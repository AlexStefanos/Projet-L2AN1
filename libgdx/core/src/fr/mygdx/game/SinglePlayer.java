package fr.mygdx.game;

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
	Deck paquetnom = new Deck();
	Cartes p1 = new Cartes(paquet);
	
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
			paquet.generateur();
    		paquet.shuffle();
    		paquetnom = paquet;
    		paquet.conversion();
    		//paquetnom.creation();
    		paquetnom.creationn();
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
			if (buttonJouer.isChecked()) {
				if (p1.uneCarte(0) == "AsCoeur") {
					batch.draw(AsCoeur, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "DeuxCoeur") {
					batch.draw(DeuxCoeur, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "TroisCoeur") {
					batch.draw(TroisCoeur, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "QuatreCoeur") {
					batch.draw(QuatreCoeur, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "CinqCoeur") {
					batch.draw(CinqCoeur, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "SixCoeur") {
					batch.draw(SixCoeur, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "SeptCoeur") {
					batch.draw(SeptCoeur, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "HuitCoeur") {
					batch.draw(HuitCoeur, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "NeufCoeur") {
					batch.draw(NeufCoeur, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "DixCoeur") {
					batch.draw(DixCoeur, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "ValetCoeur") {
					batch.draw(ValetCoeur, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "DameCoeur") {
					batch.draw(DameCoeur, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "RoiCoeur") {
					batch.draw(RoiCoeur, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "AsPique") {
					batch.draw(AsPique, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "DeuxPique") {
					batch.draw(DeuxPique, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "TroisPique") {
					batch.draw(TroisPique, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "QuatrePique") {
					batch.draw(QuatrePique, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "CinqPique") {
					batch.draw(CinqPique, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "SixPique") {
					batch.draw(SixPique, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "SeptPique") {
					batch.draw(SeptPique, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "HuitPique") {
					batch.draw(HuitPique, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "NeufPique") {
					batch.draw(NeufPique, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "DixPique") {
					batch.draw(DixPique, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "ValetPique") {
					batch.draw(ValetPique, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "DamePique") {
					batch.draw(DamePique, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "RoiPique") {
					batch.draw(RoiPique, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "AsTrefle") {
					batch.draw(AsTrefle, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "DeuxTrefle") {
					batch.draw(DeuxTrefle, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "TroisTrefle") {
					batch.draw(TroisTrefle, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "QuatreTrefle") {
					batch.draw(QuatreTrefle, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "CinqTrefle") {
					batch.draw(CinqTrefle, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "SixTrefle") {
					batch.draw(SixTrefle, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "SeptTrefle") {
					batch.draw(SeptTrefle, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "HuitTrefle") {
					batch.draw(HuitTrefle, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "NeufTrefle") {
					batch.draw(NeufTrefle, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "DixTrefle") {
					batch.draw(DixTrefle, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "ValetTrefle") {
					batch.draw(ValetTrefle, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "DameTrefle") {
					batch.draw(DameTrefle, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "RoiTrefle") {
					batch.draw(RoiTrefle, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "AsCarreau") {
					batch.draw(AsCarreau, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "DeuxCarreau") {
					batch.draw(DeuxCarreau, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "TroisCarreau") {
					batch.draw(TroisCarreau, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "QuatreCarreau") {
					batch.draw(QuatreCarreau, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "CinqCarreau") {
					batch.draw(CinqCarreau, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "SixCarreau") {
					batch.draw(SixCarreau, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "SeptCarreau") {
					batch.draw(SeptCarreau, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "HuitCarreau") {
					batch.draw(HuitCarreau, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "NeufCarreau") {
					batch.draw(NeufCarreau, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "DixCarreau") {
					batch.draw(DixCarreau, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "ValetCarreau") {
					batch.draw(ValetCarreau, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "DameCarreau") {
					batch.draw(DameCarreau, 920f, 172f, 103f, 138f);
				}
				else if (p1.uneCarte(0) == "RoiCarreau") {
					batch.draw(RoiCarreau, 920f, 172f, 103f, 138f);
				}
			}
			batch.draw(AsCoeur, 800f, 500f, 103f, 138f); //1ere Carte Croupier
			batch.draw(JetonVert, 737f, 1005f, 65f, 29f);
			batch.draw(JetonRouge, 807f, 1005f, 65f, 29f);
			batch.draw(JetonBeige, 880f, 1005f, 65f, 29f);
			batch.draw(JetonBleu, 953f, 1005f, 65f, 29f);
			batch.draw(JetonBleuClair, 1026f, 1005f, 65f, 29f);
			batch.draw(JetonJaune, 1103f, 1005f, 65f, 29f);
			batch.draw(JetonBlanc, 1175f, 1005f, 65f, 29f);
		}
		
		if (clique >= 1) {
			if (p1.uneCarte(1) == "AsCoeur") {
				batch.draw(AsCoeur, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "DeuxCoeur") {
				batch.draw(DeuxCoeur, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "TroisCoeur") {
				batch.draw(TroisCoeur, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "QuatreCoeur") {
				batch.draw(QuatreCoeur, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "CinqCoeur") {
				batch.draw(CinqCoeur, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "SixCoeur") {
				batch.draw(SixCoeur, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "SeptCoeur") {
				batch.draw(SeptCoeur, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "HuitCoeur") {
				batch.draw(HuitCoeur, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "NeufCoeur") {
				batch.draw(NeufCoeur, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "DixCoeur") {
				batch.draw(DixCoeur, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "ValetCoeur") {
				batch.draw(ValetCoeur, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "DameCoeur") {
				batch.draw(DameCoeur, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "RoiCoeur") {
				batch.draw(RoiCoeur, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "AsPique") {
				batch.draw(AsPique, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "DeuxPique") {
				batch.draw(DeuxPique, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "TroisPique") {
				batch.draw(TroisPique, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "QuatrePique") {
				batch.draw(QuatrePique, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "CinqPique") {
				batch.draw(CinqPique, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "SixPique") {
				batch.draw(SixPique, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "SeptPique") {
				batch.draw(SeptPique, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "HuitPique") {
				batch.draw(HuitPique, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "NeufPique") {
				batch.draw(NeufPique, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "DixPique") {
				batch.draw(DixPique, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "ValetPique") {
				batch.draw(ValetPique, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "DamePique") {
				batch.draw(DamePique, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "RoiPique") {
				batch.draw(RoiPique, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "AsTrefle") {
				batch.draw(AsTrefle, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "DeuxTrefle") {
				batch.draw(DeuxTrefle, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "TroisTrefle") {
				batch.draw(TroisTrefle, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "QuatreTrefle") {
				batch.draw(QuatreTrefle, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "CinqTrefle") {
				batch.draw(CinqTrefle, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "SixTrefle") {
				batch.draw(SixTrefle, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "SeptTrefle") {
				batch.draw(SeptTrefle, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "HuitTrefle") {
				batch.draw(HuitTrefle, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "NeufTrefle") {
				batch.draw(NeufTrefle, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "DixTrefle") {
				batch.draw(DixTrefle, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "ValetTrefle") {
				batch.draw(ValetTrefle, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "DameTrefle") {
				batch.draw(DameTrefle, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "RoiTrefle") {
				batch.draw(RoiTrefle, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "AsCarreau") {
				batch.draw(AsCarreau, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "DeuxCarreau") {
				batch.draw(DeuxCarreau, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "TroisCarreau") {
				batch.draw(TroisCarreau, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "QuatreCarreau") {
				batch.draw(QuatreCarreau, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "CinqCarreau") {
				batch.draw(CinqCarreau, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "SixCarreau") {
				batch.draw(SixCarreau, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "SeptCarreau") {
				batch.draw(SeptCarreau, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "HuitCarreau") {
				batch.draw(HuitCarreau, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "NeufCarreau") {
				batch.draw(NeufCarreau, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "DixCarreau") {
				batch.draw(DixCarreau, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "ValetCarreau") {
				batch.draw(ValetCarreau, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "DameCarreau") {
				batch.draw(DameCarreau, 950f, 140f, 103f, 138f);
			}
			else if (p1.uneCarte(1) == "RoiCarreau") {
				batch.draw(RoiCarreau, 950f, 140f, 103f, 138f);
			}
			if (clique >=2) {
				if (p1.uneCarte(2) == "AsCoeur") {
					batch.draw(AsCoeur, 920f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "DeuxCoeur") {
					batch.draw(DeuxCoeur, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "TroisCoeur") {
					batch.draw(TroisCoeur, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "QuatreCoeur") {
					batch.draw(QuatreCoeur, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "CinqCoeur") {
					batch.draw(CinqCoeur, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "SixCoeur") {
					batch.draw(SixCoeur, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "SeptCoeur") {
					batch.draw(SeptCoeur, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "HuitCoeur") {
					batch.draw(HuitCoeur, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "NeufCoeur") {
					batch.draw(NeufCoeur, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "DixCoeur") {
					batch.draw(DixCoeur, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "ValetCoeur") {
					batch.draw(ValetCoeur, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "DameCoeur") {
					batch.draw(DameCoeur, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "RoiCoeur") {
					batch.draw(RoiCoeur, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "AsPique") {
					batch.draw(AsPique, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "DeuxPique") {
					batch.draw(DeuxPique, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "TroisPique") {
					batch.draw(TroisPique, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "QuatrePique") {
					batch.draw(QuatrePique, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "CinqPique") {
					batch.draw(CinqPique, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "SixPique") {
					batch.draw(SixPique, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "SeptPique") {
					batch.draw(SeptPique, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "HuitPique") {
					batch.draw(HuitPique, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "NeufPique") {
					batch.draw(NeufPique, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "DixPique") {
					batch.draw(DixPique, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "ValetPique") {
					batch.draw(ValetPique, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "DamePique") {
					batch.draw(DamePique, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "RoiPique") {
					batch.draw(RoiPique, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "AsTrefle") {
					batch.draw(AsTrefle, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "DeuxTrefle") {
					batch.draw(DeuxTrefle, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "TroisTrefle") {
					batch.draw(TroisTrefle, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "QuatreTrefle") {
					batch.draw(QuatreTrefle, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "CinqTrefle") {
					batch.draw(CinqTrefle, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "SixTrefle") {
					batch.draw(SixTrefle, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "SeptTrefle") {
					batch.draw(SeptTrefle, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "HuitTrefle") {
					batch.draw(HuitTrefle, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "NeufTrefle") {
					batch.draw(NeufTrefle, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "DixTrefle") {
					batch.draw(DixTrefle, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "ValetTrefle") {
					batch.draw(ValetTrefle, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "DameTrefle") {
					batch.draw(DameTrefle, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "RoiTrefle") {
					batch.draw(RoiTrefle, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "AsCarreau") {
					batch.draw(AsCarreau, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "DeuxCarreau") {
					batch.draw(DeuxCarreau, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "TroisCarreau") {
					batch.draw(TroisCarreau, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "QuatreCarreau") {
					batch.draw(QuatreCarreau, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "CinqCarreau") {
					batch.draw(CinqCarreau, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "SixCarreau") {
					batch.draw(SixCarreau, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "SeptCarreau") {
					batch.draw(SeptCarreau, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "HuitCarreau") {
					batch.draw(HuitCarreau, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "NeufCarreau") {
					batch.draw(NeufCarreau, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "DixCarreau") {
					batch.draw(DixCarreau, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "ValetCarreau") {
					batch.draw(ValetCarreau, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "DameCarreau") {
					batch.draw(DameCarreau, 980f, 110f, 103f, 138f);
				}
				else if (p1.uneCarte(2) == "RoiCarreau") {
					batch.draw(RoiCarreau, 980f, 110f, 103f, 138f);
				}
				if (clique >= 3) {
					if (p1.uneCarte(3) == "AsCoeur") {
						batch.draw(AsCoeur, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "DeuxCoeur") {
						batch.draw(DeuxCoeur, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "TroisCoeur") {
						batch.draw(TroisCoeur, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "QuatreCoeur") {
						batch.draw(QuatreCoeur, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "CinqCoeur") {
						batch.draw(CinqCoeur, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "SixCoeur") {
						batch.draw(SixCoeur, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "SeptCoeur") {
						batch.draw(SeptCoeur, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "HuitCoeur") {
						batch.draw(HuitCoeur, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "NeufCoeur") {
						batch.draw(NeufCoeur, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "DixCoeur") {
						batch.draw(DixCoeur, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "ValetCoeur") {
						batch.draw(ValetCoeur, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "DameCoeur") {
						batch.draw(DameCoeur, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "RoiCoeur") {
						batch.draw(RoiCoeur, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "AsPique") {
						batch.draw(AsPique, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "DeuxPique") {
						batch.draw(DeuxPique, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "TroisPique") {
						batch.draw(TroisPique, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "QuatrePique") {
						batch.draw(QuatrePique, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "CinqPique") {
						batch.draw(CinqPique, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "SixPique") {
						batch.draw(SixPique, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "SeptPique") {
						batch.draw(SeptPique, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "HuitPique") {
						batch.draw(HuitPique, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "NeufPique") {
						batch.draw(NeufPique, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "DixPique") {
						batch.draw(DixPique, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "ValetPique") {
						batch.draw(ValetPique, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "DamePique") {
						batch.draw(DamePique, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "RoiPique") {
						batch.draw(RoiPique, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "AsTrefle") {
						batch.draw(AsTrefle, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "DeuxTrefle") {
						batch.draw(DeuxTrefle, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "TroisTrefle") {
						batch.draw(TroisTrefle, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "QuatreTrefle") {
						batch.draw(QuatreTrefle, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "CinqTrefle") {
						batch.draw(CinqTrefle, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "SixTrefle") {
						batch.draw(SixTrefle, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "SeptTrefle") {
						batch.draw(SeptTrefle, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "HuitTrefle") {
						batch.draw(HuitTrefle, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "NeufTrefle") {
						batch.draw(NeufTrefle, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "DixTrefle") {
						batch.draw(DixTrefle, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "ValetTrefle") {
						batch.draw(ValetTrefle, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "DameTrefle") {
						batch.draw(DameTrefle, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "RoiTrefle") {
						batch.draw(RoiTrefle, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "AsCarreau") {
						batch.draw(AsCarreau, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "DeuxCarreau") {
						batch.draw(DeuxCarreau, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "TroisCarreau") {
						batch.draw(TroisCarreau, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "QuatreCarreau") {
						batch.draw(QuatreCarreau, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "CinqCarreau") {
						batch.draw(CinqCarreau, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "SixCarreau") {
						batch.draw(SixCarreau, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "SeptCarreau") {
						batch.draw(SeptCarreau, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "HuitCarreau") {
						batch.draw(HuitCarreau, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "NeufCarreau") {
						batch.draw(NeufCarreau, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "DixCarreau") {
						batch.draw(DixCarreau, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "ValetCarreau") {
						batch.draw(ValetCarreau, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "DameCarreau") {
						batch.draw(DameCarreau, 1010f, 80f, 103f, 138f);
					}
					else if (p1.uneCarte(3) == "RoiCarreau") {
						batch.draw(RoiCarreau, 1010f, 80f, 103f, 138f);
					}
					if (clique >= 4) {
						if (p1.uneCarte(4) == "AsCoeur") {
							batch.draw(AsCoeur, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "DeuxCoeur") {
							batch.draw(DeuxCoeur, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "TroisCoeur") {
							batch.draw(TroisCoeur, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "QuatreCoeur") {
							batch.draw(QuatreCoeur, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "CinqCoeur") {
							batch.draw(CinqCoeur, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "SixCoeur") {
							batch.draw(SixCoeur, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "SeptCoeur") {
							batch.draw(SeptCoeur, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "HuitCoeur") {
							batch.draw(HuitCoeur, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "NeufCoeur") {
							batch.draw(NeufCoeur, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "DixCoeur") {
							batch.draw(DixCoeur, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "ValetCoeur") {
							batch.draw(ValetCoeur, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "DameCoeur") {
							batch.draw(DameCoeur, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "RoiCoeur") {
							batch.draw(RoiCoeur, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "AsPique") {
							batch.draw(AsPique, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "DeuxPique") {
							batch.draw(DeuxPique, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "TroisPique") {
							batch.draw(TroisPique, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "QuatrePique") {
							batch.draw(QuatrePique, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "CinqPique") {
							batch.draw(CinqPique, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "SixPique") {
							batch.draw(SixPique, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "SeptPique") {
							batch.draw(SeptPique, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "HuitPique") {
							batch.draw(HuitPique, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "NeufPique") {
							batch.draw(NeufPique, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "DixPique") {
							batch.draw(DixPique, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "ValetPique") {
							batch.draw(ValetPique, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "DamePique") {
							batch.draw(DamePique, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "RoiPique") {
							batch.draw(RoiPique, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "AsTrefle") {
							batch.draw(AsTrefle, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "DeuxTrefle") {
							batch.draw(DeuxTrefle, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "TroisTrefle") {
							batch.draw(TroisTrefle, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "QuatreTrefle") {
							batch.draw(QuatreTrefle, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "CinqTrefle") {
							batch.draw(CinqTrefle, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "SixTrefle") {
							batch.draw(SixTrefle, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "SeptTrefle") {
							batch.draw(SeptTrefle, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "HuitTrefle") {
							batch.draw(HuitTrefle, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "NeufTrefle") {
							batch.draw(NeufTrefle, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "DixTrefle") {
							batch.draw(DixTrefle, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "ValetTrefle") {
							batch.draw(ValetTrefle, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "DameTrefle") {
							batch.draw(DameTrefle, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "RoiTrefle") {
							batch.draw(RoiTrefle, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "AsCarreau") {
							batch.draw(AsCarreau, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "DeuxCarreau") {
							batch.draw(DeuxCarreau, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "TroisCarreau") {
							batch.draw(TroisCarreau, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "QuatreCarreau") {
							batch.draw(QuatreCarreau, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "CinqCarreau") {
							batch.draw(CinqCarreau, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "SixCarreau") {
							batch.draw(SixCarreau, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "SeptCarreau") {
							batch.draw(SeptCarreau, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "HuitCarreau") {
							batch.draw(HuitCarreau, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "NeufCarreau") {
							batch.draw(NeufCarreau, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "DixCarreau") {
							batch.draw(DixCarreau, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "ValetCarreau") {
							batch.draw(ValetCarreau, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "DameCarreau") {
							batch.draw(DameCarreau, 1140f, 172f, 103f, 138f);
						}
						else if (p1.uneCarte(4) == "RoiCarreau") {
							batch.draw(RoiCarreau, 1140f, 172f, 103f, 138f);
						}
						if (clique >= 5) {
							if (p1.uneCarte(5) == "AsCoeur") {
								batch.draw(AsCoeur, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "DeuxCoeur") {
								batch.draw(DeuxCoeur, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "TroisCoeur") {
								batch.draw(TroisCoeur, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "QuatreCoeur") {
								batch.draw(QuatreCoeur, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "CinqCoeur") {
								batch.draw(CinqCoeur, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "SixCoeur") {
								batch.draw(SixCoeur, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "SeptCoeur") {
								batch.draw(SeptCoeur, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "HuitCoeur") {
								batch.draw(HuitCoeur, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "NeufCoeur") {
								batch.draw(NeufCoeur, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "DixCoeur") {
								batch.draw(DixCoeur, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "ValetCoeur") {
								batch.draw(ValetCoeur, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "DameCoeur") {
								batch.draw(DameCoeur, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "RoiCoeur") {
								batch.draw(RoiCoeur, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "AsPique") {
								batch.draw(AsPique, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "DeuxPique") {
								batch.draw(DeuxPique, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "TroisPique") {
								batch.draw(TroisPique, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "QuatrePique") {
								batch.draw(QuatrePique, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "CinqPique") {
								batch.draw(CinqPique, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "SixPique") {
								batch.draw(SixPique, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "SeptPique") {
								batch.draw(SeptPique, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "HuitPique") {
								batch.draw(HuitPique, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "NeufPique") {
								batch.draw(NeufPique, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "DixPique") {
								batch.draw(DixPique, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "ValetPique") {
								batch.draw(ValetPique, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "DamePique") {
								batch.draw(DamePique, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "RoiPique") {
								batch.draw(RoiPique, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "AsTrefle") {
								batch.draw(AsTrefle, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "DeuxTrefle") {
								batch.draw(DeuxTrefle, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "TroisTrefle") {
								batch.draw(TroisTrefle, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "QuatreTrefle") {
								batch.draw(QuatreTrefle, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "CinqTrefle") {
								batch.draw(CinqTrefle, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "SixTrefle") {
								batch.draw(SixTrefle, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "SeptTrefle") {
								batch.draw(SeptTrefle, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "HuitTrefle") {
								batch.draw(HuitTrefle, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "NeufTrefle") {
								batch.draw(NeufTrefle, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "DixTrefle") {
								batch.draw(DixTrefle, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "ValetTrefle") {
								batch.draw(ValetTrefle, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "DameTrefle") {
								batch.draw(DameTrefle, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "RoiTrefle") {
								batch.draw(RoiTrefle, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "AsCarreau") {
								batch.draw(AsCarreau, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "DeuxCarreau") {
								batch.draw(DeuxCarreau, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "TroisCarreau") {
								batch.draw(TroisCarreau, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "QuatreCarreau") {
								batch.draw(QuatreCarreau, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "CinqCarreau") {
								batch.draw(CinqCarreau, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "SixCarreau") {
								batch.draw(SixCarreau, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "SeptCarreau") {
								batch.draw(SeptCarreau, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "HuitCarreau") {
								batch.draw(HuitCarreau, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "NeufCarreau") {
								batch.draw(NeufCarreau, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "DixCarreau") {
								batch.draw(DixCarreau, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "ValetCarreau") {
								batch.draw(ValetCarreau, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "DameCarreau") {
								batch.draw(DameCarreau, 1170f, 140f, 103f, 138f);
							}
							else if (p1.uneCarte(5) == "RoiCarreau") {
								batch.draw(RoiCarreau, 1170f, 140f, 103f, 138f);
							}
							if (clique >= 6) {
								if (p1.uneCarte(6) == "AsCoeur") {
									batch.draw(AsCoeur, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "DeuxCoeur") {
									batch.draw(DeuxCoeur, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "TroisCoeur") {
									batch.draw(TroisCoeur, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "QuatreCoeur") {
									batch.draw(QuatreCoeur, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "CinqCoeur") {
									batch.draw(CinqCoeur, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "SixCoeur") {
									batch.draw(SixCoeur, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "SeptCoeur") {
									batch.draw(SeptCoeur, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "HuitCoeur") {
									batch.draw(HuitCoeur, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "NeufCoeur") {
									batch.draw(NeufCoeur, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "DixCoeur") {
									batch.draw(DixCoeur, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "ValetCoeur") {
									batch.draw(ValetCoeur, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "DameCoeur") {
									batch.draw(DameCoeur, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "RoiCoeur") {
									batch.draw(RoiCoeur, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "AsPique") {
									batch.draw(AsPique, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "DeuxPique") {
									batch.draw(DeuxPique, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "TroisPique") {
									batch.draw(TroisPique, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "QuatrePique") {
									batch.draw(QuatrePique, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "CinqPique") {
									batch.draw(CinqPique, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "SixPique") {
									batch.draw(SixPique, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "SeptPique") {
									batch.draw(SeptPique, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "HuitPique") {
									batch.draw(HuitPique, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "NeufPique") {
									batch.draw(NeufPique, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "DixPique") {
									batch.draw(DixPique, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "ValetPique") {
									batch.draw(ValetPique, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "DamePique") {
									batch.draw(DamePique, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "RoiPique") {
									batch.draw(RoiPique, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "AsTrefle") {
									batch.draw(AsTrefle, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "DeuxTrefle") {
									batch.draw(DeuxTrefle, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "TroisTrefle") {
									batch.draw(TroisTrefle, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "QuatreTrefle") {
									batch.draw(QuatreTrefle, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "CinqTrefle") {
									batch.draw(CinqTrefle, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "SixTrefle") {
									batch.draw(SixTrefle, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "SeptTrefle") {
									batch.draw(SeptTrefle, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "HuitTrefle") {
									batch.draw(HuitTrefle, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "NeufTrefle") {
									batch.draw(NeufTrefle, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "DixTrefle") {
									batch.draw(DixTrefle, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "ValetTrefle") {
									batch.draw(ValetTrefle, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "DameTrefle") {
									batch.draw(DameTrefle, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "RoiTrefle") {
									batch.draw(RoiTrefle, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "AsCarreau") {
									batch.draw(AsCarreau, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "DeuxCarreau") {
									batch.draw(DeuxCarreau, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "TroisCarreau") {
									batch.draw(TroisCarreau, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "QuatreCarreau") {
									batch.draw(QuatreCarreau, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "CinqCarreau") {
									batch.draw(CinqCarreau, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "SixCarreau") {
									batch.draw(SixCarreau, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "SeptCarreau") {
									batch.draw(SeptCarreau, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "HuitCarreau") {
									batch.draw(HuitCarreau, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "NeufCarreau") {
									batch.draw(NeufCarreau, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "DixCarreau") {
									batch.draw(DixCarreau, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "ValetCarreau") {
									batch.draw(ValetCarreau, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "DameCarreau") {
									batch.draw(DameCarreau, 1200f, 110f, 103f, 138f);
								}
								else if (p1.uneCarte(6) == "RoiCarreau") {
									batch.draw(RoiCarreau, 1200f, 110f, 103f, 138f);
								}
								if (clique >= 7) {
									if (p1.uneCarte(7) == "AsCoeur") {
										batch.draw(AsCoeur, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "DeuxCoeur") {
										batch.draw(DeuxCoeur, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "TroisCoeur") {
										batch.draw(TroisCoeur, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "QuatreCoeur") {
										batch.draw(QuatreCoeur, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "CinqCoeur") {
										batch.draw(CinqCoeur, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "SixCoeur") {
										batch.draw(SixCoeur, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "SeptCoeur") {
										batch.draw(SeptCoeur, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "HuitCoeur") {
										batch.draw(HuitCoeur, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "NeufCoeur") {
										batch.draw(NeufCoeur, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "DixCoeur") {
										batch.draw(DixCoeur, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "ValetCoeur") {
										batch.draw(ValetCoeur, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "DameCoeur") {
										batch.draw(DameCoeur, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "RoiCoeur") {
										batch.draw(RoiCoeur, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "AsPique") {
										batch.draw(AsPique, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "DeuxPique") {
										batch.draw(DeuxPique, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "TroisPique") {
										batch.draw(TroisPique, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "QuatrePique") {
										batch.draw(QuatrePique, 1230f, 172f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "CinqPique") {
										batch.draw(CinqPique, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "SixPique") {
										batch.draw(SixPique, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "SeptPique") {
										batch.draw(SeptPique, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "HuitPique") {
										batch.draw(HuitPique, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "NeufPique") {
										batch.draw(NeufPique, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "DixPique") {
										batch.draw(DixPique, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "ValetPique") {
										batch.draw(ValetPique, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "DamePique") {
										batch.draw(DamePique, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "RoiPique") {
										batch.draw(RoiPique, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "AsTrefle") {
										batch.draw(AsTrefle, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "DeuxTrefle") {
										batch.draw(DeuxTrefle, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "TroisTrefle") {
										batch.draw(TroisTrefle, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "QuatreTrefle") {
										batch.draw(QuatreTrefle, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "CinqTrefle") {
										batch.draw(CinqTrefle, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "SixTrefle") {
										batch.draw(SixTrefle, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "SeptTrefle") {
										batch.draw(SeptTrefle, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "HuitTrefle") {
										batch.draw(HuitTrefle, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "NeufTrefle") {
										batch.draw(NeufTrefle, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "DixTrefle") {
										batch.draw(DixTrefle, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "ValetTrefle") {
										batch.draw(ValetTrefle, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "DameTrefle") {
										batch.draw(DameTrefle, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "RoiTrefle") {
										batch.draw(RoiTrefle, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "AsCarreau") {
										batch.draw(AsCarreau, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "DeuxCarreau") {
										batch.draw(DeuxCarreau, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "TroisCarreau") {
										batch.draw(TroisCarreau, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "QuatreCarreau") {
										batch.draw(QuatreCarreau, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "CinqCarreau") {
										batch.draw(CinqCarreau, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "SixCarreau") {
										batch.draw(SixCarreau, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "SeptCarreau") {
										batch.draw(SeptCarreau, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "HuitCarreau") {
										b80f.draw(HuitCarreau, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "NeufCarreau") {
										batch.draw(NeufCarreau, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "DixCarreau") {
										batch.draw(DixCarreau, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "ValetCarreau") {
										batch.draw(ValetCarreau, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "DameCarreau") {
										batch.draw(DameCarreau, 1230f, 80f, 103f, 138f);
									}
									else if (p1.uneCarte(7) == "RoiCarreau") {
										batch.draw(RoiCarreau, 1230f, 80f, 103f, 138f);
									}
									if (clique >= 8) {
										if (p1.uneCarte(8) == "AsCoeur") {
											batch.draw(AsCoeur, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "DeuxCoeur") {
											batch.draw(DeuxCoeur, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "TroisCoeur") {
											batch.draw(TroisCoeur, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "QuatreCoeur") {
											batch.draw(QuatreCoeur, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "CinqCoeur") {
											batch.draw(CinqCoeur, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "SixCoeur") {
											batch.draw(SixCoeur, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "SeptCoeur") {
											batch.draw(SeptCoeur, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "HuitCoeur") {
											batch.draw(HuitCoeur, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "NeufCoeur") {
											batch.draw(NeufCoeur, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "DixCoeur") {
											batch.draw(DixCoeur, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "ValetCoeur") {
											batch.draw(ValetCoeur, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "DameCoeur") {
											batch.draw(DameCoeur, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "RoiCoeur") {
											batch.draw(RoiCoeur, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "AsPique") {
											batch.draw(AsPique, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "DeuxPique") {
											batch.draw(DeuxPique, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "TroisPique") {
											batch.draw(TroisPique, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "QuatrePique") {
											batch.draw(QuatrePique, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "CinqPique") {
											batch.draw(CinqPique, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "SixPique") {
											batch.draw(SixPique, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "SeptPique") {
											batch.draw(SeptPique, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "HuitPique") {
											batch.draw(HuitPique, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "NeufPique") {
											batch.draw(NeufPique, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "DixPique") {
											batch.draw(DixPique, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "ValetPique") {
											batch.draw(ValetPique, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "DamePique") {
											batch.draw(DamePique, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "RoiPique") {
											batch.draw(RoiPique, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "AsTrefle") {
											batch.draw(AsTrefle, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "DeuxTrefle") {
											batch.draw(DeuxTrefle, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "TroisTrefle") {
											batch.draw(TroisTrefle, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "QuatreTrefle") {
											batch.draw(QuatreTrefle, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "CinqTrefle") {
											batch.draw(CinqTrefle, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "SixTrefle") {
											batch.draw(SixTrefle, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "SeptTrefle") {
											batch.draw(SeptTrefle, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "HuitTrefle") {
											batch.draw(HuitTrefle, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "NeufTrefle") {
											batch.draw(NeufTrefle, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "DixTrefle") {
											batch.draw(DixTrefle, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "ValetTrefle") {
											batch.draw(ValetTrefle, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "DameTrefle") {
											batch.draw(DameTrefle, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "RoiTrefle") {
											batch.draw(RoiTrefle, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "AsCarreau") {
											batch.draw(AsCarreau, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "DeuxCarreau") {
											batch.draw(DeuxCarreau, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "TroisCarreau") {
											batch.draw(TroisCarreau, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "QuatreCarreau") {
											batch.draw(QuatreCarreau, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "CinqCarreau") {
											batch.draw(CinqCarreau, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "SixCarreau") {
											batch.draw(SixCarreau, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "SeptCarreau") {
											batch.draw(SeptCarreau, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "HuitCarreau") {
											batch.draw(HuitCarreau, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "NeufCarreau") {
											batch.draw(NeufCarreau, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "DixCarreau") {
											batch.draw(DixCarreau, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "ValetCarreau") {
											batch.draw(ValetCarreau, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "DameCarreau") {
											batch.draw(DameCarreau, 1420f, 172f, 103f, 138f);
										}
										else if (p1.uneCarte(8) == "RoiCarreau") {
											batch.draw(RoiCarreau, 1420f, 172f, 103f, 138f);
										}
										if (clique >= 9){
											if (p1.uneCarte(9) == "AsCoeur") {
												batch.draw(AsCoeur, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "DeuxCoeur") {
												batch.draw(DeuxCoeur, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "TroisCoeur") {
												batch.draw(TroisCoeur, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "QuatreCoeur") {
												batch.draw(QuatreCoeur, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "CinqCoeur") {
												batch.draw(CinqCoeur, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "SixCoeur") {
												batch.draw(SixCoeur, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "SeptCoeur") {
												batch.draw(SeptCoeur, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "HuitCoeur") {
												batch.draw(HuitCoeur, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "NeufCoeur") {
												batch.draw(NeufCoeur, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "DixCoeur") {
												batch.draw(DixCoeur, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "ValetCoeur") {
												batch.draw(ValetCoeur, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "DameCoeur") {
												batch.draw(DameCoeur, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "RoiCoeur") {
												batch.draw(RoiCoeur, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "AsPique") {
												batch.draw(AsPique, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "DeuxPique") {
												batch.draw(DeuxPique, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "TroisPique") {
												batch.draw(TroisPique, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "QuatrePique") {
												batch.draw(QuatrePique, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "CinqPique") {
												batch.draw(CinqPique, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "SixPique") {
												batch.draw(SixPique, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "SeptPique") {
												batch.draw(SeptPique, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "HuitPique") {
												batch.draw(HuitPique, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "NeufPique") {
												batch.draw(NeufPique, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "DixPique") {
												batch.draw(DixPique, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "ValetPique") {
												batch.draw(ValetPique, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "DamePique") {
												batch.draw(DamePique, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "RoiPique") {
												batch.draw(RoiPique, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "AsTrefle") {
												batch.draw(AsTrefle, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "DeuxTrefle") {
												batch.draw(DeuxTrefle, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "TroisTrefle") {
												batch.draw(TroisTrefle, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "QuatreTrefle") {
												batch.draw(QuatreTrefle, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "CinqTrefle") {
												batch.draw(CinqTrefle, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "SixTrefle") {
												batch.draw(SixTrefle, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "SeptTrefle") {
												batch.draw(SeptTrefle, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "HuitTrefle") {
												batch.draw(HuitTrefle, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "NeufTrefle") {
												batch.draw(NeufTrefle, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "DixTrefle") {
												batch.draw(DixTrefle, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "ValetTrefle") {
												batch.draw(ValetTrefle, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "DameTrefle") {
												batch.draw(DameTrefle, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "RoiTrefle") {
												batch.draw(RoiTrefle, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "AsCarreau") {
												batch.draw(AsCarreau, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "DeuxCarreau") {
												batch.draw(DeuxCarreau, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "TroisCarreau") {
												batch.draw(TroisCarreau, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "QuatreCarreau") {
												batch.draw(QuatreCarreau, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "CinqCarreau") {
												batch.draw(CinqCarreau, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "SixCarreau") {
												batch.draw(SixCarreau, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "SeptCarreau") {
												batch.draw(SeptCarreau, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "HuitCarreau") {
												batch.draw(HuitCarreau, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "NeufCarreau") {
												batch.draw(NeufCarreau, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "DixCarreau") {
												batch.draw(DixCarreau, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "ValetCarreau") {
												batch.draw(ValetCarreau, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "DameCarreau") {
												batch.draw(DameCarreau, 1450f, 140f, 103f, 138f);
											}
											else if (p1.uneCarte(9) == "RoiCarreau") {
												batch.draw(RoiCarreau, 1450f, 140f, 103f, 138f);
											}
											if (clique >= 10) {
												if (p1.uneCarte(10) == "AsCoeur") {
													batch.draw(AsCoeur, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "DeuxCoeur") {
													batch.draw(DeuxCoeur, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "TroisCoeur") {
													batch.draw(TroisCoeur, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "QuatreCoeur") {
													batch.draw(QuatreCoeur, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "CinqCoeur") {
													batch.draw(CinqCoeur, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "SixCoeur") {
													batch.draw(SixCoeur, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "SeptCoeur") {
													batch.draw(SeptCoeur, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "HuitCoeur") {
													batch.draw(HuitCoeur, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "NeufCoeur") {
													batch.draw(NeufCoeur, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "DixCoeur") {
													batch.draw(DixCoeur, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "ValetCoeur") {
													batch.draw(ValetCoeur, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "DameCoeur") {
													batch.draw(DameCoeur, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "RoiCoeur") {
													batch.draw(RoiCoeur, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "AsPique") {
													batch.draw(AsPique, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "DeuxPique") {
													batch.draw(DeuxPique, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "TroisPique") {
													batch.draw(TroisPique, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "QuatrePique") {
													batch.draw(QuatrePique, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "CinqPique") {
													batch.draw(CinqPique, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "SixPique") {
													batch.draw(SixPique, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "SeptPique") {
													batch.draw(SeptPique, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "HuitPique") {
													batch.draw(HuitPique, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "NeufPique") {
													batch.draw(NeufPique, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "DixPique") {
													batch.draw(DixPique, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "ValetPique") {
													batch.draw(ValetPique, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "DamePique") {
													batch.draw(DamePique, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "RoiPique") {
													batch.draw(RoiPique, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "AsTrefle") {
													batch.draw(AsTrefle, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "DeuxTrefle") {
													batch.draw(DeuxTrefle, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "TroisTrefle") {
													batch.draw(TroisTrefle, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "QuatreTrefle") {
													batch.draw(QuatreTrefle, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "CinqTrefle") {
													batch.draw(CinqTrefle, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "SixTrefle") {
													batch.draw(SixTrefle, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "SeptTrefle") {
													batch.draw(SeptTrefle, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "HuitTrefle") {
													batch.draw(HuitTrefle, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "NeufTrefle") {
													batch.draw(NeufTrefle, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "DixTrefle") {
													batch.draw(DixTrefle, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "ValetTrefle") {
													batch.draw(ValetTrefle, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "DameTrefle") {
													batch.draw(DameTrefle, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "RoiTrefle") {
													batch.draw(RoiTrefle, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "AsCarreau") {
													batch.draw(AsCarreau, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "DeuxCarreau") {
													batch.draw(DeuxCarreau, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "TroisCarreau") {
													batch.draw(TroisCarreau, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "QuatreCarreau") {
													batch.draw(QuatreCarreau, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "CinqCarreau") {
													batch.draw(CinqCarreau, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "SixCarreau") {
													batch.draw(SixCarreau, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "SeptCarreau") {
													batch.draw(SeptCarreau, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "HuitCarreau") {
													batch.draw(HuitCarreau, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "NeufCarreau") {
													batch.draw(NeufCarreau, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "DixCarreau") {
													batch.draw(DixCarreau, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "ValetCarreau") {
													batch.draw(ValetCarreau, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "DameCarreau") {
													batch.draw(DameCarreau, 1480f, 110f, 103f, 138f);
												}
												else if (p1.uneCarte(10) == "RoiCarreau") {
													batch.draw(RoiCarreau, 1480f, 110f, 103f, 138f);
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
