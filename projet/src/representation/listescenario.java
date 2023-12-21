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

        DecisionNode D2 = new DecisionNode(0, 0.3f, 0, 5, 0, Arrayvide,
                "veut manger des champignons qui sont dans le coins de la cave voulez vous le faire manger ces champignons ?",
                1001, dico_vide, dico_2, -1, 0);

        Map<String, ArrayList<IntPair>> dico_D3_1 = new HashMap<String, ArrayList<IntPair>>();
        ArrayList<IntPair> listD3 = new ArrayList<IntPair>();
        listD3.add(new IntPair(1, 600));
        listD3.add(new IntPair(1, 36));
        dico_D3_1.put("chance", listD3);

        DecisionNode D3 = new DecisionNode(0.8f, 1f, 3, 7, 0, Arrayvide,
                "Une petite fille toc à la porte et vous propose de l'eau, acceptez vous ?", 1002, dico_vide, dico_D3_1,
                -1, -1);

        Map<String, ArrayList<IntPair>> dico_D4_1 = new HashMap<String, ArrayList<IntPair>>();
        ArrayList<IntPair> listD4 = new ArrayList<IntPair>();
        listD4.add(new IntPair(1, 601));
        listD4.add(new IntPair(1, 3));
        dico_D4_1.put("chance", listD4);

        DecisionNode D4 = new DecisionNode(0f, 0.15f, 4, 8, 0, Arrayvide,
                "Un petite garçon toc à la porte et vous propose des pates, acceptez vous ?", 1003, dico_vide,
                dico_D4_1, -1, -1);

        list.add(D1);
        list.add(D2);
        list.add(D3);
        list.add(D4);

        this.liste = list;

    }

    public ArrayList<DecisionNode> getListe() {
        return liste;

    }
}
