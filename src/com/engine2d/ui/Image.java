package com.engine2d.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.engine2d.gfx.objects.Sprite;
import com.engine2d.utils.Vector3;

/**
 * Class representing an UI image
 * @author OfryBY
 *
 */
public class Image extends UIObject {
	
	protected Sprite sprite;
	
	public Image(BufferedImage image, Vector3 pos, double width, double height) {
		super(pos, width, height);
		
		sprite = new Sprite(image, pos, width, height);
	}
	
	public Image(BufferedImage image, double x, double y, double z, double width, double height) {
		super(x, y, z, width, height);
		
		sprite = new Sprite(image, x, y, z, width, height);
	}
	
	public Image(BufferedImage image, double x, double y, double width, double height) {
		this(image, x, y, 0, width, height);
	}
	
	public Image(Vector3 pos, double width, double height) {
		this(null, pos, width, height);
	}
	
	public Image(double x, double y, double z, double width, double height) {
		this(null, x, y, z, width, height);
	}
	
	public Image(double x, double y, double width, double height) {
		this(null, x, y, 0, width, height);
	}

	@Override
	public void render(Graphics g, double interpolation) {
		sprite.render(g, interpolation);
	}
	
	public void setImage(BufferedImage image) {
		sprite.setImage(image);
	}
	
}
