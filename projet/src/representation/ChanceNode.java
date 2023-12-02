package Representation;
import univers.*;


public class ChanceNode extends Node{
    private int index_Evenement;
    private Personnages personnages;
    private Nourriture nouritures;
    private String nom_Aliment;
    private Objet objets;
    private String nom_Objet;

    public ChanceNode(String histoire, int index_Evenement, Personnages personnages)
    {
        super(histoire);
        this.index_Evenement = index_Evenement;
        this.personnages = personnages;
    }
        public ChanceNode(String histoire, int index_Evenement, Nourriture nouritures, String nom_Aliment)
    {
        super(histoire);
        this.index_Evenement = index_Evenement;
        this.nouritures = nouritures;
        this.nom_Aliment = nom_Aliment;
    }
    
       public ChanceNode(String histoire, int index_Evenement, Objet objets, String nom_Objet)
    {
        super(histoire);
        this.index_Evenement = index_Evenement;
        this.objets = objets;    
        this.nom_Objet = nom_Objet;
    }
    
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