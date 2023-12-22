package univers;

/**
Une classe implementant cette interface, aura pour role de simuler les objets/la nourriture presente ou pas dans la cave a un jour donne.
@author QUATREBOEUFS MATHEO
*/
public interface Inventaire  {

    /**Methode permettant d'avoir la quantite d'un objet/aliment precis
     * @param nom Nom de l'objet/aliment
     * @return Quantite de l'objet/aliment*/
    int getQuantite(String nom);

    /**Methode permettant de mettre a jour la quantite d'un objet/aliment precis
     * @param nom Nom de l'objet/aliment
     * @param q quanite a mettre a jour
     * */
    void setQuantite(String nom, int q);

    /**Methode permettant de decrire les objets/aliments disponible ainsi que leur quantite
     * */
    void getQuantites();
}
