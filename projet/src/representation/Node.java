package Representation;
import Univers.Personnages;
import Univers.Objet;
import Univers.Nourriture;

public class Node{

    //Personnages Objet et Nourriture sont des varaibles qui sont passe par reference
    // On pourra donc les modifie par la suite : c'est leurs reference qui est final
    private static final Personnages p1;
    private static final Personnages p2;
    private static final Personnages p3;
    private static final Personnages p4;
    private static final  Objet objet_possession;
    private static final Nourriture nourriture_possession;
    private static  int nombre_journee = 0;

    private String description_debut_journee = "";
    private String description_expedition = "";
    private String description_scenario  = "";


    //Constructeur : pas de constructeur par defaut.
    //On ne l'appelera que une fois, pour indiquer les personnages choisi,
    //et les objets/nourritures choisi par le joeur
    public Node(Personnages p1,Personnages p2,Personnages p3,Personnages p4,Objet objet_possession,Nourriture nourriture_possession){
      this.p1 = p1;
      this.p2 = p2;
      this.p3 = p3;
      this.p4 = p4;
      this.objet_possession = objet_possession;
      this.nourriture_possession = nourriture_possession;
    }



    //Quel attributs va t-on changer ?
    // 1 -> description_debut_journee
    // 2 -> description_expedition
    // 3 -> description_scenario
    public void set_description(int n,String description){
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

    public void set_nombre_journee(){
      this.nombre_journee = this.nombre_journee + 1;
    }

    //A completer
    private static int choix_scenario(Personnages p1,Personnages p2,Personnages p3,Personnages p4,Objet o,Nourriture n){
      return 0;
    }

    //A completer avec les scenario qu'on veut
    public void scenario(){
      int numero_scenario = choix_scenario(this.p1,this.p2,this.p3,this.p4,this.objet_possession,this.nourriture_possession);

      switch(numero_scenario){
        case 1:
          break;
        case 2:
          break;
      }
    }

    //A completer : en fonction des persos, et des volonte des personnages, on peut ramener qql chose a l'exterieur
    public void Expedition(){
    }


    public void Nourir(){
      //Qui veut tu nourir ?
      //On affiche la nouriture disponible
      //On recupere qui le joeur veut nourir
      //On nourri en consequence
    }


    //Est ce que on fait une fonction qui fait le deroulement de une journee ou pas ????


}
