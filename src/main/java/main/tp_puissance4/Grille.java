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
    
    public Grille(Grille grilles) {
        tailleX = grilles.getTailleX();
        tailleY = grilles.getTailleY();
        grille = new char[tailleX][tailleY];
        for(int j = 0; j < tailleY; j++){
            for(int i = 0; i < tailleX; i++){
                this.grille[i][j] = grilles.getGrilleChar(i, j);
            }
        }
    }

    @Override
    public String toString() {
        String res = "";
        for(int j = 0; j < tailleY; j++){
            for(int i = 0; i < tailleX; i++){
                res += grille[i][j] + "  ";
            }
            res += '\n';
        }
        return res;
    }

    public int getTailleX() {
        return tailleX;
    }

    public int getTailleY() {
        return tailleY;
    }

    public void setGrilleChar(int x, int y, char c) {
        this.grille[x][y] = c;
    }

    public char getGrilleChar(int x, int y) {
        return this.grille[x][y];
    }
    
    public char[][] getGrille() {
    	return grille;
    }
}
