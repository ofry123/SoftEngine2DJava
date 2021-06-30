package com.engine2d.input;

import com.engine2d.gfx.Display;

public class Input {
	
	private Keyboard keyboard;
	private Mouse mouse;
	
	public Input() {
		keyboard = new Keyboard();
		mouse = new Mouse();
	}
	
	public void registerToDisplay(Display display) {
		keyboard.registerToDisplay(display);
		mouse.registerToDisplay(display);
	}
	
	public void handleInput() {
		keyboard.handleInput();
		mouse.handleInput();
	}
	
	public Keyboard getKeyboard() {
		return this.keyboard;
	}
	
	public Mouse getMouse() {
		return this.mouse;
	}
}
