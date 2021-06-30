package com.engine2d.testing;

import com.engine2d.engine.Engine;
import com.engine2d.gfx.objects.Circle;
import com.engine2d.gfx.objects.Ellipse;
import com.engine2d.input.Input;

public class Test {
	
	static class Game extends Engine {
		
		Circle c;
		Ellipse e;
		
		public Game(String title, int width, int height) {
			super(title, width, height);
			
			c = new Circle(50, 50, 50);
			c.setFill(true);
			
			e = new Ellipse(50, 200, 200, 100);
			e.setFill(true);
		}
		
		@Override
		protected void init() {
		}
		
		@Override
		protected void handleInput(Input input) {
			
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
