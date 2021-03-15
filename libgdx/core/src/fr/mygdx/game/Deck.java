package fr.mygdx.game;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Integer> jeu;
	
		
		public Deck() {
			jeu = new ArrayList<Integer>(312);
			
		}
		public void generateur() {
			for (int i = 1; i<14;i++) {
				for (int j = 0;j<24;j++) {
					jeu.add(i); 
				}
				
			}
		}
		public void afficher() {
			for (int i = 0;i<312;i++) {
		    System.out.println(jeu.get(i)+ " ");
			}
		}
		public int getSize() {
			return jeu.size();
		}
		public void conversion() {
			for (int i = 0; i<312;i++) {
				if (jeu.get(i) > 10) {
					jeu.set(i, 10);
				}
				
			}
		}
		
		public void shuffle() {
			Collections.shuffle(jeu);
		}
		public ArrayList<Integer> getPaquet() {
			return jeu;
		}
}	
