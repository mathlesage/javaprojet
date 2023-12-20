package Representation;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import univers.Objet;
import univers.Personnages;

public class DecisionNode extends Node {

    // Condition necessaire pour que le scenario s'invoque
    private float variable_Aleatoire_debut;
    // pour que les scénarios ne tombent pas tous le temps au meme moment
    private float variable_Aleatoire_fin;

    private int jour_Necessaire_debut;
    // Le scénarios tombent que entre ces deux jours
    private int jour_Necessaire_fin;
    private int nombre_Peronnage;

    private int[] scenario_Necessaire;
    // les scénarios nécessaire pour que ca se lance
    private int id_peronnage_necessaire;
    // les personnages nescéssaire pour avoir le scénarios(On va crée un scénarios
    // pour chaque persos)
    private String nom_Objet_Necessaire;

    // Variable de chaque scenario
    private int totalmental;
    // Le total de l'energie de la famille doit être supèrieur à ca
    private int totalenergie;
    // Le total de la santé de la famille doit être supèrieur à ca
    private int totalsante;
    // Le total de la force de la famille doit être supèrieur à ca
    private int totalforce;
    // Le total de l'intelligence de la famille doit être supèrieur à ca
    private int totalintelligence;
    // Le total de la résistance de la famille doit être supèrieur à ca
    private int totalresistance;
    // Le total de l'agilité de la famille doit être supèrieur à ca
    private int totalagilite;
    // Récompense 1 si on refuse le scénarios

    private Map<String, ArrayList<IntPair>> dico1;
    // Récompense 2 si on accepte le scénarios mais les stats sont insuffisantes
    private Map<String, ArrayList<IntPair>> dico2;
    // Récompense 3 si on accepte le scénarios et les stats sont suffisantes
    private Map<String, ArrayList<IntPair>> dico3;
    // Mettre -1 si on veut une histoire sur la famille sinon mettre le numero du
    // personnage
    private int numero_perso;
    // pour le faire sur un numéro spéciale

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

    // Scenario sans stat
    public DecisionNode(float variable_Aleatoire_debut, float variable_Aleatoire_fin, int jour_Necessaire_debut,
            int jour_Necessaire_fin, int nombre_Peronnage, int[] scenario_Necessaire, String histoire,
            int id, Map<String, ArrayList<IntPair>> dico1, Map<String, ArrayList<IntPair>> dico2,
            int id_peronnage_necessaire, int numero_perso) {
        super(histoire, id, dico1);
        this.variable_Aleatoire_debut = variable_Aleatoire_debut;
        this.variable_Aleatoire_fin = variable_Aleatoire_fin;
        this.jour_Necessaire_debut = jour_Necessaire_debut;
        this.jour_Necessaire_fin = jour_Necessaire_fin;
        this.nombre_Peronnage = nombre_Peronnage;
        this.scenario_Necessaire = scenario_Necessaire;
        this.totalmental = 0;
        this.totalenergie = 0;
        this.totalsante = 0;
        this.totalforce = 0;
        this.totalintelligence = 0;
        this.totalresistance = 0;
        this.totalagilite = 0;

        this.dico1 = dico1;
        this.dico2 = dico2;
        this.dico3 = dico2;
        this.id_peronnage_necessaire = id_peronnage_necessaire;
        this.numero_perso = numero_perso;
    }

    // Scénario sur un personnage précis

    public void raconte_histoire(ArrayList<Personnages> personnagesList, Objet objet,
            ArrayList<ArrayList<Integer>> decisionNodes,
            ArrayList<ArrayList<Integer>> chanceNodes, int j) {
        // Si on veut faire un scénario sur un personnage unique on peut sinon mettre -1
        if (numero_perso > -1) {
            if (personnagesList.get(numero_perso).get_vivant()) {
                histoire = personnagesList.get(numero_perso).get_perso().getPrenom() + " " + histoire;
            } else {
                return;
            }

        }
        System.out.println(super.getHistoire());
        String reponse;

        int familleMental = 0;
        int familleEnergie = 0;
        int familleSante = 0;
        int familleForce = 0;
        int familleIntelligence = 0;
        int familleResistance = 0;
        int familleAgilite = 0;
        // Additionne chaque statistics de la famille pour ensuite les comparer
        for (Personnages personnage : personnagesList) {
            familleMental += personnage.get_barre_mentale();
            familleEnergie += personnage.get_barre_energie();
            familleSante += personnage.get_barre_sante();
            familleForce += personnage.get_force();
            familleIntelligence += personnage.get_intelligence();
            familleResistance += personnage.get_resistance();
            familleAgilite += personnage.get_agilite();
        }

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("(oui/non)");
            reponse = scanner.next().toLowerCase();
        } while (!reponse.equals("oui") && !reponse.equals("non"));

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

    public int get_id_peronnage_necessaire() {
        return id_peronnage_necessaire;
    }

    public String getObjetnecessaire() {
        return nom_Objet_Necessaire;
    }

}
