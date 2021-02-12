package fr.mygdx.game.splashscreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MainMenu implements Screen {

	private Stage stage;
	private Table table;
	private TextButton buttonPlay, buttonExit;
	private Label heading;
	private Skin skin;
	private BitmapFont White, Black;
	private TextureAtlas atlas;
	
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		//white = new BitmapFont(Gdx.files.internal("../../../../../../desktop/bin/main/font/white.fnt"), false);
		//black = new BitmapFont(Gdx.files.internal("../../../../../../desktop/bin/main/font/black.fnt"), false);

	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
