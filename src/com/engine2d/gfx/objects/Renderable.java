package com.engine2d.gfx.objects;

import java.awt.Graphics;

public interface Renderable {
	
	public void render(Graphics g, double interpolation);
	
	public int getRenderPriority();
}
