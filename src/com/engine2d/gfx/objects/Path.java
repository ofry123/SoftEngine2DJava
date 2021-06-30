package com.engine2d.gfx.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.engine2d.utils.Vector3;

public class Path implements Renderable {
	
	protected double z;
	protected ArrayList<Point> points;
	
	protected float pointThickness = 1, edgeThickness = 1;
	protected Color pointColor = Color.BLACK, edgeColor = Color.BLACK;
	
	
	public Path(Point[] points, double z) {
		this.points = new ArrayList<Point>();
		for (int i = 0; i < points.length; i++)
			this.points.add(new Point(points[i].getPos().getX(), points[i].getPos().getY(), z));
		
	}
	
	
	@Override
	public void render(Graphics g, double interpolation) {
		for (int i = 1; i < points.size(); i++) {
			Line l = new Line(points.get(i - 1).getPos(), points.get(i).getPos());
			l.setColor(edgeColor);
			l.setThickness(edgeThickness);
			
			
			l.render(g, interpolation);
		}
		
		for (int i = 0; i < points.size(); i++) {
			points.get(i).setThickness(pointThickness);
			points.get(i).setColor(pointColor);
			
			points.get(i).render(g, interpolation);	
		}
	}

	@Override
	public int getRenderPriority() {
		return (int)z;
	}
	
	//Getters and Setters
	public void setPointPos(int index, Vector3 pos) {
		points.get(index).setPos(pos);
	}
	
	public void setPointPos(int index, double x, double y) {
		points.get(index).setPos(x, y);
	}
	
	public Vector3 getPointPos(int index) {
		return new Vector3(points.get(index).getPos().getX(), points.get(index).getPos().getY(), z);
	}
	
	public void addPoint(Point point) {
		points.add(new Point(point.getPos().getX(), point.getPos().getY(), z));
	}
	
	public void setZIndex(double z) {
		this.z = z;
	}
	
	public double getZIndex() {
		return this.z;
	}
	
	public void setPointThickness(float thickness) {
		this.pointThickness = thickness;
	}
	
	public float getPointThickness() {
		return this.pointThickness;
	}
	
	public void setEdgeThickness(float thickness) {
		this.edgeThickness = thickness;
	}
	
	public float getEdgeThickness() {
		return this.edgeThickness;
	}
	
	//Color
		public void setPointColor(Color color) {
			this.pointColor = color;
		}
		
		public void setPointColor(int color) {
			setPointColor(new Color(color));
		}
		
		public Color getPointColor() {
			return this.pointColor;
		}
		
		public void setEdgeColor(Color color) {
			this.edgeColor = color;
		}
		
		public void setEdgeColor(int color) {
			setEdgeColor(new Color(color));
		}
		
		public Color getEdgeColor() {
			return this.edgeColor;
		}

}
