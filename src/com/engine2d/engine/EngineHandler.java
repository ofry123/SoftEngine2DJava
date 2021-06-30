package com.engine2d.engine;

public class EngineHandler {
	
	private Engine engine;
	
	public EngineHandler(Engine engine) {
		this.engine = engine;
	}
	
	public int getWidth() { 
		return engine.display.getCanvasWidth(); 
	}
	
	public int getHeight() {
		return engine.display.getCanvasHeight();
	}
	
	public void setTitle(String title) {
		engine.display.setTitle(title);
	}
	
}
