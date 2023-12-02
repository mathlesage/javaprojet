package univers;


public interface Inventaire {
    int getQuantite(String nom);
    void setQuantite(String nom, int q);
    void getQuantites();
}  
