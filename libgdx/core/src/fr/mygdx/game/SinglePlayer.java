package fr.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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

public class SinglePlayer implements Screen {

	private Stage stage, stageResult;
	private SpriteBatch batch;
	private Texture BlackjackTable, chipBlue, chipRed, chipGreen, chipYellow, chipLightBlue, chipBeige, chipWhite, buttonGreenFinal;
	private TextButton buttonQuit, buttonDraw, buttonPlay, buttonBet, buttonStop, buttonPlayAgain, buttonRedJeton, buttonGreenJeton, buttonBlueJeton, buttonYellowJeton;
	private BitmapFont black, white;
	private Table table, tableGame, tableStop, tablePlayAgain, tableRedJeton, tableGreenJeton, tableBlueJeton, tableYellowJeton, tableDraw, tableResult;
	private int launch = 0, click = 0, bet = 0, money = 5000, red = 0, yellow = 0, green = 0, blue = 0, firstLaunch = 0, clickRestart = 0;;
	private boolean clickStop = false, launchVictory = false, launchTie = false, launchDefeat = false, clickPlay = false, resultCount = false, 
					displayChips = true,afficheMise = false,clickMise = true;
	private Label miseLabel, banque, result, labelScorePlayer;
	private TextureAtlas atlas, atlas2, atlas3, atlas4, atlas5, atlasLabel, atlasAnimRedJ, atlasAnimGreenJ, atlasAnimBlueJ, atlasAnimYellowJ,atlasAura;/*, atlas2*/;

	
	private float x = 0f , y = 0f;
   
	private Skin skin,  skin2, skin3, skin4, skin5,skinLabel;;
	private Music music;
	private Music pressbutton;
	private  BLACKJACKCity parent;
	private static int score;
	private Preferences prefs;
	private float animTimeJetons1 , animTimeJetons2 , animTimeJetons3 , animTimeJetons4, animTimeAura1 , animTime1= 0f, animTime2= 0f,
				  animTime3= 0f, animTime4= 0f, animTime5= 0f, animTime6= 0f, animTime7= 0f, animTime8= 0f, animTime9= 0f, animTime10= 0f, 
				  animTime11= 0f,animTimeCroupier = 0f , animTimeDebut = 0f, animTimeAura2 , animTimeAura3 , animTimeAura4;
	private float totalAnimTime , totalAnimTimeAura , totalAnimTimeJetons, animTimeCroupier2 = 0f , animTimeCroupier3 = 0f , animTimeCroupier4 = 0f
			, animTimeCroupier5 = 0f , animTimeCroupier6 = 0f , animTimeCroupier7 = 0f;
	private Array<AtlasRegion> animationFrames , animationFramesAura;
	public static Animation <TextureRegion> animRedJ, animGreenJ, animBlueJ, animYellowJ , animCartes,animAura;
	private Vector2 screenposRed = new Vector2(650f,100f);
	private Vector2 screenposGreen = new Vector2(850f,100f);
	private Vector2 screenposBlue = new Vector2(1250f,100f);
	private Vector2 screenposYellow = new Vector2(1050f,100f);
	private Vector2 screenPos = new Vector2(500f,500f);
	
	//private float totalAnimTime;
	
	public SinglePlayer(BLACKJACKCity blackjackcity) {
		parent = blackjackcity;
	}
	private ArrayList<Animation<TextureRegion>> animationPack;
	private Player[] joueurs = new Player[1];
	Deck paquet = new Deck(animationPack);
	
	Cards p1 = new Cards(paquet);
	static int ADDCARTE = 0;
	
	
	static int pushButton = 0;
	
	@Override
	public void show() {
		//totalAnimTime = 0.1f;
		
		batch = new SpriteBatch();
		
		BlackjackTable = new Texture("BlackjackTable SinglePlayer.png");
		
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
		skin2 = new Skin(atlas2);
		skin3 = new Skin(atlas3);
		skin4 = new Skin(atlas4);
		skin5 = new Skin(atlas5);
		skinLabel = new Skin(Gdx.files.internal("skindefault/uiskin.json"));
		stage = new Stage();
		stageResult = new Stage();
		skin = new Skin(atlas);
		Gdx.input.setInputProcessor(stage);
		
		totalAnimTime = 0.2f;
		totalAnimTimeJetons = 0.1f;
		totalAnimTimeAura = 0.05f;
		
		animTimeJetons1 = 0f;
		animTimeJetons2 = 0f;
		animTimeJetons3 = 0f;
		animTimeJetons4 = 0f;
		animTime1 = 0f;
		animTimeAura1 = 0f;
		animTimeAura2 = 0f;
		animTimeAura3 = 0f;
		animTimeAura4 = 0f;

		
		animationFrames = atlasAnimRedJ.getRegions();
		animRedJ = new Animation<TextureRegion> (totalAnimTimeJetons,animationFrames);
		animRedJ.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFrames = atlasAnimGreenJ.getRegions();
		animGreenJ = new Animation<TextureRegion> (totalAnimTimeJetons,animationFrames);
		animGreenJ.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFrames = atlasAnimBlueJ.getRegions();
		animBlueJ = new Animation<TextureRegion> (totalAnimTimeJetons,animationFrames);
		animBlueJ.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFrames = atlasAnimYellowJ.getRegions();
		animYellowJ = new Animation<TextureRegion> (totalAnimTimeJetons,animationFrames);
		animYellowJ.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesAura = atlasAura.getRegions();
		animAura = new Animation<TextureRegion> (totalAnimTimeAura, animationFramesAura);
		animAura.setPlayMode(Animation.PlayMode.NORMAL);
	
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableGame = new Table(skin);
		tableGame.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableStop = new Table(skin);
		tableStop.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tablePlayAgain = new Table(skin);
		tablePlayAgain.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableRedJeton = new Table(skin2);
		tableRedJeton.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableGreenJeton = new Table(skin3);
		tableGreenJeton.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableBlueJeton = new Table(skin4);
		tableBlueJeton.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableYellowJeton = new Table(skin5);
		tableYellowJeton.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableDraw = new Table(skin);
		tableDraw.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableResult = new Table(skin);
		tableResult.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		black = new BitmapFont(Gdx.files.internal("font/black.fnt"), false);
		white = new BitmapFont(Gdx.files.internal("font/white.fnt"), false);
		pressbutton = Gdx.audio.newMusic(Gdx.files.internal("pressbutton.mp3"));
		music = Gdx.audio.newMusic(Gdx.files.internal("Playmusic.mp3"));
		result = new Label("", skinLabel);
		
		chipBlue = new Texture("LargeChips/chip_blue.png");
		chipLightBlue = new Texture("LargeChips/chip_lightblue.png");
		chipRed = new Texture("LargeChips/chip_red.png");
		chipWhite = new Texture("LargeChips/chip_white.png");
		chipGreen = new Texture("LargeChips/chip_green.png");
		chipBeige = new Texture("LargeChips/chip_biege.png");
		chipYellow = new Texture("LargeChips/chip_yellow.png");
		buttonGreenFinal = new Texture("AnimGreen7.png");
		
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
		
		buttonPlay = new TextButton("Jouer", textButtonStyle);
		buttonPlay.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
				clickPlay = true;
				displayChips = true;
				tableGame.removeActor(buttonPlay);
				tableGame.add(buttonDraw);
				tableStop.add(buttonStop);
				Label.LabelStyle label1Style = new Label.LabelStyle();
				BitmapFont myFont = new BitmapFont(Gdx.files.internal("font/white.fnt"));
				label1Style.font = myFont;
				label1Style.fontColor = Color.WHITE;
				tableRedJeton.removeActor(buttonRedJeton);
				tableGreenJeton.removeActor(buttonGreenJeton);
				tableYellowJeton.removeActor(buttonYellowJeton);
				tableBlueJeton.removeActor(buttonBlueJeton);
				labelScorePlayer = new Label("Score = "+p1.getScore(0)+"       Score du croupier = "+((p1.getMain().get(0) == 1)? "1 / 11" : p1.getMain().get(0)),label1Style);
				labelScorePlayer.setSize(200f,200f);
				labelScorePlayer.setPosition(1300,200);
				stage.addActor(labelScorePlayer);
			}
		});
		buttonPlay.pad(15f, 40f, 15f, 40f);
		
		buttonDraw = new TextButton("Tirer", textButtonStyle);
		buttonDraw.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
				click++;
				ADDCARTE = 1;
				p1.tirerjoueur(0);	
				labelScorePlayer.remove();
				Label.LabelStyle label1Style = new Label.LabelStyle();
				BitmapFont myFont = new BitmapFont(Gdx.files.internal("font/white.fnt"));
				label1Style.font = myFont;
				label1Style.fontColor = Color.WHITE;

				labelScorePlayer = new Label("Score = "+p1.getScore(0)+"       Score du croupier = "+((p1.getMain().get(0) == 1)? "1 / 11" : p1.getMain().get(0)),label1Style);
				labelScorePlayer.setSize(200f,300f);
				labelScorePlayer.setPosition(1300,200);
				stage.addActor(labelScorePlayer);
			}
		});
		buttonDraw.pad(15f, 40f, 15f, 40f);
		
		buttonStop = new TextButton("Stop", textButtonStyle);
		buttonStop.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
				tableGame.removeActor(buttonDraw);
				tableStop.removeActor(buttonStop);
				clickStop = true;
				tablePlayAgain.add(buttonPlayAgain);
				p1.getTotal(0, "SinglePlayer",AppPreferences.J);
				parent.getPreferences().setJ(1);
				System.out.println("J : " + AppPreferences.J);
				labelScorePlayer.remove();
				Label.LabelStyle label1Style = new Label.LabelStyle();
				BitmapFont myFont = new BitmapFont(Gdx.files.internal("font/white.fnt"));
				label1Style.font = myFont;
				label1Style.fontColor = Color.WHITE;
				tableRedJeton.setPosition(650f,100f, 0);
				tableRedJeton.add(buttonRedJeton);

				tableGreenJeton.setPosition(850f,100f, 0);
				tableGreenJeton.add(buttonGreenJeton);
				
				tableBlueJeton.setPosition(1250f,100f, 0);
				tableBlueJeton.add(buttonBlueJeton);
				
				tableYellowJeton.setPosition(1050f,100f, 0);
				tableYellowJeton.add(buttonYellowJeton);
				labelScorePlayer = new Label("Score = "+p1.getScore(0)+"       Score du croupier = "+p1.total(),label1Style);
				labelScorePlayer.setSize(200f,300f);
				labelScorePlayer.setPosition(1300,200);
				stage.addActor(labelScorePlayer);
				
			}
		});
		buttonStop.pad(15f, 40f, 15f, 40f);
		
		buttonPlayAgain = new TextButton("Rejouer", textButtonStyle);
		buttonPlayAgain.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
				launchVictory = false;
				launchTie = false;
				launchDefeat = false;
				click = 0;
				clickRestart ++;
				clickStop = false;
				launch = 0;
				clickPlay = true;
				displayChips = true;
				resultCount = true;
				p1.reinitialisation();
				
			    animTime1 = 0f;
			    animTime2 = 0f;
			    animTime3 = 0f;
			    animTime4 = 0f;
			    animTime5 = 0f;
			    animTime6 = 0f;
			    animTime7 = 0f;
			    animTime8 = 0f;
			    animTime9 = 0f;
			    animTime10 = 0f;
			    animTime11 = 0f;
			    tableRedJeton.removeActor(buttonRedJeton);
				tableGreenJeton.removeActor(buttonGreenJeton);
				tableYellowJeton.removeActor(buttonYellowJeton);
				tableBlueJeton.removeActor(buttonBlueJeton);
			    animTimeCroupier = 0f;
			    animTimeCroupier2 = 0f;
			    animTimeCroupier3 = 0f;
			    animTimeCroupier4 = 0f;
			    animTimeCroupier5 = 0f;
			    animTimeCroupier6 = 0f;
			    animTimeCroupier7 = 0f;
				tableDraw.removeActor(miseLabel);
				miseLabel = new Label( "Mise = " + bet + " Banque "+money, skinLabel );
				tableDraw.setPosition(500f, 500f, 0);
				tableDraw.add(miseLabel);
				tableDraw.pad(10,0,0,10);
		    	
				
		    	tablePlayAgain.removeActor(buttonPlayAgain);
				tableGame.add(buttonDraw);
				tableStop.add(buttonStop);
			}
		});
		buttonRedJeton = new TextButton("500", textButtonStyle2);
		buttonRedJeton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {

				if (money-500 >= 0) {
				bet += 500; 
				money -= 500;
				clickStop = false;
				
				red += 1;
				tableDraw.removeActor(miseLabel);
				miseLabel = new Label( "Mise = " + bet + " Banque "+money, skinLabel );
				
				tableDraw.setPosition(500f, 500f, 0);
				tableDraw.add(miseLabel);
				
				tableDraw.pad(10,0,0,10);
				pressbutton.play();
				music.dispose();
			}
			}
		});
		buttonRedJeton.pad(20f, 20f, 20f, 20f);
		
		buttonYellowJeton = new TextButton("100", textButtonStyle5);
		buttonYellowJeton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (money-100>=0) {
					bet += 100; 
					clickStop = false;
					money -= 100;
					yellow += 1;
					tableDraw.removeActor(miseLabel);
					miseLabel = new Label( "Mise = " + bet + " Banque "+money , skinLabel );
					
					tableDraw.setPosition(500f, 500f, 0);
					tableDraw.add(miseLabel);
					tableDraw.add(banque);
					tableDraw.pad(10,0,0,10);	
					pressbutton.play();
					music.dispose();
				}
			}
		});
		buttonYellowJeton.pad(20f, 20f, 20f, 20f);
		
		buttonGreenJeton = new TextButton("200", textButtonStyle3);
		buttonGreenJeton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (money - 200 >= 0) {
					bet += 200; 
					clickStop = false;
					money -= 200;
					green += 1;
					tableDraw.removeActor(miseLabel);
					miseLabel = new Label( "Mise = " + bet + " Banque "+money , skinLabel );
					
					tableDraw.setPosition(500f, 500f, 0);
					tableDraw.add(miseLabel);
					tableDraw.add(banque);
					tableDraw.pad(10,0,0,10);
					pressbutton.play();
					music.dispose();
				}
			}
		});
		buttonGreenJeton.pad(20f, 20f, 20f, 20f);
		
		buttonBlueJeton = new TextButton("50", textButtonStyle4);
		buttonBlueJeton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (money-50>= 0) {
					bet += 50; 
					clickStop = false;
					money -= 50;
					blue += 1;
					tableDraw.removeActor(miseLabel);
					miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
					
					tableDraw.setPosition(500f, 500f, 0);
					tableDraw.add(miseLabel);
					tableDraw.add(banque);
					tableDraw.pad(10,0,0,10);
					pressbutton.play();
					music.dispose();
				}
			}
		});
		miseLabel = new Label( "Mise = "+ bet + "Banque = " + money , skinLabel );
		
		
		tableDraw.setPosition(500f, 500f, 0);
		tableDraw.add(miseLabel);
		
		tableDraw.pad(10,0,0,10);
		
		buttonPlayAgain.pad(15f, 40f, 15f, 40f);
		
		table.setPosition(1700f, 600f, 0);
		table.add(buttonQuit);
		
		tableGame.setPosition(220f, 600f, 0);
		tableGame.add(buttonPlay);
		
		tableStop.setPosition(220f, 500f, 0);
		
		tablePlayAgain.setPosition(220f, 500f, 0);

		tableResult.setPosition(550f, 400f);
		table.add(result);
		
		tableRedJeton.setPosition(650f,100f, 0);
		tableRedJeton.add(buttonRedJeton);

		tableGreenJeton.setPosition(850f,100f, 0);
		tableGreenJeton.add(buttonGreenJeton);
		
		tableBlueJeton.setPosition(1250f,100f, 0);
		tableBlueJeton.add(buttonBlueJeton);
		
		tableYellowJeton.setPosition(1050f,100f, 0);
		tableYellowJeton.add(buttonYellowJeton);
		
		stage.addActor(table);
		stage.addActor(tableGame);
		stage.addActor(tableStop);
		stage.addActor(tablePlayAgain);
		stage.addActor(tableRedJeton);
		stage.addActor(tableGreenJeton);
		stage.addActor(tableBlueJeton);
		stage.addActor(tableYellowJeton);
		stage.addActor(tableDraw);
		stage.addActor(tableResult);
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(2, 2, 2, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (launch == 0) {
			if (firstLaunch == 0) {
				paquet.creationn();
				paquet.shuffle();
				paquet.toNb();
				p1.initialisation();
				firstLaunch++;
			}
			
			p1.maindep();
			p1.croupierdep();
			p1.croupiertirer();
	    	
		}
		launch++;
		
		
		batch.begin();
		batch.draw(BlackjackTable, 0, 0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		if (money == 0) {
			tableRedJeton.removeActor(buttonRedJeton);
			tableGreenJeton.removeActor(buttonGreenJeton);
			tableYellowJeton.removeActor(buttonYellowJeton);
			tableBlueJeton.removeActor(buttonBlueJeton);
			afficheMise = true;
		}
		if (money > 0 && afficheMise) {
			tableRedJeton.setPosition(650f,100f, 0);
			tableRedJeton.add(buttonRedJeton);

			tableGreenJeton.setPosition(850f,100f, 0);
			tableGreenJeton.add(buttonGreenJeton);
			
			tableBlueJeton.setPosition(1250f,100f, 0);
			tableBlueJeton.add(buttonBlueJeton);
			
			tableYellowJeton.setPosition(1050f,100f, 0);
			tableYellowJeton.add(buttonYellowJeton);
			afficheMise = false;
		}

		if(clickRestart >= 1) {
			labelScorePlayer.remove();
			Label.LabelStyle label1Style = new Label.LabelStyle();
			BitmapFont myFont = new BitmapFont(Gdx.files.internal("font/white.fnt"));
			label1Style.font = myFont;
			label1Style.fontColor = Color.WHITE;

			labelScorePlayer = new Label("Score = "+p1.getScore(0)+"       Score du croupier = "+((p1.getMain().get(0) == 1)? "1 / 11" : p1.getMain().get(0)),label1Style);
			labelScorePlayer.setSize(200f,300f);
			labelScorePlayer.setPosition(1300,200);
			stage.addActor(labelScorePlayer);
			clickRestart--;
		}

		
		if (clickPlay == true) {
			animTime1 += Gdx.graphics.getDeltaTime();
			animTime2 += Gdx.graphics.getDeltaTime();
			animTimeCroupier += Gdx.graphics.getDeltaTime();
			batch.draw(p1.getMainPlayer(0).get(0).getKeyFrame(animTime1, false), 870f, 197f, 181f, 251f);
			batch.draw(p1.getMainPlayer(0).get(1).getKeyFrame(animTime2, false), 900f, 165f, 181f, 251f);
			batch.draw(p1.afficheMainCroupierNom().get(0).getKeyFrame(animTimeCroupier, false), 800f, 600f, 181f, 251f);
			batch.draw(p1.afficheMainCroupierNom().get(1).getKeyFrame(animTimeCroupier2, false), 830f, 568f, 181f, 251f);
			
			if (clickStop == true && p1.winner(0) == 0) {
				launchVictory = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				if (p1.HasBJ()) {
					
					money += bet*2.5;
					bet = 0;
					tableDraw.removeActor(miseLabel);
					miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
					tableDraw.setPosition(500f, 500f, 0);
					tableDraw.add(miseLabel);
					
					
				}
				else {
				    
				    money += bet*2;
				    bet = 0;
				    tableDraw.removeActor(miseLabel);
				    miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				    tableDraw.setPosition(500f, 500f, 0);
				    tableDraw.add(miseLabel);
				
				    
			    }
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
				
			}
			else if (clickStop == true && p1.winner(0) == 1) {
				launchTie = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				
				money += bet;
				bet = 0;
				tableDraw.removeActor(miseLabel);
				miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				tableDraw.setPosition(500f, 500f, 0);
				tableDraw.add(miseLabel);
				
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
			else if (clickStop == true && p1.winner(0) == 2) {
				launchDefeat = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				bet = 0;
				tableDraw.removeActor(miseLabel);
				miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				tableDraw.setPosition(500f, 500f, 0);
				tableDraw.add(miseLabel);
				
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
		}
		

		batch.draw(chipGreen, 737f, 1005f, 65f, 29f);
		batch.draw(chipRed, 807f, 1005f, 65f, 29f);
		batch.draw(chipBeige, 880f, 1005f, 65f, 29f);
		batch.draw(chipBlue, 953f, 1005f, 65f, 29f);
		batch.draw(chipLightBlue, 1026f, 1005f, 65f, 29f);
		batch.draw(chipYellow, 1103f, 1005f, 65f, 29f);
		batch.draw(chipWhite, 1175f, 1005f, 65f, 29f);
		if(p1.getScore(0) > 21) {
			tableGame.removeActor(buttonDraw);
		}
		if (click >= 1 && p1.getSize() > 0) {
			animTime3 += Gdx.graphics.getDeltaTime();
			batch.draw(p1.getMainPlayer(0).get(2).getKeyFrame(animTime3, false), 930f, 133f, 181f, 251f);
			if (clickStop == true && p1.winner(0) == 0) {
				launchVictory = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				if (p1.HasBJ()) {
					
					money += bet*2.5;
					bet = 0;
					tableDraw.removeActor(miseLabel);
					miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
					tableDraw.setPosition(500f, 500f, 0);
					tableDraw.add(miseLabel);
					
					
				}
				else {
				    
				    money += bet*2;
				    bet = 0;
				    tableDraw.removeActor(miseLabel);
				    miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				    tableDraw.setPosition(500f, 500f, 0);
				    tableDraw.add(miseLabel);
				}
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}

			}
			else if (clickStop == true && p1.winner(0) == 1) {
				launchTie = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				
				money += bet;
				bet = 0;
				tableDraw.removeActor(miseLabel);
				miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				tableDraw.setPosition(500f, 500f, 0);
				tableDraw.add(miseLabel);
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
			else if (clickStop == true && p1.winner(0) == 2) {
				bet = 0;
				tableDraw.removeActor(miseLabel);
				miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				tableDraw.setPosition(500f, 500f, 0);
				tableDraw.add(miseLabel);
				launchDefeat = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
			
		}
		
		if (click >= 2 && p1.getSize() > 1) {
			animTime4 += Gdx.graphics.getDeltaTime();
			batch.draw(p1.getMainPlayer(0).get(3).getKeyFrame(animTime4, false), 960f, 101f, 181f, 251f);
			if (clickStop == true && p1.winner(0) == 0) {
				
				launchVictory = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				if (p1.HasBJ()) {
					money += bet*2.5;
					bet = 0;
					tableDraw.removeActor(miseLabel);
					miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
					tableDraw.setPosition(500f, 500f, 0);
					tableDraw.add(miseLabel);
				}
				else {
				    money += bet*2;
				    bet = 0;
				    tableDraw.removeActor(miseLabel);
				    miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				    tableDraw.setPosition(500f, 500f, 0);
				    tableDraw.add(miseLabel);
			    }
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
			else if (clickStop == true && p1.winner(0) == 1) {
				launchTie = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				money += bet;
				bet = 0;
				tableDraw.removeActor(miseLabel);
				miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				tableDraw.setPosition(500f, 500f, 0);
				tableDraw.add(miseLabel);
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
			else if (clickStop == true && p1.winner(0) == 2) {
				bet = 0;
				tableDraw.removeActor(miseLabel);
				miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				tableDraw.setPosition(500f, 500f, 0);
				tableDraw.add(miseLabel);
				launchDefeat = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
			
		}
		
		if (click >= 3 && p1.getSize() > 2) {
			animTime5 += Gdx.graphics.getDeltaTime();
			batch.draw(p1.getMainPlayer(0).get(4).getKeyFrame(animTime5, false), 1200f, 172f, 181f, 251f);
			if (clickStop == true && p1.winner(0) == 0) {
				launchVictory = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				
				if (p1.HasBJ()) {
					
					money += bet*2.5;
					bet = 0;
					tableDraw.removeActor(miseLabel);
					miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
					tableDraw.setPosition(500f, 500f, 0);
					tableDraw.add(miseLabel);
					
				}
				else {
				    
				    money += bet*2;
				    bet = 0;
				    tableDraw.removeActor(miseLabel);
				    miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				    tableDraw.setPosition(500f, 500f, 0);
				    tableDraw.add(miseLabel);
				    
			    }
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
			else if (clickStop == true && p1.winner(0) == 1) {
				launchTie = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				money += bet;
				bet = 0;
				tableDraw.removeActor(miseLabel);
				miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				tableDraw.setPosition(500f, 500f, 0);
				tableDraw.add(miseLabel);
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
			else if (clickStop == true && p1.winner(0) == 2) {
				bet  = 0;
				tableDraw.removeActor(miseLabel);
				miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				tableDraw.setPosition(500f, 500f, 0);
				tableDraw.add(miseLabel);
				launchDefeat = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
			
		}
		
		if (click >= 4 && p1.getSize() > 3) {
			animTime6 += Gdx.graphics.getDeltaTime();
			batch.draw(p1.getMainPlayer(0).get(5).getKeyFrame(animTime6, false), 1230f, 140f, 181f, 251f);
			if (clickStop == true && p1.winner(0) == 0) {
				launchVictory = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				if (p1.HasBJ()) {
					
					money += bet*2.5;
					bet = 0;
					tableDraw.removeActor(miseLabel);
					miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
					tableDraw.setPosition(500f, 500f, 0);
					tableDraw.add(miseLabel);
			    }
				else {
				    
				    money += bet*2;
				    bet = 0;
				    tableDraw.removeActor(miseLabel);
				    miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				    tableDraw.setPosition(500f, 500f, 0);
				    tableDraw.add(miseLabel);
				}
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
			else if (clickStop == true && p1.winner(0) == 1) {
				money += bet;
				bet = 0;
				tableDraw.removeActor(miseLabel);
				miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				tableDraw.setPosition(500f, 500f, 0);
				tableDraw.add(miseLabel);
				launchTie = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
			else if (clickStop == true && p1.winner(0) == 2) {
				bet  = 0;
				tableDraw.removeActor(miseLabel);
				miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				tableDraw.setPosition(500f, 500f, 0);
				tableDraw.add(miseLabel);
				launchDefeat = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
		}
		
		if (click >= 5 && p1.getSize() > 4) {
			animTime7 += Gdx.graphics.getDeltaTime();
			batch.draw(p1.getMainPlayer(0).get(6).getKeyFrame(animTime7, false), 1260f, 110f, 181f, 251f);
			if (clickStop == true && p1.winner(0) == 0) {
				launchVictory = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				if (p1.HasBJ()) {
					
					money += bet*2.5;
					bet = 0;
					tableDraw.removeActor(miseLabel);
					miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
					tableDraw.setPosition(500f, 500f, 0);
					tableDraw.add(miseLabel);
				}
				else {
				    
				    money += bet*2;
				    bet = 0;
				    tableDraw.removeActor(miseLabel);
				    miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				    tableDraw.setPosition(500f, 500f, 0);
				    tableDraw.add(miseLabel);
				}
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
			else if (clickStop == true && p1.winner(0) == 1) {
				launchTie = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				money += bet;
				bet = 0;
				tableDraw.removeActor(miseLabel);
				miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				tableDraw.setPosition(500f, 500f, 0);
				tableDraw.add(miseLabel);
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
			else if (clickStop == true && p1.winner(0) == 2) {
				bet  = 0;
				tableDraw.removeActor(miseLabel);
				miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				tableDraw.setPosition(500f, 500f, 0);
				tableDraw.add(miseLabel);
				launchDefeat = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
			
		}
		
		if (click >= 6 && p1.getSize() > 5) {
			animTime8 += Gdx.graphics.getDeltaTime();
			batch.draw(p1.getMainPlayer(0).get(7).getKeyFrame(animTime8, false), 1290f, 80f, 181f, 251f);
			if (clickStop == true && p1.winner(0) == 0) {
				if (p1.HasBJ()) {
					money += bet*2.5;
					bet = 0;
					tableDraw.removeActor(miseLabel);
					miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
					tableDraw.setPosition(500f, 500f, 0);
					tableDraw.add(miseLabel);
				}
				else {
				    money += bet*2;
				    bet = 0;
				    tableDraw.removeActor(miseLabel);
				    miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				    tableDraw.setPosition(500f, 500f, 0);
				    tableDraw.add(miseLabel);
				}
				launchVictory = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
			else if (clickStop == true && p1.winner(0) == 1) {
				launchTie = true;
				money += bet;
				bet = 0;
				tableDraw.removeActor(miseLabel);
				miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				tableDraw.setPosition(500f, 500f, 0);
				tableDraw.add(miseLabel);
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
			else if (clickStop == true && p1.winner(0) == 2) {
				bet  = 0;
				tableDraw.removeActor(miseLabel);
				miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				tableDraw.setPosition(500f, 500f, 0);
				tableDraw.add(miseLabel);
				launchDefeat = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
			
		}
		
		if (click >= 7 && p1.getSize() > 6) {
			animTime9 += Gdx.graphics.getDeltaTime();
			batch.draw(p1.getMainPlayer(0).get(8).getKeyFrame(animTime9, false), 1480f, 172f, 181f, 251f);
			if (clickStop == true && p1.winner(0) == 0) {
				if (p1.HasBJ()) {
					money += bet*2.5;
					bet = 0;
					tableDraw.removeActor(miseLabel);
					miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
					tableDraw.setPosition(500f, 500f, 0);
					tableDraw.add(miseLabel);
					}
				else {
				     money += bet*2;
				    bet = 0;
				    tableDraw.removeActor(miseLabel);
				    miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				    tableDraw.setPosition(500f, 500f, 0);
				    tableDraw.add(miseLabel);
				}
				launchVictory = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
			else if (clickStop == true && p1.winner(0) == 1) {
				money += bet;
				bet = 0;
				tableDraw.removeActor(miseLabel);
				miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				tableDraw.setPosition(500f, 500f, 0);
				tableDraw.add(miseLabel);
				launchTie = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
			else if (clickStop == true && p1.winner(0) == 2) {
				bet  = 0;
				tableDraw.removeActor(miseLabel);
				miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				tableDraw.setPosition(500f, 500f, 0);
				tableDraw.add(miseLabel);
				launchDefeat = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
			
		}
		
		if (click >= 8 && p1.getSize() > 7) {
			animTime10 += Gdx.graphics.getDeltaTime();
			batch.draw(p1.getMainPlayer(0).get(9).getKeyFrame(animTime10, false), 1510f, 140f, 181f, 251f);
			if (clickStop == true && p1.winner(0) == 0) {
				if (p1.HasBJ()) {
					money += bet*2.5;
					bet = 0;
					tableDraw.removeActor(miseLabel);
					miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
					tableDraw.setPosition(500f, 500f, 0);
					tableDraw.add(miseLabel);
				}
				else {
				    money += bet*2;
				    bet = 0;
				    tableDraw.removeActor(miseLabel);
				    miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				    tableDraw.setPosition(500f, 500f, 0);
				    tableDraw.add(miseLabel);
			    }
				launchVictory = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
			else if (clickStop == true && p1.winner(0) == 1) {
				launchTie = true;
				money += bet;
				bet = 0;
				tableDraw.removeActor(miseLabel);
				miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				tableDraw.setPosition(500f, 500f, 0);
				tableDraw.add(miseLabel);
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
			else if (clickStop == true && p1.winner(0) == 2) {
				bet  = 0;
				tableDraw.removeActor(miseLabel);
				miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				tableDraw.setPosition(500f, 500f, 0);
				tableDraw.add(miseLabel);
				launchDefeat = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
			
		}
		
		if (click >= 9 && p1.getSize() > 8) {
			animTime11 += Gdx.graphics.getDeltaTime();
			batch.draw(p1.getMainPlayer(0).get(10).getKeyFrame(animTime11, false), 1540f, 110f, 181f, 251f);
			if (clickStop == true && p1.winner(0) == 0) {
				if (p1.HasBJ()) {
					
					money += bet*2.5;
					bet = 0;
					tableDraw.removeActor(miseLabel);
					miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
					tableDraw.setPosition(500f, 500f, 0);
					tableDraw.add(miseLabel);
				}
				else {
				    money += bet*2;
				    bet = 0;
				    tableDraw.removeActor(miseLabel);
				    miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				    tableDraw.setPosition(500f, 500f, 0);
				    tableDraw.add(miseLabel);
			    }
				launchVictory = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
			else if (clickStop == true && p1.winner(0) == 1) {
				launchTie = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				money += bet;
				bet = 0;
				tableDraw.removeActor(miseLabel);
				miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				tableDraw.setPosition(500f, 500f, 0);
				tableDraw.add(miseLabel);
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
			else if (clickStop == true && p1.winner(0) == 2) {
				bet  = 0;
				tableDraw.removeActor(miseLabel);
				miseLabel = new Label( "Mise = "+ bet + " Banque " + money, skinLabel );
				tableDraw.setPosition(500f, 500f, 0);
				tableDraw.add(miseLabel);
				launchDefeat = true;
				animTimeCroupier2 += Gdx.graphics.getDeltaTime();
				if (p1.afficheMainCroupierNom().size() >= 3) {
					animTimeCroupier3 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(2).getKeyFrame(animTimeCroupier3, false), 860f, 536f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 4) {
					animTimeCroupier4 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(3).getKeyFrame(animTimeCroupier4, false), 890f, 504f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 5) {
					animTimeCroupier5 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(4).getKeyFrame(animTimeCroupier5, false), 920f, 472f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 6) {
					animTimeCroupier6 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(5).getKeyFrame(animTimeCroupier6, false), 950f, 440f, 181f, 251f);
				}
				if (p1.afficheMainCroupierNom().size() >= 7) {
					animTimeCroupier7 += Gdx.graphics.getDeltaTime();
					batch.draw(p1.afficheMainCroupierNom().get(6).getKeyFrame(animTimeCroupier7, false), 980f, 408f, 181f, 251f);
				}
			}
		
		}
		
		if (launchVictory == true) {
			Label.LabelStyle resultStyle = new Label.LabelStyle();
			BitmapFont myFont = new BitmapFont(Gdx.files.internal("font/white.fnt"));
			resultStyle.font = myFont;
			resultStyle.fontColor = Color.WHITE;

			result = new Label("Vous avez Gagné !", resultStyle);
			result.setSize(500f, 440f);
			result.setPosition(350,500);
			stageResult.addActor(result);
		}
		else if (launchTie == true) {
			Label.LabelStyle resultStyle = new Label.LabelStyle();
			BitmapFont myFont = new BitmapFont(Gdx.files.internal("font/white.fnt"));
			resultStyle.font = myFont;
			resultStyle.fontColor = Color.WHITE;

			result = new Label("C'est une égalité !", resultStyle);
			result.setSize(500f, 440f);
			result.setPosition(350,500);
			stageResult.addActor(result);			
		}
		else if (launchDefeat == true) {
			Label.LabelStyle resultStyle = new Label.LabelStyle();
			BitmapFont myFont = new BitmapFont(Gdx.files.internal("font/white.fnt"));
			resultStyle.font = myFont;
			resultStyle.fontColor = Color.WHITE;

			result = new Label("Vous avez Perdu !", resultStyle);
			result.setSize(500f, 440f);
			result.setPosition(350,500);
			stageResult.addActor(result);
		}
		
		if (resultCount == true) {
			stageResult.clear();
			resultCount = false;
		}
		
		if (displayChips == true) {
			for (int i=0; i < red; i++) {
				animTimeAura1 += Gdx.graphics.getDeltaTime();
				batch.draw(animAura.getKeyFrame(animTimeAura1,false) , 590f ,40f);
				animTimeJetons1 += Gdx.graphics.getDeltaTime();
				batch.draw(animRedJ.getKeyFrame(animTimeJetons1, false), screenposRed.x, screenposRed.y);	
			}
			
			if (buttonRedJeton.isPressed() && animRedJ.isAnimationFinished(animTimeJetons1)) {
				animTimeJetons1 = 0f;
				screenposRed.x = 650f;
				screenposRed.y = 380f;
			}
			
			if (red >= 1 && screenposRed.x <= 660) {
				screenposRed.x += 10;
			}
			
			if (red >= 1 && screenposRed.y <= 660) {
				screenposRed.y += 10;
			}
			
			for (int i=0; i < green; i++) {
				animTimeAura2 += Gdx.graphics.getDeltaTime();
				batch.draw(animAura.getKeyFrame(animTimeAura2,false) , 790f ,40f);
				animTimeJetons2 += Gdx.graphics.getDeltaTime();
				batch.draw(animGreenJ.getKeyFrame(animTimeJetons2, false), screenposGreen.x, screenposGreen.y);	
			}
			if (buttonGreenJeton.isPressed() && animGreenJ.isAnimationFinished(animTimeJetons2)) {
					animTimeJetons2 = 0f;
					screenposGreen.x = 850f;
					screenposGreen.y = 380f;
			}

			if (green >= 1 && screenposGreen.x <= 660) {
				screenposGreen.x += 10;
			}
			if (green >= 1 && screenposGreen.y <= 660) {
				screenposGreen.y += 10;
			}
			
			for (int i=0; i < blue; i++) {
				animTimeAura3 += Gdx.graphics.getDeltaTime();
				batch.draw(animAura.getKeyFrame(animTimeAura3,false) , 1190f ,40f);
				animTimeJetons3 += Gdx.graphics.getDeltaTime();
				batch.draw(animBlueJ.getKeyFrame(animTimeJetons3, false), screenposBlue.x, screenposBlue.y);	
			}
			
			if(buttonBlueJeton.isPressed() && animBlueJ.isAnimationFinished(animTimeJetons3)) {
				animTimeJetons3 = 0f;
				screenposBlue.x = 1250f;
				screenposBlue.y = 380f;
			}

				
			if (blue >= 1 && screenposBlue.x <= 660) {
				screenposBlue.x += 10;
			}
			
			if (blue >= 1 && screenposBlue.y <= 660) {
				screenposBlue.y += 10;
			}
			
			for (int i=0; i < yellow; i++) {
				animTimeAura4 += Gdx.graphics.getDeltaTime();
				batch.draw(animAura.getKeyFrame(animTimeAura4,false) , 990f ,40f);
				animTimeJetons4 += Gdx.graphics.getDeltaTime();
				batch.draw(animYellowJ.getKeyFrame(animTimeJetons4, false), screenposYellow.x, screenposYellow.y);	
			}
			
			if (buttonYellowJeton.isPressed() && animYellowJ.isAnimationFinished(animTimeJetons4)) {
				animTimeJetons4 = 0f;
				screenposYellow.x = 1050f;
				screenposYellow.y = 380f;
			}
		
			if (yellow >= 1 && screenposYellow.x <= 660) {
				screenposYellow.x += 10;
			}
			
			if (yellow >= 1 && screenposYellow.y <= 660) {
				screenposYellow.y += 10;
			}		
			
			if (click >= 1 && screenPos.x <= 1125f ) {
				screenPos.x += 8;
			}
			
			if (click >= 1 && screenPos.y >= 140f) {
				screenPos.y -= 5;
			}
		}

		
		batch.end();	
		
		stage.act(delta);
		stage.draw();
		stageResult.act(delta);
		stageResult.draw();
	}
	
	public static int getoto() {
		return score;
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
		
	}

}
