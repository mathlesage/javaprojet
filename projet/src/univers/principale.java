package univers;
import Representation.*;
public class principale {

	public static void main(String[] args) {
		Objet a=new Objet();
		int p=a.getQuantite("Fusil");
		System.out.println(p);
		a.setQuantite("Hache", 1);
		int h=a.getQuantite("Hache");
		System.out.println(h);
		int b=a.getQuantite("Banane");
		System.out.println(b);
		a.setQuantite("Banane", 1);
		b=a.getQuantite("Bache");
		System.out.println(b);
		
		Nourriture nourriture=new Nourriture();
		nourriture.setQuantite("Banane",-5);
		b=nourriture.getQuantite("Banane");
		System.out.println(b);
		nourriture.setQuantite("Banane",15);
		b=nourriture.getQuantite("Banane");
		System.out.println(b);
		b=nourriture.getNourriture("Banane");
		System.out.println(b);
		b=nourriture.getEnergie("Banane");
		b=nourriture.getQuantite("Banane");
		System.out.println(b);
		a.setQuantites();
		
		int[] monTableau = {1, 2, 3, 4};
		int[] monTableau3 = {3, 2, 3, 4};
		int[] monTableau6 = {6, 2, 3, 4};
		Scenario_choix m=new Scenario_choix("banane",)
		public Scenario_choix(String histoire,monTableau[], monTableau3, monTableau6, int[] recompense4, int totalmental, int totalenergie,int totalsante,int totalforce, int totalintelligence, int totalresistance, int totalagilite){
}
}