package com.engine2d.engine;

/**
 * class to connect the engine data with the user
 * @author OfryBY
 *
 */
public class EngineHandler {
	
	//engine associated to handler
	private Engine engine;
	
	/**
	 * Creates new handler with associated engine
	 * @param engine associated engine for handler
	 */
	public EngineHandler(Engine engine) {
		this.engine = engine;
	}
	
	/**
	 * get the window's width
	 * @return the window's width
	 */
	public int getWidth() { 
		return engine.display.getCanvasWidth(); 
	}
	
	/**
	 * get the window's height
	 * @return the window's height
	 */
	public int getHeight() {
		return engine.display.getCanvasHeight();
	}
	
	/**
	 * Set the window's title
	 * @param title title to set to
	 */
	public void setTitle(String title) {
		engine.display.setTitle(title);
	}
	
}
