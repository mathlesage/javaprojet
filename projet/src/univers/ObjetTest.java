package univers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


/**
Classe Test de la classe Objet
@author ABDELOUHAB Yacine
*/

class ObjetTest {
	
	public Objet Objet_test;
	
	@BeforeEach
	public void init_inventaire_test() {
		Objet_test = new Objet();
	}
	
	
	@ParameterizedTest
	@CsvSource({"Fusil,0,10","Insecticide,6,3","Sac,8,124"})
	public void setQuantiteTest_NomExistant_Quantite_positive(String arg1,int pos_tab,int q) {
		Objet_test.setQuantite(arg1,q);
		assertEquals(q,Objet_test.getQuantite(arg1));
	}
	
	@Test
	public void setQuantiteTest_NomExistant_Quantite_Negative(){
		boolean verif = false;
		try {
		Objet_test.setQuantite("Fusil",-10);
		}
		catch(ArithmeticException e) {
			if("Une quantite ne peut pas etre negative ! ".equals(e.getMessage())) {
				verif=true;
			}	
		}
		assertEquals(true,verif);	
	}
	
	
	@Test
	public void setQuantiteTest_NomInExistant_Quantite_Positive(){
		boolean verif = false;
		try {
		Objet_test.setQuantite("usil",10);
		}
		catch(IllegalArgumentException e) {
			if("Objet inexistant ! ".equals(e.getMessage())) {
				verif=true;
			}	
		}
		assertEquals(true,verif);	
	}

	@Test
	public void setQuantiteTest_NomInExistant_Quantite_Negative(){
		boolean verif = false;
		try {
		Objet_test.setQuantite("usil",-10);
		}
		catch(IllegalArgumentException e) {
			if("Objet inexistant ! ".equals(e.getMessage())) {
				verif=true;
			}	
		}
		catch(ArithmeticException e) {
			if("Une quantite ne peut pas etre negative ! ".equals(e.getMessage())) {
				verif=true;
			}	
		}
		assertEquals(true,verif);	
	}
	
	@Test
	public void getQuantiteTest_NomExistant_sansRajout() {
		assertEquals(0,Objet_test.getQuantite("Fusil"));
	}
	
	@Test
	public void getQuantiteTest_NomExistant_avecRajout() {
		Objet_test.setQuantite("Fusil",188);
		assertEquals(188,Objet_test.getQuantite("Fusil"));
	}
	
	@Test
	public void getQuantiteTest_NomInExistant() {
		boolean verif = false;
		try {
			Objet_test.getQuantite("fusil"); //F en minuscule
		}
		catch(IllegalArgumentException e){
			if("Objet inexistant ! ".equals(e.getMessage())) {
				verif = true;
			}
		}
		assertEquals(true,verif);	
	}
	
	
	
	

}
