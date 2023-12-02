package univers;

public class Un_objet {
        /*  Chaque objet sera définit par un nom et une quantité */
    private NomObjet nom;
    private int quantite;

    public Un_objet(NomObjet nom, int quantite) {
        this.nom = nom;
        this.quantite = quantite;
    
}
    // le getter de la variable nom
    public String getnom() {
        return this.nom.getNom();
}
    // le getter de la variable quantité
    public int getquantite() {
        return this.quantite;
}
    /* Le setter de la variable quantité avec une vérification que la variable soit bien
        > 0*/
public void setQuantite(int quantite) { 
    int nouv_quantite = quantite + this.quantite;
    if (nouv_quantite < 0) {
        this.quantite = 0; // Définit la quantité à zéro si la somme est négative
    } else {
        this.quantite = nouv_quantite;
    }
}
}

