package Representation;

import java.util.ArrayList;

public class ListeChancenode {

    private ArrayList<ChanceNode> liste = new ArrayList<ChanceNode>();

    public ListeChancenode() {

        // Modifier les pates
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

        ChanceNode chance11 = new ChanceNode("Perte d'une banane, réduisant les provisions.",
                "Une banane est à déplorer", 11, 1, "Banane");
        ChanceNode chance12 = new ChanceNode("Deux bananes manquent désormais, épuisant davantage les réserves.",
                "Deux bananes ont disparu, accentuant la pénurie de provisions.", 12, 2, "Banane");
        ChanceNode chance13 = new ChanceNode(
                "Trois bananes ont disparu, amplifiant la tension dans la lutte pour les ressources.",
                "Trois bananes perdues, intensifiant le poids de la privation alimentaire.", 13, 3, "Banane");
        ChanceNode chance15 = new ChanceNode("Perte de toutes les bananes, créant un vide dans les provisions.",
                "Toutes les bananes ont été perdues, laissant un vide dans les réserves alimentaires.", 15, 5,
                "Banane");
        ChanceNode chance16 = new ChanceNode(
                "Doublement des réserves de bananes, offrant un répit dans les provisions.",
                "Les réserves de bananes ont doublé, apportant un soulagement bienvenu aux réserves alimentaires.", 16,
                6, "Banane");
        ChanceNode chance17 = new ChanceNode("Ajout d'une banane, renforçant les provisions.",
                "Une nouvelle banane a été acquise, renforçant les réserves.", 17, 7, "Banane");
        ChanceNode chance18 = new ChanceNode("Ajout de deux bananes renforçant les provisions.",
                "Deux nouvelles bananes ont été acquises, consolidant les réserves.", 18, 8, "Banane");
        ChanceNode chance19 = new ChanceNode("Ajout de trois nouvelles bananes, enrichissant les provisions.",
                "Trois nouvelles bananes ont été acquises, enrichissant les réserves.", 19, 9, "Banane");

        ChanceNode chance21 = new ChanceNode("Une friandise a disparu, réduisant les provisions.",
                "Une friandise est à déplorer.", 21, 1, "Friandise");
        ChanceNode chance22 = new ChanceNode("Deux friandises manquent désormais, épuisant davantage les réserves.",
                "La disparition de deux friandises accentue la pénurie de provisions.", 22, 2, "Friandise");
        ChanceNode chance23 = new ChanceNode(
                "Trois friandises ont disparu, amplifiant la tension dans la lutte pour les ressources.",
                "La perte de trois friandises intensifie le poids de la privation alimentaire.", 23, 3, "Friandise");
        ChanceNode chance25 = new ChanceNode("Perte de toutes les friandises, créant un vide dans les provisions.",
                "La totalité des friandises a été perdue, laissant un vide dans les réserves alimentaires.", 25, 5,
                "Friandise");
        ChanceNode chance26 = new ChanceNode(
                "Doublement des réserves de friandises, offrant un répit dans les provisions.",
                "Le stock de friandises a doublé, apportant un soulagement aux réserves alimentaires.", 26, 6,
                "Friandise");
        ChanceNode chance27 = new ChanceNode("Ajout d'une friandise, renforçant les provisions.",
                "L'acquisition d'une nouvelle friandise renforce les réserves.", 27, 7, "Friandise");
        ChanceNode chance28 = new ChanceNode("Ajout de deux friandises renforçant les provisions.",
                "L'acquisition de deux nouvelles friandises consolide les réserves.", 28, 8, "Friandise");
        ChanceNode chance29 = new ChanceNode("Ajout de trois nouvelles friandises, enrichissant les provisions.",
                "L'acquisition de trois nouvelles friandises enrichit les réserves.", 29, 9, "Friandise");

        ChanceNode chance31 = new ChanceNode("Une bouteille d'eau a disparu, réduisant les réserves.",
                "Une bouteille d'eau manque.", 31, 1, "Eau");
        ChanceNode chance32 = new ChanceNode(
                "Deux bouteilles d'eau manquent désormais, épuisant davantage les réserves.",
                "La disparition de deux bouteilles d'eau accentue la pénurie de réserves.", 32, 2, "Eau");
        ChanceNode chance33 = new ChanceNode(
                "Trois bouteilles d'eau ont disparu, amplifiant la tension dans la lutte pour les ressources.",
                "La perte de trois bouteilles d'eau intensifie le poids de la privation.", 33, 3, "Eau");
        ChanceNode chance35 = new ChanceNode("Perte de toutes les bouteilles d'eau, créant un vide dans les réserves.",
                "Toutes les bouteilles d'eau ont été perdues, laissant un vide dans les réserves.", 35, 5, "Eau");
        ChanceNode chance36 = new ChanceNode("Doublement des réserves d'eau, offrant un répit dans les provisions.",
                "Le stock d'eau a doublé, apportant un soulagement aux réserves.", 36, 6, "Eau");
        ChanceNode chance37 = new ChanceNode("Ajout d'une bouteille d'eau, renforçant les réserves.",
                "L'acquisition d'une nouvelle bouteille d'eau renforce les réserves.", 37, 7, "Eau");
        ChanceNode chance38 = new ChanceNode("Ajout de deux bouteilles d'eau renforçant les réserves.",
                "L'acquisition de deux nouvelles bouteilles d'eau consolide les réserves.", 38, 8, "Eau");
        ChanceNode chance39 = new ChanceNode("Ajout de trois nouvelles bouteilles d'eau, enrichissant les réserves.",
                "L'acquisition de trois nouvelles bouteilles d'eau enrichit les réserves.", 39, 9, "Eau");

        liste.add(chance1);
        liste.add(chance2);
        liste.add(chance3);
        liste.add(chance5);
        liste.add(chance6);
        liste.add(chance7);
        liste.add(chance8);
        liste.add(chance9);
        liste.add(chance11);
        liste.add(chance12);
        liste.add(chance13);
        liste.add(chance15);
        liste.add(chance16);
        liste.add(chance17);
        liste.add(chance18);
        liste.add(chance19);
        liste.add(chance21);
        liste.add(chance22);
        liste.add(chance23);
        liste.add(chance25);
        liste.add(chance26);
        liste.add(chance27);
        liste.add(chance28);
        liste.add(chance29);

    }

    public ArrayList<ChanceNode> getListe() {
        return liste;
    }

    /*
     * 1. ChanceNode 1 : Perte d'une ration de pâte.
     * 2. ChanceNode 2 : Perte de deux rations de pâte.
     * 3. ChanceNode 3 : Disparition de trois rations de pâte.
     * 5. ChanceNode 5 : Perte de toutes les rations de pâte.
     * 6. ChanceNode 6 : Doublement des réserves de rations de pâte.
     * 7. ChanceNode 7 : Ajout d'une ration de pâte.
     * 8. ChanceNode 8 : Ajout de deux rations de pâte.
     * 9. ChanceNode 9 : Ajout de trois nouvelles rations de pâte.
     * 
     * 11 : Perte d'une banane.
     * 12 : Perte de deux bananes.
     * 13 : Disparition de trois bananes.
     * 15 : Perte de toutes les bananes.
     * 16 : Doublement des réserves de bananes.
     * 17 : Ajout d'une banane.
     * 18 : Ajout de deux bananes.
     * 19 : Ajout de trois nouvelles bananes.
     * 
     * 21 : Perte d'une friandise.
     * 22 : Perte de deux friandises.
     * 23 : Disparition de trois friandises.
     * 25 : Perte de toutes les friandises.
     * 26 : Doublement des réserves de friandises.
     * 27 : Ajout d'une friandise.
     * 28 : Ajout de deux friandises.
     * 29 : Ajout de trois nouvelles friandises.
     * 
     * 31 : Perte d'une bouteille d'eau.
     * 32 : Perte de deux bouteilles d'eau.
     * 33 : Disparition de trois bouteilles d'eau.
     * 35 : Perte de toutes les bouteilles d'eau.
     * 36 : Doublement des réserves d'eau.
     * 37 : Ajout d'une bouteille d'eau.
     * 38 : Ajout de deux bouteilles d'eau.
     * 39 : Ajout de trois nouvelles bouteilles d'eau.
     * 
     */
}