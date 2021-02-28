package fr.mygdx.game;

import com.badlogic.gdx.Game;

import fr.mygdx.game.splashscreen.Splash;

public class BLACKJACKCity extends Game {
	public static final String TITLE = "BLACKJACK City", VERSION="0.0.0.0";

	@Override
	public void create () {
		setScreen(new Splash());

	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}
	@Override
	public void resize(int weidth, int height ) {
		super.resize(weidth, height);
	}
	@Override
	public void pause() {
		super.pause();
	}
	@Override
	public void resume() {
		super.resume();
	}
}
