package main.tp_puissance4;

public class Joueur {
    private int idTour;
    private char jeton;

    public Joueur(int idT, char j){
        idTour = idT;
        jeton = j;
    }

    public int getIdTour() {
        return idTour;
    }

    public char getJeton() {
        return jeton;
    }
}
