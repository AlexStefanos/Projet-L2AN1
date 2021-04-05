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
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;

import fr.mygdx.game.splashscreen.MainMenu;

public class SinglePlayer implements Screen {

	private Stage stage;
	private SpriteBatch batch;
	private Texture BlackjackTable, JetonBleu, JetonRouge, JetonVert, JetonJaune, JetonBleuClair, JetonBeige, JetonBlanc;
	private TextButton buttonQuit, buttonTirer, buttonJouer, buttonMiser;
	private BitmapFont black, white;
	private Table table, tableJeu;
	private int lancement = 0;
	
	private TextureAtlas atlas, atlas2;
	private Array<AtlasRegion> animationFrames;
	public static Animation <TextureRegion> anim1;
	
	private Skin skin;
	private Music music;
	private Music pressbutton;
	private int clique;
	private  BLACKJACKCity parent;
	
	private float animTime;
	private float totalAnimTime;
	
	public SinglePlayer(BLACKJACKCity box2dTutorial) {
		parent = box2dTutorial;
	}
	private ArrayList<Texture> texturespack;
	Deck paquet = new Deck(texturespack);
	//Deck paquetnom = new Deck(); Inutile pour l'instant
	Cartes p1 = new Cartes(paquet);
	private int p1Carte = 0;
	
	//private CardsTextures hey = new CardsTextures(texturespack); On s'en sert jamais mais Alex l'a peut être mis pour quelque chose donc je supprime pas (c'est beaucoup trop long comme explication)
	static int pushButton = 0;
	
	@Override
	public void show() {
		totalAnimTime = 0.1f;
		
		batch = new SpriteBatch();
		
		BlackjackTable = new Texture("BlackjackTable SinglePlayer.png");
		
		atlas = new TextureAtlas("ui/button.pack");
		atlas2 = new TextureAtlas(Gdx.files.internal("AsTrefle/test.pack"));
		
		animationFrames = atlas2.getRegions();
		anim1 = new Animation<TextureRegion> (totalAnimTime,animationFrames);
		anim1.setPlayMode(Animation.PlayMode.NORMAL);
		animTime = 0f;
		
		stage = new Stage();
		skin = new Skin(atlas);
		clique = 0;
		Gdx.input.setInputProcessor(stage);
	
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableJeu = new Table(skin);
		tableJeu.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	
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
				clique++;
			}
		});
			
		table.setPosition(1700f, 600f, 0);
		table.add(buttonQuit);
		
		tableJeu.setPosition(220f, 600f, 0);
		tableJeu.add(buttonJouer);
	
		stage.addActor(table);
		stage.addActor(tableJeu);
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
			p1.maindep();
			p1.croupierdep(); 
			p1.tirerjoueur();
			p1.croupiertirer();
	    	p1.gagnant();
		}
		lancement++;
		
		batch.begin();
		batch.draw(BlackjackTable, 0, 0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		if (buttonJouer.isChecked()) {
			p1Carte = p1.uneCartev2(0);
			batch.draw(p1.getMainsNom().get(0), 920f, 172f, 103f, 138f);
		}
		batch.draw(p1.afficheMainCroupierNom().get(0), 800f, 500f, 103f, 138f); //1ere Carte Croupier
		batch.draw(JetonVert, 737f, 1005f, 65f, 29f);
		batch.draw(JetonRouge, 807f, 1005f, 65f, 29f);
		batch.draw(JetonBeige, 880f, 1005f, 65f, 29f);
		batch.draw(JetonBleu, 953f, 1005f, 65f, 29f);
		batch.draw(JetonBleuClair, 1026f, 1005f, 65f, 29f);
		batch.draw(JetonJaune, 1103f, 1005f, 65f, 29f);
		batch.draw(JetonBlanc, 1175f, 1005f, 65f, 29f);	
		if (clique >= 1) {
			p1Carte = p1.uneCartev2(1);
			batch.draw(p1.getMainsNom().get(1), 950f, 140f, 103f, 138f);
			if (clique >= 2 /*&& p1.uneCartev2(2) pour verifier l'existence de la carte => gestionnaire d'erreurs*/) {
				p1Carte = p1.uneCartev2(2);
				batch.draw(p1.getMainsNom().get(2), 980f, 110f, 103f, 138f);
				if (clique >= 3) {
					p1Carte = p1.uneCartev2(3);
					batch.draw(p1.getMainsNom().get(3), 1010f, 80f, 103f, 138f);
					if (clique >= 4) {
						p1Carte = p1.uneCartev2(4);
						batch.draw(p1.getMainsNom().get(4), 1200f, 172f, 103f, 138f);
						if (clique >= 5) {
							p1Carte = p1.uneCartev2(5);
							batch.draw(p1.getMainsNom().get(5), 1230f, 140f, 103f, 138f);
							if (clique >= 6) {
								p1Carte = p1.uneCartev2(6);
								batch.draw(p1.getMainsNom().get(6), 1260f, 110f, 103f, 138f);
								if (clique >= 7) {
									p1Carte = p1.uneCartev2(7);
									batch.draw(p1.getMainsNom().get(7), 1290f, 80f, 103f, 138f);
									if (clique >= 8) {
										p1Carte = p1.uneCartev2(8);
										batch.draw(p1.getMainsNom().get(8), 1480f, 172f, 103f, 138f);
										if (clique >= 9){
											p1Carte = p1.uneCartev2(9);
											batch.draw(p1.getMainsNom().get(9), 1510f, 140f, 103f, 138f);
											if (clique >= 10) {
												p1Carte = p1.uneCartev2(10);
												batch.draw(p1.getMainsNom().get(10), 1540f, 110f, 103f, 138f);
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

		batch.begin();
		animTime += Gdx.graphics.getDeltaTime();
		batch.draw(anim1.getKeyFrame(animTime, true), 150 ,150 );
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
