package com.cactus.game_objects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.cactus.main_objects.Const;

public class Cactus {
	private Vector2 position;
	private Vector2 acceleration = new Vector2(3, 0);

	private int width;
	private int height;
	private boolean reachedEndOfScreen = false;

	public Rectangle getAreaDown() {
		Rectangle rect = new Rectangle(this.position.x, this.position.y, this.width, this.height);
		return rect;
	}

	public Rectangle getAreaUp() {
		float x = this.position.x;
		;
		float y = 0;
		int width = 20;
		int h = (int) (Const.GAME_HEIGHT - this.height);
		int height = (int) (Const.GAME_HEIGHT - h - Const.HOLE);
		return new Rectangle(x, y, width, height);
	}

	public Cactus() {
		this.reset();
	}

	public Cactus(float x) {
		this.position = new Vector2(x, Const.GAME_HEIGHT);
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public Vector2 getPosition() {
		return this.position;
	}

	public void update(int chance) {
		if (this.getPosition().x <= -15) {
			this.reachedEndOfScreen = true;
			this.reset();
		} else if (!reachedEndOfScreen) {
			this.getPosition().x -= this.acceleration.x;
		}
	}

	public void reset() {
		this.reachedEndOfScreen = false;
		this.width = 20;
		this.height = (int) (Const.GAME_HEIGHT) - (int) (Math.random() * 200 + 10);
		int num = (int) (Const.GAME_WIDTH - this.position.x);
		this.position = new Vector2(Const.GAME_WIDTH + num, this.height);
		int h = (int) (Const.GAME_HEIGHT - this.height);
		System.out.println("height   " + h);
	}

	public void didIKillHim(Balloon b) {
		Vector2 tmp = new Vector2(b.getX() + Const.BALLOON_RADIUS, b.getY());
			if(this.getAreaUp().contains(tmp) || this.getAreaDown().contains(tmp)){
				b.isAlive = false;
			}
	}
}
