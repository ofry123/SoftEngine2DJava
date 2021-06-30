package com.engine2d.gfx;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display extends JFrame {
	
	private static final long serialVersionUID = 8179112726510960534L;
	
	private int width, height;
	
	private Canvas canvas;
	
	public Display(String title, int width, int height) {
		super(title);
		
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
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
	
	public Canvas getCanvas() { return this.canvas; }
	public int getCanvasWidth() { return this.width; }
	public int getCanvasHeight() { return this.height; }
	

}
