package fr.mygdx.game;

import com.badlogic.gdx.Game;

import fr.mygdx.game.splashscreen.MainMenu;
import fr.mygdx.game.splashscreen.Splash;

/**
 * Classe qui permet de faire la transition entre le splashscreen et le menu principal
 * @author arthu
 *
 */
public class BLACKJACKCity extends Game {
	public static final String TITLE = "BLACKJACK City";
	private AppPreferences preferences;
	private Options option;
	private MainMenu mainmenu;
	private SinglePlayer singleplayer;
	private DuoPlayers duoplayers;
	private QuadraPlayers quadraplayers;
	private TrioPlayers trioplayers;
	private Play play;
	private Rules rules;
	private Audio audio;
	private History history;

	public final static int AUDIO = 1;
	public final static int OPTION = 2;
	public final static int MAINMENU = 3;
	public final static int SINGLEPLAYER = 4;
	public final static int DUOPLAYERS = 5;
	public final static int TRIOPLAYERS = 6;
	public final static int QUADRAPLAYERS = 7;
	public final static int PLAY = 8;
	public final static int RULES = 9;
	public final static int HISTORY = 10;
	
	/**
	 * Permet de creer la fenetre.
	 */
	@Override
	public void create () {
		setScreen(new Splash(this));
		preferences = new AppPreferences();
	}

	/**
	 * Gestion de tous les affichages de la classe.
	 */
	@Override
	public void render () {
		super.render();
	}
	/**
	 * Cette fonction nous permet de pouvoir changer d'ecran.
	 * @param screen
	 */
	public void changeScreen(int screen){
		switch(screen){
			case AUDIO:
				if(audio == null) audio = new Audio(this);
				this.setScreen(audio);
				break;
			case OPTION:
				if(option == null) option = new Options(this);
				this.setScreen(option);
				break;
			case MAINMENU:
				if(mainmenu == null) mainmenu = new MainMenu(this);
				this.setScreen(mainmenu);
				break;
			case SINGLEPLAYER:
				if(singleplayer == null) singleplayer = new SinglePlayer(this);
				this.setScreen(singleplayer);
				break;	
			case DUOPLAYERS:
				if(duoplayers == null) duoplayers = new DuoPlayers(this);
				this.setScreen(duoplayers);
				break;	
			case TRIOPLAYERS:
				if(trioplayers == null) trioplayers = new TrioPlayers(this);
				this.setScreen(trioplayers);
				break;	
			case QUADRAPLAYERS:
				if(quadraplayers == null) quadraplayers = new QuadraPlayers(this);
				this.setScreen(quadraplayers);
				break;	
			case PLAY:
				if(play == null) play = new Play(this);
				this.setScreen(play);
				break;	
			case RULES:
				if(rules == null) rules = new Rules(this);
				this.setScreen(rules);
				break;	
			case HISTORY:
				if(history == null) history = new History(this);
				this.setScreen(history);
				break;	
		}
	}
	
	/**
	 * Permet de fermer proprement la variable donnee (methodes, stage, etc.) 
	 */
	@Override
	public void dispose () {
		super.dispose();
	}
	
	/**
	 * Permet de redimensionner des Textures, bouttons, etc. affiche a l'ecran
	 */
	@Override
	public void resize(int weidth, int height ) {
		super.resize(weidth, height);
	}
	
	/**
	 * Gestion des pauses du jeu
	 */
	@Override
	public void pause() {
		super.pause();
	}
	/**
	 * Permet de charger les options de l'utilisateur en sauvegarde dès le demarrage du jeu.
	 * @return
	 */
	public AppPreferences getPreferences(){
		return this.preferences;
	}
	
	/**
	 * Gestion de la reprise des pauses 
	 */
	@Override
	public void resume() {
		super.resume();
	}
}
