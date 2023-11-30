package univers;
import Representation.*;
public class principale {

	public static void main(String[] args) {
             Nourriture nourriture = new Nourriture();
             Objet objet = new Objet();
             System.out.println(nourriture.getQuantite("Pate"));
             nourriture.setQuantite("Pate", 3);
             System.out.println(nourriture.getQuantite("Pate"));
             objet.setQuantite("Fusil", 1);
             System.out.println(objet.getQuantite("Fusil"));



            Un_aliment pate=new Un_aliment(NomObjet.PATE,0,1,3,0);
            pate.setQuantite(3);
            System.out.println(pate.getquantite());
            System.out.println(NomObjet.PATE.getNom());
            nourriture.getQuantites();

}
}