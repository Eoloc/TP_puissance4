package main.tp_puissance4;

public class Joueur {
    private int idTour;
    private char jeton;
    private boolean IA = false;

    public Joueur(int idT, char j, boolean ia){
        idTour = idT;
        jeton = j;
        IA = ia;
    }

    public int getIdTour() {
        return idTour;
    }

    public char getJeton() {
        return jeton;
    }

    public boolean isIA() {
        return IA;
    }
}
