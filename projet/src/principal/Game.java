package principal;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


/**
Classe, permettant de gerer le menu du jeu, ainsi que la sauvegarde des differentes parties.
C'est cette classe qu'on va chercher a serialise.
@author ABDELOUHAB Yacine
*/
public class Game implements Serializable {
	
	private ArrayList<Principale> tab_jeu_en_cours = new ArrayList<>();
	private ArrayList<String> tab_nom_parti_en_cours = new ArrayList<>();
	private int indice_jeu_en_cours = -1;
	
	/**Permet d'afficher les parties sauvegarder
	 * */
	private void get_jeu_en_cours() {
		String output = "0 ------> Nouvelle Game\n";
		for(int i = 1;i<=tab_jeu_en_cours.size();i++){
			output = output + i;
			output =output + " ------> " + tab_nom_parti_en_cours.get(i-1) + "\n";
		}
		
		System.out.println("\u001B[32m" + output + "\u001B[0m");
	}

	/**Permet de supprimer une partie terminer
	 * */
	private void fin_partie_en_cours() {
		this.tab_jeu_en_cours.remove(indice_jeu_en_cours);
		this.tab_nom_parti_en_cours.remove(indice_jeu_en_cours);
	}
	
	/**Permet de sauvegarder une certaine parties non termine.
	 * */
	private void enregistrement_des_games(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("svgd_jeu.txt"))) {
            oos.writeObject(this);
        } catch (Exception e) {
        }
	}
	
	/**Permet de recuperer les parties sauvegarder lorsqu'on reprend le jeu.
	 * */
	private void recup_des_games() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("svgd_jeu.txt"))) {
            Game g = (Game) ois.readObject();
            this.tab_jeu_en_cours = g.tab_jeu_en_cours;
            this.tab_nom_parti_en_cours = g.tab_nom_parti_en_cours;         
        } catch (Exception e) {
        	
        }
	}
	
	/**Gere le menu du jeu.
	 * */
	public void lancer_menu() {
		
		this.recup_des_games();
		
		
		int sauvegarde_ou_pas = 0; //0 fin jeu    1 on veut sauvegarder
		Scanner scan = new Scanner(System.in);
		String input = "";
		
		
		while(true) {
			
			
			System.out.println("\u001B[32m" + "============================================================" + "\u001B[0m");
			System.out.println("\u001B[32m" + "===========	Bienvenue dans le menu du jeu	============" + "\u001B[0m");
			System.out.println("\u001B[32m" + "============================================================\n" + "\u001B[0m");
			
		    while (true) {
		        System.out.print("\u001B[32m" + "o pour Jouer / n pour Quitter : " + "\u001B[0m");
	         try {
		            input = scan.nextLine();
		            if (!(input.equals("o") || input.equals("n"))) {
		              throw new IllegalArgumentException("\u001B[31m" + "Inserer o pour continuer ou n pour quitter !!!" + "\u001B[0m");
		            }
		          } 
	         catch (IllegalArgumentException e) {
		            System.out.println(e.getMessage());
		            continue;
		          } 
	         catch (Exception e) {
		            System.out.println("\u001B[34m" + "Erreur dans la saisie !" + "\u001B[0m");
		            continue;
		          }
		          break;
		     }
		    
		    if(input.equals("n")) {
		    	this.enregistrement_des_games();
		    	System.out.println("\u001B[31m" + "Sauvegarde en cours..."+ "\u001B[0m");
		    	return;
		    }
			
			
			
			//On veut jouer : game existante ? Ancienne partie ?
			
			
			if(tab_jeu_en_cours.isEmpty()) {
				System.out.println("\u001B[32m" + "----Pas d'ancienne partie stockee. On lance une nouvelle----" + "\u001B[0m");
				System.out.print("\u001B[32m" + "Donne un nom a cette partie : "+"\u001B[0m");
							
				input = scan.nextLine();
				System.out.println("\u001B[32m" + "============================================================\n" + "\u001B[0m");
				
				
				tab_jeu_en_cours.add(new Principale());
				tab_nom_parti_en_cours.add(input);
				this.indice_jeu_en_cours = tab_jeu_en_cours.size() - 1;
			}
			else {
				//Une ou plusieurs ancienne partie : Choix entre les ancienne parti 
				//on debute une nouvelle partie	
				
				
				

				System.out.println("\u001B[32m" + "----------------------Ancienne Partie-----------------------"+ "\u001B[0m");
				this.get_jeu_en_cours();
				System.out.print("\u001B[32m" + "Entre le nombre correspondant a la parti que tu veux : "+ "\u001B[0m");
				
				
				//On recup la valeur
				int valeur = 0;
				while (true) {

					input = scan.nextLine();
					try {
						valeur = Integer.parseInt(input);
						if (!(valeur <= tab_jeu_en_cours.size() && valeur >= 0)) {
							System.out.print(
									"\u001B[31m" + "Game inexistante ! Ressaisir : " + "\u001B[0m");
							continue;
						}
						break;
					} catch (Exception e) {
						System.out.print("\u001B[31m" + "Valeur incorect !!! Ressaisir : " + "\u001B[0m");
					}
				}
				
				if(valeur == 0) {
					System.out.print("\u001B[32m" + "Donne un nom a cette nouvelle partie : " + "\u001B[0m");
					input = scan.nextLine();
					System.out.println("\u001B[32m" + "============================================================\n" + "\u001B[0m");
					
					tab_jeu_en_cours.add(new Principale());
					tab_nom_parti_en_cours.add(input);
					this.indice_jeu_en_cours = tab_jeu_en_cours.size() - 1;
				}
				else {
					this.indice_jeu_en_cours = valeur - 1;
				}	
			}
			
			
			//On a a present recuperer l'indice de la partie.
			
			sauvegarde_ou_pas = this.tab_jeu_en_cours.get(indice_jeu_en_cours).lancement_du_jeu();
			
			if(sauvegarde_ou_pas == 0){
				//On ne veut sauvegarder la partie
				this.fin_partie_en_cours();
				this.enregistrement_des_games();
		    	System.out.println("\u001B[31m" + "Sauvegarde en cours..."+ "\u001B[0m");
			}
			
			this.enregistrement_des_games();
	    	System.out.println("\u001B[31m" + "Sauvegarde en cours..." + "\u001B[0m");
			
		}
	}

}
