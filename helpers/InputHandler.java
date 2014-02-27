package com.cactus.helpers;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.cactus.game_objects.Balloon;
import com.cactus.game_objects.Ventilator;

public class InputHandler implements InputProcessor {

	private Ventilator ventilatorOne;
	private Ventilator ventilatorTwo;

	public InputHandler(Ventilator ventilatorOne, Ventilator ventilatorTwo) {

		this.ventilatorOne = ventilatorOne;
		this.ventilatorTwo = ventilatorTwo;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		Vector2 vector = new Vector2(screenX, screenY);

		if (this.ventilatorOne.getArea().contains(vector)) {
			Balloon.ISUP=true;
			return this.ventilatorOne.onClick();
			
		}
		if (this.ventilatorTwo.getArea().contains(vector)) {
			Balloon.ISDOWN=true;
			return this.ventilatorTwo.onClick();
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
