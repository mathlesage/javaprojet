package Representation;

import java.util.ArrayList;

public class ListeChancenode {

    private ArrayList<ChanceNode> liste = new ArrayList<ChanceNode>();

    public ListeChancenode() {
        ChanceNode chance = new ChanceNode("Blablabla", "bloubloublou", 2, "Banane", 2);
        liste.add(chance);
    }

    public ArrayList<ChanceNode> getListe() {
        return liste;
    }
}