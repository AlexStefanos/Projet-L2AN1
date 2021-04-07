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
	
	private float animTimeBis = 0f , animTime1 = 0f  , animTime2 = 0f  , animTime3 = 0f  , animTime4 = 0f  , animTimeCroupier = 0f ,
			animTime5 = 0f  ,animTime6 = 0f  ,animTime7 = 0f  ,animTime8 = 0f  ,animTime9 = 0f ,animTime10 = 0f,animTime11 = 0f ;
	private float totalAnimTime;
	
	public SinglePlayer(BLACKJACKCity box2dTutorial) {
		parent = box2dTutorial;
	}
	private ArrayList<Animation<TextureRegion>> animationPack;
	private Joueur[] joueurs = new Joueur[1];
	Deck paquet = new Deck(animationPack);
	//Deck paquetnom = new Deck(); Inutile pour l'instant
	Cartes p1 = new Cartes(paquet);
	static int ADDCARTE = 0;
	
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
		//animTime = 0f;
		//animTimeBis = 0f;
		//animTimeCroupier = 0f;
		
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
				ADDCARTE = 1;
				p1.tirerjoueur(0);
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
				ADDCARTE = 1;
				p1.tirerjoueur(0);
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
			p1.croupierdep();
			p1.croupiertirer();
	    	p1.gagnant();
		}
		lancement++;
		
		batch.begin();
		batch.draw(BlackjackTable, 0, 0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		if (buttonJouer.isChecked()) {
			animTime1 += Gdx.graphics.getDeltaTime();
			batch.draw(p1.getMainJoueur0().get(0).getKeyFrame(animTime1, false), 920f, 172f, 103f, 138f);
		}
		animTimeCroupier = Gdx.graphics.getDeltaTime();
		batch.draw(p1.afficheMainCroupierNom().get(0).getKeyFrame(animTimeCroupier, true), 800f, 500f, 103f, 138f); //1ere Carte Croupier
		batch.draw(JetonVert, 737f, 1005f, 65f, 29f);
		batch.draw(JetonRouge, 807f, 1005f, 65f, 29f);
		batch.draw(JetonBeige, 880f, 1005f, 65f, 29f);
		batch.draw(JetonBleu, 953f, 1005f, 65f, 29f);
		batch.draw(JetonBleuClair, 1026f, 1005f, 65f, 29f);
		batch.draw(JetonJaune, 1103f, 1005f, 65f, 29f);
		batch.draw(JetonBlanc, 1175f, 1005f, 65f, 29f);	
		if (clique >= 1 && p1.getSize() > 0) {
			animTime2 += Gdx.graphics.getDeltaTime();
			batch.draw(p1.getMainJoueur0().get(1).getKeyFrame(animTime2, false), 950f, 140f, 103f, 138f);
		}
		if (clique >= 2 && p1.getSize() > 1) {
			animTime3 += Gdx.graphics.getDeltaTime();
			batch.draw(p1.getMainJoueur0().get(2).getKeyFrame(animTime3, false), 980f, 110f, 103f, 138f);
		}
		if (clique >= 3 && p1.getSize() > 2) {
			animTime4 += Gdx.graphics.getDeltaTime();
			batch.draw(p1.getMainJoueur0().get(3).getKeyFrame(animTime4, false), 1010f, 80f, 103f, 138f);
		}
		if (clique >= 4 && p1.getSize() > 3) {
			animTime5 += Gdx.graphics.getDeltaTime();
			batch.draw(p1.getMainJoueur0().get(4).getKeyFrame(animTime5, false), 1200f, 172f, 103f, 138f);
		}
		if (clique >= 5 && p1.getSize() > 4) {
			animTime6 += Gdx.graphics.getDeltaTime();
			batch.draw(p1.getMainJoueur0().get(5).getKeyFrame(animTime6, false), 1230f, 140f, 103f, 138f);
		}
		if (clique >= 6 && p1.getSize() > 5) {
			animTime7 += Gdx.graphics.getDeltaTime();
			batch.draw(p1.getMainJoueur0().get(6).getKeyFrame(animTime7, false), 1260f, 110f, 103f, 138f);
		}
		if (clique >= 7 && p1.getSize() > 6) {
			animTime8 += Gdx.graphics.getDeltaTime();
			batch.draw(p1.getMainJoueur0().get(7).getKeyFrame(animTime8, false), 1290f, 80f, 103f, 138f);
		}
		if (clique >= 8 && p1.getSize() > 7) {
			animTime9 += Gdx.graphics.getDeltaTime();
			batch.draw(p1.getMainJoueur0().get(8).getKeyFrame(animTime9, false), 1480f, 172f, 103f, 138f);
		}
		if (clique >= 9 && p1.getSize() > 8) {
			animTime10 += Gdx.graphics.getDeltaTime();
			batch.draw(p1.getMainJoueur0().get(9).getKeyFrame(animTime10, false), 1510f, 140f, 103f, 138f);
		}
		if (clique >= 10 && p1.getSize() > 9) {
			animTime11 += Gdx.graphics.getDeltaTime();
			batch.draw(p1.getMainJoueur0().get(10).getKeyFrame(animTime11, false), 1540f, 110f, 103f, 138f);
		}
		batch.end();

		batch.begin();
		animTimeBis += Gdx.graphics.getDeltaTime();
		batch.draw(anim1.getKeyFrame(animTimeBis, true), 150 ,150 );
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
