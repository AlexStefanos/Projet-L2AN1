package fr.mygdx.game.splashengine;

import com.badlogic.gdx.graphics.g2d.Sprite;

import aurelienribon.tweenengine.TweenAccessor;

public class SpriteAccessor implements TweenAccessor<Sprite>{
	public static final int ALPHA = 0;
	/**
	 * Retourne la valeur qui permet de faire le fondu/l'animation pour l'écran de chargement.
	 * @return 1, -1
	 */
	@Override
	public int getValues(Sprite target, int tweenType, float[] returnValues) {
		switch(tweenType) {
		case ALPHA:
			returnValues[0] = target.getColor().a;
			return 1;
		default:
			assert false;
			return -1;
		}
	}
	/**
	 * Defenie les valeurs qui permetde faire le fondu/l'animation pour l'écran de chargement.
	 * @param target, tweenType, newValues
	 */
	@Override
	public void setValues(Sprite target, int tweenType, float[] newValues) {
		switch(tweenType) {
		case ALPHA:
			target.setColor(target.getColor().r, target.getColor().g, target.getColor().b, newValues[0] );
			break;
		default:
			assert false;
		
		}
		
		
	}
	
}
