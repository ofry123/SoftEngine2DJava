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
	
	public Engine(String title, int width, int height) {
		display = new Display(title, width, height);
		engineHandler = new EngineHandler(this);
		input = new Input();
	}
	
	protected void init() {}
	protected void handleInput() {}
	protected void handleInput(Input input) {}
	protected void tick() {}
	protected void tick(double dt) {}
	protected void render() {}
	protected void render(Graphics g, double interpolation) {}
	
	private void initEngine() {
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
		
		
		input.registerToDisplay(display);
		
		init();
	}
	
	private void handleEngineInput() {
		input.handleInput();
		
		handleInput();
		while (!inputList.isEmpty())
			inputList.poll().handleInput(input);
		inputList.clear();
		handleInput(input);
	}
	
	protected void handleInput(InputListener obj) {
		inputList.add(obj);
	}
	
	private void tickEngine(double dt) {		
		tick();
		while (!tickList.isEmpty())
			tickList.poll().tick(dt);
		tickList.clear();
		tick(dt);
	}
	
	protected void tick(Tickable obj) {
		tickList.add(obj);
	}
	
	private void renderEngine(double interpolation) {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(2);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, engineHandler.getWidth(), engineHandler.getHeight());		
		
		render();
		while (!renderList.isEmpty())
			renderList.poll().render(g, interpolation);
		renderList.clear();
		render(g, interpolation);
		
		bs.show();
		g.dispose();
	}
	
	protected void render(Renderable obj) {
		renderList.add(obj);
	}
	
	public void run() {	
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
	
	public synchronized void start() {
		if (running)
			return;
		running = true;
		engineThread = new Thread(this);
		engineThread.start();
	}
	
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
