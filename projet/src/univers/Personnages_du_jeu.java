package univers;


/**
Enumeration des personnages du jeu.
Un attribut identifiant et un attribut prenom.
@author ABDELOUHAB Yacine
*/
public enum Personnages_du_jeu {
	Pere(0,"Patrick"),
	Mere(1,"Stephanie"),
	Soeur(2,"Sarah"),
	Frere(3,"Matheo"),
	Medecin(4,"Paul"),
	Athlete(5,"Amine"),
	Cousin(6,"Yacine"),
	Cuisiniere(7,"Guilianetta");
	
	private int identifiant;
	private String prenom;
	
	Personnages_du_jeu(int id,String prenom){
		this.identifiant = id;	
		this.prenom = prenom;
	}
	
	/**Getters Identifiant
	 * @return Identifiant
	 * */
	public int getIdentifiant() {
		return this.identifiant;
	}
	
	/**Getters Prenom
	 * @return prenom
	 * */
	public String getPrenom() {
		return this.prenom;
	}

}
