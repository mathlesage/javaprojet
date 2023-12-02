package Representation;
import java.util.Random;

import univers.*;


public class ChanceNode extends Node{
    private int index_Evenement;
    private Personnages personnages;
    private Nourriture nouritures;
    private String nom_Aliment;
    private Objet objets;
    private String nom_Objet;
    private int variable_0_ou_1;
    public ChanceNode(String histoire0, String histoire1, int index_Evenement, Personnages personnages) {   
        super((Math.random() < 0.5) ? histoire0 : histoire1);
        this.index_Evenement = index_Evenement ;
        this.personnages = personnages;
    }
    
        public ChanceNode(String histoire0, String histoire1, int index_Evenement, Nourriture nouritures, String nom_Aliment)
    {
        super((Math.random() < 0.5) ? histoire0 : histoire1);
        this.index_Evenement = index_Evenement;
        this.nouritures = nouritures;
        this.nom_Aliment = nom_Aliment;
    }
    
       public ChanceNode(String histoire0, String histoire1, int index_Evenement, Objet objets, String nom_Objet)
    {
        super((Math.random() < 0.5) ? histoire0 : histoire1);
       
            this.index_Evenement = index_Evenement;
        this.objets = objets;    
        this.nom_Objet = nom_Objet;
    }
    //Renvoie soit l'id soit l'id
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