package principal;

import univers.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import Representation.*;


/**
Classe, permettant de lancer une partie. C'est la qu'on a les info du jeu : tout est conserve dans l'attribut jeu.

@author ABDELOUHAB Yacine
*/
public class Principale implements Serializable{
	

	private final int id;
	private Jour jeu = null;
	private static int nbr_game = 0;
	private boolean deja_lance = false;

	
	/**
	 * Constructeur
	*/
	Principale(){
		nbr_game ++;
		this.id = nbr_game;
	}
	
	
	/**
	 * Guetters pour recup l'id de la game
	 * @return id de la game
	*/
	public int principale_get_id(){
		return this.id;
	}
	
	
	/**
	 * Cette methode permet au debut du jeu la selection
	 * des personnages.
	 * @return un tableau des quatres personnages choisis
	*/

	private static ArrayList<Personnages> choix_perso() {

		System.out.println("==============================================================\n");

		System.out.println("\u001B[32m" + "			==================================\n"
				+ "		Procedons au Choix des personnages \n"
				+ "		==================================\n" + "\u001B[0m");

		/*
		 * try {
		 * Thread.sleep(2000);
		 * } catch (InterruptedException e) {
		 * 
		 * }
		 */

		Scanner scan = new Scanner(System.in);
		String input = "";
		int valeur = 0;

		ArrayList<Personnages> tab_aide_perso = new ArrayList<>();
		String[] tab_aide_string = {
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

		int[] tab_aide_choix = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		String affichage = "";
		for (int i = 1; i <= 4; i++) {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}

			affichage = "";
			for (int j = 1; j <= 8; j++) {
				if (tab_aide_choix[j] == 0) {
					affichage = affichage + tab_aide_string[j];
				}
			}

			System.out.println("Choix du personnage numero " + i + " :");
			System.out.println(affichage);
			System.out.print(
					"\u001B[32m" + "Saisie le nombre correspondant au personnage que tu selectionnes : " + "\u001B[0m");

			while (true) {

				input = scan.nextLine();
				try {
					valeur = Integer.parseInt(input);
					if (!(valeur <= 8 && valeur >= 1 && tab_aide_choix[valeur] == 0)) {
						System.out.print(
								"\u001B[31m" + "Personnage deja choisi ou inexistant ! Ressaisir : " + "\u001B[0m");
						continue;
					}
					break;
				} catch (Exception e) {
					System.out.print("\u001B[31m" + "Valeur incorect !!! Ressaisir : " + "\u001B[0m");
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

	
	/**
	 * Lance la partie et modifie l'attribut jeu tout le long.
	 * Deux parties dans cette methode:
	 * La premiere va gerer le debut de la game, le choix des personnages
	 * et l'instanciation de l'attribut jeu. On y passera que une seul fois. (grace a l'attribut deja lancee)
	 * La seconde contient, le deroulement de chaque jour, et chaque jour qui passe, demande si on veut 
	 * continuer a jouer ou pas.
	 * 
	 * @return 0 si c'est la fin du jeu => on a donc pas besoin de sauvegarder, 1 si on veut continuer plus tard
	*/
	public int lancement_du_jeu() {
		// Retourne zero : fin jeu
		// Retourne un : on veut sauvegarder la partie

		if (!this.deja_lance) {
			this.deja_lance = true;

			// On initialise une instance de Jour

			System.out.println("\u001B[31m" + "			==================================\n"
					+ " 	        |	     SURVIVOR	         |\n"
					+ "		==================================\n" + "\u001B[0m");

			/*
			 * try {
			 * Thread.sleep(5000);
			 * } catch (InterruptedException e) {
			 * 
			 * }
			 */

			// Message du debut
			System.out.println(
					"En plein repas de famille, le monde sombra dans le chaos.\nLa 3ème guerre mondiale éclata, ne laissant qu'un refuge:\nLe bunker, avec seulement 4 places.\n\n		=========Qui choisi tu ?========= \n		Patrick : le père sage,\n		Stéphanie : la mère protectrice,\n		Sarah : la soeur a l'esprit vif,\n		Mathéo : le frère courageux,\n		Paul : le médecin,\n		Amine : l'athlète,\n		Yacine : le cousin rusé,\n		ou Guilianetta : la cuisinière ingénieuse.\n\nQuatres personnes de ton choix vont affronter l'impensable.\nDans cette lutte pour la survie, chaque choix peseront lourd,\nchaque pas les rapprocheront du salut ou de la perte !");

			/*
			 * try {
			 * Thread.sleep(30000);
			 * } catch (InterruptedException e) {
			 * 
			 * }
			 */

			// Choix des personnages
			ArrayList<Personnages> tab_aide_perso = choix_perso();

			// Objet de depart : Objet present deja dans la cave.
			Objet objet_cave = new Objet();
			objet_cave.setQuantite("Trousse", 1);
			objet_cave.setQuantite("Echec", 1);
			objet_cave.setQuantite("Fusil", 1);
			objet_cave.setQuantite("Radio", 1);

			// Nourriture de depart : Nourriture deja dans la cave.
			Nourriture nourriture_cave = new Nourriture();
			nourriture_cave.setQuantite("Pate", 5);
			nourriture_cave.setQuantite("Eau", 5);
			listescenario listescene = new listescenario();
			ArrayList<DecisionNode> lalala = listescene.getListe();
			// Instance de Jour
			ListeChancenode listeChancenode = new ListeChancenode();
			ArrayList<ChanceNode> chanceNodes = listeChancenode.getListe();
			Jour j = new Jour(tab_aide_perso.get(0), tab_aide_perso.get(1), tab_aide_perso.get(2),
					tab_aide_perso.get(3),
					objet_cave,
					nourriture_cave, lalala, chanceNodes);
			this.jeu = j;

		}

		
		
		//Au bout du jour 15 on a survecu !!
		int jeu_info = 1;
		boolean jeu_gagne = false;
		
		while (jeu_info == 1) {
			
			

			System.out.println("Jours :" + this.jeu.get_nombre_journee());

			if (this.jeu.get_nombre_journee() > 15) {
				jeu_gagne = true;
				break;
			}

			jeu_info = this.jeu.deroulement_du_jour();
			
			if(jeu_info == 2) {
				jeu_gagne = true;
				break;
			}
			

			System.out.println("Fin de la journee");
			//Veut tu continuer a jouer au sauvegarder ?
		
			System.out.println("Continuez la journee suivante ? ");

			String input = "";
			Scanner scan = new Scanner(System.in);

			while (true) {
				System.out.print("\u001B[32m" + "o pour continuer / n pour sauvegarder : " + "\u001B[0m");
				try {
					input = scan.nextLine();
					if (!(input.equals("o") || input.equals("n"))) {
						throw new IllegalArgumentException(
								"\u001B[31m" + "Inserer o pour continuer ou n pour sauvegarder !!!" + "\u001B[0m");
					}
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
					continue;
				} catch (Exception e) {
					System.out.println("\u001B[34m" + "Erreur dans la saisie !" + "\u001B[0m");
					continue;
				}
				break;
			}

			// Si continuer, on fait rien
			// Si veut pas, on fait retourner 1 et on gere la sauvegarde dans Game
			if (input.equals("n")) {
				return 1;
			}

		}

		
		if(!jeu_gagne) {
			System.out.println("Perduuuuu!");
		}
		else{
			System.out.println("Gagné !!!");

		}

		return 0;
	}

}
