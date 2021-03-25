package fr.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
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
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

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
	private BitmapFont black, white;
	private SpriteBatch batch;
	private Music pressbutton;
	
	public Audio(BLACKJACKCity blackjackcity){
		parent = blackjackcity;
		stage = new Stage(new ScreenViewport());
		
	}
	
	
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
		white = new BitmapFont(Gdx.files.internal("font/white.fnt"), false);
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
		
		music = Gdx.audio.newMusic(Gdx.files.internal("Optionmusic.mp3"));
		music.setLooping(true);
		music.setVolume(AppPreferences.MVOLUME);
		music.play();
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
				
				table.add(titleLabel).colspan(2);
				table.row().pad(10,0,0,10);
				table.add(volumeMusicLabel).left();
				table.add(volumeMusicSlider);
				table.row().pad(10,0,0,10);
				table.add(musicOnOffLabel).left();
				table.add(musicCheckbox);
				table.row().pad(10,0,0,10);
				table.add(volumeSoundLabel).left();
				table.add(soundMusicSlider);
				table.row().pad(10,0,0,10);
				table.add(soundOnOffLabel).left();
				table.add(soundEffectsCheckbox);
				table.row().pad(10,0,0,10);
				table.add(buttonBack).colspan(2);

	}

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
