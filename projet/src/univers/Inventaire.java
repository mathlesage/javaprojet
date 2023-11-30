package univers;
import java.util.ArrayList;


public abstract class  Inventaire {
    private ArrayList<Un_objet> inventaire = new ArrayList<Un_objet>();

        public int getQuantite(String nom){
            for(Un_objet obj : inventaire) {
                if(nom.equals(obj.getnom())) {
                    return obj.getquantite();
                }
            }
            return 0;
        }
        public void setQuantite(String nom, int q) {
            for(Un_objet obj : inventaire) {
                if(nom.equals(obj.getnom())) {
                    obj.setQuantite(q);
                }
            }


}

        public void getQuantites() {
            
        for (Un_objet obj : inventaire) {

            System.out.print(obj.getnom());
            System.out.print(" ---> ");
            System.out.print(obj.getquantite());
            System.out.println(); // Saut de ligne entre chaque sous-liste
    }
}
}
