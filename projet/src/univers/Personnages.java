package Univers;
import java.util.Random;


/*
Probleme : Lien conso_nourriture et sassiete ? -> Attention qd on fait appel a la fonction....
*/

public class Personnages{

    private boolean vivant = true;
    private String id;
    /*
      Attributs generaux : Si l'un d'entre eux passe sous zero,
      ou proche de zero compromet reellement le personnage.
    */
    private int barre_eau = 100;
    private int barre_nourriture = 100;
    private int barre_mentale = 100;
    private int barre_energie = 100;
    private int barre_sante = 100; // moyenne des quatre superieurs


    /*
      Attributs specifique a chaque personnage du jeu
    */
    private int force;
    private int conso_nourriture;
    private int intelligence;
    private int resistance;
    private int agilite;

    /*
      Attributs maladie : on peut tomber malade, savoir qu'on a la maladie ou pas,
      contaminer si on a un certain type de maladie...

      4 Type de maladie
          - 0 : Fatigue
          - 1 : Depression
          - 2 : Folie
          - 3 : Virus
          - 4 : Mutation

    */

    private boolean [] tab_maladie = {false,false,false,false,false};
    private int temps_malade_virus = 0;
    private boolean contagieux = false;


    /*************************************/
    /****Instantiation d'un personnage****/
    /**   Perso 1 -> pere               **/
    /**   Perso 2 -> mere               **/
    /**   Perso 3 -> soeur              **/
    /**   Perso 4 -> frere              **/
    /**   Perso 5 -> medecin            **/
    /**   Perso 6 -> athlete            **/
    /**   Perso 7 -> enfant turbulant   **/
    /**   Perso 8 -> cuisinière         **/
    /*************************************/

    //On ne met pas de constructeur par defaut ici...
    public Personnages(int type_personne){

      switch(type_personne){

        case 1:
          this.id = "Papa";
          this.force = 8 ;
          this.conso_nourriture = 8;
          this.intelligence = 5;
          this.resistance = 5;
          this.agilite = 3;
          break;

        case 2:
          this.id = "Maman";
          this.force = 6;
          this.conso_nourriture = 4;
          this.intelligence = 8;
          this.resistance = 8;
          this.agilite = 6;
          break;

        case 3:
          this.id = "Soeur";
          this.force = 3;
          this.conso_nourriture = 2;
          this.intelligence = 5;
          this.resistance = 4;
          this.agilite = 5;
          break;

        case 4:
          this.id = "Frere";
          this.force = 4;
          this.conso_nourriture = 3;
          this.intelligence = 6;
          this.resistance = 8;
          this.agilite = 10;
          break;

        case 5:
          this.id = "Medecin";
          this.force = 6;
          this.conso_nourriture = 6 ;
          this.intelligence = 8;
          this.resistance = 5;
          this.agilite = 5;
          break;

        case 6:
          this.id = "Athlete";
          this.force = 10;
          this.conso_nourriture = 8;
          this.intelligence = 6;
          this.resistance = 10;
          this.agilite = 10;
          break;

        case 7:
          this.id = "Cousin";
          this.force = 5;
          this.conso_nourriture = 3;
          this.intelligence = 5;
          this.resistance = 10;
          this.agilite = 7;
          break;

        case 8:
          this.id = "Cuisiniere";
          this.force = 7;
          this.conso_nourriture = 8;
          this.intelligence = 5;
          this.resistance = 7;
          this.agilite = 3;
          break;
      }
    }


    //Description Personnage
    // Attributs specifique et Attributs Generaux
    public void etat_Personnages(){

      System.out.println(this.id +"\n\n" + "ATTRIBUTS GENERAUX :\n" + "Hydratation : "+this.barre_eau +"\nSassiete : "+this.barre_nourriture+"\nMental : "+this.barre_mentale+"\nEnergie : "+this.barre_energie+"\nSante Genral : "+this.barre_sante);
      System.out.println("\n"+"ATTRIBUTS SPECIFIQUES :\n"+"Force : "+this.force+"\nConso_Nourriture : "+this.conso_nourriture+"\nIntelligence : "+this.intelligence+"\nResistance : "+this.resistance+"\nAgilite : "+this.agilite);


    }


    //MAJ Obligatoire Chaque Jour qui Passe
    public void maj_naturelle_attributs_generaux_Personnages(){
      //maj tt les 1 jours
      if(this.vivant == true){
          this.barre_nourriture = this.barre_nourriture - 20; // 5 jour sans manger max
          this.barre_eau =  this.barre_eau - 33; // 3 jour sans boire max
          this.barre_mentale = this.barre_mentale - 25;
          this.barre_energie = (this.barre_nourriture <= 50) ? this.barre_energie - 25 : this.barre_energie - 10 ;
          this.barre_sante = (this.barre_nourriture + this.barre_eau + this.barre_mentale + this.barre_energie)/4;

      }
    }


    //MAJ si le personnage Mange, Boit, Joue
    public void maj_contextuelle_attributs_generaux_Personnages(int eau,int nourriture,int mentale,int energie){
      this.barre_eau = this.barre_eau + eau;
      this.barre_nourriture = this.barre_nourriture + nourriture;
      this.barre_mentale = this.barre_mentale + mentale;
      this.barre_energie = this.barre_energie + energie;
      this.barre_sante = (this.barre_nourriture + this.barre_eau + this.barre_mentale + this.barre_energie)/4;
    }


    //MAJ affectant attributs specifique
    public void maj_contextuelle_attributs_specifique_Personnages(int force,int conso_nourriture,int intelligence,int resistance,int agilite){
      this.force = force;
      this.conso_nourriture = conso_nourriture;
      this.intelligence = intelligence;
      this.resistance = resistance;
      this.agilite = agilite;
    }

    //MAJ Contamination d'un personnage par un autre
    public void maj_contamination_virus_Personnages(){
      this.tab_maladie[3] = true;
      this.consequence_maladie_baisse_stat();
    }

    //MAJ Maladie
    public boolean maj_donnee_maladie_naturelle_Personnages(){


        /*******************************************************************
        * Changement Naturelle de la maladie                               *
        * Si le personnage est malade, on fait les modifications necessaire*
        * Attention, la personne peut mourir. Verifier ensuite si c'est le *
        * cas...                                                           *
        *                                                                  *
        * On ne s'atarde pas dans cette fonction sur la Mutation car       *
        *     - Depend FORTEMENT des evenements et des choix du joeur      *
        *     - Permet de debloquer certains evenement                     *
        *                                                                  *
        *******************************************************************/

        /*********************************************************************
        Une personne peut atteindre le stade de folie, si elle atteint ce stade,
        la fonction renvoie TRUE, sinon FALSE.
        La folie engendre une cascade d'evenement negatif et incontrolable.
        *********************************************************************/


        /********************************************************************
        * Rappel : dans l'attribut tab_maladie, les indices représentent :  *
        * 0->Fatigue                                                        *
        * 1->Depression                                                     *
        * 2->Fou                                                            *
        * 3->Virus                                                          *
        * 4->Mutation                                                       *
        ********************************************************************/




        /*****************************************************************
        GESTION FATIGUE :  CONSEQUENCE => BAISSE DES ATTRIBUTS SPECIFIQUES
        ******************************************************************/

        //Attention on doit faire attention, on applique la consequence qu'une seul fois !!!!
        //En effet, si fatigué pls jours d'affilé, on doit pas baisser les stat indefiniment..
        if(this.barre_energie < 25 && tab_maladie[0]==false){
          tab_maladie[0] = true;
          this.consequence_fatigue();
        }
        //Si individu n'est plus malade, faire la maj tableau donnee...
        else if(this.barre_energie >= 25 && tab_maladie[0]==true){
          this.consequence_fin_fatigue();
          tab_maladie[0] = false;
        }



        /**************
        GESTION MENTALE
        ***************/
        boolean devient_fou_ou_pas = false;

        if(this.barre_mentale < 50){

          if(this.barre_mentale >= 25 && tab_maladie[1] == false){
            //On commence a entrer dans la zone de folie
            //Baisse des attributs specifique
            tab_maladie[1] = true ;
            tab_maladie[2] = false ;
            this.consequence1_folie();
          }

          if(this.barre_mentale < 25 && tab_maladie[2] == false){
            //On est rentré dans la folie
            tab_maladie[2] = true ;
            devient_fou_ou_pas = this.consequence2_folie();
          }
        }

        else if(this.barre_mentale >= 50 && tab_maladie[1] == true){
          this.fin_consequence_folie();
          tab_maladie[1] = false ;
          tab_maladie[2] = false ;
        }


        /**************
        GESTION   VIRUS
        ***************/

        //On ne peut etre malade plus de 5 jours consecutifs

        if(this.tab_maladie[3] == true){

            //On a depasse 5 jours de maladie
            this.temps_malade_virus = this.temps_malade_virus + 1;
            if(this.temps_malade_virus > 5){

              this.temps_malade_virus = 0;
              this.tab_maladie[3] = false;
              this.consequence_maladie_guerison_augmente_stat();
            }

            else{
              this.consequence_maladie(); //Va t-il mourir ? //Va t-il guerir tout seul ? //Va t-il contaminer qql?
            }
        }
        return devient_fou_ou_pas;
    }



    //Consequence des divers formes de maladie lors de leur apparition ou disparition
    private void consequence_fatigue(){
      maj_contextuelle_attributs_specifique_Personnages(-2,-2,-2,-2,-2);
    }
    private void consequence_fin_fatigue(){
      maj_contextuelle_attributs_specifique_Personnages(2,2,2,2,2);
    }

    private void consequence1_folie(){
      /*
      Diminution de l'intelligence et de l'agilite
      */
      maj_contextuelle_attributs_specifique_Personnages(0,0,-4,0,-4);
    }
    private void fin_consequence_folie(){
      maj_contextuelle_attributs_specifique_Personnages(0,0,4,0,4);
    }
    private boolean consequence2_folie(){
        /*
         1 chance sur 4 de devenir fou
        */

        Random r = new Random();
        int n = r.nextInt(4);

        if(n==0){
          return true;
        }
        return false;
    }

    private void consequence_maladie(){

      //A t-il contamine une personne ?
      // Peut etre : proba de 1/7

      Random r = new Random();
      int n = r.nextInt(7);

      if(n==0){
        this.contagieux = true;
      }

      //Peut on guerir ?
      // Oui avec proba = 1/(6-nombre_de_jour_malade)
      n = r.nextInt(6-this.temps_malade_virus);

      if(n==0){
        this.consequence_maladie_guerison_augmente_stat();
        return;
      }

      //Peut on mourir ?
      //Oui avec proba = 1/(10-nombre_de_jour_malade)
      n = r.nextInt(10-this.temps_malade_virus);
      if(n==0){
        this.vivant = true;
        return;
      }

    }
    private void consequence_maladie_baisse_stat(){
        /***********************************************************************************
        *  On dira qu'on baisse de 5 points chaque statistiques                            *
        *  Plusieurs parametres peuvent influer sur la baisse des attributs SPECIFIQUES    *
        *  Vaut mieux enlever des points que de chercher a diviser par un certain nombre.  *
        *  En effet, si l'on divise par deux (à cause d'un evenement A), qu'on rajoute ou  *
        *  diminue les attributs specifiques (à cause d'un evenement B), si l'evenment A,  *
        *  prend fin, on va doubler les stats, mais on remarque qu'il y a une certaine     *
        *  perte....                                                                       *
        ***********************************************************************************/
        maj_contextuelle_attributs_specifique_Personnages(-5,-5,-5,-5,-5);

    }
    private void consequence_maladie_guerison_augmente_stat(){
        maj_contextuelle_attributs_specifique_Personnages(5,5,5,5,5);
    }
}
