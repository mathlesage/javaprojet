package univers;

public class Nourriture extends Inventaire{
    public Nourriture() {
        int r=0;
        Un_alimentant fusil=new Un_alimentant();
    }
    public int getQuantite(String nom) {
        return super.getQuantite(nom);
    
}
    public void setQuantite(String nom, int q) {
        super.setQuantite(nom, q);
    
}
    public int getNourriture(String nom) {
        return super.getNourriture(nom);
    
}
    public int getEnergie(String nom) {
        return super.getEnergie(nom);
    
}
}