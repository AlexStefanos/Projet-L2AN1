package fr.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
/**
 * Permet de g�rer l'audio du jeu
 * @author arthu
 *
 */
public class Audio implements Screen {
	private BLACKJACKCity parent;
	private Stage stage;
	private Label titleLabel;
	private Label volumeMusicLabel;
	private Label volumeSoundLabel;
	private Label musicOnOffLabel;
	private Label soundOnOffLabel;
	private Music music;
	private Table tableBack;
	private Skin skinButton;
	private TextureAtlas atlas;
	private TextButton buttonBack;
	private Texture Background;
	private BitmapFont black;
	private SpriteBatch batch;
	private Music pressbutton;
	
	public Audio(BLACKJACKCity blackjackcity){
		parent = blackjackcity;
		stage = new Stage(new ScreenViewport());
	}
	
	/**
	 * Lorsqu'une classe est a l'ecran, show() est la premiere methode a etre appele. Par convention, on initialise les variables de la classe dans cette methode.
	 */
	@Override
	public void show() {
		stage.clear();
		Gdx.input.setInputProcessor(stage);
		atlas = new TextureAtlas("ui/button.pack");
		skinButton = new Skin(atlas);
		tableBack = new Table(skinButton);
		tableBack.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch = new SpriteBatch();
		Background = new Texture("Background.png");
		black = new BitmapFont(Gdx.files.internal("font/black.fnt"), false);
		pressbutton = Gdx.audio.newMusic(Gdx.files.internal("pressbutton.mp3"));
		
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skinButton.getDrawable("button.up");
		textButtonStyle.down = skinButton.getDrawable("button.down");
		textButtonStyle.pressedOffsetX = 1;
		textButtonStyle.pressedOffsetY = -1;
		textButtonStyle.font = black;
			
		Table table = new Table();
		table.setFillParent(true);
		
		stage.addActor(table);
		
		music = Gdx.audio.newMusic(Gdx.files.internal("Rulesmusic.mp3"));
		
		
		pressbutton.setVolume(AppPreferences.SVOLUME);
	
		Skin skin = new Skin(Gdx.files.internal("skin/golden-ui-skin.json"));
		
		final Slider volumeMusicSlider = new Slider(0f, 1f, 0.1f, false, skin);
		parent.getPreferences();
		volumeMusicSlider.setValue(AppPreferences.getMusicVolume());
		volumeMusicSlider.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				parent.getPreferences().setMusicVolume(volumeMusicSlider.getValue());
				return false;
			}
		});
		
		final Slider soundMusicSlider = new Slider(0f, 1f, 0.1f, false, skin);
		parent.getPreferences();
		soundMusicSlider.setValue(AppPreferences.getSoundVolume()); 
		soundMusicSlider.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				parent.getPreferences().setSoundVolume(soundMusicSlider.getValue());
				return false;
			}
		});
				final CheckBox musicCheckbox = new CheckBox(null, skin);
				musicCheckbox.setChecked(parent.getPreferences().isMusicEnabled());
				musicCheckbox.addListener(new EventListener() {
					@Override
					public boolean handle(Event event) {
						boolean enabled = musicCheckbox.isChecked();
						parent.getPreferences().setMusicEnabled(enabled);
						return false;
					}
				});
				final CheckBox soundEffectsCheckbox = new CheckBox(null, skin);
				soundEffectsCheckbox.setChecked(parent.getPreferences().isSoundEffectsEnabled());
				soundEffectsCheckbox.addListener(new EventListener() {
					@Override
					public boolean handle(Event event) {
						boolean enabled = soundEffectsCheckbox.isChecked();
						parent.getPreferences().setSoundEffectsEnabled(enabled);
						return false;
					}
				});
				buttonBack = new TextButton("Save", textButtonStyle);
				buttonBack.addListener(new ClickListener() {
					@Override
					public void clicked(InputEvent event, float x, float y) {
						parent.changeScreen(BLACKJACKCity.OPTION); 
						pressbutton.play();
						music.dispose();
					}
				});
		
				titleLabel = new Label( "Audio", skin );
				volumeMusicLabel = new Label( "Music Volume", skin );
				volumeSoundLabel = new Label( "Sound Volume", skin );
				musicOnOffLabel = new Label( "Music", skin );
				soundOnOffLabel = new Label( "Sound Effect", skin );
				
				table.setPosition(500f, -50f, 0);
				table.add(titleLabel);
				table.row().pad(10,0,0,10);
				table.add(volumeMusicLabel);
				table.add(volumeMusicSlider);
				table.row().pad(10,0,0,10);
				table.add(musicOnOffLabel);
				table.add(musicCheckbox);
				table.row().pad(10,0,0,10);
				table.add(volumeSoundLabel);
				table.add(soundMusicSlider);
				table.row().pad(10,0,0,10);
				table.add(soundOnOffLabel);
				table.add(soundEffectsCheckbox);
				table.row().pad(10,0,0,10);
				table.add(buttonBack);
	}

	/**
	 * Gestion de tous les affichages de la classe.
	 */
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.draw(Background,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
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
