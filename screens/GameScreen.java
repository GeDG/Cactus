package com.cactus.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.cactus.game_world.GameRenderer;
import com.cactus.game_world.GameWorld;
import com.cactus.helpers.InputHandler;
import com.cactus.main_objects.Const;

public class GameScreen implements Screen {

	private GameWorld world;
	private GameRenderer renderer;

	// This is the constructor, not the class declaration
	public GameScreen() {

		int midPointY = (int) (Const.GAME_HEIGHT / 2);

		world = new GameWorld(midPointY);
		renderer = new GameRenderer(world);

		Gdx.input.setInputProcessor(new InputHandler(world.getVentilatorUp(), world.getVentilatorDown()));
		// Gdx.input.setInputProcessor(new
		// InputHandler(world.getVentilatorTwo()));
	}

	@Override
	public void render(float delta) {
		world.update(delta);
		renderer.render();
	}

	@Override
	public void resize(int width, int height) {
		System.out.println("GameScreen - resizing");
	}

	@Override
	public void show() {
		System.out.println("GameScreen - show called");
	}

	@Override
	public void hide() {
		System.out.println("GameScreen - hide called");
	}

	@Override
	public void pause() {
		System.out.println("GameScreen - pause called");
	}

	@Override
	public void resume() {
		System.out.println("GameScreen - resume called");
	}

	@Override
	public void dispose() {
		// Leave blank
	}

}