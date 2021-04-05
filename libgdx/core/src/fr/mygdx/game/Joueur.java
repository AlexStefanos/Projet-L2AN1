package fr.mygdx.game;
import com.badlogic.gdx.graphics.Texture;
import java.util.*;

public class Joueur {
    private String nom;
    private ArrayList<Integer> mains;
    private int mise;
    private int banque;
    private ArrayList<Texture> mainstr;
    Deck paquet = new Deck(mainstr);
    
    public Joueur() {
    	banque = 100;
    	mains = new ArrayList<Integer>(15);
    	mainstr = new ArrayList<Texture>(15);
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
    
    public int getBanque() {
    	return banque;
    }
	public void bust() {
		banque -= mise;
		mise = 0;
	}
	public void victoire() {
		banque += mise;
		mise = 0;
	}
	public void defaite() {
		banque -= mise;
		mise = 0;
	}
	public void blackjack() {
		banque += mise * 1.5;
		mise = 0;
	}
	public void miser(int bet) {
		mise = bet;
	}
	public void nomJoueur(String name) {
		nom = name;
	}
	public String getNom() {
		return nom;
	}
	public ArrayList<Integer> getMain() {
		return mains;
	}
	public ArrayList<Texture> getMainStr(){
		return mainstr;
	}
	
	public void addint(int card) {
		mains.add(card);
	}
	public void addstr(Texture card) {
	    mainstr.add(card);
	}
}
