package Representation;
import java.io.Serializable;



/** Classe Utilitaire pour la gestion des scenarios
 * @author QUATREBOEUFS Matheo
 * */
public class IntPair implements Serializable {
    private int premier;
    private int deuxieme;

    /**Constructeur
     * */
    public IntPair(int premier, int deuxieme) {
        this.premier = premier;
        this.deuxieme = deuxieme;
    }

    /**Getters
     * @return premier element*/
    public int getPremier() {
        return premier;
    }

    /**Setters
     * @param premier_element*/
    public void setPremier(int premier) {
        this.premier = premier;
    }

    /**Getters
     * @return deuxieme element*/
    public int getDeuxieme() {
        return deuxieme;
    }

    /**Setters
     * @param deuxieme_element*/
    public void setDeuxieme(int deuxieme) {
        this.deuxieme = deuxieme;
    }

}
