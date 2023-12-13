package Representation;

import univers.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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

public class Jour {

  /**
   * Nombre de jour passe dans la cave
   */
  private static int nombre_journee = 0;

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
  private ArrayList<ArrayList<Integer>> tab_DecisionNode_en_cours = new ArrayList<ArrayList<Integer>>();

  /**
   * Tableau contenant à l'indice i, les i-eme scenario impose que l'on va jouer
   * au i-eme jour
   * On le construit petit a petit.
   */
  private ArrayList<ArrayList<Integer>> tab_scenario_impose_en_cours = new ArrayList<ArrayList<Integer>>();

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
      boolean condition_4 = nombre_journee < DecisionNode.getJour_Necessaire_fin();
      boolean condition_5 = nombre_journee > DecisionNode.getJour_Necessaire_debut();

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
          tab_DecisionNode_en_cours.get(nombre_journee).add(DecisionNode.getId());
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
    System.out.println(node.getHistoire());
    int id_scenario = node.getIndex_Evenement();

    switch (id_scenario) {

      case 1:
        // Retirer un objet id 1
        node.getObjets().setQuantite(node.getNom_Objet(), -1);
        break;
      case 2:
        // retire tout les objets : id 2
        int quantite_objet = node.getObjets().getQuantite(node.getNom_Objet());
        node.getObjets().setQuantite(node.getNom_Objet(), quantite_objet);
        break;
      case 3:
        // rajouter un objet
        node.getObjets().setQuantite(node.getNom_Objet(), 1);
        break;

      case 101:
        // rajouter un aliment 1 fois : id 101
        node.getNouritures().setQuantite(node.getNom_Aliment(), 1);
        break;

      case 102:
        // rajouter un aliment 2 fois : id 102
        node.getNouritures().setQuantite(node.getNom_Aliment(), 2);
        break;

      case 103:
        // rajouter un aliment 3 fois id 103
        node.getNouritures().setQuantite(node.getNom_Aliment(), 3);
        break;

      case 105:
        // doubler la quantiter d'un aliment : id 105
        int quantite_nourriture = node.getNouritures().getQuantite(node.getNom_Objet());
        node.getNouritures().setQuantite(node.getNom_Aliment(), quantite_nourriture);
        break;
      case 111:
        // enlever un aliment 1 fois : id 111
        node.getNouritures().setQuantite(node.getNom_Aliment(), -1);
        break;

      case 112:
        // enlever un aliment 2 fois : id 112
        node.getNouritures().setQuantite(node.getNom_Aliment(), -2);
        break;

      case 113:
        // enlever un aliment 3 fois id 113
        node.getNouritures().setQuantite(node.getNom_Aliment(), -3);
        break;

      case 115:
        // enlever toute la quantiter d'un aliment : id 115
        quantite_nourriture = node.getNouritures().getQuantite(node.getNom_Objet()) * -1;
        node.getNouritures().setQuantite(node.getNom_Aliment(), quantite_nourriture);
        break;

    }

  }

  private void expedition() {
    // Un personnage va en expedition
    // Pourra ramener de la nouriture des objets, etc...

    // On verifie d'abord qu'on peut effectivement aller en expedition
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
      return;
    }

    // On peut emmener qql en expedition. Est ce que le joeur veut ?
    Scanner scan = new Scanner(System.in);
    String input = "";
    System.out.println("Veut tu emmener quelqun en expedition, pour ramener un objet ou de la nourriture? o/n ");
    input = scan.nextLine();

    // verifie qu'on a bien entree o ou n
    while (!(input.equals("n") || input.equals("o"))) {
      System.out.println("Entre o pour oui ou n pour non!!!!");
      input = scan.nextLine();
    }

    if (input.equals("n")) {
      scan.close();
      return;
    }

    System.out.println("Tu pourras choisir au plus un objet a prendre, et un personnage.");

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
    System.out.println("Lequel choisi tu ?");

    input = scan.nextLine(); // Verifier que il a entrer un numero valable grace au tableau...

    while (tab_aide_choix_perso[Integer.parseInt(input)] != 1) {
      System.out.println("Impossible de choisir ce personnage !!!!");
      System.out.println(choix_perso);
      System.out.println("Lequel choisi tu ?");
      input = scan.nextLine();
    }

    Personnages perso_expedition;
    switch (Integer.parseInt(input)) {
      case 1:
        perso1.part_en_expedition();
        perso_expedition = this.perso1;
        break;
      case 2:
        perso2.part_en_expedition();
        perso_expedition = this.perso2;
        break;
      case 3:
        perso3.part_en_expedition();
        perso_expedition = this.perso3;
        break;
      case 4:
        perso4.part_en_expedition();
        perso_expedition = this.perso4;
        break;
      default:
        perso_expedition = this.perso1;
    }

    // Choix objet ?

    Elements_du_jeu e_expedition = null;
    // On verifie qu'il peut en choisir un...
    if (objet_possession.get_objet_dispo() == true) {
      System.out.println("Voici les objets ainsi que leurs quantites : \n");
      this.objet_possession.getQuantites();

      System.out.println("Veux tu prendre un objet avec toi ? o/n");
      input = scan.nextLine();
      while (!(input.equals("n") || input.equals("o"))) {
        System.out.println("Entre o pour oui ou n pour non!!!!");
        input = scan.nextLine();
      }

      if (input.equals("o")) {
        System.out.println("Quel objet veut tu prendre ? Ecrit son nom. (Premiere lettre en majuscule !)");
        input = scan.nextLine();

        boolean verif = false;
        while (!verif) {
          for (Elements_du_jeu obj : Elements_du_jeu.values()) {
            if (input.equals(obj.getNom())) {
              e_expedition = obj;
              objet_possession.setQuantite(obj.getNom(), objet_possession.getQuantite(obj.getNom()) - 1);
              verif = true;
              break;
            }
          }
          if (!verif) {
            System.out.println("Nom inccorect. Ressaisir l'objet. (Premiere lettre en majuscule !)");
            input = scan.nextLine();
          }
        }

      } else {
        System.out.println("Pas d'Objet pris. Expedition realise sans objet. Bon courage.");
      }
    } else {
      System.out.println("Pas d'Objet disponible. Expedition realise sans objet. Bon courage.");
    }
    int point_perso = (perso_expedition.get_barre_energie() * (perso_expedition.get_force()
        + perso_expedition.get_intelligence() + perso_expedition.get_agilite() + perso_expedition.get_resistance()));
    int point_arm = 0;
    if (e_expedition == null) {
      point_arm = 0;
    } else {
      point_arm = e_expedition.getPoint() * 40;
    }
    Random random = new Random();
    int min = 1;
    int max = 4000;
    int randomNumber = random.nextInt(max - min + 1) + min;
    int notetoal = randomNumber + point_arm + point_perso;
    // Supposons que notetoal est une variable de type int déjà définie

    if (notetoal < 600) {

    } else if (notetoal < 12000) {

    } else if (notetoal < 1800) {

    } else if (notetoal < 2400) {

    } else if (notetoal < 3000) {

    } else if (notetoal < 3600) {

    } else if (notetoal < 4200) {

    } else if (notetoal < 4800) {

    } else if (notetoal < 5400) {

    } else if (notetoal < 6000) {

    } else if (notetoal < 6600) {

    } else if (notetoal < 7200) {

    } else if (notetoal < 7800) {

    } else if (notetoal < 8400) {

    } else if (notetoal < 9000) {

    } else if (notetoal < 9600) {

    } else if (notetoal < 10200) {

    } else if (notetoal < 10800) {

    } else if (notetoal < 11400) {

    } else if (notetoal < 12000) {

    }

    // Perso choisi ---> perso_expedition, la fonction s'arrete si pas de perso
    // Objet pris -----> e_expedition Null si rien pris

    // gestion de l'expedition en tant que tel
    // Faire avec Matheo : on a dit on le fait avec les scenario

    scan.close();
  }

  private void nourir_perso(Personnages p1) {
    Scanner scan = new Scanner(System.in);
    String input_nourriture = "";
    String input_nombre = "";

    System.out.println("Que veut tu donner à nourir ?");

    // On verifie juste que la nourriture existe
    boolean verif = false;
    while (!verif) {
      input_nourriture = scan.nextLine();
      try {
        nourriture_possession.getQuantite(input_nourriture);
        verif = true;
      } catch (IllegalArgumentException e) {
        e.getMessage();
        System.out.println("Ressaisir le nom.");
        verif = false;
      }
    }

    System.out.println("Combien en veux tu donner ?");
    System.out.println("Il y en a " + nourriture_possession.getQuantite(input_nourriture) + " de disponible.");
    input_nombre = scan.nextLine();

    while (Integer.parseInt(input_nombre) > nourriture_possession.getQuantite(input_nourriture)) {
      System.out.println("Pas assez de nourriture disponible ! Resaisir un nombre !!");
      input_nombre = scan.nextLine();
    }

    nourriture_possession.setQuantite(input_nourriture,
        nourriture_possession.getQuantite(input_nourriture) - Integer.parseInt(input_nombre));

    switch (input_nourriture) {
      case "Eau":
        perso1.maj_contextuelle_attributs_generaux_Personnages(nourriture_possession.getQuantite("Eau"), 0, 0,
            nourriture_possession.getEnergie("Eau"));
        break;
      default:
        perso1.maj_contextuelle_attributs_generaux_Personnages(0, nourriture_possession.getQuantite(input_nourriture),
            0, nourriture_possession.getEnergie(input_nourriture));
    }

    scan.close();
  }

  private void nourir_cave() {
    // Il faut une certaine dose de nourriture pour nourir un personnage
    // Ex : le pere doit manger plus que le frere
    // Variable a ajuster ensuite

    if (!nourriture_possession.get_nourriture_dispo()) {
      System.out.println("Plus de nourriture de disponible. On ne peut nourrir personne !!!");
      return;
    }

    System.out.print("Voici l'etat des personnages.");
    for (Personnages p : personnages) {
      p.to_String();
    }

    System.out.print("Voici les nourritures disponibles.");
    nourriture_possession.getQuantites();

    System.out
        .println("On va choisir les personnages a nourir. (Donner le numero de la personne que vous voulez nourir)");

    int[] tab_a_nourir = { 0, 0, 0, 0, 0 };

    for (int i = 1; i <= 4; i++) {
      if (personnages.get(i - 1).get_vivant() && personnages.get(i - 1).get_en_expedition() == false) {
        System.out.println(i + "------>" + personnages.get(i - 1).get_perso().name());
        tab_a_nourir[i - 1] = 1;
      }
    }

    Scanner scanner = new Scanner(System.in);
    String input = "";
    boolean verif = true;
    while (nourriture_possession.get_nourriture_dispo() && verif) {

      System.out.println("Inserer le numero du personnages que vous voulez nourrir :  ");
      input = scanner.nextLine();

      // verifier que num ok avec tab_a_nourir
      nourir_perso(personnages.get(Integer.parseInt(input)));

      System.out.println("Veux tu nourir quelqu'un d'autre ? o/n ");
      input = scanner.nextLine();

      // verifier que bien o ou n

      if (input.equals("n")) {
        verif = false;
      }
    }

    if (nourriture_possession.get_nourriture_dispo()) {
      System.out.println("Plus de nourriture disponible.");
    }

    scanner.close();
  }

  public boolean deroulement_du_jour() {
    ArrayList<Integer> vide = new ArrayList<Integer>();
    vide.add(1);
    tab_scenario_impose_en_cours.add(vide);
    tab_scenario_impose_en_cours.add(vide);
    tab_scenario_impose_en_cours.add(vide);
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
    tab_scenario_impose_en_cours.get(nombre_journee).add(2);
    System.out.println("Jours :" + nombre_journee);
    System.out.println(tab_scenario_impose_en_cours.get(nombre_journee));
    for (int ChanceNode_lancement : tab_scenario_impose_en_cours.get(nombre_journee)) {
      System.out.println("3");
      for (ChanceNode ch : tab_scenario_impose) {
        if (ch.getId() == ChanceNode_lancement) {
          lancement_scenario_impose(ch);
        }
      }
    }
    System.out.println("5");
    selection_scenario_avec_choix(); // On rempli l'attribut tab_DecisionNode_en_cours de scenario avec choix a jouer
    for (int DecisionNodelancement : tab_DecisionNode_en_cours.get(nombre_journee)) {

      for (DecisionNode de : tab_DecisionNode) {
        if (de.getId() == DecisionNodelancement) {
          de.raconte_histoire(personnages, objet_possession, tab_DecisionNode_en_cours, tab_DecisionNode_en_cours,
              personnages_en_vie);
        }
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