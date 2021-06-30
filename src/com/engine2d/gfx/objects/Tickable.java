package com.engine2d.gfx.objects;

public interface Tickable {
	
	public void tick(double dt);
	
	public int getTickPriority();
}
