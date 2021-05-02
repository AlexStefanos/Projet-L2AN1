package fr.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.*;
/**
 * Classe permettant de gérer les règles du jeu (détermine le vainqueur, fait piocher, etc...).
 * 
 *
 */
public class Cards {


private ArrayList<Integer> handsInt;

private ArrayList<Animation<TextureRegion>> handsAnim;
private ArrayList<String> handsString;
private Player[] player;
private Deck paquet;
private static Preferences prefs;
private int nbparticipants;
private int t,bank = 5000;

int mise = 0;

	public Cards(Deck paquet) {
		handsInt = new ArrayList<Integer>(11);
		handsAnim = new ArrayList<Animation<TextureRegion>>(11);
		handsString = new ArrayList<String>(11);
		player = new Player[6];
		this.paquet = paquet;
		prefs = Gdx.app.getPreferences("Les Scores");
	}

	/**
	 * Permet l'initialisation des joueurs sous forme de tableau, comme il n'y a que le mode singleplayer nous avons mis 
	 * nbparticipants a 1 directement.
	 */
	public void initialisation() {
	    do {
		nbparticipants = 1;
	
	    } while (nbparticipants > 6 || nbparticipants < 0);
	    player = new Player[nbparticipants];
	    
	    for (int i =0; i<nbparticipants;i++) {
	    	player[i] = new Player();
	    }
	}
	/**
	 * Permet l'initialisation pour deux joueurs.
	 */
	public void initialisation2() {
	    do {
		nbparticipants = 2;
	
	    } while (nbparticipants > 6 || nbparticipants < 0);
	    player = new Player[nbparticipants];
	    
	    for (int i =0; i<nbparticipants;i++) {
	    	player[i] = new Player();
	    }
	    player[0].nomJoueur("Arthur");
	    player[1].nomJoueur("Samuel");
	}
	
	/**
	 * Vide les mains des joueurs pour commencer une nouvelle partie.
	 */
	public void reinitialisation() {
		for (int i =0;i<nbparticipants;i++) {
			player[i].clearHands();
		}
		handsInt.clear();
		handsAnim.clear();
		handsString.clear();
	}
	 
	/**
	 * 
	 * @param i retourne le nom du joueur numero i.
	 * @return
	 */
	 public String getJoueur(int i) {
		 return player[i].getNom();
	 }
	
	/** Permet de generer le paquet 
	 * 
	 */
	
	public void generateur() {
		for (int i = 1; i<14;i++) {
			for (int j = 0;j<24;j++) {
				paquet.getPaquet().add(i); 
			}
		}
	}
	/**
	 * Methode pour faire doubler le joueur i.
	 * @param i
	 */
	
	public void doubler(int i) {
		player[i].addint(paquet.getPaquet().get(0));
		player[i].addtext(paquet.getPaquetText().get(0));
		player[i].addstr(paquet.getPaquetNom().get(0));
		paquet.getPaquet().remove(0);
	    paquet.getPaquetText().remove(0); 
	    paquet.getPaquetNom().remove(0);
	    player[i].miser(mise*2);
	}
	
	/**
	 * Methode pour faire split le joueur i.
	 * @param i
	 */
	public void split(int i) {
		player[i].addintSplit(player[i].getMain().get(1));
		player[i].addtextSplit(player[i].getHandsAnim().get(1));
		player[i].addstrSplit(player[i].getMainstr().get(1));
		player[i].getMain().remove(1);
		player[i].getHandsAnim().remove(1);
		player[i].getMainstr().remove(1);
		player[i].hassplit();
	}
	
	/**
	 * Permet de generer la main de depart des joueurs.
	 * @return renvoie une arrayList avec la main du joueur sous forme d'animation.
	 */
	 public ArrayList<Animation<TextureRegion>> maindep() {
		 for (int j=0;j<nbparticipants;j++) {
			 for (int i =0;i<2;i++) {		            
				 player[j].addint(paquet.getPaquet().get(0));
				 player[j].addtext(paquet.getPaquetText().get(0));
				 player[j].addstr(paquet.getPaquetNom().get(0));
				 paquet.getPaquet().remove(0);
	    	     paquet.getPaquetText().remove(0); 
	    	     paquet.getPaquetNom().remove(0);
	        }	
			player[j].hasBJ(player[j].total());
		 }
		return player[0].getHandsAnim();
	 }
	 
	 /**
	  * 
	  * @param k Placement de la carte que l'on souhaite avoir.
	  * @return La carte sous forme d'animation associe a la position k de la main du joueur.
	  */
	 
	 public Animation<TextureRegion> uneCarte(int k) {
		 return player[0].getHandsAnim().get(k);
	 }
	
	 /**
	  * 
	  * @param k Placement de la carte que l'on souhaite avoir.
	  * @return La carte sous forme d'entier (sa valeur dans le jeu du blackjack) associe a la position k de la main du joueur.
	  */
	 public int uneCartev2(int k) {
		 return player[0].getMain().get(k);
	 }
	 
	 /**
	  * 
	  * @param i designe le joueur dont l'on souhaite avoir la main.
	  * @return la main entière du joueur i sous forme d'animation.
	  */
	 public ArrayList<Animation<TextureRegion>> carteJoueuri(int i){
		 return player[i].getHandsAnim();
	 }
	 
	 /**
	  * 
	  * @param i designe le joueur dont l'on souhaite avoir la main.
	  * @return la main entière du joueur i sous forme d'entiers.
	  * 
	  */
	 public ArrayList<Integer> joueuri(int i) {
		 return player[0].getMain();
	 }
	 
	/**
	 *         
	 * @param i designe le joueur dont l'on souhaite lui faire tirer une carte.
	 * Cette methode permet de faire tirer des cartes.
	 */
	public void tirerjoueur(int i) {
		
	    	     if (SinglePlayer.ADDCARTE == 1) {
	    	    	player[i].addtext(paquet.getPaquetText().get(0));
	    	    	player[i].addint(paquet.getPaquet().get(0));
	    	    	player[i].addstr(paquet.getPaquetNom().get(0));
	    	        paquet.getPaquetNom().remove(0);
	    	        paquet.getPaquetText().remove(0);
	    	        paquet.getPaquet().remove(0);
	    	        SinglePlayer.ADDCARTE = 0;
	    	        }
	    	   }
	public ArrayList<Animation<TextureRegion>> gethandsAnim(){
		return handsAnim;
	}
	
	public ArrayList<String> getMainsJoueurNom(int i){
		return player[i].getMainstr();
	}
	
	/**
	 * Permet de generer les deux premières cartes du croupier.
	 */
	 public void croupierdep() {
		 for (int i =0;i<2;i++) {
		        handsInt.add((paquet.getPaquet().get(0)));
		        handsAnim.add(paquet.getPaquetText().get(0));
		        handsString.add(paquet.getPaquetNom().get(0));
		        paquet.getPaquetNom().remove(0);
	    	    paquet.getPaquet().remove(0);
	    	    paquet.getPaquetText().remove(0);
		 }
	}
	 
	 
	 public ArrayList<Animation<TextureRegion>> getMainCroupierNom(){
			 return handsAnim;
	 }
	 
	 /**
	  * Fait tirer le croupier tant qu'il a moins de 17.
	  * 
	  */
	 public void croupiertirer() {
		 while (total() < 17) {
	    	 handsInt.add((paquet.getPaquet().get(0)));
		     handsAnim.add(paquet.getPaquetText().get(0));
		     handsString.add(paquet.getPaquetNom().get(0));
	    	 paquet.getPaquetNom().remove(0);
		     paquet.getPaquet().remove(0);
		     paquet.getPaquetText().remove(0);
	     }
	 }
	 
	/**
	 * Permet de savoir si l'on a gagne, perdu ou fait nul.
	 * @param i  permet de savoir le statut final du ième joueur
	 * @return 0, 1 ou 2, 0 etant la valeur si le joueur a gagne, 1 si il y a nul, et 2 si le joueur a perdu.
	 */
	 
	 public int winner(int i) { //0 = a gagne, 1 = nul, 2 = defaite
		 
		 int alpha = -1; // Alpha va etre la valeur retourne de win/defaite/nul.
	     if (total() > 21 && player[i].total() < 22 ) {
		     if (player[i].getHasBJ()) {
		    	 player[i].blackjack();
		     }
		     else {
		    	 player[i].win();
		     }
		     alpha = 0;
	     }
	     else if (total() < 22 && total() == player[i].total()) {
		     alpha = 1;
		 }
	     else if (player[i].total() > 21 ) {
		     player[i].defaite();
		     alpha = 2;
	     }
	     else if (total() < 22 && total() < player[i].total() && player[i].total() < 22  ) {
		     if (player[i].getHasBJ()) {
		    	 player[i].blackjack();
		     }
		     else {
		    	 player[i].win();
		     }
		     alpha = 0;
	     }
	     else if (total() < 22 && total() > player[i].total() && player[i].total() < 22) {
		     player[i].defaite();
		     alpha = 2;
	     }
     return alpha;
	}
	 /**
	  * Permet de calculer la valeur total des cartes du joueur.
	  * @return Le total des cartes du joueur.
	  */
	 public int total() {
		 int somme = 0;
		 boolean flag = false;
		 for (int i = 0;i<handsInt.size();i++) {
			 if (handsInt.get(i) == 1) {
				 flag = true;
			 }
			 somme +=  handsInt.get(i);
		 }
		 if (flag && 10+somme <= 21) {
			 somme += 10;
		 }
		return somme;
	}
	 
	/**
	 * Retourne le nombre de partie effectue.
	 * @param j
	 * @return prefs.getInteger("Score"+j);
	 */
	public static int getoto(int j) {
		
		return prefs.getInteger("Score"+j);
	}
	
	/**
	 * Retourne le mode de jeu dans lequel le joueur etait.
	 * @param j
	 * @return prefs.getString("State"+j);
	 */
	public static String getotoS(int j) {
		
		return prefs.getString("State"+j);
	}
	
	/**
	 * Retourne si le joueur a gagne, perdu ou fait egalite.
	 * @param j
	 * @return prefs.getString("WL"+j);
	 */
	public static String getotoWL(int j) {
		
		return prefs.getString("WL"+j);
	}
	
	/**
	 * Enregistre la partie du joueur(son mode de jeu,victoire ou defaite,numero de la partie).
	 * @param i
	 * @param state
	 * @param j
	 */
	public void getTotal(int i,String state, int j) {
			if (AppPreferences.J >=20) {
				for(int o = 0; o <= 10 ; o++) {
					t = (AppPreferences.J -20) + o;
					prefs.remove("Score"+t);
					prefs.remove("State"+t);
					prefs.remove("WL"+t);
				}
			}
		 	
		 	prefs.putInteger("Score"+j, player[i].total());
			prefs.flush();
			prefs.putString("State"+j, state);
			prefs.flush();
			if(winner(0) == 0) {
				prefs.putString("WL"+j, "Win");
				prefs.flush();
			}
			if(winner(0) == 1) {
				prefs.putString("WL"+j, "Tie");
				prefs.flush();
			}
			if(winner(0) == 2) {
				prefs.putString("WL"+j, "Lose");
				prefs.flush();
			}
	}
	/**
	 * Retourne le score du joueur.
	 * @param i
	 * @return
	 */
	 public int getScore(int i) {
		 return player[i].total();
	 }
	 
	/**
	 * Permet de convertir les valeurs superieurs a 10 (Valet,Dame,Roi) en 10 puisqu'au blackjack les tetes valent 10 (sauf l'As).
	 */
	public void convert() {
		for (int i = 0; i<312;i++) {
			if (paquet.getPaquet().get(i) > 10) {
				paquet.getPaquet().add(i, 10);
			}
		}
	}
	
	public ArrayList<Animation<TextureRegion>> getMainPlayer(int i){
		return player[i].getHandsAnim();
	}
	
	public ArrayList<Integer> getMain(){
		return handsInt;
	}
	
	public int getSize() {
		return handsInt.size();
	}
	
	public int getBanque(int i) {
		return bank;
	}
	
	public void miser(int i, int bet) {
		player[i].miser(bet);
	}
	
	/**
	 * Ajoute le gain a la banque.
	 * @param i
	 */
	public void gagneMise(int i) {
		bank = bank + i*2;
	}
	
	public void setBanque(int i) {
		bank = i;
	}
	
	public void setMise(int i) {
		mise = i;
	}
	
	/**
	 * 
	 * @return un boolean pour savoir si le joueur a eu un blackjack ou non.
	 */
	public boolean HasBJ() {
		return player[0].getHasBJ();
	}
}
	
