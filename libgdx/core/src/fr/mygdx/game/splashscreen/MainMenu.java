package fr.mygdx.game.splashscreen;

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

import fr.mygdx.game.BLACKJACKCity;
import fr.mygdx.game.AppPreferences;

/**
 * Gestion du menu principal
 */
public class MainMenu implements Screen {

	private Stage stage;
	private Table table;
	private TextButton buttonPlay, buttonExit, buttonRules, buttonOptions;
	private Texture Background;
	private Skin skin;
	private BitmapFont black, white;
	private TextureAtlas atlas;
	private SpriteBatch batch;
	private Music music;
	private Music pressbutton;
	private  BLACKJACKCity parent;
	private boolean musicIsOff = true;
	
	
	public MainMenu(BLACKJACKCity blackjackcity){
		parent = blackjackcity;
	}
	
	@Override
	public void show() {
		batch = new SpriteBatch();
		Background = new Texture("Background.png");
		atlas = new TextureAtlas("ui/button.pack");
		skin = new Skin(atlas);
		stage = new Stage();
		music = Gdx.audio.newMusic(Gdx.files.internal("Rulesmusic.mp3"));
		pressbutton = Gdx.audio.newMusic(Gdx.files.internal("pressbutton.mp3"));
		Gdx.input.setInputProcessor(stage);
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		black = new BitmapFont(Gdx.files.internal("font/black.fnt"), false);
		white = new BitmapFont(Gdx.files.internal("font/white.fnt"), false);
		
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.getDrawable("button.up");
		textButtonStyle.down = skin.getDrawable("button.down");
		textButtonStyle.pressedOffsetX = 1;
		textButtonStyle.pressedOffsetY = -1;
		textButtonStyle.font = black;
		
		if (musicIsOff) {
		    music.setLooping(true);
		    music.setVolume(AppPreferences.MVOLUME);
		    music.play();
		    musicIsOff = false;
		}
		pressbutton.setVolume(AppPreferences.SVOLUME);
	
		buttonPlay = new TextButton("Play", textButtonStyle);
		buttonPlay.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				parent.changeScreen(BLACKJACKCity.PLAY);
				pressbutton.play();
				
			}
		});
		buttonPlay.pad(15f, 40f, 15f, 40f);
		buttonRules = new TextButton("Rules", textButtonStyle);
		buttonRules.pad(15f, 36f, 15f, 36f);
		buttonRules.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				parent.changeScreen(BLACKJACKCity.RULES);
				pressbutton.play();
				
			}
		});
		buttonOptions = new TextButton("Options", textButtonStyle);
		buttonOptions.pad(15f, 27.5f, 15f, 27.5f);
		buttonOptions.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				parent.changeScreen(BLACKJACKCity.OPTION);
				pressbutton.play();
				
			}
		});
		buttonExit = new TextButton("Exit", textButtonStyle);
		buttonExit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	pressbutton.play();
            	Gdx.app.exit();
                
            }
        });
		buttonExit.pad(15f, 41f, 15f, 41f);
		
		table.setPosition(1500f, 500f, 0);
		table.add(buttonPlay);
		table.getCell(buttonPlay).spaceBottom(20f);
		table.row();
		table.add(buttonRules);
		table.getCell(buttonRules).spaceBottom(20f);
		table.row();
		table.add(buttonOptions);
		table.getCell(buttonOptions).spaceBottom(20f);
		table.row();
		table.add(buttonExit);
		table.getCell(buttonExit).spaceBottom(20f);
		table.row();
		stage.addActor(table);	
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


	}

	@Override
	public void pause() {


	}

	@Override
	public void resume() {


	}

	@Override
	public void hide() {


	}

	@Override
	public void dispose() {
		stage.dispose();
		atlas.dispose();
		skin.dispose();
		white.dispose();
		black.dispose();
	}
}
