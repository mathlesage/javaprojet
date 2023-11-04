package Univers;



public class  Objet extends Inventaire {
    public Objet() {
        super("objet");
    }
    public int getQuantite(String nom) {
        return super.getQuantite(nom);
}
    public void setQuantite(String nom, int q) {
        super.setQuantite(nom, q);
}
}
