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
import fr.mygdx.game.blackjack.*;

public class Gameplay implements Screen {

	private Stage stage;
	private SpriteBatch batch;
	private Texture BlackjackTable, FondCarteBleu, AsTrefle, DeuxTrefle, TroisTrefle, QuatreTrefle, CinqTrefle, SixTrefle, 
	SeptTrefle, HuitTrefle, NeufTrefle, DixTrefle, ValetTrefle, DameTrefle, RoiTrefle, AsCarrot, DeuxCarrot, TroisCarrot, QuatreCarrot, 
	CinqCarrot, SixCarrot, SeptCarrot, HuitCarrot, NeufCarrot, DixCarrot, ValetCarrot, DameCarrot, RoiCarrot, AsCoeur, DeuxCoeur, TroisCoeur,
	QuatreCoeur, CinqCoeur, SixCoeur, SeptCoeur, HuitCoeur, NeufCoeur, DixCoeur, ValetCoeur, DameCoeur, RoiCoeur, AsPique, DeuxPique, 
	TroisPique, QuatrePique, CinqPique, SixPique, SeptPique, HuitPique, NeufPique, DixPique, ValetPique, DamePique, RoiPique, JokerBlack, JokerRed;
	private TextButton buttonQuit, buttonTirer, buttonTirer2, buttonTirer3, buttonTirer4, buttonTirer5, buttonTirer6, buttonTirer7, 
	buttonTirer8, buttonTirer9, buttonTirer10, buttonTirer11, buttonJouer, buttonMiser;
	private BitmapFont black, white;
	private Table table, tableJeu, tableJeu2, tableJeu3, tableJeu4, tableJeu5, tableJeu6, tableJeu7, tableJeu8, tableJeu9, tableJeu10, 
	tableJeu11, tableJeu12;
	private TextureAtlas atlas;
	private Skin skin;
	private Music music;
	private Sound pressbutton;
	
	/*int a = 1;
	//Saisie.lireEntier("Nombre de joueurs à la table ? \n");
	Deck paquet = new Deck();
	Cartes p1 = new Cartes(a, paquet);
	Cartes p2 = new Cartes(a, paquet);
	Cartes p3 = new Cartes(a, paquet);
	Cartes p4 = new Cartes(a, paquet);
	Cartes croupier = new Cartes(a, paquet);*/
	
	@Override
	public void show() {
		batch = new SpriteBatch();
		BlackjackTable = new Texture("BlackjackTable.png");
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
		tableJeu12 = new Table(skin);
		tableJeu12.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		black = new BitmapFont(Gdx.files.internal("font/black.fnt"), false);
		white = new BitmapFont(Gdx.files.internal("font/white.fnt"), false);
		pressbutton = Gdx.audio.newSound(Gdx.files.internal("pressbutton.mp3"));
		music = Gdx.audio.newMusic(Gdx.files.internal("Playmusic.mp3"));
		
		FondCarteBleu = new Texture("Large/Back Blue 2.png");
		AsTrefle = new Texture("Large/Clubs 1.png");
		DeuxTrefle = new Texture("Large/Clubs 2.png"); 
		TroisTrefle = new Texture("Large/Clubs 3.png");
		QuatreTrefle = new Texture("Large/Clubs 4.png");
		CinqTrefle = new Texture("Large/Clubs 5.png");
		SixTrefle = new Texture("Large/Clubs 6.png");
		SeptTrefle = new Texture("Large/Clubs 7.png");
		HuitTrefle = new Texture("Large/Clubs 8.png");
		NeufTrefle = new Texture("Large/Clubs 9.png");
		DixTrefle = new Texture("Large/Clubs 10.png");
		ValetTrefle = new Texture("Large/Clubs 11.png");
		DameTrefle = new Texture("Large/Clubs 12.png");
		RoiTrefle = new Texture("Large/Clubs 13.png");
		AsCarrot = new Texture("Large/Diamond 1.png");
		DeuxCarrot = new Texture("Large/Diamond 2.png");
		TroisCarrot = new Texture("Large/Diamond 3.png");
		QuatreCarrot = new Texture("Large/Diamond 4.png");
		CinqCarrot = new Texture("Large/Diamond 5.png");
		SixCarrot = new Texture("Large/Diamond 6.png");
		SeptCarrot = new Texture("Large/Diamond 7.png");
		HuitCarrot = new Texture("Large/Diamond 8.png");
		NeufCarrot = new Texture("Large/Diamond 9.png");
		DixCarrot = new Texture("Large/Diamond 10.png");
		ValetCarrot = new Texture("Large/Diamond 11.png");
		DameCarrot = new Texture("Large/Diamond 12.png");
		RoiCarrot = new Texture("Large/Diamond 13.png");
		AsCoeur = new Texture("Large/Hearts 1.png");
		DeuxCoeur = new Texture("Large/Hearts 2.png");
		TroisCoeur = new Texture("Large/Hearts 3.png");
		QuatreCoeur = new Texture("Large/Hearts 4.png");
		CinqCoeur = new Texture("Large/Hearts 5.png");
		SixCoeur = new Texture("Large/Hearts 6.png");
		SeptCoeur = new Texture("Large/Hearts 7.png");
		HuitCoeur = new Texture("Large/Hearts 8.png");
		NeufCoeur = new Texture("Large/Hearts 9.png");
		DixCoeur = new Texture("Large/Hearts 10.png");
		ValetCoeur = new Texture("Large/Hearts 11.png");
		DameCoeur = new Texture("Large/Hearts 12.png");
		RoiCoeur = new Texture("Large/Hearts 13.png");
		AsPique = new Texture("Large/Spades 1.png");
		DeuxPique = new Texture("Large/Spades 2.png");
		TroisPique = new Texture("Large/Spades 3.png");
		QuatrePique = new Texture("Large/Spades 4.png");
		CinqPique = new Texture("Large/Spades 5.png");
		SixPique = new Texture("Large/Spades 6.png");
		SeptPique = new Texture("Large/Spades 7.png");
		HuitPique = new Texture("Large/Spades 8.png");
		NeufPique = new Texture("Large/Spades 9.png");
		DixPique = new Texture("Large/Spades 10.png");
		ValetPique = new Texture("Large/Spades 11.png");
		DamePique = new Texture("Large/Spades 12.png");
		RoiPique = new Texture("Large/Spades 13.png");
		JokerBlack = new Texture("Large/Joker Black.png");
		JokerRed = new Texture("Large/Joker Red.png");
		
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
				/*paquet.generateur();		|
				paquet.conversion();		|
				paquet.shuffle();			| Lancer la generation de paquet et des mains de depart lorsque l'on appuie sur Jouer  
				croupier.croupierdep(); 	|
				p1.maindep();				| */
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
		tableJeu12.setPosition(500f, 50f, 0);
		
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
		stage.addActor(tableJeu12);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(2, 2, 2, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.draw(BlackjackTable, 0,   0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		if (buttonJouer.isChecked()) {
			tableJeu.removeActor(buttonJouer);
			tableJeu2.add(buttonTirer);
			//if (Cartes.mains) 		si la 1ere carte est un as de coeur par exemple, batch.draw(AsCoeur)
			batch.draw(AsCoeur, 180f, 230f, 103f, 138f);
		}
		
		if (buttonTirer.isChecked()) {
			batch.draw(AsCoeur, 210, 200f, 103f, 138f);
			tableJeu2.removeActor(buttonTirer);
			tableJeu3.add(buttonTirer2);
		}
		
		if (buttonTirer2.isChecked()) {
			batch.draw(AsCoeur, 400f, 500f, 103f, 138f);
			tableJeu3.removeActor(buttonTirer2);
			tableJeu4.add(buttonTirer3);
		}

		if (buttonTirer3.isChecked()) {
			batch.draw(AsCoeur, 550f, 500f, 103f, 138f);
			tableJeu4.removeActor(buttonTirer3);
			tableJeu5.add(buttonTirer4);
		}

		if (buttonTirer4.isChecked()) {
			batch.draw(AsCoeur, 700f, 500f, 103f, 138f);
			tableJeu5.removeActor(buttonTirer4);
			tableJeu6.add(buttonTirer5);
		}
		
		if (buttonTirer5.isChecked()) {
			batch.draw(AsCoeur, 850f, 500f, 103f, 138f);
			tableJeu6.removeActor(buttonTirer5);
			tableJeu7.add(buttonTirer6);
		}
		
		if (buttonTirer6.isChecked()) {
			batch.draw(AsCoeur, 1000f, 500f, 103f, 138f);
			tableJeu7.removeActor(buttonTirer6);
			tableJeu8.add(buttonTirer7);
		}
		
		if (buttonTirer7.isChecked()) {
			batch.draw(AsCoeur, 1150f, 500f, 103f, 138f);
			tableJeu8.removeActor(buttonTirer7);
			tableJeu9.add(buttonTirer8);
		}
		
		if (buttonTirer8.isChecked()) {
			batch.draw(AsCoeur, 1300f, 500f, 103f, 138f);
			tableJeu9.removeActor(buttonTirer8);
			tableJeu10.add(buttonTirer9);
		}
		
		if (buttonTirer9.isChecked()) {
			batch.draw(AsCoeur, 1450f, 500f, 103f, 138f);
			tableJeu10.removeActor(buttonTirer9);
			tableJeu11.add(buttonTirer10);
		}
		
		if (buttonTirer10.isChecked()) {
			batch.draw(AsCoeur, 1600f, 500f, 103f, 138f);
			tableJeu11.removeActor(buttonTirer10);
			tableJeu12.add(buttonQuit);
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
