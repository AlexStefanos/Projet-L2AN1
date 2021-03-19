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

public class TrioPlayers implements Screen {
	private Stage stage;
	private SpriteBatch batch;
	private Texture BlackjackTable, FondCarteBleu, AsTrefle, DeuxTrefle, TroisTrefle, QuatreTrefle, CinqTrefle, SixTrefle, 
	SeptTrefle, HuitTrefle, NeufTrefle, DixTrefle, ValetTrefle, DameTrefle, RoiTrefle, AsCarrot, DeuxCarrot, TroisCarrot, QuatreCarrot, 
	CinqCarrot, SixCarrot, SeptCarrot, HuitCarrot, NeufCarrot, DixCarrot, ValetCarrot, DameCarrot, RoiCarrot, AsCoeur, DeuxCoeur, TroisCoeur,
	QuatreCoeur, CinqCoeur, SixCoeur, SeptCoeur, HuitCoeur, NeufCoeur, DixCoeur, ValetCoeur, DameCoeur, RoiCoeur, AsPique, DeuxPique, 
	TroisPique, QuatrePique, CinqPique, SixPique, SeptPique, HuitPique, NeufPique, DixPique, ValetPique, DamePique, RoiPique, JokerBlack, 
	JokerRed, JetonBleu, JetonRouge, JetonVert, JetonJaune, JetonBleuClair, JetonBeige, JetonBlanc;
	private TextButton buttonQuit, buttonTirerJ1, buttonTirerJ2, buttonTirerJ3, buttonJouer, buttonMiser;
	private BitmapFont black, white;
	private Table table, tableJeu, tableJeu2, tableJeu3;
	private TextureAtlas atlas;
	private Skin skin;
	private Music music;
	private Sound pressbutton;
	private int cliqueJ1, cliqueJ2, cliqueJ3;
		
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
		BlackjackTable = new Texture("BlackjackTable TrioPlayers.png");
		atlas = new TextureAtlas("ui/button.pack");
		stage = new Stage();
		skin = new Skin(atlas);
		cliqueJ1 = 0;
		cliqueJ2 = 0;
		cliqueJ3 = 0;
		Gdx.input.setInputProcessor(stage);
		
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableJeu = new Table(skin);
		tableJeu.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableJeu2 = new Table(skin);
		tableJeu2.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableJeu3 = new Table(skin);
		tableJeu3.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
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
		JetonBleu = new Texture("LargeChips/chip_blue.png");
		JetonBleuClair = new Texture("LargeChips/chip_lightblue.png");
		JetonRouge = new Texture("LargeChips/chip_red.png");
		JetonBlanc = new Texture("LargeChips/chip_white.png");
		JetonVert = new Texture("LargeChips/chip_green.png");
		JetonBeige = new Texture("LargeChips/chip_biege.png");
		JetonJaune = new Texture("LargeChips/chip_yellow.png");
			
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
			
		buttonJouer = new TextButton("Play", textButtonStyle);
		buttonJouer.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
				tableJeu.removeActor(buttonJouer);
				tableJeu.add(buttonTirerJ1);
				/*paquet.generateur();		|
				paquet.conversion();		|
				paquet.shuffle();			| Lancer la generation de paquet et des mains de depart lorsque l'on appuie sur Jouer  
				croupier.croupierdep(); 	|
				p1.maindep();				| */
			}
		});
		buttonJouer.pad(15f, 40f, 15f, 40f);
			
		buttonTirerJ1 = new TextButton("Draw Player 1", textButtonStyle);
		buttonTirerJ1.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
				cliqueJ1++;
			}
		});
		buttonTirerJ1.pad(15f, 40f, 15f, 40f);
		
		buttonTirerJ2 = new TextButton("Draw Player 2", textButtonStyle);
		buttonTirerJ2.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
				cliqueJ2++;
			}
		});
		buttonTirerJ2.pad(15f, 40f, 15f, 40f);	
		
		buttonTirerJ3 = new TextButton("Draw Player 3", textButtonStyle);
		buttonTirerJ3.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
				cliqueJ3++;
			}
		});
		buttonTirerJ3.pad(15f, 40f, 15f, 40f);	
		
		table.setPosition(1700f, 600f, 0);
		table.add(buttonQuit);
			
		tableJeu.setPosition(220f, 600f, 0);
		tableJeu.add(buttonJouer);
		
		tableJeu2.setPosition(220f, 600f, 0);
		tableJeu3.setPosition(220f, 600f, 0);

		stage.addActor(table);
		stage.addActor(tableJeu);
		stage.addActor(tableJeu2);
		stage.addActor(tableJeu3);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(2, 2, 2, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
		batch.begin();
		batch.draw(BlackjackTable, 0,   0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		if (buttonJouer.isChecked()) {
			//if (Cartes.mains) 		si la 1ere carte est un as de coeur par exemple, batch.draw(AsCoeur)
			batch.draw(AsCoeur, 1268f, 183f, 103f, 138f); //1ere Carte J1	
			batch.draw(AsCoeur, 920f, 183f, 103f, 138f); //1ere Carte J2
			batch.draw(AsCoeur, 565f, 183f, 103f, 138f); //1ere Carte J3
			batch.draw(AsCoeur, 800f, 500f, 103f, 138f); //1ere Carte Croupier
			batch.draw(JetonVert, 737f, 1005f, 65f, 29f);
			batch.draw(JetonRouge, 807f, 1005f, 65f, 29f);
			batch.draw(JetonBeige, 880f, 1005f, 65f, 29f);
			batch.draw(JetonBleu, 953f, 1005f, 65f, 29f);
			batch.draw(JetonBleuClair, 1026f, 1005f, 65f, 29f);
			batch.draw(JetonJaune, 1103f, 1005f, 65f, 29f);
			batch.draw(JetonBlanc, 1175f, 1005f, 65f, 29f);
		}	
		if (cliqueJ1 >= 1) {
			batch.draw(AsCoeur, 1300f, 150f, 103f, 138f);
			if (cliqueJ1 >=2) {
				batch.draw(AsCoeur, 1330f, 120f, 103f, 138f);
				if (cliqueJ1 >= 3) {
					batch.draw(AsCoeur, 1360f, 90f, 103f, 138f);
					if (cliqueJ1 >= 4) {
						batch.draw(AsCoeur, 1470f, 183f, 103f, 138f);
						if (cliqueJ1 >= 5) {
							batch.draw(AsCoeur, 1500f, 150f, 103f, 138f);
							if (cliqueJ1 >= 6) {
								batch.draw(AsCoeur, 1530f, 120f, 103f, 138f);
								if (cliqueJ1 >= 7) {
									batch.draw(AsCoeur, 1560f, 90f, 103f, 138f);
									if (cliqueJ1 >= 8) {
										batch.draw(AsCoeur, 1670f, 183f, 103f, 138f);
										if (cliqueJ1 >= 9){
											batch.draw(AsCoeur, 1700f, 150f, 103f, 138f);
											if (cliqueJ1 >= 10) {
												batch.draw(AsCoeur, 1730f, 120f, 103f, 138f);
												tableJeu.removeActor(buttonTirerJ1);
												tableJeu2.add(buttonTirerJ2);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}	
		if (cliqueJ2 >= 1) {
			batch.draw(AsCoeur, 950f, 150f, 103f, 138f);
			if (cliqueJ2 >=2) {
				batch.draw(AsCoeur, 980f, 120f, 103f, 138f);
				if (cliqueJ2 >= 3) {
					batch.draw(AsCoeur, 1010f, 90f, 103f, 138f);
					if (cliqueJ2 >= 4) {
						batch.draw(AsCoeur, 920f, 400f, 103f, 138f);
						if (cliqueJ2 >= 5) {
							batch.draw(AsCoeur, 950f, 370f, 103f, 138f);
							if (cliqueJ2 >= 6) {
								batch.draw(AsCoeur, 980f, 340f, 103f, 138f);
								if (cliqueJ2 >= 7) {
									batch.draw(AsCoeur, 1010f, 310f, 103f, 138f);
									if (cliqueJ2 >= 8) {
										batch.draw(AsCoeur, 1130f, 400f, 103f, 138f);
										if (cliqueJ2 >= 9){
											batch.draw(AsCoeur, 1160f, 370f, 103f, 138f);
											if (cliqueJ2 >= 10) {
												batch.draw(AsCoeur, 1190f, 340f, 103f, 138f);
												tableJeu2.removeActor(buttonTirerJ2);
												tableJeu3.add(buttonTirerJ3);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if (cliqueJ3 >= 1) {
			batch.draw(AsCoeur, 595f, 150f, 103f, 138f);
			if (cliqueJ3 >=2) {
				batch.draw(AsCoeur, 625f, 120f, 103f, 138f);
				if (cliqueJ3 >= 3) {
					batch.draw(AsCoeur, 655f, 90f, 103f, 138f);
					if (cliqueJ3 >= 4) {
						batch.draw(AsCoeur, 400f, 183f, 103f, 138f);
						if (cliqueJ3 >= 5) {
							batch.draw(AsCoeur, 430f, 150f, 103f, 138f);
							if (cliqueJ3 >= 6) {
								batch.draw(AsCoeur, 460f, 120f, 103f, 138f);
								if (cliqueJ3 >= 7) {
									batch.draw(AsCoeur, 490f, 90f, 103f, 138f);
									if (cliqueJ3 >= 8) {
										batch.draw(AsCoeur, 260f, 183f, 103f, 138f);
										if (cliqueJ3 >= 9){
											batch.draw(AsCoeur, 290f, 150f, 103f, 138f);
											if (cliqueJ3 >= 10) {
												batch.draw(AsCoeur, 320f, 120f, 103f, 138f);
												tableJeu3.removeActor(buttonTirerJ3);
											}
										}
									}
								}
							}
						}
					}
				}
			}
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
