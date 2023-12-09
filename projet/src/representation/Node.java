package Representation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Node {
    private int id;
    protected String histoire;
    protected Map<String, ArrayList<IntPair>> dico;

    public Node(String histoire, int id, Map<String, ArrayList<IntPair>> dico) {
        this.id = id;
        this.histoire = histoire;
        this.dico = dico;
    }

    public String getHistoire() {
        return histoire;
    }

    public int getId() {
        return id;
    }

    public void prochain_Scenario(ArrayList<ArrayList<Integer>> decisionNodes,
            ArrayList<ArrayList<Integer>> chanceNodes, int j) {
        ArrayList<IntPair> decision = dico.get("decision");
        ArrayList<IntPair> chance = dico.get("chance");

        if (decision != null) {
            for (IntPair pair : decision) {
                int decisionIndex = j + pair.getPremier();
                while (decisionNodes.size() <= decisionIndex) {
                    decisionNodes.add(new ArrayList<>());
                }
                decisionNodes.get(decisionIndex).add(pair.getDeuxieme());
            }
        }

        if (chance != null) {
            for (IntPair pair : chance) {
                int chanceIndex = j + pair.getPremier();
                while (chanceNodes.size() <= chanceIndex) {
                    chanceNodes.add(new ArrayList<>());
                }
                chanceNodes.get(chanceIndex).add(pair.getDeuxieme());
            }
        }
    }

}
