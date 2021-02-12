package fr.mygdx.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.mygdx.game.splashscreen.Splash;

public class ProjetL2AN1 extends Game {
	//SpriteBatch batch;
	//Texture img;
	public static final String TITTLE = "BLACKJACK City", VERSION="0.0.0.0";
	
	@Override
	public void create () {
		setScreen(new Splash());
		
		//batch = new SpriteBatch();
		//img = new Texture("Blackjack.jpg");
	}

	@Override
	public void render () {
		super.render();
		/*Gdx.gl.glClearColor(2, 2, 2, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();*/
	}
	
	@Override
	public void dispose () {
		super.dispose();
		//batch.dispose();
		//img.dispose();
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
