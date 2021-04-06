package fr.mygdx.game;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.Collections;

public class Deck extends CardsTextures{
	private ArrayList<Integer> jeu;
	private ArrayList<Texture> jeutext;
	private ArrayList<String>  jeunoms;
		
		public Deck(ArrayList<Texture> texturespack) {
			super(texturespack);
			jeu = new ArrayList<Integer>(312);
			jeutext = new ArrayList<Texture>(312);
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
							jeutext.add(AsCoeur);
							jeunoms.add("AsCoeur");
						}
						else if (j == 2) {
							jeutext.add(DeuxCoeur);
							jeunoms.add("DeuxCoeur");
						}
						else if (j == 3) {
							jeutext.add(TroisCoeur);
							jeunoms.add("TroisCoeur");
						}
						else if (j == 4) {
							jeutext.add(QuatreCoeur);
							jeunoms.add("QuatreCoeur");
						}
						else if (j == 5) {
							jeutext.add(CinqCoeur);
							jeunoms.add("CinqCoeur");
						}
						else if (j == 6) {
							jeutext.add(SixCoeur);
							jeunoms.add("SixCoeur");
						}
						else if (j == 7) {
							jeutext.add(SeptCoeur);
							jeunoms.add("SeptCoeur");
						}
						else if (j == 8) {
							jeutext.add(HuitCoeur);
							jeunoms.add("HuitCoeur");
						}
						else if (j == 9) {
							jeutext.add(NeufCoeur);
							jeunoms.add("NeufCoeur");
						}
						else if (j == 10) {
							jeutext.add(DixCoeur);
							jeunoms.add("DixCoeur");
						}
						else if (j == 11) {
							jeutext.add(ValetCoeur);
							jeunoms.add("ValetCoeur");
						}
						else if (j == 12) {
							jeutext.add(DameCoeur);
							jeunoms.add("DameCoeur");}
						else if (j == 13) {
							jeutext.add(RoiCoeur);
							jeunoms.add("RoiCoeur");
						
					}
						
				}
					else if (i>=6 && i<12) {
						if (j == 1) {
							jeutext.add(AsTrefle);
							jeunoms.add("AsTrefle");
						}
						else if (j == 2) {
							jeutext.add(DeuxTrefle);
							jeunoms.add("DeuxTrefle");
						}
						else if (j == 3) {
							jeutext.add(TroisTrefle);
							jeunoms.add("TroisTrefle");
						}
						else if (j == 4) {
							jeutext.add(QuatreTrefle);
							jeunoms.add("QuatreTrefle");
						}
						else if (j == 5) {
							jeutext.add(CinqTrefle);
							jeunoms.add("CinqTrefle");
						}
						else if (j == 6) {
							jeutext.add(SixTrefle);
							jeunoms.add("SixTrefle");
						}
						else if (j == 7) {
							jeutext.add(SeptTrefle);
							jeunoms.add("SeptTrefle");
						}
						else if (j == 8) {
							jeutext.add(HuitTrefle);
							jeunoms.add("HuitTrefle");
						}
						else if (j == 9) {
							jeutext.add(NeufTrefle);
							jeunoms.add("NeufTrefle");
						}
						else if (j == 10) {
							jeutext.add(DixTrefle);
							jeunoms.add("DixTrefle");
						}
						else if (j == 11) {
							jeutext.add(ValetTrefle);
							jeunoms.add("ValetTrefle");
						}
						else if (j == 12) {
							jeutext.add(DameTrefle);
							jeunoms.add("DameTrefle");
						}
						else if (j == 13) {
							jeutext.add(RoiTrefle);
							jeunoms.add("RoiTrefle");
						
					
					}
					}
						else if (i>=12 && i<18) {
							if (j == 1) {
								jeutext.add(AsCarreau);
								jeunoms.add("AsCarreau");
							}
							else if (j == 2) {
								jeutext.add(DeuxCarreau);
								jeunoms.add("DeuxCarreau");
							}
							else if (j == 3) {
								jeutext.add(TroisCarreau);
								jeunoms.add("TroisCarreau");
							}
							else if (j == 4) {
								jeutext.add(QuatreCarreau);
								jeunoms.add("QuatreCarreau");
							}
							else if (j == 5) {
								jeutext.add(CinqCarreau);
								jeunoms.add("CinqCarreau");
							}
							else if (j == 6) {
								jeutext.add(SixCarreau);
								jeunoms.add("SixCarreau");
							}
							else if (j == 7) {
								jeutext.add(SeptCarreau);
								jeunoms.add("SeptCarreau");
							}
							else if (j == 8) {
								jeutext.add(HuitCarreau);
								jeunoms.add("HuitCarreau");
							}
							else if (j == 9) {
								jeutext.add(NeufCarreau);
								jeunoms.add("NeufCarreau");
							}
							else if (j == 10) {
								jeutext.add(DixCarreau);
								jeunoms.add("DixCarreau");
							}
							else if (j == 11) {
								jeutext.add(ValetCarreau);
								jeunoms.add("ValetCarreau");
							}
							else if (j == 12) {
								jeutext.add(DameCarreau);
								jeunoms.add("DameCarreau");
							}
							else if (j == 13) {
								jeutext.add(RoiCarreau);
								jeunoms.add("RoiCarreau");
							
					}
						
				}
						else if (i>=18 && i<24) {
							if (j == 1) {
								jeutext.add(AsPique);
								jeunoms.add("AsPique");
							}
							else if (j == 2) {
								jeutext.add(DeuxPique);
								jeunoms.add("DeuxPique");
							}
							else if (j == 3) {
								jeutext.add(TroisPique);
								jeunoms.add("TroisPique");
							}
							else if (j == 4) {
								jeutext.add(QuatrePique);
								jeunoms.add("QuatrePique");
							}
							else if (j == 5) {
								jeutext.add(CinqPique);
								jeunoms.add("CinqPique");
							}
							else if (j == 6) {
								jeutext.add(SixPique);
								jeunoms.add("SixPique");
							}
							else if (j == 7) {
								jeutext.add(SeptPique);
								jeunoms.add("SeptPique");
							}
							else if (j == 8) {
								jeutext.add(HuitPique);
								jeunoms.add("(HuitPique");
							}
							else if (j == 9) {
								jeutext.add(NeufPique);
								jeunoms.add("NeufPique");
							}
							else if (j == 10) {
								jeutext.add(DixPique);
								jeunoms.add("DixPique");
							}
							else if (j == 11) {
								jeutext.add(ValetPique);
								jeunoms.add("ValetPique");
							}
							else if (j == 12) {
								jeutext.add(DamePique);
								jeunoms.add("DamePique");
							}
							else if (j == 13) {
								jeutext.add(RoiPique);		
								jeunoms.add("RoiPique");
			}
		}
			}
			
	}
}
		public void toNb() {
			for (int i =0;i<312;i++) {
				if (jeutext.get(i) == AsPique || jeutext.get(i) == AsCoeur || jeutext.get(i) == AsTrefle || jeutext.get(i) == AsCarreau) {
					jeu.add(1);
				}
				else if (jeutext.get(i) == DeuxPique || jeutext.get(i) == DeuxCoeur || jeutext.get(i) == DeuxTrefle || jeutext.get(i) == DeuxCarreau) {
					jeu.add(2);
				}
				else if (jeutext.get(i) == TroisPique || jeutext.get(i) == TroisCoeur || jeutext.get(i) == TroisTrefle || jeutext.get(i) == TroisCarreau) {
					jeu.add(3);
				}
				else if (jeutext.get(i) == QuatrePique || jeutext.get(i) == QuatreCoeur || jeutext.get(i) == QuatreTrefle || jeutext.get(i) == QuatreCarreau) {
					jeu.add(4);
				}
				else if (jeutext.get(i) == CinqPique || jeutext.get(i) == CinqCoeur || jeutext.get(i) == CinqTrefle || jeutext.get(i) == CinqCarreau) {
					jeu.add(5);
				}
				else if (jeutext.get(i) == SixPique || jeutext.get(i) == SixCoeur || jeutext.get(i) == SixTrefle || jeutext.get(i) == SixCarreau) {
					jeu.add(6);
				}
				else if (jeutext.get(i) == SeptPique || jeutext.get(i) == SeptCoeur || jeutext.get(i) == SeptTrefle || jeutext.get(i) == SeptCarreau) {
					jeu.add(7);
				}
				else if (jeutext.get(i) == HuitPique || jeutext.get(i) == HuitCoeur || jeutext.get(i) == HuitTrefle || jeutext.get(i) == HuitCarreau) {
					jeu.add(8);
				}
				else if (jeutext.get(i) == NeufPique || jeutext.get(i) == NeufCoeur || jeutext.get(i) == NeufTrefle || jeutext.get(i) == NeufCarreau) {
					jeu.add(9);
				}
				else if (jeutext.get(i) == DixPique || jeutext.get(i) == DixCoeur || jeutext.get(i) == DixTrefle || jeutext.get(i) == DixCarreau) {
					jeu.add(10);
				}
				else if (jeutext.get(i) == ValetPique || jeutext.get(i) == ValetCoeur || jeutext.get(i) == ValetTrefle || jeutext.get(i) == ValetCarreau) {
					jeu.add(10);
				}
				else if (jeutext.get(i) == DamePique || jeutext.get(i) == DameCoeur || jeutext.get(i) == DameTrefle || jeutext.get(i) == DameCarreau) {
					jeu.add(10);
				}
				else if (jeutext.get(i) == RoiPique || jeutext.get(i) == RoiCoeur || jeutext.get(i) == RoiTrefle || jeutext.get(i) == RoiCarreau) {
					jeu.add(10);
				}
				
			}
			for (int i =0;i<312;i++) {
				
				if (jeutext.get(i) == AsPique ) {
					jeunoms.add("Aspique");
				}
				else if ( jeutext.get(i) == AsCoeur) {
					jeunoms.add("AsCoeur");
				}
				else if (jeutext.get(i) == AsTrefle) {
					jeunoms.add("AsTrefle");
				}
				else if ( jeutext.get(i) == AsCarreau) {
					jeunoms.add("AsCarreau");
				}
				else if (jeutext.get(i) == DeuxPique) {
					jeunoms.add("DeuxPique");
				}
				
				else if ( jeutext.get(i) == DeuxCoeur) {
					jeunoms.add(" DeuxCoeur");
				}
				else if (jeutext.get(i) == DeuxTrefle) {
					jeunoms.add("DeuxTrefle");
				}
				else if (jeutext.get(i) == DeuxCarreau) {
					jeunoms.add("DeuxCarreau");
				}
				
				else if (jeutext.get(i) == DeuxPique) {
					jeunoms.add("DeuxPique");
				}
				
				else if ( jeutext.get(i) == TroisCoeur) {
					jeunoms.add("TroisCoeur");
				}
				else if (jeutext.get(i) == TroisTrefle) {
					jeunoms.add("TroisTrefle");
				}
				else if (jeutext.get(i) == TroisCarreau) {
					jeunoms.add("TroisCarreau");
				}
				else if (jeutext.get(i) == QuatrePique) {
					jeunoms.add("QuatrePique");
				}
				else if (jeutext.get(i) == QuatreCoeur) {
					jeunoms.add("QuatreCoeur");
				}
				else if (jeutext.get(i) == QuatreTrefle) {
					jeunoms.add(" QuatreTrefle");
				}
				else if (jeutext.get(i) == QuatreCarreau) {
					jeunoms.add("QuatreCarreau");
				}
				else if (jeutext.get(i) == CinqPique) {
					jeunoms.add("CinqPique");
				}
				else if ( jeutext.get(i) == CinqCoeur) {
					jeunoms.add("CinqCoeur");
				}
				else if (jeutext.get(i) == CinqTrefle) {
					jeunoms.add(" CinqTrefle");
				}
				else if ( jeutext.get(i) == CinqCarreau) {
					jeunoms.add("CinqCarreau");
				}
				
				else if (jeutext.get(i) == SixPique) {
					jeunoms.add("SixPique");
				}
				else if ( jeutext.get(i) == SixCoeur) {
					jeunoms.add("SixCoeur");
				}
				else if (jeutext.get(i) == SixTrefle) {
					jeunoms.add("SixTrefle");
				}
				else if (jeutext.get(i) == SixCarreau) {
					jeunoms.add("SixCarreau");
				}
				else if (jeutext.get(i) == SeptPique) {
					jeunoms.add("SeptPique");
				}
				else if (jeutext.get(i) == SeptCoeur) {
					jeunoms.add("SeptCoeur");
				}
				else if (jeutext.get(i) == SeptTrefle) {
					jeunoms.add("SeptTrefle");
				}
				else if ( jeutext.get(i) == SeptCarreau) {
					jeunoms.add("SeptCarreau");
				}
				else if (jeutext.get(i) == HuitPique) {
					jeunoms.add(" HuitPique");
				}
				else if ( jeutext.get(i) == HuitCoeur) {
					jeunoms.add("HuitCoeur");
				}
				else if (jeutext.get(i) == HuitTrefle) {
					jeunoms.add("HuitTrefle");
				}
				else if ( jeutext.get(i) == HuitCarreau) {
					jeunoms.add("HuitCarreau");
				}
				else if (jeutext.get(i) == NeufPique) {
					jeunoms.add("NeufPique");
				}
				else if (jeutext.get(i) == NeufCoeur) {
					jeunoms.add("NeufCoeur");
				}
				else if ( jeutext.get(i) == NeufTrefle) {
					jeunoms.add("NeufTrefle");
				}
				else if (jeutext.get(i) == NeufCarreau) {
					jeunoms.add("NeufCarreau");
				}
				else if (jeutext.get(i) == DixPique) {
					jeunoms.add("DixPique");
				}
				else if ( jeutext.get(i) == DixTrefle) {
					jeunoms.add("DixTrefle");
				}
				else if (jeutext.get(i) == DixCarreau) {
					jeunoms.add("DixCarreau");
				}
				else if ( jeutext.get(i) == ValetPique) {
					jeunoms.add("ValetPique");
				}
				else if (jeutext.get(i) == ValetCoeur) {
					jeunoms.add("ValetCoeur");
				}
				else if (  jeutext.get(i) == ValetTrefle) {
					jeunoms.add("ValetTrefle");
				}
				else if (jeutext.get(i) == ValetCarreau) {
					jeunoms.add("ValetCarreau");
				}
				else if ( jeutext.get(i) == DamePique) {
					jeunoms.add("DamePique");
				}
				else if (jeutext.get(i) == DameCoeur) {
					jeunoms.add("DameCoeur");
				}
				else if ( jeutext.get(i) == DameTrefle) {
					jeunoms.add("DameTrefle");
				}
				else if ( jeutext.get(i) == DameCarreau) {
					jeunoms.add("DameCarreau");
				}
				else if (jeutext.get(i) == RoiPique) {
					jeunoms.add("RoiPique");
				}
				else if (jeutext.get(i) == RoiCoeur) {
					jeunoms.add("RoiCoeur");
				}
				else if ( jeutext.get(i) == RoiTrefle) {
					jeunoms.add("RoiTrefle");
				}
				else if (jeutext.get(i) == RoiCarreau) {
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
		public ArrayList<Texture> getPaquetText(){
			return jeutext;
		}
		public ArrayList<String> getPaquetNom(){
			return jeunoms;
		}
}	
