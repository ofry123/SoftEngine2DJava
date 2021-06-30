package com.engine2d.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import com.engine2d.gfx.objects.Rectangle;
import com.engine2d.gfx.objects.Tickable;
import com.engine2d.input.Input;
import com.engine2d.input.InputListener;
import com.engine2d.utils.Collision;
import com.engine2d.utils.Vector2;
import com.engine2d.utils.Vector3;

public class TextButton extends UIObject implements InputListener {
	
	private static final int DEFAULT_COLOR = 0xd7dadd,
							 DEFAULT_HOVER_COLOR = 0x7a8793,
							 DEFAULT_DOWN_COLOR = 0xd71b2c,
							 DEFAULT_CLICK_COLOR = 0x1dae51;
	
	private String text;
	
	private boolean hovering, down, clicked;
	private Clickable clickEvent;
	
	private Rectangle background;
	
	public TextButton(String text, Vector3 pos, double width, double height) {
		super(pos, width, height);
		setText(text);
		
		background = new Rectangle(pos, width, height);
		background.setFill(true, true);
		background.setFillColor(DEFAULT_COLOR);
		background.setThickness(2);
	}


	@Override
	public void handleInput(Input input) {
		hovering = isHovering(input.getMouse().getMousePos());
		down = input.getMouse().isDown(MouseEvent.BUTTON1);
		clicked = input.getMouse().isReleased(MouseEvent.BUTTON1);
		
		if (hovering) {
			if (down)
				background.setFillColor(DEFAULT_DOWN_COLOR);
			else if (clicked)
				background.setFillColor(DEFAULT_CLICK_COLOR);
			else
				background.setFillColor(DEFAULT_HOVER_COLOR);
		} else
			background.setFillColor(DEFAULT_COLOR);
		
		if (hovering && clicked && clickEvent != null)
			clickEvent.click(this, input.getMouse());
	}
	
	@Override
	public void render(Graphics g, double interpolation) {
		final Graphics2D gfx = (Graphics2D) g.create();
		
		background.render(g, interpolation);
		
		
		
		gfx.dispose();
	}
	
	protected boolean isHovering(Vector2 mousePos) {
		return Collision.pointInRect(mousePos, pos, width, height);
	}
	
	
	public void setText(String text) {
		this.text = new String(text);
	}
	
	public String getText() {
		return new String(text);
	}
	
	public void setClick(Clickable clickEvent) {
		this.clickEvent = clickEvent;
	}
	
}
