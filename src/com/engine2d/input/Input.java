package com.engine2d.input;

import com.engine2d.gfx.Display;

/**
 * Class to handle input from mouse and keyboard
 * @author OfryBY
 *
 */
public class Input {
	
	private Keyboard keyboard;
	private Mouse mouse;
	
	/**
	 * Creates new input handler
	 */
	public Input() {
		keyboard = new Keyboard();
		mouse = new Mouse();
	}
	
	/**
	 * registers mouse and keyboard listeners to the display to retrieve data
	 * @param display the display to register to
	 */
	public void registerToDisplay(Display display) {
		keyboard.registerToDisplay(display);
		mouse.registerToDisplay(display);
	}
	
	/**
	 * handles and updates the frame's current data state
	 */
	public void handleInput() {
		keyboard.handleInput();
		mouse.handleInput();
	}
	
	/**
	 * get the keyboard data
	 * @return keyboard data
	 */
	public Keyboard getKeyboard() {
		return this.keyboard;
	}
	
	/**
	 * get the mouse data
	 * @return mouse data
	 */
	public Mouse getMouse() {
		return this.mouse;
	}
}
