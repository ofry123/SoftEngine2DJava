package com.engine2d.engine;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Comparator;
import java.util.PriorityQueue;

import com.engine2d.gfx.Display;
import com.engine2d.gfx.objects.Renderable;
import com.engine2d.gfx.objects.Tickable;
import com.engine2d.input.Input;
import com.engine2d.input.InputListener;

/**
 * Engine class used as a wrap for another class to render tick and handle input easily
 * @author OfryBY
 *
 */
public abstract class Engine implements Runnable {
	
	Display display;
	protected EngineHandler engineHandler;
	
	private Graphics g;
	private BufferStrategy bs; 
	
	private boolean running;
	protected Thread engineThread;
	
	private PriorityQueue<Tickable> tickList;
	private PriorityQueue<Renderable> renderList;
	private PriorityQueue<InputListener> inputList;
	
	private Input input;
	
	/**
	 * Creates new engine with title and size
	 * @param title Title of engine
	 * @param width Width of window
	 * @param height Height of window
	 */
	public Engine(String title, int width, int height) {
		display = new Display(title, width, height);
		engineHandler = new EngineHandler(this);
		input = new Input();
	}
	
	/**
	 * initializes engine - override use
	 */
	protected void init() {}
	/**
	 * handles the input - override use
	 */
	protected void handleInput() {}
	/**
	 * handles the input - override use
	 * @param input data about input
	 */
	protected void handleInput(Input input) {}
	/**
	 * tick - override use
	 */
	protected void tick() {}
	/**
	 * fixed tick with dt - override use
	 * @param dt the time from last tick
	 */
	protected void tick(double dt) {}
	/**
	 * render - override use
	 */
	protected void render() {}
	/**
	 * render using graphics and interpolation
	 * @param g graphics to draw to
	 * @param interpolation approximated time into the frame
	 */
	protected void render(Graphics g, double interpolation) {}
	
	/**
	 * Initializes the engine
	 */
	private void initEngine() {
		//Set comparing functions for priority queues
		tickList = new PriorityQueue<Tickable>(new Comparator<Tickable>() {

			@Override
			public int compare(Tickable o1, Tickable o2) {
				return o1.getTickPriority() > o2.getTickPriority() ? 1 : -1;
			}
			
		});
		renderList = new PriorityQueue<Renderable>(new Comparator<Renderable>() {

			@Override
			public int compare(Renderable o1, Renderable o2) {
				return o1.getRenderPriority() > o2.getRenderPriority() ? 1 : -1;
			}
			
		});
		inputList = new PriorityQueue<InputListener>(new Comparator<InputListener>() {

			@Override
			public int compare(InputListener o1, InputListener o2) {
				return o1.getInputPriority() > o2.getInputPriority() ? 1 : -1;
			}
			
			
		});
		
		//registers the input to the display to collect listeners data
		input.registerToDisplay(display);
		
		//initialize engine (overridden)
		init();
	}
	
	/**
	 * handles the engine input
	 */
	private void handleEngineInput() {
		//handles input in the input class, updates all variables and such
		input.handleInput();
		
		//handles input (overridden)
		handleInput();
		//handle input for all listeners by priority
		while (!inputList.isEmpty())
			inputList.poll().handleInput(input);
		inputList.clear();
		
		//custom input handling (overridden)
		handleInput(input);
	}
	
	/**
	 * adds an input listener to queue
	 * @param obj input listener to add
	 */
	protected void handleInput(InputListener obj) {
		inputList.add(obj);
	}
	
	/**
	 * ticks the engine by dt time
	 * @param dt
	 */
	private void tickEngine(double dt) {
		//tick (overridden)
		tick();
		//ticks objects by priority
		while (!tickList.isEmpty())
			tickList.poll().tick(dt);
		tickList.clear();
		
		//custom tick (overridden)
		tick(dt);
	}
	
	/**
	 * adds a tickable object to queue
	 * @param obj tickable object to add
	 */
	protected void tick(Tickable obj) {
		tickList.add(obj);
	}
	
	/**
	 * renders the engine with approximated interpolation between frames
	 * @param interpolation approximated interpolation between frames
	 */
	private void renderEngine(double interpolation) {
		//Check for buffer strategies and create if needed
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(2);
			return;
		}
		//get graphics
		g = bs.getDrawGraphics();
		
		//Clear screen
		g.clearRect(0, 0, engineHandler.getWidth(), engineHandler.getHeight());		
		
		//render (overridden)
		render();
		//renders object by priority
		while (!renderList.isEmpty())
			renderList.poll().render(g, interpolation);
		renderList.clear();
		
		//custom tick (overridden)
		render(g, interpolation);
		
		//flips bs
		bs.show();
		g.dispose();
	}
	
	/**
	 * adds renderable object to the queue
	 * @param obj renderable object to add the the queue
	 */
	protected void render(Renderable obj) {
		renderList.add(obj);
	}
	
	/**
	 * Runs the engine
	 */
	public void run() {
		//time between ticks
		double dt = 0.01;
		
		double currentTime = System.nanoTime() / 1000000000.0;
		double accumulator = 0.0;
		
		initEngine();
		
		while (running) {
			double newTime = System.nanoTime() / 1000000000.0;
			double frameTime = newTime - currentTime;
			if (frameTime > 0.25)
				frameTime = 0.25;
			currentTime = newTime;

			accumulator += frameTime;

			while (accumulator >= dt) {
				handleEngineInput();
				tickEngine(dt);

				accumulator -= dt;
			}

			final double interpolation = accumulator;
			renderEngine(interpolation);
		}
		
		stop();
	}
	
	/**
	 * Starts the engine
	 */
	public synchronized void start() {
		if (running)
			return;
		running = true;
		engineThread = new Thread(this);
		engineThread.start();
	}
	
	/**
	 * Stops the engine
	 */
	public synchronized void stop() {
		if (!running)
			return;
		try {
			engineThread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
