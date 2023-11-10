package Representation;
import univers.*;


public class Scenario_impose extends Scenario{
    int index_Evenement;
    Personnages personnages;
    Nourriture nouritures;
    String nom_Aliment;
    Objet objets;
    String nom_Objet;

    public Scenario_impose(String histoire, int index_Evenement, Personnages personnages)
    {
        super(histoire);
        this.index_Evenement = index_Evenement;
        this.personnages = personnages;
    }
        public Scenario_impose(String histoire, int index_Evenement, Nourriture nouritures, String nom_Aliment)
    {
        super(histoire);
        this.index_Evenement = index_Evenement;
        this.nouritures = nouritures;
        this.nom_Aliment = nom_Aliment;
    }
    
       public Scenario_impose(String histoire, int index_Evenement, Objet objets, String nom_Objet)
    {
        super(histoire);
        this.index_Evenement = index_Evenement;
        this.objets = objets;    
        this.nom_Objet = nom_Objet;
    }


}