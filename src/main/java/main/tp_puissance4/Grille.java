package main.tp_puissance4;

import java.util.Arrays;

public class Grille {
    private char[][] grille;
    private int tailleX;
    private int tailleY;

    public Grille(int tX, int tY) {
        tailleX = tX;
        tailleY = tY;
        grille = new char[tailleX][tailleY];
        for(int j = 0; j < tailleY; j++){
            for(int i = 0; i < tailleX; i++){
                this.grille[i][j] = '-';
            }
        }
    }

    @Override
    public String toString() {
        String res = "";
        for(int j = 0; j < tailleY; j++){
            for(int i = 0; i < tailleX; i++){
                res += '-';
            }
            res += '\n';
        }
        return res;
    }
}
