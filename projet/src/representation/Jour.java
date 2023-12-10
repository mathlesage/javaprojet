package Representation;

import univers.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Un Jour constitue les elements dans la cave au moment d'une journee:
 * -le personnage 1
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
  private int jours;
  private final Personnages perso1;
  private final Personnages perso2;
  private final Personnages perso3;
  private final Personnages perso4;
  private final Objet objet_possession;
  private final Nourriture nourriture_possession;
  // list des personnages (Yacine je te laisse les ajouter je sais pas comment
  // marche final avec une instance)
  private ArrayList<Personnages> personnages;

  /**
   * Tableau contenant l'ensemble des scenarios avec choix possible.
   */
  private static ArrayList<DecisionNode> tab_DecisionNode = new ArrayList<DecisionNode>();
  /**
   * Tableau contenant l'ensemble des scenarios imposes possible.
   */
  private static ArrayList<ChanceNode> tab_scenario_impose = new ArrayList<ChanceNode>();

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

  /** Tableau contenant les scenario passées */

  private ArrayList<Integer> scenarios_passe = new ArrayList<Integer>();

  /** Tableau contenant l'indice des scenario passées */

  private ArrayList<Integer> scenarios_indice_passe = new ArrayList<Integer>();

  /**
   * Constructeur, il n'y a pas de constructeur par defaut.
   * On ne l'appelera que une fois, pour indiquer les personnages, les objets et
   * les nourritures,
   * choisi, par le joueur.
   */
  public Jour(Personnages p1, Personnages p2, Personnages p3, Personnages p4, Objet objet_possession,
      Nourriture nourriture_possession) {
    this.perso1 = p1;
    this.perso2 = p2;
    this.perso3 = p3;
    this.perso4 = p4;
    this.objet_possession = objet_possession;
    this.nourriture_possession = nourriture_possession;
    this.jours = 0;
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
    // Fonction en cours de construction
    // On devra écrire l'ensemble des scénarios et les stocker dans le tableau.

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
      boolean condition_3 = nombre_de_vivant == DecisionNode.getNombre_Personnage();
      boolean condition_4 = nombre_journee < DecisionNode.getJour_Necessaire_fin();
      boolean condition_5 = nombre_journee > DecisionNode.getJour_Necessaire_debut();

      boolean tousPresent = true;

      for (int nombre : scenarios_passe) {
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
      boolean id_peronnage_necessaire = true;
      // si aucun personnage n'est necessaire
      if (DecisionNode.get_id_peronnage_necessaire() != -1) {
        id_peronnage_necessaire = false;
        for (Personnages personne : personnages) {
          if (personne.get_perso().getIdentifiant() == DecisionNode.get_id_peronnage_necessaire()) {
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
          while (tab_DecisionNode_en_cours.size() <= jours + 1) {
            tab_DecisionNode_en_cours.add(new ArrayList<>());
          }
          tab_DecisionNode_en_cours.get(jours).add(DecisionNode.getId());
        }
      }
    }
  }

  // Retourne deux scenario avec choix a absolument rejouer a un certain jour
  // ainsi que le jour ou il faut les jouer
  private ArrayList<Integer> lancement_scenario_avec_choix() {

    return null;
  }

  // Retourne deux scenario impose a absolument rejouer a un certain jour ainsi
  // que le jour ou il faut les jouer
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
    // On gere cela de maniere aleatoire, en fonction des attributs specifique des
    // joueurs
    // En cours de construction
    Scanner scan = new Scanner(System.in);
    String input = "";
    System.out.println("Veut tu emmener quelqun en expedition, pour ramener un objet ou de la nourriture? o/n ");
    input = scan.nextLine(); // verifier si c'est bien o/n qui est entree

    if (input.equals("n")) {
      return;
    }

    System.out.println("Tu pourras choisir au plus un objet a prendre, et un personnage.");

    // Choix personnage
    // Rappeler les attributs specifiques des perso ?

    // Verifier qu'ils sont vivants, et qu'il ne sont pas en expedition
    String choix_perso = "Tu peux chosir les personages suivant : \n";
    int[] tab_aide_choix_perso = { 0, 0, 0, 0, 0 }; // changer attribut et faire un tableau de personnages ????
    // On a pas 5 perso, mais 4. Pour ne pas s'embeter avec la gestion d'indice on
    // rajoute une case de plus.

    if (perso1.get_vivant() == true && perso1.get_en_expedition() == false) {
      choix_perso = choix_perso + "1 ---> " + perso1.get_id() + "\n";
      tab_aide_choix_perso[1] = 1;
    }

    if (perso2.get_vivant() == true && perso2.get_en_expedition() == false) {
      choix_perso = choix_perso + "2 ---> " + perso2.get_id() + "\n";
      tab_aide_choix_perso[2] = 1;
    }

    if (perso3.get_vivant() == true && perso3.get_en_expedition() == false) {
      choix_perso = choix_perso + "3 ---> " + perso3.get_id() + "\n";
      tab_aide_choix_perso[3] = 1;
    }

    if (perso4.get_vivant() == true && perso4.get_en_expedition() == false) {
      choix_perso = choix_perso + "4---> " + perso4.get_id() + "\n";
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

    switch (Integer.parseInt(input)) {
      case 1:
        perso1.part_en_expedition();
      case 2:
        perso2.part_en_expedition();
      case 3:
        perso3.part_en_expedition();
      case 4:
        perso4.part_en_expedition();
    }

    // Choix objet ?
    // gerer le fait qu'on sache qui a pris quoi ?

  }

  private void nourir_perso(Personnages p1) {
    Scanner scan = new Scanner(System.in);
    String input_nourriture = "";
    String input_nombre = "";

    System.out.println("Que veut tu donner à nourir ?");
    input_nourriture = scan.nextLine();
    System.out.println("Combien en veux tu donner ?");
    System.out.println("Il y en a " + nourriture_possession.getNourriture(input_nourriture) + " de disponible.");
    input_nombre = scan.nextLine();

    while (Integer.parseInt(input_nombre) > nourriture_possession.getNourriture(input_nourriture)) {
      System.out.println("Pas assez de nourriture disponible ! Resaisir un nombre !!");
      input_nombre = scan.nextLine();
    }

    nourriture_possession.setQuantite(input_nourriture,
        nourriture_possession.getNourriture(input_nourriture) - Integer.parseInt(input_nombre));

    switch (input_nourriture) {
      case "Eau":
        perso1.maj_contextuelle_attributs_generaux_Personnages(nourriture_possession.getNourriture("Eau"), 0, 0,
            nourriture_possession.getEnergie("Eau"));
        break;
      default:
        perso1.maj_contextuelle_attributs_generaux_Personnages(0, nourriture_possession.getNourriture(input_nourriture),
            0, nourriture_possession.getEnergie(input_nourriture));
    }

    scan.close();
  }

  private void nourir_cave(){
    //En construction
    // Il faut une certaine dose de nourriture pour nourir un personnage
    // Ex : le pere doit manger plus que le frere
    Scanner scanner = new Scanner(System.in);
    String input = "";
    System.out.print("Voici les nourritures disponibles.");
    nourriture_possession.getQuantites();


    if(perso1.get_vivant() == true && perso1.get_en_expedition() == false ){
       while(true){
         System.out.print("Veux tu nourir "+perso1.get_id()+"? o/n");
         input = scanner.nextLine();

         //Verif qu'il a bien entree o ou n
         while( !(input.equals("o") || input.equals("n")) ){
           System.out.print("ATTENTION Repondre par o/n");
           System.out.print("Veux tu nourir "+perso1.get_id()+"? o/n");
           input = scanner.nextLine();
           }

         if(input.equals("n")){break;}
         this.nourir_perso(this.perso1);
       }
    }


    //ATTENTION REPLICATION DE CODE.......
    if(perso2.get_vivant() == true && perso2.get_en_expedition() == false ){
       while(true){
         System.out.print("Veux tu nourir "+perso2.get_id()+"? o/n");
         input = scanner.nextLine();

         //Verif qu'il a bien entree o ou n
         while( !(input.equals("o") || input.equals("n")) ){
           System.out.print("ATTENTION Repondre par o/n");
           System.out.print("Veux tu nourir "+perso2.get_id()+"? o/n");
           input = scanner.nextLine();
           }

         if(input.equals("n")){break;}
         this.nourir_perso(this.perso2);
       }
    }

    if(perso3.get_vivant() == true && perso3.get_en_expedition() == false){
       while(true){
         System.out.print("Veux tu nourir "+perso3.get_id()+"? o/n");
         input = scanner.nextLine();

         //Verif qu'il a bien entree o ou n
         while( !(input.equals("o") || input.equals("n")) ){
           System.out.print("ATTENTION Repondre par o/n");
           System.out.print("Veux tu nourir "+perso3.get_id()+"? o/n");
           input = scanner.nextLine();
           }

         if(input.equals("n")){break;}
         this.nourir_perso(this.perso3);
       }
    }

    if(perso4.get_vivant() == true && perso4.get_en_expedition() == false){
       while(true){
         System.out.print("Veux tu nourir "+perso4.()+"? o/n");
         input = scanner.nextLine();

         //Verif qu'il a bien entree o ou n
         while( !(input.equals("o") || input.equals("n")) ){
           System.out.print("ATTENTION Repondre par o/n");
           System.out.print("Veux tu nourir "+perso4.get_id()+"? o/n");
           input = scanner.nextLine();
           }

         if(input.equals("n")){break;}
         this.nourir_perso(this.perso4);
       }
    }

    scanner.close();
  }

  private void deroulement_du_jour() {
    // En cours de construction
    perso1.maj_naturelle_attributs_generaux_Personnages();
    perso2.maj_naturelle_attributs_generaux_Personnages();
    perso3.maj_naturelle_attributs_generaux_Personnages();
    perso4.maj_naturelle_attributs_generaux_Personnages();

    selection_scenario_avec_choix(); // On rempli l'attribut tab_DecisionNode_en_cours de scenario avec choix a jouer
    ArrayList<Integer> set_prochain_DecisionNode = lancement_scenario_avec_choix();
    // ArrayList<Integer> set_prochain_scenario_impose =
    // lancement_scenario_impose();
    // On modifie les tableaux tab_DecisionNode_en_cours et
    // tab_scenario_impose_en_cours

    perso1.maj_donnee_maladie_naturelle_Personnages();
    perso2.maj_donnee_maladie_naturelle_Personnages();
    perso3.maj_donnee_maladie_naturelle_Personnages();
    perso4.maj_donnee_maladie_naturelle_Personnages();

    nourir_cave();
    expedition();
    this.nombre_journee = this.nombre_journee + 1;
  }

}
