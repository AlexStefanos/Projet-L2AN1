package fr.mygdx.game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.*;

public class Joueur {
    private String nom;
    private ArrayList<Integer> mains;
    private int mise;
    private int banque;
    private ArrayList<Animation<TextureRegion>> mainstext;
    private ArrayList<String> mainstr;
    Deck paquet = new Deck(mainstext);
    private ArrayList<Integer> maindep;
    private boolean hasBJ;
    private ArrayList<String> mainstrsplit;
    private ArrayList<Integer> mainsintsplit;
    private ArrayList<Animation<TextureRegion>> mainstextsplit;
    private boolean hassplit = false;
    
    public Joueur() {
    	banque = 100;
    	mains = new ArrayList<Integer>(15);
    	mainstext = new ArrayList<Animation<TextureRegion>>(15);
    	mainstr = new ArrayList<String>(15);
    	hasBJ = false;
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
	
	public ArrayList<Integer> getMainSplit() {
		return mainsintsplit;
	}
	
	public ArrayList<String> getMainstr() {
		return mainstr;
	}
	
	public ArrayList<String> getMainSplitstr() {
		return mainstrsplit;
	}
	
	public ArrayList<Animation<TextureRegion>> getMainText(){
		return mainstext;
	}
	
	public ArrayList<Animation<TextureRegion>> getMainSplitText(){
		return mainstextsplit;
	}
	
	public void addint(int card) {
		mains.add(card);
	}
	
	public void addintSplit(int card) {
		mainsintsplit.add(card);
	}
	
	public void addtext(Animation<TextureRegion> card) {
	    mainstext.add(card);
	}
	
	public void addtextSplit(Animation<TextureRegion> card) {
	    mainstextsplit.add(card);
	}
	
	
	public void addstr(String card) {
		mainstr.add(card);
	}
	
	public void addstrSplit(String card) {
		mainstrsplit.add(card);
	}
	public void hasBJ(int i) {
		
		if (i == 21) {
			hasBJ = true;
		}
		
	}
	
	public void clearHands() {
		mainstext.clear();
		mainstr.clear();
		mains.clear();
	}
	
	public void hassplit() {
		hassplit = true;
	}
	
	public boolean getHasBJ() {
		return hasBJ;
	}
	public boolean getHassplit() {
		return hassplit;
	}
	
}
