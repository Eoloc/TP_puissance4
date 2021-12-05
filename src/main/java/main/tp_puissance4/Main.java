package main.tp_puissance4;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //launch();
        /* Grille grille = new Grille(7, 6);
        System.out.println(grille);
        Jeu puissance4 = new Jeu(grille);
        puissance4.demarrer();*/
    	
    	Grille grille = new Grille(7, 6);
    	grille.setGrilleChar(5, 5, 'X');
        grille.setGrilleChar(4, 5, 'X');
        System.out.println(grille);
        Jeu puissance4 = new Jeu(grille);
        puissance4.demarrer();
    	
    }
}
