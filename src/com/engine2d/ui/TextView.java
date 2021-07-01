package com.engine2d.ui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.LinkedList;

import com.engine2d.gfx.objects.Rectangle;
import com.engine2d.utils.Vector3;

public class TextView extends UIObject {
	
	private String text;
	private String visibleText;
	
	public TextView(String text, Vector3 pos, double width, double height) {
		super(pos, width, height);
		setText(text);
		
		
	}

	@Override
	public void render(Graphics g, double interpolation) {
		final Graphics2D gfx = (Graphics2D) g.create();
		
		visibleText = "";
		
		LinkedList<StringBuilder> lines = new LinkedList<StringBuilder>();
		float height = 0, lineHeight = 0;
		var fm = gfx.getFontMetrics();
		for (String word : text.split("")) {
			String line = lines.isEmpty() ? "" : lines.getLast() + word;
			Rectangle2D bounds = fm.getStringBounds(line, gfx);
			lineHeight = (float) Math.max(lineHeight, bounds.getHeight());
			if (height + lineHeight > this.height)
				break;
			
			if (bounds.getWidth() > this.width)
				if (height + fm.getStringBounds(word, gfx).getHeight() > this.height)
					break;
				else
					lines.add(new StringBuilder(word));
			else
				if (lines.isEmpty())
					lines.add(new StringBuilder(word));
				else
					lines.getLast().append(word);
		}
		
		for (StringBuilder sb : lines)
			visibleText += sb.toString() + "\n";
		visibleText = visibleText.stripTrailing();
		
		gfx.drawString(visibleText, (int)pos.getX(), (int)pos.getY());
		
		gfx.dispose();
	}
	
	public void setText(String text) {
		this.text = new String(text);
	}
	
	public String getText() {
		return new String(text);
	}


	
}
