package com.experiencepvp.effects;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import de.slikey.effectlib.Effect;
import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.util.ParticleEffect;
import de.slikey.effectlib.util.RandomUtils;

public class PhantomEffect extends Effect {

	private ParticleEffect effect;
	
	public PhantomEffect(EffectManager effectManager, ParticleEffect effect) {
		super(effectManager);
		type = EffectType.REPEATING;
		period = 1;
		iterations = 1200;
		this.effect = effect;
	}

	@Override
	public void onRun() {
		Location location = getLocation();
		for (int i = 0; i < 100; i++) {
			Vector v = RandomUtils.getRandomCircleVector().multiply(RandomUtils.random.nextDouble() * 0.6d);
			v.setY(RandomUtils.random.nextFloat() * 1.8);
			location.add(v);
			effect.display(location, visibleRange, 0, 0, 0, 0, 0);
			location.subtract(v);
		}		
	}
	
	
}
