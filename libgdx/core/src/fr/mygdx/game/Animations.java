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
/**
 * La classe Animation permet d'initialiser toute les animations pour les appeler facilement.
 * @author arthu
 *
 */
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
	
	//private float animTimeCarte = 0f;
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
		animCinqCarreau.setPlayMode(Animation.PlayMode.NORMAL);
		
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
		
		animationFramesAsCoeur = atlasAsCoeur.getRegions();
		animAsCoeur = new Animation<TextureRegion> (totalAnimTime , animationFramesAsCoeur);
		animAsCoeur.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesDeuxCoeur = atlasDeuxCoeur.getRegions();
		animDeuxCoeur = new Animation<TextureRegion> (totalAnimTime , animationFramesDeuxCoeur);
		animDeuxCoeur.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesTroisCoeur = atlasTroisCoeur.getRegions();
		animTroisCoeur = new Animation<TextureRegion> (totalAnimTime , animationFramesTroisCoeur);
		animTroisCoeur.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesQuatreCoeur = atlasQuatreCoeur.getRegions();
		animQuatreCoeur = new Animation<TextureRegion> (totalAnimTime , animationFramesQuatreCoeur);
		animQuatreCoeur.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesCinqCoeur = atlasCinqCoeur.getRegions();
		animCinqCoeur = new Animation<TextureRegion> (totalAnimTime , animationFramesCinqCoeur);
		animCinqCoeur.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesSixCoeur = atlasSixCoeur.getRegions();
		animSixCoeur = new Animation<TextureRegion> (totalAnimTime , animationFramesSixCoeur);
		animSixCoeur.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesSeptCoeur = atlasSeptCoeur.getRegions();
		animSeptCoeur = new Animation<TextureRegion> (totalAnimTime , animationFramesSeptCoeur);
		animSeptCoeur.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesHuitCoeur = atlasHuitCoeur.getRegions();
		animHuitCoeur = new Animation<TextureRegion> (totalAnimTime , animationFramesHuitCoeur);
		animHuitCoeur.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesNeufCoeur = atlasNeufCoeur.getRegions();
		animNeufCoeur = new Animation<TextureRegion> (totalAnimTime , animationFramesNeufCoeur);
		animNeufCoeur.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesDixCoeur = atlasDixCoeur.getRegions();
		animDixCoeur = new Animation<TextureRegion> (totalAnimTime , animationFramesDixCoeur);
		animDixCoeur.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesValetCoeur = atlasValetCoeur.getRegions();
		animValetCoeur = new Animation<TextureRegion> (totalAnimTime , animationFramesValetCoeur);
		animValetCoeur.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesDameCoeur = atlasDameCoeur.getRegions();
		animDameCoeur = new Animation<TextureRegion> (totalAnimTime , animationFramesDameCoeur);
		animDameCoeur.setPlayMode(Animation.PlayMode.NORMAL);

		animationFramesRoiCoeur = atlasRoiCoeur.getRegions();
		animRoiCoeur = new Animation<TextureRegion> (totalAnimTime , animationFramesRoiCoeur);
		animRoiCoeur.setPlayMode(Animation.PlayMode.NORMAL);

		//--------------------------------------------------------------------------------------------------
		//---------------------------------------------------Trefle-----------------------------------------
		//--------------------------------------------------------------------------------------------------
		
		animationFramesAsTrefle = atlasAsTrefle.getRegions();
		animAsTrefle = new Animation<TextureRegion> (totalAnimTime , animationFramesAsTrefle);
		animAsTrefle.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesDeuxTrefle = atlasDeuxTrefle.getRegions();
		animDeuxTrefle = new Animation<TextureRegion> (totalAnimTime , animationFramesDeuxTrefle);
		animDeuxTrefle.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesTroisTrefle = atlasTroisTrefle.getRegions();
		animTroisTrefle = new Animation<TextureRegion> (totalAnimTime , animationFramesTroisTrefle);
		animTroisTrefle.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesQuatreTrefle = atlasQuatreTrefle.getRegions();
		animQuatreTrefle = new Animation<TextureRegion> (totalAnimTime , animationFramesQuatreTrefle);
		animQuatreTrefle.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesCinqTrefle = atlasCinqTrefle.getRegions();
		animCinqTrefle = new Animation<TextureRegion> (totalAnimTime , animationFramesCinqTrefle);
		animCinqTrefle.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesSixTrefle = atlasSixTrefle.getRegions();
		animSixTrefle = new Animation<TextureRegion> (totalAnimTime , animationFramesSixTrefle);
		animSixTrefle.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesSeptTrefle = atlasSeptTrefle.getRegions();
		animSeptTrefle = new Animation<TextureRegion> (totalAnimTime , animationFramesSeptTrefle);
		animSeptTrefle.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesHuitTrefle = atlasHuitTrefle.getRegions();
		animHuitTrefle = new Animation<TextureRegion> (totalAnimTime , animationFramesHuitTrefle);
		animHuitTrefle.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesNeufTrefle = atlasNeufTrefle.getRegions();
		animNeufTrefle = new Animation<TextureRegion> (totalAnimTime , animationFramesNeufTrefle);
		animNeufTrefle.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesDixTrefle = atlasDixTrefle.getRegions();
		animDixTrefle = new Animation<TextureRegion> (totalAnimTime , animationFramesDixTrefle);
		animDixTrefle.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesValetTrefle = atlasValetTrefle.getRegions();
		animValetTrefle = new Animation<TextureRegion> (totalAnimTime , animationFramesValetTrefle);
		animValetTrefle.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesDameTrefle = atlasDameTrefle.getRegions();
		animDameTrefle = new Animation<TextureRegion> (totalAnimTime , animationFramesDameTrefle);
		animDameTrefle.setPlayMode(Animation.PlayMode.NORMAL);

		animationFramesRoiTrefle = atlasRoiTrefle.getRegions();
		animRoiTrefle = new Animation<TextureRegion> (totalAnimTime , animationFramesRoiTrefle);
		animRoiTrefle.setPlayMode(Animation.PlayMode.NORMAL);

		//--------------------------------------------------------------------------------------------------
		//---------------------------------------------------Pique------------------------------------------
		//--------------------------------------------------------------------------------------------------
		
		animationFramesAsPique = atlasAsPique.getRegions();
		animAsPique = new Animation<TextureRegion> (totalAnimTime , animationFramesAsPique);
		animAsPique.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesDeuxPique = atlasDeuxPique.getRegions();
		animDeuxPique = new Animation<TextureRegion> (totalAnimTime , animationFramesDeuxPique);
		animDeuxPique.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesTroisPique = atlasTroisPique.getRegions();
		animTroisPique = new Animation<TextureRegion> (totalAnimTime , animationFramesTroisPique);
		animTroisPique.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesQuatrePique = atlasQuatrePique.getRegions();
		animQuatrePique = new Animation<TextureRegion> (totalAnimTime , animationFramesQuatrePique);
		animQuatrePique.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesCinqPique = atlasCinqPique.getRegions();
		animCinqPique = new Animation<TextureRegion> (totalAnimTime , animationFramesCinqPique);
		animCinqPique.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesSixPique = atlasSixPique.getRegions();
		animSixPique = new Animation<TextureRegion> (totalAnimTime , animationFramesSixPique);
		animSixPique.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesSeptPique = atlasSeptPique.getRegions();
		animSeptPique = new Animation<TextureRegion> (totalAnimTime , animationFramesSeptPique);
		animSeptPique.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesHuitPique = atlasHuitPique.getRegions();
		animHuitPique = new Animation<TextureRegion> (totalAnimTime , animationFramesHuitPique);
		animHuitPique.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesNeufPique = atlasNeufPique.getRegions();
		animNeufPique = new Animation<TextureRegion> (totalAnimTime , animationFramesNeufPique);
		animNeufPique.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesDixPique = atlasDixPique.getRegions();
		animDixPique = new Animation<TextureRegion> (totalAnimTime , animationFramesDixPique);
		animDixPique.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesValetPique = atlasValetPique.getRegions();
		animValetPique = new Animation<TextureRegion> (totalAnimTime , animationFramesValetPique);
		animValetPique.setPlayMode(Animation.PlayMode.NORMAL);
		
		animationFramesDamePique = atlasDamePique.getRegions();
		animDamePique = new Animation<TextureRegion> (totalAnimTime , animationFramesDamePique);
		animDamePique.setPlayMode(Animation.PlayMode.NORMAL);

		animationFramesRoiPique = atlasRoiPique.getRegions();
		animRoiPique = new Animation<TextureRegion> (totalAnimTime , animationFramesRoiPique);
		animRoiPique.setPlayMode(Animation.PlayMode.NORMAL);
		
		/*
		animationPack.add(0, animAsCoeur);
		animationPack.add(1, animDeuxCoeur);
		animationPack.add(2, animTroisCoeur);
		animationPack.add(3, animQuatreCoeur);
		animationPack.add(4, animCinqCoeur);
		animationPack.add(5, animSixCoeur);
		animationPack.add(6, animSeptCoeur);
		animationPack.add(7, animHuitCoeur);
		animationPack.add(8, animNeufCoeur);
		animationPack.add(9, animDixCoeur);
		animationPack.add(10, animValetCoeur);
		animationPack.add(11, animDameCoeur);
		animationPack.add(12, animRoiCoeur);
		animationPack.add(13, animAsTrefle);
		animationPack.add(14, animDeuxTrefle);
		animationPack.add(15, animTroisTrefle);
		animationPack.add(16, animQuatreTrefle);
		animationPack.add(17, animCinqTrefle);
		animationPack.add(18, animSixTrefle);
		animationPack.add(19, animSeptTrefle);
		animationPack.add(20, animHuitTrefle);
		animationPack.add(21, animNeufTrefle);
		animationPack.add(22, animDixTrefle);
		animationPack.add(23, animValetTrefle);
		animationPack.add(24, animDameTrefle);
		animationPack.add(25, animRoiTrefle);
		animationPack.add(26, animAsCarreau);
		animationPack.add(27, animDeuxCarreau);
		animationPack.add(28, animTroisCarreau);
		animationPack.add(29, animQuatreCarreau);
		animationPack.add(30, animCinqCarreau);
		animationPack.add(31, animSixCarreau);
		animationPack.add(32, animSeptCarreau);
		animationPack.add(33, animHuitCarreau);
		animationPack.add(34, animNeufCarreau);
		animationPack.add(35, animDixCarreau);
		animationPack.add(36, animValetCarreau);
		animationPack.add(37, animDameCarreau);
		animationPack.add(38, animRoiCarreau);
		animationPack.add(39, animAsPique);
		animationPack.add(40, animDeuxPique);
		animationPack.add(41, animTroisPique);
		animationPack.add(42, animQuatrePique);
		animationPack.add(43, animCinqPique);
		animationPack.add(44, animSixPique);
		animationPack.add(45, animSeptPique);
		animationPack.add(46, animHuitPique);
		animationPack.add(47, animNeufPique);
		animationPack.add(48, animDixPique);
		animationPack.add(49, animValetPique);
		animationPack.add(50, animDamePique);
		animationPack.add(51, animRoiPique);
		*/
	
	}

	/**
	 * Permet de retourner notre ArrayList contenant toutes les animations.
	 * @return
	 */
	public ArrayList<Animation<TextureRegion>> getAnimationsPack() {
		return animationPack;
	}
	
	/**
	 * On créer ici une ArrayList qui va définir et stocker les animations de toutes les cartes 
	 * pour pouvoir appeler les animations facilement pour la suite.
	 * @param p1
	 */
	public void creaAnimations(ArrayList<Animation<TextureRegion>> p1) {
		for (int i =0;i<p1.size();i++) {
			animationPack.add(p1.get(i));
		}
	}
	
}