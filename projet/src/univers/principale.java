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

    }
}