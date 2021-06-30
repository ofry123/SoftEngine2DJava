package com.engine2d.utils;

public class Collision {
	
	//Point-Rectangle collision
	public static boolean pointInRect(double pointX, double pointY, double rectX, double rectY, double rectWidth, double rectHeight) {
		return pointX >= rectX && pointX <= rectX + rectWidth //X
				&& pointY >= rectY && pointY <= rectY + rectHeight; //Y
	}
	
	public static boolean pointInRect(Vector2 point, Vector2 rectPos, Vector2 rectSize) {
		return pointInRect(point.getX(), point.getY(), rectPos.getX(), rectPos.getY(), rectSize.getX(), rectSize.getY());
	}
	
	public static boolean pointInRect(double pointX, double pointY, Vector2 rectPos, Vector2 rectSize) {
		return pointInRect(pointX, pointY, rectPos.getX(), rectPos.getY(), rectSize.getX(), rectSize.getY());
	}
	
	public static boolean pointInRect(Vector2 point, double rectX, double rectY, double rectWidth, double rectHeight) {
		return pointInRect(point.getX(), point.getY(), rectX, rectY, rectWidth, rectHeight);
	}
	
	public static boolean pointInRect(Vector2 point, Vector3 rectPos, double rectWidth, double rectHeight) {
		return pointInRect(point.getX(), point.getY(), rectPos.getX(), rectPos.getY(), rectWidth, rectHeight);
	}
	
	public static boolean pointInRect(Vector3 point, double rectX, double rectY, double rectWidth, double rectHeight) {
		return pointInRect(point.getX(), point.getY(), rectX, rectY, rectWidth, rectHeight);
	}
	
}
