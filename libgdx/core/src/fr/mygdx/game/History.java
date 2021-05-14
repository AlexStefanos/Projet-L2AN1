package fr.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
/**
 * Classe qui gère l'historique des parties
 * @author arthu
 *
 */
@SuppressWarnings("unused")
public class History implements Screen{
	
	private  BLACKJACKCity parent;
	private Stage stage;
	private Texture Background;
	private Skin skin;
	private BitmapFont black;
	private TextureAtlas atlas;
	private SpriteBatch batch;
	private Music pressbutton;
	private Music music;
	private TextButton buttonBack;
	private Table table,tableLabel;
	private Label label0,label1;
	private int i,e;
	
	private ArrayList<Animation<TextureRegion>> animationPack;
	Deck paquet = new Deck(animationPack);
	Cards p1 = new Cards(paquet);
	Cards p2 = new Cards(paquet);
	
	public History(BLACKJACKCity blackjackcity){
		parent = blackjackcity;
	}
	
	/**
	 * Lorsqu'une classe est a l'ecran, show() est la premiere methode a etre appele. Par convention, on initialise les variables de la classe dans cette methode.
	 */
	@Override
	public void show() {
		batch = new SpriteBatch();
		Background = new Texture("FondHistory.png");
		atlas = new TextureAtlas("ui/button.pack");
		skin = new Skin(atlas);
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableLabel = new Table(skin);
		tableLabel.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		black = new BitmapFont(Gdx.files.internal("font/black.fnt"), false);
		pressbutton = Gdx.audio.newMusic(Gdx.files.internal("pressbutton.mp3"));
		
		
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.getDrawable("button.up");
		textButtonStyle.down = skin.getDrawable("button.down");
		textButtonStyle.pressedOffsetX = 1;
		textButtonStyle.pressedOffsetY = -1;
		textButtonStyle.font = black;
		
		p1.initialisation();
		
		int row_height = Gdx.graphics.getWidth() / 12;
	    int col_width = Gdx.graphics.getWidth() / 12;
	    e = 0;
	    
	    Label.LabelStyle label1Style = new Label.LabelStyle();
		BitmapFont myFont = new BitmapFont(Gdx.files.internal("font/whitescores.fnt"));
		label1Style.font = myFont;
		label1Style.fontColor = Color.WHITE;

		label1 = new Label("SCOREBOARDS :",label1Style);
		label1.setSize(Gdx.graphics.getWidth(),row_height);
		label1.setPosition(350,500);
		stage.addActor(label1);
	    
	    for (int z = 0; z < AppPreferences.J || z <= 10; z++) {
	    	if(z <= 9 && AppPreferences.J <= 10) {
	    		Label.LabelStyle label0Style = new Label.LabelStyle();
	    		BitmapFont myFont1 = new BitmapFont(Gdx.files.internal("font/whitescores.fnt"));
	    		label0Style.font = myFont1;
	    		label0Style.fontColor = Color.WHITE;
	    
	    		label0 = new Label(((Cards.getotoS(z) == "")? "---" : Cards.getotoS(z))+"  Score = "+((Cards.getoto(z) == 0)? "---" : Cards.getoto(z))+"  "+((Cards.getotoWL(z) == "")? "---" : Cards.getotoWL(z)),label0Style);
	    		label0.setSize(Gdx.graphics.getWidth(),row_height);
	    		label0.setPosition(820,150+e);
	    		stage.addActor(label0);
	    		e = e + 70;
	    	}
	    	if (AppPreferences.J > 10) {
	    		i = AppPreferences.J -10;
	    		if (z >= i ) {
		    		Label.LabelStyle label0Style = new Label.LabelStyle();
			    	BitmapFont myFont1 = new BitmapFont(Gdx.files.internal("font/whitescores.fnt"));
			    	label0Style.font = myFont1;
			    	label0Style.fontColor = Color.WHITE;
			    
			    	label0 = new Label(((Cards.getotoS(z) == "")? "---" : Cards.getotoS(z))+"  Score = "+((Cards.getoto(z) == 0)? "---" : Cards.getoto(z))+"  "+((Cards.getotoWL(z) == "")? "---" : Cards.getotoWL(z)),label0Style);
			    	label0.setSize(Gdx.graphics.getWidth(),row_height);
			    	label0.setPosition(820,150+e);
			    	stage.addActor(label0);
			    	e = e + 70;
	    		}
		    }
	    }
	    
		
		
		pressbutton.setVolume(AppPreferences.SVOLUME);

		buttonBack = new TextButton("Back", textButtonStyle);
		buttonBack.addListener(new ClickListener() {
			/**
			 * Determine lorsque l'on clique sur un bouton.
			 * @param event,x,y
			 */
			@Override
			public void clicked(InputEvent event, float x, float y) {
				parent.changeScreen(BLACKJACKCity.PLAY);
				pressbutton.play();
				
			}
		});
		p1.initialisation();
		buttonBack.pad(15f, 40f, 15f, 40f);
		
		table.setPosition(1500f, 100f, 0);
		table.add(buttonBack);
		
		stage.addActor(table);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(2, 2, 2, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.draw(Background,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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
