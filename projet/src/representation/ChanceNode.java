package Representation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import univers.*;

public class ChanceNode extends Node {
    private int index_Evenement;
    private Personnages personnages;
    private Nourriture nouritures;
    private String nom_Aliment;
    private Objet objets;
    private String nom_Objet;

    public ChanceNode(String histoire0, String histoire1, int id, Personnages personnages,
            Map<String, ArrayList<IntPair>> dico, int index_Evenement) {
        super((personnages.get_perso().getPrenom() + " " + ((Math.random() < 0.5) ? histoire0 : histoire1)), id, dico);
        this.index_Evenement = index_Evenement;
        this.personnages = personnages;

    }

    public ChanceNode(String histoire0, String histoire1, int index_Evenement, Nourriture nouritures,
            String nom_Alimentint, int id, Map<String, ArrayList<IntPair>> dico) {
        super((nom_Alimentint + " " + ((Math.random() < 0.5) ? histoire0 : histoire1)), id, dico);
        this.index_Evenement = index_Evenement;
        this.nouritures = nouritures;
        this.nom_Aliment = nom_Aliment;
    }

    public ChanceNode(String histoire0, String histoire1, int index_Evenement, Objet objets, String nom_Objet, int id,
            Map<String, ArrayList<IntPair>> dico) {

        super((nom_Objet + " " + ((Math.random() < 0.5) ? histoire0 : histoire1)), id, dico);

        this.index_Evenement = index_Evenement;
        this.objets = objets;
        this.nom_Objet = nom_Objet;
    }

    // Renvoie soit l'id soit l'id
    public int getIndex_Evenement() {
        return index_Evenement;
    }

    public Personnages getPersonnages() {
        return personnages;
    }

    public Nourriture getNouritures() {
        return nouritures;
    }

    public String getNom_Aliment() {
        return nom_Aliment;
    }

    public Objet getObjets() {
        return objets;
    }

    public String getNom_Objet() {
        return nom_Objet;
    }

}
