package Representation;

import java.util.ArrayList;

public class ListeChancenode {

    private ArrayList<ChanceNode> liste = new ArrayList<ChanceNode>();

    public ListeChancenode() {

        // Modifier une banane
        ChanceNode chance = new ChanceNode("blblblbbl", "blblblblb", 3, 1, "Pate");
        liste.add(chance);
    }

    public ArrayList<ChanceNode> getListe() {
        return liste;
    }

}