package com.cactus.game_world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.cactus.game_objects.Cactus;
import com.cactus.main_objects.Const;

public class GameRenderer {
	private GameWorld myWorld;
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;

	public GameRenderer(GameWorld myWorld) {
		this.myWorld = myWorld;
		cam = new OrthographicCamera();
		cam.setToOrtho(true, 300, Const.GAME_HEIGHT);
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
	}

	public void render() {

		/*
		 * 1. We draw a black background. This prevents flickering.
		 */

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		/*
		 * 2. We draw the Filled rectangle
		 */

		// Tells shapeRenderer to begin drawing filled shapes
		shapeRenderer.begin(ShapeType.Filled);

		// Chooses RGB Color of 87, 109, 120 at full opacity
		shapeRenderer.setColor(87 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1);

		// Draws the rectangle from myWorld (Using ShapeType.Filled)
		shapeRenderer.circle(myWorld.getBalloon().getX(), myWorld.getBalloon().getY(),
				myWorld.getBalloon().getRadius());

		for (Cactus c : myWorld.getCactuses()) {
			shapeRenderer.rect(c.getAreaDown().x, c.getAreaDown().y, c.getAreaDown().width, c.getAreaDown().height);
			shapeRenderer.rect(c.getAreaUp().x, c.getAreaUp().y, c.getAreaUp().width, c.getAreaUp().height);
		}

		shapeRenderer.rect(myWorld.getVentilatorUp().getPosition().x, myWorld.getVentilatorUp().getPosition().y, 50, 10);

		shapeRenderer
				.rect(myWorld.getVentilatorDown().getPosition().x, myWorld.getVentilatorDown().getPosition().y, 50, 10);
		// Tells the shapeRenderer to finish rendering
		// We MUST do this every time.
		shapeRenderer.end();

	}
}
