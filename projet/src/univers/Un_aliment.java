package univers;

public class Un_aliment extends Un_objet{
    /*  Les aliment vont posseder en plus une variable energie et une varaible nourrissante 
    pour indiquer ce que cela va ajouter au personnages qui en consommes */
    private int energie; 
    private int nourrissant;
    private int soif;
    public Un_aliment(NomObjet objet, int quantite, int energie, int nourrissant, int soif){
        super(objet, quantite);
        this.energie = energie;
        this.nourrissant=nourrissant;
        this.soif = soif;
    }

    //getter de la viariable energie
    public int getEnergie(){
        return this.energie;
    }

    //getter de la viariable nourrissant
    public int getnourrissant(){
        return this.nourrissant;
    }

    public int getSoif(){
        return this.soif;

}
}
