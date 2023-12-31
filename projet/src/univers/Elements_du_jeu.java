package univers;

import java.io.Serializable;

/**
 * Enumeration de la nourriture et des objets du jeu ainsi que leur attribut
 * energisant, nourrisant, et d'hydratation.
 * Par default un objet n'est pas de la nourriture : attribut
 * energisant,nourrisant et hydratation vallent -1.
 * 
 * @author ABDELOUHAB Yacine et QUATREBOEUFS Matheo
 */
public enum Elements_du_jeu implements Serializable {
  FUSIL("Fusil", -1, -1, -1, 10),
  BOITE_OUTILS("Boite a Outils", -1, -1, -1, 5),
  KATANA("Katana", -1, -1, -1, 9),
  CARTE_VILLE("Carte de la ville", -1, -1, -1, 10),
  ECHEC("Echec", -1, -1, -1, 2),
  CARTE_JOUE("Carte a jouer", -1, -1, -1, 3),
  INSECTICIDE("Insecticide", -1, -1, -1, 4),
  HACHE("Hache", -1, -1, -1, 8),
  SAC("Sac", -1, -1, -1, 10),
  TROUSSE("Trousse", -1, -1, -1, 2),
  RADIO("Radio", -1, -1, -1, 1),
  LAMPE("Lampe", -1, -1, -1, 6),
  BANANE("Banane", 20, 25, 5, 1),
  PATE("Pate", 20, 50, 0, 1),
  FRANDISE("Friandise", 15, 10, 0, 1),
  EAU("Eau", 0, 0, 75, 1),
  SODA("Soda", 30, 0, 25, 5);

  private String nom;
  private int energie;
  private int nourissant;
  private int hydratation;
  private int point;

  Elements_du_jeu(String nom, int energie, int nourissant, int hydratation, int point) {
    this.nom = nom;
    this.energie = energie;
    this.nourissant = nourissant;
    this.hydratation = hydratation;
    this.point = point;
  }

  
  /** Getters
   * @return Nom de l'Element*/
  public String getNom() {
    return this.nom;
  }

  /** Getters
   * @return Energie de l'element*/
  public int getEnergie() {
    return this.energie;
  }

  /** Getters
   * @return Pouvoir nourrisant de l'element*/
  public int getNourrissant() {
    return this.nourissant;
  }

  /** Getters
   * @return Pouvoir Hydratant de l'element*/
  public int getHydratation() {
    return this.hydratation;
  }

  /** Getters
   * @return Point de l'element*/
  public int getPoint() {
    return this.point;
  }

}
