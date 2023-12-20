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
                                "Trois sachets de pâtes perdues, intensifiant le poids de la privation alimentaire.", 3,
                                3, "Pate");
                ChanceNode chance5 = new ChanceNode(
                                "Suite à cet événement tragique, toutes les pâtes ont été perdues, créant un vide dans les provisions.",
                                "Un événement malheureux a conduit à la perte de toutes les pâtes, laissant un vide dans les réserves alimentaires.",
                                5, 5, "Pate");
                ChanceNode chance6 = new ChanceNode(
                                "Les réserves de pâtes ont doublé, offrant un répit dans les provisions.",
                                "Le stock de pâtes a été doublé, apportant un soulagement bienvenu aux réserves alimentaires.",
                                6, 6,
                                "Pate");
                ChanceNode chance7 = new ChanceNode("Une ration de pâte a été ajoutée, renforçant les provisions.",
                                "Une nouvelle ration de pâte a été acquise, renforçant les réserves.", 7, 7, "Pate");
                ChanceNode chance8 = new ChanceNode("L'ajout de deux sachets de pâtes renforce les provisions.",
                                "Deux nouvelles rations de pâtes ont été acquises, consolidant les réserves.", 8, 8,
                                "Pate");
                ChanceNode chance9 = new ChanceNode("Trois nouveaux sachets de pâtes enrichissent les provisions.",
                                "L'acquisition de trois rations supplémentaires consolide les réserves.", 9, 9, "Pate");

                ChanceNode chance11 = new ChanceNode("Perte d'une banane, réduisant les provisions.",
                                "Une banane est à déplorer", 11, 1, "Banane");
                ChanceNode chance12 = new ChanceNode(
                                "Deux bananes manquent désormais, épuisant davantage les réserves.",
                                "Deux bananes ont disparu, accentuant la pénurie de provisions.", 12, 2, "Banane");
                ChanceNode chance13 = new ChanceNode(
                                "Trois bananes ont disparu, amplifiant la tension dans la lutte pour les ressources.",
                                "Trois bananes perdues, intensifiant le poids de la privation alimentaire.", 13, 3,
                                "Banane");
                ChanceNode chance15 = new ChanceNode("Perte de toutes les bananes, créant un vide dans les provisions.",
                                "Toutes les bananes ont été perdues, laissant un vide dans les réserves alimentaires.",
                                15, 5,
                                "Banane");
                ChanceNode chance16 = new ChanceNode(
                                "Doublement des réserves de bananes, offrant un répit dans les provisions.",
                                "Les réserves de bananes ont doublé, apportant un soulagement bienvenu aux réserves alimentaires.",
                                16,
                                6, "Banane");
                ChanceNode chance17 = new ChanceNode("Ajout d'une banane, renforçant les provisions.",
                                "Une nouvelle banane a été acquise, renforçant les réserves.", 17, 7, "Banane");
                ChanceNode chance18 = new ChanceNode("Ajout de deux bananes renforçant les provisions.",
                                "Deux nouvelles bananes ont été acquises, consolidant les réserves.", 18, 8, "Banane");
                ChanceNode chance19 = new ChanceNode("Ajout de trois nouvelles bananes, enrichissant les provisions.",
                                "Trois nouvelles bananes ont été acquises, enrichissant les réserves.", 19, 9,
                                "Banane");

                ChanceNode chance21 = new ChanceNode("Une friandise a disparu, réduisant les provisions.",
                                "Une friandise est à déplorer.", 21, 1, "Friandise");
                ChanceNode chance22 = new ChanceNode(
                                "Deux friandises manquent désormais, épuisant davantage les réserves.",
                                "La disparition de deux friandises accentue la pénurie de provisions.", 22, 2,
                                "Friandise");
                ChanceNode chance23 = new ChanceNode(
                                "Trois friandises ont disparu, amplifiant la tension dans la lutte pour les ressources.",
                                "La perte de trois friandises intensifie le poids de la privation alimentaire.", 23, 3,
                                "Friandise");
                ChanceNode chance25 = new ChanceNode(
                                "Perte de toutes les friandises, créant un vide dans les provisions.",
                                "La totalité des friandises a été perdue, laissant un vide dans les réserves alimentaires.",
                                25, 5,
                                "Friandise");
                ChanceNode chance26 = new ChanceNode(
                                "Doublement des réserves de friandises, offrant un répit dans les provisions.",
                                "Le stock de friandises a doublé, apportant un soulagement aux réserves alimentaires.",
                                26, 6,
                                "Friandise");
                ChanceNode chance27 = new ChanceNode("Ajout d'une friandise, renforçant les provisions.",
                                "L'acquisition d'une nouvelle friandise renforce les réserves.", 27, 7, "Friandise");
                ChanceNode chance28 = new ChanceNode("Ajout de deux friandises renforçant les provisions.",
                                "L'acquisition de deux nouvelles friandises consolide les réserves.", 28, 8,
                                "Friandise");
                ChanceNode chance29 = new ChanceNode(
                                "Ajout de trois nouvelles friandises, enrichissant les provisions.",
                                "L'acquisition de trois nouvelles friandises enrichit les réserves.", 29, 9,
                                "Friandise");

                ChanceNode chance31 = new ChanceNode("Une bouteille d'eau a disparu, réduisant les réserves.",
                                "Une bouteille d'eau manque.", 31, 1, "Eau");
                ChanceNode chance32 = new ChanceNode(
                                "Deux bouteilles d'eau manquent désormais, épuisant davantage les réserves.",
                                "La disparition de deux bouteilles d'eau accentue la pénurie de réserves.", 32, 2,
                                "Eau");
                ChanceNode chance33 = new ChanceNode(
                                "Trois bouteilles d'eau ont disparu, amplifiant la tension dans la lutte pour les ressources.",
                                "La perte de trois bouteilles d'eau intensifie le poids de la privation.", 33, 3,
                                "Eau");
                ChanceNode chance35 = new ChanceNode(
                                "Perte de toutes les bouteilles d'eau, créant un vide dans les réserves.",
                                "Toutes les bouteilles d'eau ont été perdues, laissant un vide dans les réserves.", 35,
                                5, "Eau");
                ChanceNode chance36 = new ChanceNode(
                                "Doublement des réserves d'eau, offrant un répit dans les provisions.",
                                "Le stock d'eau a doublé, apportant un soulagement aux réserves.", 36, 6, "Eau");
                ChanceNode chance37 = new ChanceNode("Ajout d'une bouteille d'eau, renforçant les réserves.",
                                "L'acquisition d'une nouvelle bouteille d'eau renforce les réserves.", 37, 7, "Eau");
                ChanceNode chance38 = new ChanceNode("Ajout de deux bouteilles d'eau renforçant les réserves.",
                                "L'acquisition de deux nouvelles bouteilles d'eau consolide les réserves.", 38, 8,
                                "Eau");
                ChanceNode chance39 = new ChanceNode(
                                "Ajout de trois nouvelles bouteilles d'eau, enrichissant les réserves.",
                                "L'acquisition de trois nouvelles bouteilles d'eau enrichit les réserves.", 39, 9,
                                "Eau");

                ChanceNode chance41 = new ChanceNode("Une canette de soda a disparu, réduisant les réserves.",
                                "Une canette de soda manque.", 41, 1, "Soda");
                ChanceNode chance42 = new ChanceNode(
                                "Deux canettes de soda manquent désormais, épuisant davantage les réserves.",
                                "La disparition de deux canettes de soda accentue la pénurie de réserves.", 42, 2,
                                "Soda");
                ChanceNode chance43 = new ChanceNode(
                                "Trois canettes de soda ont disparu, amplifiant la tension dans la lutte pour les ressources.",
                                "La perte de trois canettes de soda intensifie le poids de la privation.", 43, 3,
                                "Soda");
                ChanceNode chance45 = new ChanceNode(
                                "Perte de toutes les canettes de soda, créant un vide dans les réserves.",
                                "Toutes les canettes de soda ont été perdues, laissant un vide dans les réserves.", 45,
                                5, "Soda");
                ChanceNode chance46 = new ChanceNode(
                                "Doublement des réserves de sodas, offrant un répit dans les provisions.",
                                "Le stock de sodas a doublé, apportant un soulagement aux réserves.", 46, 6, "Soda");
                ChanceNode chance47 = new ChanceNode("Ajout d'une canette de soda, renforçant les réserves.",
                                "L'acquisition d'une nouvelle canette de soda renforce les réserves.", 47, 7, "Soda");
                ChanceNode chance48 = new ChanceNode("Ajout de deux canettes de soda renforçant les réserves.",
                                "L'acquisition de deux nouvelles canettes de soda consolide les réserves.", 48, 8,
                                "Soda");
                ChanceNode chance49 = new ChanceNode(
                                "Ajout de trois nouvelles canettes de soda, enrichissant les réserves.",
                                "L'acquisition de trois nouvelles canettes de soda enrichit les réserves.", 49, 9,
                                "Soda");

                ChanceNode chance51 = new ChanceNode("Un fusil c'est enrayé", "Un fusil est tombé en morceaux.", 51, 11,
                                "Fusil");
                ChanceNode chance55 = new ChanceNode("Tous les fusils sont devenus inutilisables",
                                "Plus aucun fusil ne fonctionne.", 55, 15, "Fusil");
                ChanceNode chance57 = new ChanceNode("Un nouveau fusil est en stock.",
                                "Le stock enrichi d'un fusil neuf.", 57, 17, "Fusil");

                ChanceNode chance61 = new ChanceNode(
                                "Une boîte à outils est endommagée, réduisant les outils disponibles.",
                                "Une boîte à outils est endommagée.", 61, 11, "BoiteOutils");
                ChanceNode chance65 = new ChanceNode("Toutes les boîtes à outils sont devenues inutilisables.",
                                "Plus aucune boîte à outils ne fonctionne.", 65, 15, "BoiteOutils");
                ChanceNode chance67 = new ChanceNode("Une nouvelle boîte à outils est en stock.",
                                "Le stock s'est enrichi d'une boîte à outils neuve.", 67, 17, "BoiteOutils");

                ChanceNode chance71 = new ChanceNode("Un katana est endommagé, réduisant la disponibilité des armes.",
                                "Un katana est endommagé.", 71, 11, "Katana");
                ChanceNode chance75 = new ChanceNode("Tous les katanas sont devenus inutilisables.",
                                "Plus aucun katana ne fonctionne.", 75, 15, "Katana");
                ChanceNode chance77 = new ChanceNode("Un nouveau katana est en stock.",
                                "Le stock s'est enrichi d'un katana neuf.", 77, 17, "Katana");

                ChanceNode chance81 = new ChanceNode(
                                "Une carte de la ville est déchirée, rendant la navigation difficile.",
                                "Une carte de la ville est déchirée.", 81, 11, "CarteVille");
                ChanceNode chance85 = new ChanceNode("Toutes les cartes de la ville sont devenues illisibles.",
                                "Plus aucune carte de la ville n'est lisible.", 85, 15, "CarteVille");
                ChanceNode chance87 = new ChanceNode("Une nouvelle carte de la ville est en stock.",
                                "Le stock s'est enrichi d'une nouvelle carte de la ville.", 87, 17, "CarteVille");

                ChanceNode chance91 = new ChanceNode("L'objet Échec est endommagé, réduisant son efficacité.",
                                "L'objet Échec est endommagé.", 91, 11, "Echec");
                ChanceNode chance95 = new ChanceNode("Tous les objets Échec sont devenus inutilisables.",
                                "Plus aucun objet Échec n'est fonctionnel.", 95, 15, "Echec");
                ChanceNode chance97 = new ChanceNode("Un nouvel objet Échec est en stock.",
                                "Le stock s'est enrichi d'un nouvel objet Échec.", 97, 17, "Echec");

                ChanceNode chance101 = new ChanceNode(
                                "Une carte à jouer est abîmée, rendant son utilisation difficile.",
                                "Une carte à jouer est abîmée.", 101, 11, "CarteAJouer");
                ChanceNode chance105 = new ChanceNode("Toutes les cartes à jouer sont devenues illisibles.",
                                "Plus aucune carte à jouer n'est lisible.", 105, 15, "CarteAJouer");
                ChanceNode chance107 = new ChanceNode("Une nouvelle série de cartes à jouer est en stock.",
                                "Le stock s'est enrichi d'une nouvelle série de cartes à jouer.", 107, 17,
                                "CarteAJouer");

                ChanceNode chance111 = new ChanceNode("L'insecticide est presque vide, réduisant son efficacité.",
                                "L'insecticide est presque épuisé.", 111, 11, "Insecticide");
                ChanceNode chance115 = new ChanceNode("Tous les insecticides sont désormais vides.",
                                "Plus aucun insecticide n'est disponible.", 115, 15, "Insecticide");
                ChanceNode chance117 = new ChanceNode("Un nouvel insecticide est en stock.",
                                "Le stock s'est enrichi d'un nouvel insecticide.", 117, 17, "Insecticide");

                ChanceNode chance121 = new ChanceNode("Une hache est endommagée, réduisant son efficacité.",
                                "Une hache est endommagée.", 121, 11, "Hache");
                ChanceNode chance125 = new ChanceNode("Toutes les haches sont désormais inutilisables.",
                                "Plus aucune hache n'est fonctionnelle.", 125, 15, "Hache");
                ChanceNode chance127 = new ChanceNode("Une nouvelle hache est en stock.",
                                "Le stock s'est enrichi d'une nouvelle hache.", 127, 17, "Hache");

                ChanceNode chance131 = new ChanceNode("Un sac est déchiré, réduisant sa capacité de stockage.",
                                "Un sac est déchiré.", 131, 11, "Sac");
                ChanceNode chance135 = new ChanceNode("Tous les sacs sont désormais inutilisables.",
                                "Plus aucun sac n'est fonctionnel.", 135, 15, "Sac");
                ChanceNode chance137 = new ChanceNode("Un nouveau sac est en stock.",
                                "Le stock s'est enrichi d'un nouveau sac.", 137, 17, "Sac");

                ChanceNode chance141 = new ChanceNode("Une trousse est abîmée, réduisant sa capacité de stockage.",
                                "Une trousse est abîmée.", 141, 11, "Trousse");
                ChanceNode chance145 = new ChanceNode("Toutes les trousses sont désormais inutilisables.",
                                "Plus aucune trousse n'est fonctionnelle.", 145, 15, "Trousse");
                ChanceNode chance147 = new ChanceNode("Une nouvelle trousse est en stock.",
                                "Le stock s'est enrichi d'une nouvelle trousse.", 147, 17, "Trousse");

                ChanceNode chance151 = new ChanceNode("La radio est endommagée, réduisant sa capacité de transmission.",
                                "La radio est endommagée.", 151, 11, "Radio");
                ChanceNode chance155 = new ChanceNode("Toutes les radios sont désormais hors service.",
                                "Plus aucune radio n'est fonctionnelle.", 155, 15, "Radio");
                ChanceNode chance157 = new ChanceNode("Une nouvelle radio est en stock.",
                                "Le stock s'est enrichi d'une nouvelle radio.", 157, 17, "Radio");

                ChanceNode chance161 = new ChanceNode("La lampe est endommagée, réduisant sa luminosité.",
                                "La lampe est endommagée.", 161, 11, "Lampe");
                ChanceNode chance165 = new ChanceNode("Toutes les lampes sont désormais hors service.",
                                "Plus aucune lampe n'est fonctionnelle.", 165, 15, "Lampe");
                ChanceNode chance167 = new ChanceNode("Une nouvelle lampe est en stock.",
                                "Le stock s'est enrichi d'une nouvelle lampe.", 167, 17, "Lampe");

                ChanceNode chance200 = new ChanceNode("est devenu moins fort", " a perdu en muscle", 200, 100, 0);
                ChanceNode chance201 = new ChanceNode("est devenu plus fort", " a pris du muscle", 201, 101, 0);
                ChanceNode chance202 = new ChanceNode("consomme plus de nourriture", " a augmenté son appétit", 202,
                                102, 0);
                ChanceNode chance203 = new ChanceNode("consomme moins de nourriture", " a réduit son appétit", 203, 103,
                                0);
                ChanceNode chance204 = new ChanceNode("est devenue un intellectuel", "est devenue plus intelligent",
                                204, 104, 0);
                ChanceNode chance205 = new ChanceNode("a perdu de l'intelligence", "est moins intelligent", 205, 105,
                                0);
                ChanceNode chance206 = new ChanceNode("a gagné en agilité", "est plus agile", 206, 106, 0);
                ChanceNode chance207 = new ChanceNode("a perdu de l'agilité", "est moins agile", 207, 107, 0);
                ChanceNode chance208 = new ChanceNode("a gagné en résistance", "est plus résistant", 208, 108, 0);
                ChanceNode chance209 = new ChanceNode("a perdu de la résistance", "est moins résistant", 209, 109, 0);
                ChanceNode chance210 = new ChanceNode("est devenu plus fort partout", "est beaucoup plus fort", 210,
                                110, 0);
                ChanceNode chance211 = new ChanceNode("est devenu un légume", "est inactif", 211, 111, 0);
                ChanceNode chance212 = new ChanceNode("ne consomme plus rien", "ne se nourrit plus du tout", 212, 112,
                                0);
                ChanceNode chance213 = new ChanceNode("est accro à la nourriture", "a une forte dépendance alimentaire",
                                213, 113, 0);
                ChanceNode chance214 = new ChanceNode("est d'une intelligence hors norme",
                                "est extrêmement intelligent", 214, 114, 0);
                ChanceNode chance215 = new ChanceNode("est tombé malade", "est atteint d'une maladie", 215, 115, 0);

                ChanceNode chance220 = new ChanceNode("est devenu moins fort", " a perdu en muscle", 220, 100, 1);
                ChanceNode chance221 = new ChanceNode("est devenu plus fort", " a pris du muscle", 221, 101, 1);
                ChanceNode chance222 = new ChanceNode("consomme plus de nourriture", " a augmenté son appétit", 222,
                                102, 1);
                ChanceNode chance223 = new ChanceNode("consomme moins de nourriture", " a réduit son appétit", 223, 103,
                                1);
                ChanceNode chance224 = new ChanceNode("est devenue un intellectuel", "est devenue plus intelligent",
                                224, 104, 1);
                ChanceNode chance225 = new ChanceNode("a perdu de l'intelligence", "est moins intelligent", 225, 105,
                                1);
                ChanceNode chance226 = new ChanceNode("a gagné en agilité", "est plus agile", 226, 106, 1);
                ChanceNode chance227 = new ChanceNode("a perdu de l'agilité", "est moins agile", 227, 107, 1);
                ChanceNode chance228 = new ChanceNode("a gagné en résistance", "est plus résistant", 228, 108, 1);
                ChanceNode chance229 = new ChanceNode("a perdu de la résistance", "est moins résistant", 229, 109, 1);
                ChanceNode chance230 = new ChanceNode("est devenu plus fort partout", "est beaucoup plus fort", 230,
                                110, 1);
                ChanceNode chance231 = new ChanceNode("est devenu un légume", "est inactif", 231, 111, 1);
                ChanceNode chance232 = new ChanceNode("ne consomme plus rien", "ne se nourrit plus du tout", 232, 112,
                                1);
                ChanceNode chance233 = new ChanceNode("est accro à la nourriture", "a une forte dépendance alimentaire",
                                233, 113, 1);
                ChanceNode chance234 = new ChanceNode("est d'une intelligence hors norme",
                                "est extrêmement intelligent", 234, 114, 1);
                ChanceNode chance235 = new ChanceNode("est tombé malade", "est atteint d'une maladie", 235, 115, 1);

                ChanceNode chance240 = new ChanceNode("est devenu moins fort", " a perdu en muscle", 240, 100, 2);
                ChanceNode chance241 = new ChanceNode("est devenu plus fort", " a pris du muscle", 241, 101, 2);
                ChanceNode chance242 = new ChanceNode("consomme plus de nourriture", " a augmenté son appétit", 242,
                                102, 2);
                ChanceNode chance243 = new ChanceNode("consomme moins de nourriture", " a réduit son appétit", 243, 103,
                                2);
                ChanceNode chance244 = new ChanceNode("est devenue un intellectuel", "est devenue plus intelligent",
                                244, 104, 2);
                ChanceNode chance245 = new ChanceNode("a perdu de l'intelligence", "est moins intelligent", 245, 105,
                                2);
                ChanceNode chance246 = new ChanceNode("a gagné en agilité", "est plus agile", 246, 106, 2);
                ChanceNode chance247 = new ChanceNode("a perdu de l'agilité", "est moins agile", 247, 107, 2);
                ChanceNode chance248 = new ChanceNode("a gagné en résistance", "est plus résistant", 248, 108, 2);
                ChanceNode chance249 = new ChanceNode("a perdu de la résistance", "est moins résistant", 249, 109, 2);
                ChanceNode chance250 = new ChanceNode("est devenu plus fort partout", "est beaucoup plus fort", 250,
                                110, 2);
                ChanceNode chance251 = new ChanceNode("est devenu un légume", "est inactif", 251, 111, 2);
                ChanceNode chance252 = new ChanceNode("ne consomme plus rien", "ne se nourrit plus du tout", 252, 112,
                                2);
                ChanceNode chance253 = new ChanceNode("est accro à la nourriture", "a une forte dépendance alimentaire",
                                253, 113, 2);
                ChanceNode chance254 = new ChanceNode("est d'une intelligence hors norme",
                                "est extrêmement intelligent", 254, 114, 2);
                ChanceNode chance255 = new ChanceNode("est tombé malade", "est atteint d'une maladie", 255, 115, 2);

                ChanceNode chance260 = new ChanceNode("est devenu moins fort", " a perdu en muscle", 260, 100, 3);
                ChanceNode chance261 = new ChanceNode("est devenu plus fort", " a pris du muscle", 261, 101, 3);
                ChanceNode chance262 = new ChanceNode("consomme plus de nourriture", " a augmenté son appétit", 262,
                                102, 3);
                ChanceNode chance263 = new ChanceNode("consomme moins de nourriture", " a réduit son appétit", 263, 103,
                                3);
                ChanceNode chance264 = new ChanceNode("est devenue un intellectuel", "est devenue plus intelligent",
                                264, 104, 3);
                ChanceNode chance265 = new ChanceNode("a perdu de l'intelligence", "est moins intelligent", 265, 105,
                                3);
                ChanceNode chance266 = new ChanceNode("a gagné en agilité", "est plus agile", 266, 106, 3);
                ChanceNode chance267 = new ChanceNode("a perdu de l'agilité", "est moins agile", 267, 107, 3);
                ChanceNode chance268 = new ChanceNode("a gagné en résistance", "est plus résistant", 268, 108, 3);
                ChanceNode chance269 = new ChanceNode("a perdu de la résistance", "est moins résistant", 269, 109, 3);
                ChanceNode chance270 = new ChanceNode("est devenu plus fort partout", "est beaucoup plus fort", 270,
                                110, 3);
                ChanceNode chance271 = new ChanceNode("est devenu un légume", "est inactif", 271, 111, 3);
                ChanceNode chance272 = new ChanceNode("ne consomme plus rien", "ne se nourrit plus du tout", 272, 112,
                                3);
                ChanceNode chance273 = new ChanceNode("est accro à la nourriture", "a une forte dépendance alimentaire",
                                273, 113, 3);
                ChanceNode chance274 = new ChanceNode("est d'une intelligence hors norme",
                                "est extrêmement intelligent", 274, 114, 3);
                ChanceNode chance275 = new ChanceNode("est tombé malade", "est atteint d'une maladie", 275, 115, 3);

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
                liste.add(chance31);
                liste.add(chance32);
                liste.add(chance33);
                liste.add(chance35);
                liste.add(chance36);
                liste.add(chance37);
                liste.add(chance38);
                liste.add(chance39);
                liste.add(chance41);
                liste.add(chance42);
                liste.add(chance43);
                liste.add(chance45);
                liste.add(chance46);
                liste.add(chance47);
                liste.add(chance48);
                liste.add(chance49);
                liste.add(chance51);
                liste.add(chance55);
                liste.add(chance57);
                liste.add(chance61);
                liste.add(chance65);
                liste.add(chance67);
                liste.add(chance71);
                liste.add(chance75);
                liste.add(chance77);
                liste.add(chance81);
                liste.add(chance85);
                liste.add(chance87);
                liste.add(chance91);
                liste.add(chance95);
                liste.add(chance97);
                liste.add(chance101);
                liste.add(chance105);
                liste.add(chance107);
                liste.add(chance111);
                liste.add(chance115);
                liste.add(chance117);
                liste.add(chance121);
                liste.add(chance125);
                liste.add(chance127);
                liste.add(chance131);
                liste.add(chance135);
                liste.add(chance137);
                liste.add(chance141);
                liste.add(chance145);
                liste.add(chance147);
                liste.add(chance151);
                liste.add(chance155);
                liste.add(chance157);
                liste.add(chance161);
                liste.add(chance165);
                liste.add(chance167);
                liste.add(chance200);
                liste.add(chance201);
                liste.add(chance202);
                liste.add(chance203);
                liste.add(chance204);
                liste.add(chance205);
                liste.add(chance206);
                liste.add(chance207);
                liste.add(chance208);
                liste.add(chance209);
                liste.add(chance210);
                liste.add(chance211);
                liste.add(chance212);
                liste.add(chance213);
                liste.add(chance214);
                liste.add(chance215);
                liste.add(chance220);
                liste.add(chance221);
                liste.add(chance222);
                liste.add(chance223);
                liste.add(chance224);
                liste.add(chance225);
                liste.add(chance226);
                liste.add(chance227);
                liste.add(chance228);
                liste.add(chance229);
                liste.add(chance230);
                liste.add(chance231);
                liste.add(chance232);
                liste.add(chance233);
                liste.add(chance234);
                liste.add(chance235);
                liste.add(chance240);
                liste.add(chance241);
                liste.add(chance242);
                liste.add(chance243);
                liste.add(chance244);
                liste.add(chance245);
                liste.add(chance246);
                liste.add(chance247);
                liste.add(chance248);
                liste.add(chance249);
                liste.add(chance250);
                liste.add(chance251);
                liste.add(chance252);
                liste.add(chance253);
                liste.add(chance254);
                liste.add(chance255);
                liste.add(chance260);
                liste.add(chance261);
                liste.add(chance262);
                liste.add(chance263);
                liste.add(chance264);
                liste.add(chance265);
                liste.add(chance266);
                liste.add(chance267);
                liste.add(chance268);
                liste.add(chance269);
                liste.add(chance270);
                liste.add(chance271);
                liste.add(chance272);
                liste.add(chance273);
                liste.add(chance274);
                liste.add(chance275);

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
         * 41 : Perte d'une canette de soda.
         * 42 : Perte de deux canettes de soda.
         * 43 : Disparition de trois canettes de soda.
         * 45 : Perte de toutes les canettes de soda.
         * 46 : Doublement des réserves de sodas.
         * 47 : Ajout d'une canette de soda.
         * 48 : Ajout de deux canettes de soda.
         * 49 : Ajout de trois nouvelles canettes de soda.
         * 
         * 61 : Une boîte à outils est endommagée.
         * 65 : Toutes les boîtes à outils sont devenues inutilisables.
         * 67 : Ajout d'une nouvelle boîte à outils.
         * 71 : Un katana est endommagé.
         * 75 : Tous les katanas sont devenus inutilisables.
         * 77 : Ajout d'un nouveau katana.
         * 81 : Une carte de la ville est déchirée.
         * 85 : Toutes les cartes de la ville sont devenues illisibles.
         * 87 : Ajout d'une nouvelle carte de la ville.
         * 91 : L'objet Échec est endommagé.
         * 95 : Tous les objets Échec sont devenus inutilisables.
         * 97 : Ajout d'un nouvel objet Échec.
         * 101 : Une carte à jouer est abîmée.
         * 105 : Toutes les cartes à jouer sont devenues illisibles.
         * 107 : Ajout d'une nouvelle série de cartes à jouer.
         * 111 : L'insecticide est presque vide.
         * 115 : Tous les insecticides sont désormais vides.
         * 117 : Ajout d'un nouvel insecticide.
         * 121 : Une hache est endommagée.
         * 125 : Toutes les haches sont désormais inutilisables.
         * 127 : Ajout d'une nouvelle hache.
         * 131 : Un sac est déchiré.
         * 135 : Tous les sacs sont désormais inutilisables.
         * 137 : Ajout d'un nouveau sac.
         * 141 : Une trousse est abîmée.
         * 145 : Toutes les trousses sont désormais inutilisables.
         * 147 : Ajout d'une nouvelle trousse.
         * 151 : La radio est endommagée.
         * 155 : Toutes les radios sont désormais hors service.
         * 157 : Ajout d'une nouvelle radio.
         * 161 : La lampe est endommagée.
         * 165 : Toutes les lampes sont désormais hors service.
         * 167 : Ajout d'une nouvelle lampe.
         * 200 : Le perso 0 est devenue moins fort
         * 200 : Le personnage 0 est devenu moins fort.
         * 201 : Le personnage 0 est devenu plus fort.
         * 202 : Le personnage 0 consomme plus de nourriture.
         * 203 : Le personnage 0 consomme moins de nourriture.
         * 204 : Le personnage 0 est devenu un intellectuel.
         * 205 : Le personnage 0 a perdu de l'intelligence.
         * 206 : Le personnage 0 a gagné en agilité.
         * 207 : Le personnage 0 a perdu de l'agilité.
         * 208 : Le personnage 0 a gagné en résistance.
         * 209 : Le personnage 0 a perdu de la résistance.
         * 210 : Le personnage 0 est devenu plus fort partout.
         * 211 : Le personnage 0 est devenu un légume.
         * 212 : Le personnage 0 ne consomme plus rien.
         * 213 : Le personnage 0 est accro à la nourriture.
         * 214 : Le personnage 0 est d'une intelligence hors norme.
         * 215 : Le personnage 0 est tombé malade.
         * 220 : Le personnage 1 est devenu moins fort.
         * 221 : Le personnage 1 est devenu plus fort.
         * 222 : Le personnage 1 consomme plus de nourriture.
         * 223 : Le personnage 1 consomme moins de nourriture.
         * 224 : Le personnage 1 est devenu un intellectuel.
         * 225 : Le personnage 1 a perdu de l'intelligence.
         * 226 : Le personnage 1 a gagné en agilité.
         * 227 : Le personnage 1 a perdu de l'agilité.
         * 228 : Le personnage 1 a gagné en résistance.
         * 229 : Le personnage 1 a perdu de la résistance.
         * 230 : Le personnage 1 est devenu plus fort partout.
         * 231 : Le personnage 1 est devenu un légume.
         * 232 : Le personnage 1 ne consomme plus rien.
         * 233 : Le personnage 1 est accro à la nourriture.
         * 234 : Le personnage 1 est d'une intelligence hors norme.
         * 235 : Le personnage 1 est tombé malade.
         * 240 : Le personnage 2 est devenu moins fort.
         * 241 : Le personnage 2 est devenu plus fort.
         * 242 : Le personnage 2 consomme plus de nourriture.
         * 243 : Le personnage 2 consomme moins de nourriture.
         * 244 : Le personnage 2 est devenu un intellectuel.
         * 245 : Le personnage 2 a perdu de l'intelligence.
         * 246 : Le personnage 2 a gagné en agilité.
         * 247 : Le personnage 2 a perdu de l'agilité.
         * 248 : Le personnage 2 a gagné en résistance.
         * 249 : Le personnage 2 a perdu de la résistance.
         * 250 : Le personnage 2 est devenu plus fort partout.
         * 251 : Le personnage 2 est devenu un légume.
         * 252 : Le personnage 2 ne consomme plus rien.
         * 253 : Le personnage 2 est accro à la nourriture.
         * 254 : Le personnage 2 est d'une intelligence hors norme.
         * 255 : Le personnage 2 est tombé malade.
         * 260 : Le personnage 3 est devenu moins fort.
         * 261 : Le personnage 3 est devenu plus fort.
         * 262 : Le personnage 3 consomme plus de nourriture.
         * 263 : Le personnage 3 consomme moins de nourriture.
         * 264 : Le personnage 3 est devenu un intellectuel.
         * 265 : Le personnage 3 a perdu de l'intelligence.
         * 266 : Le personnage 3 a gagné en agilité.
         * 267 : Le personnage 3 a perdu de l'agilité.
         * 268 : Le personnage 3 a gagné en résistance.
         * 269 : Le personnage 3 a perdu de la résistance.
         * 270 : Le personnage 3 est devenu plus fort partout.
         * 271 : Le personnage 3 est devenu un légume.
         * 272 : Le personnage 3 ne consomme plus rien.
         * 273 : Le personnage 3 est accro à la nourriture.
         * 274 : Le personnage 3 est d'une intelligence hors norme.
         * 275 : Le personnage 3 est tombé malade.
         * 
         * 
         * 
         * 
         * 
         * 
         * 
         */
}