package principal;
import univers.*;

import java.util.Scanner;
import principal.*;

public class Principale{
	
	public static Personnages [] choix_perso() {
		
		Scanner scan = new Scanner(System.in);
		String input = "";
		int valeur = 0;
		
		Personnages [] tab_aide_perso = {null,null,null,null,null,null,null,null,null};
		String [] tab_aide_string = {
									"",
									"1 => Patrick, le père sage,\n",
									"2 => Stéphanie : la mère protectrice,\n",
									"3 => Sarah : l'esprit vif,\n",
									"4 => Mathéo : le frère courageux,\n",
									"5 => Paul : le médecin,\n",
									"6 => Amine, l'athlète,\n",
									"7 => Yacine, le cousin rusé,\n",
									"8 => Guilianetta, la cuisinière ingénieuse\n"
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
			System.out.println("==========================================================================================================================================\n");
			System.out.println("Choix du personnage numero "+i+" :");
			System.out.println(affichage);
			System.out.print("Saisie le nombre correspondant au personnage que tu selectionnes : ");
				
				
			while(true) {
				input = scan.nextLine();
				try {
					valeur = Integer.parseInt(input);
					if(!(valeur<= 8 && valeur>= 1 && tab_aide_choix[valeur] == 0 )) {
						System.out.print("Personnage deja choisi ou inexistant ! Ressaisir : ");
						continue;
					}
					break;
				}
				catch(Exception e) {
						System.out.print("Valeur incorect !!! Ressaisir : ");
				}		
			}
				
							
			tab_aide_choix[valeur] = 1;
			switch(valeur) {
				case 1 :
					tab_aide_perso[valeur] = new Personnages(Personnages_du_jeu.Pere) ;						break;
				case 2 :
					tab_aide_perso[valeur] = new Personnages(Personnages_du_jeu.Mere) ;
					break;
				case 3 :
					tab_aide_perso[valeur] = new Personnages(Personnages_du_jeu.Soeur) ;						break;
				case 4 :
					tab_aide_perso[valeur] = new Personnages(Personnages_du_jeu.Frere) ;
					break;
				case 5 :
					tab_aide_perso[valeur] = new Personnages(Personnages_du_jeu.Medecin) ;
					break;
				case 6 :
					tab_aide_perso[valeur] = new Personnages(Personnages_du_jeu.Athlete) ;
					break;
				case 7 :
					tab_aide_perso[valeur] = new Personnages(Personnages_du_jeu.Cousin) ;
					break;
				case 8 :
					tab_aide_perso[valeur] = new Personnages(Personnages_du_jeu.Cuisiniere) ;
					break;
				}	
		}
		scan.close();
		return tab_aide_perso;
	}
	
	public static void lancement_du_jeu(){
		System.out.println("En plein repas de famille, le monde sombra dans le chaos.\nLa 3ème guerre mondiale éclata, ne laissant qu'un refuge:\nLe bunker, avec seulement 4 places.\n\n =========Qui choisi tu ?========= \nPatrick : le père sage,\nStéphanie : la mère protectrice,\nSarah : l'esprit vif,\nMathéo : le frère courageux,\nPaul : le médecin,\nAmine : l'athlète,\nYacine : le cousin rusé,\nou Guilianetta : la cuisinière ingénieuse.\n\nQuatres personnes de ton choix vont affronter l'impensable.\nDans cette lutte pour la survie, chaque choix peseront lourd, chaque pas les rapprocheront du salut ou de la perte !");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
		}
		Personnages [] tab_aide_perso = choix_perso();
		
		
	}
	

	public static void main(String[] args) {
		lancement_du_jeu();
	}
	
	
}
