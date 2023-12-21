package Representation;

import univers.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import java.util.Iterator;

/**
 * Un Jour constitue les elements dans la cave au moment d'une journee:
 * -le personnage 11
 * -le personnage 2
 * -le personnage 3
 * -le personnage 4
 * -les objets en possession
 * -la nourriture en possession
 * -le nombre de jour passe dans la cave
 * 
 * -Un tableau contenant tous les scenarios a choix possible
 * -Un tableau contenant tous les scenarios a choix impose
 * 
 * -Un tableau de tableau contenant à l'indice i l'ensemble des scenarios a
 * choix qui seront joue au i-eme jour
 * -Un tableau de tableau contenant à l'indice i l'ensemble des scenarios impose
 * qui seront joue au i-eme jour
 * 
 * 
 * L'etat du Node (donc de la cave), change de jour en jour (par l'utilisation
 * de methode) :
 * -On pourra nourir les personnes
 * -On pourra emmener quelquns en expedition a l'exterieur pour recuperer un ou
 * plusieurs objets
 * -On proposera chaque jour qui passe, un/ou plusieurs scenario. Le choix de
 * scenario est determine en fonction
 * de l'etat des personnages, objets et nourritures en possession.
 * 
 * 
 * @author ABDELOUHAB Yacine et QUATREBOEUFS Matheo
 * @version deux_classes
 */

public class Jour implements Serializable {

  /**
   * Nombre de jour passe dans la cave
   */
  private int nombre_journee = 0;

  // Personnages Objet et Nourriture sont des variables qui sont passe par
  // reference
  // On pourra donc les modifie par la suite : c'est leurs reference qui est final
  private final Personnages perso1;
  private final Personnages perso2;
  private final Personnages perso3;
  private final Personnages perso4;
  private final Objet objet_possession;
  private final Nourriture nourriture_possession;
  private final ArrayList<Personnages> personnages;

  /**
   * Tableau contenant l'ensemble des scenarios avec choix possible.
   */
  private ArrayList<DecisionNode> tab_DecisionNode;
  /**
   * Tableau contenant l'ensemble des scenarios imposes possible.
   */
  private ArrayList<ChanceNode> tab_scenario_impose;

  /**
   * Tableau contenant à l'indice i, les i-eme scenario avec choix que l'on va
   * jouer au i-eme jour
   * On le construit petit a petit.
   */
  public ArrayList<ArrayList<Integer>> tab_DecisionNode_en_cours = new ArrayList<ArrayList<Integer>>();

  /**
   * Tableau contenant à l'indice i, les i-eme scenario impose que l'on va jouer
   * au i-eme jour
   * On le construit petit a petit.
   */
  public ArrayList<ArrayList<Integer>> tab_scenario_impose_en_cours = new ArrayList<ArrayList<Integer>>();

  /** Tableau contenant l'indice des scenario passées */

  private ArrayList<Integer> scenarios_indice_passe = new ArrayList<Integer>();

  /**
   * Constructeur, il n'y a pas de constructeur par defaut.
   * On ne l'appelera que une fois, pour indiquer les personnages, les objets et
   * les nourritures,
   * choisi, par le joueur.
   */

  public Jour(Personnages p1, Personnages p2, Personnages p3, Personnages p4, Objet objet_possession,
      Nourriture nourriture_possession, ArrayList<DecisionNode> tab_DecisionNode,
      ArrayList<ChanceNode> tab_scenario_impose) {

    this.perso1 = p1;
    this.perso2 = p2;
    this.perso3 = p3;
    this.perso4 = p4;
    this.objet_possession = objet_possession;
    this.nourriture_possession = nourriture_possession;
    this.personnages = (new ArrayList<Personnages>());
    this.personnages.add(this.perso1);
    this.personnages.add(this.perso2);
    this.personnages.add(this.perso3);
    this.personnages.add(this.perso4);
    this.tab_DecisionNode = tab_DecisionNode;
    this.tab_scenario_impose = tab_scenario_impose;

  }

  /**
   * Parmis les scenarios avec choix disponible, il faudra chaque jour jouer un ou
   * plusieurs scenario.
   * Cette methode va modifier l'attribut tab_DecisionNode_en_cours, en rajoutant,
   * les scenarios qui seront jouer a un certain jour.
   * Ces scenarios avec choix sont determines grace au parametre des personnages,
   * des objets et nourriture qu'il possede.
   */

  public int get_nombre_journee() {
    return this.nombre_journee;
  }

  private void selection_scenario_avec_choix() {

    int nombre_de_vivant = 0; // Initialisation du compteur de personnages vivants

    // Vérifie si chaque personnage est vivant et incrémente le compteur
    if (perso1.get_vivant()) {
      nombre_de_vivant++;
    }
    if (perso2.get_vivant()) {
      nombre_de_vivant++;
    }
    if (perso3.get_vivant()) {
      nombre_de_vivant++;
    }
    if (perso4.get_vivant()) {
      nombre_de_vivant++;
    }

    // Génère un nombre aléatoire entre 0 et 1
    double nombre_aleatoire_entre_0_1 = Math.random();

    // Parcours des nœuds de décision dans le tableau tab_DecisionNode
    for (DecisionNode DecisionNode : tab_DecisionNode) {
      // Vérifie si les conditions sont remplies pour ce DecisionNode spécifique
      boolean condition_1 = DecisionNode.getVariable_Aleatoire_debut() < nombre_aleatoire_entre_0_1;
      boolean condition_2 = nombre_aleatoire_entre_0_1 < DecisionNode.getVariable_Aleatoire_fin();
      boolean condition_3 = nombre_de_vivant >= DecisionNode.getNombre_Personnage();
      boolean condition_4 = nombre_journee <= DecisionNode.getJour_Necessaire_fin();
      boolean condition_5 = nombre_journee >= DecisionNode.getJour_Necessaire_debut();

      boolean tousPresent = true;
      if (DecisionNode.getScenario_Necessaire() != null) {
        for (int nombre : scenarios_indice_passe) {
          boolean trouve = false;

          // Vérifie si l'élément du premier tableau est présent dans le deuxième tableau
          for (int valeur : DecisionNode.getScenario_Necessaire()) {
            if (nombre == valeur) {
              trouve = true;
              break; // Sort de la boucle une fois qu'il est trouvé
            }
          }

          // Si l'élément du premier tableau n'est pas trouvé dans le deuxième tableau, on
          // modifie le booléen
          if (!trouve) {
            tousPresent = false;
            break; // On arrête la boucle, on a trouvé un élément manquant
          }
        }
      }

      boolean id_peronnage_necessaire = true;
      // si aucun personnage n'est necessaire
      if (DecisionNode.get_id_peronnage_necessaire() != -1) {
        id_peronnage_necessaire = false;
        for (Personnages personne : personnages) {
          if (personne.get_perso().getIdentifiant() == DecisionNode.get_id_peronnage_necessaire()
              && personne.get_vivant()) {
            id_peronnage_necessaire = true;
          }
        }
      }
      boolean objet_Necessaire = true;
      if (DecisionNode.getObjetnecessaire() != null) {
        objet_Necessaire = false;

        for (String nom_objet_posseder : objet_possession.getObjetsposseder()) {
          if (DecisionNode.getObjetnecessaire().equals(nom_objet_posseder)) {
            objet_Necessaire = true;
          }

        }
      }
      if (condition_1 && condition_2 && condition_3 && condition_4 && condition_5 && tousPresent
          && id_peronnage_necessaire && objet_Necessaire) {
        {
          // Créeation de liste pour pas générer des beugs
          while (tab_DecisionNode_en_cours.size() <= nombre_journee + 1) {
            tab_DecisionNode_en_cours.add(new ArrayList<>());
          }
          // Rajoute le déscison node qui remplie tous les critères et stop la fonction
          // pour en rajouter qu'un seul

          tab_DecisionNode_en_cours.get((nombre_journee)).add(DecisionNode.getId());

          return;
        }
      }
    }
  }

  private ArrayList<Integer> lancement_scenario_avec_choix() {

    return null;
  }

  private void lancement_scenario_impose(ChanceNode node) {
    // Raconte l'histoire du scénario
    if (node.getNum_perso() != -1) {
      System.out.print(personnages.get(node.getNum_perso()).get_perso().getPrenom() + " ");
    }
    System.out.println(node.getHistoire());
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {

    }
    int index_scenario = node.getIndex_Evenement();
    int nombre_nourriture;

    switch (index_scenario) {
      case 0:
        // ne fait rien sert à mettre du text
        break;

      case 1:
        // Retirer un aliment index : 1
        nourriture_possession.setQuantite(node.getNom_Aliment(), -1);
        break;
      case 2:
        // Retirer deux aliment index : 2
        nourriture_possession.setQuantite(node.getNom_Aliment(), -2);
        break;
      case 3:
        // retire 3 aliments : index : 3
        nourriture_possession.setQuantite(node.getNom_Aliment(), -3);
        break;

      case 5:
        // retire tout les aliments : index : 5
        nombre_nourriture = nourriture_possession.getQuantite(node.getNom_Aliment()) * -1;
        nourriture_possession.setQuantite(node.getNom_Aliment(), nombre_nourriture);
        break;

      case 6:
        // doubler la quantité : index : 6
        nombre_nourriture = nourriture_possession.getQuantite(node.getNom_Aliment());
        nourriture_possession.setQuantite(node.getNom_Aliment(), nombre_nourriture);
        break;
      case 7:
        // Ajouter une quantité indexx : 7

        nourriture_possession.setQuantite(node.getNom_Aliment(), 1);
        break;
      case 8:
        // Ajouter deux aliment index : 8
        nourriture_possession.setQuantite(node.getNom_Aliment(), 2);
        break;
      case 9:
        // Ajouter 3 aliments : index : 9
        nourriture_possession.setQuantite(node.getNom_Aliment(), 3);
        break;

      case 11:
        // Retirer un aliment index : 1
        objet_possession.setQuantite(node.getNom_Aliment(), -1);
        break;

      case 15:
        // retire tout les aliments : index : 5
        nombre_nourriture = nourriture_possession.getQuantite(node.getNom_Aliment()) * -1;
        objet_possession.setQuantite(node.getNom_Aliment(), nombre_nourriture);
        break;

      case 17:
        // Ajouter une quantité index : 7

        objet_possession.setQuantite(node.getNom_Aliment(), 1);

        break;
      /*
       * maj_contextuelle_attributs_specifique_Personnages_ajout() int nforce, int
       * nconso_nourriture, int nintelligence,
       * int nresistance, int nagilite)
       */
      case 100:

        // Le personnage devient moins fort
        if (personnages.get(node.getNum_perso()).get_vivant()) {
          personnages.get(node.getNum_perso()).maj_contextuelle_attributs_specifique_Personnages_ajout(-3, 0, 0, 0, 0);
        } else {
          System.out.println("A non il est mort");
        }
        break;

      case 101:

        // Le personnage devient plus fort
        if (personnages.get(node.getNum_perso()).get_vivant()) {
          personnages.get(node.getNum_perso()).maj_contextuelle_attributs_specifique_Personnages_ajout(3, 0, 0, 0, 0);
        } else {
          System.out.println("Ah non il est mort");
        }
        break;

      case 102:

        // Le personnage consomme plus de nourriture
        if (personnages.get(node.getNum_perso()).get_vivant()) {
          personnages.get(node.getNum_perso()).maj_contextuelle_attributs_specifique_Personnages_ajout(0, 3, 0, 0, 0);
        } else {
          System.out.println("Ah non il est mort");
        }
        break;

      case 103:

        // Le personnage consomme moins de nourriture
        if (personnages.get(node.getNum_perso()).get_vivant()) {
          personnages.get(node.getNum_perso()).maj_contextuelle_attributs_specifique_Personnages_ajout(0, -3, 0, 0, 0);
        } else {
          System.out.println("Ah non il est mort");
        }
        break;

      case 104:

        // Le personnage devient plus intelligent
        if (personnages.get(node.getNum_perso()).get_vivant()) {
          personnages.get(node.getNum_perso()).maj_contextuelle_attributs_specifique_Personnages_ajout(0, 0, 3, 0, 0);
        } else {
          System.out.println("Ah non il est mort");
        }
        break;

      case 105:
        // Le personnage perd de l'intelligence
        if (personnages.get(node.getNum_perso()).get_vivant()) {
          personnages.get(node.getNum_perso()).maj_contextuelle_attributs_specifique_Personnages_ajout(0, 0, -3, 0, 0);
        } else {
          System.out.println("Ah non il est mort");
        }
        break;

      case 106:
        // Le personnage gagne de l'agilité
        if (personnages.get(node.getNum_perso()).get_vivant()) {
          personnages.get(node.getNum_perso()).maj_contextuelle_attributs_specifique_Personnages_ajout(0, 0, 0, 3, 0);
        } else {
          System.out.println("Ah non il est mort");
        }
        break;

      case 107:
        // Le personnage perd de l'agilité
        if (personnages.get(node.getNum_perso()).get_vivant()) {
          personnages.get(node.getNum_perso()).maj_contextuelle_attributs_specifique_Personnages_ajout(0, 0, 0, -3, 0);
        } else {
          System.out.println("Ah non il est mort");
        }
        break;

      case 108:
        // Le personnage gagne de la résistance
        if (personnages.get(node.getNum_perso()).get_vivant()) {
          personnages.get(node.getNum_perso()).maj_contextuelle_attributs_specifique_Personnages_ajout(0, 0, 0, 0, 3);
        } else {
          System.out.println("Ah non il est mort");
        }
        break;
      case 109:
        // Le personnage perd de la résistance
        if (personnages.get(node.getNum_perso()).get_vivant()) {
          personnages.get(node.getNum_perso()).maj_contextuelle_attributs_specifique_Personnages_ajout(0, 0, 0, 0, -3);
        } else {
          System.out.println("Ah non il est mort");
        }
        break;

      case 110:
        // Le personnage devient fort partout
        if (personnages.get(node.getNum_perso()).get_vivant()) {
          personnages.get(node.getNum_perso()).maj_contextuelle_attributs_specifique_Personnages(20, 20, 20, 20, 20);
        } else {
          System.out.println("Ah non il est mort");
        }
        break;
      case 111:
        // Le personnage est devenue un légume
        if (personnages.get(node.getNum_perso()).get_vivant()) {
          personnages.get(node.getNum_perso()).maj_contextuelle_attributs_specifique_Personnages(0, 0, 0, 0, 0);
        } else {
          System.out.println("Ah non il est mort");
        }
        break;

      case 112:
        // Le personnage ne consomme plus rien
        if (personnages.get(node.getNum_perso()).get_vivant()) {
          personnages.get(node.getNum_perso()).maj_contextuelle_attributs_specifique_Personnages_ajout(0, -100, 0, 0,
              0);
        } else {
          System.out.println("Ah non il est mort");
        }
        break;
      case 113:
        // Le personnage est accros à la nourriture
        if (personnages.get(node.getNum_perso()).get_vivant()) {
          personnages.get(node.getNum_perso()).maj_contextuelle_attributs_specifique_Personnages_ajout(0, 30, 0, 0, 0);
        } else {
          System.out.println("Ah non il est mort");
        }
        break;

      case 114:
        // Le personnage est d'une intelligence hors norme
        if (personnages.get(node.getNum_perso()).get_vivant()) {
          personnages.get(node.getNum_perso()).maj_contextuelle_attributs_specifique_Personnages_ajout(0, 0, 20, 0, 0);
        } else {
          System.out.println("Ah non il est mort");
        }
        break;

      case 115:
        // Le personnage tombe malade
        if (personnages.get(node.getNum_perso()).get_vivant()) {

          personnages.get(node.getNum_perso()).maj_contamination_virus_Personnages();

        } else {
          System.out.println("Ah non il est mort");
        }
        break;
      case 116:
        // La personne meurt
        if (personnages.get(node.getNum_perso()).get_vivant()) {
          personnages.get(node.getNum_perso()).tuer_personnage();
        } else {
          System.out.println("Une deuxième fois c'est un peu de l'acharnement.");
        }
        break;
      case 117:
        // La personne revient d'expédition
        if (personnages.get(node.getNum_perso()).get_vivant()) {
          personnages.get(node.getNum_perso()).revient_de_expedition();
        } else {
          System.out.println("Certe il revient, mais il est mort.");
        }
        break;

      case 118:
        // La personne est un peu amocher
        if (personnages.get(node.getNum_perso()).get_vivant()) {
          personnages.get(node.getNum_perso()).maj_contextuelle_attributs_generaux_Personnages(-20, -20, -20, -20);

        } else {
          System.out.println("Certe il revient, mais il est mort.");
        }
        break;

      case 119:
        // La personne va mieux
        if (personnages.get(node.getNum_perso()).get_vivant()) {
          personnages.get(node.getNum_perso()).maj_contextuelle_attributs_generaux_Personnages(20, 20, 20, 20);
        } else {
          System.out.println("Certe il revient, mais il est mort.");
        }
        break;

      case 120:
        if (personnages.get(node.getNum_perso()).get_vivant()) {
          personnages.get(node.getNum_perso()).maj_contextuelle_attributs_generaux_Personnages(100, 100, 100, 100);
        } else {
          System.out.println("Certe il revient, mais il est mort.");
        }
        break;
    }
  }

  private void expedition() {
    // Un personnage va en expedition
    // Pourra ramener de la nouriture des objets, etc...

    // On verifie d'abord qu'on peut effectivement aller en expedition

    System.out.println("\n\n");
    System.out.println("==============================================================\n");

    System.out.println("\u001B[34m" + "			==================================\n"
        + "          		   Expedition ! \n"
        + "		==================================\n" + "\u001B[0m");

    /*
     * try {
     * Thread.sleep(2000);
     * } catch (InterruptedException e) {
     * 
     * }
     */

    // On verifie qu'on peut emmener qql en expedition
    int verif1 = 1;
    int verif2 = 1;
    int verif3 = 1;
    int verif4 = 1;
    int nbr_boucle = 1;
    int verif_courant = 1;

    for (Personnages p : this.personnages) {
      if (p.get_vivant() == false || p.get_en_expedition() == true) {
        verif_courant = 0;

      } else {
        verif_courant = 1;
      }

      switch (nbr_boucle) {
        case 1:
          verif1 = verif_courant;
        case 2:
          verif2 = verif_courant;
        case 3:
          verif3 = verif_courant;
        case 4:
          verif4 = verif_courant;
      }
      nbr_boucle = nbr_boucle + 1;
    }

    if (verif1 + verif2 + verif3 + verif4 == 0) {
      System.out.println("\u001B[34m" + "Aucun Personnage Dispo !" + "\u001B[0m");
      System.out.println("==============================================================\n");
      return;
    }

    // On peut emmener qql en expedition. Est ce que le joeur veut ?
    Scanner scan = new Scanner(System.in);
    String input = "";
    System.out.print("\u001B[34m"
        + "Veut tu emmener quelqun en expedition, pour ramener un objet ou de la nourriture? o/n " + "\u001B[0m");

    input = scan.nextLine();

    // verifie qu'on a bien entree o ou n
    while (!(input.equals("n") || input.equals("o"))) {
      System.out.print("\u001B[31m" + "Entre o pour oui ou n pour non! Ressaisir : " + "\u001B[0m ");
      input = scan.nextLine();
    }

    if (input.equals("n")) {
      System.out.println("==============================================================\n");
      return;
    }

    System.out
        .println("\u001B[34m" + "Tu pourras choisir au plus un objet a prendre, et un personnage." + "\u001B[0m ");

    // Choix personnage
    // Rappeler les attributs specifiques des perso ?

    // Verifier qu'ils sont vivants, et qu'il ne sont pas en expedition
    String choix_perso = "Tu peux chosir les personages suivant : \n";
    int[] tab_aide_choix_perso = { 0, 0, 0, 0, 0 };
    // On a pas 5 perso, mais 4. Pour ne pas s'embeter avec la gestion d'indice on
    // rajoute une case de plus.

    if (perso1.get_vivant() == true && perso1.get_en_expedition() == false) {
      choix_perso = choix_perso + "1 ---> " + (perso1.get_perso()).name() + "\n";
      tab_aide_choix_perso[1] = 1;
    }

    if (perso2.get_vivant() == true && perso2.get_en_expedition() == false) {
      choix_perso = choix_perso + "2 ---> " + (perso2.get_perso()).name() + "\n";
      tab_aide_choix_perso[2] = 1;
    }

    if (perso3.get_vivant() == true && perso3.get_en_expedition() == false) {
      choix_perso = choix_perso + "3 ---> " + (perso3.get_perso()).name() + "\n";
      tab_aide_choix_perso[3] = 1;
    }

    if (perso4.get_vivant() == true && perso4.get_en_expedition() == false) {
      choix_perso = choix_perso + "4---> " + (perso4.get_perso()).name() + "\n";
      tab_aide_choix_perso[4] = 1;
    }

    System.out.println(choix_perso);
    System.out.print("\u001B[34m" + "Lequel choisi tu ? " + "\u001B[0m ");

    while (true) {

      input = scan.nextLine(); // Verifier que il a entrer un numero valable grace au tableau...
      try {

        if (!(Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= 4)) {
          System.out.print("\u001B[31m" + "Personnage Inexistant ! Ressaisir : " + "\u001B[0m");
          continue;
        }
        if (tab_aide_choix_perso[Integer.parseInt(input)] != 1) {
          System.out.print("\u001B[31m" + "Impossible de choisir ce personnage ! Ressaisir : " + "\u001B[0m");
          continue;
        }
      } catch (NumberFormatException e) {
        System.out.print("\u001B[31m" + "Erreur de saisie ! Ressaisir : " + "\u001B[0m");
        continue;
      } catch (Exception e) {
        System.out.print("\u001B[31m" + "Erreur! Ressaisir : " + "\u001B[0m");
        continue;
      }
      break;
    }
    int place_du_perso = -1;
    Personnages perso_expedition;
    switch (Integer.parseInt(input)) {
      case 1:

        perso1.part_en_expedition();
        perso_expedition = this.perso1;
        place_du_perso = 0;
        break;
      case 2:
        perso2.part_en_expedition();
        perso_expedition = this.perso2;
        place_du_perso = 1;

        break;
      case 3:
        perso3.part_en_expedition();
        perso_expedition = this.perso3;
        place_du_perso = 2;

        break;
      case 4:
        perso4.part_en_expedition();
        perso_expedition = this.perso4;
        place_du_perso = 3;

        break;
      default:
        perso_expedition = this.perso1;
    }

    // Choix objet ?

    Elements_du_jeu e_expedition = null;
    // On verifie qu'il peut en choisir un...
    if (objet_possession.get_objet_dispo() == true) {

      System.out.println("\u001B[34m" + "			========Inventaire Objet========" + "\u001B[0m");
      this.objet_possession.getQuantites();

      /*
       * try {
       * Thread.sleep(2000);
       * } catch (InterruptedException e) {
       * 
       * }
       */

      System.out.print("\u001B[34m" + "Veux tu prendre un objet avec toi ? o/n " + "\u001B[0m");
      input = scan.nextLine();
      while (!(input.equals("n") || input.equals("o"))) {
        System.out.print("\u001B[31m" + "Entre o pour oui ou n pour non!!!! " + "\u001B[0m");
        input = scan.nextLine();
      }

      if (input.equals("o")) {
        System.out.print("\u001B[34m" + "Quel objet veut tu prendre ? Ecrit son nom. (Premiere lettre en majuscule !) "
            + "\u001B[0m");
        input = scan.nextLine();

        boolean verif = false;
        while (!verif) {

          try {
            for (Elements_du_jeu obj : Elements_du_jeu.values()) {
              if (input.equals(obj.getNom()) && this.objet_possession.getQuantite(obj.getNom()) != 0) {
                e_expedition = obj;
                objet_possession.setQuantite(obj.getNom(), -1);
                verif = true;
                break;
              }
            }

          } catch (Exception e) {

          }
          if (!verif) {
            System.out.print(
                "\u001B[31m" + "Nom incorect. Ressaisir l'objet. (Premiere lettre en majuscule !) : " + "\u001B[0m");
            input = scan.nextLine();
          }
        }

      } else {

        System.out
            .println("\u001B[34m" + "Pas d'Objet pris. Expedition realise sans objet. Bon courage." + "\u001B[0m");
      }
    } else {
      System.out
          .println("\u001B[34m" + "Pas d'Objet disponible. Expedition realise sans objet. Bon courage." + "\u001B[0m");
    }
    int point_perso = (perso_expedition.get_barre_energie() * (perso_expedition.get_force()
        + perso_expedition.get_intelligence() + perso_expedition.get_agilite() + perso_expedition.get_resistance()));
    int point_arm = 0;
    if (e_expedition == null) {
      point_arm = 0;
    } else {
      point_arm = e_expedition.getPoint() * 400;
    }
    Random random = new Random();
    int min = 1;
    int max = 4000;
    int randomNumber = random.nextInt(max - min + 1) + min;
    int notetoal = randomNumber + point_arm + point_perso;
    // Supposons que notetoal est une variable de type int déjà définie
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {

    }
    int bon_placement = place_du_perso * 20;
    int temps_expedition = 1;


    while (tab_scenario_impose_en_cours.size() <= (nombre_journee + temps_expedition)) {
      tab_scenario_impose_en_cours.add(new ArrayList<>());
    }
    tab_scenario_impose_en_cours.get(nombre_journee + temps_expedition).add(217 + bon_placement);

    if (notetoal < 600) {

      tab_scenario_impose_en_cours.get(nombre_journee + temps_expedition).add(500 + place_du_perso);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(216);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(236);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(256);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(276);
    } else if (notetoal < 1200) {

      tab_scenario_impose_en_cours.get(nombre_journee + temps_expedition).add(504 + place_du_perso);

      if (place_du_perso == 0) {

        tab_scenario_impose_en_cours.get(nombre_journee + 1).add(236);
        tab_scenario_impose_en_cours.get(nombre_journee + 1).add(256);
        tab_scenario_impose_en_cours.get(nombre_journee + 1).add(276);
      }
      if (place_du_perso == 1) {
        tab_scenario_impose_en_cours.get(nombre_journee + 1).add(216);
        tab_scenario_impose_en_cours.get(nombre_journee + 1).add(256);
        tab_scenario_impose_en_cours.get(nombre_journee + 1).add(276);
      }
      if (place_du_perso == 2) {
        tab_scenario_impose_en_cours.get(nombre_journee + 1).add(216);
        tab_scenario_impose_en_cours.get(nombre_journee + 1).add(236);
        tab_scenario_impose_en_cours.get(nombre_journee + 1).add(276);
      }
      if (place_du_perso == 3) {
        tab_scenario_impose_en_cours.get(nombre_journee + 1).add(216);
        tab_scenario_impose_en_cours.get(nombre_journee + 1).add(236);
        tab_scenario_impose_en_cours.get(nombre_journee + 1).add(256);
      }


    } else if (notetoal < 1800) {
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(599);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(216 + bon_placement);
    } else if (notetoal < 2400) {
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(599);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(211 + bon_placement);

    } else if (notetoal < 3000) {
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(599);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(215 + bon_placement);

    } else if (notetoal < 3600) {
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(599);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(218 + bon_placement);

    } else if (notetoal < 4200) {
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(599);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(218 + bon_placement);

    } else if (notetoal < 4800) {
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(218 + bon_placement);

    } else if (notetoal < 5400) {
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(598);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(37);

    } else if (notetoal < 6000) {
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(219 + bon_placement);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(598);

      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(17);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(37);

    } else if (notetoal < 6600) {
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(598);

      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(77);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(9);

    } else if (notetoal < 7200) {
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(208 + bon_placement);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(598);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(137);

    } else if (notetoal < 7800) {
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(598);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(19);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(27);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(46);
    } else if (notetoal < 8400) {
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(598);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(157);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(38);

    } else if (notetoal < 9000) {
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(598);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(7);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(17);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(27);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(37);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(47);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(67);

    } else if (notetoal < 9600) {
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(206 + bon_placement);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(203 + bon_placement);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(201 + bon_placement);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(598);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(7);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(87);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(19);

    } else if (notetoal < 10200) {
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(280 + place_du_perso);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(598);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(39);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(36);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(29);

    } else if (notetoal < 10800) {
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(598);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(38);
      for (int i = 0; i < 10; i++) {

        tab_scenario_impose_en_cours.get(nombre_journee + 1).add(67 + (10 * i));

      }

    } else if (notetoal < 11400) {
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(212 + bon_placement);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(214 + bon_placement);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(598);

      for (int i = 0; i < 5; i++) {

        tab_scenario_impose_en_cours.get(nombre_journee + 1).add(8 + (10 * i));

      }


    } else {
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(210 + bon_placement);
      tab_scenario_impose_en_cours.get(nombre_journee + 1).add(598);

      for (int i = 0; i < 5; i++) {

        tab_scenario_impose_en_cours.get(nombre_journee + 1).add(9 + (10 * i));

      }

    }

    /*
     * 1. ChanceNode 1 : Perte d'une ration de pâte.
     * 2. ChanceNode 2 : Perte de deux rations de pâte.
     * 3. ChanceNode 3 : Disparition de trois rations de pâte.
     * 5. ChanceNode 5 : Perte de toutes les rations de pâte.
     * 6. ChanceNode 6 : Doublement des réserves de rations de pâte.
     * 7. ChanceNode 7 : Ajout d'une ration de pâte.
     * 8. ChanceNode 8 : Ajout de deux rations de pâte.
     * 9. ChanceNode 9 : Ajout de trois nouvelles rations de pâte.
     * 
     * 11 : Perte d'une banane.
     * 12 : Perte de deux bananes.
     * 13 : Disparition de trois bananes.
     * 15 : Perte de toutes les bananes.
     * 16 : Doublement des réserves de bananes.
     * 17 : Ajout d'une banane.
     * 18 : Ajout de deux bananes.
     * 19 : Ajout de trois nouvelles bananes.
     * 
     * 21 : Perte d'une friandise.
     * 22 : Perte de deux friandises.
     * 23 : Disparition de trois friandises.
     * 25 : Perte de toutes les friandises.
     * 26 : Doublement des réserves de friandises.
     * 27 : Ajout d'une friandise.
     * 28 : Ajout de deux friandises.
     * 29 : Ajout de trois nouvelles friandises.
     * 
     * 31 : Perte d'une bouteille d'eau.
     * 32 : Perte de deux bouteilles d'eau.
     * 33 : Disparition de trois bouteilles d'eau.
     * 35 : Perte de toutes les bouteilles d'eau.
     * 36 : Doublement des réserves d'eau.
     * 37 : Ajout d'une bouteille d'eau.
     * 38 : Ajout de deux bouteilles d'eau.
     * 39 : Ajout de trois nouvelles bouteilles d'eau.
     * 
     * 41 : Perte d'une canette de soda.
     * 42 : Perte de deux canettes de soda.
     * 43 : Disparition de trois canettes de soda.
     * 45 : Perte de toutes les canettes de soda.
     * 46 : Doublement des réserves de sodas.
     * 47 : Ajout d'une canette de soda.
     * 48 : Ajout de deux canettes de soda.
     * 49 : Ajout de trois nouvelles canettes de soda.
     * 
     * 61 : Une boîte à outils est endommagée.
     * 65 : Toutes les boîtes à outils sont devenues inutilisables.
     * 67 : Ajout d'une nouvelle boîte à outils.
     * 71 : Un katana est endommagé.
     * 75 : Tous les katanas sont devenus inutilisables.
     * 77 : Ajout d'un nouveau katana.
     * 81 : Une carte de la ville est déchirée.
     * 85 : Toutes les cartes de la ville sont devenues illisibles.
     * 87 : Ajout d'une nouvelle carte de la ville.
     * 91 : L'objet Échec est endommagé.
     * 95 : Tous les objets Échec sont devenus inutilisables.
     * 97 : Ajout d'un nouvel objet Échec.
     * 101 : Une carte à jouer est abîmée.
     * 105 : Toutes les cartes à jouer sont devenues illisibles.
     * 107 : Ajout d'une nouvelle série de cartes à jouer.
     * 111 : L'insecticide est presque vide.
     * 115 : Tous les insecticides sont désormais vides.
     * 117 : Ajout d'un nouvel insecticide.
     * 121 : Une hache est endommagée.
     * 125 : Toutes les haches sont désormais inutilisables.
     * 127 : Ajout d'une nouvelle hache.
     * 131 : Un sac est déchiré.
     * 135 : Tous les sacs sont désormais inutilisables.
     * 137 : Ajout d'un nouveau sac.
     * 141 : Une trousse est abîmée.
     * 145 : Toutes les trousses sont désormais inutilisables.
     * 147 : Ajout d'une nouvelle trousse.
     * 151 : La radio est endommagée.
     * 155 : Toutes les radios sont désormais hors service.
     * 157 : Ajout d'une nouvelle radio.
     * 161 : La lampe est endommagée.
     * 165 : Toutes les lampes sont désormais hors service.
     * 167 : Ajout d'une nouvelle lampe.
     */
    System.out.println("==============================================================\n");

    // Perso choisi ---> perso_expedition, la fonction s'arrete si pas de perso
    // Objet pris -----> e_expedition Null si rien pris

    // gestion de l'expedition en tant que tel
    // Faire avec Matheo : on a dit on le fait avec les scenario

  }

  private void nourir_perso(Personnages p1) {
    Scanner scan = new Scanner(System.in);
    String input_nourriture = "";
    String input_nombre = "";

    System.out.print("\u001B[34m"
        + "Que veut tu donner à nourir ? (Ecrit un des des aliments de l'inventaire : attention au majuscule...) "
        + "\u001B[0m");

    // On verifie juste que la nourriture existe
    boolean verif = false;
    while (!verif) {
      input_nourriture = scan.nextLine();
      try {
        nourriture_possession.getQuantite(input_nourriture);
        verif = true;
      } catch (IllegalArgumentException e) {
        System.out.print("\u001B[31m" + e.getMessage() + "Ressaisir l'aliment : " + "\u001B[0m");
        verif = false;
      }
    }

    System.out.println("\u001B[34m" + "Il y en a " + nourriture_possession.getQuantite(input_nourriture)
        + " de disponible." + "\u001B[0m");
    System.out.print("\u001B[34m" + "Combien veux tu en donner ? " + "\u001B[0m");

    while (true) {
      try {
        input_nombre = scan.nextLine();
        if (Integer.parseInt(input_nombre) > nourriture_possession.getQuantite(input_nourriture)) {
          System.out.print("\u001B[31m" + "Pas assez de nourriture disponible ! Ressaisir un nombre !! " + "\u001B[0m");
          continue;
        }
        if (Integer.parseInt(input_nombre) < 0) {
          System.out.print("\u001B[31m" + "Un nombre negatif ?? Ressaisir un nombre !! " + "\u001B[0m");
          continue;
        }
      } catch (NumberFormatException e) {
        System.out.print("\u001B[31m" + "Saisir un Nombre! Ressaisir : " + "\u001B[0m");
        continue;
      } catch (Exception e) {
        System.out.print("\u001B[31m" + "Saisie Incorrect. Ressaisir : " + "\u001B[0m");
        continue;
      }
      break;
    }

    nourriture_possession.setQuantite(input_nourriture, -Integer.parseInt(input_nombre));

    for (Elements_du_jeu e : Elements_du_jeu.values()) {
      if (e.getNom().equals(input_nourriture)) {
        p1.maj_contextuelle_attributs_generaux_Personnages(e.getHydratation() * Integer.parseInt(input_nombre),
            (int) (e.getNourrissant() * (1.0 / p1.get_conso_nourriture())), 0, e.getEnergie());
      }
    }
  }

  private void nourir_cave() {
    // Il faut une certaine dose de nourriture pour nourir un personnage
    // Ex : le pere doit manger plus que le frere
    // Variable a ajuster ensuite

    System.out.println("\n\n");
    System.out.println("==============================================================\n");

    System.out.println("\u001B[34m" + "			==================================\n"
        + "          		    A Table !! \n"
        + "		==================================\n" + "\u001B[0m");

    /*
     * try {
     * Thread.sleep(2000);
     * } catch (InterruptedException e) {
     * 
     * }
     */

    if (!nourriture_possession.get_nourriture_dispo()) {
      System.out
          .println("\u001B[31m" + " Plus de nourriture de disponible. On ne peut nourrir personne !!!" + "\u001B[0m");
      System.out.println("==============================================================\n");

      return;
    }

    System.out.println("Voici l'etat des personnages.\n");
    for (Personnages p : personnages) {
      if(p.get_en_expedition()) {
    	  p.to_String_en_expedition();
      }
      else {
    	  p.to_String_Generaux();
      }
    }

    System.out.println("\u001B[34m" + "			======Inventaire Nourriture======" + "\u001B[0m");
    this.nourriture_possession.getQuantites();

    System.out.println("\n\n" + "\u001B[34m"
        + "On va choisir les personnages a nourir. (Donner le numero de la personne que vous voulez nourir)"
        + "\u001B[0m");

    int[] tab_aide_verif = { 0, 0, 0, 0, 0 }; // Si persoi vivant alors on met a l'indice i la val 1, 0 sinon

    for (int i = 1; i <= 4; i++) {
      if (personnages.get(i - 1).get_vivant() && personnages.get(i - 1).get_en_expedition() == false) {
        System.out.println(i + "------>" + personnages.get(i - 1).get_perso().name() + " => "
            + personnages.get(i - 1).get_perso().getPrenom());
        tab_aide_verif[i] = 1;
      }
    }
    System.out.println();

    Scanner scanner = new Scanner(System.in);
    String input = "";
    boolean verif = true;
    while (nourriture_possession.get_nourriture_dispo() && verif) {

      System.out.print("\u001B[34m"
          + "Inserer le numero du personnages que vous voulez nourrir (0 si personne a nourir) : " + "\u001B[0m");

      input = scanner.next();

      try {
        if (!(Integer.parseInt(input) <= 4 && Integer.parseInt(input) >= 0)) {
          throw new ArithmeticException("\u001B[31m" + "Nombre saisie Incorrect !" + "\u001B[0m");
        }

        if (Integer.parseInt(input) > 0 && tab_aide_verif[Integer.parseInt(input)] == 0) {
          throw new IllegalArgumentException(
              "\u001B[31m" + "Personnage Indisponible, on ne peut pas le nourir !" + "\u001B[0m");
        }
      } catch (NumberFormatException e) {
        System.out.println("\u001B[31m" + "Erreur dans la saisie !" + "\u001B[0m");
        continue;
      } catch (ArithmeticException e) {
        System.out.println(e.getMessage());
        continue;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        continue;
      }

      if (Integer.parseInt(input) == 0) {
        verif = false;
        continue;
      }

      nourir_perso(personnages.get(Integer.parseInt(input) - 1));

      while (true) {
        System.out.print("\u001B[34m" + "Veux tu nourir quelqu'un d'autre (o/n) ?  " + "\u001B[0m");
        try {
          input = scanner.nextLine();
          if (!(input.equals("o") || input.equals("n"))) {
            throw new IllegalArgumentException("\u001B[31m" + "Inserer o pour oui ou n pour non !!!" + "\u001B[0m");
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

      if (input.equals("n")) {
        verif = false;
      }
    }

    if (!(nourriture_possession.get_nourriture_dispo())) {
      System.out.println("\u001B[34m" + "Attention plus de nourriture disponible !" + "\u001B[0m");
    }

    System.out.println("\n\n\n");
    System.out.println("	    ==========Mise a jour effectuee==========\n\n");
    System.out.println("\u001B[34m" + "			======Inventaire Nourriture======" + "\u001B[0m");
    nourriture_possession.getQuantites();
    System.out.println("\n");
    for (Personnages p : personnages) {
      p.to_String_Generaux();
    }
    System.out.println("==============================================================\n");

  }

  public boolean deroulement_du_jour() {
    ArrayList<Integer> vide = new ArrayList<Integer>();
    tab_scenario_impose_en_cours.add(vide);
    tab_DecisionNode_en_cours.add(vide);
    int personnages_en_vie = 0;
    for (Personnages p : personnages) {
      if (p.get_vivant()) {
        personnages_en_vie++;

      }
    }
    if (personnages_en_vie == 0) {
      return false;
    }

    for (Personnages p : personnages) {
      p.maj_naturelle_attributs_generaux_Personnages();

    }

    for (int ChanceNode_lancement : tab_scenario_impose_en_cours.get(nombre_journee)) {
      for (ChanceNode ch : tab_scenario_impose) {
        if (ch.getId() == ChanceNode_lancement) {

          lancement_scenario_impose(ch);

        }
      }
    }

    selection_scenario_avec_choix(); // On rempli l'attribut tab_DecisionNode_en_cours de scenario avec choix a jouer

    ArrayList<Integer> decisions = tab_DecisionNode_en_cours.get(nombre_journee);
    Iterator<DecisionNode> iterator = tab_DecisionNode.iterator();
    while (iterator.hasNext()) {
      DecisionNode de = iterator.next();
      if (decisions.contains(de.getId())) {

        de.raconte_histoire(personnages, objet_possession, tab_DecisionNode_en_cours, tab_scenario_impose_en_cours,
            this.nombre_journee);
        iterator.remove(); // Utilisation de l'itérateur pour supprimer l'élément en cours
      }
    }

    // ArrayList<Integer> set_prochain_scenario_impose =
    // lancement_scenario_impose();
    // On modifie les tableaux tab_DecisionNode_en_cours et
    // tab_scenario_impose_en_cours

    for (Personnages p : personnages) {
      p.maj_donnee_etat_naturelle_Personnages();
    }

    nourir_cave();
    expedition();
    nombre_journee = nombre_journee + 1;

    return true;
  }

}
