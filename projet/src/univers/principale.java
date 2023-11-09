package univers;

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
		System.out.println(b);
		nourriture.setQuantite("Banane",-15);
		b=nourriture.getQuantite("Banane");
		System.out.println(b);
		a.setQuantites();
		

}
}