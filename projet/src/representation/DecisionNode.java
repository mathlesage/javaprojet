package Representation;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import univers.Objet;
import univers.Personnages;

public class DecisionNode extends Node {

    // Condition necessaire pour que le scenario s'invoque
    private float variable_Aleatoire_debut;
    private float variable_Aleatoire_fin;
    private int jour_Necessaire_debut;
    private int jour_Necessaire_fin;
    private int nombre_Peronnage;
    private int[] scenario_Necessaire;
    private int id_peronnage_necessaire;
    // Variable de chaque scenario
    private int totalmental;
    private int totalenergie;
    private int totalsante;
    private int totalforce;
    private int totalintelligence;
    private int totalresistance;
    private int totalagilite;
    private Map<String, ArrayList<IntPair>> dico1;
    private Map<String, ArrayList<IntPair>> dico2;
    private Map<String, ArrayList<IntPair>> dico3;
    // Mettre -1 si on veut une histoire sur la famille sinon mettre le numero du
    // personnage
    private int numero_perso;

    public DecisionNode(float variable_Aleatoire_debut, float variable_Aleatoire_fin, int jour_Necessaire_debut,
            int jour_Necessaire_fin, int nombre_Peronnage, int[] scenario_Necessaire, String histoire,
            int totalmental, int totalenergie, int totalsante, int totalforce, int totalintelligence,
            int totalresistance,
            int totalagilite, int id, Map<String, ArrayList<IntPair>> dico1, Map<String, ArrayList<IntPair>> dico2,
            Map<String, ArrayList<IntPair>> dico3, int id_peronnage_necessaire, int numero_perso) {
        super(histoire, id, dico1);
        this.variable_Aleatoire_debut = variable_Aleatoire_debut;
        this.variable_Aleatoire_fin = variable_Aleatoire_fin;
        this.jour_Necessaire_debut = jour_Necessaire_debut;
        this.jour_Necessaire_fin = jour_Necessaire_fin;
        this.nombre_Peronnage = nombre_Peronnage;
        this.scenario_Necessaire = scenario_Necessaire;
        this.totalmental = totalmental;
        this.totalenergie = totalenergie;
        this.totalsante = totalsante;
        this.totalforce = totalforce;
        this.totalintelligence = totalintelligence;
        this.totalresistance = totalresistance;
        this.totalagilite = totalagilite;
        this.dico1 = dico1;
        this.dico2 = dico2;
        this.dico3 = dico3;
        this.id_peronnage_necessaire = id_peronnage_necessaire;
        this.numero_perso = numero_perso;
    }

    public void raconte_histoire(ArrayList<Personnages> personnagesList, Objet objet,
            ArrayList<ArrayList<Integer>> decisionNodes,
            ArrayList<ArrayList<Integer>> chanceNodes, int j) {
        if (numero_perso > -1) {
            if (personnagesList.get(numero_perso).get_vivant()) {
                histoire = personnagesList.get(numero_perso).get_perso().getPrenom() + histoire;
            } else {
                return;
            }

        }
        super.getHistoire();
        String reponse;

        int familleMental = 0;
        int familleEnergie = 0;
        int familleSante = 0;
        int familleForce = 0;
        int familleIntelligence = 0;
        int familleResistance = 0;
        int familleAgilite = 0;

        for (Personnages personnage : personnagesList) {
            familleMental += personnage.get_barre_mentale();
            familleEnergie += personnage.get_barre_energie();
            familleSante += personnage.get_barre_sante();
            familleForce += personnage.get_force();
            familleIntelligence += personnage.get_intelligence();
            familleResistance += personnage.get_resistance();
            familleAgilite += personnage.get_agilite();
        }

        do {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("(oui/non)");
                reponse = scanner.next().toLowerCase();
            }
        } while (reponse.equals("oui") && reponse.equals("non"));
        if (reponse.equals("non")) {
            super.dico = dico1;
            // Recomponse s'il refuse le scenario
        } else {

            if (totalmental <= familleMental && totalenergie <= familleEnergie && totalsante <= familleSante
                    && totalforce <= familleForce && totalintelligence <= familleIntelligence
                    && totalresistance <= familleResistance && totalagilite <= familleAgilite) {
                super.dico = dico2;
                // Recomponse si les stats des perso sont suffisant
            } else {
                super.dico = dico3;
                // Recomponse si les stats des perso sont insuffisante
            }

        }
        super.prochain_Scenario(decisionNodes, chanceNodes, j);
    }

    // getter des conditions nescessaire pour que les scenarios soit proposer
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

    public int id_peronnage_necessaire() {
        return id_peronnage_necessaire();
    }

}
