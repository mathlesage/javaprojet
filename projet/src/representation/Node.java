package Representation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Serializable {
    private int id;
    protected String histoire;
    protected Map<String, ArrayList<IntPair>> dico;

    // Crée une histoire avec suite qui est contenue dans Map<String,
    // ArrayList<IntPair>> dico
    public Node(String histoire, int id, Map<String, ArrayList<IntPair>> dico) {
        this.id = id;
        this.histoire = histoire;
        this.dico = dico;
    }

    // Crée une histoire sans suite
    public Node(String histoire, int id) {
        this.id = id;
        this.histoire = histoire;
        ArrayList<IntPair> list1 = new ArrayList<>();
        list1.add(new IntPair(0, 0));
        list1.add(new IntPair(0, 0));
        this.dico = new HashMap<String, ArrayList<IntPair>>();
        dico.put("null", list1);
    }

    public String getHistoire() {
        return histoire;
    }

    public int getId() {
        return id;
    }

    public void prochain_Scenario(ArrayList<ArrayList<Integer>> decisionNodes,
            ArrayList<ArrayList<Integer>> chanceNodes, ArrayList<Integer> tab_Terminale_Node, int j) {

        if (dico.containsKey("null")) {
            return;
        }

        ArrayList<IntPair> decision = dico.get("decision");
        ArrayList<IntPair> chance = dico.get("chance");
        ArrayList<IntPair> fin = dico.get("fin");

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
        if (fin != null) {
            for (IntPair pair : fin) {
                int fin_index = j + pair.getPremier();
                while (tab_Terminale_Node.size() <= fin_index) {
                    tab_Terminale_Node.add(0);
                }

                tab_Terminale_Node.set(fin_index, pair.getDeuxieme());

            }

        }

    }
}
