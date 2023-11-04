package Representation ;
public class InnerNode extends Node{

  public InnerNode(String description,Node nextNode1){
    super(description,nextNode1);
  }
  public InnerNode(String description,Node nextNode1,Personnages perso1, Personnages perso2,Personnages perso3,Personnages perso4,Objet objet_possede,Nourriture nourriture_possede){
    super(description,nextNode1,perso1,perso2,perso3,perso4,objet_possede,nourriture_possede);
  }

  public Node chooseNext(){
    return super.nextNode1;
  }

}
