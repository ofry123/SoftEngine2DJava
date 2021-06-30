package com.engine2d.ui;

import com.engine2d.gfx.objects.Renderable;
import com.engine2d.utils.Vector2;
import com.engine2d.utils.Vector3;

public abstract class UIObject implements Renderable {
	
	protected Vector3 pos;
	protected double width, height;
	
	public UIObject(Vector3 pos, double width, double height) {
		setPos(pos);
		setSize(width, height);
	}
	
	public UIObject(double x, double y, double z, double width, double height) {
		setPos(x, y, z);
		setSize(width, height);
	}
	
	public UIObject(double x, double y, double width, double height) {
		this(x, y, 0, width, height);
	}
	
	@Override
	public int getRenderPriority() {
		return (int)pos.getZ();
	}
	
	
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
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public void setSize(double width, double height) {
		setWidth(width);
		setHeight(height);
	}
	
	public Vector2 getSize() {
		return new Vector2(width, height);
	}
	
}
