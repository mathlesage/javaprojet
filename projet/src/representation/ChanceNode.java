package Representation ;
public class ChanceNode extends Node{

  //Constructeur
  //Gerer la redondance...
  public ChanceNode(String description,Node nextNode1){
    super(description,nextNode1);
  }
  public ChanceNode(String description,Node nextNode1,Personnages perso1, Personnages perso2,Personnages perso3,Personnages perso4,Objet objet_possede,Nourriture nourriture_possede){
    super(description,nextNode1,perso1,perso2,perso3,perso4,objet_possede,nourriture_possede);
  }
  public ChanceNode(String description,Node nextNode1,Node nextNode2,Personnages perso1, Personnages perso2,Personnages perso3,Personnages perso4,Objet objet_possede,Nourriture nourriture_possede){
    super(description,nextNode1,nextNode2,perso1,perso2,perso3,perso4,objet_possede,nourriture_possede);
  }
  public ChanceNode(String description,Node nextNode1,Node nextNode2,Node nextNode3,Personnages perso1, Personnages perso2,Personnages perso3,Personnages perso4,Objet objet_possede,Nourriture nourriture_possede){
    super(description,nextNode1,nextNode2,nextNode3,perso1,perso2,perso3,perso4,objet_possede,nourriture_possede);
  }
  public ChanceNode(String description,Node nextNode1,Node nextNode2,Node nextNode3,Node nextNode4,Personnages perso1, Personnages perso2,Personnages perso3,Personnages perso4,Objet objet_possede,Nourriture nourriture_possede){
    super(description,nextNode1,nextNode2,nextNode3,nextNode4,perso1,perso2,perso3,perso4,objet_possede,nourriture_possede);
  }

  //Plusieurs Loi de variable aleatoire que l'on utilisera
  private int loi_alea1(){
    return 0;
  }
  private int loi_alea2(){
    return 0;
  }

  // ici le n correspond à la loi que l'on veut utiliser
  public Node chooseNext(int n){

    //On genere le nombre aleatoire que l'on veut, represente le noeud a chosisir
    int nbr_aleatoire;
    switch(n){
      case 1:
        nbr_aleatoire = loi_alea1();
        break;

      case 2:
        nbr_aleatoire = loi_alea2();
        break;
    }

    //Puis on choisi le noeud qu'on veut
    switch(nbr_aleatoire){
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
