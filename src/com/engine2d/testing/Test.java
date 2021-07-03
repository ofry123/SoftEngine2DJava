package com.engine2d.testing;

import com.engine2d.engine.Engine;

public class Test {
	
	public static class Game extends Engine {
		
		public Game(String title, int width, int height) {
			super(title, width, height);
			
		}
		
		@Override
		protected void tick() {
			
			
		}
		
		@Override
		protected void render() {
			
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		Game g = new Game("Ofry", 640, 640);
		g.start();
	}
}
