package fr.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;

public class Animations {
	
	private TextureAtlas atlasAsCarreau , atlasDeuxCarreau , atlasTroisCarreau , atlasQuatreCarreau , atlasCinqCarreau , atlasSixCarreau ,
	atlasSeptCarreau , atlasHuitCarreau , atlasNeufCarreau , atlasDixCarreau , atlasValetCarreau , atlasDameCarreau , atlasRoiCarreau ,
	atlasAsCoeur , atlasDeuxCoeur , atlasTroisCoeur , atlasQuatreCoeur , atlasCinqCoeur , atlasSixCoeur ,
	atlasSeptCoeur , atlasHuitCoeur , atlasNeufCoeur , atlasDixCoeur , atlasValetCoeur , atlasDameCoeur , atlasRoiCoeur ,
	atlasAsPique , atlasDeuxPique , atlasTroisPique , atlasQuatrePique , atlasCinqPique , atlasSixPique ,
	atlasSeptPique , atlasHuitPique , atlasNeufPique , atlasDixPique , atlasValetPique , atlasDamePique , atlasRoiPique ,
	atlasAsTrefle , atlasDeuxTrefle , atlasTroisTrefle , atlasQuatreTrefle , atlasCinqTrefle , atlasSixTrefle ,
	atlasSeptTrefle , atlasHuitTrefle , atlasNeufTrefle , atlasDixTrefle , atlasValetTrefle , atlasDameTrefle , atlasRoiTrefle ;

	private Array<AtlasRegion> animationFramesAsCarreau , animationFramesDeuxCarreau , animationFramesTroisCarreau , animationFramesQuatreCarreau ,
	animationFramesCinqCarreau , animationFramesSixCarreau , animationFramesSeptCarreau , animationFramesHuitCarreau , animationFramesNeufCarreau ,
	animationFramesDixCarreau , animationFramesValetCarreau , animationFramesDameCarreau ,animationFramesRoiCarreau , 
	animationFramesAsCoeur , animationFramesDeuxCoeur , animationFramesTroisCoeur , animationFramesQuatreCoeur ,
	animationFramesCinqCoeur , animationFramesSixCoeur , animationFramesSeptCoeur , animationFramesHuitCoeur , animationFramesNeufCoeur ,
	animationFramesDixCoeur , animationFramesValetCoeur , animationFramesDameCoeur ,animationFramesRoiCoeur ,
	animationFramesAsPique , animationFramesDeuxPique , animationFramesTroisPique , animationFramesQuatrePique ,
	animationFramesCinqPique , animationFramesSixPique , animationFramesSeptPique , animationFramesHuitPique , animationFramesNeufPique,
	animationFramesDixPique , animationFramesValetPique , animationFramesDamePique ,animationFramesRoiPique ,
	animationFramesAsTrefle , animationFramesDeuxTrefle , animationFramesTroisTrefle , animationFramesQuatreTrefle ,
	animationFramesCinqTrefle , animationFramesSixTrefle , animationFramesSeptTrefle , animationFramesHuitTrefle , animationFramesNeufTrefle ,
	animationFramesDixTrefle , animationFramesValetTrefle , animationFramesDameTrefle ,animationFramesRoiTrefle ;
	
	public static Animation <TextureRegion> animAsCarreau , animDeuxCarreau , animTroisCarreau , animQuatreCarreau , 
	animCinqCarreau , animSixCarreau , animSeptCarreau , animHuitCarreau , animNeufCarreau , animDixCarreau , animValetCarreau , 
	animDameCarreau , animRoiCarreau , animAsPique , animDeuxPique , animTroisPique , animQuatrePique , 
	animCinqPique , animSixPique , animSeptPique , animHuitPique , animNeufPique , animDixPique , animValetPique , 
	animDamePique , animRoiPique , animAsTrefle , animDeuxTrefle , animTroisTrefle , animQuatreTrefle , 
	animCinqTrefle , animSixTrefle , animSeptTrefle , animHuitTrefle , animNeufTrefle , animDixTrefle , animValetTrefle , 
	animDameTrefle , animRoiTrefle ,  animAsCoeur , animDeuxCoeur , animTroisCoeur , animQuatreCoeur , 
	animCinqCoeur , animSixCoeur , animSeptCoeur , animHuitCoeur , animNeufCoeur , animDixCoeur , animValetCoeur , 
	animDameCoeur , animRoiCoeur ;
	
	private ArrayList<Animation<TextureRegion>> animationPack;
	
	private float animTimeCarte = 0f;
	private float totalAnimTime = 0.1f;
	
	public Animations(ArrayList<Animation<TextureRegion>> animationPack) {
		this.animationPack = animationPack;
		
		atlasAsCarreau = new TextureAtlas("Anim/AsCarreau/AnimAsCarreau.pack");
		atlasDeuxCarreau = new TextureAtlas("Anim/DeuxCarreau/AnimDeuxCarreau.pack");
		atlasTroisCarreau = new TextureAtlas("Anim/TroisCarreau/AnimTroisCarreau.pack");
		atlasQuatreCarreau = new TextureAtlas("Anim/QuatreCarreau/AnimQuatreCarreau.pack");
		atlasCinqCarreau = new TextureAtlas("Anim/CinqCarreau/AnimCinqCarreau.pack");
		atlasSixCarreau = new TextureAtlas("Anim/SixCarreau/AnimSixCarreau.pack");
		atlasSeptCarreau = new TextureAtlas("Anim/SeptCarreau/AnimSeptCarreau.pack");
		atlasHuitCarreau = new TextureAtlas("Anim/HuitCarreau/AnimHuitCarreau.pack");
		atlasNeufCarreau = new TextureAtlas("Anim/NeufCarreau/AnimNeufCarreau.pack");
		atlasDixCarreau = new TextureAtlas("Anim/DixCarreau/AnimDixCarreau.pack");
		atlasValetCarreau = new TextureAtlas("Anim/ValetCarreau/AnimValetCarreau.pack");
		atlasDameCarreau = new TextureAtlas("Anim/DameCarreau/AnimDameCarreau.pack");
		atlasRoiCarreau = new TextureAtlas("Anim/RoiCarreau/AnimRoiCarreau.pack");
		atlasAsCoeur = new TextureAtlas("Anim/AsCoeur/AnimAsCoeur.pack");
		atlasDeuxCoeur = new TextureAtlas("Anim/DeuxCoeur/AnimDeuxCoeur.pack");
		atlasTroisCoeur = new TextureAtlas("Anim/TroisCoeur/AnimTroisCoeur.pack");
		atlasQuatreCoeur = new TextureAtlas("Anim/QuatreCoeur/AnimQuatreCoeur.pack");
		atlasCinqCoeur = new TextureAtlas("Anim/CinqCoeur/AnimCinqCoeur.pack");
		atlasSixCoeur = new TextureAtlas("Anim/SixCoeur/AnimSixCoeur.pack");
		atlasSeptCoeur = new TextureAtlas("Anim/SeptCoeur/AnimSeptCoeur.pack");
		atlasHuitCoeur = new TextureAtlas("Anim/HuitCoeur/AnimHuitCoeur.pack");
		atlasNeufCoeur = new TextureAtlas("Anim/NeufCoeur/AnimNeufCoeur.pack");
		atlasDixCoeur = new TextureAtlas("Anim/DixCoeur/AnimDixCoeur.pack");
		atlasValetCoeur = new TextureAtlas("Anim/ValetCoeur/AnimValetCoeur.pack");
		atlasDameCoeur = new TextureAtlas("Anim/DameCoeur/AnimDameCoeur.pack");
		atlasRoiCoeur = new TextureAtlas("Anim/RoiCoeur/AnimRoiCoeur.pack");
		atlasAsTrefle = new TextureAtlas("Anim/AsTrefle/AnimAsTrefle.pack");
		atlasDeuxTrefle = new TextureAtlas("Anim/DeuxTrefle/AnimDeuxTrefle.pack");
		atlasTroisTrefle = new TextureAtlas("Anim/TroisTrefle/AnimTroisTrefle.pack");
		atlasQuatreTrefle = new TextureAtlas("Anim/QuatreTrefle/AnimQuatreTrefle.pack");
		atlasCinqTrefle = new TextureAtlas("Anim/CinqTrefle/AnimCinqTrefle.pack");
		atlasSixTrefle = new TextureAtlas("Anim/SixTrefle/AnimSixTrefle.pack");
		atlasSeptTrefle = new TextureAtlas("Anim/SeptTrefle/AnimSeptTrefle.pack");
		atlasHuitTrefle = new TextureAtlas("Anim/HuitTrefle/AnimHuitTrefle.pack");
		atlasNeufTrefle = new TextureAtlas("Anim/NeufTrefle/AnimNeufTrefle.pack");
		atlasDixTrefle = new TextureAtlas("Anim/DixTrefle/AnimDixTrefle.pack");
		atlasValetTrefle = new TextureAtlas("Anim/ValetTrefle/AnimValetTrefle.pack");
		atlasDameTrefle = new TextureAtlas("Anim/DameTrefle/AnimDameTrefle.pack");
		atlasRoiTrefle = new TextureAtlas("Anim/RoiTrefle/AnimRoiTrefle.pack");
		atlasAsPique = new TextureAtlas("Anim/AsPique/AnimAsPique.pack");
		atlasDeuxPique = new TextureAtlas("Anim/DeuxPique/AnimDeuxPique.pack");
		atlasTroisPique = new TextureAtlas("Anim/TroisPique/AnimTroisPique.pack");
		atlasQuatrePique = new TextureAtlas("Anim/QuatrePique/AnimQuatrePique.pack");
		atlasCinqPique = new TextureAtlas("Anim/CinqPique/AnimCinqPique.pack");
		atlasSixPique = new TextureAtlas("Anim/SixPique/AnimSixPique.pack");
		atlasSeptPique = new TextureAtlas("Anim/SeptPique/AnimSeptPique.pack");
		atlasHuitPique = new TextureAtlas("Anim/HuitPique/AnimHuitPique.pack");
		atlasNeufPique = new TextureAtlas("Anim/NeufPique/AnimNeufPique.pack");
		atlasDixPique = new TextureAtlas("Anim/DixPique/AnimDixPique.pack");
		atlasValetPique = new TextureAtlas("Anim/ValetPique/AnimValetPique.pack");
		atlasDamePique = new TextureAtlas("Anim/DamePique/AnimDamePique.pack");
		atlasRoiPique = new TextureAtlas("Anim/RoiPique/AnimRoiPique.pack");

		//--------------------------------------------------------------------------------------------------
		//---------------------------------------------------Carreau----------------------------------------
		//--------------------------------------------------------------------------------------------------
		
		
		animationFramesAsCarreau = atlasAsCarreau.getRegions();
		animAsCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesAsCarreau);
		animAsCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesDeuxCarreau = atlasDeuxCarreau.getRegions();
		animDeuxCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesDeuxCarreau);
		animDeuxCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesTroisCarreau = atlasTroisCarreau.getRegions();
		animTroisCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesTroisCarreau);
		animTroisCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesQuatreCarreau = atlasQuatreCarreau.getRegions();
		animQuatreCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesQuatreCarreau);
		animQuatreCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesCinqCarreau = atlasCinqCarreau.getRegions();
		animCinqCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesCinqCarreau);
		animAsCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesSixCarreau = atlasSixCarreau.getRegions();
		animSixCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesSixCarreau);
		animSixCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesSeptCarreau = atlasSeptCarreau.getRegions();
		animSeptCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesSeptCarreau);
		animSeptCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesHuitCarreau = atlasHuitCarreau.getRegions();
		animHuitCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesHuitCarreau);
		animHuitCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesNeufCarreau = atlasNeufCarreau.getRegions();
		animNeufCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesNeufCarreau);
		animNeufCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesDixCarreau = atlasDixCarreau.getRegions();
		animDixCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesDixCarreau);
		animDixCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesValetCarreau = atlasValetCarreau.getRegions();
		animValetCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesValetCarreau);
		animValetCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesDameCarreau = atlasDameCarreau.getRegions();
		animDameCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesDameCarreau);
		animDameCarreau.setPlayMode(Animation.PlayMode.NORMAL);

		animationFramesRoiCarreau = atlasRoiCarreau.getRegions();
		animRoiCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesRoiCarreau);
		animRoiCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		//--------------------------------------------------------------------------------------------------
		//---------------------------------------------------Coeur------------------------------------------
		//--------------------------------------------------------------------------------------------------
		
		animationFramesAsCarreau = atlasAsCarreau.getRegions();
		animAsCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesAsCarreau);
		animAsCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesDeuxCarreau = atlasDeuxCarreau.getRegions();
		animDeuxCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesDeuxCarreau);
		animDeuxCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesTroisCarreau = atlasTroisCarreau.getRegions();
		animTroisCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesTroisCarreau);
		animTroisCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesQuatreCarreau = atlasQuatreCarreau.getRegions();
		animQuatreCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesQuatreCarreau);
		animQuatreCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesCinqCarreau = atlasCinqCarreau.getRegions();
		animCinqCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesCinqCarreau);
		animAsCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesSixCarreau = atlasSixCarreau.getRegions();
		animSixCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesSixCarreau);
		animSixCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesSeptCarreau = atlasSeptCarreau.getRegions();
		animSeptCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesSeptCarreau);
		animSeptCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesHuitCarreau = atlasHuitCarreau.getRegions();
		animHuitCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesHuitCarreau);
		animHuitCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesNeufCarreau = atlasNeufCarreau.getRegions();
		animNeufCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesNeufCarreau);
		animNeufCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesDixCarreau = atlasDixCarreau.getRegions();
		animDixCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesDixCarreau);
		animDixCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesValetCarreau = atlasValetCarreau.getRegions();
		animValetCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesValetCarreau);
		animValetCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesDameCarreau = atlasDameCarreau.getRegions();
		animDameCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesDameCarreau);
		animDameCarreau.setPlayMode(Animation.PlayMode.NORMAL);

		animationFramesRoiCarreau = atlasRoiCarreau.getRegions();
		animRoiCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesRoiCarreau);
		animRoiCarreau.setPlayMode(Animation.PlayMode.NORMAL);

		//--------------------------------------------------------------------------------------------------
		//---------------------------------------------------Trefle-----------------------------------------
		//--------------------------------------------------------------------------------------------------
		
		animationFramesAsCarreau = atlasAsCarreau.getRegions();
		animAsCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesAsCarreau);
		animAsCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesDeuxCarreau = atlasDeuxCarreau.getRegions();
		animDeuxCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesDeuxCarreau);
		animDeuxCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesTroisCarreau = atlasTroisCarreau.getRegions();
		animTroisCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesTroisCarreau);
		animTroisCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesQuatreCarreau = atlasQuatreCarreau.getRegions();
		animQuatreCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesQuatreCarreau);
		animQuatreCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesCinqCarreau = atlasCinqCarreau.getRegions();
		animCinqCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesCinqCarreau);
		animAsCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesSixCarreau = atlasSixCarreau.getRegions();
		animSixCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesSixCarreau);
		animSixCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesSeptCarreau = atlasSeptCarreau.getRegions();
		animSeptCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesSeptCarreau);
		animSeptCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesHuitCarreau = atlasHuitCarreau.getRegions();
		animHuitCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesHuitCarreau);
		animHuitCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesNeufCarreau = atlasNeufCarreau.getRegions();
		animNeufCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesNeufCarreau);
		animNeufCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesDixCarreau = atlasDixCarreau.getRegions();
		animDixCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesDixCarreau);
		animDixCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesValetCarreau = atlasValetCarreau.getRegions();
		animValetCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesValetCarreau);
		animValetCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesDameCarreau = atlasDameCarreau.getRegions();
		animDameCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesDameCarreau);
		animDameCarreau.setPlayMode(Animation.PlayMode.NORMAL);

		animationFramesRoiCarreau = atlasRoiCarreau.getRegions();
		animRoiCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesRoiCarreau);
		animRoiCarreau.setPlayMode(Animation.PlayMode.NORMAL);

		//--------------------------------------------------------------------------------------------------
		//---------------------------------------------------Pique------------------------------------------
		//--------------------------------------------------------------------------------------------------
		
		animationFramesAsCarreau = atlasAsCarreau.getRegions();
		animAsCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesAsCarreau);
		animAsCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesDeuxCarreau = atlasDeuxCarreau.getRegions();
		animDeuxCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesDeuxCarreau);
		animDeuxCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesTroisCarreau = atlasTroisCarreau.getRegions();
		animTroisCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesTroisCarreau);
		animTroisCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesQuatreCarreau = atlasQuatreCarreau.getRegions();
		animQuatreCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesQuatreCarreau);
		animQuatreCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesCinqCarreau = atlasCinqCarreau.getRegions();
		animCinqCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesCinqCarreau);
		animAsCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesSixCarreau = atlasSixCarreau.getRegions();
		animSixCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesSixCarreau);
		animSixCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesSeptCarreau = atlasSeptCarreau.getRegions();
		animSeptCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesSeptCarreau);
		animSeptCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesHuitCarreau = atlasHuitCarreau.getRegions();
		animHuitCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesHuitCarreau);
		animHuitCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesNeufCarreau = atlasNeufCarreau.getRegions();
		animNeufCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesNeufCarreau);
		animNeufCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesDixCarreau = atlasDixCarreau.getRegions();
		animDixCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesDixCarreau);
		animDixCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesValetCarreau = atlasValetCarreau.getRegions();
		animValetCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesValetCarreau);
		animValetCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesDameCarreau = atlasDameCarreau.getRegions();
		animDameCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesDameCarreau);
		animDameCarreau.setPlayMode(Animation.PlayMode.NORMAL);

		animationFramesRoiCarreau = atlasRoiCarreau.getRegions();
		animRoiCarreau = new Animation<TextureRegion> (totalAnimTime , animationFramesRoiCarreau);
		animRoiCarreau.setPlayMode(Animation.PlayMode.NORMAL);
	}

	
}