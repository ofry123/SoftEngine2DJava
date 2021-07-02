package com.engine2d.gfx.objects;

import java.awt.Graphics;

/**
 * Renderable interface - draw
 * @author OfryBY
 *
 */
public interface Renderable {
	
	/**
	 * Renders the object
	 * @param g graphics to draw to
	 * @param interpolation approximated time between frame
	 */
	public void render(Graphics g, double interpolation);
	
	/**
	 * get the priority that the object needs to be rendered with
	 * @return the render priority of the object
	 */
	public default double getRenderPriority() {
		return 0;
	}
}
