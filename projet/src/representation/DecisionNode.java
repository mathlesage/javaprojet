package Representation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import univers.Objet;
import univers.Personnages;



/**Classe Decision
 * @author QUATREBOEUFS Matheo
 * */
public class DecisionNode extends Node implements Serializable {

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

    
    /** Constructeur1
     * @param variable_Aleatoire_debut Borne Superieur de la var pour jouer ce scenario
     * @param variable_Aleatoire_fin Borne Inferieur de la var pour jouer ce scenario
     * @param jour_Necessaire_debut Borne Inferieur pour pouvoir jouer le scenario
     * @param jour_Necessaire_fin Borne Superieur pour pouvoir jouer le scenario
     * @param nombre_Peronnage Nombre de personnage necessaire pour pouvoir jouer le scenario
     * @param scenario_Necessaire Scenario Necessaire pour pouvoir jouer le scenario
     * @param histoire Histoire du Scenario
     * @param totalmental Mental de Toute la famille reunit necessaire pour pouvoir Passer avec succes le scenario
     * @param totalenergie Energie de Toute la famille reunit necessaire pour pouvoir Passer avec succes le scenario
     * @param totalsante Sante de Toute la famille reunit necessaire pour pouvoir Passer avec succes le scenario
     * @param totalforce Force de Toute la famille reunit necessaire pour pouvoir Passer avec succes le scenario
     * @param totalintelligence Intelligence de Toute la famille reunit necessaire pour pouvoir Passer avec succes le scenario
     * @param totalresistance Resistance de Toute la famille reunit necessaire pour pouvoir Passer avec succes le scenario
     * @param totalagilite Agilite de Toute la famille reunit necessaire pour pouvoir Passer avec succes le scenario
     * @param id id Scenario
     * @param dico1 Prochain Scenario si on refuse le scenario
     * @param dico2 Prochain Scenario si on accepte le scenario et qu'on a les stat necessaire
     * @param dico3 Prochain Scenario si on accepte le scenario mais qu'on a pas les stat necessaire
     * @param id_peronnage_necessaire perso necessaire pour faire jouer ce scenario
     * @param numero_perso Placement du perso dans le tableau de personnage
     * 
     * */
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

    
    
    /** Constructeur2
     * @param variable_Aleatoire_debut Borne Superieur de la var pour jouer ce scenario
     * @param variable_Aleatoire_fin Borne Inferieur de la var pour jouer ce scenario
     * @param jour_Necessaire_debut Borne Inferieur pour pouvoir jouer le scenario
     * @param jour_Necessaire_fin Borne Superieur pour pouvoir jouer le scenario
     * @param nombre_Peronnage Nombre de personnage necessaire pour pouvoir jouer le scenario
     * @param scenario_Necessaire Scenario Necessaire pour pouvoir jouer le scenario
     * @param histoire Histoire du Scenario
     * @param id id Scenario
     * @param dico1 Prochain Scenario si on refuse le scenario
     * @param dico2 Prochain Scenario si on accepte le scenario et qu'on a les stat necessaires
     * @param id_peronnage_necessaire perso necessaire pour faire jouer ce scenario
     * @param numero_perso Placement du perso dans le tableau de personnage
     * 
     * */
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

    
    /** Constructeur3
     * @param jour_Necessaire_debut Borne Inferieur pour pouvoir jouer le scenario
     * @param jour_Necessaire_fin Borne Superieur pour pouvoir jouer le scenario
     * @param nombre_Peronnage Nombre de personnage necessaire pour pouvoir jouer le scenario
     * @param histoire Histoire du Scenario
     * @param id id Scenario
     * @param dico2 Prochain Scenario si on accepte le scenario et qu'on a les stat necessaire 
     * @param objet_nec Objet necessaire pour realiser le scenario avec succes
     * 
     * */
    public DecisionNode(int jour_Necessaire_debut, int jour_Necessaire_fin, String histoire, int id,
            Map<String, ArrayList<IntPair>> dico2, String objet_nec) {

        super(histoire, id, dico2);
        this.jour_Necessaire_debut = jour_Necessaire_debut;
        this.jour_Necessaire_fin = jour_Necessaire_fin;
        this.scenario_Necessaire = new int[0];

        this.variable_Aleatoire_debut = 0f;
        this.variable_Aleatoire_fin = 0.5f;
        this.nombre_Peronnage = 0;
        this.totalmental = 0;
        this.totalenergie = 0;
        this.totalsante = 0;
        this.totalforce = 0;
        this.totalintelligence = 0;
        this.totalresistance = 0;
        this.totalagilite = 0;
        this.nom_Objet_Necessaire = objet_nec;

        ArrayList<IntPair> list1 = new ArrayList<>();
        list1.add(new IntPair(0, 0));
        list1.add(new IntPair(0, 0));
        Map<String, ArrayList<IntPair>> dico_vide = new HashMap<String, ArrayList<IntPair>>();

        dico_vide.put("null", list1);
        this.dico1 = dico_vide;
        this.dico2 = dico2;
        this.dico3 = dico2;
        this.id_peronnage_necessaire = -1;
        this.numero_perso = -1;

    }

   
    /**Lance le scenario
     * */
    public void raconte_histoire(ArrayList<Personnages> personnagesList, Objet objet,
            ArrayList<ArrayList<Integer>> decisionNodes,
            ArrayList<ArrayList<Integer>> chanceNodes, ArrayList<Integer> terminalNode, int j) {
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
        super.prochain_Scenario(decisionNodes, chanceNodes, terminalNode, j);
    }

    /**Getters
     * @return VarBorneInf
     * */
    public float getVariable_Aleatoire_debut() {
        return variable_Aleatoire_debut;
    }

    /**Getters
     * @return VarBorneSup
     * */
    public float getVariable_Aleatoire_fin() {
        return variable_Aleatoire_fin;
    }

    /**Getters
     * @return JourneeBorneInf
     * */
    public int getJour_Necessaire_debut() {
        return jour_Necessaire_debut;
    }
    
    /**Getters
     * @return JourneeBorneSup
     * */
    public int getJour_Necessaire_fin() {
        return jour_Necessaire_fin;
    }

    
    /**Getters
     * @return nombre Personnage necessaire
     * */
    public int getNombre_Personnage() {
        return nombre_Peronnage;
    }

    /**Getters
     * @return Scenarios necessaire pour lance le scenario
     * */
    public int[] getScenario_Necessaire() {
        return scenario_Necessaire;
    }

    /**Getters
     * @return perso necessaire pour lance le scenario
     * */
    public int get_id_peronnage_necessaire() {
        return id_peronnage_necessaire;
    }

    /**Getters
     * @return nom de l'objet necessaire pour lance le scenario
     * */
    public String getObjetnecessaire() {
        return nom_Objet_Necessaire;
    }

}
