package fr.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class CardsTextures {
	
	private Texture BlackjackTable, FondCarteBleu, AsTrefle, DeuxTrefle, TroisTrefle, QuatreTrefle, CinqTrefle, SixTrefle, 
	SeptTrefle, HuitTrefle, NeufTrefle, DixTrefle, ValetTrefle, DameTrefle, RoiTrefle, AsCarreau, DeuxCarreau, TroisCarreau, QuatreCarreau, 
	CinqCarreau, SixCarreau, SeptCarreau, HuitCarreau, NeufCarreau, DixCarreau, ValetCarreau, DameCarreau, RoiCarreau, AsCoeur, DeuxCoeur, TroisCoeur,
	QuatreCoeur, CinqCoeur, SixCoeur, SeptCoeur, HuitCoeur, NeufCoeur, DixCoeur, ValetCoeur, DameCoeur, RoiCoeur, AsPique, DeuxPique, 
	TroisPique, QuatrePique, CinqPique, SixPique, SeptPique, HuitPique, NeufPique, DixPique, ValetPique, DamePique, RoiPique, JokerBlack, 
	JokerRed, JetonBleu, JetonRouge, JetonVert, JetonJaune, JetonBleuClair, JetonBeige, JetonBlanc;
	private ArrayList<Texture> texturespack;
	
	public CardsTextures(ArrayList<Texture> texturespack) {
		this.texturespack = texturespack;
		
		FondCarteBleu = new Texture("Large/Back Blue 2.png");
		AsTrefle = new Texture("Large/Clubs 1.png");
		DeuxTrefle = new Texture("Large/Clubs 2.png"); 
		TroisTrefle = new Texture("Large/Clubs 3.png");
		QuatreTrefle = new Texture("Large/Clubs 4.png");
		CinqTrefle = new Texture("Large/Clubs 5.png");
		SixTrefle = new Texture("Large/Clubs 6.png");
		SeptTrefle = new Texture("Large/Clubs 7.png");
		HuitTrefle = new Texture("Large/Clubs 8.png");
		NeufTrefle = new Texture("Large/Clubs 9.png");
		DixTrefle = new Texture("Large/Clubs 10.png");
		ValetTrefle = new Texture("Large/Clubs 11.png");
		DameTrefle = new Texture("Large/Clubs 12.png");
		RoiTrefle = new Texture("Large/Clubs 13.png");
		AsCarreau = new Texture("Large/Diamond 1.png");
		DeuxCarreau = new Texture("Large/Diamond 2.png");
		TroisCarreau = new Texture("Large/Diamond 3.png");
		QuatreCarreau = new Texture("Large/Diamond 4.png");
		CinqCarreau = new Texture("Large/Diamond 5.png");
		SixCarreau = new Texture("Large/Diamond 6.png");
		SeptCarreau = new Texture("Large/Diamond 7.png");
		HuitCarreau = new Texture("Large/Diamond 8.png");
		NeufCarreau = new Texture("Large/Diamond 9.png");
		DixCarreau = new Texture("Large/Diamond 10.png");
		ValetCarreau = new Texture("Large/Diamond 11.png");
		DameCarreau = new Texture("Large/Diamond 12.png");
		RoiCarreau = new Texture("Large/Diamond 13.png");
		AsCoeur = new Texture("Large/Hearts 1.png");
		DeuxCoeur = new Texture("Large/Hearts 2.png");
		TroisCoeur = new Texture("Large/Hearts 3.png");
		QuatreCoeur = new Texture("Large/Hearts 4.png");
		CinqCoeur = new Texture("Large/Hearts 5.png");
		SixCoeur = new Texture("Large/Hearts 6.png");
		SeptCoeur = new Texture("Large/Hearts 7.png");
		HuitCoeur = new Texture("Large/Hearts 8.png");
		NeufCoeur = new Texture("Large/Hearts 9.png");
		DixCoeur = new Texture("Large/Hearts 10.png");
		ValetCoeur = new Texture("Large/Hearts 11.png");
		DameCoeur = new Texture("Large/Hearts 12.png");
		RoiCoeur = new Texture("Large/Hearts 13.png");
		AsPique = new Texture("Large/Spades 1.png");
		DeuxPique = new Texture("Large/Spades 2.png");
		TroisPique = new Texture("Large/Spades 3.png");
		QuatrePique = new Texture("Large/Spades 4.png");
		CinqPique = new Texture("Large/Spades 5.png");
		SixPique = new Texture("Large/Spades 6.png");
		SeptPique = new Texture("Large/Spades 7.png");
		HuitPique = new Texture("Large/Spades 8.png");
		NeufPique = new Texture("Large/Spades 9.png");
		DixPique = new Texture("Large/Spades 10.png");
		ValetPique = new Texture("Large/Spades 11.png");
		DamePique = new Texture("Large/Spades 12.png");
		RoiPique = new Texture("Large/Spades 13.png");
		JokerBlack = new Texture("Large/Joker Black.png");
		JokerRed = new Texture("Large/Joker Red.png");
		JetonBleu = new Texture("LargeChips/chip_blue.png");
		JetonBleuClair = new Texture("LargeChips/chip_lightblue.png");
		JetonRouge = new Texture("LargeChips/chip_red.png");
		JetonBlanc = new Texture("LargeChips/chip_white.png");
		JetonVert = new Texture("LargeChips/chip_green.png");
		JetonBeige = new Texture("LargeChips/chip_biege.png");
		JetonJaune = new Texture("LargeChips/chip_yellow.png");

		texturespack.add(0, AsCoeur);
		texturespack.add(1, DeuxCoeur);
		texturespack.add(2, TroisCoeur);
		texturespack.add(3, QuatreCoeur);
		texturespack.add(4, CinqCoeur);
		texturespack.add(5, SixCoeur);
		texturespack.add(6, SeptCoeur);
		texturespack.add(7, HuitCoeur);
		texturespack.add(8, NeufCoeur);
		texturespack.add(9, DixCoeur);
		texturespack.add(10, ValetCoeur);
		texturespack.add(11, DameCoeur);
		texturespack.add(12, RoiCoeur);
		texturespack.add(13, AsTrefle);
		texturespack.add(14, DeuxTrefle);
		texturespack.add(15, TroisTrefle);
		texturespack.add(16, QuatreTrefle);
		texturespack.add(17, CinqTrefle);
		texturespack.add(18, SixTrefle);
		texturespack.add(19, SeptTrefle);
		texturespack.add(20, HuitTrefle);
		texturespack.add(21, NeufTrefle);
		texturespack.add(22, DixTrefle);
		texturespack.add(23, ValetTrefle);
		texturespack.add(24, DameTrefle);
		texturespack.add(25, RoiTrefle);
		texturespack.add(26, AsCarreau);
		texturespack.add(27, DeuxCarreau);
		texturespack.add(28, TroisCarreau);
		texturespack.add(29, QuatreCarreau);
		texturespack.add(30, CinqCarreau);
		texturespack.add(31, SixCarreau);
		texturespack.add(32, SeptCarreau);
		texturespack.add(33, HuitCarreau);
		texturespack.add(34, NeufCarreau);
		texturespack.add(35, DixCarreau);
		texturespack.add(36, ValetCarreau);
		texturespack.add(37, DameCarreau);
		texturespack.add(38, RoiCarreau);
		texturespack.add(39, AsPique);
		texturespack.add(40, DeuxPique);
		texturespack.add(41, TroisPique);
		texturespack.add(42, QuatrePique);
		texturespack.add(43, CinqPique);
		texturespack.add(44, SeptPique);
		texturespack.add(45, HuitPique);
		texturespack.add(46, NeufPique);
		texturespack.add(47, DixPique);
		texturespack.add(48, ValetPique);
		texturespack.add(49, DamePique);
		texturespack.add(50, RoiPique);
		texturespack.add(51, JokerRed);
		texturespack.add(52, JokerBlack);
	}
	
	public ArrayList<Texture> getTexturespack() {
		return texturespack;
	}
}
