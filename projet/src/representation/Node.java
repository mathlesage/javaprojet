package Representation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**Classe Abstraite Node
 * */
public abstract class Node implements Serializable {
    private int id;
    protected String histoire;
    protected Map<String, ArrayList<IntPair>> dico;


    /**Constrcuteur Permettant de creer une histoire avec suite.
     * @param dico Contient la suite de l'histoire
     * */
    public Node(String histoire, int id, Map<String, ArrayList<IntPair>> dico) {
        this.id = id;
        this.histoire = histoire;
        this.dico = dico;
    }

    /**Constrcuteur Permettant de creer une histoire sans suite.
     * 
     * */
    public Node(String histoire, int id) {
        this.id = id;
        this.histoire = histoire;
        ArrayList<IntPair> list1 = new ArrayList<>();
        list1.add(new IntPair(0, 0));
        list1.add(new IntPair(0, 0));
        this.dico = new HashMap<String, ArrayList<IntPair>>();
        dico.put("null", list1);
    }

    
    /**Getters
     * @return chaine de caractere avec l'histoire
     * */
    public String getHistoire() {
        return histoire;
    }

    /**Getters
     *@return Id du Node*/
    public int getId() {
        return id;
    }

    
    /**
     */
    public void prochain_Scenario(ArrayList<ArrayList<Integer>> decisionNodes,
            ArrayList<ArrayList<Integer>> chanceNodes, int j) {

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
                System.out.println(chanceIndex);
                System.out.println(pair.getDeuxieme());
                chanceNodes.get(chanceIndex).add(pair.getDeuxieme());
            }

        }
        if (fin != null) {

        }
    }

}
