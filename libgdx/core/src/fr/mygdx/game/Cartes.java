package fr.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.*;

public class Cartes {

private Scanner alpha = new Scanner(System.in);
private ArrayList<Integer> mains,scores;
private ArrayList<Animation<TextureRegion>> mainstext;
private ArrayList<String> mainsnom;
private Joueur[] joueurs;
private Croupier croupier;
private Deck paquet;
private boolean tirer;
private Preferences prefs;
private int nbparticipants, score0, score1, score2, score3, score4, score5, score6, score7, score8, score9, j;

int mise = 0;

	
	public Cartes(Deck paquet) {
		
		mains = new ArrayList<Integer>(11);
		scores = new ArrayList<Integer>(10);
		mainstext = new ArrayList<Animation<TextureRegion>>(11);
		mainsnom = new ArrayList<String>(11);
		joueurs = new Joueur[6];
		croupier = new Croupier();
		this.paquet = paquet;
		tirer = true;
		prefs = Gdx.app.getPreferences("Les Scores");
		j = prefs.getInteger("J",0);
	}
	
	public void initialisation() {
	    do {
		System.out.println("Combien de joueurs ? (Min : 1, Max : 6)");
		nbparticipants = 1;//alpha.nextInt();
	
	    } while (nbparticipants > 6 || nbparticipants < 0);
	    joueurs = new Joueur[nbparticipants];
	    
	    for (int i =0; i<nbparticipants;i++) {
	    	String nom;
	    	int v = i+1;
	    	System.out.println("\nNom du joueur " + v);
	    	nom = "A";//alpha.next();
	    	joueurs[i] = new Joueur();
	    	joueurs[i].nomJoueur(nom);
	    }
	}
	public void initialisation2() {
	    do {
		System.out.println("Combien de joueurs ? (Min : 1, Max : 6)");
		nbparticipants = 2;//alpha.nextInt();
	
	    } while (nbparticipants > 6 || nbparticipants < 0);
	    joueurs = new Joueur[nbparticipants];
	    
	    for (int i =0; i<nbparticipants;i++) {
	    	
	    	
	    	
	    	
	    	joueurs[i] = new Joueur();
	    	
	    }
	    joueurs[0].nomJoueur("Arthur");
	    joueurs[1].nomJoueur("Samuel");
	}
	 
	 public String getJoueur(int i) {
		 return joueurs[i].getNom();
	 }
	
	public void mise() {
		for (int i = 0;i<joueurs.length;i++) {
			System.out.println(joueurs[i].getNom() + " combien voulez vous miser ? ");
			mise = alpha.nextInt();
			joueurs[i].miser(mise);
		}
	}
	
	
	
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
		joueurs[i].addint(paquet.getPaquet().get(0));
		joueurs[i].addtext(paquet.getPaquetText().get(0));
		joueurs[i].addstr(paquet.getPaquetNom().get(0));
		paquet.getPaquet().remove(0);
	    paquet.getPaquetText().remove(0); 
	    paquet.getPaquetNom().remove(0);
	    joueurs[i].miser(mise*2);
	}
	
	public void split(int i) {
		joueurs[i].addintSplit(joueurs[i].getMain().get(1));
		joueurs[i].addtextSplit(joueurs[i].getMainText().get(1));
		joueurs[i].addstrSplit(joueurs[i].getMainstr().get(1));
		joueurs[i].getMain().remove(1);
		joueurs[i].getMainText().remove(1);
		joueurs[i].getMainstr().remove(1);
		joueurs[i].hassplit();
		
	}
	
	
	 public ArrayList<Animation<TextureRegion>> maindep() {
		 for (int j=0;j<nbparticipants;j++) {
			 
			 for (int i =0;i<2;i++) {		            
				 joueurs[j].addint(paquet.getPaquet().get(0));
				 joueurs[j].addtext(paquet.getPaquetText().get(0));
				 joueurs[j].addstr(paquet.getPaquetNom().get(0));
				   
	    	     paquet.getPaquet().remove(0);
	    	     paquet.getPaquetText().remove(0); 
	    	     paquet.getPaquetNom().remove(0);
	    	     System.out.println(joueurs[j].getMainstr());
	        }	
			
			joueurs[j].hasBJ(joueurs[j].total());
	        System.out.println("Main de " + joueurs[j].getNom() + " " + joueurs[j].getMainstr() );
		 }
		 /*for (int i = 0; i<2;i++) {
				if (joueurs[0].getMain().get(i) == 1) {
					joueurs[0].getMainStr().set(i, "AsCoeur");
				}
				else if (joueurs[0].getMain().get(i) == 2) {
					joueurs[0].getMainStr().set(i, "DeuxCoeur");
				}
				else if (joueurs[0].getMain().get(i) == 3) {
					joueurs[0].getMainStr().set(i, "TroisCoeur");
				}
				else if (joueurs[0].getMain().get(i) == 4) {
					joueurs[0].getMainStr().set(i, "QuatreCoeur");
				}
				else if (joueurs[0].getMain().get(i) == 5) {
					joueurs[0].getMainStr().set(i, "CinqCoeur");
				}
				else if (joueurs[0].getMain().get(i) == 6) {
					joueurs[0].getMainStr().set(i, "SixCoeur");
				}
				else if (joueurs[0].getMain().get(i) == 7) {
					joueurs[0].getMainStr().set(i, "SeptCoeur");
				}
				else if (joueurs[0].getMain().get(i) == 8) {
					joueurs[0].getMainStr().set(i, "HuitCoeur");
				}
				else if (joueurs[0].getMain().get(i) == 9) {
					joueurs[0].getMainStr().set(i, "NeufCoeur");
				}
				else if (joueurs[0].getMain().get(i) == 10) {
					joueurs[0].getMainStr().set(i, "DixCoeur");
				}
				else if (joueurs[0].getMain().get(i) == 11) {
					joueurs[0].getMainStr().set(i, "ValetCoeur");
				}
				else if (joueurs[0].getMain().get(i) == 12) {
					joueurs[0].getMainStr().set(i, "DameCoeur");
				}
				else if (joueurs[0].getMain().get(i) == 13) {
					joueurs[0].getMainStr().set(i, "RoiCoeur");
				}
	    	}*/
		 return joueurs[0].getMainText();
	 }
	 
	 
	 public Animation<TextureRegion> uneCarte(int k) {
		 return joueurs[0].getMainText().get(k);
	 }
	
	 public int uneCartev2(int k) {
		 return joueurs[0].getMain().get(k);
	 }
	 public ArrayList<Animation<TextureRegion>> carteJoueuri(int i){
		 return joueurs[i].getMainText();
	 }
	 public ArrayList<Integer> joueuri(int i) {
		 return joueurs[0].getMain();
	 }
	 
	 /*public void maindepnom() {
			
	        for (int i =0;i<2;i++) {
		        mainsnom.add(i, paquet.getPaquetNom().get(0));
	    	    System.out.println("Votre main : " + mainsnom + "\n");
	    	    paquet.getPaquetNom().remove(0);
	        }
	 }*/
	        
	public void tirerjoueur(int i) {
		/* for (int j=0;j<nbparticipants;j++) {
           for (int i =0;i<2;i++) {
	            
    	        joueurs[j].addint(paquet.getPaquet().get(0));
    	        joueurs[j].addstr(paquet.getPaquetNom().get(0));
	            
    	        paquet.getPaquet().remove(0);
    	        paquet.getPaquetNom().remove(0);
    	        
            }
           
            System.out.println("Main de " + joueurs[j].getNom() + " " + joueurs[j].getMainStr() );
	    }*/
       
 
		/*for (int i=0;i<nbparticipants;i++) {
			System.out.println("La main du croupier est [" + mainstext.get(0) + ", ?]");
			System.out.println(joueurs[i].total());
			tirer = true;
		while (joueurs[i].total() < 21) {
	        	int reponse;
	    	    Scanner clavier = new Scanner(System.in);
	    	    System.out.print("Voulez vous tirer une carte : \n");
	    	    reponse = clavier.nextInt();
	    	    if (reponse != 1) {
	    	    	tirer = false;
	    	    }*/
	        	    
	     
	     
	    	 
	            // System.out.println("Au tour de " + joueurs[i].getNom());
	    	     if (SinglePlayer.ADDCARTE == 1) {
	    	    	 
	    	    	 System.out.print("\nVotre main : " + joueurs[i].getMainstr() + "\n");
	    	    	
	    	    	joueurs[i].addtext(paquet.getPaquetText().get(0));
	    	    	joueurs[i].addint(paquet.getPaquet().get(0));
	    	    	joueurs[i].addstr(paquet.getPaquetNom().get(0));
	    	        paquet.getPaquetNom().remove(0);
	    	        paquet.getPaquetText().remove(0);
	    	        paquet.getPaquet().remove(0);
	    	    	
	    	        
	    	        //System.out.print("\nVotre main : " + joueurs[i].getMainstr() + "\n");
	    	        SinglePlayer.ADDCARTE = 0;
	    	        }
	    	    /* else {
	    	    	tirer = false;
	    	    } */  
	        
	     }
	       
	public ArrayList<Animation<TextureRegion>> getMainsText(){
		return mainstext;
	}
	public ArrayList<String> getMainsJoueurNom(int i){
		return joueurs[i].getMainstr();
	}
	
	
	 public void croupierdep() {
		 for (int i =0;i<2;i++) {
		        mains.add((paquet.getPaquet().get(0)));
		        mainstext.add(paquet.getPaquetText().get(0));
		        mainsnom.add(paquet.getPaquetNom().get(0));
		        
	    	    paquet.getPaquetNom().remove(0);
	    	    paquet.getPaquet().remove(0);
	    	    paquet.getPaquetText().remove(0);
		 }
		 
		
		 
	 }
	 
	/* public ArrayList<String> croupierdepNom() {
		 for (int i =0;i<2;i++) {
		        mainsnom.add(i, paquet.getPaquetNom().get(0));
	    	    System.out.println("\nMain du croupier : " + mainsnom + "\n");
	    	    paquet.getPaquetNom().remove(0);
		 }
		 return mainsnom;
		 
	 }*/

	 public ArrayList<Integer> afficheMainCroupier(){
		 return mains;
	 }
	public ArrayList<Animation<TextureRegion>> afficheMainCroupierNom(){
			 return mainstext;
	 }
	 public Animation<TextureRegion> croupiertirer() {
		 while (total() < 17) {
	    	 mains.add((paquet.getPaquet().get(0)));
		     mainstext.add(paquet.getPaquetText().get(0));
		     mainsnom.add(paquet.getPaquetNom().get(0));
	    	 //mains.add(paquet.getPaquet().get(0));
		     //mainsnom.add(paquet.getPaquetNom().get(0));
		     //mainsnom.add(paquet.getPaquetNom().get(0));
		     paquet.getPaquetNom().remove(0);
		     paquet.getPaquet().remove(0);
		     paquet.getPaquetText().remove(0);
		     System.out.println("\nMain du croupier apres tirage : " + mainsnom);
	     }
		 if (total() > 17) {
			 System.out.println("\nMain du croupier final : " + mainsnom);
		 }
		 return mainstext.get(0);
	 }
	 public int gagnant(int i) { //0 = a gagné, 1 = nul, 2 = défaite
		 
		 //for (int i=0;i<nbparticipants;i++) {
		    
		     if (total() > 21 && joueurs[i].total() < 22 ) {
			     System.out.println("\nLe croupier a un score de " + total() + " " +   joueurs[i].getNom() +" a un score de " + joueurs[i].total() + " donc " + joueurs[i].getNom() +" est vainqueur");
			     if (joueurs[i].getHasBJ()) {
			    	 joueurs[i].blackjack();
			    	 System.out.println("Félicitations vous avez eu un Blackjack ");
			    	 return (0); 
			     }
			     else {
			    	 joueurs[i].victoire();
			    	 return (0);
			     }
		     }
		     else if (total() < 22 && total() == joueurs[i].total()) {
			     System.out.println( "\n" + joueurs[i].getNom() + "a le mï¿½me score que le croupier "  + joueurs[i].getNom() + " rï¿½cupï¿½re sa mise");
			     return (1);
			     
		     }
		     else if (joueurs[i].total() > 21 ) {
			     System.out.println( "\n" + joueurs[i].getNom() + " a un score de " + joueurs[i].total() + " donc "  + joueurs[i].getNom() + " a perdu");
			     joueurs[i].defaite();
			     return (2);
		     }
		     else if (total() < 22 && total() < joueurs[i].total() && joueurs[i].total() < 22  ) {
			     System.out.println( "\n" + joueurs[i].getNom() + " a un score de "  + joueurs[i].total() + " et le croupier un score de " + total() + " donc "  + joueurs[i].getNom() + " est vainqueur");
			     if (joueurs[i].getHasBJ()) {
			    	 joueurs[i].blackjack();
			    	 System.out.println("Félicitations vous avez eu un Blackjack ");
			    	 return (0);
			     }
			     else {
			    	 joueurs[i].victoire();
			    	 return (0);
			     }
		     }
		     else if (total() < 22 && total() > joueurs[i].total() && joueurs[i].total() < 22) {
			     System.out.println( "\n" + joueurs[i].getNom() + " a un score de "  + joueurs[i].total() + " et le croupier un score de " + total() + " donc " +  joueurs[i].getNom() + " a perdu ");
			     joueurs[i].defaite();
			     return (2);
		     }
	     //}
			return (1);
	 }
	 public int total() {
		 int somme = 0;
		 boolean flag = false;
		 for (int i = 0;i<mains.size();i++) {
			 
			 if (mains.get(i) == 1) {
				 flag = true;
			 }
			 somme +=  mains.get(i);
		 }
		 if (flag && 10+somme <= 21) {
			 somme += 10;
		 }
		return somme;
	}
	
	 public int getTotal(int i) {
			j=0;
			if (j==0) {
				prefs.putInteger("Score0", joueurs[i].total());
				prefs.flush();
				score0 = prefs.getInteger("Score0");
				scores.add(score0);
				prefs.putInteger("J", j++);
				prefs.flush();
				System.out.println("score = "+score0);
				return scores.get(0);
			}
			if (j==1) {
				prefs.putInteger("Score1", joueurs[i].total());
				prefs.flush();
				score1 = prefs.getInteger("Score1");
				scores.add(score1);
				prefs.putInteger("J", j++);
				prefs.flush();
				System.out.println("score = "+score1);
				return scores.get(1);
			}
			if (j==2) {
				prefs.putInteger("Score2", joueurs[i].total());
				prefs.flush();
				score2 = prefs.getInteger("Score2");
				scores.add(score2);
				prefs.putInteger("J", j++);
				prefs.flush();
				System.out.println("score = "+score2);
				return scores.get(2);
			}
			if (j==3) {
				prefs.putInteger("Score3", joueurs[i].total());
				prefs.flush();
				score3 = prefs.getInteger("Score3");
				scores.add(score3);
				prefs.putInteger("J", j++);
				prefs.flush();
				System.out.println("score = "+score3);
				return scores.get(3);
			}
			if (j==4) {
				prefs.putInteger("Score4", joueurs[i].total());
				prefs.flush();
				score4 = prefs.getInteger("Score4");
				scores.add(score4);
				prefs.putInteger("J", j++);
				prefs.flush();
				System.out.println("score = "+score4);
				return scores.get(4);
			}
			if (j==5) {
				prefs.putInteger("Score5", joueurs[i].total());
				prefs.flush();
				score5 = prefs.getInteger("Score5");
				scores.add(score5);
				prefs.putInteger("J", j++);
				prefs.flush();
				System.out.println("score = "+score5);
				return scores.get(5);
			}
			if (j==6) {
				prefs.putInteger("Score6", joueurs[i].total());
				prefs.flush();
				score6 = prefs.getInteger("Score6");
				scores.add(score6);
				prefs.putInteger("J", j++);
				prefs.flush();
				System.out.println("score = "+score6);
				return scores.get(6);
			}
			if (j==7) {
				prefs.putInteger("Score7", joueurs[i].total());
				prefs.flush();
				score7 = prefs.getInteger("Score7");
				scores.add(score7);
				prefs.putInteger("J", j++);
				prefs.flush();
				System.out.println("score = "+score7);
				return scores.get(7);
			}
			if (j==8) {
				prefs.putInteger("Score8", joueurs[i].total());
				prefs.flush();
				score8 = prefs.getInteger("Score8");
				scores.add(score8);
				prefs.putInteger("J", j++);
				prefs.flush();
				System.out.println("score = "+score8);
				return scores.get(8);
			}
			if(j==9) {
				prefs.putInteger("Score9", joueurs[i].total());
				prefs.flush();
				score9 = prefs.getInteger("Score9");
				scores.add(score9);
				prefs.putInteger("J", j++);
				prefs.flush();
				System.out.println("score = "+score9);
				return scores.get(9);
			}
			else if(scores.get(0) == score0){
				scores.remove(0);
				prefs.putInteger("Score0", joueurs[i].total());
				prefs.flush();
				score0 = prefs.getInteger("Score0");
				scores.add(score0);
				return scores.get(9);
			}
			else if(scores.get(0) == score1){
				scores.remove(0);
				prefs.putInteger("Score1", joueurs[i].total());
				prefs.flush();
				score1 = prefs.getInteger("Score1");
				scores.add(score1);
				return scores.get(9);
			}
			else if(scores.get(0) == score2){
				scores.remove(0);
				prefs.putInteger("Score2", joueurs[i].total());
				prefs.flush();
				score2 = prefs.getInteger("Score2");
				scores.add(score2);
				return scores.get(9);
			}
			else if(scores.get(0) == score3){
				scores.remove(0);
				prefs.putInteger("Score3", joueurs[i].total());
				prefs.flush();
				score3 = prefs.getInteger("Score3");
				scores.add(score3);
				return scores.get(9);
			}
			else if(scores.get(0) == score4){
				scores.remove(0);
				prefs.putInteger("Score4", joueurs[i].total());
				prefs.flush();
				score4 = prefs.getInteger("Score4");
				scores.add(score4);
				return scores.get(9);
			}
			else if(scores.get(0) == score5){
				scores.remove(0);
				prefs.putInteger("Score5", joueurs[i].total());
				prefs.flush();
				score5 = prefs.getInteger("Score5");
				scores.add(score5);
				return scores.get(9);
			}
			else if(scores.get(0) == score6){
				scores.remove(0);
				prefs.putInteger("Score6", joueurs[i].total());
				prefs.flush();
				score6 = prefs.getInteger("Score6");
				scores.add(score6);
				return scores.get(9);
			}
			else if(scores.get(0) == score7){
				scores.remove(0);
				prefs.putInteger("Score7", joueurs[i].total());
				prefs.flush();
				score7 = prefs.getInteger("Score7");
				scores.add(score7);
				return scores.get(9);
			}
			else if(scores.get(0) == score8){
				scores.remove(0);
				prefs.putInteger("Score8", joueurs[i].total());
				prefs.flush();
				score8 = prefs.getInteger("Score8");
				scores.add(score8);
				return scores.get(9);
			}
			else {
				scores.remove(0);
				prefs.putInteger("Score9", joueurs[i].total());
				prefs.flush();
				score9 = prefs.getInteger("Score9");
				scores.add(score9);
				return scores.get(9);
			}			
		}
		 
	 
	 
	public void conversion() {
		for (int i = 0; i<312;i++) {
			if (paquet.getPaquet().get(i) > 10) {
				paquet.getPaquet().add(i, 10);
			}
			
			
		}
		
	}
	public ArrayList<Animation<TextureRegion>> getMainJoueur(int i){
		return joueurs[i].getMainText();
	}
	public ArrayList<Integer> getMain(){
		return mains;
	}
	public int getSize() {
		return mains.size();
	}
	
	public void afficheBanque() {
		for (int i=0;i<joueurs.length;i++) {
			System.out.println(joueurs[i].getBanque());
		}
	}
}
	
