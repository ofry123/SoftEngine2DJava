package com.engine2d.gfx.objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import com.engine2d.utils.Vector3;

public class Point implements Renderable {
	
	protected Vector3 pos;
	protected float thickness = 1;
	protected Color color = Color.BLACK;
	
	public Point(Vector3 pos) {
		setPos(pos);
	}
	
	public Point(double x, double y, double z) {
		setPos(x, y, z);
	}
	
	public Point(double x, double y) {
		this(x, y, 0);
	}
	
	public Point() {
		this(0, 0, 0);
	}
	
	@Override
	public void render(Graphics g, double interpolation) {
		final Graphics2D gfx = (Graphics2D) g.create();
		
		gfx.setStroke(new BasicStroke(thickness));
		gfx.setColor(color);
		
		gfx.draw(new Line2D.Double(pos.getX(), pos.getY(), pos.getX(), pos.getY()));
		
		gfx.dispose();
	}
	
	public Vector3 getPos() {
		return new Vector3(pos);
	}
	
	public void setPos(Vector3 pos) {
		this.pos = new Vector3(pos);
	}
	
	public void setPos(double x, double y) {
		setPos(x, y, pos.getZ());
	}
	
	public void setPos(double x, double y, double z) {
		this.pos = new Vector3(x, y, z);
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setColor(int color) {
		setColor(new Color(color));
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void setThickness(float thickness) {
		this.thickness = thickness;
	}
	
	public float getThickness() {
		return this.thickness;
	}
	
	@Override
	public int getRenderPriority() {
		return (int) pos.getZ();
	}
	
}
