package com.engine2d.gfx.objects;

/**
 * Class to draw a polygon
 * @author OfryBY
 *
 */
public class Polygon extends Path {
	
	/**
	 * Create a polygon
	 * @param points array of points
	 * @param z z-index (render priority)
	 */
	public Polygon(Point[] points, double z) {
		super(points, z);
		addPoint(points[0]);
	}
	
	/**
	 * Create a polygon
	 * @param points array of points
	 */
	public Polygon(Point[] points) {
		this(points, 0);
	}
	
	/**
	 * Create a polygon
	 * @param points set of points
	 * @param z z-index (render priority)
	 */
	public Polygon(Iterable<Point> points, double z) {
		super(points, z);
		addPoint(points.iterator().next());
	}
	
	/**
	 * Create a polygon
	 * @param points set of points
	 */
	public Polygon(Iterable<Point> points) {
		this(points, 0);
	}

}
