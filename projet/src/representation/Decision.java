package Representation ;
public class DecisionNode extends Node{


  //Constructeur
  //Gerer la redondance...
  public DecisionNode(String description,Node nextNode1){
    super(description,nextNode1);
  }
  public DecisionNode(String description,Node nextNode1,Personnages perso1, Personnages perso2,Personnages perso3,Personnages perso4,Objet objet_possede,Nourriture nourriture_possede){
    super(description,nextNode1,perso1,perso2,perso3,perso4,objet_possede,nourriture_possede);
  }
  public DecisionNode(String description,Node nextNode1,Node nextNode2,Personnages perso1, Personnages perso2,Personnages perso3,Personnages perso4,Objet objet_possede,Nourriture nourriture_possede){
    super(description,nextNode1,nextNode2,perso1,perso2,perso3,perso4,objet_possede,nourriture_possede);
  }
  public DecisionNode(String description,Node nextNode1,Node nextNode2,Node nextNode3,Personnages perso1, Personnages perso2,Personnages perso3,Personnages perso4,Objet objet_possede,Nourriture nourriture_possede){
    super(description,nextNode1,nextNode2,nextNode3,perso1,perso2,perso3,perso4,objet_possede,nourriture_possede);
  }
  public DecisionNode(String description,Node nextNode1,Node nextNode2,Node nextNode3,Node nextNode4,Personnages perso1, Personnages perso2,Personnages perso3,Personnages perso4,Objet objet_possede,Nourriture nourriture_possede){
    super(description,nextNode1,nextNode2,nextNode3,nextNode4,perso1,perso2,perso3,perso4,objet_possede,nourriture_possede);
  }


  //Reussir a gerer ensuite la redirection vers un noeud terminal si tout les personnages sont morts
  //Ici, on a juste à entrer l'entier n, correspond au noeud vers lequels on veut aller, en fonction du choix du joueur
  public Node chooseNext(int n){
    switch(n){
      case 1:
        return super.nextNode1;
        break;

      case 2:
        return super.nextNode2;
        break;

      case 3:
        return super.nextNode3;
        break;

      case 4:
        return super.nextNode4;
        break;
    }
  }

}
