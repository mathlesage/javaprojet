package univers;

import java.io.Serializable;


/**
 * Enumeration des differents etats des personnages
 * 
 * @author ABDELOUHAB Yacine
 */
public enum Etat_Personnages implements Serializable{
	
	//Etat global
	Vigoureux(80,100,"sante"),
	Sain(65,79,"sante"),
	Stable(50,64,"sante"),
	Affaibli(31,49,"sante"),
	Vulnerable(1,30,"sante"),
	Mort(0,0,"sante"),
	
	//Malade?
	PasMalade(-1,-1,"virus"),
	Malade(-1,-1,"virus"),
	
	
	//Energie ?
	Repose(30,100,"energie"),
	Fatigue(0,29,"energie"),
	
	
	//Mentale ?
	Heureux(50,100,"mentale"),
	Depressif(25,49,"mentale"),
	Fou(0,24,"mentale");
	

	private int borne_inf;
	private int borne_sup;
	private String attribut;

	
	Etat_Personnages(int arg1,int arg2,String arg3){
		this.borne_inf = arg1;
		this.borne_sup = arg2;
		this.attribut = arg3;
	}
	
	
	/**Getters
	 *@return la BorneInf pour avoir un certain etat. */
	public int getBorne_Inf() {
		return this.borne_inf;
	}
	
	/**Getters
	 *@return la BorneSup pour avoir un certain etat. */
	public int getBorne_Sup() {
		return this.borne_sup;
	}
	
	/**Getters
	 *@return la description de l'etat sous forme de chaine de caractere. */
	public String getAttribut() {
		return this.attribut;
	}

	
}
