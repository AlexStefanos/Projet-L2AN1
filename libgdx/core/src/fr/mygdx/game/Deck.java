package fr.mygdx.game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.Collections;

public class Deck extends Animations{
	private ArrayList<Integer> jeu;
	private ArrayList<Animation<TextureRegion>> jeutext;
	private ArrayList<String>  jeunoms;
		
		public Deck(ArrayList<Animation<TextureRegion>> animationPack) {
			super(animationPack);
			jeu = new ArrayList<Integer>(312);
			jeutext = new ArrayList<Animation<TextureRegion>>(312);
			jeunoms = new ArrayList<String>(312);
		}

		public void generateur() {
			for (int i = 1; i<14;i++) {
				for (int j = 0;j<24;j++) {
					jeu.add(i); 
				}
				
			}
		}
		public void afficher() {
			for (int i = 0;i<312;i++) {
		    System.out.println(jeu.get(i)+ " ");
			}
		}
		
		public void affichernoms() {
			for (int i = 0;i<312;i++) {
		    System.out.println(jeutext.get(i)+ " ");
			}
		}
		public int getSize() {
			return jeu.size();
		}
		public void conversion() {
			for (int i = 0; i<312;i++) {
				if (jeu.get(i) > 10) {
					jeu.set(i, 10);
				}
			}
		}
		public void creationn() {
			for (int i = 0;i<24;i++) {
				for (int j = 1;j<14;j++) {
					
					if (i<6) {
						if (j == 1) {
							jeutext.add(animAsCoeur);
							jeunoms.add("AsCoeur");
						}
						else if (j == 2) {
							jeutext.add(animDeuxCoeur);
							jeunoms.add("DeuxCoeur");
						}
						else if (j == 3) {
							jeutext.add(animTroisCoeur);
							jeunoms.add("TroisCoeur");
						}
						else if (j == 4) {
							jeutext.add(animQuatreCoeur);
							jeunoms.add("QuatreCoeur");
						}
						else if (j == 5) {
							jeutext.add(animCinqCoeur);
							jeunoms.add("CinqCoeur");
						}
						else if (j == 6) {
							jeutext.add(animSixCoeur);
							jeunoms.add("SixCoeur");
						}
						else if (j == 7) {
							jeutext.add(animSeptCoeur);
							jeunoms.add("SeptCoeur");
						}
						else if (j == 8) {
							jeutext.add(animHuitCoeur);
							jeunoms.add("HuitCoeur");
						}
						else if (j == 9) {
							jeutext.add(animNeufCoeur);
							jeunoms.add("NeufCoeur");
						}
						else if (j == 10) {
							jeutext.add(animDixCoeur);
							jeunoms.add("DixCoeur");
						}
						else if (j == 11) {
							jeutext.add(animValetCoeur);
							jeunoms.add("ValetCoeur");
						}
						else if (j == 12) {
							jeutext.add(animDameCoeur);
							jeunoms.add("DameCoeur");}
						else if (j == 13) {
							jeutext.add(animRoiCoeur);
							jeunoms.add("RoiCoeur");
						
					}
						
				}
					else if (i>=6 && i<12) {
						if (j == 1) {
							jeutext.add(animAsTrefle);
							jeunoms.add("AsTrefle");
						}
						else if (j == 2) {
							jeutext.add(animDeuxTrefle);
							jeunoms.add("DeuxTrefle");
						}
						else if (j == 3) {
							jeutext.add(animTroisTrefle);
							jeunoms.add("TroisTrefle");
						}
						else if (j == 4) {
							jeutext.add(animQuatreTrefle);
							jeunoms.add("QuatreTrefle");
						}
						else if (j == 5) {
							jeutext.add(animCinqTrefle);
							jeunoms.add("CinqTrefle");
						}
						else if (j == 6) {
							jeutext.add(animSixTrefle);
							jeunoms.add("SixTrefle");
						}
						else if (j == 7) {
							jeutext.add(animSeptTrefle);
							jeunoms.add("SeptTrefle");
						}
						else if (j == 8) {
							jeutext.add(animHuitTrefle);
							jeunoms.add("HuitTrefle");
						}
						else if (j == 9) {
							jeutext.add(animNeufTrefle);
							jeunoms.add("NeufTrefle");
						}
						else if (j == 10) {
							jeutext.add(animDixTrefle);
							jeunoms.add("DixTrefle");
						}
						else if (j == 11) {
							jeutext.add(animValetTrefle);
							jeunoms.add("ValetTrefle");
						}
						else if (j == 12) {
							jeutext.add(animDameTrefle);
							jeunoms.add("DameTrefle");
						}
						else if (j == 13) {
							jeutext.add(animRoiTrefle);
							jeunoms.add("RoiTrefle");
						
					
					}
					}
						else if (i>=12 && i<18) {
							if (j == 1) {
								jeutext.add(animAsCarreau);
								jeunoms.add("AsCarreau");
							}
							else if (j == 2) {
								jeutext.add(animDeuxCarreau);
								jeunoms.add("DeuxCarreau");
							}
							else if (j == 3) {
								jeutext.add(animTroisCarreau);
								jeunoms.add("TroisCarreau");
							}
							else if (j == 4) {
								jeutext.add(animQuatreCarreau);
								jeunoms.add("QuatreCarreau");
							}
							else if (j == 5) {
								jeutext.add(animCinqCarreau);
								jeunoms.add("CinqCarreau");
							}
							else if (j == 6) {
								jeutext.add(animSixCarreau);
								jeunoms.add("SixCarreau");
							}
							else if (j == 7) {
								jeutext.add(animSeptCarreau);
								jeunoms.add("SeptCarreau");
							}
							else if (j == 8) {
								jeutext.add(animHuitCarreau);
								jeunoms.add("HuitCarreau");
							}
							else if (j == 9) {
								jeutext.add(animNeufCarreau);
								jeunoms.add("NeufCarreau");
							}
							else if (j == 10) {
								jeutext.add(animDixCarreau);
								jeunoms.add("DixCarreau");
							}
							else if (j == 11) {
								jeutext.add(animValetCarreau);
								jeunoms.add("ValetCarreau");
							}
							else if (j == 12) {
								jeutext.add(animDameCarreau);
								jeunoms.add("DameCarreau");
							}
							else if (j == 13) {
								jeutext.add(animRoiCarreau);
								jeunoms.add("RoiCarreau");
							
					}
						
				}
						else if (i>=18 && i<24) {
							if (j == 1) {
								jeutext.add(animAsPique);
								jeunoms.add("AsPique");
							}
							else if (j == 2) {
								jeutext.add(animDeuxPique);
								jeunoms.add("DeuxPique");
							}
							else if (j == 3) {
								jeutext.add(animTroisPique);
								jeunoms.add("TroisPique");
							}
							else if (j == 4) {
								jeutext.add(animQuatrePique);
								jeunoms.add("QuatrePique");
							}
							else if (j == 5) {
								jeutext.add(animCinqPique);
								jeunoms.add("CinqPique");
							}
							else if (j == 6) {
								jeutext.add(animSixPique);
								jeunoms.add("SixPique");
							}
							else if (j == 7) {
								jeutext.add(animSeptPique);
								jeunoms.add("SeptPique");
							}
							else if (j == 8) {
								jeutext.add(animHuitPique);
								jeunoms.add("(HuitPique");
							}
							else if (j == 9) {
								jeutext.add(animNeufPique);
								jeunoms.add("NeufPique");
							}
							else if (j == 10) {
								jeutext.add(animDixPique);
								jeunoms.add("DixPique");
							}
							else if (j == 11) {
								jeutext.add(animValetPique);
								jeunoms.add("ValetPique");
							}
							else if (j == 12) {
								jeutext.add(animDamePique);
								jeunoms.add("DamePique");
							}
							else if (j == 13) {
								jeutext.add(animRoiPique);		
								jeunoms.add("RoiPique");
			}
		}
			}
			
	}
}
		public void toNb() {
			for (int i =0;i<312;i++) {
				if (jeutext.get(i) == animAsPique || jeutext.get(i) == animAsCoeur || jeutext.get(i) == animAsTrefle || jeutext.get(i) == animAsCarreau) {
					jeu.add(1);
				}
				else if (jeutext.get(i) == animDeuxPique || jeutext.get(i) == animDeuxCoeur || jeutext.get(i) == animDeuxTrefle || jeutext.get(i) == animDeuxCarreau) {
					jeu.add(2);
				}
				else if (jeutext.get(i) == animTroisPique || jeutext.get(i) == animTroisCoeur || jeutext.get(i) == animTroisTrefle || jeutext.get(i) == animTroisCarreau) {
					jeu.add(3);
				}
				else if (jeutext.get(i) == animQuatrePique || jeutext.get(i) == animQuatreCoeur || jeutext.get(i) == animQuatreTrefle || jeutext.get(i) == animQuatreCarreau) {
					jeu.add(4);
				}
				else if (jeutext.get(i) == animCinqPique || jeutext.get(i) == animCinqCoeur || jeutext.get(i) == animCinqTrefle || jeutext.get(i) == animCinqCarreau) {
					jeu.add(5);
				}
				else if (jeutext.get(i) == animSixPique || jeutext.get(i) == animSixCoeur || jeutext.get(i) == animSixTrefle || jeutext.get(i) == animSixCarreau) {
					jeu.add(6);
				}
				else if (jeutext.get(i) == animSeptPique || jeutext.get(i) == animSeptCoeur || jeutext.get(i) == animSeptTrefle || jeutext.get(i) == animSeptCarreau) {
					jeu.add(7);
				}
				else if (jeutext.get(i) == animHuitPique || jeutext.get(i) == animHuitCoeur || jeutext.get(i) == animHuitTrefle || jeutext.get(i) == animHuitCarreau) {
					jeu.add(8);
				}
				else if (jeutext.get(i) == animNeufPique || jeutext.get(i) == animNeufCoeur || jeutext.get(i) == animNeufTrefle || jeutext.get(i) == animNeufCarreau) {
					jeu.add(9);
				}
				else if (jeutext.get(i) == animDixPique || jeutext.get(i) == animDixCoeur || jeutext.get(i) == animDixTrefle || jeutext.get(i) == animDixCarreau) {
					jeu.add(10);
				}
				else if (jeutext.get(i) == animValetPique || jeutext.get(i) == animValetCoeur || jeutext.get(i) == animValetTrefle || jeutext.get(i) == animValetCarreau) {
					jeu.add(10);
				}
				else if (jeutext.get(i) == animDamePique || jeutext.get(i) == animDameCoeur || jeutext.get(i) == animDameTrefle || jeutext.get(i) == animDameCarreau) {
					jeu.add(10);
				}
				else if (jeutext.get(i) == animRoiPique || jeutext.get(i) == animRoiCoeur || jeutext.get(i) == animRoiTrefle || jeutext.get(i) == animRoiCarreau) {
					jeu.add(10);
				}
				
			}
			for (int i =0;i<312;i++) {
				
				if (jeutext.get(i) == animAsPique ) {
					jeunoms.add("Aspique");
				}
				else if ( jeutext.get(i) == animAsCoeur) {
					jeunoms.add("AsCoeur");
				}
				else if (jeutext.get(i) == animAsTrefle) {
					jeunoms.add("AsTrefle");
				}
				else if ( jeutext.get(i) == animAsCarreau) {
					jeunoms.add("AsCarreau");
				}
				else if (jeutext.get(i) == animDeuxPique) {
					jeunoms.add("DeuxPique");
				}
				
				else if ( jeutext.get(i) == animDeuxCoeur) {
					jeunoms.add(" DeuxCoeur");
				}
				else if (jeutext.get(i) == animDeuxTrefle) {
					jeunoms.add("DeuxTrefle");
				}
				else if (jeutext.get(i) == animDeuxCarreau) {
					jeunoms.add("DeuxCarreau");
				}
				
				else if (jeutext.get(i) == animDeuxPique) {
					jeunoms.add("DeuxPique");
				}
				
				else if ( jeutext.get(i) == animTroisCoeur) {
					jeunoms.add("TroisCoeur");
				}
				else if (jeutext.get(i) == animTroisTrefle) {
					jeunoms.add("TroisTrefle");
				}
				else if (jeutext.get(i) == animTroisCarreau) {
					jeunoms.add("TroisCarreau");
				}
				else if (jeutext.get(i) == animQuatrePique) {
					jeunoms.add("QuatrePique");
				}
				else if (jeutext.get(i) == animQuatreCoeur) {
					jeunoms.add("QuatreCoeur");
				}
				else if (jeutext.get(i) == animQuatreTrefle) {
					jeunoms.add(" QuatreTrefle");
				}
				else if (jeutext.get(i) == animQuatreCarreau) {
					jeunoms.add("QuatreCarreau");
				}
				else if (jeutext.get(i) == animCinqPique) {
					jeunoms.add("CinqPique");
				}
				else if ( jeutext.get(i) == animCinqCoeur) {
					jeunoms.add("CinqCoeur");
				}
				else if (jeutext.get(i) == animCinqTrefle) {
					jeunoms.add(" CinqTrefle");
				}
				else if ( jeutext.get(i) == animCinqCarreau) {
					jeunoms.add("CinqCarreau");
				}
				
				else if (jeutext.get(i) == animSixPique) {
					jeunoms.add("SixPique");
				}
				else if ( jeutext.get(i) == animSixCoeur) {
					jeunoms.add("SixCoeur");
				}
				else if (jeutext.get(i) == animSixTrefle) {
					jeunoms.add("SixTrefle");
				}
				else if (jeutext.get(i) == animSixCarreau) {
					jeunoms.add("SixCarreau");
				}
				else if (jeutext.get(i) == animSeptPique) {
					jeunoms.add("SeptPique");
				}
				else if (jeutext.get(i) == animSeptCoeur) {
					jeunoms.add("SeptCoeur");
				}
				else if (jeutext.get(i) == animSeptTrefle) {
					jeunoms.add("SeptTrefle");
				}
				else if ( jeutext.get(i) == animSeptCarreau) {
					jeunoms.add("SeptCarreau");
				}
				else if (jeutext.get(i) == animHuitPique) {
					jeunoms.add(" HuitPique");
				}
				else if ( jeutext.get(i) == animHuitCoeur) {
					jeunoms.add("HuitCoeur");
				}
				else if (jeutext.get(i) == animHuitTrefle) {
					jeunoms.add("HuitTrefle");
				}
				else if ( jeutext.get(i) == animHuitCarreau) {
					jeunoms.add("HuitCarreau");
				}
				else if (jeutext.get(i) == animNeufPique) {
					jeunoms.add("NeufPique");
				}
				else if (jeutext.get(i) == animNeufCoeur) {
					jeunoms.add("NeufCoeur");
				}
				else if ( jeutext.get(i) == animNeufTrefle) {
					jeunoms.add("NeufTrefle");
				}
				else if (jeutext.get(i) == animNeufCarreau) {
					jeunoms.add("NeufCarreau");
				}
				else if (jeutext.get(i) == animDixPique) {
					jeunoms.add("DixPique");
				}
				else if ( jeutext.get(i) == animDixTrefle) {
					jeunoms.add("DixTrefle");
				}
				else if (jeutext.get(i) == animDixCarreau) {
					jeunoms.add("DixCarreau");
				}
				else if ( jeutext.get(i) == animValetPique) {
					jeunoms.add("ValetPique");
				}
				else if (jeutext.get(i) == animValetCoeur) {
					jeunoms.add("ValetCoeur");
				}
				else if (  jeutext.get(i) == animValetTrefle) {
					jeunoms.add("ValetTrefle");
				}
				else if (jeutext.get(i) == animValetCarreau) {
					jeunoms.add("ValetCarreau");
				}
				else if ( jeutext.get(i) == animDamePique) {
					jeunoms.add("DamePique");
				}
				else if (jeutext.get(i) == animDameCoeur) {
					jeunoms.add("DameCoeur");
				}
				else if ( jeutext.get(i) == animDameTrefle) {
					jeunoms.add("DameTrefle");
				}
				else if ( jeutext.get(i) == animDameCarreau) {
					jeunoms.add("DameCarreau");
				}
				else if (jeutext.get(i) == animRoiPique) {
					jeunoms.add("RoiPique");
				}
				else if (jeutext.get(i) == animRoiCoeur) {
					jeunoms.add("RoiCoeur");
				}
				else if ( jeutext.get(i) == animRoiTrefle) {
					jeunoms.add("RoiTrefle");
				}
				else if (jeutext.get(i) == animRoiCarreau) {
					jeunoms.add("RoiCarreau");
				}
				
				
			}
		}
		
		/*public void creation() {
			for (int i = 0; i<312;i++) {
				
				if (jeu.get(i) == 1) {
					jeutext.add("As");
				}
				else if (jeu.get(i) == 2) {
					jeutext.add("Deux");
				}
				else if (jeu.get(i) == 3) {
					jeutext.add("Trois");
				}
				else if (jeu.get(i) == 4) {
					jeutext.add("Quatre");
				}
				else if (jeu.get(i) == 5) {
					jeutext.add("Cinq");
				}
				else if (jeu.get(i) == 6) {
					jeutext.add("Six");
				}
				else if (jeu.get(i) == 7) {
					jeutext.add("Sept");
				}
				else if (jeu.get(i) == 8) {
					jeutext.add("Huit");
				}
				else if (jeu.get(i) == 9) {
					jeutext.add("Neuf");
				}
				else if (jeu.get(i) == 10) {
					jeutext.add("Dix");
				}
				else if (jeu.get(i) == 11) {
					jeutext.add("Valet");
				}
				else if (jeu.get(i) == 12) {
					jeutext.add("Dame");
				}
				else if (jeu.get(i) == 13) {
					jeutext.add("Roi");
				}
			} 
			
			
			
		}*/
		
		
		
		public void shuffle() {
			Collections.shuffle(jeutext);
			
		}
		public ArrayList<Integer> getPaquet() {
			return jeu;
		}
		public ArrayList<Animation<TextureRegion>> getPaquetText(){
			return jeutext;
		}
		public ArrayList<String> getPaquetNom(){
			return jeunoms;
		}
}	
