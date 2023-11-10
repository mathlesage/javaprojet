package Representation;

import java.util.Scanner;

import univers.Objet;
import univers.Personnages;

public class Scenario_choix extends Scenario{
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
    public Scenario_choix(String histoire,int[] recompense1, int[] recompense2, int[] recompense3, int[] recompense4, int totalmental, int totalenergie,int totalsante,int totalforce, int totalintelligence, int totalresistance, int totalagilite){
        super(histoire);
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
    }
    else
    {
        if(totalmental <= familleMental && totalenergie <= familleEnergie && totalsante <= familleSante && totalforce <= familleForce && totalintelligence <= familleIntelligence && totalresistance <= familleResistance && totalagilite <= familleAgilite){
            return recompense3;
    }else
    {
        return recompense2;
    }

}
}

    
}
