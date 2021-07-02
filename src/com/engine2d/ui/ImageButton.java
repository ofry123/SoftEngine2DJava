package com.engine2d.ui;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import com.engine2d.input.Input;
import com.engine2d.input.InputListener;
import com.engine2d.utils.Collision;
import com.engine2d.utils.Vector2;

public class ImageButton extends Image implements InputListener
{
	
	private BufferedImage defaultImage, hoveringImage, downImage, clickImage;

	private boolean hovering, down, clicked;
	private Clickable clickEvent;
	
	public ImageButton(double x, double y, double width, double height) {
		super(x, y, width, height);
	}

	@Override
	public void handleInput(Input input) {
		hovering = isHovering(input.getMouse().getMousePos());
		down = input.getMouse().isDown(MouseEvent.BUTTON1);
		clicked = input.getMouse().isReleased(MouseEvent.BUTTON1);
		
		if (hovering) {
			if (down)
				sprite.setImage(downImage);
			else if (clicked)
				sprite.setImage(clickImage);
			else
				sprite.setImage(hoveringImage);
		} else
			sprite.setImage(defaultImage);
		
		if (hovering && clicked && clickEvent != null)
			clickEvent.click(this, input.getMouse());
	}
	
	protected boolean isHovering(Vector2 mousePos) {
		return Collision.pointInRect(mousePos, pos, width, height);
	}
	
	public void setClick(Clickable clickEvent) {
		this.clickEvent = clickEvent;
	}
	
	public void setDefaultImage(BufferedImage image) {
		this.defaultImage = image;
	}
	
	public void setHoveringImage(BufferedImage image) {
		this.hoveringImage = image;
	}
	
	public void setDownImage(BufferedImage image) {
		this.downImage = image;
	}
	
	public void setClickImage(BufferedImage image) {
		this.clickImage = image;
	}
	
	public void setImages(BufferedImage defaultImage, BufferedImage hoveringImage, BufferedImage downImage, BufferedImage clickImage) {
		setDefaultImage(defaultImage);
		setHoveringImage(hoveringImage);
		setDownImage(downImage);
		setClickImage(clickImage);
	}
	
}
