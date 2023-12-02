package Representation;

import java.util.Scanner;

import univers.Objet;
import univers.Personnages;

public class DecisionNode extends Node{


    // Condition necessaire pour que le scenario s'invoque
    private float variable_Aleatoire_debut;
    private float variable_Aleatoire_fin;
    private int jour_Necessaire_debut;
    private int jour_Necessaire_fin;
    private int nombre_Peronnage;
    private int [] scenario_Necessaire;

    // Variable de chaque scenario
    private int[] recompense1 = new int[4];
    private int[] recompense2 = new int[4];
    private int[] recompense3 = new int[4];
    private int totalmental;
    private int totalenergie;
    private int totalsante;
    private int totalforce;
    private int totalintelligence;
    private int totalresistance;
    private int totalagilite;
    public DecisionNode(float variable_Aleatoire_debut,float variable_Aleatoire_fin,int jour_Necessaire_debut,int jour_Necessaire_fin,int nombre_Peronnage,int [] scenario_Necessaire,String histoire ,int[] recompense1, int[] recompense2, int[] recompense3, int[] recompense4, int totalmental, int totalenergie,int totalsante,int totalforce, int totalintelligence, int totalresistance, int totalagilite){
        super(histoire);
        this.variable_Aleatoire_debut =variable_Aleatoire_debut;
        this.variable_Aleatoire_fin =variable_Aleatoire_fin;
        this.jour_Necessaire_debut =jour_Necessaire_debut;
        this.jour_Necessaire_fin=jour_Necessaire_fin;
        this.nombre_Peronnage=nombre_Peronnage;
        this.scenario_Necessaire =scenario_Necessaire;
        this.recompense1=recompense1;
        this.recompense2=recompense2;
        this.recompense3=recompense3;
        this.totalmental=totalmental;
        this.totalenergie=totalenergie;
        this.totalsante=totalsante;
        this.totalforce=totalforce;
        this.totalintelligence=totalintelligence;
        this.totalresistance=totalresistance;
        this.totalagilite=totalagilite;
    }


    public int[] raconte_histoire(Personnages personnages1, Personnages personnages2, Personnages personnages3, Personnages personnages4, Objet objet) {
    super.getHistoire();
    String reponse;
    int familleMental = personnages1.get_barre_mentale() + personnages2.get_barre_mentale() + personnages3.get_barre_mentale() + personnages4.get_barre_mentale();
    int familleEnergie = personnages1.get_barre_energie() + personnages2.get_barre_energie() + personnages3.get_barre_energie() + personnages4.get_barre_energie();
    int familleSante = personnages1.get_barre_sante() + personnages2.get_barre_sante() + personnages3.get_barre_sante() + personnages4.get_barre_sante();
    int familleForce = personnages1.get_force() + personnages2.get_force() + personnages3.get_force() + personnages4.get_force(); 
    int familleIntelligence = personnages1.get_intelligence() + personnages2.get_intelligence() + personnages3.get_intelligence() + personnages4.get_intelligence();
    int familleResistance = personnages1.get_resistance() + personnages2.get_resistance() + personnages3.get_resistance() + personnages4.get_resistance();
    int familleAgilite = personnages1.get_agilite() + personnages2.get_agilite() + personnages3.get_agilite() + personnages4.get_agilite();
    do{
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("(oui/non)");
            reponse = scanner.next().toLowerCase();
        }
    }while(reponse.equals("oui") && reponse.equals("non"));
    if (reponse.equals("non")){
        return recompense1;
        //Recomponse s'il refuse le scenario
    }
    else
    {
        
        if(totalmental <= familleMental && totalenergie <= familleEnergie && totalsante <= familleSante && totalforce <= familleForce && totalintelligence <= familleIntelligence && totalresistance <= familleResistance && totalagilite <= familleAgilite){
            return recompense3;
            //Recomponse si les stats des perso sont suffisant
    }else
    {
        return recompense2;
         //Recomponse si les stats des perso sont insuffisante
    }

}
}

//getter des conditions nescessaire pour que les scenarios soit proposer
public float getVariable_Aleatoire_debut() {
    return variable_Aleatoire_debut;
}

public float getVariable_Aleatoire_fin() {
    return variable_Aleatoire_fin;
}

public int getJour_Necessaire_debut() {
    return jour_Necessaire_debut;
}

public int getJour_Necessaire_fin() {
    return jour_Necessaire_fin;
}

public int getNombre_Personnage() {
    return nombre_Peronnage;
}

public int[] getScenario_Necessaire() {
    return scenario_Necessaire;
}

    
}
