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
    public NomObjet getnom() {
        return this.nom;
}
    // le getter de la variable quantité
    public int getquantite() {
        return this.quantite;
}
    /* Le setter de la variable quantité avec une vérification que la variable soit bien
        > 0*/
    public void setQuantite(int quantite) { 
        int nouv_quantite = quantite+this.quantite;
        if (nouv_quantite < 0) {
            throw new IllegalArgumentException("La quantité ne peut pas être négatif.");
        }
        this.quantite = nouv_quantite;
    }

}