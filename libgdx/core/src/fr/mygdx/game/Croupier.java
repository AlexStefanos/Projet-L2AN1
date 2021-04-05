package fr.mygdx.game;
import java.util.*;
import com.badlogic.gdx.graphics.Texture;

public class Croupier {
    
    private ArrayList<Integer> mains;
    
    private ArrayList<Texture> mainstr;
    Deck paquet = new Deck(mainstr);
    
    public Croupier() {
    	
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
