package univers;

import java.io.Serializable;

/**
 * Classe Un_element decrit un element du jeu, et combien il y en a.
 * 
 * @author ABDELOUHAB Yacine et QUATREBOEUFS Matheo
 */

public class Un_element implements Serializable {

  private Elements_du_jeu element;
  private int quantite;

  /**
   * Constructeurs
   * */
  public Un_element(Elements_du_jeu element, int quantite) {
    this.element = element;
    this.quantite = quantite;
  }

  
  /**Getters
   * @return Nom de l'element*/
  public String getNom() {
    return this.element.getNom();
  }

  /**
   * Getters
   * @return Quantite de l'element */
  public int getQuantite() {
    return this.quantite;
  }

  /**Setters
   * @param quantite Cmb veut tu mettre en quantite ?
   * @throws ArithmeticException Probleme si quantite negative
   */
  public void setQuantite_total(int quantite) throws ArithmeticException {

    if (quantite < 0) {
      throw new ArithmeticException("Ouf, il y en a deja 0 " + this.element.getNom() + " !");
    }
    this.quantite = quantite;
  }

  
  /**Setters
   * @param quantite cmb veut tu rajouter?
   */
  public void setQuantite(int quantiter) {
    int nouvelle = quantiter + this.quantite;
    setQuantite_total(nouvelle);

  }

  /**Getters
   * @return Energie de l'element*/
  public int getEnergie() {
    return this.element.getEnergie();
  }

  /**Getters
   * @return Pouvoir Nourissant de l'element*/
  public int getNourrissant() {
    return this.element.getNourrissant();
  }

  /**Getters
   * @return Pouvoir Hydratant de l'element*/
  public int getHydratation() {
    return this.element.getHydratation();
  }

}
