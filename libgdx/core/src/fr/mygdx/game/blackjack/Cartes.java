package fr.mygdx.game.blackjack;

import java.util.*;

public class Cartes {

public ArrayList<Integer> mains;
public ArrayList<String> mainsnom;
public int nbparticipants;
public Deck paquet;
public boolean tirer;
	
	public Cartes(int nbparticipants, Deck paquet) {
		
		mains = new ArrayList<Integer>(5);
		mainsnom = new ArrayList<String>(5);
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
		        mainsnom.add(i, paquet.getPaquetNom().get(0));
	    	    
	    	    paquet.getPaquet().remove(0);
	    	    paquet.getPaquetNom().remove(0);
	        }
	        System.out.println("Votre main : " + mainsnom );
	 }
	 /*public void maindepnom() {
			
	        for (int i =0;i<2;i++) {
		        mainsnom.add(i, paquet.getPaquetNom().get(0));
	    	    System.out.println("Votre main : " + mainsnom + "\n");
	    	    paquet.getPaquetNom().remove(0);
	        }
	 }*/
	        
	        public void tirerjoueur(ArrayList<String> maincroupier, int totalcroupier) {
	            while (tirer && total() < 21) {
	        	/*String reponse;
	    	    Scanner clavier = new Scanner(System.in);
	    	    System.out.print("Voulez vous tirer une carte : \n");
	    	    reponse = clavier.nextLine();*/
	        	    int a;
	        	    
	        	    a = Saisie.lireEntier("\n Voulez vous tirer une carte, sachant que la main du croupier est [" +  maincroupier.get(0) +  ", ?]");
	    	        if (a == 1) {
	    	        mainsnom.add(paquet.getPaquetNom().get(0));
	    	        mains.add(paquet.getPaquet().get(0));
	    	        paquet.getPaquetNom().remove(0);
	    	        paquet.getPaquet().remove(0);
	    	        System.out.print("\nVotre main : " + mainsnom + "\n");
	    	        }
	    	        if (a != 1) {
	    	    	    tirer = false;
	    	        }   
	        }
	        
	       
	 }
	 public ArrayList<String> croupierdep() {
		 for (int i =0;i<2;i++) {
		        mains.add(i, paquet.getPaquet().get(0));
		        mainsnom.add(i, paquet.getPaquetNom().get(0));
	    	    
	    	    paquet.getPaquet().remove(0);
	    	    paquet.getPaquetNom().remove(0);
		 }
		 System.out.println("\nMain du croupier : " + mainsnom.get(0) + " une autre carte face cachée " );
		 return mainsnom;
		 
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
	public ArrayList<String> afficheMainCroupierNom(){
			 return mainsnom;
	 }
	 public void croupiertirer(int totaljoueur) {
		 while (total() < 17) {
			 mains.add(paquet.getPaquet().get(0));
			 mainsnom.add(paquet.getPaquetNom().get(0));
			 //mainsnom.add(paquet.getPaquetNom().get(0));
			 paquet.getPaquet().remove(0);
			 paquet.getPaquetNom().remove(0);
			 System.out.println("\nMain du croupier après tirage : " + mainsnom + "\n");
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
		 else if (total() < 22 && total() < totaljoueur && totaljoueur < 22  ) {
			 System.out.println("Vous avez un score de " + totaljoueur + " et le croupier un score de " + total() + " vous êtes donc vainqueurs");
		 }
		 else if (total() < 22 && total() > totaljoueur && totaljoueur < 22) {
			 System.out.println("Vous avez un score de " + totaljoueur + " et le croupier un score de " + total() + " vous avez perdu");
		 }
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
	public void conversion() {
		for (int i = 0; i<312;i++) {
			if (paquet.getPaquet().get(i) > 10) {
				paquet.getPaquet().add(i, 10);
			}
			
			
		}
	}
}
