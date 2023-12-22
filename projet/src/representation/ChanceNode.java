package Representation;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import univers.*;


/**Classe ChanceNode
 * @author QUATREBOEUFS Matheo
 * */
public class ChanceNode extends Node implements Serializable {
    private int index_Evenement;
    private Personnages personnages;
    private Nourriture nouritures;
    private String nom_Aliment;
    private Objet objets;
    private String nom_Objet;
    private int numero_perso;

    
    
    /**Deux récit différent avec 1 chance sur 2 de tomber sur l'un ou l'autre modifie un personnage et peux ammener de nouveau scénario
     * @param histoire0 Premiere Histoire possible
     * @param histoire1 Seconde Histoire possible
     * @param id Id du Node
     * @param personnages Personnage sur qui sera affecter le scenario
     * @param dico suite de l'histoire
     * @param index_Evenement id evenement
     * */

    public ChanceNode(String histoire0, String histoire1, int id, Personnages personnages,
            Map<String, ArrayList<IntPair>> dico, int index_Evenement) {

        super((personnages.get_perso().getPrenom() + " " + ((Math.random() < 0.5) ? histoire0 : histoire1)), id, dico);
        this.index_Evenement = index_Evenement;
        this.personnages = personnages;
        this.numero_perso = -1;

    }

    
    /** modifie un aliment ammener de nouveau scénario
     * @param histoire0 Premiere Histoire possible
     * @param histoire1 Seconde Histoire possible
     * @param id Id du Node
     * @param nom_Alimentint Aliment sur qui sera affecter le scenario
     * @param dico suite de l'histoire
     * @param index_Evenement Quand va t on jouer le prochain evenement ?
     * */
    public ChanceNode(String histoire0, String histoire1, int index_Evenement, String nom_Alimentint, int id,
            Map<String, ArrayList<IntPair>> dico) {
        super((nom_Alimentint + " " + ((Math.random() < 0.5) ? histoire0 : histoire1)), id, dico);
        this.index_Evenement = index_Evenement;

        this.nom_Aliment = nom_Alimentint;
        this.numero_perso = -1;

    }

    
    /** modifie un objet et ammener de nouveau scénario
     * @param histoire0 Premiere Histoire possible
     * @param histoire1 Seconde Histoire possible
     * @param id Id du Node
     * @param nom_Alimentint Aliment sur qui sera affecter le scenario
     * @param dico suite de l'histoire
     * @param index_Evenement Quand va t on jouer le prochain evenement ?
     * */
    public ChanceNode(String histoire0, String histoire1, int index_Evenement, Objet objets, String nom_Objet, int id,
            Map<String, ArrayList<IntPair>> dico) {

        super((nom_Objet + " " + ((Math.random() < 0.5) ? histoire0 : histoire1)), id, dico);

        this.index_Evenement = index_Evenement;
        this.objets = objets;
        this.nom_Objet = nom_Objet;
        this.numero_perso = -1;
    }

    
    /** modifie un objet et ammener de nouveau scénario
     * @param histoire0 Premiere Histoire possible
     * @param histoire1 Seconde Histoire possible
     * @param id Id du Node
     * @param numero_Perso idPerso sur qui sera affecter le scenario
     * @param index_Evenement Quand va t on jouer le prochain evenement ?
     * */
    public ChanceNode(String histoire0, String histoire1, int id, int index_Evenement, int numero_perso) {
        super(((Math.random() < 0.5) ? histoire0 : histoire1), id);
        this.index_Evenement = index_Evenement;
        this.numero_perso = numero_perso;
    }

    
    /** Scénarios qui changent un aliments
     * @param histoire0 Premiere Histoire possible
     * @param histoire1 Seconde Histoire possible
     * @param id Id du Node
     * @param nom_Aliment int Aliment sur qui sera affecter le scenario
     * @param index_Evenement Quand va t on jouer le prochain evenement ?
     * */
    public ChanceNode(String histoire0, String histoire1, int id, int index_Evenement, String nom_Aliment) {
        super(((Math.random() < 0.5) ? histoire0 : histoire1), id);
        this.index_Evenement = index_Evenement;
        this.nom_Aliment = nom_Aliment;
        this.numero_perso = -1;

    }

    
    
    
    /**Getters
     * @return index evenement*/
    public int getIndex_Evenement() {
        return index_Evenement;
    }

    /**Getters
     * @return personnages*/
    public Personnages getPersonnages() {
        return personnages;
    }

    /**Getters
     * @return nourritures*/
    public Nourriture getNouritures() {
        return nouritures;
    }

    /**Getters
     * @return nom aliment*/
    public String getNom_Aliment() {
        return nom_Aliment;
    }

    /**Getters
     * @return objtes*/
    public Objet getObjets() {
        return objets;
    }

    /**Getters
     * @return nom obet*/
    public String getNom_Objet() {
        return nom_Objet;
    }

    /**Getters
     * @return numero (id) du personnage*/
    public int getNum_perso() {
        return numero_perso;
    }

}
