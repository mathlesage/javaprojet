package univers;

import java.util.ArrayList;

public class Nourriture extends Inventaire{
    private ArrayList<Un_aliment> inventaire = new ArrayList<Un_aliment>();
    public Nourriture() {
        int r=0;
        Un_aliment banane=new Un_aliment(NomObjet.BANANE,r,3,2,0);
        inventaire.add(banane);

        Un_aliment pate=new Un_aliment(NomObjet.PATE,r,1,3,0);
        inventaire.add(pate);

        Un_aliment friandise=new Un_aliment(NomObjet.FRANDISE,r,3,1,0);
        inventaire.add(friandise);

        Un_aliment eau=new Un_aliment(NomObjet.EAU,r,0,0,3);
        inventaire.add(eau);

        Un_aliment soda=new Un_aliment(NomObjet.SODA,r,3,0,2);
        inventaire.add(soda);
    }

    public int getNourriture(String nom) {
        for(Un_aliment aliment : inventaire){
            if(nom.equals(aliment.getnom())){
                return aliment.getnourrissant();
            }
        }
        return 0;
    
}

    public int getEnergie(String nom) {
        for(Un_aliment aliment : inventaire){
            if(nom.equals(aliment.getnom())){
                return aliment.getEnergie();
            }
        }
        return 0;
    
}
public void getQuantites() {
            
    for (Un_objet obj : inventaire) {

        System.out.print(obj.getnom());
        System.out.print(" ---> ");
        System.out.print(obj.getquantite());
        System.out.println(); // Saut de ligne entre chaque sous-liste
}

}}