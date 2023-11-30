package univers;

import java.util.ArrayList;

public class  Objet extends Inventaire {
    private ArrayList<Un_objet> inventaire = new ArrayList<Un_objet>();
    public Objet() {Un_objet fusil = new Un_objet(NomObjet.FUSIL, 0);
        inventaire.add(fusil);
        
        Un_objet boiteOutils = new Un_objet(NomObjet.BOITE_OUTILS, 0);
        inventaire.add(boiteOutils);
        
        Un_objet katana = new Un_objet(NomObjet.KATANA, 0);
        inventaire.add(katana);
        
        Un_objet carteVille = new Un_objet(NomObjet.CARTE_VILLE, 0);
        inventaire.add(carteVille);
        
        Un_objet echec = new Un_objet(NomObjet.ECHEC, 0);
        inventaire.add(echec);
        
        Un_objet carteJoue = new Un_objet(NomObjet.CARTE_JOUE, 0);
        inventaire.add(carteJoue);
        
        Un_objet insecticide = new Un_objet(NomObjet.INSECTICIDE, 0);
        inventaire.add(insecticide);
        
        Un_objet hache = new Un_objet(NomObjet.HACHE, 0);
        inventaire.add(hache);
        
        Un_objet sac = new Un_objet(NomObjet.SAC, 0);
        inventaire.add(sac);
        
        Un_objet trousse = new Un_objet(NomObjet.TROUSSE, 0);
        inventaire.add(trousse);
        
        Un_objet radio = new Un_objet(NomObjet.RADIO, 0);
        inventaire.add(radio);
        
        Un_objet lampe = new Un_objet(NomObjet.LAMPE, 0);
        inventaire.add(lampe);
        
        Un_objet pile = new Un_objet(NomObjet.PILE, 0);
        inventaire.add(pile);
    }
    public int getQuantite(String nom) {
        return super.getQuantite(nom);
}
    public void setQuantite(String nom, int q) {
        super.setQuantite(nom, q);
}
    
}
