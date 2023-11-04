package Representation ;
import Univers;


public abstract class Node{

    //Attribut de la classe Node
    private String description;
    private final int id_Node;
    private static int nbr_Node = 0;
    private Node nextNode1;
    private Node nextNode2;
    private Node nextNode3;
    private Node nextNode4;


    private final static Personnages perso1;
    private final static Personnages perso2;
    private final static Personnages perso3;
    private final static Personnages perso4;
    private final static Objet objet_possede;
    private final static Nourriture nourriture_possede;

    //Attention pas de constructeur par defaut...
    //Gerer la redondance
    public Node(String description,Node nextNode1,Node nextNode2,Node nextNode3,Node nextNode4){
      this.description = description;
      this.nbr_Node = nbr_Node + 1;
      this.id_Node = nbr_Node;
      this.tab_next_Node = args;
      this.nextNode1 = nextNode1;
      this.nextNode2 = nextNode2;
      this.nextNode3 = nextNode3;
      this.nextNode4 = nextNode4;

    }
    public Node(String description,Node nextNode1,Node nextNode2,Node nextNode3){
      this.description = description;
      this.nbr_Node = nbr_Node + 1;
      this.id_Node = nbr_Node;
      this.tab_next_Node = args;
      this.nextNode1 = nextNode1;
      this.nextNode2 = nextNode2;
      this.nextNode3 = nextNode3;
    }
    public Node(String description,Node nextNode1,Node nextNode2){
      this.description = description;
      this.nbr_Node = nbr_Node + 1;
      this.id_Node = nbr_Node;
      this.tab_next_Node = args;
      this.nextNode1 = nextNode1;
      this.nextNode2 = nextNode2;
    }
    public Node(String description,Node nextNode1){
      this.description = description;
      this.nbr_Node = nbr_Node + 1;
      this.id_Node = nbr_Node;
      this.tab_next_Node = args;
      this.nextNode1 = nextNode1;
    }
    public Node(String description,Node nextNode1,Node nextNode2,Node nextNode3,Node nextNode4,Personnages perso1, Personnages perso2,Personnages perso3,Personnages perso4,Objet objet_possede,Nourriture nourriture_possede){
      this.description = description;
      this.nbr_Node = nbr_Node + 1;
      this.id_Node = nbr_Node;
      this.tab_next_Node = args;
      this.nextNode1 = nextNode1;
      this.nextNode2 = nextNode2;
      this.nextNode3 = nextNode3;
      this.nextNode4 = nextNode4;
      this.perso1 = perso1;
      this.perso2 = perso2;
      this.perso3 = perso3;
      this.perso4 = perso4;
      this.objet_possede = objet_possede;
      this.nourriture_possede = nourriture_possede;
    }
    public Node(String description,Node nextNode1,Node nextNode2,Node nextNode3,Personnages perso1, Personnages perso2,Personnages perso3,Personnages perso4,Objet objet_possede,Nourriture nourriture_possede){
      this.description = description;
      this.nbr_Node = nbr_Node + 1;
      this.id_Node = nbr_Node;
      this.tab_next_Node = args;
      this.nextNode1 = nextNode1;
      this.nextNode2 = nextNode2;
      this.nextNode3 = nextNode3;
      this.perso1 = perso1;
      this.perso2 = perso2;
      this.perso3 = perso3;
      this.perso4 = perso4;
      this.objet_possede = objet_possede;
      this.nourriture_possede = nourriture_possede;
    }
    public Node(String description,Node nextNode1,Node nextNode2,Personnages perso1, Personnages perso2,Personnages perso3,Personnages perso4,Objet objet_possede,Nourriture nourriture_possede){
      this.description = description;
      this.nbr_Node = nbr_Node + 1;
      this.id_Node = nbr_Node;
      this.tab_next_Node = args;
      this.nextNode1 = nextNode1;
      this.nextNode2 = nextNode2;
      this.perso1 = perso1;
      this.perso2 = perso2;
      this.perso3 = perso3;
      this.perso4 = perso4;
      this.objet_possede = objet_possede;
      this.nourriture_possede = nourriture_possede;
    }
    public Node(String description,Node nextNode1,Personnages perso1, Personnages perso2,Personnages perso3,Personnages perso4,Objet objet_possede,Nourriture nourriture_possede){
      this.description = description;
      this.nbr_Node = nbr_Node + 1;
      this.id_Node = nbr_Node;
      this.tab_next_Node = args;
      this.nextNode1 = nextNode1;

      this.perso1 = perso1;
      this.perso2 = perso2;
      this.perso3 = perso3;
      this.perso4 = perso4;
      this.objet_possede = objet_possede;
      this.nourriture_possede = nourriture_possede;
    }


    public void display(){
      System.out.println(this.description);
    }
    public Node chooseNext();

}
