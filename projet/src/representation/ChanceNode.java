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

    // Deux récit différent avec 1 chance sur 2 de tomber sur l'un ou l'autre
    // modifie un personnage
    public ChanceNode(String histoire0, String histoire1, int id, Personnages personnages,
            Map<String, ArrayList<IntPair>> dico, int index_Evenement) {

        super((personnages.get_perso().getPrenom() + " " + ((Math.random() < 0.5) ? histoire0 : histoire1)), id, dico);
        this.index_Evenement = index_Evenement;
        this.personnages = personnages;

    }

    // modifie un aliment
    public ChanceNode(String histoire0, String histoire1, int index_Evenement, Nourriture nouritures,
            String nom_Alimentint, int id, Map<String, ArrayList<IntPair>> dico) {
        super((nom_Alimentint + " " + ((Math.random() < 0.5) ? histoire0 : histoire1)), id, dico);
        this.index_Evenement = index_Evenement;
        this.nouritures = nouritures;
        this.nom_Aliment = nom_Aliment;
    }

    // modifie un objet
    public ChanceNode(String histoire0, String histoire1, int index_Evenement, Objet objets, String nom_Objet, int id,
            Map<String, ArrayList<IntPair>> dico) {

        super((nom_Objet + " " + ((Math.random() < 0.5) ? histoire0 : histoire1)), id, dico);

        this.index_Evenement = index_Evenement;
        this.objets = objets;
        this.nom_Objet = nom_Objet;
    }

    // Renvoie l'index evenement
    public int getIndex_Evenement() {
        return index_Evenement;
    }

    // Renvoie un personnage
    public Personnages getPersonnages() {
        return personnages;
    }

    // renvoie la nourriture
    public Nourriture getNouritures() {
        return nouritures;
    }

    // renvoie l'aliment
    public String getNom_Aliment() {
        return nom_Aliment;
    }

    // renvoie l'objet
    public Objet getObjets() {
        return objets;
    }

    // renvoie le nom de l'objet
    public String getNom_Objet() {
        return nom_Objet;
    }

}
