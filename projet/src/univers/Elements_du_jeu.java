package univers;

/**
  Enumeration de la nourriture et des objets du jeu ainsi que leur attribut energisant, nourrisant, et d'hydratation.
  Par default un objet n'est pas de la nourriture : attribut energisant,nourrisant et hydratation vallent -1.
  @author ABDELOUHAB Yacine et QUATREBOEUFS Matheo
*/
public enum Elements_du_jeu{
  FUSIL("Fusil",-1,-1,-1),
  BOITE_OUTILS("Boite a Outils",-1,-1,-1),
  KATANA("Katana",-1,-1,-1),
  CARTE_VILLE("Carte de la ville",-1,-1,-1),
  ECHEC("Echec",-1,-1,-1),
  CARTE_JOUE("Carte a jouer",-1,-1,-1),
  INSECTICIDE("Insecticide",-1,-1,-1),
  HACHE("Hache",-1,-1,-1),
  SAC("Sac",-1,-1,-1),
  TROUSSE("Trousse",-1,-1,-1),
  RADIO("Radio",-1,-1,-1),
  LAMPE("Lampe",-1,-1,-1),
  PILE("Pile",-1,-1,-1),
  BANANE("Banane",3,2,0),
  PATE("Pate",1,3,0),
  FRANDISE("Friandise",3,1,0),
  EAU("Eau",0,0,3),
  SODA("Soda",3,0,2);

  private String nom;
  private int energie;
  private int nourissant;
  private int hydratation;

  Elements_du_jeu(String nom,int energie,int nourissant,int hydratation){
    this.nom = nom;
    this.energie = energie;
    this.nourissant = nourissant;
    this.hydratation = hydratation;
  }

  public String getNom(){
    return this.nom;
  }

  public int getEnergie(){
    return this.energie;
  }

  public int getNourrissant(){
    return this.nourissant;
  }

  public int getHydratation(){
    return this.hydratation;
  }

}
