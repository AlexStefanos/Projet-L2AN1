package fr.mygdx.game;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Integer> jeu;
	private ArrayList<String> jeunoms;
		
		public Deck() {
			jeu = new ArrayList<Integer>(312);
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
		    System.out.println(jeunoms.get(i)+ " ");
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
							jeunoms.add("AsCoeur");
						}
						else if (j == 2) {
							jeunoms.add("DeuxCoeur");
						}
						else if (j == 3) {
							jeunoms.add("TroisCoeur");
						}
						else if (j == 4) {
							jeunoms.add("QuatreCoeur");
						}
						else if (j == 5) {
							jeunoms.add("CinqCoeur");
						}
						else if (j == 6) {
							jeunoms.add("SixCoeur");
						}
						else if (j == 7) {
							jeunoms.add("SeptCoeur");
						}
						else if (j == 8) {
							jeunoms.add("HuitCoeur");
						}
						else if (j == 9) {
							jeunoms.add("NeufCoeur");
						}
						else if (j == 10) {
							jeunoms.add("DixCoeur");
						}
						else if (j == 11) {
							jeunoms.add("ValetCoeur");
						}
						else if (j == 12) {
							jeunoms.add("DameCoeur");
						}
						else if (j == 13) {
							jeunoms.add("RoiCoeur");
						
					}
						
				}
					else if (i>=6 && i<12) {
						if (j == 1) {
							jeunoms.add("AsTrefle");
						}
						else if (j == 2) {
							jeunoms.add("DeuxTrefle");
						}
						else if (j == 3) {
							jeunoms.add("TroisTrefle");
						}
						else if (j == 4) {
							jeunoms.add("QuatreTrefle");
						}
						else if (j == 5) {
							jeunoms.add("CinqTrefle");
						}
						else if (j == 6) {
							jeunoms.add("SixTrefle");
						}
						else if (j == 7) {
							jeunoms.add("SeptTrefle");
						}
						else if (j == 8) {
							jeunoms.add("HuitTrefle");
						}
						else if (j == 9) {
							jeunoms.add("NeufTrefle");
						}
						else if (j == 10) {
							jeunoms.add("DixTrefle");
						}
						else if (j == 11) {
							jeunoms.add("ValetTrefle");
						}
						else if (j == 12) {
							jeunoms.add("DameTrefle");
						}
						else if (j == 13) {
							jeunoms.add("RoiTrefle");
						
					
					}
					}
						else if (i>=12 && i<18) {
							if (j == 1) {
								jeunoms.add("AsCarreau");
							}
							else if (j == 2) {
								jeunoms.add("DeuxCarreau");
							}
							else if (j == 3) {
								jeunoms.add("TroisCarreau");
							}
							else if (j == 4) {
								jeunoms.add("QuatreCarreau");
							}
							else if (j == 5) {
								jeunoms.add("CinqCarreau");
							}
							else if (j == 6) {
								jeunoms.add("SixCarreau");
							}
							else if (j == 7) {
								jeunoms.add("SeptCarreau");
							}
							else if (j == 8) {
								jeunoms.add("HuitCarreau");
							}
							else if (j == 9) {
								jeunoms.add("NeufCarreau");
							}
							else if (j == 10) {
								jeunoms.add("DixCarreau");
							}
							else if (j == 11) {
								jeunoms.add("ValetCarreau");
							}
							else if (j == 12) {
								jeunoms.add("DameCarreau");
							}
							else if (j == 13) {
								jeunoms.add("RoiCarreau");
							
					}
						
				}
						else if (i>=18 && i<24) {
							if (j == 1) {
								jeunoms.add("AsPique");
							}
							else if (j == 2) {
								jeunoms.add("DeuxPique");
							}
							else if (j == 3) {
								jeunoms.add("TroisPique");
							}
							else if (j == 4) {
								jeunoms.add("QuatrePique");
							}
							else if (j == 5) {
								jeunoms.add("CinqPique");
							}
							else if (j == 6) {
								jeunoms.add("SixPique");
							}
							else if (j == 7) {
								jeunoms.add("SeptPique");
							}
							else if (j == 8) {
								jeunoms.add("HuitPique");
							}
							else if (j == 9) {
								jeunoms.add("NeufPique");
							}
							else if (j == 10) {
								jeunoms.add("DixPique");
							}
							else if (j == 11) {
								jeunoms.add("ValetPique");
							}
							else if (j == 12) {
								jeunoms.add("DamePique");
							}
							else if (j == 13) {
								jeunoms.add("RoiPique");		
			}
		}
			}
			
	}
}
		public void toNb() {
			for (int i =0;i<312;i++) {
				if (jeunoms.get(i) == "AsPique" || jeunoms.get(i) == "AsCoeur" || jeunoms.get(i) == "AsTrefle" || jeunoms.get(i) == "AsCarreau") {
					jeu.add(1);
				}
				else if (jeunoms.get(i) == "DeuxPique" || jeunoms.get(i) == "DeuxCoeur" || jeunoms.get(i) == "DeuxTrefle" || jeunoms.get(i) == "DeuxCarreau") {
					jeu.add(2);
				}
				else if (jeunoms.get(i) == "TroisPique" || jeunoms.get(i) == "TroisCoeur" || jeunoms.get(i) == "TroisTrefle" || jeunoms.get(i) == "TroisCarreau") {
					jeu.add(3);
				}
				else if (jeunoms.get(i) == "QuatrePique" || jeunoms.get(i) == "QuatreCoeur" || jeunoms.get(i) == "QuatreTrefle" || jeunoms.get(i) == "QuatreCarreau") {
					jeu.add(4);
				}
				else if (jeunoms.get(i) == "CinqPique" || jeunoms.get(i) == "CinqCoeur" || jeunoms.get(i) == "CinqTrefle" || jeunoms.get(i) == "CinqCarreau") {
					jeu.add(5);
				}
				else if (jeunoms.get(i) == "SixPique" || jeunoms.get(i) == "SixCoeur" || jeunoms.get(i) == "SixTrefle" || jeunoms.get(i) == "SixCarreau") {
					jeu.add(6);
				}
				else if (jeunoms.get(i) == "SeptPique" || jeunoms.get(i) == "SeptCoeur" || jeunoms.get(i) == "SeptTrefle" || jeunoms.get(i) == "SeptCarreau") {
					jeu.add(7);
				}
				else if (jeunoms.get(i) == "HuitPique" || jeunoms.get(i) == "HuitCoeur" || jeunoms.get(i) == "HuitTrefle" || jeunoms.get(i) == "HuitCarreau") {
					jeu.add(8);
				}
				else if (jeunoms.get(i) == "NeufPique" || jeunoms.get(i) == "NeufCoeur" || jeunoms.get(i) == "NeufTrefle" || jeunoms.get(i) == "NeufCarreau") {
					jeu.add(9);
				}
				else if (jeunoms.get(i) == "DixPique" || jeunoms.get(i) == "DixCoeur" || jeunoms.get(i) == "DixTrefle" || jeunoms.get(i) == "DixCarreau") {
					jeu.add(10);
				}
				else if (jeunoms.get(i) == "ValetPique" || jeunoms.get(i) == "ValetCoeur" || jeunoms.get(i) == "ValetTrefle" || jeunoms.get(i) == "ValetCarreau") {
					jeu.add(10);
				}
				else if (jeunoms.get(i) == "DamePique" || jeunoms.get(i) == "DameCoeur" || jeunoms.get(i) == "DameTrefle" || jeunoms.get(i) == "DameCarreau") {
					jeu.add(10);
				}
				else if (jeunoms.get(i) == "RoiPique" || jeunoms.get(i) == "RoiCoeur" || jeunoms.get(i) == "RoiTrefle" || jeunoms.get(i) == "RoiCarreau") {
					jeu.add(10);
				}
				
			}
		}
		
		/*public void creation() {
			for (int i = 0; i<312;i++) {
				
				if (jeu.get(i) == 1) {
					jeunoms.add("As");
				}
				else if (jeu.get(i) == 2) {
					jeunoms.add("Deux");
				}
				else if (jeu.get(i) == 3) {
					jeunoms.add("Trois");
				}
				else if (jeu.get(i) == 4) {
					jeunoms.add("Quatre");
				}
				else if (jeu.get(i) == 5) {
					jeunoms.add("Cinq");
				}
				else if (jeu.get(i) == 6) {
					jeunoms.add("Six");
				}
				else if (jeu.get(i) == 7) {
					jeunoms.add("Sept");
				}
				else if (jeu.get(i) == 8) {
					jeunoms.add("Huit");
				}
				else if (jeu.get(i) == 9) {
					jeunoms.add("Neuf");
				}
				else if (jeu.get(i) == 10) {
					jeunoms.add("Dix");
				}
				else if (jeu.get(i) == 11) {
					jeunoms.add("Valet");
				}
				else if (jeu.get(i) == 12) {
					jeunoms.add("Dame");
				}
				else if (jeu.get(i) == 13) {
					jeunoms.add("Roi");
				}
			} 
			
			
			
		}*/
		
		
		
		public void shuffle() {
			Collections.shuffle(jeunoms);
			
		}
		public ArrayList<Integer> getPaquet() {
			return jeu;
		}
		public ArrayList<String> getPaquetNom(){
			return jeunoms;
		}
}	
