package com.engine2d.gfx.objects;

import com.engine2d.utils.Vector3;

/**
 * Class to draw a circle
 * @author OfryBY
 *
 */
public class Circle extends Ellipse {
	
	/**
	 * Create a circle
	 * @param pos position of the circle
	 * @param radius radius of the circle
	 * @param isCentered is the position the center
	 */
	public Circle(Vector3 pos, double radius, boolean isCentered) {
		super(pos, radius, radius, isCentered);
	}
	
	/**
	 * Create a circle
	 * @param pos position of the circle
	 * @param radius radius of the circle
	 */
	public Circle(Vector3 pos, double radius) {
		this(pos, radius, false);
	}
	
	/**
	 * Creates a circle 
	 * @param x x-coordinate of the circle
	 * @param y y-coordinate of the circle
	 * @param z z-index of the circle (render priority)
	 * @param radius radius of the circle
	 * @param isCentered is the position the center
	 */
	public Circle(double x, double y, double z, double radius, boolean isCentered) {
		super(x, y, z, radius, radius, isCentered);
	}
	
	/**
	 * Creates a circle 
	 * @param x x-coordinate of the circle
	 * @param y y-coordinate of the circle
	 * @param radius radius of the circle
	 * @param isCentered is the position the center
	 */
	public Circle(double x, double y, double radius, boolean isCentered) {
		this(x, y, 0, radius, isCentered);
	}
	
	/**
	 * Creates a not-circled circle
	 * @param x x-coordinate of the circle
	 * @param y y-coordinate of the circle
	 * @param z z-index of the circle (render priority)
	 * @param radius radius of the circle
	 */
	public Circle(double x, double y, double z, double radius) {
		this(x, y, z, radius, false);
	}
	
	/**
	 * Creates a not-circled circle
	 * @param x x-coordinate of the circle
	 * @param y y-coordinate of the circle
	 * @param radius radius of the circle
	 */
	public Circle(double x, double y, double radius) {
		this(x, y, 0, radius, false);
	}
}