package principal;

import univers.*;

public class Principale {

    public static void lancement_du_jeu() {
        System.out.println(
                "En plein repas de famille, le monde sombra dans le chaos.\nLa 3ème guerre mondiale éclata, ne laissant qu'un refuge:\nLe bunker, avec seulement 4 places.\n\n =========Qui choisi tu ?========= \nPatrick : le père sage,\nStéphanie : la mère protectrice,\nSarah : l'esprit vif,\nMathéo : le frère courageux,\nPaul : le médecin,\nAmine : l'athlète,\nYacine : le cousin rusé,\nou Guilianetta : la cuisinière ingénieuse.\n\nQuatres personnes de ton choix vont affronter l'impensable.\nDans cette lutte pour la survie, chaque choix peseront lourd, chaque pas les rapprocheront du salut ou de la perte");
        System.out.println("==============================================\n");
        System.out.println("Choisissez votre 1 personnages :\n"
                + "1 => Patrick, le père sage,\n"
                + "2 => Stéphanie : la mère protectrice, 3:\n"
                + "3 => Sarah : l'esprit vif,\n"
                + "4:Mathéo, le frère courageux,\n"
                + "5:Paul, le médecin,\n"
                + "6:Amine, l'athlète,\n"
                + "7:Yacine, le cousin rusé,\n"
                + "8:Guilianetta, la cuisinière ingénieuse\n");
    }

    public static void main(String[] args) {
        lancement_du_jeu();
    }

}
