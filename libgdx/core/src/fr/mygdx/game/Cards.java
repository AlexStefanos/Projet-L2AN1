package fr.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.*;

public class Cards {


private ArrayList<Integer> handsInt;

private ArrayList<Animation<TextureRegion>> handsAnim;
private ArrayList<String> handsString;
private Player[] player;
private Deck paquet;
private static Preferences prefs;
private int nbparticipants;
private int bank = 5000;

int mise = 0;

	
	public Cards(Deck paquet) {
		
		handsInt = new ArrayList<Integer>(11);
		handsAnim = new ArrayList<Animation<TextureRegion>>(11);
		handsString = new ArrayList<String>(11);
		player = new Player[6];
		this.paquet = paquet;
		prefs = Gdx.app.getPreferences("Les Scores");
	}
	
	public void initialisation() {
	    do {
		nbparticipants = 1;
	
	    } while (nbparticipants > 6 || nbparticipants < 0);
	    player = new Player[nbparticipants];
	    
	    for (int i =0; i<nbparticipants;i++) {
	    	player[i] = new Player();
	    	
	    }
	}
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
	
	public void reinitialisation() {
		for (int i =0;i<nbparticipants;i++) {
			player[i].clearHands();
		}
		handsInt.clear();
		handsAnim.clear();
		handsString.clear();
	}
	 
	 public String getJoueur(int i) {
		 return player[i].getNom();
	 }
	
	public void mise(int bet) {
		for (int i = 0;i<player.length;i++) {
			player[i].miser(bet);
		}
	}
	
	/** Permet de générer le paquet 
	 * 
	 */
	
	public void generateur() {
		for (int i = 1; i<14;i++) {
			for (int j = 0;j<24;j++) {
				paquet.getPaquet().add(i); 
			}
		}
	}
	
	    	
	
	public void afficher() {
		for (int i = 0;i<120;i++) {
	    System.out.println(paquet.getPaquet().get(i)+ " ");
		}
	}
	
	public void doubler(int i) {
		player[i].addint(paquet.getPaquet().get(0));
		player[i].addtext(paquet.getPaquetText().get(0));
		player[i].addstr(paquet.getPaquetNom().get(0));
		paquet.getPaquet().remove(0);
	    paquet.getPaquetText().remove(0); 
	    paquet.getPaquetNom().remove(0);
	    player[i].miser(mise*2);
	}
	
	public void split(int i) {
		player[i].addintSplit(player[i].getMain().get(1));
		player[i].addtextSplit(player[i].getHandsAnim().get(1));
		player[i].addstrSplit(player[i].getMainstr().get(1));
		player[i].getMain().remove(1);
		player[i].getHandsAnim().remove(1);
		player[i].getMainstr().remove(1);
		player[i].hassplit();
		
	}
	
	
	 public ArrayList<Animation<TextureRegion>> maindep() {
		 for (int j=0;j<nbparticipants;j++) {
			 for (int i =0;i<2;i++) {		            
				 player[j].addint(paquet.getPaquet().get(0));
				 player[j].addtext(paquet.getPaquetText().get(0));
				 player[j].addstr(paquet.getPaquetNom().get(0));
				 paquet.getPaquet().remove(0);
	    	     paquet.getPaquetText().remove(0); 
	    	     paquet.getPaquetNom().remove(0);
	    	     System.out.println(player[j].getMainstr());
	        }	
			player[j].hasBJ(player[j].total());
	        System.out.println("Main de " + player[j].getNom() + " " + player[j].getMainstr() );
		 }
		return player[0].getHandsAnim();
	 }
	 
	 
	 public Animation<TextureRegion> uneCarte(int k) {
		 return player[0].getHandsAnim().get(k);
	 }
	
	 public int uneCartev2(int k) {
		 return player[0].getMain().get(k);
	 }
	 public ArrayList<Animation<TextureRegion>> carteJoueuri(int i){
		 return player[i].getHandsAnim();
	 }
	 public ArrayList<Integer> joueuri(int i) {
		 return player[0].getMain();
	 }
	 
	 
	        
	public void tirerjoueur(int i) {
		
	    	     if (SinglePlayer.ADDCARTE == 1) {
	    	    	 System.out.print("\nVotre main : " + player[i].getMainstr() + "\n");
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
	 
	 public ArrayList<Integer> afficheMainCroupier(){
		 return handsInt;
	 }
	 public ArrayList<Animation<TextureRegion>> afficheMainCroupierNom(){
			 return handsAnim;
	 }
	 public Animation<TextureRegion> croupiertirer() {
		 while (total() < 17) {
	    	 handsInt.add((paquet.getPaquet().get(0)));
		     handsAnim.add(paquet.getPaquetText().get(0));
		     handsString.add(paquet.getPaquetNom().get(0));
	    	 paquet.getPaquetNom().remove(0);
		     paquet.getPaquet().remove(0);
		     paquet.getPaquetText().remove(0);
		     System.out.println("\nMain du croupier apres tirage : " + handsString);
	     }
		 if (total() > 17) {
			 System.out.println("\nMain du croupier final : " + handsString);
		 }
		 return handsAnim.get(0);
	 }
	 public int winner(int i) { //0 = a gagné, 1 = nul, 2 = défaite
		 
		 int alpha = -1; // Alpha va être la valeur retourné de win/défaite/nul.
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
	public static int getoto(int j) {
		
		return prefs.getInteger("Score"+j);
	}
	public static String getotoS(int j) {
		
		return prefs.getString("State"+j);
	}
	public static String getotoWL(int j) {
		
		return prefs.getString("WL"+j);
	}

	public void getTotal(int i,String state, int j) {
		 	
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

	 public int getScore(int i) {
		 return player[i].total();
	 }
	 
	 
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
	
	public void gagneMise(int i) {
		bank = bank + i*2;
	}
	public void perdMise(int i) {
		player[i].defaite();
	}
	public void setBanque(int i) {
		bank = i;
	}
	public void setMise(int i) {
		mise = i;
	}
	public boolean HasBJ() {
		return player[0].getHasBJ();
	}
}
	
