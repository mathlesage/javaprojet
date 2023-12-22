package univers;


/**
  Classe Nourriture, permet de connaitre le nombre des differents aliments present dans la cave ou pas.
  @author ABDELOUHAB Yacine QUATREBOEUFS Matheo
*/
public class Nourriture extends Objet{

	/**
	 * Constructeur par defaut de la classe
	*/
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

    
    /**
     * Getters pour la quantite
     * @param nom Nom de la Nourriture
     * @throws IllegalArgumentException Nourriture Inexistante
     * @return la quantite disponible dans l'inventaire
     * */
    	@Override
    public int getQuantite(String nom) throws IllegalArgumentException{
      try{
        return super.getQuantite(nom);
      }
      catch(IllegalArgumentException e){
        throw new IllegalArgumentException("Aliment inexistant !");
      }
    }
    	
    	
    	
    /**
     * Setters pour la quantite
     * @param nom Nom de la Nourriture
     * @param q Quantite que l'on veut mettre a jour
     * @throws IllegalArgumentException Nourriture Inexistante
    */
    	@Override
    public void setQuantite(String nom, int q) throws IllegalArgumentException{
      try{
        super.setQuantite(nom,q);
      }
      catch(IllegalArgumentException e){
        throw new IllegalArgumentException("Aliment inexistant !");
      }
    }

    	
    	
    	
    /** Getters pour connaitre le pouvoir nourrisant de l'aliment
     * @param nom Nom de la nourriture
     * @throws IllegalArgumentException Nourriture Inexistante
     * @return Pouvoir Nourrisant
     * */
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

    /** Getters pour connaitre le pouvoir energisant de l'aliment
     * @param nom Nom de la nourriture
     * @throws IllegalArgumentException Nourriture Inexistante
     * @return Pouvoir Energisant
     * */
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

    
    /** Getters pour connaitre le pouvoir hydratant de l'aliment
     * @param nom Nom de la nourriture
     * @throws IllegalArgumentException Nourriture Inexistante
     * @return Pouvoir Hydratant
     * */
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
    
    
    /** Nourriture Disponible ou pas dans notre inventaire
     * @return Oui si au moins un aliment disponible, Non sinon.
     * */
    public boolean get_nourriture_dispo() {
  	  for(Un_element e : inventaire) {
  		  if(e.getQuantite() > 0) {
  			  return true;
  		  }
  	  }
  	  return false;
    }

}
