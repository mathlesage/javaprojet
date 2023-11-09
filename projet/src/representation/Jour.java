package representation;
import univers.*;
import java.util.ArrayList;

/** Un Jour constitue les elements dans la cave au moment d'une journee:
    -le personnage 1
    -le personnage 2
    -le personnage 3
    -le personnage 4
    -les objets en possession
    -la nourriture en possession
    -le nombre de jour passe dans la cave

    -Un tableau contenant tous les scenarios a choix possible
    -Un tableau contenant tous les scenarios a choix impose

    -Un tableau de tableau contenant à l'indice i l'ensemble des scenarios a choix qui seront joue au i-eme jour
    -Un tableau de tableau contenant à l'indice i l'ensemble des scenarios impose qui seront joue au i-eme jour


    L'etat du Node (donc de la cave), change de jour en jour (par l'utilisation de methode) :
    -On pourra nourir les personnes
    -On pourra emmener quelquns en expedition a l'exterieur pour recuperer un ou plusieurs objets
    -On proposera chaque jour qui passe, un/ou plusieurs scenario. Le choix de scenario est determine en fonction
     de l'etat des personnages, objets et nourritures en possession.


@author ABDELOUHAB Yacine et QUATREBOEUFS Matheo
@version deux_classes
*/

public class Jour{


  /** Nombre de jour passe dans la cave
  */
  private static  int nombre_journee = 0;



  //Personnages Objet et Nourriture sont des variables qui sont passe par reference
  // On pourra donc les modifie par la suite : c'est leurs reference qui est final
  private final Personnages perso1;
  private final Personnages perso2;
  private final Personnages perso3;
  private final Personnages perso4;
  private final Objet objet_possession;
  private final Nourriture nourriture_possession;



  /**Tableau contenant l'ensemble des scenarios avec choix possible.
  */
  private static ArrayList<Scenario_choix> tab_scenario_choix = new ArrayList<Scenario_choix>();
  /**Tableau contenant l'ensemble des scenarios imposes possible.
  */
  private static ArrayList<Scenario_impose> tab_scenario_impose = new ArrayList<Scenario_impose>();

  /**Tableau contenant à l'indice i, les i-eme scenario avec choix que l'on va jouer au i-eme jour
     On le construit petit a petit.
  */
  private ArrayList<ArrayList<Scenario_choix>> tab_scenario_choix_en_cours = new ArrayList<ArrayList<Scenario_choix>>();

  /**Tableau contenant à l'indice i, les i-eme scenario impose que l'on va jouer au i-eme jour
     On le construit petit a petit.
  */
  private ArrayList<ArrayList<Scenario_impose>> tab_scenario_impose_en_cours = new ArrayList<ArrayList<Scenario_impose>>();





  /**Constructeur, il n'y a pas de constructeur par defaut.
     On ne l'appelera que une fois, pour indiquer les personnages, les objets et les nourritures,
     choisi, par le joueur.
  */
  public Jour(Personnages p1,Personnages p2,Personnages p3,Personnages p4,Objet objet_possession,Nourriture nourriture_possession){
    this.perso1 = p1;
    this.perso2 = p2;
    this.perso3 = p3;
    this.perso4 = p4;
    this.objet_possession = objet_possession;
    this.nourriture_possession = nourriture_possession;
  }


  /**Parmis les scenarios avec choix disponible, il faudra chaque jour jouer un ou plusieurs scenario.
     Cette methode va modifier l'attribut tab_scenario_choix_en_cours, en rajoutant,
     les scenarios qui seront jouer a un certain jour.
     Ces scenarios avec choix sont determines grace au parametre des personnages, des objets et nourriture qu'il possede.
  */
  private void selection_scenario_avec_choix(){

  }

  //Retourne deux scenario avec choix a absolument rejouer a un certain jour ainsi que le jour ou il faut les jouer
  private ArrayList<Integer> lancement_scenario_avec_choix(){
    return null;

  }

  //Retourne deux scenario impose a absolument rejouer a un certain jour ainsi que le jour ou il faut les jouer
  private ArrayList<Integer> lancement_scenario_impose(){
    return null;
  }

  private void expedition(){
  }

  private void nourir(){
    //Qui veut tu nourir ?
    //On affiche la nouriture disponible
    //On recupere qui le joeur veut nourir
    //On nourri en consequence
  }

  private void deroulement_du_jour(){

    perso1.maj_naturelle_attributs_generaux_Personnages();
    perso2.maj_naturelle_attributs_generaux_Personnages();
    perso3.maj_naturelle_attributs_generaux_Personnages();
    perso4.maj_naturelle_attributs_generaux_Personnages();

    selection_scenario_avec_choix(); //On rempli l'attribut tab_scenario_choix_en_cours de scenario avec choix a jouer
    ArrayList<Integer> set_prochain_scenario_choix = lancement_scenario_avec_choix();
    ArrayList<Integer> set_prochain_scenario_impose =  lancement_scenario_impose();
    //On modifie les tableaux tab_scenario_choix_en_cours et tab_scenario_impose_en_cours

    nourir();
    expedition();
    this.nombre_journee = this.nombre_journee+1;
  }

}
