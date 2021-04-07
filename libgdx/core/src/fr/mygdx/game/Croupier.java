package fr.mygdx.game;
import java.util.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Croupier {
    
    private ArrayList<Integer> mains;
    
    private ArrayList<Animation<TextureRegion>> mainstr;
    Deck paquet = new Deck(mainstr);
    
    public Croupier() {
    	
    	mains = new ArrayList<Integer>(15);
    	mainstr = new ArrayList<Animation<TextureRegion>>(15);
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
    public ArrayList<Integer> getMain() {
		return mains;
	}
	public ArrayList<Animation<TextureRegion>> getMainStr(){
		return mainstr;
	}
	
	public void addint(int card) {
		mains.add(card);
	}
	public void addstr(Animation<TextureRegion> card) {
	    mainstr.add(card);
	}
}
