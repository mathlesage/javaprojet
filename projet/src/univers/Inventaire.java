package univers;
import java.util.ArrayList;
import java.util.List;


public abstract class  Inventaire {
    ArrayList<ArrayList<String>> inventaire = new ArrayList<ArrayList<String>>();
    public Inventaire(String o) {
        if( "objet".equals(o)) {
            ArrayList<String> obj=new ArrayList<String>();
            obj.add("Fusil");
            obj.add("0");
            inventaire.add(obj);
            obj=new ArrayList<String>();
            obj.add("Boite à outils");
            obj.add("0");
            inventaire.add(obj);
            obj=new ArrayList<String>();
            obj.add("Katana");
            obj.add("0");
            inventaire.add(obj);
            obj=new ArrayList<String>();
            obj.add("Carte de la ville");
            obj.add("0");
            inventaire.add(obj);
            obj=new ArrayList<String>();
            obj.add("Echec");
            obj.add("0");
            inventaire.add(obj);
            obj=new ArrayList<String>();
            obj.add("Carte à joué");
            obj.add("0");
            inventaire.add(obj);
            obj=new ArrayList<String>();
            obj.add("Insecticide");
            obj.add("0");
            inventaire.add(obj);
            obj=new ArrayList<String>();
            obj.add("Hache");
            obj.add("0");
            inventaire.add(obj);
            obj=new ArrayList<String>();
            obj.add("Sac");
            obj.add("0");
            inventaire.add(obj);
            obj=new ArrayList<String>();
            obj.add("Trousse");
            obj.add("0");
            inventaire.add(obj);
            obj=new ArrayList<String>();
            obj.add("Radio");
            obj.add("0");
            inventaire.add(obj);
            obj=new ArrayList<String>();
            obj.add("Lampe");
            obj.add("0");
            inventaire.add(obj);
            obj=new ArrayList<String>();
            obj.add("Pile");
            obj.add("0");
            inventaire.add(obj);
        }
        // [nom, quantité, nourritur donnée, énergie donnée]
        if("nourriture".equals(o)) {
            ArrayList<String> nou=new ArrayList<String>();
            nou.add("Banane");
            nou.add("0");
            nou.add("3");
            nou.add("2");
            inventaire.add(nou);
            nou=new ArrayList<String>();
            nou.add("Pate");
            nou.add("0");
            nou.add("1");
            nou.add("1");
            inventaire.add(nou);
            nou=new ArrayList<String>();
            nou.add("Friandise");
            nou.add("0");
            nou.add("1");
            nou.add("1");
            inventaire.add(nou);
            nou=new ArrayList<String>();
            nou.add("Eau");
            nou.add("0");
            nou.add("1");
            nou.add("1");
            inventaire.add(nou);
            nou=new ArrayList<String>();
            nou.add("Soda");
            nou.add("0");
            nou.add("1");
            nou.add("1");


    }
}

        public int getQuantite(String nom){
            for(int i=0;i<inventaire.size();i++) {
                if(nom.equals(inventaire.get(i).get(0))) {
                    return Integer.parseInt(inventaire.get(i).get(1));
                }
            }
            return 0;
        }
        public void setQuantite(String nom, int q) {
            for(int i=0;i<inventaire.size();i++) {
                if(nom.equals(inventaire.get(i).get(0))) {
                    int nouvelleQuantité=(Integer.parseInt(inventaire.get(i).get(1)))+q;
                    if(nouvelleQuantité>=0) {
                        inventaire.get(i).set(1, String.valueOf(nouvelleQuantité));
                    }
                }
            }


}
        public void setQuantites() {
            
    for (ArrayList<String> element : inventaire) {
    // 'element' représente chaque sous-liste dans l'inventaire

        for (String valeur : element) {
        // 'valeur' représente chaque chaîne de caractères dans la sous-liste actuelle
            System.out.print(valeur + " ---> ");
    }

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
