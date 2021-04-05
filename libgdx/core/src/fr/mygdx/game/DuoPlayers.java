package fr.mygdx.game;

import java.util.ArrayList;

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

public class DuoPlayers implements Screen{
	private Stage stage;
	private SpriteBatch batch;
	private Texture BlackjackTable, JetonBleu, JetonRouge, JetonVert, JetonJaune, JetonBleuClair, JetonBeige, JetonBlanc;
	private TextButton buttonQuit, buttonTirerJ1, buttonTirerJ2, buttonJouer, buttonMiser,buttonRedJeton,buttonGreenJeton,buttonBlueJeton, buttonYellowJeton;
	private BitmapFont black, white;
	private Table table, tableJeu, tableJeu2, tableRedJeton, tableGreenJeton, tableBlueJeton, tableYellowJeton;
	private TextureAtlas atlas, atlas2, atlas3, atlas4, atlas5, atlasLabel;
	private Skin skin, skin2, skin3, skin4, skin5,skinLabel;
	private Music music;
	private Music pressbutton;
	private Label miseLabel;
	private int cliqueJ1, cliqueJ2, mise;
	private  BLACKJACKCity parent;
	private int lancement = 0;
	
	public DuoPlayers(BLACKJACKCity box2dTutorial){
		parent = box2dTutorial;
	}
	
	private ArrayList<Texture> texturespack;
	private Joueur[] joueurs = new Joueur[1];
	Deck paquet = new Deck(texturespack);
	//Deck paquetnom = new Deck(); Inutile pour l'instant
	Cartes p1 = new Cartes(paquet);
	Cartes p2 = new Cartes(paquet);
	private int p1Carte = 0, p2Carte = 0;
	
	@Override
	public void show() {
		batch = new SpriteBatch();
		BlackjackTable = new Texture("BlackjackTable DuoPlayers.png");
		atlas3 = new TextureAtlas("buttonjeton2/buttonGreen.pack");
		atlas4 = new TextureAtlas("buttonjeton3/buttonBlue.pack");
		atlas5 = new TextureAtlas("buttonjeton4/buttonYellow.pack");
		atlas2 = new TextureAtlas("buttonjeton/Buttonred.pack");
		atlas = new TextureAtlas("ui/button.pack");
		stage = new Stage();
		skin = new Skin(atlas);
		skin2 = new Skin(atlas2);
		skin3 = new Skin(atlas3);
		skin4 = new Skin(atlas4);
		skin5 = new Skin(atlas5);
		skinLabel = new Skin(Gdx.files.internal("skindefault/uiskin.json"));
		cliqueJ1 = 0;
		cliqueJ2 = 0;
		mise = 0;
		Gdx.input.setInputProcessor(stage);
		
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableJeu = new Table(skin);
		tableJeu.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableJeu2 = new Table(skin);
		tableJeu2.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableRedJeton = new Table(skin2);
		tableRedJeton.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableGreenJeton = new Table(skin3);
		tableGreenJeton.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableBlueJeton = new Table(skin4);
		tableBlueJeton.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableYellowJeton = new Table(skin5);
		tableYellowJeton.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		black = new BitmapFont(Gdx.files.internal("font/black.fnt"), false);
		white = new BitmapFont(Gdx.files.internal("font/white.fnt"), false);
		pressbutton = Gdx.audio.newMusic(Gdx.files.internal("pressbutton.mp3"));
		music = Gdx.audio.newMusic(Gdx.files.internal("Playmusic.mp3"));
			
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
		
		TextButtonStyle textButtonStyle2 = new TextButtonStyle();
		textButtonStyle2.down = skin2.getDrawable("buttonrouge.down");
		textButtonStyle2.up = skin2.getDrawable("buttonrouge.up");
		textButtonStyle2.pressedOffsetX = 1;
		textButtonStyle2.pressedOffsetY = -1;
		textButtonStyle2.font = black;
		
		TextButtonStyle textButtonStyle3 = new TextButtonStyle();
		textButtonStyle3.down = skin3.getDrawable("buttongreen.down");
		textButtonStyle3.up = skin3.getDrawable("buttongreen.up");
		textButtonStyle3.pressedOffsetX = 1;
		textButtonStyle3.pressedOffsetY = -1;
		textButtonStyle3.font = black;
		
		TextButtonStyle textButtonStyle4 = new TextButtonStyle();
		textButtonStyle4.down = skin4.getDrawable("buttonblue.down");
		textButtonStyle4.up = skin4.getDrawable("buttonblue.up");
		textButtonStyle4.pressedOffsetX = 1;
		textButtonStyle4.pressedOffsetY = -1;
		textButtonStyle4.font = black;
		
		TextButtonStyle textButtonStyle5 = new TextButtonStyle();
		textButtonStyle5.down = skin5.getDrawable("buttonyellow.down");
		textButtonStyle5.up = skin5.getDrawable("buttonyellow.up");
		textButtonStyle5.pressedOffsetX = 1;
		textButtonStyle5.pressedOffsetY = -1;
		textButtonStyle5.font = black;
			
		music.setLooping(true);
		music.setVolume(AppPreferences.MVOLUME);
		music.play();
		pressbutton.setVolume(AppPreferences.SVOLUME);
			
		buttonQuit = new TextButton("Quit to Main Menu", textButtonStyle);
		buttonQuit.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				parent.changeScreen(BLACKJACKCity.MAINMENU);
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
		
		buttonTirerJ2 = new TextButton("Draw Player 2", textButtonStyle);
		buttonTirerJ2.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
				cliqueJ2++;
			}
		});
		
		buttonRedJeton = new TextButton("500", textButtonStyle2);
		buttonRedJeton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				mise += 500; 
				pressbutton.play();
				music.dispose();
			}
		});
		buttonRedJeton.pad(15f, 40f, 15f, 40f);
		
		buttonYellowJeton = new TextButton("100", textButtonStyle5);
		buttonYellowJeton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				mise += 100; 
				pressbutton.play();
				music.dispose();
			}
		});
		buttonYellowJeton.pad(15f, 40f, 15f, 40f);
		
		buttonGreenJeton = new TextButton("200", textButtonStyle3);
		buttonGreenJeton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				mise += 200; 
				pressbutton.play();
				music.dispose();
			}
		});
		buttonGreenJeton.pad(15f, 40f, 15f, 40f);
		
		buttonBlueJeton = new TextButton("50", textButtonStyle4);
		buttonBlueJeton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				mise += 50; 
				pressbutton.play();
				music.dispose();
			}
		});
		miseLabel = new Label( "Mise = "+mise , skinLabel );
		
		table.setPosition(500f, -50f, 0);
		table.add(miseLabel);
		table.row().pad(10,0,0,10);
		
		
		buttonBlueJeton.pad(15f, 40f, 15f, 40f);
			
		table.setPosition(1700f, 600f, 0);
		table.add(buttonQuit);
		table.row();
			
		tableJeu.setPosition(220f, 600f, 0);
		tableJeu.add(buttonJouer);
		table.row();
			
		tableJeu2.setPosition(220f, 600f, 0);
		
		tableRedJeton.setPosition(100f,100f, 0);
		tableRedJeton.add(buttonRedJeton);
		table.row();
		
		tableGreenJeton.setPosition(300f,100f, 0);
		tableGreenJeton.add(buttonGreenJeton);
		table.row();
		
		tableBlueJeton.setPosition(500f,100f, 0);
		tableBlueJeton.add(buttonBlueJeton);
		table.row();
		
		tableYellowJeton.setPosition(700f,100f, 0);
		tableYellowJeton.add(buttonYellowJeton);
		table.row();
		
		
		stage.addActor(table);
		stage.addActor(tableJeu);
		stage.addActor(tableJeu2);
		stage.addActor(tableRedJeton);
		stage.addActor(tableGreenJeton);
		stage.addActor(tableBlueJeton);
		stage.addActor(tableYellowJeton);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(2, 2, 2, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
		if (lancement == 0) {
			paquet.creationn();
			paquet.shuffle();
			paquet.toNb();
			//paquet.conversion();
    		//paquetnom = paquet;
    		//paquetnom.creation();
    		//paquetnom.creationn();
			p1.initialisation();
			p2.initialisation();
			p1.maindep();
			p2.maindep();
			p1.croupierdep();
			p1.tirerjoueur();
			p2.maindep();
			p1.croupiertirer();
	    	p1.gagnant();
	    	p2.gagnant();
		}
		lancement++;
		
		batch.begin();
		batch.draw(BlackjackTable, 0,   0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		if (buttonJouer.isChecked()) {
			p1Carte = p1.uneCartev2(0);
			batch.draw(p1.getMainJoueur0().get(0), 920f, 172f, 103f, 138f);
			p2Carte = p2.uneCartev2(0);
			batch.draw(p2.getMainJoueur0().get(0), 713f, 172f, 103f, 138f); 
			batch.draw(p1.getMainJoueur0().get(0), 800f, 500f, 103f, 138f); //1ere Carte Croupier
			batch.draw(JetonVert, 737f, 1005f, 65f, 29f);
			batch.draw(JetonRouge, 807f, 1005f, 65f, 29f);
			batch.draw(JetonBeige, 880f, 1005f, 65f, 29f);
			batch.draw(JetonBleu, 953f, 1005f, 65f, 29f);
			batch.draw(JetonBleuClair, 1026f, 1005f, 65f, 29f);
			batch.draw(JetonJaune, 1103f, 1005f, 65f, 29f);
			batch.draw(JetonBlanc, 1175f, 1005f, 65f, 29f);
		}
		
		if (cliqueJ1 >= 1) {
			p1Carte = p1.uneCartev2(1);
			batch.draw(p1.getMainJoueur0().get(1), 1155f, 140f, 103f, 138f);
			if (cliqueJ1 >= 2) {
				p1Carte = p1.uneCartev2(2);
				batch.draw(p1.getMainJoueur0().get(2), 1185f, 110f, 103f, 138f);
				if (cliqueJ1 >= 3) {
					p1Carte = p1.uneCartev2(3);
					batch.draw(p1.getMainJoueur0().get(3), 1215f, 80f, 103f, 138f);
					if (cliqueJ1 >= 4) {
						p1Carte = p1.uneCartev2(4);
						batch.draw(p1.getMainJoueur0().get(4), 1345f, 172f, 103f, 138f);
						if (cliqueJ1 >= 5) {
							p1Carte = p1.uneCartev2(5);
							batch.draw(p1.getMainJoueur0().get(5), 1375f, 140f, 103f, 138f);
							if (cliqueJ1 >= 6) {
								p1Carte = p1.uneCartev2(6);
								batch.draw(p1.getMainJoueur0().get(6), 1405f, 110f, 103f, 138f);
								if (cliqueJ1 >= 7) {
									p1Carte = p1.uneCartev2(7);
									batch.draw(p1.getMainJoueur0().get(7), 1435f, 80f, 103f, 138f);
									if (cliqueJ1 >= 8) {
										p1Carte = p1.uneCartev2(8);
										batch.draw(p1.getMainJoueur0().get(8), 1565f, 172f, 103f, 138f);
										if (cliqueJ1 >= 9) {
											p1Carte = p1.uneCartev2(9);
											batch.draw(p1.getMainJoueur0().get(9), 1595f, 140f, 103f, 138f);
											if (cliqueJ1 >= 10) {
												p1Carte = p1.uneCartev2(10);
												batch.draw(p1.getMainJoueur0().get(10), 1625f, 110f, 103f, 138f);
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
			p2Carte = p2.uneCartev2(1);
			batch.draw(p2.getMainJoueur0().get(1), 740f, 140f, 103f, 138f);
			if (cliqueJ2 >= 2) {
				p2Carte = p2.uneCartev2(2);
				batch.draw(p2.getMainJoueur0().get(2), 770f, 110f, 103f, 138f);
				if (cliqueJ2 >= 3) {
					p2Carte = p2.uneCartev2(3);
					batch.draw(p2.getMainJoueur0().get(3), 800f, 80f, 103f, 138f);
					if (cliqueJ2 >= 4) {
						p2Carte = p2.uneCartev2(4);
						batch.draw(p2.getMainJoueur0().get(4), 520f, 172f, 103f, 138f);
						if (cliqueJ2 >= 5) {
							p2Carte = p2.uneCartev2(5);
							batch.draw(p2.getMainJoueur0().get(5), 550f, 140f, 103f, 138f);
							if (cliqueJ2 >= 6) {
								p2Carte = p2.uneCartev2(6);
								batch.draw(p2.getMainJoueur0().get(6), 580f, 110f, 103f, 138f);	
								if (cliqueJ2 >= 7) {
									p2Carte = p2.uneCartev2(7);
									batch.draw(p2.getMainJoueur0().get(7), 610f, 80f, 103f, 138f);
									if (cliqueJ2 >= 8) {
										p2Carte = p2.uneCartev2(8);
										batch.draw(p2.getMainJoueur0().get(8), 350f, 172f, 103f, 138f);
										if (cliqueJ2 >= 9) {
											p2Carte = p2.uneCartev2(9);
											batch.draw(p2.getMainJoueur0().get(9), 380f, 140f, 103f, 138f);
											if (cliqueJ2 >= 10) {
												p2Carte = p2.uneCartev2(10);
												batch.draw(p2.getMainJoueur0().get(10), 410f, 110f, 103f, 138f);
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
