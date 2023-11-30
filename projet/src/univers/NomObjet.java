package univers;
public enum NomObjet {
    FUSIL("Fusil"),
    BOITE_OUTILS("Boite à Outils"),
    KATANA("Katana"),
    CARTE_VILLE("Carte de la ville"),
    ECHEC("Echec"),
    CARTE_JOUE("Carte à joueur"),
    INSECTICIDE("Insecticide"),
    HACHE("Hache"),
    SAC("Sac"),
    TROUSSE("Trousse"),
    RADIO("Radio"),
    LAMPE("Lampe"),
    PILE("Pile"),
    BANANE("Banana"),
    PATE("Pate"),
    FRANDISE("Friandise"),
    EAU("Eau"),
    SODA("Soda");
    private final String nom;

    NomObjet(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
    

}


