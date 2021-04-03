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
	private Texture BlackjackTable, FondCarteBleu, AsTrefle, DeuxTrefle, TroisTrefle, QuatreTrefle, CinqTrefle, SixTrefle, 
	SeptTrefle, HuitTrefle, NeufTrefle, DixTrefle, ValetTrefle, DameTrefle, RoiTrefle, AsCarreau, DeuxCarreau, TroisCarreau, QuatreCarreau, 
	CinqCarreau, SixCarreau, SeptCarreau, HuitCarreau, NeufCarreau, DixCarreau, ValetCarreau, DameCarreau, RoiCarreau, AsCoeur, DeuxCoeur, TroisCoeur,
	QuatreCoeur, CinqCoeur, SixCoeur, SeptCoeur, HuitCoeur, NeufCoeur, DixCoeur, ValetCoeur, DameCoeur, RoiCoeur, AsPique, DeuxPique, 
	TroisPique, QuatrePique, CinqPique, SixPique, SeptPique, HuitPique, NeufPique, DixPique, ValetPique, DamePique, RoiPique, JokerBlack, 
	JokerRed, JetonBleu, JetonRouge, JetonVert, JetonJaune, JetonBleuClair, JetonBeige, JetonBlanc;
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
	
	public SinglePlayer(BLACKJACKCity box2dTutorial){
		parent = box2dTutorial;
	}
	
	Deck paquet = new Deck();
	//Deck paquetnom = new Deck(); Inutile pour l'instant
	Cartes p1 = new Cartes(paquet);
	private int p1Carte = 0;
	private ArrayList<Texture> texturespack = new ArrayList<Texture>();
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
		AsCarreau = new Texture("Large/Diamond 1.png");
		DeuxCarreau = new Texture("Large/Diamond 2.png");
		TroisCarreau = new Texture("Large/Diamond 3.png");
		QuatreCarreau = new Texture("Large/Diamond 4.png");
		CinqCarreau = new Texture("Large/Diamond 5.png");
		SixCarreau = new Texture("Large/Diamond 6.png");
		SeptCarreau = new Texture("Large/Diamond 7.png");
		HuitCarreau = new Texture("Large/Diamond 8.png");
		NeufCarreau = new Texture("Large/Diamond 9.png");
		DixCarreau = new Texture("Large/Diamond 10.png");
		ValetCarreau = new Texture("Large/Diamond 11.png");
		DameCarreau = new Texture("Large/Diamond 12.png");
		RoiCarreau = new Texture("Large/Diamond 13.png");
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
			paquet.conversion();
    		//paquetnom = paquet;
    		//paquetnom.creation();
    		//paquetnom.creationn();
			p1.maindep();
			p1.initialisation();
			p1.croupierdep(); 
			p1.tirerjoueur();
			p1.croupiertirer();
	    	p1.gagnant();
		}
		lancement++;
		
		batch.begin();
		batch.draw(BlackjackTable, 0,   0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		if (buttonJouer.isChecked()) {
			p1Carte = p1.uneCartev2(0);
			batch.draw(texturespack.get(p1Carte), 920f, 172f, 103f, 138f);
		}
		batch.draw(AsCoeur, 800f, 500f, 103f, 138f); //1ere Carte Croupier
		batch.draw(JetonVert, 737f, 1005f, 65f, 29f);
		batch.draw(JetonRouge, 807f, 1005f, 65f, 29f);
		batch.draw(JetonBeige, 880f, 1005f, 65f, 29f);
		batch.draw(JetonBleu, 953f, 1005f, 65f, 29f);
		batch.draw(JetonBleuClair, 1026f, 1005f, 65f, 29f);
		batch.draw(JetonJaune, 1103f, 1005f, 65f, 29f);
		batch.draw(JetonBlanc, 1175f, 1005f, 65f, 29f);	
		if (clique >= 1) {
			p1Carte = p1.uneCartev2(1);
			batch.draw(texturespack.get(p1Carte), 950f, 140f, 103f, 138f);
			if (clique >=2) {
				p1Carte = p1.uneCartev2(2);
				batch.draw(texturespack.get(p1Carte), 980f, 110f, 103f, 138f);
				if (clique >= 3) {
					p1Carte = p1.uneCartev2(3);
					batch.draw(texturespack.get(p1Carte), 1010f, 80f, 103f, 138f);
					if (clique >= 4) {
						p1Carte = p1.uneCartev2(4);
						batch.draw(texturespack.get(p1Carte), 1200f, 172f, 103f, 138f);
						if (clique >= 5) {
							p1Carte = p1.uneCartev2(5);
							batch.draw(texturespack.get(p1Carte), 1230f, 140f, 103f, 138f);
							if (clique >= 6) {
								p1Carte = p1.uneCartev2(6);
								batch.draw(texturespack.get(p1Carte), 1260f, 110f, 103f, 138f);
								if (clique >= 7) {
									p1Carte = p1.uneCartev2(7);
									batch.draw(texturespack.get(p1Carte), 1290f, 80f, 103f, 138f);
									if (clique >= 8) {
										p1Carte = p1.uneCartev2(8);
										batch.draw(texturespack.get(p1Carte), 1480f, 172f, 103f, 138f);
										if (clique >= 9){
											p1Carte = p1.uneCartev2(9);
											batch.draw(texturespack.get(p1Carte), 1510f, 140f, 103f, 138f);
											if (clique >= 10) {
												p1Carte = p1.uneCartev2(10);
												batch.draw(texturespack.get(p1Carte), 1540f, 110f, 103f, 138f);
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
