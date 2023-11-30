package univers;
import java.util.ArrayList;


public interface Inventaire {
    int getQuantite(String nom);
    void setQuantite(String nom, int q);
    void getQuantites();
}  
