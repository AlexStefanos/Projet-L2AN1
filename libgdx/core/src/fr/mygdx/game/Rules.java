package fr.mygdx.game;

import com.badlogic.gdx.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
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
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import fr.mygdx.game.splashscreen.MainMenu;
import fr.mygdx.game.Options;

public class Rules implements Screen {

	private Stage stage;
	private Table table, table_rules;
	private TextButton buttonBack;
	private Texture Background;
	private Texture Image;
	private Skin skin;
	private BitmapFont black, white;
	private Label rules;
	private TextureAtlas atlas;
	private SpriteBatch batch;
	private Music pressbutton;
	private Music music;
	private  BLACKJACKCity parent;
	
	
	private static final String textrules = "REGLES PRINCIPALES :\n"
			    		+ "Voici les regles de base a connaitre pour le Blackjack :\n"
						+ "La partie oppose individuellement chaque joueur contre la banque. Le but est de battre le croupier sans d�passer 21.\n"
						+ "D�s qu'un joueur fait plus que 21, on dit qu'il � Br�le � ou qu'il � cr�ve � et il perd sa mise initiale.\n"
						+ "La valeur des cartes est �tablie comme suit : -De 2 � 9 -> valeur nominale de la carte l'As -> 1 ou 11 (au choix).\n"
						+ "                                                   -Chaque figure + le 10 surnomm�es b�che -> 10 points\n"
						+ "                                                   -l'As -> 1 ou 11 (au choix).\n"
						+ "\n"
						+ "\n"
						+ "\n"
						+ "\n"
						+ "\n"
						+ "\n"
						+ "\n"
						+ "\n"
						+ "\n"
						+ "\n"
						+ "\n"
						+ "\n"
						+ "\n"
						+ "\n"
						+ "Un Blackjack est compos� d'une b�che et d'un As ce qui fait 21, si on obtient 21 avec 3 cartes ou plus, ce n'est pas un blackjack mais un 21\n"
						+ "Dans un premier temps, le(s) joueur(s) mise(nt) puis le croupier distribue 2 cartes visibles a chaque joueur, et 1 carte visible ainsi qu'une\n"
						+ "carte non visible pour lui. Le premier joueur (celui a la gauche du croupier) commence :\n"
						+ "Il peut tirer autant de carte qu'il veut tant qu'il ne d�passe pas 21 ou qu'il n'a pas atteint 21. Si il d�passe 21, il perd sa mise initiale, on dit qu'il 'bust'.\n"
						+ "Il peut d�cider de s'arreter de tirer des cartes, on dit qu'il 'stay', ainsi chaque joueur joue en tirant tour par tour leurs cartes, et ce jusqu'a ce que tous les\n"
						+ "joueurs aient jou�. Maintenant, c'est au tour du croupier, qui d�voile sa seconde carte et va tirer tant qu'il n'a pas 17 points ou plus.\n"
						+ "\n"
						+ "Le croupier poss�de en premi�re carte un AS :\n"
						+ "Ici, l'AS est une carte dangereuse car si la deuxi�me carte est un 10, le joueur perd dans tous les cas, une option s'offre a lui : l'assurance, cela consiste \n"
						+ "a payer la moiti� de la mise initiale mais le joueur ne peut pas perdre la main(Il perd donc seulement la moiti� de sa mise).\n"
						+ "\n"
						+ "Si le joueur pense avoir un bon jeu contre le croupier, a condition qu'il n'ai pas tir� une seul fois pendant la main, il peut prendre\n"
						+ "le d�cision de doubler sa mise mais ne pourra tirer qu'une seule carte.\n"
						+ "\n"
						+ "Parfois, il arrive que le joueur pioche deux cartes de m�me valeur (deux 8 ou meme un Valet et une Dame), dans ce cas, il peut d�cider\n"
						+ "de 'Split', cela consiste a s�parer ses deux cartes pour avoir 2 mains et en meme temps doubler la mise(la mise initiale par main) Il pourra\n"
						+ "ainsi jouer ses deux mains dans le meme tour, avec les memes r�gles que pr�c�demment, sauf une :\n"
						+ "Si le joueur d�cide de Split deux As alors il ne pourra piocher qu'une seule carte en plus de son AS pour ses deux mains.\n";
	
	public Rules(BLACKJACKCity box2dTutorial){
		parent = box2dTutorial;
	}
	
	@Override
	public void show() {
		batch = new SpriteBatch();
		Background = new Texture("Backgroundrules.png");
		Image = new Texture("Tableau.png");
		atlas = new TextureAtlas("ui/button.pack");
		skin = new Skin(atlas);
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		table = new Table(skin);
		table_rules = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		table_rules.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		black = new BitmapFont(Gdx.files.internal("font/black.fnt"), false);
		white = new BitmapFont(Gdx.files.internal("font/white.fnt"), false);
		
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.getDrawable("button.up");
		textButtonStyle.down = skin.getDrawable("button.down");
		textButtonStyle.pressedOffsetX = 1;
		textButtonStyle.pressedOffsetY = -1;
		textButtonStyle.font = black;
		pressbutton = Gdx.audio.newMusic(Gdx.files.internal("pressbutton.mp3"));
		music = Gdx.audio.newMusic(Gdx.files.internal("Rulesmusic.mp3"));
		
		music.setLooping(true);
		music.setVolume(AppPreferences.MVOLUME);
		music.play();
		pressbutton.setVolume(AppPreferences.SVOLUME);
		
		buttonBack = new TextButton("Back", textButtonStyle);
		buttonBack.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				parent.changeScreen(BLACKJACKCity.MAINMENU);
				pressbutton.play();
				music.dispose();
			}
		});
		buttonBack.pad(15f, 40f, 15f, 40f);
		
		LabelStyle rulesStyle = new LabelStyle(white, Color.WHITE);
		rules = new Label(textrules, rulesStyle);
		rules.setFontScale(0.75f);
		
		table_rules.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2f,0);
		table_rules.add(rules);
		table.setPosition(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/20,0);
		table.add(buttonBack);
		table.getCell(buttonBack).spaceBottom(35f);
		table.row();
		stage.addActor(table);
		stage.addActor(table_rules);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(2, 2, 2, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(Background,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(Image,Gdx.graphics.getWidth()/4f,Gdx.graphics.getHeight()/2f,664f,289f);
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
