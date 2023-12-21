package Representation;

import java.io.Serializable;
import java.util.*;
import univers.*;

public class listescenario implements Serializable {

    private ArrayList<DecisionNode> liste = new ArrayList<DecisionNode>();

    public listescenario() {
        ArrayList<DecisionNode> list = new ArrayList<DecisionNode>();
        Map<String, ArrayList<IntPair>> d1 = new HashMap<String, ArrayList<IntPair>>();
        ArrayList<IntPair> pairList = new ArrayList<IntPair>();

        ArrayList<IntPair> list1 = new ArrayList<>();
        list1.add(new IntPair(0, 0));
        list1.add(new IntPair(0, 0));
        Map<String, ArrayList<IntPair>> dico_vide = new HashMap<String, ArrayList<IntPair>>();
        dico_vide.put("null", list1);

        IntPair pair = new IntPair(1, 1);
        pairList.add(pair);
        d1.put("decision", pairList);

        int[] Arrayvide = new int[] {};

        DecisionNode D1 = new DecisionNode(0, 1, 9, 10, 0, Arrayvide,
                "Bienvenue dans le jeux adam le chien veut venir l'accepter vous", 0, 0, 0, 0, 0, 0, 0, 1000, d1, d1,
                d1, -1, 1);

        // Sniffer du champignon
        ArrayList<IntPair> listD2 = new ArrayList<>();
        listD2.add(new IntPair(1, 211));
        Map<String, ArrayList<IntPair>> dico_2 = new HashMap<String, ArrayList<IntPair>>();
        dico_2.put("chance", listD2);
        DecisionNode D2 = new DecisionNode(0, 1, 0, 5, 0, Arrayvide,
                "veut manger des champignons qui sont dans le coins de la cave voulez vous le faire manger ces champignons ?",
                1001, dico_vide, dico_2, -1, 0);

        list.add(D1);
        list.add(D2);

        this.liste = list;

    }

    public ArrayList<DecisionNode> getListe() {
        return liste;

    }
}
