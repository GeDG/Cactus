package com.cactus.game;

import com.badlogic.gdx.Game;
import com.cactus.screens.GameScreen;

public class CactusGame extends Game {

	
	@Override
	public void create() {
		System.out.println("CactusGM Created!");
		this.setScreen(new GameScreen());
	}
}
