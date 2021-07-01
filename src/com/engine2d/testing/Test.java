package com.engine2d.testing;

import com.engine2d.engine.Engine;
import com.engine2d.gfx.objects.Circle;
import com.engine2d.gfx.objects.Ellipse;
import com.engine2d.input.Input;
import com.engine2d.input.Mouse;
import com.engine2d.ui.Clickable;
import com.engine2d.ui.TextButton;
import com.engine2d.ui.TextView;
import com.engine2d.utils.Vector3;

public class Test {
	
	static class Game extends Engine {
		
		TextView b;
		
		public Game(String title, int width, int height) {
			super(title, width, height);
			
			b = new TextView("Ofry lalal la ll al la lal l lal l ll ", new Vector3(20, 20, 0), 200, 50);
		}
		
		@Override
		protected void init() {
		}
		
		@Override
		protected void handleInput() {
			//handleInput(b);
		}
		
		@Override
		protected void tick() {
		}
		
		@Override
		protected void render() {
			render(b);
		}
		
		
	}
	
	public static void main(String[] args) {
		
		Game g = new Game("Ofry", 640, 640);
		g.start();
		
	}
	
	
}
