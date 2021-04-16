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

public class History implements Screen{
	
	private  BLACKJACKCity parent;
	private Stage stage;
	private Texture Background;
	private Skin skin, skinLabel;
	private BitmapFont black, white;
	private TextureAtlas atlas;
	private SpriteBatch batch;
	private Music pressbutton;
	private Music music;
	private TextButton buttonBack;
	private Table table,tableLabel;
	private Label scoreLabel;
	private Label label0;
	private int i,e,p;
	
	private ArrayList<Animation<TextureRegion>> animationPack;
	private Joueur[] joueurs = new Joueur[1];
	Deck paquet = new Deck(animationPack);
	//Deck paquetnom = new Deck(); Inutile pour l'instant
	Cartes p1 = new Cartes(paquet);
	Cartes p2 = new Cartes(paquet);
	private int p1Carte = 0, p2Carte = 0;
	
	public History(BLACKJACKCity box2dTutorial){
		parent = box2dTutorial;
	}
	
	@Override
	public void show() {
		
		batch = new SpriteBatch();
		Background = new Texture("Background.png");
		atlas = new TextureAtlas("ui/button.pack");
		skin = new Skin(atlas);
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tableLabel = new Table(skin);
		tableLabel.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		black = new BitmapFont(Gdx.files.internal("font/black.fnt"), false);
		white = new BitmapFont(Gdx.files.internal("font/white.fnt"), false);
		pressbutton = Gdx.audio.newMusic(Gdx.files.internal("pressbutton.mp3"));
		music = Gdx.audio.newMusic(Gdx.files.internal("Playmusic.mp3"));
		skinLabel = new Skin(Gdx.files.internal("skindefault/uiskin.json"));
		
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
	    p = 0;
	    for(int z = 0; z < AppPreferences.J || z <= 10; z++) {
	    	if(z <= 9 && AppPreferences.J <= 10) {
	    		Label.LabelStyle label0Style = new Label.LabelStyle();
	    		BitmapFont myFont = new BitmapFont(Gdx.files.internal("font/whitescores.fnt"));
	    		label0Style.font = myFont;
	    		label0Style.fontColor = Color.GREEN;
	    
	    		label0 = new Label("Mode de jeu : "+((Cartes.getotoS(z) == "")? "---" : Cartes.getotoS(z))+" Score = "+((Cartes.getoto(z) == 0)? "---" : Cartes.getoto(z)),label0Style);
	    		label0.setSize(Gdx.graphics.getWidth(),row_height);
	    		label0.setPosition(200,200+e);
	    		stage.addActor(label0);
	    		e = e + 70;
	    	}
	    	if(AppPreferences.J > 10) {
	    		i = AppPreferences.J -10;
	    		if (z >= i ) {
		    		Label.LabelStyle label0Style = new Label.LabelStyle();
			    	BitmapFont myFont = new BitmapFont(Gdx.files.internal("font/whitescores.fnt"));
			    	label0Style.font = myFont;
			    	label0Style.fontColor = Color.GREEN;
			    
			    	label0 = new Label("Mode de jeu : "+((Cartes.getotoS(z) == "")? "---" : Cartes.getotoS(z))+" Score = "+((Cartes.getoto(z) == 0)? "---" : Cartes.getoto(z)),label0Style);
			    	label0.setSize(Gdx.graphics.getWidth(),row_height);
			    	label0.setPosition(200,200+e);
			    	stage.addActor(label0);
			    	e = e + 70;
	    		}
		    }
	    }
	    
	    
	   /* Label.LabelStyle label1Style = new Label.LabelStyle();
	    label1Style.font = myFont;
	    label1Style.fontColor = Color.GREEN;
	    
	    Label label1 = new Label("Mode de jeu : "+Cartes.getotoS(1)+" Score = "+((Cartes.getoto(1) == 0)? 000 : Cartes.getoto(1)),label1Style);
	    label1.setSize(Gdx.graphics.getWidth(),row_height);
	    label1.setPosition(0,300);
	    label1.setAlignment(Align.center);
	    stage.addActor(label1);
	    
	    Label.LabelStyle label2Style = new Label.LabelStyle();
	    label2Style.font = myFont;
	    label2Style.fontColor = Color.GREEN;
	    
	    Label label2 = new Label("Mode de jeu : "+Cartes.getotoS(2)+" Score = "+ ((Cartes.getoto(2) == 0)? 000 : Cartes.getoto(2)),label0Style);
	    label2.setSize(Gdx.graphics.getWidth(),row_height);
	    label2.setPosition(0,100);
	    label2.setAlignment(Align.center);
	    stage.addActor(label2);*/
	    
	    

	    
		music.setLooping(true);
		music.setVolume(AppPreferences.MVOLUME);
		music.play();
		pressbutton.setVolume(AppPreferences.SVOLUME);
		

		
		
		
		
		
		buttonBack = new TextButton("Back", textButtonStyle);
		buttonBack.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				parent.changeScreen(BLACKJACKCity.PLAY);
				pressbutton.play();
				music.dispose();
			}
		});
		p1.initialisation();
		buttonBack.pad(15f, 40f, 15f, 40f);
		
		table.setPosition(1700f, 150f, 0);
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
