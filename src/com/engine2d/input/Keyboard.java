package com.engine2d.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.engine2d.gfx.Display;

public class Keyboard implements KeyListener{
	
	public static final int KEY_COUNT = 256;
	
	public static enum KeyState { NONE, PRESS, DOWN, RELEASED }
	
	private KeyState[] keys;
	private boolean[] notFirstPress, notFirstRelease;
	
	public Keyboard() {
		keys = new KeyState[KEY_COUNT];
		
		notFirstPress = new boolean[KEY_COUNT];
		notFirstRelease = new boolean[KEY_COUNT];
	}
	
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
	
	public void registerToDisplay(Display display) {
		display.addKeyListener(this);
		display.getCanvas().addKeyListener(this);
	}
	
	public KeyState getKeyState(int keycode) {
		return keys[keycode];
	}
	
	public boolean isPressed(int keycode) {
		return keys[keycode] == KeyState.PRESS;
	}
	
	public boolean isDown(int keycode) {
		return keys[keycode] == KeyState.DOWN;
	}
	
	public boolean isReleased(int keycode) {
		return keys[keycode] == KeyState.RELEASED;
	}

}
