package univers;

/**
Une classe implementant cette interface, aura pour role de simuler les objets/la nourriture presente ou pas dans la cave a un jour donne.
@author QUATREBOEUFS MATHEO
*/
public interface Inventaire {

    //Methode permettant d'avoir la quantite d'un objet/aliment precis
    int getQuantite(String nom);

    //Methode permettant de mettre a jour la quantite d'un objet/aliment precis
    void setQuantite(String nom, int q);

    //Methode permettant d'avoir la quantite de tout les objets/aliments
    void getQuantites();
}
