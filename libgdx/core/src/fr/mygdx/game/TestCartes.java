package fr.mygdx.game;


public class TestCartes {
	public static void main(String[] args) {
    	int a = Saisie.lireEntier("Nombre de joueurs à la table ? \n");
		Deck paquet = new Deck();
    	paquet.generateur();
    	
    	Cartes p1 = new Cartes(a, paquet);
    	Cartes p2 = new Cartes(a, paquet);
    	Cartes croupier = new Cartes(a, paquet);
    	
    	
    	//paquet.afficher();
    	paquet.conversion();
    	paquet.shuffle();
    	//paquet.afficher();
    	croupier.croupierdep();
    	p1.maindep();
    	p1.tirerjoueur(croupier.afficheMainCroupier(),croupier.total());
    	croupier.croupiertirer(p1.total());
    	//p1.total();
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	//p2.maindep();
       	//p2.total();
    	
    	
    	
    }
}