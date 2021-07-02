package com.engine2d.input;

/**
 * interface for input handling
 * @author OfryBY
 *
 */
public interface InputListener {
	
	/**
	 * handles input
	 * @param input data of input
	 */
	public void handleInput(Input input);
	
	/**
	 * get the priority that the object needs to be input handled
	 * @return the input handling priority of the object
	 */
	public default int getInputPriority() {
		return 0;
	}
	
}
