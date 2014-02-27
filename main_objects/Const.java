package com.cactus.main_objects;

import com.badlogic.gdx.Gdx;

public final class Const {
	// Hard-coded constants

	public final static float BALLOON_X = 33;
	public final static int BALLOON_RADIUS = 10;
	public final static long VENTILATOR_COOLDOWN = 1000;
	public final static long VENTILATOR_RUN_TIME = 200;
	public final static int VENTILATOR_POWER = 300;
	public final static float VENTILATORS_X = 16;
	public final static float VENTILATOR_UP_Y = 0;
	public final static int VENTILATORS_WIDTH = 50;
	public final static int VENTILATORS_HEIGHT = 10;
	public final static float CAMERA_WIDTH = 300;
	public final static float WORLD_GRAVITY = 0.5f;
	public final static int HOLE = 50;
	// Run-time determined constants
	public final static float SCREEN_WIDTH = Gdx.graphics.getWidth();
	public final static float SCREEN_HEIGHT = Gdx.graphics.getHeight();

	// Dynamically generated constants
	public final static float GAME_WIDTH = SCREEN_WIDTH;
	public final static float GAME_HEIGHT = SCREEN_HEIGHT / (SCREEN_WIDTH / GAME_WIDTH);
	public final static float VENTILATOR_DOWN_Y = SCREEN_HEIGHT - VENTILATORS_HEIGHT;

}
