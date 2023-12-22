package Representation;

import java.io.Serializable;
import java.util.*;
import univers.*;

public class listescenario implements Serializable {

        private ArrayList<DecisionNode> liste = new ArrayList<DecisionNode>();

        public listescenario() {
                ArrayList<DecisionNode> list = new ArrayList<DecisionNode>();
                Map<String, ArrayList<IntPair>> d1 = new HashMap<String, ArrayList<IntPair>>();
                ArrayList<IntPair> pairList = new ArrayList<IntPair>();

                ArrayList<IntPair> list1 = new ArrayList<>();
                list1.add(new IntPair(0, 0));
                list1.add(new IntPair(0, 0));
                Map<String, ArrayList<IntPair>> dico_vide = new HashMap<String, ArrayList<IntPair>>();
                dico_vide.put("null", list1);

                IntPair pair = new IntPair(1, 1);
                pairList.add(pair);
                d1.put("decision", pairList);

                int[] Arrayvide = new int[] {};

                DecisionNode D1 = new DecisionNode(0, 1, 9, 10, 0, Arrayvide,
                                "Bienvenue dans le jeux adam le chien veut venir l'accepter vous", 0, 0, 0, 0, 0, 0, 0,
                                1000, d1, d1,
                                d1, -1, 1);

                // Sniffer du champignon
                ArrayList<IntPair> listD2 = new ArrayList<>();
                listD2.add(new IntPair(1, 211));
                Map<String, ArrayList<IntPair>> dico_2 = new HashMap<String, ArrayList<IntPair>>();
                dico_2.put("chance", listD2);

                DecisionNode D2 = new DecisionNode(0, 0.3f, 0, 5, 0, Arrayvide,
                                "veut manger des champignons qui sont dans le coins de la cave voulez vous le faire manger ces champignons ?",
                                1001, dico_vide, dico_2, -1, 0);

                Map<String, ArrayList<IntPair>> dico_D3_1 = new HashMap<String, ArrayList<IntPair>>();
                ArrayList<IntPair> listD3 = new ArrayList<IntPair>();
                listD3.add(new IntPair(1, 600));
                listD3.add(new IntPair(1, 36));
                dico_D3_1.put("chance", listD3);

                DecisionNode D3 = new DecisionNode(0.8f, 1f, 3, 7, 0, Arrayvide,
                                "Une petite fille toc à la porte et vous propose de l'eau, acceptez vous ?", 1002,
                                dico_vide, dico_D3_1,
                                -1, -1);

                Map<String, ArrayList<IntPair>> dico_D4_1 = new HashMap<String, ArrayList<IntPair>>();
                ArrayList<IntPair> listD4 = new ArrayList<IntPair>();
                listD4.add(new IntPair(1, 601));
                listD4.add(new IntPair(1, 3));
                dico_D4_1.put("chance", listD4);

                DecisionNode D4 = new DecisionNode(0f, 0.15f, 4, 8, 0, Arrayvide,
                                "Un petite garçon toc à la porte et vous propose des pates, acceptez vous ?", 1003,
                                dico_vide,
                                dico_D4_1, -1, -1);

                Map<String, ArrayList<IntPair>> dico_D5_1 = new HashMap<String, ArrayList<IntPair>>();
                ArrayList<IntPair> listD5_1 = new ArrayList<IntPair>();
                listD5_1.add(new IntPair(1, 602));
                listD5_1.add(new IntPair(1, 236));
                dico_D5_1.put("chance", listD5_1);

                Map<String, ArrayList<IntPair>> dico_D5_2 = new HashMap<String, ArrayList<IntPair>>();
                ArrayList<IntPair> listD5_2 = new ArrayList<IntPair>();
                listD5_2.add(new IntPair(1, 603));
                listD5_2.add(new IntPair(1, 19));
                listD5_2.add(new IntPair(1, 29));
                listD5_2.add(new IntPair(1, 48));
                listD5_2.add(new IntPair(1, 117));
                dico_D5_1.put("chance", listD5_2);

                DecisionNode D5 = new DecisionNode(0.4f, 0.5f, 3, 20, 4, Arrayvide,
                                "Un colis est tombé juste à coté de la maison voulez vous allez le chercher ?", 20, 20,
                                20, 20, 10, 10,
                                10, 1004, dico_vide, dico_D5_1, dico_D5_2, -1, -1);

                Map<String, ArrayList<IntPair>> dico_D6_1 = new HashMap<String, ArrayList<IntPair>>();
                ArrayList<IntPair> listD6 = new ArrayList<IntPair>();
                listD6.add(new IntPair(1, 604));
                listD6.add(new IntPair(1, 216));
                listD6.add(new IntPair(1, 236));
                listD6.add(new IntPair(1, 256));
                listD6.add(new IntPair(1, 276));
                dico_D6_1.put("chance", listD6);

                DecisionNode D6 = new DecisionNode(0.7f, 0.8f, 8, 30, 2, Arrayvide,
                                "La solitude et la faim commencent à affecter la santé mentale de chacun. Une idée émerge : celle de consommer la personne la moins appréciée. Qu'en pensez-vous, seriez-vous d'accord avec cette idée ? ",
                                1006, dico_vide,
                                dico_D6_1, -1, -1);

                Map<String, ArrayList<IntPair>> dico_D7_1 = new HashMap<String, ArrayList<IntPair>>();
                ArrayList<IntPair> listD7 = new ArrayList<IntPair>();
                listD7.add(new IntPair(1, 280));
                listD7.add(new IntPair(1, 281));
                listD7.add(new IntPair(1, 282));
                listD7.add(new IntPair(1, 283));
                dico_D7_1.put("chance", listD7);
                DecisionNode D7 = new DecisionNode(0f, 1f, 10, 12, 0, Arrayvide,
                                "Guilianetta propose de préparer un plat spécial dont elle seule détient le secret. Acceptez-vous sa proposition ? ",
                                1007, dico_vide, dico_D7_1, 7, -1);

                Map<String, ArrayList<IntPair>> dico_D8_1 = new HashMap<String, ArrayList<IntPair>>();
                ArrayList<IntPair> listD8_1 = new ArrayList<IntPair>();
                listD8_1.add(new IntPair(1, 1));
                dico_D8_1.put("chance", listD8_1);

                Map<String, ArrayList<IntPair>> dico_D8_2 = new HashMap<String, ArrayList<IntPair>>();
                ArrayList<IntPair> listD8_2 = new ArrayList<IntPair>();
                listD8_2.add(new IntPair(3, 205));
                listD8_2.add(new IntPair(3, 225));
                listD8_2.add(new IntPair(3, 245));
                listD8_2.add(new IntPair(3, 255));
                dico_D8_2.put("chance", listD8_2);

                DecisionNode D8 = new DecisionNode(0.3f, 0.35f, 0, 25, 0, Arrayvide,
                                "Rachelle, la hippie, implore votre aide pour une soupe, mais elle vous met en garde en évoquant la possibilité de vous ensorceler pour vous rendre idiot dans trois jours si vous refusez de l'aider. Donnez lui vous une soupe ? ",
                                1008, dico_D8_2, dico_D8_1, -1, -1);

                Map<String, ArrayList<IntPair>> dico_D9_1 = new HashMap<String, ArrayList<IntPair>>();
                ArrayList<IntPair> listD9_1 = new ArrayList<IntPair>();
                listD9_1.add(new IntPair(1, 1));
                listD9_1.add(new IntPair(1, 31));
                listD9_1.add(new IntPair(3, 39));
                listD9_1.add(new IntPair(3, 36));
                listD9_1.add(new IntPair(3, 9));
                listD9_1.add(new IntPair(3, 605));
                dico_D9_1.put("chance", listD9_1);

                DecisionNode D9 = new DecisionNode(0.60f, 0.70f, 0, 25, 0, Arrayvide,
                                "Le banquier, frappe à votre porte et vous propose un échange : une bouteille d'eau et une portion de pâtes contre le triple de cette quantité dans trois jours. Acceptez-vous cette proposition ?",
                                1009, dico_vide, dico_D9_1, -1, -1);

                Map<String, ArrayList<IntPair>> dico_D10_1 = new HashMap<String, ArrayList<IntPair>>();
                ArrayList<IntPair> listD10_1 = new ArrayList<IntPair>();
                listD10_1.add(new IntPair(1, 606));
                listD10_1.add(new IntPair(1, 9));
                listD10_1.add(new IntPair(1, 19));
                listD10_1.add(new IntPair(1, 29));
                listD10_1.add(new IntPair(1, 39));
                listD10_1.add(new IntPair(1, 49));
                listD10_1.add(new IntPair(1, 59));

                dico_D10_1.put("chance", listD10_1);
                DecisionNode D10 = new DecisionNode(0, 100,
                                "La carte que vous possedez vous montre tous les restaurents de la ville, voulez vous y allez et tous leurs voler ?",
                                1010, dico_D10_1, "Carte de la ville");

                Map<String, ArrayList<IntPair>> dico11 = new HashMap<String, ArrayList<IntPair>>();
                ArrayList<IntPair> listD11 = new ArrayList<IntPair>();
                listD11.add(new IntPair(1, 607));
                listD11.add(new IntPair(1, 91));
                dico11.put("chance", listD11);
                DecisionNode D11 = new DecisionNode(10, 13,
                                "Voulez vous jouez au echec ? Cela peut rendre le temps plus agréable.", 1011, dico11,
                                "Echec");

                DecisionNode D12 = new DecisionNode(20, 23,
                                "Voulez vous jouez au echec ? Cela peut rendre le temps plus agréable.",
                                1012, dico11, "Echec");

                DecisionNode D13 = new DecisionNode(30, 33,
                                "Voulez vous jouez au echec ? Cela peut rendre le temps plus agréable.",
                                1013, dico11, "Echec");

                DecisionNode D14 = new DecisionNode(40, 43,
                                "Voulez vous jouez au echec ? Cela peut rendre le temps plus agréable.",
                                1014, dico11, "Echec");

                DecisionNode D15 = new DecisionNode(50, 53,
                                "Voulez vous jouez au echec ? Cela peut rendre le temps plus agréable.",
                                1015, dico11, "Echec");

                Map<String, ArrayList<IntPair>> dico16 = new HashMap<String, ArrayList<IntPair>>();
                ArrayList<IntPair> listD16 = new ArrayList<IntPair>();
                listD16.add(new IntPair(1, 607));
                listD16.add(new IntPair(1, 91));
                dico16.put("chance", listD16);

                DecisionNode D16 = new DecisionNode(6, 9,
                                "Voulez vous jouez au carte ? Cela peut être amusant.", 1016, dico16,
                                "Carte a jouer");

                DecisionNode D17 = new DecisionNode(16, 19,
                                "Voulez vous jouez au carte ? Cela peut être amusant.", 1017, dico16,
                                "Carte a jouer");

                DecisionNode D18 = new DecisionNode(26, 29,
                                "Voulez vous jouez au carte ? Cela peut être amusant.", 1018, dico16,
                                "Carte a jouer");

                DecisionNode D19 = new DecisionNode(36, 39,
                                "Voulez vous jouez au carte ? Cela peut être amusant.", 1019, dico16,
                                "Carte a jouer");

                DecisionNode D20 = new DecisionNode(46, 49,
                                "Voulez vous jouez au carte ? Cela peut être amusant.", 1020, dico16,
                                "Carte a jouer");

                DecisionNode D21 = new DecisionNode(56, 59,
                                "Voulez vous jouez au carte ? Cela peut être amusant.", 1021, dico16,
                                "Carte a jouer");

                Map<String, ArrayList<IntPair>> dico22 = new HashMap<>();
                ArrayList<IntPair> listD22 = new ArrayList<>();

                listD22.add(new IntPair(1, 608));
                listD22.add(new IntPair(1, 210));

                dico22.put("chance", listD22);

                DecisionNode D22 = new DecisionNode(0, 100,
                                "Un cafard radioactive est dans votre repère voulez vous le laissez vivre ?", 1022,
                                dico22, "Insecticide");

                Map<String, ArrayList<IntPair>> dico23 = new HashMap<>();
                ArrayList<IntPair> listD23 = new ArrayList<>();

                listD23.add(new IntPair(1, 141));
                listD23.add(new IntPair(1, 87));

                dico23.put("chance", listD23);

                DecisionNode D23 = new DecisionNode(3, 100,
                                "On vous propose d'échanger votre trousse contre une Carte de la ville, acceptez vous ?",
                                1023,
                                dico23, "Trousse");

                // Changer
                Map<String, ArrayList<IntPair>> dico24 = new HashMap<>();
                ArrayList<IntPair> listD24 = new ArrayList<>();
                listD24.add(new IntPair(1, 1025));

                dico24.put("decision", listD24);

                DecisionNode D24 = new DecisionNode(10, 100,
                                "Votre radio à l'air d'emettre un signal, voulez vous l'écouter ?",
                                1024,
                                dico24, "Radio");

                Map<String, ArrayList<IntPair>> dico25_2 = new HashMap<>();
                ArrayList<IntPair> listD25_2 = new ArrayList<>();
                listD25_2.add(new IntPair(1, 10000));

                dico25_2.put("fin", listD25_2);

                DecisionNode D25 = new DecisionNode(0.0f, 0.0f, 0, 0, 0, new int[] {},
                                "La radio signale un lieu de rapatriement où l'armée offre un refuge sécurisé. Prendriez-vous le risque de vous y rendre ?",
                                1025, dico_vide, dico25_2, -1, -1);

                Map<String, ArrayList<IntPair>> dico26_1 = new HashMap<>();
                ArrayList<IntPair> listD26_1 = new ArrayList<>();
                listD26_1.add(new IntPair(1, 610));
                dico26_1.put("chance", listD26_1);

                Map<String, ArrayList<IntPair>> dico26_2 = new HashMap<>();
                ArrayList<IntPair> listD26_2 = new ArrayList<>();
                listD26_2.add(new IntPair(1, 611));
                listD26_2.add(new IntPair(1, 167));
                dico26_2.put("chance", listD26_2);

                DecisionNode D26 = new DecisionNode(0, 1, 0, 20, 0, Arrayvide,
                                "Un petit endant toque à la porte et réclame votre hospitalité, vous n'allez quand même pas le laisser dehors, l'acceptez vous ?",
                                1026, dico26_1, dico26_2, -1, -1);

                list.add(D1);
                list.add(D2);
                list.add(D3);
                list.add(D4);
                list.add(D5);
                list.add(D6);
                list.add(D7);
                list.add(D8);
                list.add(D9);
                list.add(D10);
                list.add(D11);
                list.add(D12);
                list.add(D13);
                list.add(D14);
                list.add(D15);
                list.add(D16);
                list.add(D17);
                list.add(D18);
                list.add(D19);
                list.add(D20);
                list.add(D21);
                list.add(D22);
                list.add(D23);
                list.add(D24);
                list.add(D25);
                list.add(D26);
                this.liste = list;

        }

        public ArrayList<DecisionNode> getListe() {
                return liste;

        }
}
