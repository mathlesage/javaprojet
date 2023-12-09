package univers;
import java.util.ArrayList;


/**
  Classe Objet, permet de connaitre le nombre des differents objets present dans la cave ou pas.
  @author QUATREBOEUFS Matheo
*/

public class Objet implements Inventaire {

    protected ArrayList<Un_element> inventaire = new ArrayList<Un_element>();

    public Objet() {

        Un_element fusil = new Un_element(Elements_du_jeu.FUSIL, 0);
        inventaire.add(fusil);

        Un_element boiteOutils = new Un_element(Elements_du_jeu.BOITE_OUTILS, 0);
        inventaire.add(boiteOutils);

        Un_element katana = new Un_element(Elements_du_jeu.KATANA, 0);
        inventaire.add(katana);

        Un_element carteVille = new Un_element(Elements_du_jeu.CARTE_VILLE, 0);
        inventaire.add(carteVille);

        Un_element echec = new Un_element(Elements_du_jeu.ECHEC, 0);
        inventaire.add(echec);

        Un_element carteJoue = new Un_element(Elements_du_jeu.CARTE_JOUE, 0);
        inventaire.add(carteJoue);

        Un_element insecticide = new Un_element(Elements_du_jeu.INSECTICIDE, 0);
        inventaire.add(insecticide);

        Un_element hache = new Un_element(Elements_du_jeu.HACHE, 0);
        inventaire.add(hache);

        Un_element sac = new Un_element(Elements_du_jeu.SAC, 0);
        inventaire.add(sac);

        Un_element trousse = new Un_element(Elements_du_jeu.TROUSSE, 0);
        inventaire.add(trousse);

        Un_element radio = new Un_element(Elements_du_jeu.RADIO, 0);
        inventaire.add(radio);

        Un_element lampe = new Un_element(Elements_du_jeu.LAMPE, 0);
        inventaire.add(lampe);

        Un_element pile = new Un_element(Elements_du_jeu.PILE, 0);
        inventaire.add(pile);
    }

    public int getQuantite(String nom) throws IllegalArgumentException{
      for(Un_element obj : inventaire) {
          if(nom.equals(obj.getNom())) {
              return obj.getQuantite();
          }
      }
      throw new IllegalArgumentException("Objet inexistant ! ");
    }

    public void setQuantite(String nom, int q) throws IllegalArgumentException,ArithmeticException{

        boolean verif = false;
        for(Un_element obj : inventaire) {
            if(nom.equals(obj.getNom())) {
                try{
                  obj.setQuantite(q);
                }
                catch(ArithmeticException e){
                  throw new ArithmeticException(e.getMessage());
                }
                verif = true;
            }
        }

        if(!verif){
          throw new IllegalArgumentException("Objet inexistant ! ");
        }
    }

    public void getQuantites() {

      for (Un_element obj : inventaire) {
          System.out.print(obj.getNom());
          System.out.print(" ---> ");
          System.out.print(obj.getQuantite());
          System.out.println(); // Saut de ligne entre chaque sous-liste
      }
    }

}
