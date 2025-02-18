package fr.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
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

/**
 * Menu permetettant de g�rer les options du jeu
 * @author arthu
 *
 */
public class Options implements Screen {

	private Stage stage;
	private Table table, tableFullscreen, tableAudio, tableResolution;
	private TextButton buttonBack, buttonFullscreenOn, buttonFullscreenOff, buttonAudio, buttonResolution0, buttonResolution1, buttonResolution2, buttonResolution3, buttonResolution4, buttonResolution5;
	private Texture Background;
	private Skin skin;
	private BitmapFont black;
	private TextureAtlas atlas;
	private SpriteBatch batch;
	
	private Music pressbutton;
	private BLACKJACKCity parent;
	public static boolean FULLSCREEN = true;
	public static float MULTIWEIGHT0 = 0.71f;
	
	public Options(BLACKJACKCity blackjackcity){
		parent = blackjackcity;
	}
	
	/**
	 * Lorsqu'une classe est a l'ecran, show() est la premiere methode a etre appele. Par convention, on initialise les variables de la classe dans cette methode.
	 */
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
		tableAudio = new Table(skin);
		tableAudio.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableResolution = new Table(skin);
		tableResolution.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		black = new BitmapFont(Gdx.files.internal("font/black.fnt"), false);
		
		pressbutton = Gdx.audio.newMusic(Gdx.files.internal("pressbutton.mp3"));
	
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.getDrawable("button.up");
		textButtonStyle.down = skin.getDrawable("button.down");
		textButtonStyle.pressedOffsetX = 1;
		textButtonStyle.pressedOffsetY = -1;
		textButtonStyle.font = black;
		
		
		
		
		pressbutton.setVolume(AppPreferences.SVOLUME);
		
		buttonBack = new TextButton("Back", textButtonStyle);
		buttonBack.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				parent.changeScreen(BLACKJACKCity.MAINMENU);
				pressbutton.play();
				
			}
		});
		buttonBack.pad(15f, 40f, 15f, 40f);
		
		buttonFullscreenOn = new TextButton("Fullscreen On", textButtonStyle);
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
		buttonFullscreenOn.pad(15f, 41f, 15f, 41f);
		
		buttonFullscreenOff = new TextButton("Fullscreen Off", textButtonStyle);
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
		buttonFullscreenOff.pad(15f, 41f, 15f, 41f);
	
		buttonAudio = new TextButton("Audio", textButtonStyle);
		buttonAudio.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				parent.changeScreen(BLACKJACKCity.AUDIO);
				pressbutton.play();
				
			}
		});
		buttonAudio.pad(15f, 41f, 15f, 41f);
		
		buttonResolution0 = new TextButton("1920x1080", textButtonStyle);
		buttonResolution0.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
				tableResolution.removeActor(buttonResolution0);
				tableResolution.add(buttonResolution1);
				Gdx.graphics.setWindowedMode(1366, 768);
			}
		});
		buttonResolution0.pad(15f, 41f, 15f, 41f);
		
		buttonResolution1 = new TextButton("1366x768", textButtonStyle);
		buttonResolution1.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
				tableResolution.removeActor(buttonResolution1);
				tableResolution.add(buttonResolution2);
				Gdx.graphics.setWindowedMode(1536, 864);
			}
		});
		buttonResolution1.pad(15f, 41f, 15f, 41f);
		
		buttonResolution2 = new TextButton("1536x864", textButtonStyle);
		buttonResolution2.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
				tableResolution.removeActor(buttonResolution2);
				tableResolution.add(buttonResolution3);
				Gdx.graphics.setWindowedMode(1440, 900);
			}
		});
		buttonResolution2.pad(15f, 41f, 15f, 41f);
		
		buttonResolution3 = new TextButton("1440x900", textButtonStyle);
		buttonResolution3.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
				tableResolution.removeActor(buttonResolution3);
				tableResolution.add(buttonResolution4);
				Gdx.graphics.setWindowedMode(375, 667);
			}
		});
		buttonResolution3.pad(15f, 41f, 15f, 41f);
		
		buttonResolution4 = new TextButton("375x640", textButtonStyle);
		buttonResolution4.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
				tableResolution.removeActor(buttonResolution4);
				tableResolution.add(buttonResolution5);
				Gdx.graphics.setWindowedMode(360, 640);
			}
		});
		buttonResolution4.pad(15f, 41f, 15f, 41f);
		
		buttonResolution5 = new TextButton("360x640", textButtonStyle);
		buttonResolution5.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
				tableResolution.removeActor(buttonResolution5);
				tableResolution.add(buttonResolution0);
				Gdx.graphics.setWindowedMode(1920, 1080);
			}
		});
		buttonResolution5.pad(15f, 41f, 15f, 41f);
		
		table.setPosition(1700f, 150f, 0);
		table.add(buttonBack);
		table.getCell(buttonBack).spaceBottom(35f);
		table.row();
		
		tableFullscreen.setPosition(1500f, 700f, 0);
		if (FULLSCREEN == true ) {
			tableFullscreen.add(buttonFullscreenOn);
			tableFullscreen.getCell(buttonFullscreenOn).spaceBottom(20f);
			tableFullscreen.row();
		}
		if (FULLSCREEN == false) {
			tableFullscreen.add(buttonFullscreenOff);
			tableFullscreen.getCell(buttonFullscreenOff).spaceBottom(20f);
			tableFullscreen.row();
		}
		
		tableAudio.setPosition(1500f, 620f, 0);
		tableAudio.add(buttonAudio);
		tableAudio.getCell(buttonAudio).spaceBottom(40f);
		
		stage.addActor(table);
		stage.addActor(tableFullscreen);
		stage.addActor(tableAudio);
		stage.addActor(tableResolution);
	}

	/**
	 * Gestion de tous les affichages de la classe.
	 */
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

	/**
	 * Permet de redimensionner des Textures, bouttons, etc. affiche a l'ecran
	 */
	@Override
	public void resize(int width, int height) {

	}
	
	/**
	 * Gestion des pauses du jeu
	 */
	@Override
	public void pause() {

	}
	
	/**
	 * Gestion de la reprise des pauses 
	 */
	@Override
	public void resume() {

	}

	/**
	 * Gestion des Textures, bouttons, etc. non-affiche a l'ecran
	 */
	@Override
	public void hide() {

	}

	/**
	 * Permet de fermer proprement la variable donnee (methodes, stage, etc.) 
	 */
	@Override
	public void dispose() {

	}

}