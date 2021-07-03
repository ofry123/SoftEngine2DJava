package com.engine2d.gfx.objects;

import java.awt.Graphics;
import java.util.ArrayList;

public class Animation implements Renderable, Tickable {
	
	public static class AnimationData {
		
		private Renderable renderObj;
		private double duration;
		
		public AnimationData(Renderable renderObj, double duration) {
			setRenderObj(renderObj);
			setDuration(duration);
		}
		
		public void setRenderObj(Renderable renderObj) {
			this.renderObj = renderObj;
		}
		
		public Renderable getRenderObj() {
			return renderObj;
		}
		
		public void setDuration(double duration) {
			this.duration = duration;
		}
		
		public double getDuration() {
			return duration;
		}
		
	}
	
	private double time = 0;
	private int currentIndex = 0;
	
	private ArrayList<AnimationData> animation;;
	
	public Animation(AnimationData[] animation) {
		setAnimation(animation);
	}
	
	public Animation(Iterable<AnimationData> animation) {
		setAnimation(animation);
	}

	@Override
	public void tick(double dt) {
		time += dt;
		double currentDuration;
		while (time > (currentDuration = animation.get(currentIndex).duration)) {
			time -= currentDuration;
			currentIndex++;
			currentIndex %= animation.size();
		}
	}

	@Override
	public void render(Graphics g, double interpolation) {
		animation.get(currentIndex).renderObj.render(g, interpolation);
	}
	
	//Getters and Setters
	public void setAnimation(AnimationData[] animation) {
		this.animation = new ArrayList<AnimationData>();
		for (AnimationData data : animation)
			this.animation.add(data);
	}
	
	public void setAnimation(Iterable<AnimationData> animation) {
		this.animation = new ArrayList<AnimationData>();
		for (AnimationData data : animation)
			this.animation.add(data);
	}
	
	public void addAnimation(int index, AnimationData data) {
		animation.add(index, data);
	}
	
	public void addAnimation(AnimationData data) {
		animation.add(data);
	}
	
	public AnimationData getAnimation(int index) {
		return animation.get(index);
	}
	
	public AnimationData removeAnimation(int index) {
		return animation.remove(index);
	}
	
	
}
