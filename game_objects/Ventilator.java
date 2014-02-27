package com.cactus.game_objects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.cactus.main_objects.Const;

public class Ventilator {
	private Vector2 position;
	private int width;
	private int height;
	public long counter = 0;

	public Ventilator(float x, float y, int width, int height) {
		this.width = width;
		this.height = height;
		position = new Vector2(x, y);
	}

	public void update() {
		// System.out.println("COUNTER FOR DOWN  "+counter);
		if(counter <= 0){
			counter = 0;
		}
		
		
	}

	public float getX() {
		return position.x;
	}

	public float getY() {
		return position.y;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public boolean onClick() {
		counter = Const.VENTILATOR_RUN_TIME;
		return true;
	}

	public Vector2 getPosition() {
		return this.position;
	}

	public Rectangle getArea() {
		Rectangle rect = new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		return rect;

	}

}
