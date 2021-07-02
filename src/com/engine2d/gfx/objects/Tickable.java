package com.engine2d.gfx.objects;


/**
 * Tickable interface - update
 * @author OfryBY
 *
 */
public interface Tickable {
	
	/**
	 * Tick/Update in fixed time dt
	 * @param dt fixed time to update by
	 */
	public void tick(double dt);
	
	/**
	 * Priority of tick
	 * @return returns the priority that the object needs to be ticked
	 */
	public default double getTickPriority() {
		return 0;
	}
}
