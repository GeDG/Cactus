package com.cactus.game_world;

import com.cactus.game_objects.Balloon;
import com.cactus.game_objects.Cactus;
import com.cactus.game_objects.Ventilator;
import com.cactus.main_objects.Const;

public class GameWorld {

	String[] gameStates = { "RUNING", "GAMEOVER" };
	String gameState;
	private Balloon balloon;
	private Ventilator ventilatorUp;
	private Ventilator ventilatorDown;
	private Cactus[] cactuses = new Cactus[3];

	public GameWorld(int midPointY) {
		this.gameState = this.gameStates[0];
		balloon = new Balloon(Const.BALLOON_X, midPointY - 5, Const.BALLOON_RADIUS);
		ventilatorUp = new Ventilator(Const.VENTILATORS_X, Const.VENTILATOR_UP_Y, Const.VENTILATORS_WIDTH,
				Const.VENTILATORS_HEIGHT);
		ventilatorDown = new Ventilator(Const.VENTILATORS_X, Const.VENTILATOR_DOWN_Y, Const.VENTILATORS_WIDTH,
				Const.VENTILATORS_HEIGHT);
		float x = 200;
		for (int i = 0; i <= 2; i++) {
			cactuses[i] = new Cactus(x);
			x += 200;
		}

	}

	public void update(float delta) {
		if (gameState.equals("RUNING")) {
			balloon.update(delta);
			ventilatorUp.update();
			ventilatorDown.update();
			int chance = (int) (Math.random() * 25);
			for (Cactus c : cactuses) {
				c.update(chance);
				c.didIKillHim(balloon);
			}
		}

		if (ventilatorUp.counter <= 0) {
			Balloon.ISUP = false;
		}

		if (ventilatorDown.counter <= 0) {
			Balloon.ISDOWN = false;
		}

		if (Balloon.ISUP) {
			ventilatorUp.counter--;
		}
		if (Balloon.ISDOWN) {
			ventilatorDown.counter--;
		}
	}

	public Balloon getBalloon() {
		return balloon;
	}

	public Ventilator getVentilatorUp() {
		return ventilatorUp;
	}

	public Ventilator getVentilatorDown() {
		return ventilatorDown;
	}

	public Cactus[] getCactuses() {
		return this.cactuses;
	}

}
