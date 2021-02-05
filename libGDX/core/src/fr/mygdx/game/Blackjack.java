package fr.mygdx.game;

public class Blackjack {

	public static void Cartes(int nb) {
		if (nb == 0) {
			nb = 1;
		}
		else if (nb == 9 | nb == 10 | nb == 11 | nb == 12) {
			nb = 10;
		}
		else {
			nb++;
		}
	}
}

class Partie {
	int Croupier, MJoueur1, MJoueur2, MJoueur3, CCroupier, CJoueur1, CJoueur2, CJoueur3, nb;
}
