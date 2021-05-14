package fr.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
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

@SuppressWarnings("unused")
/**
 * Mode pour quatre joueurs.
 * 
 *
 */
public class QuadraPlayers implements Screen{
	private Stage stage;
	private SpriteBatch batch;
	private Texture BlackjackTable;
	private TextButton buttonQuit, buttonTirer, buttonJouer, buttonMiser, buttonRedJeton, buttonGreenJeton, buttonBlueJeton, buttonYellowJeton;
	private BitmapFont black;
	private Table table, tableJeu, tableQuit, tableJeu2, tableRedJeton, tableGreenJeton, tableBlueJeton, tableYellowJeton;
	private TextureAtlas atlas, atlas2, atlas3, atlas4, atlas5, atlasLabel,atlasAnimRedJ,atlasAnimGreenJ, atlasAnimBlueJ, atlasAnimYellowJ, cards1,atlasAura;
	private Skin skin, skin2, skin3, skin4, skin5,skinLabel;
	
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
	
	public QuadraPlayers(BLACKJACKCity blackjackcity){
		parent = blackjackcity;
	}
	
	private ArrayList<Animation<TextureRegion>> animationPack;
	private Player[] joueurs = new Player[2];
	Deck paquet = new Deck(animationPack);
	Cards p1 = new Cards(paquet);
	
	private int p1Carte = 0;//, p2Carte = 0;
	
	/**
	 * Lorsqu'une classe est a l'ecran, show() est la premiere methode a etre appele. Par convention, on initialise les variables de la classe dans cette methode.
	 */
	@Override
	public void show() {
		batch = new SpriteBatch();
		BlackjackTable = new Texture("BlackjackTable QuadraPlayers.png");
		
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
		pressbutton = Gdx.audio.newMusic(Gdx.files.internal("pressbutton.mp3"));
		
		
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
			
		
		pressbutton.setVolume(AppPreferences.SVOLUME);
			
		buttonQuit = new TextButton("Quit to Main Menu", textButtonStyle);
		buttonQuit.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				parent.changeScreen(BLACKJACKCity.MAINMENU);
				pressbutton.play();
				
			}
		});
		buttonQuit.pad(15f, 40f, 15f, 40f);
			
		buttonJouer = new TextButton("Play (Will soon be Available)", textButtonStyle);
		buttonJouer.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
			}
		});
		buttonJouer.pad(15f, 40f, 15f, 40f);
			
		buttonTirer = new TextButton("Hit", textButtonStyle);
		buttonTirer.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pressbutton.play();
				cliqueJ1++;
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
		
		tableRedJeton.setPosition(650f,100f, 0);
		tableRedJeton.add(buttonRedJeton);

		tableGreenJeton.setPosition(850f,100f, 0);
		tableGreenJeton.add(buttonGreenJeton);
		
		tableBlueJeton.setPosition(1250f,100f, 0);
		tableBlueJeton.add(buttonBlueJeton);
		
		tableYellowJeton.setPosition(1050f,100f, 0);
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

	/**
	 * Gestion de tous les affichages de la classe.
	 */
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(2, 2, 2, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		lancement++;
		
		batch.begin();
		batch.draw(BlackjackTable, 0,   0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		if (buttonJouer.isChecked()) {
			animTimeDebut += Gdx.graphics.getDeltaTime();
			animTimeCroupier += Gdx.graphics.getDeltaTime();
		}
		
		batch.end();
		
		stage.act(delta);
		stage.draw();
	}

	/**
	 * Permet de redimensionner des Textures, bouttons, etc. affiche a l'ecran
	 */
	@Override
	public void resize(int width, int height) {

	}
	
	/**
	 * Gestion des pauses du jeu
	 */
	@Override
	public void pause() {

	}
	
	/**
	 * Gestion de la reprise des pauses 
	 */
	@Override
	public void resume() {

	}

	/**
	 * Gestion des Textures, bouttons, etc. non-affiche a l'ecran
	 */
	@Override
	public void hide() {

	}

	/**
	 * Permet de fermer proprement la variable donnee (methodes, stage, etc.) 
	 */
	@Override
	public void dispose() {

	}
}
