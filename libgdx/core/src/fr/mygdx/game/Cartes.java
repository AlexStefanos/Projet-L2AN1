package fr.mygdx.game;

import java.util.*;

public class Cartes {

private ArrayList<Integer> mains;
private int nbparticipants;
private Deck paquet;
private boolean tirer;
	
	public Cartes(int nbparticipants, Deck paquet) {
		
		mains = new ArrayList<Integer>(5);
		this.nbparticipants = nbparticipants;
		this.paquet = paquet;
		tirer = true;
	}
	public void generateur() {
		for (int i = 1; i<14;i++) {
			for (int j = 0;j<24;j++) {
				paquet.getPaquet().add(i); 
			}
			
		}
	}
	public int getJoueurs() {
	    nbparticipants = Saisie.lireEntier("Nombre de joueurs à la table ? \n");
	    return nbparticipants;
	    	
	}
	public void afficher() {
		for (int i = 0;i<120;i++) {
	    System.out.println(paquet.getPaquet().get(i)+ " ");
		}
	}
	
	
	 public void maindep() {
		
	        for (int i =0;i<2;i++) {
		        mains.add(i, paquet.getPaquet().get(0));
	    	    System.out.println("Votre main : " + mains + "\n");
	    	    paquet.getPaquet().remove(0);
	        }
	 }
	        
	        public void tirerjoueur(ArrayList<Integer> maincroupier, int totalcroupier) {
	            while (tirer && total() < 21) {
	        	/*String reponse;
	    	    Scanner clavier = new Scanner(System.in);
	    	    System.out.print("Voulez vous tirer une carte : \n");
	    	    reponse = clavier.nextLine();*/
	        	    int a;
	        	    
	        	    a = Saisie.lireEntier("\n Voulez vous tirer une carte, sachant que la main du croupier est " +  maincroupier  + "donc un total de " + totalcroupier +  " ?");
	    	        if (a == 1) {
	    	        mains.add(paquet.getPaquet().get(0));
	    	        paquet.getPaquet().remove(0);
	    	        System.out.print("\nVotre main : " + mains + "\n");
	    	        }
	    	        if (a != 1) {
	    	    	    tirer = false;
	    	        }   
	        }
	        
	       
	 }
	 public ArrayList<Integer> croupierdep() {
		 for (int i =0;i<2;i++) {
		        mains.add(i, paquet.getPaquet().get(0));
	    	    System.out.println("\nMain du croupier : " + mains + "\n");
	    	    paquet.getPaquet().remove(0);
		 }
		 return mains;
		 
	 }
	 public ArrayList<Integer> afficheMainCroupier(){
		 return mains;
		 
	 }
	 public void croupiertirer(int totaljoueur) {
		 while (total() < 17) {
			 mains.add(paquet.getPaquet().get(0));
			 System.out.println("\nMain du croupier après tirage : " + mains + "\n");
		 }
		 if (total() > 21 && totaljoueur < 22 ) {
			 System.out.println("\nLe croupier à un score de " + total() + " votre score est de " + totaljoueur + " donc êtes vainqueurs");
		 }
		 else if (total() < 22 && total() == totaljoueur) {
			 System.out.println("Vous avez le même score que le croupier, vous récupérez votre mise ");
		 }
		 else if (totaljoueur > 21 ) {
			 System.out.println("Votre total est de " + totaljoueur + " donc vous avez perdu");
		 }
		 else if (total() < 22 && total() < totaljoueur && totaljoueur < 22) {
			 System.out.println("Vous avez un score de " + totaljoueur + " et le croupier un score de " + total() + " vous êtes donc vainqueurs");
		 }
		 else if (total() < 22 && total() > totaljoueur && totaljoueur < 22) {
			 System.out.println("Vous avez un score de " + totaljoueur + " et le croupier un score de " + total() + " vous avez perdu");
		 }
	 }
	 public int total() {
		 int somme = 0;
		 for (int i = 0;i<mains.size();i++) {
			 somme +=  mains.get(i);
		 }
		 //System.out.println("\nVotre main vaut " + somme );
		 return somme;
			 
	 }
	public void conversion() {
		for (int i = 0; i<312;i++) {
			if (paquet.getPaquet().get(i) > 10) {
				paquet.getPaquet().add(i, 10);
			}
			
			
		}
	}
}
