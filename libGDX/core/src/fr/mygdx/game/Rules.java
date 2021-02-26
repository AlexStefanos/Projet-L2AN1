package fr.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
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

public class Rules implements Screen {

	private Stage stage;
	private Table table, table_rules;
	private TextButton buttonBack;
	private Texture Background;
	private Skin skin;
	private BitmapFont black, white;
	private Label rules;
	private TextureAtlas atlas;
	private SpriteBatch batch;
	private static final String textrules = "La partie oppose individuellement chaque joueur contre la banque. "
			+ "Le but est de battre le croupier sans d�passer 21. D�s qu'un joueur fait plus que 21, "
			+ "on dit qu'il � Br�le � ou qu'il � cr�ve � et il perd sa mise initiale. "
			+ "La valeur des cartes est �tablie comme suit : de 2 � 9 -> valeur nominale de la carte\\r\\n chaque figure + "
			+ "le 10 surnomm�es b�che -> 10 points\\r\\n l'As -> 1 ou 11 (au choix).\\r\\n Un Blackjack est compos� d'un As"
			+ " et d'une � buche � (carte ayant pour valeur 10, donc 10, J, Q ou K). Cependant, si le joueur atteint le point 21 en 3 cartes "
			+ "ou plus on compte le point 21 et non pas Blackjack; de m�me lorsque le joueur s�pare deux as et qu'il re�oit une buche pour "
			+ "l'un d'eux.\\r\\n Au d�but de la partie, le croupier distribue une carte face visible � chaque joueur et tire une carte face "
			+ "visible �galement pour lui. Il tire ensuite pour chacun une seconde carte face visible et tire une seconde carte face cach�e "
			+ "pour lui au Blackjack am�ricain. Au blackjack europ�en, le croupier tire sa seconde carte apr�s le tour de jeu des joueurs."
			+ "\\r\\n Puis, il demande au premier joueur de la table (joueur situ� � sa gauche) l'option qu'il d�sire choisir. Si le "
			+ "joueur veut une carte, il doit l'annoncer en disant � Carte ! �. Le joueur peut demander autant de cartes qu'il le souhaite "
			+ "pour approcher la valeur sans la d�passer. Si apr�s le tirage d'une carte, il a d�pass� 21, il perd sa mise et le croupier "
			+ "passe au joueur suivant. S'il d�cide de s'arr�ter, en disant � Je reste �, le croupier passe �galement au joueur suivant."
			+ "\\r\\n Le croupier r�p�te cette op�ration jusqu'� ce que tous les joueurs soient servis.\\r\\n Ensuite, il joue pour lui "
			+ "selon une r�gle simple et codifi�e � la banque tire � 16, reste � 17 �. Ainsi, le croupier tire des cartes jusqu'� atteindre"
			+ " un nombre compris entre 17 et 21 que l'on appelle un point. S'il fait plus de 21, tous les joueurs restants gagnent mais "
			+ "s'il fait son point, seuls gagnent ceux ayant un point sup�rieur au sien (sans avoir saut�). Dans cette situation, le joueur "
			+ "remporte l'�quivalent de sa mise. En cas d'�galit� le joueur garde sa mise mais n'empoche rien en plus. � noter que le "
			+ "blackjack (une b�che et un as en deux cartes) est plus fort que 21 fait en ayant tir� plus de deux cartes. Si un joueur "
			+ "fait blackjack et que le banquier fait 21 en 3 cartes ou plus, le joueur fait blackjack et remporte un fois et demi de sa mise."
			+ " Le banquier lui gagne contre tous les joueurs ayant 20 ou moins. R�ciproquement si la banque a un as et une b�che, elle gagne"
			+ " contre tout joueur ayant 21 en ayant tir� plus de deux cartes. Dans ce cas, si un joueur fait �galement blackjack, il peut "
			+ "r�cup�rer sa mise mais n'est pas pay�, le jeu �tant � �galit�. Un joueur ayant fait blackjack (sauf blackjack � la banque "
			+ "auquel cas il y a �galit�) remporte une fois et demi sa mise.\\r\\n Ces r�gles simples ne sont contrari�es que par quatre "
			+ "cas particuliers : L'assurance. Si la premi�re carte du croupier est un As, un joueur a la possibilit� de s'assurer contre "
			+ "son Blackjack. Pour cela, le joueur paye la moiti� de sa mise initiale. Si le croupier fait Blackjack, le joueur perd sa mise"
			+ " mais se voit payer l'assurance en double (donc b�n�fice 0, perte 0). Si le croupier ne fait pas Blackjack, deux situations "
			+ "sont possibles : Premi�rement, le joueur gagne ; il perd son assurance mais empoche l'�quivalent de sa mise initiale "
			+ "(b�n�fice net 1/2 fois la mise initiale). Deuxi�mement, le joueur perd ; il perd alors l'assurance ainsi que sa mise "
			+ "(perte 1,5 fois la mise initiale). Il peut bien s�r Tirer/Doubler/S�parer apr�s avoir pris l'assurance. "
			+ "Le split / S�parer. Lorsqu'un joueur obtient deux cartes de m�me valeur, il lui est possible de s�parer ces deux cartes "
			+ "afin de jouer avec deux jeux. Pour cela, il doit ajouter la m�me mise que celle qu'il a jou�e au d�part. Une fois les "
			+ "jeux s�par�s, le joueur joue chaque main de la m�me fa�on qu'une main simple. S'il gagne sur les deux jeux, il aura fait "
			+ "d'une pierre deux coups (deux gains en un coup). Si le joueur perd sur un jeu, il ne gagne pas mais ne perd rien. "
			+ "Enfin, s'il perd sur les deux jeux, il aura perdu deux fois en un coup. Si � la suite d'une s�paration, le joueur "
			+ "obtient une troisi�me carte de m�me valeur (sur le premier ou deuxi�me tableau) il peut � nouveau les s�parer et ainsi "
			+ "jouer sur 3 tableaux. En France, cette r�gle est cependant au bon vouloir des casinos (certains autorisent deux jeux"
			+ " maximum, d'autres trois jeux maximum).\\r\\n Une r�gle particuli�re concerne la s�paration de deux as : en s�parant "
			+ "deux as, le joueur ne peut plus recevoir qu'une carte pour chacun des tableaux et ne pourra pas spliter � nouveau s'il "
			+ "re�oit un troisi�me as. En outre Le blackjack n'est pas possible en ayant split� : un joueur qui split deux as et re�oit "
			+ "eux b�ches aura deux 21, mais pas deux blackjack, celui-ci devant �tre r�alis� d�s les deux premi�res cartes. Il s'ensuit "
			+ "pour l'exemple que le joueur ayant s�par� deux as et recevant deux b�ches perd tout contre un as et une figure � la banque."
			+ "\\r\\n Doubler. Apr�s avoir re�u deux cartes, le joueur peut choisir de doubler sa mise � la seule condition de ne recevoir "
			+ "qu'une carte apr�s cela (le joueur est donc oblig� de tirer la carte permettant de doubler). Exemple apr�s la donne, j'ai 11"
			+ " (8 et 3). Le croupier a une carte faible, 6 par exemple. Je choisis alors de doubler ma mise. L'espoir est de recevoir une"
			+ " b�che pour obtenir le point 21 alors que le croupier a peu de chances de faire de m�me. Il est tout � fait possible de "
			+ "doubler apr�s avoir s�par�.\\r\\n En France, jusqu'en 2007, il n'�tait possible de doubler que si le score des deux premi�res"
			+ " cartes �tait 9, 10 ou 11. Cette r�gle a �t� abolie2, et il est d�sormais possible de doubler avec n'importe quel score au "
			+ "blackjack jou� dans les casinos fran�ais.\\r\\n Au Blackjack am�ricain, le joueur double face cach�e (doubling down),"
			+ " c'est-�-dire que la carte qu'il re�oit apr�s avoir doubl� lui est distribu�e face cach�e. Il ne la voit qu'une fois "
			+ "le jeu du croupier termin�.\\r\\n Abandonner / Surrender. Une r�gle qui n'est pas universellement admise, mais n�anmoins"
			+ " autoris� par la l�gislation fran�aise et appliqu�e par certains casinos. Apr�s avoir re�u ses deux premi�res cartes et "
			+ "constatant une carte dangereuse � la banque, un joueur peut d�cider d'abandonner imm�diatement. Il perd simplement la "
			+ "moiti� de sa mise. Attention, l'utilisation de l'abandon dans la plupart des casinos le pratiquant se fait directement"
			+ " apr�s la distribution des cartes ; � partir du moment ou le croupier annonce le r�sultat du premier joueur,"
			+ " il ne sera plus possible d'abandonner, le joueur est donc contraint de jouer.";
	@Override
	public void show() {
		batch = new SpriteBatch();
		Background = new Texture("Background.png");
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
		
		buttonBack = new TextButton("Back", textButtonStyle);
		buttonBack.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
			}
		});
		buttonBack.pad(15f, 40f, 15f, 40f);
		
		LabelStyle rulesStyle = new LabelStyle(black, Color.BLACK);
		rules = new Label(textrules, rulesStyle);
		rules.setFontScale(0.75f);
		
		table_rules.setPosition(1500f, 500f, 0);
		table_rules.add(rules);
		table.setPosition(1700f, 150f, 0);
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
