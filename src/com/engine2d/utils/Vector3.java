package com.engine2d.utils;

public class Vector3 {
	
	private double x, y, z;
	
	public Vector3(double x, double y, double z) {
		setPosition(x, y, z);
	}
	
	public Vector3() {
		this(0, 0, 0);
	}
	
	public Vector3(Vector3 copy) {
		this(copy.x, copy.y, copy.z);
	}
	
	public Vector3 add(Vector3 v) {
		return new Vector3(x + v.x, y + v.y, z + v.z);
	}
	
	public Vector3 sub(Vector3 v) {
		return new Vector3(x - v.x, y - v.y, z - v.z);
	}
	
	public Vector3 mult(double scalar) {
		return new Vector3(x * scalar, y * scalar, z * scalar);
	}
	
	public Vector3 mult2(double scalar) {
		return new Vector3(x * scalar, y * scalar, z);
	}
	
	public Vector3 normalized() {
		double magnitude = magnitude();
		return new Vector3(x / magnitude, y / magnitude, z / magnitude);
	}
	
	public Vector3 normalized2() {
		double magnitude2 = magnitude2();
		return new Vector3(x / magnitude2, y / magnitude2, z);
	}
	
	public double magnitude() {
		return Math.sqrt(x * x + y * y + z * z);
	}
	
	public double magnitude2() {
		return Math.sqrt(x * x + y * y);
	}
	
	public double dot3(Vector3 v) {
		return x * v.x + y * v.y + z * v.z;
	}
	
	public double dot2(Vector3 v) {
		return x * v.x + y * v.y;
	}
	
	public Vector3 cross3(Vector3 v) {
		return new Vector3(y * v.z - z * v.y, z * v.x - x * v.z, x * v.y - y * v.x);
	}
	
	public Vector3 cross2(Vector3 v) {
		return (new Vector3(x, y, 0)).cross3(new Vector3(v.x, v.y, 0));
	}
	
	//Getters and Setters
	public void setPosition(double x, double y, double z) {
		setX(x);
		setY(y);
		setZ(z);
	}
	
	public double[] getPosition() {
		return new double[] {getX(), getY(), getZ()};
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
	
	public void setZ(double z) {
		this.z = z;
	}
	
	public double getZ() {
		return this.z;
	}
	
	
	//ToString
		@Override
		public String toString() {
			return "(" + x + ", " + y + ", " + z + ").";
		}
	
	
}
