package Representation;

import java.io.Serializable;

public class IntPair implements Serializable {
    private int premier;
    private int deuxieme;

    public IntPair(int premier, int deuxieme) {
        this.premier = premier;
        this.deuxieme = deuxieme;
    }

    public int getPremier() {
        return premier;
    }

    public void setPremier(int premier) {
        this.premier = premier;
    }

    public int getDeuxieme() {
        return deuxieme;
    }

    public void setDeuxieme(int deuxieme) {
        this.deuxieme = deuxieme;
    }
}
