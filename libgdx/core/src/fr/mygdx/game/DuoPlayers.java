package fr.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;

import fr.mygdx.game.splashscreen.MainMenu;

public class DuoPlayers implements Screen{
	private Stage stage;
	private SpriteBatch batch;
	private Texture BlackjackTable, JetonBleu, JetonRouge, JetonVert, JetonJaune, JetonBleuClair, JetonBeige, JetonBlanc, Lunes, YOUWIN, TIE, YOULOSE;
	private TextButton buttonQuit, buttonTirerJ1, buttonTirerJ2, buttonJouer, buttonMiser, buttonRedJeton, buttonGreenJeton, buttonBlueJeton, buttonYellowJeton;
	private BitmapFont black, white;
	private Table table, tableJeu, tableQuit, tableJeu2, tableRedJeton, tableGreenJeton, tableBlueJeton, tableYellowJeton;
	private TextureAtlas atlas, atlas2, atlas3, atlas4, atlas5, atlasLabel,atlasAnimRedJ,atlasAnimGreenJ, atlasAnimBlueJ, atlasAnimYellowJ, cards1,atlasAura;
	private Skin skin, skin2, skin3, skin4, skin5,skinLabel;
	private Music music;
	private Music pressbutton;
	private Label miseLabel;
	private int cliqueJ1, cliqueJ2, mise,red,green,blue,yellow, cliqueStop = 0;
	
	private Array<AtlasRegion> animationFrames , animationFramesCartes,animationFramesAura;
	public static Animation <TextureRegion> animRedJ, animGreenJ, animBlueJ, animYellowJ , animCartes,animAura;
	
	private Vector2 screenposRed = new Vector2(650f,380f);
	private Vector2 screenposGreen = new Vector2(850f,380f);
	private Vector2 screenposBlue = new Vector2(1250f,380f);
	private Vector2 screenposYellow = new Vector2(1050f,380f);
	private Vector2 screenPos = new Vector2(500f,500f);

	
	private float animTimeJetons1 , animTimeJetons2 , animTimeJetons3 , animTimeJetons4, animTimeAura , animTime1= 0f, animTime2= 0f,
			animTime3= 0f, animTime4= 0f, animTime5= 0f, animTime6= 0f, animTime7= 0f, animTime8= 0f, animTime9= 0f, animTime10= 0f, 
			animTime11= 0f, animTime12= 0f, animTime13= 0f, animTime14= 0f, animTime15= 0f, animTime16= 0f,
			animTime17= 0f, animTime18= 0f, animTime19= 0f ,animTime20= 0f,animTimeCroupier = 0f , animTimeDebut = 0f;
	private float totalAnimTime;
	
	private  BLACKJACKCity parent;
	private int lancement = 0;
	
	public DuoPlayers(BLACKJACKCity box2dTutorial){
		parent = box2dTutorial;
	}
	
	private ArrayList<Animation<TextureRegion>> animationPack;
	private Joueur[] joueurs = new Joueur[2];
	Deck paquet = new Deck(animationPack);
	//Deck paquetnom = new Deck(); Inutile pour l'instant
	Cartes p1 = new Cartes(paquet);
	
	private int p1Carte = 0;//, p2Carte = 0;
	
	@Override
	public void show() {
		batch = new SpriteBatch();
		BlackjackTable = new Texture("BlackjackTable DuoPlayers.png");
		Lunes = new Texture("shieldWhite_Edit.png");
		
		atlasAura = new TextureAtlas("AuraJetons/AnimAuraJetons.pack");
		atlasAnimRedJ = new TextureAtlas("ANIMREDJ/AnimRedJ.pack");
		atlasAnimGreenJ = new TextureAtlas("ANIMGREENJ/AnimGreenJ.pack");
		atlasAnimBlueJ = new TextureAtlas("ANIMBLUEJ/AnimBlueJ.pack");
		atlasAnimYellowJ = new TextureAtlas("ANIMYELLOWJ/AnimYellowJ.pack");
		atlas3 = new TextureAtlas("buttonjeton2/buttonGreen.pack");
		atlas4 = new TextureAtlas("buttonjeton3/buttonBlue.pack");
		atlas5 = new TextureAtlas("buttonjeton4/buttonYellow.pack");
		atlas2 = new TextureAtlas("buttonjeton/Buttonred.pack");
		atlas = new TextureAtlas("ui/button.pack");
		cards1 = new TextureAtlas("Anim/AsCarreau/AnimAsCarreau.pack");
		
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
		red = 0;
		green = 0;
		blue = 0;
		yellow = 0;
		Gdx.input.setInputProcessor(stage);
		
		totalAnimTime = 0.2f;
		animationFramesCartes = cards1.getRegions();
		animationFrames = atlasAnimRedJ.getRegions();
		animCartes = new Animation<TextureRegion> (totalAnimTime, animationFramesCartes);
		animRedJ = new Animation<TextureRegion> (totalAnimTime,animationFrames);
		animCartes.setPlayMode(Animation.PlayMode.NORMAL);
		animRedJ.setPlayMode(Animation.PlayMode.NORMAL);
		
		animTimeJetons1 = 0f;
		animTimeJetons2 = 0f;
		animTimeJetons3 = 0f;
		animTimeJetons4 = 0f;
		animTime1 = 0f;
		animTimeAura = 0f;
		
		animationFrames = atlasAnimGreenJ.getRegions();
		animGreenJ = new Animation<TextureRegion> (totalAnimTime,animationFrames);
		animGreenJ.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFrames = atlasAnimBlueJ.getRegions();
		animBlueJ = new Animation<TextureRegion> (totalAnimTime,animationFrames);
		animBlueJ.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFrames = atlasAnimYellowJ.getRegions();
		animYellowJ = new Animation<TextureRegion> (totalAnimTime,animationFrames);
		animYellowJ.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesAura = atlasAura.getRegions();
		animAura = new Animation<TextureRegion> (totalAnimTime, animationFramesAura);
		animAura.setPlayMode(Animation.PlayMode.NORMAL);
		
		YOUWIN = new Texture("YOUWIN.png");
		TIE = new Texture("TIE.png");
		YOULOSE = new Texture("YOULOSE.png");
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableQuit = new Table(skin);
		tableQuit.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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
				red += 1;
				table.removeActor(miseLabel);
				miseLabel = new Label( "Mise = "+mise , skinLabel );
				table.setPosition(500f, 500f, 0);
				table.add(miseLabel);
				table.pad(10,0,0,10);
				pressbutton.play();
				music.dispose();
			}
		});
		buttonRedJeton.pad(20f, 20f, 20f, 20f);
		
		buttonYellowJeton = new TextButton("100", textButtonStyle5);
		buttonYellowJeton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				mise += 100; 
				yellow += 1;
				table.removeActor(miseLabel);
				miseLabel = new Label( "Mise = "+mise , skinLabel );
				table.setPosition(500f, 500f, 0);
				table.add(miseLabel);
				table.pad(10,0,0,10);	
				pressbutton.play();
				music.dispose();
			}
		});
		buttonYellowJeton.pad(20f, 20f, 20f, 20f);
		
		buttonGreenJeton = new TextButton("200", textButtonStyle3);
		buttonGreenJeton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				mise += 200; 
				green += 1;
				table.removeActor(miseLabel);
				miseLabel = new Label( "Mise = "+mise , skinLabel );
				table.setPosition(500f, 500f, 0);
				table.add(miseLabel);
				table.pad(10,0,0,10);
				pressbutton.play();
				music.dispose();
			}
		});
		buttonGreenJeton.pad(20f, 20f, 20f, 20f);
		
		buttonBlueJeton = new TextButton("50", textButtonStyle4);
		buttonBlueJeton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				mise += 50; 
				blue += 1;
				table.removeActor(miseLabel);
				miseLabel = new Label( "Mise = "+mise , skinLabel );
				table.setPosition(500f, 500f, 0);
				table.add(miseLabel);
				table.pad(10,0,0,10);
				pressbutton.play();
				music.dispose();
			}
		});
		miseLabel = new Label( "Mise = "+mise , skinLabel );
		
		table.setPosition(500f, 500f, 0);
		table.add(miseLabel);
		table.pad(10,0,0,10);	
		
		buttonBlueJeton.pad(20f, 20f, 20f, 20f);
			
		tableQuit.setPosition(1700f, 600f, 0);
		tableQuit.add(buttonQuit);
		tableQuit.row();
			
		tableJeu.setPosition(220f, 600f, 0);
		tableJeu.add(buttonJouer);
		table.row();
			
		tableJeu2.setPosition(220f, 600f, 0);
		
		tableRedJeton.setPosition(650f,380f, 0);
		tableRedJeton.add(buttonRedJeton);

		
		tableGreenJeton.setPosition(850f,380f, 0);
		tableGreenJeton.add(buttonGreenJeton);
	
		
		tableBlueJeton.setPosition(1250f,380f, 0);
		tableBlueJeton.add(buttonBlueJeton);
		
		tableYellowJeton.setPosition(1050f,380f, 0);
		tableYellowJeton.add(buttonYellowJeton);
		
		
		stage.addActor(table);
		stage.addActor(tableQuit);
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
			p1.initialisation2();
			//p2.initialisation();
			p1.maindep();
			//p2.maindep();
			p1.croupierdep();
			//p1.tirerjoueur();
			//p2.maindep();
			p1.croupiertirer();
	    	p1.gagnantbis();
	    	//p2.gagnant();
		}
		lancement++;
		
		batch.begin();
		batch.draw(BlackjackTable, 0,   0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(Lunes,990f,330f, 110, 110);
		if (buttonJouer.isChecked()) {
			//p1Carte = p1.uneCartev2(0);
			animTimeDebut += Gdx.graphics.getDeltaTime();
			animTimeCroupier += Gdx.graphics.getDeltaTime();
			batch.draw(p1.getMainJoueur(0).get(0).getKeyFrame(animTimeDebut, false), 713f, 168f, 103f, 138f);
			//p2Carte = p2.uneCartev2(0);
			batch.draw(p1.getMainJoueur(1).get(0).getKeyFrame(animTimeDebut, false), 1125f, 168f, 103f, 138f); 
			batch.draw(p1.afficheMainCroupierNom().get(0).getKeyFrame(animTimeCroupier, false), 800f, 500f, 103f, 138f); //1ere Carte Croupier
			batch.draw(JetonVert, 737f, 1005f, 65f, 29f);
			batch.draw(JetonRouge, 807f, 1005f, 65f, 29f);
			batch.draw(JetonBeige, 880f, 1005f, 65f, 29f);
			batch.draw(JetonBleu, 953f, 1005f, 65f, 29f);
			batch.draw(JetonBleuClair, 1026f, 1005f, 65f, 29f);
			batch.draw(JetonJaune, 1103f, 1005f, 65f, 29f);
			batch.draw(JetonBlanc, 1175f, 1005f, 65f, 29f);
			/*if (cliqueStop == 1 && p1.gagnant(0) == 0) {
				batch.draw(YOUWIN, 550f, 400f, 840f, 411f);
				cliqueStop = 0;
			}
			else if (cliqueStop == 1 && p1.gagnant(0) == 1) {
				batch.draw(TIE, 550f, 440f, 208f, 243f);
				cliqueStop = 0;
			}
			else if (cliqueStop == 1 && p1.gagnant(0) == 2) {
				batch.draw(YOULOSE, 550f, 440f, 860f, 401f);
				cliqueStop = 0;
			}*/
		}
		
			
		
		if (cliqueJ1 >= 1) {
			//p1Carte = p1.joueuri(0).get(1);
			animTime1 += Gdx.graphics.getDeltaTime();
			batch.draw(p1.getMainJoueur(0).get(1).getKeyFrame(animTime1, false),  screenPos.x ,screenPos.y);
			if (cliqueJ1 >= 2) {
				//p1Carte = p1.uneCartev2(2);
				animTime2 += Gdx.graphics.getDeltaTime();
				batch.draw(p1.getMainJoueur(0).get(2).getKeyFrame(animTime2, false), 1185f, 110f, 103f, 138f);
				if (cliqueJ1 >= 3) {
					//p1Carte = p1.uneCartev2(3);
					animTime3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.getMainJoueur(0).get(3).getKeyFrame(animTime3, false), 1215f, 80f, 103f, 138f);
					if (cliqueJ1 >= 4) {
						//p1Carte = p1.uneCartev2(4);
						animTime4 += Gdx.graphics.getDeltaTime();
						batch.draw(p1.getMainJoueur(0).get(4).getKeyFrame(animTime4, false), 1345f, 168f, 103f, 138f);
						if (cliqueJ1 >= 5) {
							//p1Carte = p1.uneCartev2(5);
							animTime5 += Gdx.graphics.getDeltaTime();
							batch.draw(p1.getMainJoueur(0).get(5).getKeyFrame(animTime5, false), 1375f, 140f, 103f, 138f);
							if (cliqueJ1 >= 6) {
								//p1Carte = p1.uneCartev2(6);
								animTime6 += Gdx.graphics.getDeltaTime();
								batch.draw(p1.getMainJoueur(0).get(6).getKeyFrame(animTime6, false), 1405f, 110f, 103f, 138f);
								if (cliqueJ1 >= 7) {
									//p1Carte = p1.uneCartev2(7);
									animTime7 += Gdx.graphics.getDeltaTime();
									batch.draw(p1.getMainJoueur(0).get(7).getKeyFrame(animTime7, false), 1435f, 80f, 103f, 138f);
									if (cliqueJ1 >= 8) {
										//p1Carte = p1.uneCartev2(8);
										animTime8 += Gdx.graphics.getDeltaTime();
										batch.draw(p1.getMainJoueur(0).get(8).getKeyFrame(animTime8, false), 1565f, 168f, 103f, 138f);
										if (cliqueJ1 >= 9) {
											//p1Carte = p1.uneCartev2(9);
											animTime9 += Gdx.graphics.getDeltaTime();
											batch.draw(p1.getMainJoueur(0).get(9).getKeyFrame(animTime9, false), 1595f, 140f, 103f, 138f);
											if (cliqueJ1 >= 10) {
												//p1Carte = p1.uneCartev2(10);
												animTime10 += Gdx.graphics.getDeltaTime();
												batch.draw(p1.getMainJoueur(0).get(10).getKeyFrame(animTime10, false), 1625f, 110f, 103f, 138f);
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
			//p2Carte = p2.uneCartev2(1);
			batch.draw(p1.getMainJoueur(1).get(1).getKeyFrame(animTime11, false), 740f, 140f, 103f, 138f);
			if (cliqueJ2 >= 2) {
				//p2Carte = p2.uneCartev2(2);
				batch.draw(p1.getMainJoueur(1).get(2).getKeyFrame(animTime12, false), 770f, 110f, 103f, 138f);
				if (cliqueJ2 >= 3) {
					//p2Carte = p2.uneCartev2(3);
					batch.draw(p1.getMainJoueur(1).get(3).getKeyFrame(animTime13, false), 800f, 80f, 103f, 138f);
					if (cliqueJ2 >= 4) {
						//p2Carte = p2.uneCartev2(4);
						batch.draw(p1.getMainJoueur(1).get(4).getKeyFrame(animTime14, false), 520f, 168f, 103f, 138f);
						if (cliqueJ2 >= 5) {
							//p2Carte = p2.uneCartev2(5);
							batch.draw(p1.getMainJoueur(1).get(5).getKeyFrame(animTime15, false), 550f, 140f, 103f, 138f);
							if (cliqueJ2 >= 6) {
								//p2Carte = p2.uneCartev2(6);
								batch.draw(p1.getMainJoueur(1).get(6).getKeyFrame(animTime16, false), 580f, 110f, 103f, 138f);	
								if (cliqueJ2 >= 7) {
									//p2Carte = p2.uneCartev2(7);
									batch.draw(p1.getMainJoueur(1).get(7).getKeyFrame(animTime17, false), 610f, 80f, 103f, 138f);
									if (cliqueJ2 >= 8) {
										//p2Carte = p2.uneCartev2(8);
										batch.draw(p1.getMainJoueur(1).get(8).getKeyFrame(animTime18, false), 350f, 168f, 103f, 138f);
										if (cliqueJ2 >= 9) {
											//p2Carte = p2.uneCartev2(9);
											batch.draw(p1.getMainJoueur(1).get(9).getKeyFrame(animTime19, false), 380f, 140f, 103f, 138f);
											if (cliqueJ2 >= 10) {
												//p2Carte = p2.uneCartev2(10);
												batch.draw(p1.getMainJoueur(1).get(10).getKeyFrame(animTime20, false), 410f, 110f, 103f, 138f);
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
		for(int i=0; i < red;i++){
		batch.begin();
		animTimeAura += Gdx.graphics.getDeltaTime();
		batch.draw(animAura.getKeyFrame(animTimeAura,false) ,500f ,500f);
		animTimeJetons1 += Gdx.graphics.getDeltaTime();
		batch.draw(animRedJ.getKeyFrame(animTimeJetons1, false), screenposRed.x, screenposRed.y);
		batch.end();	
		}
		
		if(red >= 1 && screenposRed.x <= 660) {
			screenposRed.x += 5;
		}
		if(red >= 1 && screenposRed.y <= 660) {
			screenposRed.y += 5;
		}

		for(int i=0; i < green;i++){
			batch.begin();
			animTimeJetons2 += Gdx.graphics.getDeltaTime();
			batch.draw(animGreenJ.getKeyFrame(animTimeJetons2, false), screenposGreen.x, screenposGreen.y);
			batch.end();	
		}
		
		if(green >= 1 && screenposGreen.x <= 660) {
			screenposGreen.x += 5;
		}
		if(green >= 1 && screenposGreen.y <= 660) {
				screenposGreen.y += 5;
		}
	
		for(int i=0; i < blue;i++){
			batch.begin();
			animTimeJetons3 += Gdx.graphics.getDeltaTime();
			batch.draw(animBlueJ.getKeyFrame(animTimeJetons3, false), screenposBlue.x, screenposBlue.y);
			batch.end();	
		}
			
		if(blue >= 1 && screenposBlue.x <= 660) {
			screenposBlue.x += 5;
		}
		if(blue >= 1 && screenposBlue.y <= 660) {
			screenposBlue.y += 5;
		}
		
		for(int i=0; i < yellow;i++){
		batch.begin();
		animTimeJetons4 += Gdx.graphics.getDeltaTime();
		batch.draw(animYellowJ.getKeyFrame(animTimeJetons4, false), screenposYellow.x, screenposYellow.y);
		batch.end();	
		}
				
		if(yellow >= 1 && screenposYellow.x <= 660) {
			screenposYellow.x += 5;
		}
		if(yellow >= 1 && screenposYellow.y <= 660) {
			screenposYellow.y += 5;
		}		
		
		if(cliqueJ1 >= 1 && screenPos.x <= 1125f ) {
			screenPos.x += 8;
		}
		
		if(cliqueJ1 >= 1 && screenPos.y >= 140f) {
			screenPos.y -= 5;
		}

			
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
