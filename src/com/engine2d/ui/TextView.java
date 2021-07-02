package com.engine2d.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import com.engine2d.gfx.objects.Rectangle;
import com.engine2d.utils.Vector3;

public class TextView extends UIObject {
	
	protected Rectangle background;
	private String text;
	private boolean centered;
	
	public TextView(String text, Vector3 pos, double width, double height) {
		super(pos, width, height);
		setText(text);
		
		background = new Rectangle(pos, width, height);
		background.setThickness(2);
	}

	@Override
	public void render(Graphics g, double interpolation) {
		final Graphics2D gfx = (Graphics2D) g.create();
		
		background.render(gfx, interpolation);
		
		if (centered) {
			String visibleText = getCenteredVisibleText(gfx, width, height);
			int textHeight = g.getFontMetrics().getHeight();
			int offset = (int)(height / 2 + textHeight / 2);
			for (String s : visibleText.split("\n")) {
				int textX = (int)(pos.getX() + width / 2 - g.getFontMetrics().stringWidth(s) / 2);
				int textY = (int)(pos.getY() + offset);
				gfx.drawString(s, textX, textY);
				offset += textHeight;
			}
			
		} else {
			String visibleText = getVisibleText(gfx, width, height);
			int textHeight = g.getFontMetrics().getHeight();
			int offset = textHeight;
			for (String s : visibleText.split("\n")) {
				int textX = (int)pos.getX();
				int textY = (int)(pos.getY() + offset);
				gfx.drawString(s, textX, textY);
				offset += textHeight;
			}
		}
		gfx.dispose();
	}
	
	public String getVisibleText(Graphics g, double width, double height) {		
		final var matric = g.getFontMetrics();
		ArrayList<String> lines = new ArrayList<String>();
		
		String currentLine = "";
		int textHeight = matric.getHeight();
		for (char c : text.toCharArray()) {
			if (textHeight > height)
				break;
			if (c == '\n' || matric.stringWidth(currentLine + c) > width) {
				int lastSpace = currentLine.lastIndexOf(" ");
				String lastWord = "";
				if (c != '\n' && lastSpace != -1) {
					lastWord = currentLine.substring(lastSpace);
					currentLine = currentLine.substring(0, lastSpace);
				} 
				lines.add(currentLine);
				currentLine = new String("");
				currentLine += lastWord;
				textHeight += matric.getHeight();
			} 
			currentLine += c == '\n' ? "" : c;
		}
		
		String visibleText = "";
		for (String s : lines)
			visibleText += s + "\n";
		if (textHeight < height)
			visibleText += currentLine;
		return visibleText;
	}

	public String getCenteredVisibleText(Graphics g, double width, double height) {
		return getVisibleText(g, width, height / 2 + g.getFontMetrics().getHeight() / 2);
	}
	
	public void setText(String text) {
		this.text = new String(text);
	}
	
	public String getText() {
		return new String(text);
	}
	
	public void setCentered(boolean centered) {
		this.centered = centered;
	}
	
	public boolean isCentered() {
		return centered;
	}
}
