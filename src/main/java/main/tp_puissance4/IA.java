package main.tp_puissance4;

import java.util.Arrays;

public class IA extends Joueur{
    private Graphe graphe;
    private Grille grille;

    public IA(int idT, char j) {
        super(idT, j, true);
        graphe = new Graphe();
    }

    public int choisirCoup() {
        int choix = 1;

        graphe.genererGraphe(grille);
        graphe.getNoeudG().genererNext('X');
        int max = -1;
        int totalValeur;
        for (int i = 0; i < graphe.getNoeudG().getNexts().size();i++) {

            // Décommenter les deux lignes ci-dessous pour voir les grilles générées
            //System.out.println("montre grille : " + i);
            //System.out.println(graphe.getNoeudG().getNexts().get(i).getGrille());

            graphe.getNoeudG().getNexts().get(i).genererValeur(grille);
            // On utilise les valeurs heuristiques du Hashmap
            // Prendre la colonne qui a la meilleure heuristique
            max = -1;
            for(int k = 1; k < graphe.getNoeudG().getNexts().get(i).getGrille().getTailleX(); k++) {
                totalValeur = 0;

                for(int a = 0; a < graphe.getNoeudG().getNexts().get(i).getValeurs().get(k).length; a++){

                    totalValeur += graphe.getNoeudG().getNexts().get(i).getValeurs().get(k)[a];
                }

                if(totalValeur > max){
                    max = k;
                    choix = k;
                }
            }
        }


        return choix;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }
}
