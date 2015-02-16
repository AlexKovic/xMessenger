package com.experiencepvp.effects;

import de.slikey.effectlib.Effect;
import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.util.ParticleEffect;
import de.slikey.effectlib.util.RandomUtils;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class GladiatorEffect extends Effect {

	private int ran;
	private ParticleEffect effect;
	
	public GladiatorEffect(EffectManager effectManager, ParticleEffect effect) {
		super(effectManager);
		type = EffectType.INSTANT;
		period = 1;
		iterations = 600;
		this.ran = 0;
		this.effect = effect;
	}

	@Override
	public void onRun() {
		Location location = getLocation();
		for (int i = 0; i < 50; i++) {
			Vector v = RandomUtils.getRandomCircleVector().multiply(RandomUtils.random.nextDouble() * 0.6d);
			v.setY(RandomUtils.random.nextFloat() * 1.8);
			location.add(v);
			effect.display(location, visibleRange, 0, 0, 0, 0, 0);
			location.subtract(v);
		}		
	}
	
}
