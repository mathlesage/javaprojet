package univers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class PersonnagesTest {

	Personnages perso_test;
	
	@BeforeEach
	public void init_perso_test() {
		perso_test = new Personnages(Personnages_du_jeu.Pere);
	}
	
	@Test
	public void to_String_test() {
		perso_test.to_String_Generaux();
		assertEquals(true,true);
	}
	
	@Test
	public void maj_naturelle_attributs_generaux_Personnages_Test_tjr_vivant(){
		this.perso_test.maj_naturelle_attributs_generaux_Personnages();
		boolean verif = false;
		if(this.perso_test.get_barre_eau() == 67 && this.perso_test.get_barre_nourriture() == 80 && this.perso_test.get_barre_mentale() == 75 && this.perso_test.get_barre_energie() == 90 && this.perso_test.get_etat_global()== Etat_Personnages.Sain  ) {
			
			verif = true;
		}
		assertEquals(true,verif);
	}
	
	@Test
	public void maj_naturelle_attributs_generaux_Personnages_Test_mort(){
		this.perso_test.maj_naturelle_attributs_generaux_Personnages();
		this.perso_test.maj_naturelle_attributs_generaux_Personnages();
		this.perso_test.maj_naturelle_attributs_generaux_Personnages();
		this.perso_test.maj_naturelle_attributs_generaux_Personnages();
		this.perso_test.maj_naturelle_attributs_generaux_Personnages();
		boolean verif = false;
		if( this.perso_test.get_etat_global()== Etat_Personnages.Mort  ) {
			verif = true;
		}
		assertEquals(true,verif);
	}
	
	public void maj_contamination_virus_Personnages_Test() {
		this.perso_test.maj_contamination_virus_Personnages();
		boolean verif = false;
		if(this.perso_test.get_etat_malade() == Etat_Personnages.Malade && this.perso_test.get_force() == 3 && this.perso_test.get_conso_nourriture() == 3 && this.perso_test.get_intelligence() == 0 && this.perso_test.get_resistance()== 0 && this.perso_test.get_agilite() == 0 ) {
			verif = true;
		}
		assertEquals(true,verif);
	}
	
	public void maj_contamination_virus_Personnages_Test_guerison() {
		this.perso_test.maj_contamination_virus_Personnages();
		this.perso_test.set_temps_malade_virus(10);
		this.perso_test.maj_donnee_etat_naturelle_Personnages();
		boolean verif = false;
		if(this.perso_test.get_etat_malade() == Etat_Personnages.PasMalade && this.perso_test.get_force() == 8 && this.perso_test.get_conso_nourriture() == 8 && this.perso_test.get_intelligence() == 5 && this.perso_test.get_resistance()== 5 && this.perso_test.get_agilite() == 3 ) {
			verif = true;
		}
		assertEquals(true,verif);
	}
	
	
}
