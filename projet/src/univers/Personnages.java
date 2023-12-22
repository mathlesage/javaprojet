package univers;

import java.io.Serializable;
import java.util.Random;

/**
 * Un personnage du jeu est un Personnages avec plusieurs attribus :
 * des attributs generaux, des attributs specifiques et quelques autres.
 * Le joueur commencera avec 4 joueurs de son choix. On a 8 types de
 * personnages differents tous enumerer dans Personnages_du_jeu.
 * 
 * @author ABDELOUHAB Yacine
 * @version 2
 */
public class Personnages implements Serializable {

  private Personnages_du_jeu perso;

  /**
   * Indique si le personnage est en expedition ou pas.
   */
  private boolean en_expedition = false;

  /*--------------------
  - ATTRIBUTS GENERAUX -
  ---------------------*/

  /** Attribut general : Hydratation */
  private int barre_eau = 100;

  /** Attribut general : Faim */
  private int barre_nourriture = 100;

  /** Attribut general : Mental */
  private int barre_mentale = 100;

  /** Attribut general : Energie */
  private int barre_energie = 100;

  /** Attribut general : Moyenne des autre attributs */
  private int barre_sante = 100;

  /*-------------------------------------------------
  - ATTRIBUTS SPECIFIQUE a chaque personnage du jeu -
  -------------------------------------------------*/
  // NB : on ne met pasles attributs en final : pourront bouger tout au long du
  // jeu

  /** Attribut specifique au personnage */
  private int force;
  /** Attribut specifique au personnage */
  private int conso_nourriture;
  /** Attribut specifique au personnage */
  private int intelligence;
  /** Attribut specifique au personnage */
  private int resistance;
  /** Attribut specifique au personnage */
  private int agilite;

  /**
   * Etat global du personnage : resume de la barre sante et si il est vivant ou
   * pas
   */
  private Etat_Personnages etat_global = Etat_Personnages.Vigoureux;

  /** Personnage malade ou pas ? */
  private Etat_Personnages etat_malade = Etat_Personnages.PasMalade;
  /** Etat mentale du personnage : Si Fou debloque evenement incontrole */
  private Etat_Personnages etat_mentale = Etat_Personnages.Heureux;

  /** Etat de fatigue du personnage */
  private Etat_Personnages etat_energie = Etat_Personnages.Repose;
  private int temps_malade_virus = 0;

  /**
   * Un seul Constructeur : quel personnage choisis t on?
   */
  public Personnages(Personnages_du_jeu perso) {

    switch (perso) {

      case Pere:
        this.perso = perso;
        this.force = 8;
        this.conso_nourriture = 8;
        this.intelligence = 5;
        this.resistance = 5;
        this.agilite = 3;
        break;

      case Mere:
        this.perso = perso;
        this.force = 6;
        this.conso_nourriture = 4;
        this.intelligence = 8;
        this.resistance = 8;
        this.agilite = 6;
        break;

      case Soeur:
        this.perso = perso;
        this.force = 3;
        this.conso_nourriture = 2;
        this.intelligence = 5;
        this.resistance = 4;
        this.agilite = 5;
        break;

      case Frere:
        this.perso = perso;
        this.force = 10;
        this.conso_nourriture = 1;
        this.intelligence = 9;
        this.resistance = 8;
        this.agilite = 10;
        break;

      case Medecin:
        this.perso = perso;
        this.force = 6;
        this.conso_nourriture = 6;
        this.intelligence = 8;
        this.resistance = 5;
        this.agilite = 5;
        break;

      case Athlete:
        this.perso = perso;
        this.force = 10;
        this.conso_nourriture = 8;
        this.intelligence = 6;
        this.resistance = 10;
        this.agilite = 10;
        break;

      case Cousin:
        this.perso = perso;
        this.force = 5;
        this.conso_nourriture = 3;
        this.intelligence = 5;
        this.resistance = 10;
        this.agilite = 7;
        break;

      case Cuisiniere:
        this.perso = perso;
        this.force = 7;
        this.conso_nourriture = 8;
        this.intelligence = 5;
        this.resistance = 7;
        this.agilite = 3;
        break;
    }
  }

  /**
   * Donne une description des attribus generaux des personnages
   */
  public void to_String_Generaux() {

    System.out.println("------------------------------");
    if (this.etat_global != Etat_Personnages.Mort) {
      System.out.print(this.perso.name() + " => " + this.perso.getPrenom() + " est vivant(e).\n" + "	"
          + this.etat_global.name() + "\n"
          + "	" + this.etat_malade.name() + "\n" + "	" + this.etat_mentale.name());
      System.out.println("\n------ATTRIBUTS GENERAUX------\n" + "Hydratation : " + this.barre_eau + "\nSassiete : "
          + this.barre_nourriture + "\nMental : " + this.barre_mentale + "\nEnergie : " + this.barre_energie
          + "\nSante General : " + this.barre_sante);
    } else {
      System.out.println(this.perso.getPrenom() + " est mort(e).");
    }
    System.out.println("------------------------------");
    System.out.println();
  }

  /**
   * Donne une description des attribus specifiques des personnages
   */
  public void to_String_Specefique() {

    System.out.println("------------------------------");
    if (this.etat_global != Etat_Personnages.Mort) {
      System.out.print(
          this.perso.name() + " => " + this.perso.getPrenom() + " est vivant(e).\n" + this.etat_global.name() + "\n"
              + this.etat_malade.name() + "\n" + this.etat_mentale.name());
      System.out.println("\n-----ATTRIBUTS SPECIFIQUE-----\n" + "Force : " + this.force + "\nConso_Nourriture : "
          + this.conso_nourriture + "\nIntelligence : " + this.intelligence + "\nResistance : " + this.resistance
          + "\nAgilite : " + this.agilite);
    } else {
      System.out.println(this.perso.getPrenom() + " est mort(e).");
    }
    System.out.println("------------------------------");
    System.out.println();

  }

  /**
   * Affichage si en expedition
   */
  public void to_String_en_expedition() {

    System.out.println("------------------------------");
    if (this.etat_global != Etat_Personnages.Mort) {
      System.out.println(this.perso.name() + " => " + this.perso.getPrenom() + " est en expedition.");
    } else {
      System.out.println(this.perso.getPrenom() + " est mort(e).");
    }
    System.out.println("------------------------------");
    System.out.println();
  }

  /**
   * Getters
   * 
   * @return vivant ou pas ?
   */

  public boolean get_vivant() {
    if (this.etat_global != Etat_Personnages.Mort) {
      return true;
    }
    return false;
  }

  /**
   * Getters
   * 
   * @return nombre correspondant a la barre nourriture
   */
  public int get_barre_nourriture() {
    return this.barre_nourriture;
  }

  /**
   * Getters
   * 
   * @return nombre correspondant a la barre mentale
   */
  public int get_barre_mentale() {
    return this.barre_mentale;
  }

  /**
   * Getters
   * 
   * @return nombre correspondant a la barre energie
   */
  public int get_barre_energie() {
    return this.barre_energie;
  }

  /**
   * Getters
   * 
   * @return nombre correspondant a la barre sante
   */
  public int get_barre_sante() {
    return this.barre_sante;
  }

  /**
   * Getters
   * 
   * @return nombre correspondant a la barre eau
   */
  public int get_barre_eau() {
    return this.barre_eau;
  }

  /**
   * Getters
   * 
   * @return nombre correspondant a la force du perso
   */
  public int get_force() {
    return this.force;
  }

  public Personnages_du_jeu get_perso() {
    return this.perso;
  }

  /**
   * Getters
   * Conso Nourriture : a quel point faut t-il mange pour etre rassasie ?
   * 
   * @return nombre correspondant a la consommation du perso
   */
  public int get_conso_nourriture() {
    return this.conso_nourriture;
  }

  /**
   * Getters
   * 
   * @return nombre correspondant a l'intelligence du perso
   */
  public int get_intelligence() {
    return this.intelligence;
  }

  /**
   * Getters
   * 
   * @return nombre correspondant a la resistance du perso
   */
  public int get_resistance() {
    return this.resistance;
  }

  /**
   * Getters
   * 
   * @return nombre correspondant a l'agilite du perso
   */
  public int get_agilite() {
    return this.agilite;
  }

  /**
   * Getters
   * 
   * @return nombre correspondant a combien de temps le perso est malade
   */
  public int get_temps_malade_virus() {
    return this.temps_malade_virus;
  }

  /**
   * Getters
   * 
   * @return perso en expedition ou pas ?
   */
  public boolean get_en_expedition() {
    return this.en_expedition;
  }

  /**
   * Getters
   * 
   * @return l'etat global du personages
   */
  public Etat_Personnages get_etat_global() {
    return this.etat_global;
  }

  /**
   * Getters
   * 
   * @return l'etat malade ou pas malade du personages
   */
  public Etat_Personnages get_etat_malade() {
    return this.etat_malade;
  }

  /**
   * Getters
   * 
   * @return l'etat mentale du personages
   */
  public Etat_Personnages get_etat_mentale() {
    return this.etat_mentale;
  }

  /**
   * Getters
   * 
   * @return l'etat de fatigue du personages
   */
  public Etat_Personnages get_etat_energie() {
    return this.etat_energie;
  }

  /**
   * MAJ Obligatoire chaque jour qui passe.
   * On a de plus en plus faim/soif le long de la journee.
   * On a moins d'energie.
   * Le mentale baisse.
   * On met a jour l'attribut etat_global
   */
  public void maj_naturelle_attributs_generaux_Personnages() {
    // maj a faire tt les 1 jours en fin de journee
    if (this.etat_global != Etat_Personnages.Mort) {
      this.barre_nourriture = this.barre_nourriture - 20;
      this.barre_eau = this.barre_eau - 25;
      this.barre_mentale = this.barre_mentale - 5;
      this.barre_energie = (this.barre_nourriture <= 20) ? this.barre_energie - 10 : this.barre_energie - 5; // perd
                                                                                                             // plus
                                                                                                             // d'energie
                                                                                                             // si faim

      this.barre_sante = (this.barre_nourriture + this.barre_eau + this.barre_mentale + this.barre_energie) / 4;
    }

    // Meurt si un des attributs generaux passe sous ou egal zero.
    if (this.barre_nourriture <= 0 || this.barre_eau <= 0 || this.barre_mentale <= 0 || this.barre_energie <= 0) {
      this.barre_nourriture = Math.max(0, this.barre_nourriture);
      this.barre_eau = Math.max(0, this.barre_eau);
      this.barre_mentale = Math.max(0, this.barre_mentale);
      this.barre_energie = Math.max(0, this.barre_energie);
      this.barre_sante = 0;
      this.etat_global = Etat_Personnages.Mort;
    }

    if (!(this.barre_sante <= this.etat_global.getBorne_Sup() && this.barre_sante >= this.etat_global.getBorne_Inf())) {
      if (this.barre_sante >= 80 && this.barre_sante <= 100) {
        this.etat_global = Etat_Personnages.Vigoureux;
      } else if (this.barre_sante >= 65 && this.barre_sante <= 79) {
        this.etat_global = Etat_Personnages.Sain;
      } else if (this.barre_sante >= 50 && this.barre_sante <= 64) {
        this.etat_global = Etat_Personnages.Stable;
      } else if (this.barre_sante >= 31 && this.barre_sante <= 49) {
        this.etat_global = Etat_Personnages.Affaibli;
      } else if (this.barre_sante >= 1 && this.barre_sante <= 30) {
        this.etat_global = Etat_Personnages.Vulnerable;
      }
    }
  }

  /**
   * MAJ lorsque :
   * Le personnage mange ou bois.
   * Fait une activite qui boost le mentale.
   * Autre contexte ?
   */
  public void maj_contextuelle_attributs_generaux_Personnages(int eau, int nourriture, int mentale, int energie) {

    if (this.barre_eau + eau > 100) {
      this.barre_eau = 100;
    } else if (this.barre_eau + eau < 0) {
      this.barre_eau = 0;
    } else {
      this.barre_eau = this.barre_eau + eau;
    }

    if (this.barre_nourriture + nourriture > 100) {
      this.barre_nourriture = 100;
    } else if (this.barre_nourriture + nourriture < 0) {
      this.barre_nourriture = 0;
    } else {
      this.barre_nourriture = this.barre_nourriture + nourriture;
    }

    if (this.barre_mentale + mentale > 100) {
      this.barre_mentale = 100;
    } else if (this.barre_mentale + mentale < 0) {
      this.barre_mentale = 0;
    } else {
      this.barre_mentale = this.barre_mentale + mentale;
    }

    if (this.barre_energie + energie > 100) {
      this.barre_energie = 100;
    } else if (this.barre_energie + energie < 0) {
      this.barre_energie = 0;
    } else {
      this.barre_energie = this.barre_energie + energie;
    }

    this.barre_sante = (this.barre_nourriture + this.barre_eau + this.barre_mentale + this.barre_energie) / 4;
  }

  /**
   * MAJ permettant de modifie les attributs specifique d'un personnage.
   */
  public void maj_contextuelle_attributs_specifique_Personnages(int force, int conso_nourriture, int intelligence,
      int resistance, int agilite) {

    if (force < 0) {
      this.force = 0;
    } else {
      this.force = force;
    }

    if (conso_nourriture < 1) { // j'utilise en faisant une division
      this.conso_nourriture = 1;
    } else {
      this.conso_nourriture = conso_nourriture;
    }

    if (intelligence < 0) {
      this.intelligence = 0;
    } else {
      this.intelligence = intelligence;
    }

    if (resistance < 0) {
      this.resistance = 0;
    } else {
      this.resistance = resistance;
    }

    if (agilite < 0) {
      this.agilite = 0;
    } else {
      this.agilite = agilite;
    }

  }

  /**
   * MAJ Contamination d'un personnage par un autre.
   */
  public void maj_contamination_virus_Personnages() {
    if (this.etat_malade == Etat_Personnages.PasMalade) {
      this.etat_malade = Etat_Personnages.Malade;
      this.consequence_maladie_baisse_stat();
    }
  }

  /**
   * MAJ Si Perso Malade, Fatigue etc... Tous cela affecte les attributs
   * specifiques
   */
  public void maj_donnee_etat_naturelle_Personnages() {

    /**************
     * GESTION Energie
     ***************/

    // Si energie basse baisse des stat generales
    if (!(this.barre_energie <= this.etat_energie.getBorne_Sup()
        || this.barre_energie >= this.etat_energie.getBorne_Inf())) {
      if (this.barre_energie >= 30 && this.barre_energie <= 100) {
        this.etat_energie = Etat_Personnages.Repose;
        this.consequence_fin_fatigue();
      } else if (this.barre_sante >= 0 && this.barre_sante <= 29) {
        this.etat_global = Etat_Personnages.Fatigue;
        this.consequence_fatigue();
      }
    }

    /**************
     * GESTION MENTALE
     ***************/

    if (!(this.barre_mentale <= this.etat_mentale.getBorne_Sup()
        && this.barre_mentale >= this.etat_mentale.getBorne_Inf())) {
      if (this.barre_mentale >= 50 && this.barre_mentale <= 100) {
        this.etat_mentale = Etat_Personnages.Heureux;
        this.fin_consequence_depression();
      } else if (this.barre_mentale >= 25 && this.barre_mentale <= 49) {
        this.etat_mentale = Etat_Personnages.Depressif;
        this.consequence_depression();
      } else if (this.barre_mentale >= 0 && this.barre_mentale <= 24) {
        this.etat_mentale = Etat_Personnages.Fou;
        // debloque necessairement des evenements catastrophique
      }
    }

    /**************
     * GESTION VIRUS
     ***************/

    if (this.etat_malade == Etat_Personnages.Malade) {
      // On a depasse 5 jours de maladie
      this.temps_malade_virus = this.temps_malade_virus + 1;
      if (this.temps_malade_virus > 5) {

        this.temps_malade_virus = 0;
        this.etat_malade = Etat_Personnages.PasMalade;
        this.consequence_maladie_guerison_augmente_stat();
      } else {
        this.consequence_maladie(); // Va t-il mourir ? //Va t-il guerir tout seul ?
      }
    }
  }

  /**
   * Si perso Fatigue, on baisse ces stats
   */
  private void consequence_fatigue() {
    maj_contextuelle_attributs_specifique_Personnages(-2, -2, -2, -2, -2);
  }

  /**
   * Si perso n'est plus fatigue, on augmente les stats qui ont ete baisse
   */
  private void consequence_fin_fatigue() {
    maj_contextuelle_attributs_specifique_Personnages(2, 2, 2, 2, 2);
  }

  /**
   * Si perso en Depression, on baisse ces stats
   */
  private void consequence_depression() {
    maj_contextuelle_attributs_specifique_Personnages(0, 0, -4, 0, -4);
  }

  /**
   * Si perso n'est plus en depression, on augmente les stats qui ont ete baisse
   */
  private void fin_consequence_depression() {
    maj_contextuelle_attributs_specifique_Personnages(0, 0, 4, 0, 4);
  }

  /**
   * Si perso Malade, on peut soit guerir naturellement, soit mourrir.
   */
  private void consequence_maladie() {

    // Peut on guerir ?
    // Oui avec proba = 1/(6-nombre_de_jour_malade)
    Random r = new Random();
    int n = r.nextInt(6 - this.temps_malade_virus);

    if (n == 0) {
      this.etat_malade = Etat_Personnages.PasMalade;
      this.consequence_maladie_guerison_augmente_stat();
      return;
    }

    // Peut on mourir ?
    // Oui avec proba = 1/(10-nombre_de_jour_malade)
    n = r.nextInt(10 - this.temps_malade_virus);
    if (n == 0) {
      this.etat_global = Etat_Personnages.Mort;
      return;
    }
  }

  /**
   * Si perso Malade, on baisse ces stats.
   */
  private void consequence_maladie_baisse_stat() {
    /***********************************************************************************
     * On dira qu'on baisse de 5 points chaque statistiques *
     * Plusieurs parametres peuvent influer sur la baisse des attributs SPECIFIQUES
     * *
     * Vaut mieux enlever des points que de chercher a diviser par un certain
     * nombre. *
     * En effet, si l'on divise par deux (à cause d'un evenement A), qu'on rajoute
     * ou *
     * diminue les attributs specifiques (à cause d'un evenement B), si l'evenment
     * A, *
     * prend fin, on va doubler les stats, mais on remarque qu'il y a une certaine *
     * perte.... *
     ***********************************************************************************/
    maj_contextuelle_attributs_specifique_Personnages(-5, -5, -5, -5, -5);

  }

  /**
   * Si perso plus Malade, on augmente les stats qui ont ete baisse.
   */
  private void consequence_maladie_guerison_augmente_stat() {
    maj_contextuelle_attributs_specifique_Personnages(5, 5, 5, 5, 5);
  }

  /**
   * Setters
   * Part en expedition
   */
  public void part_en_expedition() {
    this.en_expedition = true;
  }

  /**
   * Setters
   * Revient d'expedition (baisse de l'energie)
   */
  public void revient_de_expedition() {
    this.en_expedition = false;
    this.maj_contextuelle_attributs_generaux_Personnages(0, 0, 0, -20);
  }

  /**
   * Setters
   * 
   * @param n cmb de jour malade ? Si plus de 5, le prochain jour guerit
   *          automatiquement.
   *          Mettre a jour le temps de maladie
   */
  public void set_temps_malade_virus(int n) {
    this.temps_malade_virus = n;
  }

  /**
   * MAJ les attributs specifique du Perso
   */
  public void maj_contextuelle_attributs_specifique_Personnages_ajout(int nforce, int nconso_nourriture,
      int nintelligence,
      int nresistance, int nagilite) {

    if (this.force + nforce < 0) {
      this.force = 0;
    } else {
      this.force = this.force + nforce;
    }

    if (this.conso_nourriture + nconso_nourriture < 0) {
      this.conso_nourriture = 1;
    } else {
      this.conso_nourriture = this.conso_nourriture + nconso_nourriture;
    }

    if (this.intelligence + nintelligence < 0) {
      this.intelligence = 0;
    } else {
      this.intelligence = this.intelligence + nintelligence;
    }

    if (this.resistance + nresistance < 0) {
      this.resistance = 0;
    } else {
      this.resistance = this.resistance + nresistance;
    }

    if (this.agilite + nagilite < 0) {
      this.agilite = 0;
    } else {
      this.agilite = this.agilite + nagilite;
    }

  }

  /**
   * Tuer un personages
   */
  public void tuer_personnage() {
    this.etat_global = Etat_Personnages.Mort;
  }

}
