package Representation;

import java.util.*;
import univers.*;

public class listescenario {

    private ArrayList<DecisionNode> liste = new ArrayList<DecisionNode>();

    public listescenario() {
        ArrayList<DecisionNode> list = new ArrayList<DecisionNode>();
        Map<String, ArrayList<IntPair>> d1 = new HashMap<String, ArrayList<IntPair>>();
        ArrayList<IntPair> pairList = new ArrayList<IntPair>();

        IntPair pair = new IntPair(1, 1);
        pairList.add(pair);
        d1.put("decision", pairList);

        int[] intArray = new int[] {};

        DecisionNode D1 = new DecisionNode(0, 1, 0, 10, 0, intArray,
                "Bienvenue dans le jeux adam le chien veut venir l'accepter vous", 0, 0, 0, 0, 0, 0, 0, 1, d1, d1,
                d1, -1, 1);
        list.add(D1);

        this.liste = list;

    }

    public ArrayList<DecisionNode> getListe() {
        return liste;

    }
}
