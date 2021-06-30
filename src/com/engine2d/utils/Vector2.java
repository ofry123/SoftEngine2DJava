package com.engine2d.utils;

public class Vector2 {
	
	private double x, y;
	
	public Vector2(double x, double y) {
		setPosition(x, y);
	}
	
	public Vector2() {
		this(0, 0);
	}
	
	public Vector2(Vector2 copy) {
		this(copy.x, copy.y);
	}
	
	public Vector2 add(Vector2 v) {
		return new Vector2(x + v.x, y + v.y);
	}
	
	public Vector2 sub(Vector2 v) {
		return new Vector2(x - v.x, y - v.y);
	}
	
	public Vector2 mult(double scalar) {
		return new Vector2(x * scalar, y * scalar);
	}
	
	public Vector2 normalized() {
		double magnitude = magnitude();
		return new Vector2(x / magnitude, y / magnitude);
	}
	
	public double magnitude() {
		return Math.sqrt(x * x + y * y);
	}
	
	public double dot(Vector2 v) {
		return x * v.x + y * v.y;
	}
	
	public Vector3 cross(Vector2 v) {
		return new Vector3(0, 0, x * v.y - y * v.x);
	}
	
	//Getters and Setters
	public void setPosition(double x, double y) {
		setX(x);
		setY(y);
	}
	
	public double[] getPosition() {
		return new double[] {getX(), getY()};
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getX() {
		return this.x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double getY() {
		return this.y;
	}
	
	//ToString
	@Override
	public String toString() {
		return "(" + x + ", " + y + ").";
	}
}
