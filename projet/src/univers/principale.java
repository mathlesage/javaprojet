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
		Personnages perso1 = new Personnages(1);
        Personnages perso2 = new Personnages(2);
        Personnages perso3 = new Personnages(3);
        Personnages perso4 = new Personnages(4);
        Objet objet = new Objet();

        // Initialisez d'autres paramètres nécessaires pour le scénario
        float variableDebut = 0.5f;
        float variableFin = 0.8f;
        int jourDebut = 3;
        int jourFin = 7;
        int nombrePersonnage = 4;
        int[] scenarioNecessaire = {1, 2, 3}; // Supposons que c'est un tableau d'exigences quelconques
        int[] recompense1 = {10, 20, 30, 40};
        int[] recompense2 = {5, 10, 15, 20};
        int[] recompense3 = {50, 100, 150, 200};
        int totalMental = 100;
        int totalEnergie = 80;
        int totalSante = 120;
        int totalForce = 50;
        int totalIntelligence = 70;
        int totalResistance = 60;
        int totalAgilite = 90;

        // Créez une instance de Scenario_choix
        Scenario_choix scenario = new Scenario_choix(variableDebut, variableFin, jourDebut, jourFin, nombrePersonnage,
                scenarioNecessaire, "Une histoire intéressante", recompense1, recompense2, recompense3, new int[4],
                totalMental, totalEnergie, totalSante, totalForce, totalIntelligence, totalResistance, totalAgilite);

        // Appelez la méthode raconte_histoire
        int[] resultatRecompense = scenario.raconte_histoire(perso1, perso2, perso3, perso4, objet);

        // Affichez le résultat de la recompense
        System.out.println("Résultat de la recompense : " + java.util.Arrays.toString(resultatRecompense));
}
}