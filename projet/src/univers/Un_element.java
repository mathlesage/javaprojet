package univers;


/**
  Classe decrivant un element du jeu, et combien il y en a.
  @author ABDELOUHAB Yacine et QUATREBOEUFS Matheo
*/

public class Un_element {

    private Elements_du_jeu element;
    private int quantite;

    public Un_element(Elements_du_jeu element, int quantite) {
        this.element = element;
        this.quantite = quantite;
      }

    public String getNom() {
        return this.element.getNom();
    }

    public int getQuantite() {
        return this.quantite;
    }

    /* Le setter de la variable quantité avec une vérification que la variable soit bien > 0*/
    public void setQuantite(int quantite) throws ArithmeticException{

      if (quantite < 0) {
          throw new ArithmeticException("Une quantite ne peut pas etre negative ! ");
      }
      this.quantite = quantite;

    }

    public int getEnergie(){
      return this.element.getEnergie();
    }

    public int getNourrissant(){
      return this.element.getNourrissant();
    }

    public int getHydratation(){
      return this.element.getHydratation();
    }

}
