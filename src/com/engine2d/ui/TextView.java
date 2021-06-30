package com.engine2d.ui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.TextLayout;

import com.engine2d.gfx.objects.Rectangle;
import com.engine2d.utils.Vector3;

public class TextView extends UIObject {
	
	private String text;
	
	public TextView(String text, Vector3 pos, double width, double height) {
		super(pos, width, height);
		setText(text);
	}

	@Override
	public void render(Graphics g, double interpolation) {
		final Graphics2D gfx = (Graphics2D) g.create();
		
		gfx.setFont(scaleFont(text, gfx));
		gfx.drawString(text, (int)pos.getX(), (int)(pos.getY() + height));
		
		
		gfx.dispose();
	}
	public Font scaleFont(String text, Graphics g) {

		  final var font = g.getFont();
		  final var frc = ((Graphics2D) g).getFontRenderContext();

		  final var dstWidthPx = width;
		  final var dstHeightPx = height;

		  var minSizePt = 1f;
		  var maxSizePt = 1000f;
		  var scaledFont = font;
		  float scaledPt = scaledFont.getSize();

		  while( maxSizePt - minSizePt > 1f ) {
		    scaledFont = scaledFont.deriveFont( scaledPt );

		    final var layout = new TextLayout( text, scaledFont, frc );
		    final var fontWidthPx = layout.getVisibleAdvance();

		    final var metrics = scaledFont.getLineMetrics( text, frc );
		    final var fontHeightPx = metrics.getHeight();

		    if( (fontWidthPx > dstWidthPx) || (fontHeightPx > dstHeightPx) ) {
		      maxSizePt = scaledPt;
		    }
		    else {
		      minSizePt = scaledPt;
		    }

		    scaledPt = (minSizePt + maxSizePt) / 2;
		  }

		  return scaledFont.deriveFont( (float) Math.floor( scaledPt ) );
		}
	
	
	
	public void setText(String text) {
		this.text = new String(text);
	}
	
	public String getText() {
		return new String(text);
	}


	
}
