package com.engine2d.utils;

public class Pair<F, S> {
	
	private F first;
	private S second;
	
	public Pair(F first, S second) {
		this.first = first;
		this.second = second;		
	}
	
	public Pair() {
		this.first = null;
		this.second = null;
	}
	
	public void setFirst(F first) {
		this.first = first;
	}
	
	public F getFirst() {
		return first;
	}

	public void setSecond(S second) {
		this.second = second;
	}
	
	public S getSocend() {
		return second;
	}
}
