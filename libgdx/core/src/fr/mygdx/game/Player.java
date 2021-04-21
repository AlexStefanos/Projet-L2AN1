package fr.mygdx.game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.*;

public class Player {
    private String name;
    private ArrayList<Integer> handsInt;
    private int bet;
    private int bank;
    private ArrayList<Animation<TextureRegion>> handsAnim;
    private ArrayList<String> handsStr;
    Deck paquet = new Deck(handsAnim);
    private boolean hasBJ;
    private ArrayList<String> mainstrsplit;
    private ArrayList<Integer> mainsintsplit;
    private ArrayList<Animation<TextureRegion>> handsAnimSplit;
    private boolean hassplit = false;
    
    
    
    public Player() {
    	
    	handsInt = new ArrayList<Integer>(15);
    	handsAnim = new ArrayList<Animation<TextureRegion>>(15);
    	handsStr = new ArrayList<String>(15);
    	hasBJ = false;
    }
    public int total() {
		 int sum = 0;
		 boolean flag = false;
		 for (int i = 0;i<handsInt.size();i++) {
			 
			 if (handsInt.get(i) == 1) {
				 flag = true;
			 }
			 sum +=  handsInt.get(i);
		 }
		 if (flag && 10+sum <= 21) {
			 sum += 10;
		 }
		return sum;
    }
    
    public int getBanque() {
    	bank = 5000;
    	return bank;
    }
	public void bust() {
		bank -= bet;
		bet = 0;
	}
	public void win() {
		bank += bet;
		bet = 0;
	}
	public void defaite() {
		bank -= bet;
		bet = 0;
	}
	public void blackjack() {
		bank += bet * 1.5;
		bet = 0;
	}
	public void miser(int betPlayer) {
		bet = betPlayer;
		bank = bank - betPlayer;
	}
	public void nomJoueur(String nameplayer) {
		name = nameplayer;
	}
	public String getNom() {
		return name;
	}
	public ArrayList<Integer> getMain() {
		return handsInt;
	}
	
	public ArrayList<Integer> getMainSplit() {
		return mainsintsplit;
	}
	
	public ArrayList<String> getMainstr() {
		return handsStr;
	}
	
	public ArrayList<String> getMainSplitstr() {
		return mainstrsplit;
	}
	
	public ArrayList<Animation<TextureRegion>> getHandsAnim(){
		return handsAnim;
	}
	
	public ArrayList<Animation<TextureRegion>> getMainSplitText(){
		return handsAnimSplit;
	}
	
	public void addint(int card) {
		handsInt.add(card);
	}
	
	public void addintSplit(int card) {
		mainsintsplit.add(card);
	}
	
	public void addtext(Animation<TextureRegion> card) {
	    handsAnim.add(card);
	}
	
	public void addtextSplit(Animation<TextureRegion> card) {
	    handsAnimSplit.add(card);
	}
	
	
	public void addstr(String card) {
		handsStr.add(card);
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
		handsAnim.clear();
		handsStr.clear();
		handsInt.clear();
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
	public void setBanque(int i) {
		bank = i;
	}
}
