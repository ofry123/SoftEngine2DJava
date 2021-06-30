package com.engine2d.gfx.objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import com.engine2d.utils.Vector3;

public class Line implements Renderable {
	
	protected double z;
	protected Vector3 p1, p2;
	
	protected Color color;
	protected float thickness;
	
	public Line(Vector3 p1, Vector3 p2, double z) {
		setPoints(p1, p2, z);
	}
	
	public Line(Vector3 p1, Vector3 p2) {
		this(p1, p2, 0);
	}
	
	public Line(double x1, double y1, double x2, double y2, double z) {
		setPoints(x1, y1, x2, y2, z);
	}
	
	public Line(double x1, double y1, double x2, double y2) {
		this(x1, y1, x2, y2, 0);
	}
	
	@Override
	public void render(Graphics g, double interpolation) {
		final Graphics2D gfx = (Graphics2D) g.create();
		
		gfx.setColor(color);
		gfx.setStroke(new BasicStroke(thickness));
		
		gfx.draw(new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY()));
		
		gfx.dispose();
	}

	@Override
	public int getRenderPriority() {
		return (int)z;
	}
	
	//Getters and Setters
	//Point 1
	public void setPoint1(Vector3 p1) {
		this.p1 = new Vector3(p1);
	}
	
	public void setPoint1(double x, double y) {
		this.p1 = new Vector3(x, y, 0);
	}
	
	//Point 2
	public void setPoint2(Vector3 p2) {
		this.p2 = new Vector3(p2);
	}
	
	public void setPoint2(double x, double y) {
		this.p2 = new Vector3(x, y, 0);
	}
	
	//Points
	public void setPoints(Vector3 p1, Vector3 p2) {
		setPoint1(p1);
		setPoint2(p2);
	}
	
	public void setPoints(Vector3 p1, Vector3 p2, double z) {
		setPoints(p1, p2);
		this.z = z;
	}
	
	public void setPoints(double x1, double y1, double x2, double y2) {
		setPoint1(x1, y1);
		setPoint2(x2, y2);
	}
	
	public void setPoints(double x1, double y1, double x2, double y2, double z) {
		setPoints(x1, y1, x2, y2);
		this.z = z;
	}
	
	public Vector3 getPoint1() {
		return new Vector3(p1);
	}
	
	public Vector3 getPoint2() {
		return new Vector3(p2);
	}
	
	public Vector3[] getPoints() {
		return new Vector3[] { getPoint1(), getPoint2() };
	}
	
	//Z index
	public void setZIndex(double z) {
		this.z = z;
	}
	
	public double getZIndex() {
		return this.z;
	}
	
	//Color
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setColor(int color) {
		setColor(new Color(color));
	}
	
	public Color getColor() {
		return this.color;
	}
	
	//Thickness
	public void setThickness(float thickness) {
		this.thickness = thickness;
	}
	
	public float getThickness() {
		return this.thickness;
	}
	
	
	
	
	
}
