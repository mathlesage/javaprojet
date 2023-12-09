package univers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NourritureTest {

	public Nourriture nourriture_test;
	@BeforeEach
	public void init_inventaire_test() {
		nourriture_test = new Nourriture();
	}
	
	@ParameterizedTest
	@CsvSource({"Banane,0,10","Friandise,2,3","Soda,4,124"})
	public void setQuantiteTest_NomExistant_Quantite_positive(String arg1,int pos_tab,int q) {
		nourriture_test.setQuantite(arg1,q);
		assertEquals(q,nourriture_test.getQuantite(arg1));
	}
	
	@Test
	public void setQuantiteTest_NomExistant_Quantite_Negative(){
		boolean verif = false;
		try {
			nourriture_test.setQuantite("Banane",-10);
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
			nourriture_test.setQuantite("anane",10);
		}
		catch(IllegalArgumentException e) {
			if("Aliment inexistant !".equals(e.getMessage())) {
				verif=true;
			}	
		}
		assertEquals(true,verif);	
	}

	@Test
	public void setQuantiteTest_NomInExistant_Quantite_Negative(){
		boolean verif = false;
		try {
			nourriture_test.setQuantite("anane",-10);
		}
		catch(IllegalArgumentException e) {
			if("Aliment inexistant !".equals(e.getMessage())) {
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
		assertEquals(0,nourriture_test.getQuantite("Banane"));
	}
	
	@Test
	public void getQuantiteTest_NomExistant_avecRajout() {
		nourriture_test.setQuantite("Banane",188);
		assertEquals(188,nourriture_test.getQuantite("Banane"));
	}
	
	@Test
	public void getQuantiteTest_NomInExistant() {
		boolean verif = false;
		try {
			nourriture_test.getQuantite("anane"); //B en minuscule
		}
		catch(IllegalArgumentException e){
			if("Aliment inexistant !".equals(e.getMessage())) {
				verif = true;
			}
		}
		assertEquals(true,verif);	
	}
	
	
	@ParameterizedTest
	@CsvSource({"Banane, 2","Pate,3","Friandise,1","Eau,0","Soda,0"})
	public void getNourrisant_Test_NomExistant(String arg1,int arg2) {
		assertEquals(arg2,nourriture_test.getNourrissant(arg1));
	}
	
	@ParameterizedTest
	@CsvSource({"Banane, 0","Pate,0","Friandise,0","Eau,3","Soda,2"})
	public void getHydratation_Test_NomExistant(String arg1,int arg2) {
		assertEquals(arg2,nourriture_test.getHydratation(arg1));
	}
	
	@ParameterizedTest
	@CsvSource({"Banane, 3","Pate,1","Friandise,3","Eau,0","Soda,3"})
	public void getEnergie_Test_NomExistant(String arg1,int arg2) {
		assertEquals(arg2,nourriture_test.getEnergie(arg1));
	}
	
	@Test
	public void getNourrisant_Test_NomInExistant() {
		boolean verif = false;
		try{
			nourriture_test.getNourrissant("Anane");
		}
		catch(IllegalArgumentException e){
			if("Aliment Inexistant !".equals(e.getMessage())) {
				verif = true;
			}
		}
		assertEquals(true,verif);
	}
	
	@Test
	public void getHydratation_Test_NomInExistant() {
		boolean verif = false;
		try{
			nourriture_test.getHydratation("Anane");
		}
		catch(IllegalArgumentException e){
			if("Aliment Inexistant !".equals(e.getMessage())) {
				verif = true;
			}
		}
		assertEquals(true,verif);
	}
	
	@Test
	public void getEnergie_Test_NomInExistant() {
		boolean verif = false;
		try{
			nourriture_test.getEnergie("Anane");
		}
		catch(IllegalArgumentException e){
			if("Aliment Inexistant !".equals(e.getMessage())) {
				verif = true;
			}
		}
		assertEquals(true,verif);
	}
	

}
