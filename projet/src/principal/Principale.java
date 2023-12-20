package principal;
import univers.*;

import java.util.ArrayList;
import java.util.Scanner;

import Representation.*;

public class Principale {

	public static ArrayList<Personnages> choix_perso() {

		System.out.println("==============================================================\n");
		
		System.out.println("\u001B[32m"+"			==================================\n"
				+ "		Procedons au Choix des personnages \n"
				+ "		==================================\n"+"\u001B[0m");
		
/*			
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
*/
		
		Scanner scan = new Scanner(System.in);
		String input = "";
		int valeur = 0;
		
		ArrayList<Personnages> tab_aide_perso = new ArrayList<>();
		String [] tab_aide_string = {
									"",
									"1 => Patrick, le père sage,\n",
									"2 => Stéphanie : la mère protectrice,\n",
									"3 => Sarah : l'esprit vif,\n",
									"4 => Mathéo : le frère courageux,\n",
									"5 => Paul : le médecin,\n",
									"6 => Amine, l'athlète,\n",
									"7 => Yacine, le cousin rusé,\n",
									"8 => Guilianetta, la cuisinière ingénieuse"
									};
		
		int [] tab_aide_choix = {0,0,0,0,0,0,0,0,0};
		String affichage = "";
		for(int i = 1;i<=4;i++){
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
					
			affichage = "";
			for(int j = 1;j<=8;j++) {
				if(tab_aide_choix[j] == 0) {
					affichage = affichage + tab_aide_string[j];
				}
			}
			
		
			
			System.out.println("Choix du personnage numero "+i+" :");
			System.out.println(affichage);
			System.out.print("\u001B[32m"+"Saisie le nombre correspondant au personnage que tu selectionnes : "+"\u001B[0m");

			while (true) {

				input = scan.nextLine();
				try {
					valeur = Integer.parseInt(input);
					if (!(valeur <= 8 && valeur >= 1 && tab_aide_choix[valeur] == 0)) {
						System.out.print("\u001B[31m"+"Personnage deja choisi ou inexistant ! Ressaisir : " + "\u001B[0m");
						continue;
					}
					break;
				} catch (Exception e) {
					System.out.print("\u001B[31m"+"Valeur incorect !!! Ressaisir : "+ "\u001B[0m");
				}
			}

			tab_aide_choix[valeur] = 1;
			switch (valeur) {
				case 1:
					tab_aide_perso.add(new Personnages(Personnages_du_jeu.Pere));
					break;
				case 2:
					tab_aide_perso.add(new Personnages(Personnages_du_jeu.Mere));
					break;
				case 3:
					tab_aide_perso.add(new Personnages(Personnages_du_jeu.Soeur));
					break;
				case 4:
					tab_aide_perso.add(new Personnages(Personnages_du_jeu.Frere));
					break;
				case 5:
					tab_aide_perso.add(new Personnages(Personnages_du_jeu.Medecin));
					break;
				case 6:
					tab_aide_perso.add(new Personnages(Personnages_du_jeu.Athlete));
					break;
				case 7:
					tab_aide_perso.add(new Personnages(Personnages_du_jeu.Cousin));
					break;

				case 8:
					tab_aide_perso.add(new Personnages(Personnages_du_jeu.Cuisiniere));
					break;
			}
			
			System.out.println();

		}
		
		System.out.println("==============================================================\n\n");
		return tab_aide_perso;
	}

	public static void lancement_du_jeu() {

		
		System.out.println("\u001B[31m"+"			==================================\n"
				+ " 	        |	     SURVIVOR	         |\n"
				+ "		==================================\n"+"\u001B[0m");
		
/*
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
		}
*/
		
		// Message du debut
		System.out.println(
				"En plein repas de famille, le monde sombra dans le chaos.\nLa 3ème guerre mondiale éclata, ne laissant qu'un refuge:\nLe bunker, avec seulement 4 places.\n\n		=========Qui choisi tu ?========= \n		Patrick : le père sage,\n		Stéphanie : la mère protectrice,\n		Sarah : la soeur a l'esprit vif,\n		Mathéo : le frère courageux,\n		Paul : le médecin,\n		Amine : l'athlète,\n		Yacine : le cousin rusé,\n		ou Guilianetta : la cuisinière ingénieuse.\n\nQuatres personnes de ton choix vont affronter l'impensable.\nDans cette lutte pour la survie, chaque choix peseront lourd,\nchaque pas les rapprocheront du salut ou de la perte !");

/*
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			
		}
*/

		// Choix des personnages
		ArrayList <Personnages> tab_aide_perso = choix_perso();

		// Objet de depart : Objet present deja dans la cave.
		Objet objet_cave = new Objet();
		objet_cave.setQuantite("Carte a jouer", 1);

		// Nourriture de depart : Nourriture deja dans la cave.
		Nourriture nourriture_cave = new Nourriture();
		nourriture_cave.setQuantite("Pate", 5);
		nourriture_cave.setQuantite("Eau", 5);
		listescenario listescene = new listescenario();
		ArrayList<DecisionNode> lalala = listescene.getListe();
		// Instance de Jour
		ListeChancenode listeChancenode = new ListeChancenode();
		ArrayList<ChanceNode> chanceNodes = listeChancenode.getListe();
		Jour j = new Jour(tab_aide_perso.get(0),tab_aide_perso.get(1),tab_aide_perso.get(2),tab_aide_perso.get(3),objet_cave,
				nourriture_cave, lalala, chanceNodes);

		while (true) {
			j.deroulement_du_jour();
		}


	}
	

	
	
	public static void main(String[] args) {
		lancement_du_jeu();
	}
	
	
}
