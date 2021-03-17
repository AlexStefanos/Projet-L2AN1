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

public class Gameplay implements Screen {

	private Stage stage;
	private SpriteBatch batch;
	private Texture BlackjackTable, FondCarteBleu, AsCoeur;
	private TextButton buttonQuit, buttonTirer, buttonTirer2, buttonTirer3, buttonTirer4, buttonTirer5, buttonTirer6, buttonTirer7, buttonTirer8, buttonTirer9, buttonTirer10, buttonTirer11, buttonJouer, buttonMiser;
	private BitmapFont black, white;
	private Table table, tableJeu, tableJeu2, tableJeu3, tableJeu4, tableJeu5, tableJeu6, tableJeu7, tableJeu8, tableJeu9, tableJeu10, tableJeu11, tableJeu12;
	private TextureAtlas atlas;
	private Skin skin;
	private Music music;
	private Sound pressbutton;
	
	@Override
	public void show() {
		batch = new SpriteBatch();
		BlackjackTable = new Texture("BlackjackTable.png");
		FondCarteBleu = new Texture("Large/Back Blue 2.png");
		AsCoeur = new Texture("Large/Hearts 1.png");
		atlas = new TextureAtlas("ui/button.pack");
		stage = new Stage();
		skin = new Skin(atlas);
		Gdx.input.setInputProcessor(stage);
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableJeu = new Table(skin);
		tableJeu.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableJeu2 = new Table(skin);
		tableJeu2.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableJeu3 = new Table(skin);
		tableJeu3.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableJeu4 = new Table(skin);
		tableJeu4.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableJeu5 = new Table(skin);
		tableJeu5.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableJeu6 = new Table(skin);
		tableJeu6.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableJeu7 = new Table(skin);
		tableJeu7.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableJeu8 = new Table(skin);
		tableJeu8.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableJeu9 = new Table(skin);
		tableJeu9.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableJeu10 = new Table(skin);
		tableJeu10.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableJeu11 = new Table(skin);
		tableJeu11.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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
		
		buttonQuit = new TextButton("Quit to Main Menu", textButtonStyle);
		buttonQuit.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
				pressbutton.play();
				music.dispose();
			}
		});
		buttonQuit.pad(15f, 40f, 15f, 40f);
		
		buttonJouer = new TextButton("Jouer", textButtonStyle);
		buttonJouer.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
				tableJeu.removeActor(buttonJouer);
				tableJeu.add(buttonTirer);
			}
		});
		buttonJouer.pad(15f, 40f, 15f, 40f);
		
		buttonTirer = new TextButton("Tirer", textButtonStyle);
		buttonTirer.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
			}
		});
		
		buttonTirer2 = new TextButton("Tirer", textButtonStyle);
		buttonTirer2.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
			}
		});
		
		buttonTirer3 = new TextButton("Tirer", textButtonStyle);
		buttonTirer3.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
			}
		});
		
		buttonTirer4 = new TextButton("Tirer", textButtonStyle);
		buttonTirer4.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
			}
		});
		
		buttonTirer5 = new TextButton("Tirer", textButtonStyle);
		buttonTirer5.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
			}
		});
		
		buttonTirer6 = new TextButton("Tirer", textButtonStyle);
		buttonTirer6.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
			}
		});
		
		buttonTirer7 = new TextButton("Tirer", textButtonStyle);
		buttonTirer7.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
			}
		});
		
		buttonTirer8 = new TextButton("Tirer", textButtonStyle);
		buttonTirer8.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
			}
		});
		
		buttonTirer9 = new TextButton("Tirer", textButtonStyle);
		buttonTirer9.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
			}
		});
		
		buttonTirer10 = new TextButton("Tirer", textButtonStyle);
		buttonTirer10.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
			}
		});	
		buttonTirer11 = new TextButton("Tirer", textButtonStyle);
		buttonTirer11.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
			}
		});		
		
		table.setPosition(1700f, 150f, 0);
		table.add(buttonQuit);
		table.getCell(buttonQuit).spaceBottom(35f);
		table.row();
		
		tableJeu.setPosition(500f, 50f, 0);
		tableJeu.add(buttonJouer);
		tableJeu2.setPosition(500f, 50f, 0);
		tableJeu3.setPosition(500f, 50f, 0);
		tableJeu4.setPosition(500f, 50f, 0);
		tableJeu5.setPosition(500f, 50f, 0);
		tableJeu6.setPosition(500f, 50f, 0);
		tableJeu7.setPosition(500f, 50f, 0);
		tableJeu8.setPosition(500f, 50f, 0);
		tableJeu9.setPosition(500f, 50f, 0);
		tableJeu10.setPosition(500f, 50f, 0);
		tableJeu11.setPosition(500f, 50f, 0);
		
		stage.addActor(table);
		stage.addActor(tableJeu);
		stage.addActor(tableJeu2);
		stage.addActor(tableJeu3);
		stage.addActor(tableJeu4);
		stage.addActor(tableJeu5);
		stage.addActor(tableJeu6);
		stage.addActor(tableJeu7);
		stage.addActor(tableJeu8);
		stage.addActor(tableJeu9);
		stage.addActor(tableJeu10);
		stage.addActor(tableJeu11);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(2, 2, 2, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.draw(BlackjackTable, 0,   0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());		
		if (buttonTirer.isChecked()) {
			batch.draw(AsCoeur, 180f, 230f, 103f, 138f);
			tableJeu.removeActor(buttonTirer);
			tableJeu.add(buttonTirer2);
		}
		
		if (buttonTirer2.isChecked()) {
			batch.draw(AsCoeur, 210f, 200f, 103f, 138f);
			tableJeu.removeActor(buttonTirer2);
			tableJeu2.add(buttonTirer3);
		}

		if (buttonTirer3.isChecked()) {
			batch.draw(AsCoeur, 400f, 500f, 103f, 138f);
			tableJeu2.removeActor(buttonTirer3);
			tableJeu3.add(buttonTirer4);
		}

		if (buttonTirer4.isChecked()) {
			batch.draw(AsCoeur, 550f, 500f, 103f, 138f);
			tableJeu3.removeActor(buttonTirer4);
			tableJeu4.add(buttonTirer5);
		}
		
		if (buttonTirer5.isChecked()) {
			batch.draw(AsCoeur, 700f, 500f, 103f, 138f);
			tableJeu4.removeActor(buttonTirer5);
			tableJeu5.add(buttonTirer6);
		}
		
		if (buttonTirer6.isChecked()) {
			batch.draw(AsCoeur, 850f, 500f, 103f, 138f);
			tableJeu5.removeActor(buttonTirer6);
			tableJeu6.add(buttonTirer7);
		}
		
		if (buttonTirer7.isChecked()) {
			batch.draw(AsCoeur, 1000f, 500f, 103f, 138f);
			tableJeu6.removeActor(buttonTirer7);
			tableJeu7.add(buttonTirer8);
		}
		
		if (buttonTirer8.isChecked()) {
			batch.draw(AsCoeur, 1150f, 500f, 103f, 138f);
			tableJeu7.removeActor(buttonTirer8);
			tableJeu8.add(buttonTirer9);
		}
		
		if (buttonTirer9.isChecked()) {
			batch.draw(AsCoeur, 1300f, 500f, 103f, 138f);
			tableJeu8.removeActor(buttonTirer9);
			tableJeu9.add(buttonTirer10);
		}
		
		if (buttonTirer10.isChecked()) {
			batch.draw(AsCoeur, 1450f, 500f, 103f, 138f);
			tableJeu9.removeActor(buttonTirer10);
			tableJeu10.add(buttonTirer11);
		}
		
		if (buttonTirer11.isChecked()) {
			batch.draw(AsCoeur, 1600f, 500f, 103f, 138f);
			tableJeu10.removeActor(buttonTirer10);
			tableJeu11.add(buttonQuit);
		}
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
