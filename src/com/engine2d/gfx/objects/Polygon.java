package com.engine2d.gfx.objects;

public class Polygon extends Path {
	
	public Polygon(Point[] points, double z) {
		super(points, z);
		addPoint(points[0]);
	}

}
