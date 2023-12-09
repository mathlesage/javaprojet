package univers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
Classe Test de la classe Un_element
@author ABDELOUHAB Yacine
*/

public class Un_element_Test {
	private Un_element un_element_test ;

	  @BeforeEach
	  public void init_un_element(){
	    un_element_test = new Un_element(Elements_du_jeu.BANANE,0);
	  }

	  @ParameterizedTest
	  @CsvSource({"1","2","3","1000"})
	  public void setQuantite_Test_Valeur_Correct(int arg1){
	    un_element_test.setQuantite(arg1);
	    assertEquals(arg1,un_element_test.getQuantite());
	  }

	  @Test
	  public void setQuantite_Test_Valeur_Incorrect(){
	    boolean verif = false;
	    try{
	      un_element_test.setQuantite(-1);
	    }
	    catch(ArithmeticException e){
	      verif = true;
	    }
	    assertEquals(true,verif);
	  }

}
