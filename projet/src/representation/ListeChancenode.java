package Representation;

import java.util.ArrayList;

public class ListeChancenode {

    private ArrayList<ChanceNode> liste = new ArrayList<ChanceNode>();

    public ListeChancenode() {

        // Modifier une banane
        ChanceNode chance1 = new ChanceNode("Une ration de pâte a disparu, réduisant les provisions.",
                "Une ration de pâte est à déplorer", 1, 1, "Pate");
        ChanceNode chance2 = new ChanceNode(
                "Deux paquets de pâtes manquent désormais, épuisant davantage les réserves.",
                "Deux rations de pâte ont disparu, accentuant la pénurie de provisions.", 2, 2, "Pate");
        ChanceNode chance3 = new ChanceNode(
                "Trois sachets de pâtes ont disparu, amplifiant la tension dans la lutte pour les ressources.",
                "Trois sachets de pâtes perdues, intensifiant le poids de la privation alimentaire.", 3, 3, "Pate");
        ChanceNode chance5 = new ChanceNode(
                "Suite à cet événement tragique, toutes les pâtes ont été perdues, créant un vide dans les provisions.",
                "Un événement malheureux a conduit à la perte de toutes les pâtes, laissant un vide dans les réserves alimentaires.",
                5, 5, "Pate");
        ChanceNode chance6 = new ChanceNode("Les réserves de pâtes ont doublé, offrant un répit dans les provisions.",
                "Le stock de pâtes a été doublé, apportant un soulagement bienvenu aux réserves alimentaires.", 6, 6,
                "Pate");
        ChanceNode chance7 = new ChanceNode("Une ration de pâte a été ajoutée, renforçant les provisions.",
                "Une nouvelle ration de pâte a été acquise, renforçant les réserves.", 7, 7, "Pate");
        ChanceNode chance8 = new ChanceNode("L'ajout de deux sachets de pâtes renforce les provisions.",
                "Deux nouvelles rations de pâtes ont été acquises, consolidant les réserves.", 8, 8, "Pate");
        ChanceNode chance9 = new ChanceNode("Trois nouveaux sachets de pâtes enrichissent les provisions.",
                "L'acquisition de trois rations supplémentaires consolide les réserves.", 9, 9, "Pate");

        liste.add(chance1);
        liste.add(chance2);
        liste.add(chance3);
        liste.add(chance5);
        liste.add(chance6);
        liste.add(chance7);
        liste.add(chance8);
        liste.add(chance9);

    }

    public ArrayList<ChanceNode> getListe() {
        return liste;
    }

}