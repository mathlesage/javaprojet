package Representation ;
public class TerminalNode extends Node{
  public TerminalNode(String description,Node nextNode1,Node nextNode2,Node nextNode3,Node nextNode4){
    super(description,nextNode1,nextNode2,nextNode3,nextNode4);
  }
  public TerminalNode(String description,Node nextNode1,Node nextNode2,Node nextNode3,Node nextNode4,Personnages perso1, Personnages perso2,Personnages perso3,Personnages perso4,Objet objet_possede,Nourriture nourriture_possede){
    super(description,nextNode1,nextNode2,nextNode3,nextNode4,perso1,perso2,perso3,perso4,objet_possede,nourriture_possede);
  }
  public TerminalNode chooseNext(){
      return this
  }
}
