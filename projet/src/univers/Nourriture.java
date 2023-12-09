package univers;


/**
  Classe Nourriture, permet de connaitre le nombre des differents aliments present dans la cave ou pas.
  @author ABDELOUHAB Yacine QUATREBOEUFS Matheo
*/
public class Nourriture extends Objet{

    public Nourriture() {

        Un_element banane=new Un_element(Elements_du_jeu.BANANE,0);
        inventaire.add(banane);

        Un_element pate=new Un_element(Elements_du_jeu.PATE,0);
        inventaire.add(pate);

        Un_element friandise=new Un_element(Elements_du_jeu.FRANDISE,0);
        inventaire.add(friandise);

        Un_element eau=new Un_element(Elements_du_jeu.EAU,0);
        inventaire.add(eau);

        Un_element soda=new Un_element(Elements_du_jeu.SODA,0);
        inventaire.add(soda);
    }

    	@Override
    public int getQuantite(String nom) throws IllegalArgumentException{
      try{
        return super.getQuantite(nom);
      }
      catch(IllegalArgumentException e){
        throw new IllegalArgumentException("Aliment inexistant !");
      }
    }
    	
    	
    	@Override
    public void setQuantite(String nom, int q) throws IllegalArgumentException,ArithmeticException{
      try{
        super.setQuantite(nom,q);
      }
      catch(IllegalArgumentException e){
        throw new IllegalArgumentException("Aliment inexistant !");
      }
      catch(ArithmeticException e){
        throw new ArithmeticException(e.getMessage());
      }

    }

    public int getNourrissant(String nom) throws IllegalArgumentException {

        boolean verif = false;
        for(Un_element aliment : inventaire){
            if(nom.equals(aliment.getNom())){
                return aliment.getNourrissant();
            }
        }
        if(!verif){
          throw new IllegalArgumentException("Aliment Inexistant !");
        }
        return -1; //Probleme non gere
      }

    public int getEnergie(String nom) throws IllegalArgumentException{

        boolean verif = false;
        for(Un_element aliment : inventaire){
            if(nom.equals(aliment.getNom())){
                return aliment.getEnergie();
            }
        }
        if(!verif){
          throw new IllegalArgumentException("Aliment Inexistant !");
        }
        return -1; //Probleme non gere
}

    public int getHydratation(String nom) throws IllegalArgumentException{
        boolean verif = false;
        for(Un_element aliment : inventaire){
            if(nom.equals(aliment.getNom())){
                return aliment.getHydratation();
            }
        }
        if(!verif){
          throw new IllegalArgumentException("Aliment Inexistant !");
        }
        return -1; //Probleme non gere
    }
}
