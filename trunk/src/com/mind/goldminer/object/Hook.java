package com.mind.goldminer.object;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Hook {
	private Sprite		hook;
	
	private final float	MAXANGLE = (float) (3.14*2.0/5.0);
	private final float	SPEED = 0.1f;
	
	private float			curAngle;
	private float			speed;
	
	public Hook(Sprite hook) {
		this.hook = hook;
		curAngle = 0.0f;
		speed = SPEED;
	}
	
	public void update() {
		if (curAngle >= MAXANGLE) {
			speed = -SPEED;
		} else if (curAngle <= -MAXANGLE){
			speed = SPEED;
		}
		
		curAngle += speed;
	}
	
	public void draw(SpriteBatch spriteBatch) {
		hook.rotate(curAngle);
		hook.setPosition(400, 20);
		hook.draw(spriteBatch);
	}
}
