package fr.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Permet de construire le paquet avec lequel on va jouer
 * 
 *
 */
public class Deck extends Animations{
	private ArrayList<Integer> deckInt;
	private ArrayList<Animation<TextureRegion>> deckAnim;
	private ArrayList<String>  deckStr;
		
		public Deck(ArrayList<Animation<TextureRegion>> animationPack) {
			super(animationPack);
			deckInt = new ArrayList<Integer>(312);
			deckAnim = new ArrayList<Animation<TextureRegion>>(312);
			deckStr = new ArrayList<String>(312);
		}
		
		/**
		 * Permet la generation des paquets de cartes pour jouer au blackjack, ici 6 paquets car le blackjack se joue avec 6 paquets.
		 */

		public void generateur() {
			for (int i = 1; i<14;i++) {
				for (int j = 0;j<24;j++) {
					deckInt.add(i); 
				}
			}
		}
	    public int getSize() {
			return deckInt.size();
		}
	    /**
	     * Permet de convertir les tetes en 10.
	     */
		public void conversion() {
			for (int i = 0; i<312;i++) {
				if (deckInt.get(i) > 10) {
					deckInt.set(i, 10);
				}
			}
		}
		
		/**
		 * Permet de lier les animations aux bonnes cartes.
		 */
		public void creationn() {
			for (int i = 0;i<24;i++) {
				for (int j = 1;j<14;j++) {
					
					if (i<6) {
						if (j == 1) {
							deckAnim.add(animAsCoeur);
						}
						else if (j == 2) {
							deckAnim.add(animDeuxCoeur);
						}
						else if (j == 3) {
							deckAnim.add(animTroisCoeur);
						}
						else if (j == 4) {
							deckAnim.add(animQuatreCoeur);
						}
						else if (j == 5) {
							deckAnim.add(animCinqCoeur);
						}
						else if (j == 6) {
							deckAnim.add(animSixCoeur);
						}
						else if (j == 7) {
							deckAnim.add(animSeptCoeur);
						}
						else if (j == 8) {
							deckAnim.add(animHuitCoeur);
						}
						else if (j == 9) {
							deckAnim.add(animNeufCoeur);
						}
						else if (j == 10) {
							deckAnim.add(animDixCoeur);
						}
						else if (j == 11) {
							deckAnim.add(animValetCoeur);
						}
						else if (j == 12) {
							deckAnim.add(animDameCoeur);
						}
						else if (j == 13) {
							deckAnim.add(animRoiCoeur);
							
						
					}
						
				}
					else if (i>=6 && i<12) {
						if (j == 1) {
							deckAnim.add(animAsTrefle);
						}
						else if (j == 2) {
							deckAnim.add(animDeuxTrefle);
						}
						else if (j == 3) {
							deckAnim.add(animTroisTrefle);
						}
						else if (j == 4) {
							deckAnim.add(animQuatreTrefle);
						}
						else if (j == 5) {
							deckAnim.add(animCinqTrefle);
						}
						else if (j == 6) {
							deckAnim.add(animSixTrefle);
						}
						else if (j == 7) {
							deckAnim.add(animSeptTrefle);
						}
						else if (j == 8) {
							deckAnim.add(animHuitTrefle);
						}
						else if (j == 9) {
							deckAnim.add(animNeufTrefle);
						}
						else if (j == 10) {
							deckAnim.add(animDixTrefle);
						}
						else if (j == 11) {
							deckAnim.add(animValetTrefle);
						}
						else if (j == 12) {
							deckAnim.add(animDameTrefle);
						}
						else if (j == 13) {
							deckAnim.add(animRoiTrefle);
							
						
					
					}
					}
						else if (i>=12 && i<18) {
							if (j == 1) {
								deckAnim.add(animAsCarreau);
							}
							else if (j == 2) {
								deckAnim.add(animDeuxCarreau);
							}
							else if (j == 3) {
								deckAnim.add(animTroisCarreau);
							}
							else if (j == 4) {
								deckAnim.add(animQuatreCarreau);
							}
							else if (j == 5) {
								deckAnim.add(animCinqCarreau);
							}
							else if (j == 6) {
								deckAnim.add(animSixCarreau);
							}
							else if (j == 7) {
								deckAnim.add(animSeptCarreau);
							}
							else if (j == 8) {
								deckAnim.add(animHuitCarreau);
							}
							else if (j == 9) {
								deckAnim.add(animNeufCarreau);
							}
							else if (j == 10) {
								deckAnim.add(animDixCarreau);
							}
							else if (j == 11) {
								deckAnim.add(animValetCarreau);
							}
							else if (j == 12) {
								deckAnim.add(animDameCarreau);
							}
							else if (j == 13) {
								deckAnim.add(animRoiCarreau);
								
							
					}
						
				}
						else if (i>=18 && i<24) {
							if (j == 1) {
								deckAnim.add(animAsPique);
							}
							else if (j == 2) {
								deckAnim.add(animDeuxPique);
							}
							else if (j == 3) {
								deckAnim.add(animTroisPique);
							}
							else if (j == 4) {
								deckAnim.add(animQuatrePique);
							}
							else if (j == 5) {
								deckAnim.add(animCinqPique);
							}
							else if (j == 6) {
								deckAnim.add(animSixPique);
							}
							else if (j == 7) {
								deckAnim.add(animSeptPique);
							}
							else if (j == 8) {
								deckAnim.add(animHuitPique);
							}
							else if (j == 9) {
								deckAnim.add(animNeufPique);
							}
							else if (j == 10) {
								deckAnim.add(animDixPique);
							}
							else if (j == 11) {
								deckAnim.add(animValetPique);
							}
							else if (j == 12) {
								deckAnim.add(animDamePique);
							}
							else if (j == 13) {
								deckAnim.add(animRoiPique);		
						}
		         }
			}
		}
}
		/**
		 * Ajoute les valeurs entieres selon les animations dans l'arraylist.
		 */
		public void toNb() {
			for (int i =0;i<312;i++) {
				if (deckAnim.get(i) == animAsPique || deckAnim.get(i) == animAsCoeur || deckAnim.get(i) == animAsTrefle || deckAnim.get(i) == animAsCarreau) {
					deckInt.add(1);
				}
				else if (deckAnim.get(i) == animDeuxPique || deckAnim.get(i) == animDeuxCoeur || deckAnim.get(i) == animDeuxTrefle || deckAnim.get(i) == animDeuxCarreau) {
					deckInt.add(2);
				}
				else if (deckAnim.get(i) == animTroisPique || deckAnim.get(i) == animTroisCoeur || deckAnim.get(i) == animTroisTrefle || deckAnim.get(i) == animTroisCarreau) {
					deckInt.add(3);
				}
				else if (deckAnim.get(i) == animQuatrePique || deckAnim.get(i) == animQuatreCoeur || deckAnim.get(i) == animQuatreTrefle || deckAnim.get(i) == animQuatreCarreau) {
					deckInt.add(4);
				}
				else if (deckAnim.get(i) == animCinqPique || deckAnim.get(i) == animCinqCoeur || deckAnim.get(i) == animCinqTrefle || deckAnim.get(i) == animCinqCarreau) {
					deckInt.add(5);
				}
				else if (deckAnim.get(i) == animSixPique || deckAnim.get(i) == animSixCoeur || deckAnim.get(i) == animSixTrefle || deckAnim.get(i) == animSixCarreau) {
					deckInt.add(6);
				}
				else if (deckAnim.get(i) == animSeptPique || deckAnim.get(i) == animSeptCoeur || deckAnim.get(i) == animSeptTrefle || deckAnim.get(i) == animSeptCarreau) {
					deckInt.add(7);
				}
				else if (deckAnim.get(i) == animHuitPique || deckAnim.get(i) == animHuitCoeur || deckAnim.get(i) == animHuitTrefle || deckAnim.get(i) == animHuitCarreau) {
					deckInt.add(8);
				}
				else if (deckAnim.get(i) == animNeufPique || deckAnim.get(i) == animNeufCoeur || deckAnim.get(i) == animNeufTrefle || deckAnim.get(i) == animNeufCarreau) {
					deckInt.add(9);
				}
				else if (deckAnim.get(i) == animDixPique || deckAnim.get(i) == animDixCoeur || deckAnim.get(i) == animDixTrefle || deckAnim.get(i) == animDixCarreau) {
					deckInt.add(10);
				}
				else if (deckAnim.get(i) == animValetPique || deckAnim.get(i) == animValetCoeur || deckAnim.get(i) == animValetTrefle || deckAnim.get(i) == animValetCarreau) {
					deckInt.add(10);
				}
				else if (deckAnim.get(i) == animDamePique || deckAnim.get(i) == animDameCoeur || deckAnim.get(i) == animDameTrefle || deckAnim.get(i) == animDameCarreau) {
					deckInt.add(10);
				}
				else if (deckAnim.get(i) == animRoiPique || deckAnim.get(i) == animRoiCoeur || deckAnim.get(i) == animRoiTrefle || deckAnim.get(i) == animRoiCarreau) {
					deckInt.add(10);
				}
				
			}
			for (int i =0;i<312;i++) {
				
				if (deckAnim.get(i) == animAsPique ) {
					deckStr.add("Aspique");
				}
				else if ( deckAnim.get(i) == animAsCoeur) {
					deckStr.add("AsCoeur");
				}
				else if (deckAnim.get(i) == animAsTrefle) {
					deckStr.add("AsTrefle");
				}
				else if ( deckAnim.get(i) == animAsCarreau) {
					deckStr.add("AsCarreau");
				}
				else if (deckAnim.get(i) == animDeuxPique) {
					deckStr.add("DeuxPique");
				}
				
				else if ( deckAnim.get(i) == animDeuxCoeur) {
					deckStr.add(" DeuxCoeur");
				}
				else if (deckAnim.get(i) == animDeuxTrefle) {
					deckStr.add("DeuxTrefle");
				}
				else if (deckAnim.get(i) == animDeuxCarreau) {
					deckStr.add("DeuxCarreau");
				}
				
				else if (deckAnim.get(i) == animDeuxPique) {
					deckStr.add("DeuxPique");
				}
				
				else if ( deckAnim.get(i) == animTroisCoeur) {
					deckStr.add("TroisCoeur");
				}
				else if (deckAnim.get(i) == animTroisTrefle) {
					deckStr.add("TroisTrefle");
				}
				else if (deckAnim.get(i) == animTroisCarreau) {
					deckStr.add("TroisCarreau");
				}
				else if (deckAnim.get(i) == animQuatrePique) {
					deckStr.add("QuatrePique");
				}
				else if (deckAnim.get(i) == animQuatreCoeur) {
					deckStr.add("QuatreCoeur");
				}
				else if (deckAnim.get(i) == animQuatreTrefle) {
					deckStr.add(" QuatreTrefle");
				}
				else if (deckAnim.get(i) == animQuatreCarreau) {
					deckStr.add("QuatreCarreau");
				}
				else if (deckAnim.get(i) == animCinqPique) {
					deckStr.add("CinqPique");
				}
				else if ( deckAnim.get(i) == animCinqCoeur) {
					deckStr.add("CinqCoeur");
				}
				else if (deckAnim.get(i) == animCinqTrefle) {
					deckStr.add(" CinqTrefle");
				}
				else if ( deckAnim.get(i) == animCinqCarreau) {
					deckStr.add("CinqCarreau");
				}
				
				else if (deckAnim.get(i) == animSixPique) {
					deckStr.add("SixPique");
				}
				else if ( deckAnim.get(i) == animSixCoeur) {
					deckStr.add("SixCoeur");
				}
				else if (deckAnim.get(i) == animSixTrefle) {
					deckStr.add("SixTrefle");
				}
				else if (deckAnim.get(i) == animSixCarreau) {
					deckStr.add("SixCarreau");
				}
				else if (deckAnim.get(i) == animSeptPique) {
					deckStr.add("SeptPique");
				}
				else if (deckAnim.get(i) == animSeptCoeur) {
					deckStr.add("SeptCoeur");
				}
				else if (deckAnim.get(i) == animSeptTrefle) {
					deckStr.add("SeptTrefle");
				}
				else if ( deckAnim.get(i) == animSeptCarreau) {
					deckStr.add("SeptCarreau");
				}
				else if (deckAnim.get(i) == animHuitPique) {
					deckStr.add(" HuitPique");
				}
				else if ( deckAnim.get(i) == animHuitCoeur) {
					deckStr.add("HuitCoeur");
				}
				else if (deckAnim.get(i) == animHuitTrefle) {
					deckStr.add("HuitTrefle");
				}
				else if ( deckAnim.get(i) == animHuitCarreau) {
					deckStr.add("HuitCarreau");
				}
				else if (deckAnim.get(i) == animNeufPique) {
					deckStr.add("NeufPique");
				}
				else if (deckAnim.get(i) == animNeufCoeur) {
					deckStr.add("NeufCoeur");
				}
				else if ( deckAnim.get(i) == animNeufTrefle) {
					deckStr.add("NeufTrefle");
				}
				else if (deckAnim.get(i) == animNeufCarreau) {
					deckStr.add("NeufCarreau");
				}
				else if (deckAnim.get(i) == animDixPique) {
					deckStr.add("DixPique");
				}
				else if ( deckAnim.get(i) == animDixTrefle) {
					deckStr.add("DixTrefle");
				}
				else if (deckAnim.get(i) == animDixCarreau) {
					deckStr.add("DixCarreau");
				}
				else if ( deckAnim.get(i) == animValetPique) {
					deckStr.add("ValetPique");
				}
				else if (deckAnim.get(i) == animValetCoeur) {
					deckStr.add("ValetCoeur");
				}
				else if (  deckAnim.get(i) == animValetTrefle) {
					deckStr.add("ValetTrefle");
				}
				else if (deckAnim.get(i) == animValetCarreau) {
					deckStr.add("ValetCarreau");
				}
				else if ( deckAnim.get(i) == animDamePique) {
					deckStr.add("DamePique");
				}
				else if (deckAnim.get(i) == animDameCoeur) {
					deckStr.add("DameCoeur");
				}
				else if ( deckAnim.get(i) == animDameTrefle) {
					deckStr.add("DameTrefle");
				}
				else if ( deckAnim.get(i) == animDameCarreau) {
					deckStr.add("DameCarreau");
				}
				else if (deckAnim.get(i) == animRoiPique) {
					deckStr.add("RoiPique");
				}
				else if (deckAnim.get(i) == animRoiCoeur) {
					deckStr.add("RoiCoeur");
				}
				else if ( deckAnim.get(i) == animRoiTrefle) {
					deckStr.add("RoiTrefle");
				}
				else if (deckAnim.get(i) == animRoiCarreau) {
					deckStr.add("RoiCarreau");
				}
				
				
			}
		}
		
		
		
		
		/**
		 * Melange le paquet.
		 */
		public void shuffle() {
			Collections.shuffle(deckAnim);
			
		}
		public ArrayList<Integer> getPaquet() {
			return deckInt;
		}
		public ArrayList<Animation<TextureRegion>> getPaquetText(){
			return deckAnim;
		}
		public ArrayList<String> getPaquetNom(){
			return deckStr;
		}
}	
