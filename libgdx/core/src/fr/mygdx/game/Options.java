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
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import fr.mygdx.game.splashscreen.MainMenu;

public class Options implements Screen {

	private Stage stage;
	private Table table, tableFullscreen, tableVolume, tableAudio;
	private TextButton buttonBack, buttonFullscreenOn, buttonFullscreenOff, buttonVolume25, buttonVolume50, buttonVolume75, buttonVolume100, buttonVolume0, buttonAudio;
	private Texture Background;
	private Skin skin;
	private BitmapFont black, white;
	private TextureAtlas atlas;
	private SpriteBatch batch;
	private Music music;
	private Music pressbutton;
	private  BLACKJACKCity parent;
	
	
	public Options(BLACKJACKCity box2dTutorial){
		parent = box2dTutorial;
	}
	
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
		tableFullscreen = new Table(skin);
		tableFullscreen.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableVolume = new Table(skin);
		tableVolume.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableAudio = new Table(skin);
		tableAudio.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		black = new BitmapFont(Gdx.files.internal("font/black.fnt"), false);
		white = new BitmapFont(Gdx.files.internal("font/white.fnt"), false);
		music = Gdx.audio.newMusic(Gdx.files.internal("Optionmusic.mp3"));
		pressbutton = Gdx.audio.newMusic(Gdx.files.internal("pressbutton.mp3"));
	
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.getDrawable("button.up");
		textButtonStyle.down = skin.getDrawable("button.down");
		textButtonStyle.pressedOffsetX = 1;
		textButtonStyle.pressedOffsetY = -1;
		textButtonStyle.font = black;
		
		music.setLooping(true);
		music.setVolume(AppPreferences.MVOLUME);
		music.play();
		pressbutton.setVolume(AppPreferences.SVOLUME);
		
		
		buttonBack = new TextButton("Back", textButtonStyle);
		buttonBack.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				parent.changeScreen(BLACKJACKCity.MAINMENU);
				pressbutton.play();
				music.dispose();
			}
		});
		buttonBack.pad(15f, 40f, 15f, 40f);
		buttonFullscreenOn = new TextButton("Fullscreen On", textButtonStyle);
		buttonFullscreenOff = new TextButton("Fullscreen Off", textButtonStyle);
		buttonFullscreenOn.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
				tableFullscreen.removeActor(buttonFullscreenOn);
				tableFullscreen.add(buttonFullscreenOff);
				tableFullscreen.getCell(buttonFullscreenOff).spaceBottom(20f);
				Gdx.graphics.setWindowedMode(1920, 1080);
			}
		});
		buttonFullscreenOff.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
				tableFullscreen.removeActor(buttonFullscreenOff);
				tableFullscreen.add(buttonFullscreenOn);
				tableFullscreen.getCell(buttonFullscreenOn).spaceBottom(20f);
				Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
			}
		});
		buttonFullscreenOn.pad(15f, 41f, 15f, 41f);
		buttonFullscreenOff.pad(15f, 41f, 15f, 41f);
		buttonVolume25 = new TextButton("Volume 25%", textButtonStyle);
		buttonVolume50 = new TextButton("Volume 50%", textButtonStyle);
		buttonVolume75 = new TextButton("Volume 75%", textButtonStyle);
		buttonVolume100 = new TextButton("Volume 100%", textButtonStyle);
		buttonVolume0 = new TextButton("Volume 0%", textButtonStyle);
		buttonVolume25.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
				tableVolume.removeActor(buttonVolume25);
				tableVolume.add(buttonVolume50);
				tableVolume.getCell(buttonVolume50).spaceBottom(20f);
				music.setVolume(0.50f);
				AppPreferences.MVOLUME = 0.50f;
			}
		});
		buttonVolume50.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
				tableVolume.removeActor(buttonVolume50);
				tableVolume.add(buttonVolume75);
				tableVolume.getCell(buttonVolume75).spaceBottom(20f);
				music.setVolume(0.75f);
				AppPreferences.MVOLUME = 0.75f;
			}
		});
		buttonVolume75.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
				tableVolume.removeActor(buttonVolume75);
				tableVolume.add(buttonVolume100);
				tableVolume.getCell(buttonVolume100).spaceBottom(20f);
				music.setVolume(1.00f);
				AppPreferences.MVOLUME = 1.00f;
			}
		});
		buttonVolume100.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
				tableVolume.removeActor(buttonVolume100);
				tableVolume.add(buttonVolume0);
				tableVolume.getCell(buttonVolume0).spaceBottom(20f);
				music.setVolume(0.00f);
				AppPreferences.MVOLUME = 0.00f;
			}
		});
		buttonVolume0.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
				tableVolume.removeActor(buttonVolume0);
				tableVolume.add(buttonVolume25);
				tableVolume.getCell(buttonVolume25).spaceBottom(20f);
				music.setVolume(0.25f);
				AppPreferences.MVOLUME = 0.25f;
			}
		});
		buttonAudio = new TextButton("Audio", textButtonStyle);
		buttonAudio.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				parent.changeScreen(BLACKJACKCity.AUDIO);
				pressbutton.play();
				music.dispose();
			}
		});
		buttonVolume25.pad(15f, 41f, 15f, 41f);
		buttonVolume50.pad(15f, 41f, 15f, 41f);
		buttonVolume75.pad(15f, 41f, 15f, 41f);
		buttonVolume100.pad(15f, 41f, 15f, 41f);
		buttonVolume0.pad(15f, 41f, 15f, 41f);
		buttonAudio.pad(15f, 41f, 15f, 41f);
		
		
		table.setPosition(1700f, 150f, 0);
		table.add(buttonBack);
		table.getCell(buttonBack).spaceBottom(35f);
		table.row();
		
		tableFullscreen.setPosition(1500f, 700f, 0);
		tableFullscreen.add(buttonFullscreenOn);
		tableFullscreen.getCell(buttonFullscreenOn).spaceBottom(20f);
		tableFullscreen.row();
		
		tableVolume.setPosition(1500f, 540f, 0);
		tableVolume.add(buttonVolume25);
		tableVolume.getCell(buttonVolume25).spaceBottom(40f);
		table.row();
		
		tableAudio.setPosition(1500f, 620f, 0);
		tableAudio.add(buttonAudio);
		tableAudio.getCell(buttonAudio).spaceBottom(40f);
		
		stage.addActor(table);
		stage.addActor(tableFullscreen);
		stage.addActor(tableVolume);
		stage.addActor(tableAudio);
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