package fr.mygdx.game;

import java.util.Random;

public class TestBlackjack {
	public static void main(String[] args) {
		Partie p1 = new Partie();
		
		p1.Croupier = 0;
		p1.MJoueur1 = 500;
		p1.MJoueur2 = 500;
		p1.MJoueur3 = 500;
		p1.CJoueur1 = 0;
		p1.CJoueur2 = 0;
		p1.CJoueur3 = 0;
		p1.nb = 0;
		Random random = new Random();
		p1.nb = random.nextInt(13);
		System.out.println(p1.nb);	
		Blackjack.Cartes(p1.nb);
		System.out.println(p1.nb);
	}
}