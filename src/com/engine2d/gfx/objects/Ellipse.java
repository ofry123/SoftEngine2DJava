package com.engine2d.gfx.objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import com.engine2d.utils.Vector2;
import com.engine2d.utils.Vector3;

public class Ellipse implements Renderable {
	
	protected Vector3 pos;
	protected double width, height;
	protected boolean centered;
	
	protected boolean fill = false, stroke = false;
	protected Color strokeColor = Color.BLACK, fillColor = Color.BLACK;
	protected float thickness = 1;
	
	public Ellipse(Vector3 pos, double width, double height, boolean isCentered) {
		setPos(pos);
		setSize(width, height);
		setCentered(isCentered);
	}
	
	public Ellipse(Vector3 pos, double width, double height) {
		this(pos, width, height, false);
	}
	
	public Ellipse(double x, double y, double z, double width, double height, boolean isCentered) {
		setPos(x, y, z);
		setSize(width, height);
		setCentered(isCentered);
	}
	
	public Ellipse(double x, double y, double width, double height, boolean isCentered) {
		this(x, y, 0, width, height, isCentered);
	}
	
	public Ellipse(double x, double y, double z, double width, double height) {
		this(x, y, z, width, height, false);
	}
	
	public Ellipse(double x, double y, double width, double height) {
		this(x, y, 0, width, height, false);
	}
	
	@Override
	public void render(Graphics g, double interpolation) {
		final Graphics2D gfx = (Graphics2D) g.create();
		
		double x = centered ? pos.getX() - width / 2 : pos.getX();
		double y = centered ? pos.getY() - height / 2 : pos.getY();
		
		if (fill) {
			gfx.setColor(fillColor);
			gfx.fill(new Ellipse2D.Double(x, y, width, height));
			
			if (stroke) {
				gfx.setStroke(new BasicStroke(thickness));
				gfx.setColor(strokeColor);
				gfx.draw(new Ellipse2D.Double(x, y, width, height));
			}
		
		} else {
			gfx.setColor(strokeColor);
			gfx.setStroke(new BasicStroke(thickness));
			
			gfx.draw(new Ellipse2D.Double(x, y, width, height));
		}
		
		gfx.dispose();
	}

	@Override
	public int getRenderPriority() {
		return (int)pos.getZ();
	}
	
	//Getters and Setters
	//Position
	public void setPos(Vector3 pos) {
		this.pos = new Vector3(pos);
	}
	
	public void setPos(double x, double y, double z) {
		this.pos = new Vector3(x, y, z);
	}
	
	public void setPos(double x, double y) {
		setPos(x, y, 0);
	}
	
	public Vector3 getPos() {
		return new Vector3(pos);
	}
	
	//size
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setSize(double width, double height) {
		setWidth(width);
		setHeight(height);
	}
	
	public Vector2 getRadius() {
		return new Vector2(getWidth(), getHeight());
	}
	
	//Center
	public void setCentered(boolean isCentered) {
		this.centered = isCentered;
	}
	
	public boolean isCentered() {
		return this.centered;
	}
	
	//Color
	public void setFillColor(Color color) {
		this.fillColor = color;
	}
	
	public void setFillColor(int color) {
		setFillColor(new Color(color));
	}
	
	public Color getFillColor() {
		return this.fillColor;
	}
	
	public void setStrokeColor(Color color) {
		this.strokeColor = color;
	}
	
	public void setStrokeColor(int color) {
		setStrokeColor(new Color(color));
	}
	
	public Color getStrokeColor() {
		return this.strokeColor;
	}
	
	public void setFill(boolean isFill, boolean isStroke) {
		this.fill = isFill;
		this.stroke = isStroke;
	}
	
	public void setFill(boolean isFill) {
		setFill(isFill, false);
	}
	
	//Thickness
	public void setThickness(float thickness) {
		this.thickness = thickness;
	}
	
	public float getThickness() {
		return this.thickness;
	}
	
}
