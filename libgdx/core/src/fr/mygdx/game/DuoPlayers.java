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
	private Texture BlackjackTable, FondCarteBleu, AsTrefle, DeuxTrefle, TroisTrefle, QuatreTrefle, CinqTrefle, SixTrefle, 
	SeptTrefle, HuitTrefle, NeufTrefle, DixTrefle, ValetTrefle, DameTrefle, RoiTrefle, AsCarreau, DeuxCarreau, TroisCarreau, QuatreCarreau, 
	CinqCarreau, SixCarreau, SeptCarreau, HuitCarreau, NeufCarreau, DixCarreau, ValetCarreau, DameCarreau, RoiCarreau, AsCoeur, DeuxCoeur, TroisCoeur,
	QuatreCoeur, CinqCoeur, SixCoeur, SeptCoeur, HuitCoeur, NeufCoeur, DixCoeur, ValetCoeur, DameCoeur, RoiCoeur, AsPique, DeuxPique, 
	TroisPique, QuatrePique, CinqPique, SixPique, SeptPique, HuitPique, NeufPique, DixPique, ValetPique, DamePique, RoiPique, JokerBlack, 
	JokerRed, JetonBleu, JetonRouge, JetonVert, JetonJaune, JetonBleuClair, JetonBeige, JetonBlanc;
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
	
	public DuoPlayers(BLACKJACKCity box2dTutorial){
		parent = box2dTutorial;
	}
		
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
		
		tableRedJeton.setPosition(100f,700f, 0);
		tableRedJeton.add(buttonRedJeton);
		table.row();
		
		tableGreenJeton.setPosition(200f,100f, 0);
		tableGreenJeton.add(buttonGreenJeton);
		table.row();
		
		tableBlueJeton.setPosition(300f,100f, 0);
		tableBlueJeton.add(buttonBlueJeton);
		table.row();
		
		tableYellowJeton.setPosition(2000f,1000f, 0);
		tableYellowJeton.add(buttonYellowJeton);
		table.row();
		
		
		stage.addActor(table);
		stage.addActor(tableJeu);
		stage.addActor(tableJeu2);
		stage.addActor(buttonRedJeton);
		stage.addActor(buttonGreenJeton);
		stage.addActor(buttonBlueJeton);
		stage.addActor(buttonYellowJeton);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(2, 2, 2, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
		batch.begin();
		batch.draw(BlackjackTable, 0,   0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		if (buttonJouer.isChecked()) {
			//if (Cartes.mains) 		si la 1ere carte est un as de coeur par exemple, batch.draw(AsCoeur)
			batch.draw(AsCoeur, 1125f, 172f, 103f, 138f); //1ere Carte J1
			batch.draw(AsCoeur, 713f, 172f, 103f, 138f); //1ere Carte J2
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
			batch.draw(AsCoeur, 1155f, 140f, 103f, 138f);
			if (cliqueJ1 >= 2) {
				batch.draw(AsCoeur, 1185f, 110f, 103f, 138f);
				if (cliqueJ1 >= 3) {
					batch.draw(AsCoeur, 1215f, 80f, 103f, 138f);
					if (cliqueJ1 >= 4) {
						batch.draw(AsCoeur, 1345f, 172f, 103f, 138f);
						if (cliqueJ1 >= 5) {
							batch.draw(AsCoeur, 1375f, 140f, 103f, 138f);
							if (cliqueJ1 >= 6) {
								batch.draw(AsCoeur, 1405f, 110f, 103f, 138f);
								if (cliqueJ1 >= 7) {
									batch.draw(AsCoeur, 1435f, 80f, 103f, 138f);
									if (cliqueJ1 >= 8) {
										batch.draw(AsCoeur, 1565f, 172f, 103f, 138f);
										if (cliqueJ1 >= 9) {
											batch.draw(AsCoeur, 1595f, 140f, 103f, 138f);
											if (cliqueJ1 >= 10) {
												batch.draw(AsCoeur, 1625f, 110f, 103f, 138f);
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
			batch.draw(AsCoeur, 740f, 140f, 103f, 138f);
			if (cliqueJ2 >= 2) {
				batch.draw(AsCoeur, 770f, 110f, 103f, 138f);
				if (cliqueJ2 >= 3) {
					batch.draw(AsCoeur, 800f, 80f, 103f, 138f);
					if (cliqueJ2 >= 4) {
						batch.draw(AsCoeur, 520f, 172f, 103f, 138f);
						if (cliqueJ2 >= 5) {
							batch.draw(AsCoeur, 550f, 140f, 103f, 138f);
							if (cliqueJ2 >= 6) {
								batch.draw(AsCoeur, 580f, 110f, 103f, 138f);	
								if (cliqueJ2 >= 7) {
									batch.draw(AsCoeur, 610f, 80f, 103f, 138f);
									if (cliqueJ2 >= 8) {
										batch.draw(AsCoeur, 350f, 172f, 103f, 138f);
										if (cliqueJ2 >= 9){
											batch.draw(AsCoeur, 380f, 140f, 103f, 138f);
											if (cliqueJ2 >= 10) {
												batch.draw(AsCoeur, 410f, 110f, 103f, 138f);
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
