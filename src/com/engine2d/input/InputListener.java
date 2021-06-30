package com.engine2d.input;

public interface InputListener {
	
	public void handleInput(Input input);
	
	public default int getInputPriority() {
		return 0;
	}
	
}
