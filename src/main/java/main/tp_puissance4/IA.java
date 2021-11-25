package main.tp_puissance4;

public class IA extends Joueur{
    private Graphe graphe;
    private Grille grille;

    public IA(int idT, char j) {
        super(idT, j, true);
        graphe = new Graphe();
    }

    public int choisirCoup() {
        graphe.genererGraphe(grille);
        System.out.println(graphe);
        //TODO appliquer l'algo MinMax
        return 1;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }
}
