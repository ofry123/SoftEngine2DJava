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
	
	//AABB
	public static boolean rectVsRect(double x1, double y1, double width1, double height1,
									 double x2, double y2, double width2, double height2) {
		return x1 < x2 + width2 &&
			   x1 + width1 > x2 &&
			   y1 < y2 + height2 &&
			   y1 + height1 > y2;
	}
	
	public static boolean rectVsRect(Vector2 rect1Pos, Vector2 rect1Size, Vector2 rect2Pos, Vector2 rect2Size) {
		return rectVsRect(rect1Pos.getX(), rect1Pos.getY(), rect1Size.getX(), rect1Size.getY(),
						  rect2Pos.getX(), rect2Pos.getY(), rect2Size.getX(), rect2Size.getY());
	}
	
	public static boolean rectVsRect(Vector3 rect1Pos, Vector3 rect1Size, Vector3 rect2Pos, Vector3 rect2Size) {
		return rectVsRect(rect1Pos.getX(), rect1Pos.getY(), rect1Size.getX(), rect1Size.getY(),
						  rect2Pos.getX(), rect2Pos.getY(), rect2Size.getX(), rect2Size.getY());
	}
	
	public static boolean rectVsRect(Vector3 rect1Pos, Vector2 rect1Size, Vector3 rect2Pos, Vector2 rect2Size) {
		return rectVsRect(rect1Pos.getX(), rect1Pos.getY(), rect1Size.getX(), rect1Size.getY(),
						  rect2Pos.getX(), rect2Pos.getY(), rect2Size.getX(), rect2Size.getY());
	}
	
	public static boolean rectVsRect(Vector3 rect1Pos, double width1 , double height1,
									 Vector3 rect2Pos, double width2, double height2) {
		return rectVsRect(rect1Pos.getX(), rect1Pos.getY(), width1, height1,
						  rect2Pos.getX(), rect2Pos.getY(), width2, height2);
	}
	
	//Circles
	public static boolean circleVsCircle(Vector2 c1, double r1, Vector2 c2, double r2) {
		return (c1.sub(c2)).magnitude() < r1 + r2;
	}
	
	public static boolean circleVsCircle(double x1, double y1, double r1,
										 double x2, double y2, double r2) {
		return circleVsCircle(new Vector2(x1, y1), r1, new Vector2(x2, y2), r2);
	}
	
	
	
	
	
}
