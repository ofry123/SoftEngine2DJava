package com.engine2d.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.engine2d.gfx.Display;

/**
 * Class for keyboard listening
 * @author OfryBY
 *
 */
public class Keyboard implements KeyListener{
	
	public static final int KEY_COUNT = 256;
	
	public static enum KeyState { NONE, PRESS, DOWN, RELEASED }
	
	private KeyState[] keys;
	private boolean[] notFirstPress, notFirstRelease;
	
	/**
	 * Creates new keyboard event listener
	 */
	public Keyboard() {
		keys = new KeyState[KEY_COUNT];
		
		notFirstPress = new boolean[KEY_COUNT];
		notFirstRelease = new boolean[KEY_COUNT];
	}
	
	/**
	 * handles the input and updates data
	 */
	public void handleInput() {
		for (int i = 0; i < KEY_COUNT; i++) {
			if (keys[i] == KeyState.PRESS && !notFirstPress[i]) {
				notFirstPress[i] = true;
			} else if (keys[i] == KeyState.PRESS) {
				keys[i] = KeyState.DOWN;
			} else if (keys[i] == KeyState.RELEASED && !notFirstRelease[i]) {
				notFirstRelease[i] = true;
			} else if (keys[i] == KeyState.RELEASED) {
				keys[i] = KeyState.NONE;
				notFirstPress[i] = notFirstRelease[i] = false;
			}
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = KeyState.PRESS;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = KeyState.RELEASED;
	}
	
	/**
	 * registers the keyboard to a display
	 * @param display display to register to
	 */
	public void registerToDisplay(Display display) {
		display.addKeyListener(this);
		display.getCanvas().addKeyListener(this);
	}
	
	/**
	 * get the key state
	 * @param keycode code of key
	 * @return the state the key is in
	 */
	public KeyState getKeyState(int keycode) {
		return keys[keycode];
	}
	
	/**
	 * check if the key is pressed
	 * @param keycode code of key
	 * @return true if the key is pressed
	 */
	public boolean isPressed(int keycode) {
		return keys[keycode] == KeyState.PRESS;
	}
	
	/**
	 * check if the key is down
	 * @param keycode code of key
	 * @return true if the key is down
	 */
	public boolean isDown(int keycode) {
		return keys[keycode] == KeyState.DOWN;
	}
	
	/**
	 * check if the key is released
	 * @param keycode code of key
	 * @return true if the key is released
	 */
	public boolean isReleased(int keycode) {
		return keys[keycode] == KeyState.RELEASED;
	}

}
