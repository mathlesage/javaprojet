package Representation;
import Univers.Personnages;
import Univers.Objet;
import Univers.Nourriture;

/** Un Node constitue les elements dans la cave :
    -le personnage 1
    -le personnage 2
    -le personnage 3
    -le personnage 4
    -les objets en possession
    -la nourriture en possession
    -le nombre de jour passe dans la cave
    (cela constitue en parti les attributs de la classe)


    L'etat du Node (donc de la cave), change de jour en jour (par l'utilisation de methode) :
    -On pourra nourir les personnes
    -On pourra emmener quelquns en expedition a l'exterieur pour recuperer un ou plusieurs objets
    -On proposera chaque jour qui passe, un certain scenario. Le choix de scnerio est determine en fonction
     de l'etat de du Node (donc de la cave).


@author ABDELOUHAB Yacine
@version une_seul_classe
*/


public class Node{

    //Personnages Objet et Nourriture sont des variables qui sont passe par reference
    // On pourra donc les modifie par la suite : c'est leurs reference qui est final

    private final Personnages p1;
    private final Personnages p2;
    private final Personnages p3;
    private final Personnages p4;
    private final Objet objet_possession;
    private final Nourriture nourriture_possession;

    /** Nombre de jour passe dans la cave
    */
    private static  int nombre_journee = 0; //Determine ensuite un nombre de jour max

    private String description_debut_journee = "";
    private String description_expedition = "";
    private String description_scenario  = "";




    /**Constructeur, il n'y a pas de constructeur par defaut.
       On ne l'appelera que une fois, pour indiquer les personnages, les objets et les nourritures,
       choisi, par le joueur.
    */
    public Node(Personnages p1,Personnages p2,Personnages p3,Personnages p4,Objet objet_possession,Nourriture nourriture_possession){
      this.p1 = p1;
      this.p2 = p2;
      this.p3 = p3;
      this.p4 = p4;
      this.objet_possession = objet_possession;
      this.nourriture_possession = nourriture_possession;
    }

    /**Mettre a jour les attributs de description
      @param n  1:description_debut_journee    2:description_expedition   3:description_scenario
    */
    private void set_description(int n,String description){
      switch(n){
        case 1 :
            this.description_debut_journee = description;
            break;
        case 2 :
            this.description_expedition = description;
            break;
        case 3:
            this.description_scenario = description;
            break;
      }
    }
    private void set_nombre_journee(){
      this.nombre_journee = this.nombre_journee + 1;
    }


    //A completer On va ici, choisir le scenario qu'il faut en fonction des personnages/objet/nourriture que l'on possede
    private static int choix_scenario(Personnages p1,Personnages p2,Personnages p3,Personnages p4,Objet o,Nourriture n){
      return 0;
    }

    //A completer avec les scenario qu'on veut
    private void scenario(){
      int numero_scenario = choix_scenario(this.p1,this.p2,this.p3,this.p4,this.objet_possession,this.nourriture_possession);

      switch(numero_scenario){
        case 1:
          break;
        case 2:
          break;
      }
    }

    //A completer : en fonction des persos, et des volonte des personnages, on peut ramener qql chose a l'exterieur
    private void expedition(){
    }


    private void nourir(){
      //Qui veut tu nourir ?
      //On affiche la nouriture disponible
      //On recupere qui le joeur veut nourir
      //On nourri en consequence
    }

    //On fait le deroulement d'une journee
    public void deroulement_jour(){
    }


}
