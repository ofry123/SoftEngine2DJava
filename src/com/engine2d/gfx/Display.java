package com.engine2d.gfx;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Display class used for handling basic jframe with a canvas to draw to
 * @author OfryBY
 *
 */
public class Display extends JFrame {
	
	private static final long serialVersionUID = 8179112726510960534L;
	
	//Size of canvas
	private int width, height;
	
	private Canvas canvas;
	
	/**
	 * Creates new display
	 * @param title title of display
	 * @param width width of the drawing area
	 * @param height height of the drawing area
	 */
	public Display(String title, int width, int height) {
		super(title);
		
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	/**
	 * Create the display from properties
	 */
	private void createDisplay() {
		//initialize window
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setFocusable(true);
		
		//initialize canvas
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		//add canvas to window
		add(canvas);
		
		pack();
	}
	
	/**
	 * get the canvas in the window
	 * @return the canvas in the window
	 */
	public Canvas getCanvas() { 
		return this.canvas; 
	}
	
	/**
	 * get the width of the canvas
	 * @return the width of the canvas
	 */
	public int getCanvasWidth() { 
		return this.width; 
	}
	
	/**
	 * get the height of the canvas
	 * @return the height of the canvas
	 */
	public int getCanvasHeight() { 
		return this.height; 
	}
	

}
