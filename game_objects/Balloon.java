package com.cactus.game_objects;

import com.badlogic.gdx.math.Vector2;
import com.cactus.main_objects.Const;

public class Balloon {

	private Vector2 position;
	private Vector2 acceleration;
	public boolean isAlive = true;

	private int radius;
	public static boolean ISUP = false;
	public static boolean ISDOWN = false;

	public Balloon(float x, float y, int radius) {

		position = new Vector2(x, y);
		this.radius = radius;
		acceleration = new Vector2(0, 0);
	}

	private void calculateAcceleration() {
		if (ISUP && ISDOWN) {
			acceleration.y = 0;
		} else {
			acceleration.y = Const.WORLD_GRAVITY;
			if (ISUP) {
				float powerReduced = this.getY() - Const.VENTILATOR_UP_Y;
				acceleration.y += Const.VENTILATOR_POWER / powerReduced;
			}
			if (ISDOWN) {
				float powerReduced = Const.VENTILATOR_DOWN_Y - this.getY();
				// BALANCE GAME PLAY GRAVITY BONUS
				acceleration.y -= acceleration.y = Const.WORLD_GRAVITY;
				acceleration.y -= Const.VENTILATOR_POWER / powerReduced;
			}
		}
		// System.out.println(acceleration.y);
	}

	public void update(float delta) {
		if(!isAlive){
			return;
		}
		this.calculateAcceleration();

		position.y = position.y + acceleration.y;

		if (position.y > Const.GAME_HEIGHT - this.getRadius() - Const.VENTILATORS_HEIGHT) {
			position.y = Const.GAME_HEIGHT - this.getRadius() - Const.VENTILATORS_HEIGHT;
		}

		if (position.y < Const.VENTILATORS_HEIGHT + Const.BALLOON_RADIUS) {
			position.y = Const.VENTILATORS_HEIGHT + Const.BALLOON_RADIUS;
		}

	}

	public float getX() {
		return position.x;
	}

	public float getY() {
		return position.y;
	}

	public int getRadius() {
		return this.radius;
	}
}
