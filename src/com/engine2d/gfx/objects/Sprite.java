package com.engine2d.gfx.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import com.engine2d.utils.Vector3;

/**
 * Class to draw a sprite (image)
 * @author OfryBY
 *
 */
public class Sprite implements Renderable {
	
	
	protected Vector3 pos;
	protected double width, height;
	
	protected BufferedImage image;
	
	/**
	 * Creates a sprite
	 * @param image image of the sprite
	 * @param pos position of the sprite
	 * @param width width of the sprite
	 * @param height height of the sprite
	 */
	public Sprite(BufferedImage image, Vector3 pos, double width, double height) {
		setImage(image);
		setPos(pos);
		setSize(width, height);
	}
	
	/**
	 * Creates an empty sprite
	 * @param pos position of the sprite
	 * @param width width of the sprite
	 * @param height height of the sprite
	 */
	public Sprite(Vector3 pos, double width, double height) {
		setImage(image);
		setPos(pos);
		setSize(width, height);
	}
	
	/**
	 * Creates a sprite with the image's size (not null)
	 * @param image image of sprite
	 * @param pos position of sprite
	 */
	public Sprite(BufferedImage image, Vector3 pos) {
		this(image, pos, image.getWidth(), image.getHeight());
	}
	
	/**
	 * Creates a sprite
	 * @param image image of sprite 
	 * @param x x-coordinate of sprite
	 * @param y y-coordinate of sprite
	 * @param z z-index (render priority)
	 * @param width width of sprite
	 * @param height height of sprite
	 */
	public Sprite(BufferedImage image, double x, double y, double z, double width, double height) {
		setImage(image);
		setPos(x, y, z);
		setSize(width, height);
	}
	
	/**
	 * Creates an empty sprite
	 * @param x x-coordinate of sprite
	 * @param y y-coordinate of sprite
	 * @param z z-index (render priority)
	 * @param width width of sprite
	 * @param height height of sprite
	 */
	public Sprite(double x, double y, double z, double width, double height) {
		this(null, x, y, z, width, height);
	}
	
	/**
	 * Creates a sprite with the image's size
	 * @param image image of sprite (not null)
	 * @param x x-coordinate of sprite
	 * @param y y-coordinate of sprite
	 * @param z z-index (render priority)
	 */
	public Sprite(BufferedImage image, double x, double y, double z) {
		this(image, x, y, z, image.getWidth(), image.getHeight());
	}
	
	/**
	 * Creates a sprite
	 * @param image image of sprite
	 * @param x x-coordinate of sprite
	 * @param y y-coordinate of sprite
	 * @param width width of sprite
	 * @param height height of sprite
	 */
	public Sprite(BufferedImage image, double x, double y, double width, double height) {
		this(image, x, y, 0, width, height);
	}
	
	/**
	 * Create an empty sprite
	 * @param x x-coordinate of sprite
	 * @param y y-coordinate of sprite
	 * @param width width of sprite
	 * @param height height of sprite
	 */
	public Sprite(double x, double y, double width, double height) {
		this(null, x, y, width, height);
	}
	
	/**
	 * Creates a sprite with the image's size
	 * @param image image of sprite (not null)
	 * @param x x-coordinate of sprite
	 * @param y y-coordinate of sprite
	 */
	public Sprite(BufferedImage image, double x, double y) {
		this(image, x, y, 0, image.getWidth(), image.getHeight());
	}
	
	@Override
	public void render(Graphics g, double interpolation) {
		if (image == null)
			return;
		final Graphics2D gfx = (Graphics2D) g.create();
		
		AffineTransform t = new AffineTransform();
		t.translate(pos.getX(), pos.getY());
		t.scale(width / getImageWidth(), height / getImageHeight());
		gfx.drawImage(image, t, null);
		
		gfx.dispose();
	}

	@Override
	public double getRenderPriority() {
		return pos.getZ();
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
	
	//Image
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public int getPixelColor(int x, int y) {
		return image.getRGB(x, y);
	}
	
	public void setPixelColor(int x, int y, int color) {
		image.setRGB(x, y, color);
	}
	
	public void setPixelColor(int x, int y, Color color) {
		setPixelColor(x, y, color.getRGB());
	}
	
	public int getImageWidth() {
		return image.getWidth();
	}
	
	public int getImageHeight() {
		return image.getHeight();
	}
	
	//Size
	public void setSize(double width, double height) {
		setWidth(width);
		setHeight(height);
	}
	
	public void fitSize() {
		setSize(getImageWidth(), getImageHeight());
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
	
	
	
	
}
