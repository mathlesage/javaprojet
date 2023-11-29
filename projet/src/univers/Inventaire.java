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

        public void setQuantites() {
            
        for (Un_objet obj : inventaire) {

            System.out.print(obj.getnom());
            System.out.print(" ---> ");
            System.out.print(obj.getquantit());
            System.out.println(); // Saut de ligne entre chaque sous-liste
    }


}

    
        public int getNourriture(String nom){
            for(int i=0;i<inventaire.size();i++) {
                if(nom.equals(inventaire.get(i).get(0))) {
                    return Integer.parseInt(inventaire.get(i).get(2));
                }
            }
            return 0;
        }
        public int getEnergie(String nom){
            for(int i=0;i<inventaire.size();i++) {
                if(nom.equals(inventaire.get(i).get(0))) {
                    return Integer.parseInt(inventaire.get(i).get(3));
                }
            }
            return 0;
        }
}
