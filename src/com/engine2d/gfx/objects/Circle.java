package com.engine2d.gfx.objects;

import com.engine2d.utils.Vector3;

public class Circle extends Ellipse {
	
	
	public Circle(Vector3 pos, double radius, boolean isCentered) {
		super(pos, radius, radius, isCentered);
	}
	
	public Circle(Vector3 pos, double radius) {
		this(pos, radius, false);
	}
	
	public Circle(double x, double y, double z, double radius, boolean isCentered) {
		super(x, y, z, radius, radius, isCentered);
	}
	
	public Circle(double x, double y, double radius, boolean isCentered) {
		this(x, y, 0, radius, isCentered);
	}
	
	public Circle(double x, double y, double z, double radius) {
		this(x, y, z, radius, false);
	}
	
	public Circle(double x, double y, double radius) {
		this(x, y, 0, radius, false);
	}
}