package com.engine2d.gfx.objects;

import java.awt.Graphics;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Particle system class
 * @author OfryBY
 *
 */
public class Particles implements Renderable, Tickable {
	
	/**
	 * Wrap class for a particle
	 * @author OfryBY
	 *
	 */
	public static abstract class Particle implements Renderable, Tickable {
		
		protected Particles parent;
		protected double time = 0, duration;
		
		/**
		 * Creates a basic particle
		 * @param parent particle system associated with the particle
		 * @param duration time that the particle is visible
		 */
		public Particle(Particles parent, double duration) {
			this.parent = parent;
			this.duration = duration;
			
		}
		
		/**
		 * wrap tick for particle
		 * @param dt fixed time step of engine
		 */
		public void tickWrap(double dt) {
			time += dt;
			if (time > duration)
				parent.removeParticle(this);
			tick(dt);
		}
		
	}
	
	private ArrayList<Particle> particles;
	private ArrayList<Particle> toRemove;
	
	/**
	 * Create new particle system
	 * @param amount amount of particles
	 * @param duration time (seconds) that the particles are visible
	 * @param particleClass sub class of <code>Particle</code>
	 * @param data additional data in <code>Particle</code>'s Constructor
	 */
	public Particles(int amount, double duration, Class<? extends Particle> particleClass, Object... data) {
		particles = new ArrayList<Particle>(amount);
		toRemove = new ArrayList<Particle>();
		Object[] objects;
		objects = new Object[2 + data.length];
		objects[0] = this;
		objects[1] = duration;
		for (int i = 0; i < data.length; i++)
			objects[2 + i] = data[i];
		for (int i = 0; i < amount; i++)
			for (Constructor<?> c : particleClass.getConstructors()) {
				try { 
					particles.add((Particle) c.newInstance(objects));
					break;
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | SecurityException e) {
					e.printStackTrace();
				}	
			}
	}

	@Override
	public void tick(double dt) {
		for (Particle p : particles)
			p.tickWrap(dt);
		for (Particle p : toRemove)
			particles.remove(p);
		toRemove.clear();
	}

	@Override
	public void render(Graphics g, double interpolation) {
		for (Particle p : particles)
			p.render(g, interpolation);
	}
	
	public void removeParticle(Particle particle) {
		toRemove.add(particle);
	}
	
}
