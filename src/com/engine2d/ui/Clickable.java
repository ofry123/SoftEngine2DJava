package com.engine2d.ui;

import com.engine2d.input.Mouse;

/**
 * interface for clickable object
 * @author OfryBY
 *
 */
public interface Clickable {
	
	/**
	 * Click action
	 * @param sender object that sent the request
	 * @param mouse mouse data while clicking
	 */
	public void click(Object sender, Mouse mouse);
	
	
}
