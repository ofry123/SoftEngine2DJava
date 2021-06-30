package com.engine2d.gfx.objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import com.engine2d.utils.Vector3;

public class Rectangle implements Renderable {
	
	protected Vector3 pos;
	protected double width, height;
	
	protected boolean fill = false, stroke = false;
	protected Color strokeColor = Color.BLACK, fillColor = Color.BLACK;
	protected float thickness = 1;
	
	public Rectangle(Vector3 pos, double width, double height) {
		setPos(pos);
		setSize(width, height);
	}
	
	public Rectangle(double x, double y, double z, double width, double height) {
		setPos(x, y, z);
		setSize(width, height);
	}
	
	public Rectangle(double x, double y, double width, double height) {
		this(x, y, 0, width, height);
	}
	
	@Override
	public void render(Graphics g, double interpolation) {
		final Graphics2D gfx = (Graphics2D) g.create();
		
		if (fill) {
			gfx.setColor(fillColor);
			gfx.fill(new Rectangle2D.Double(pos.getX(), pos.getY(), width, height));
			
			if (stroke) {
				gfx.setStroke(new BasicStroke(thickness));
				gfx.setColor(strokeColor);
				gfx.draw(new Rectangle2D.Double(pos.getX(), pos.getY(), width, height));
			}
		
		} else {
			gfx.setColor(strokeColor);
			gfx.setStroke(new BasicStroke(thickness));
			
			gfx.draw(new Rectangle2D.Double(pos.getX(), pos.getY(), width, height));
		}
		
		gfx.dispose();
	}

	@Override
	public int getRenderPriority() {
		return (int) this.pos.getZ();
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
		
		//Size
		public void setSize(double width, double height) {
			setWidth(width);
			setHeight(height);
		}
		
		//Width
		public void setWidth(double width) {
			this.width = width;
		}
		
		public double getWidth() {
			return this.width;
		}
		
		//Height
		public void setHeight(double height) {
			this.height = height;
		}
		
		public double getHeight() {
			return this.height;
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
