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
			+ "Le but est de battre le croupier sans dépasser 21. Dès qu'un joueur fait plus que 21, "
			+ "on dit qu'il ‘ Brûle ‘ ou qu'il ‘ crève ‘ et il perd sa mise initiale. "
			+ "La valeur des cartes est établie comme suit : de 2 à 9 -> valeur nominale de la carte\\r\\n chaque figure + "
			+ "le 10 surnommées bûche -> 10 points\\r\\n l'As -> 1 ou 11 (au choix).\\r\\n Un Blackjack est composé d'un As"
			+ " et d'une ‘ buche ‘ (carte ayant pour valeur 10, donc 10, J, Q ou K). Cependant, si le joueur atteint le point 21 en 3 cartes "
			+ "ou plus on compte le point 21 et non pas Blackjack; de même lorsque le joueur sépare deux as et qu'il reçoit une buche pour "
			+ "l'un d'eux.\\r\\n Au début de la partie, le croupier distribue une carte face visible à chaque joueur et tire une carte face "
			+ "visible également pour lui. Il tire ensuite pour chacun une seconde carte face visible et tire une seconde carte face cachée "
			+ "pour lui au Blackjack américain. Au blackjack européen, le croupier tire sa seconde carte après le tour de jeu des joueurs."
			+ "\\r\\n Puis, il demande au premier joueur de la table (joueur situé à sa gauche) l'option qu'il désire choisir. Si le "
			+ "joueur veut une carte, il doit l'annoncer en disant ‘ Carte ! ‘. Le joueur peut demander autant de cartes qu'il le souhaite "
			+ "pour approcher la valeur sans la dépasser. Si après le tirage d'une carte, il a dépassé 21, il perd sa mise et le croupier "
			+ "passe au joueur suivant. S'il décide de s'arrêter, en disant ‘ Je reste ‘, le croupier passe également au joueur suivant."
			+ "\\r\\n Le croupier répète cette opération jusqu'à ce que tous les joueurs soient servis.\\r\\n Ensuite, il joue pour lui "
			+ "selon une règle simple et codifiée ‘ la banque tire à 16, reste à 17 ‘. Ainsi, le croupier tire des cartes jusqu'à atteindre"
			+ " un nombre compris entre 17 et 21 que l'on appelle un point. S'il fait plus de 21, tous les joueurs restants gagnent mais "
			+ "s'il fait son point, seuls gagnent ceux ayant un point supérieur au sien (sans avoir sauté). Dans cette situation, le joueur "
			+ "remporte l'équivalent de sa mise. En cas d'égalité le joueur garde sa mise mais n'empoche rien en plus. À noter que le "
			+ "blackjack (une bûche et un as en deux cartes) est plus fort que 21 fait en ayant tiré plus de deux cartes. Si un joueur "
			+ "fait blackjack et que le banquier fait 21 en 3 cartes ou plus, le joueur fait blackjack et remporte un fois et demi de sa mise."
			+ " Le banquier lui gagne contre tous les joueurs ayant 20 ou moins. Réciproquement si la banque a un as et une bûche, elle gagne"
			+ " contre tout joueur ayant 21 en ayant tiré plus de deux cartes. Dans ce cas, si un joueur fait également blackjack, il peut "
			+ "récupérer sa mise mais n'est pas payé, le jeu étant à égalité. Un joueur ayant fait blackjack (sauf blackjack à la banque "
			+ "auquel cas il y a égalité) remporte une fois et demi sa mise.\\r\\n Ces règles simples ne sont contrariées que par quatre "
			+ "cas particuliers : L'assurance. Si la première carte du croupier est un As, un joueur a la possibilité de s'assurer contre "
			+ "son Blackjack. Pour cela, le joueur paye la moitié de sa mise initiale. Si le croupier fait Blackjack, le joueur perd sa mise"
			+ " mais se voit payer l'assurance en double (donc bénéfice 0, perte 0). Si le croupier ne fait pas Blackjack, deux situations "
			+ "sont possibles : Premièrement, le joueur gagne ; il perd son assurance mais empoche l'équivalent de sa mise initiale "
			+ "(bénéfice net 1/2 fois la mise initiale). Deuxièmement, le joueur perd ; il perd alors l'assurance ainsi que sa mise "
			+ "(perte 1,5 fois la mise initiale). Il peut bien sûr Tirer/Doubler/Séparer après avoir pris l'assurance. "
			+ "Le split / Séparer. Lorsqu'un joueur obtient deux cartes de même valeur, il lui est possible de séparer ces deux cartes "
			+ "afin de jouer avec deux jeux. Pour cela, il doit ajouter la même mise que celle qu'il a jouée au départ. Une fois les "
			+ "jeux séparés, le joueur joue chaque main de la même façon qu'une main simple. S'il gagne sur les deux jeux, il aura fait "
			+ "d'une pierre deux coups (deux gains en un coup). Si le joueur perd sur un jeu, il ne gagne pas mais ne perd rien. "
			+ "Enfin, s'il perd sur les deux jeux, il aura perdu deux fois en un coup. Si à la suite d'une séparation, le joueur "
			+ "obtient une troisième carte de même valeur (sur le premier ou deuxième tableau) il peut à nouveau les séparer et ainsi "
			+ "jouer sur 3 tableaux. En France, cette règle est cependant au bon vouloir des casinos (certains autorisent deux jeux"
			+ " maximum, d'autres trois jeux maximum).\\r\\n Une règle particulière concerne la séparation de deux as : en séparant "
			+ "deux as, le joueur ne peut plus recevoir qu'une carte pour chacun des tableaux et ne pourra pas spliter à nouveau s'il "
			+ "reçoit un troisième as. En outre Le blackjack n'est pas possible en ayant splité : un joueur qui split deux as et reçoit "
			+ "eux bûches aura deux 21, mais pas deux blackjack, celui-ci devant être réalisé dès les deux premières cartes. Il s'ensuit "
			+ "pour l'exemple que le joueur ayant séparé deux as et recevant deux bûches perd tout contre un as et une figure à la banque."
			+ "\\r\\n Doubler. Après avoir reçu deux cartes, le joueur peut choisir de doubler sa mise à la seule condition de ne recevoir "
			+ "qu'une carte après cela (le joueur est donc obligé de tirer la carte permettant de doubler). Exemple après la donne, j'ai 11"
			+ " (8 et 3). Le croupier a une carte faible, 6 par exemple. Je choisis alors de doubler ma mise. L'espoir est de recevoir une"
			+ " bûche pour obtenir le point 21 alors que le croupier a peu de chances de faire de même. Il est tout à fait possible de "
			+ "doubler après avoir séparé.\\r\\n En France, jusqu'en 2007, il n'était possible de doubler que si le score des deux premières"
			+ " cartes était 9, 10 ou 11. Cette règle a été abolie2, et il est désormais possible de doubler avec n'importe quel score au "
			+ "blackjack joué dans les casinos français.\\r\\n Au Blackjack américain, le joueur double face cachée (doubling down),"
			+ " c'est-à-dire que la carte qu'il reçoit après avoir doublé lui est distribuée face cachée. Il ne la voit qu'une fois "
			+ "le jeu du croupier terminé.\\r\\n Abandonner / Surrender. Une règle qui n'est pas universellement admise, mais néanmoins"
			+ " autorisé par la législation française et appliquée par certains casinos. Après avoir reçu ses deux premières cartes et "
			+ "constatant une carte dangereuse à la banque, un joueur peut décider d'abandonner immédiatement. Il perd simplement la "
			+ "moitié de sa mise. Attention, l'utilisation de l'abandon dans la plupart des casinos le pratiquant se fait directement"
			+ " après la distribution des cartes ; à partir du moment ou le croupier annonce le résultat du premier joueur,"
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
