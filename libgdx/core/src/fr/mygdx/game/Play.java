package fr.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import fr.mygdx.game.splashscreen.MainMenu;

public class Play implements Screen {

	private Stage stage;
	private Table table, tablePlay;
	private TextButton buttonBack, buttonSingle, buttonDuo, buttonTrio, buttonQuadra;
	private Texture Background;
	private Skin skin;
	private BitmapFont black, white;
	private TextureAtlas atlas;
	private SpriteBatch batch;
	private Sound pressbutton;
	private Music music;

	@Override
	public void show() {
		batch = new SpriteBatch();
		Background = new Texture("Background.png");
		atlas = new TextureAtlas("ui/button.pack");
		skin = new Skin(atlas);
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tablePlay = new Table(skin);
		tablePlay.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		black = new BitmapFont(Gdx.files.internal("font/black.fnt"), false);
		white = new BitmapFont(Gdx.files.internal("font/white.fnt"), false);
		pressbutton = Gdx.audio.newSound(Gdx.files.internal("pressbutton.mp3"));
		music = Gdx.audio.newMusic(Gdx.files.internal("Playmusic.mp3"));

		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.getDrawable("button.up");
		textButtonStyle.down = skin.getDrawable("button.down");
		textButtonStyle.pressedOffsetX = 1;
		textButtonStyle.pressedOffsetY = -1;
		textButtonStyle.font = black;

		music.setLooping(true);
		music.setVolume(Options.VOLUME);
		music.play();


		buttonBack = new TextButton("Back", textButtonStyle);
		buttonBack.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
				pressbutton.play();
				music.dispose();
			}
		});
		buttonBack.pad(15f, 40f, 15f, 40f);
		
		buttonSingle = new TextButton("SinglePlayer", textButtonStyle);
		buttonSingle.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener()).setScreen(new SinglePlayer());
				pressbutton.play();
				music.dispose();
			}
		});
		buttonSingle.pad(15f, 40f, 15f, 40f);
		
		buttonDuo = new TextButton("DuoPlayers", textButtonStyle);
		buttonDuo.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener()).setScreen(new DuoPlayers());
				pressbutton.play();
				music.dispose();
			}
		});
		buttonDuo.pad(15f, 40f, 15f, 40f);
		
		buttonTrio = new TextButton("TrioPlayers", textButtonStyle);
		buttonTrio.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener()).setScreen(new TrioPlayers());
				pressbutton.play();
				music.dispose();
			}
		});
		buttonTrio.pad(15f, 40f, 15f, 40f);
		
		buttonQuadra = new TextButton("QuadraPlayers", textButtonStyle);
		buttonQuadra.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener()).setScreen(new QuadraPlayers());
				pressbutton.play();
				music.dispose();
			}
		});
		buttonQuadra.pad(15f, 40f, 15f, 40f);
		
		table.setPosition(1700f, 150f, 0);
		table.add(buttonBack);
		table.getCell(buttonBack).spaceBottom(35f);
		table.row();
		
		tablePlay.setPosition(1500f, 500f, 0);
		tablePlay.add(buttonSingle);
		tablePlay.getCell(buttonSingle).spaceBottom(20f);
		tablePlay.row();
		tablePlay.add(buttonDuo);
		tablePlay.getCell(buttonDuo).spaceBottom(20f);
		tablePlay.row();
		tablePlay.add(buttonTrio);
		tablePlay.getCell(buttonTrio).spaceBottom(20f);
		tablePlay.row();
		tablePlay.add(buttonQuadra);
		tablePlay.getCell(buttonQuadra).spaceBottom(20f);
		tablePlay.row();
		
		stage.addActor(table);
		stage.addActor(tablePlay);
		}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(2, 2, 2, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.draw(Background,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();
		
		stage.act(delta);
		stage.draw();
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
