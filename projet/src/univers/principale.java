package univers;
import Representation.*;
public class principale {

	public static void main(String[] args) {
             Nourriture nourriture = new Nourriture();
             Objet objet = new Objet();
             System.out.println(nourriture.getQuantite("pate"));
             nourriture.setQuantite("pate", 3);
             System.out.println(nourriture.getQuantite("pate"));
}
}