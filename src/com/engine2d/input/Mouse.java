package com.engine2d.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import com.engine2d.gfx.Display;
import com.engine2d.input.Keyboard.KeyState;
import com.engine2d.utils.Vector2;

/**
 * Class for mouse listening
 * @author OfryBY
 *
 */
public class Mouse implements MouseListener, MouseMotionListener, MouseWheelListener {
	
	public static final int BUTTON_COUNT = 15;
	
	public static enum MouseState { NONE, PRESS, DOWN, RELEASED }
	
	private KeyState[] buttons;
	private boolean[] notFirstPress, notFirstRelease;
	
	private Vector2 pos;
	private int mouseScroll, mouseScrollChange;
	
	private boolean mouseInDisplay;
	
	/**
	 * Create new mouse event listener
	 */
	public Mouse() {
		pos = new Vector2();
		mouseScroll = mouseScrollChange = 0;
		
		buttons = new KeyState[BUTTON_COUNT];
		
		notFirstPress = new boolean[BUTTON_COUNT];
		notFirstRelease = new boolean[BUTTON_COUNT];
	}
	
	/**
	 * handles the input and updates data
	 */
	public void handleInput() {
		for (int i = 0; i < BUTTON_COUNT; i++) {
			if (buttons[i] == KeyState.PRESS && !notFirstPress[i]) {
				notFirstPress[i] = true;
			} else if (buttons[i] == KeyState.PRESS) {
				buttons[i] = KeyState.DOWN;
			} else if (buttons[i] == KeyState.RELEASED && !notFirstRelease[i]) {
				notFirstRelease[i] = true;
			} else if (buttons[i] == KeyState.RELEASED) {
				buttons[i] = KeyState.NONE;
				notFirstPress[i] = notFirstRelease[i] = false;
			}
		}
		
		mouseScroll = mouseScrollChange;
		mouseScrollChange = 0;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		buttons[e.getButton()] = KeyState.PRESS;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		buttons[e.getButton()] = KeyState.RELEASED;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		mouseInDisplay = true;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		mouseInDisplay = false;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		mouseScrollChange += e.getWheelRotation();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		pos.setX(e.getX());
		pos.setY(e.getY());
		
	}
	
	/**
	 * registers the mouse to the display
	 * @param display the display to register to
	 */
	public void registerToDisplay(Display display) {
		display.addMouseListener(this);
		display.getCanvas().addMouseListener(this);
		display.addMouseMotionListener(this);
		display.getCanvas().addMouseMotionListener(this);
		display.addMouseWheelListener(this);
		display.getCanvas().addMouseWheelListener(this);
	}
	
	/**
	 * get the state of the mouse button
	 * @param buttoncode the mouse's button code
	 * @return the state of the button
	 */
	public KeyState getButton(int buttoncode) {
		return buttons[buttoncode];
	}
	
	/**
	 * check if the mouse's button is pressed
	 * @param buttoncode the mouse's button code
	 * @return true if the button is pressed
	 */
	public boolean isPressed(int buttoncode) {
		return buttons[buttoncode] == KeyState.PRESS;
	}
	
	/**
	 * check if the mouse's button is down
	 * @param buttoncode the mouse's button code
	 * @return true if the button is down
	 */
	public boolean isDown(int buttoncode) {
		return buttons[buttoncode] == KeyState.DOWN;
	}

	/**
	 * check if the mouse's button is released
	 * @param buttoncode the mouse's button code
	 * @return true if the button is released
	 */
	public boolean isReleased(int buttoncode) {
		return buttons[buttoncode] == KeyState.RELEASED;
	}
	
	/**
	 * get the mouse position
	 * @return the current mouse position
	 */
	public Vector2 getMousePos() {
		return new Vector2(pos);
	}
	
	/**
	 * get the amount of wheel scroll
	 * @return amount of full scrolls
	 */
	public int getWheelScroll() {
		return mouseScroll;
	}
	
	/**
	 * Check if the mouse is within the display's boundaries
	 * @return true if the mouse is in the display's boundaries
	 */
	public boolean isMouseInDisplay() {
		return mouseInDisplay;
	}

}
