package main.tp_puissance4;

import main.tp_puissance4.Grille;
import main.tp_puissance4.Joueur;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class Jeu {
    private boolean fin_jeu;
    private Grille grille;


    public Jeu(Grille g) {
        fin_jeu = false;
        grille = g;
    }

    public void demarrer() throws IOException {
        Joueur joueur1 = new Joueur(1, 'O', false);
        //Joueur joueur2 = new Joueur(2, 'X', false);
        IA joueur2 = new IA(2, 'X');
        int tour = 1;
        boolean bonChoix = true;
        Scanner sc = new Scanner(System.in);
        int choix;

        while(!fin_jeu){
            if(tour == joueur1.getIdTour()){
                System.out.println("Joueur 1 jouer");

                bonChoix = true;
                try {
                    choix = sc.nextInt();
                    insererJeton(joueur1, choix-1);
                } catch(Exception e) {
                    bonChoix = false;
                }
            }
            if(tour == joueur2.getIdTour()){
                System.out.println("Joueur 2 jouer");

                bonChoix = true;

                try {
                    if(joueur2.isIA()){
                        joueur2.setGrille(grille);
                        //choix = joueur2.choisirCoup();
                        joueur2.choisirCoup();
                        choix = sc.nextInt();
                    } else {
                        choix = sc.nextInt();
                    }

                    insererJeton(joueur2, choix-1);
                } catch(Exception e) {
                    bonChoix = false;
                }

            }
            if(bonChoix){
                if(tour == 1) {
                    tour = 2;
                } else {
                    tour = 1;
                }
            }
            System.out.println(grille);
        }
        System.out.println("Jeu terminé");
    }

    public void insererJeton(Joueur joueur, int position){
        for(int j = 0; j < grille.getTailleY(); j++){
            if(grille.getGrilleChar(position, j) != '-'){
                grille.setGrilleChar(position, j-1, joueur.getJeton());
                fin_jeu = verifWin(position, j-1);
                if(fin_jeu){
                    System.out.println("Bravo a joueur" + joueur.getIdTour());
                }
                break;
            }
            if(j == grille.getTailleY() - 1){
                grille.setGrilleChar(position, j, joueur.getJeton());
                fin_jeu = verifWin(position, j);
                if(fin_jeu){
                    System.out.println("Bravo a joueur" + joueur.getIdTour());
                }
            }

        }
    }

    public boolean verifWin(int x, int y) {
        char jetonActuel = grille.getGrilleChar(x, y);
        boolean win = false;
        boolean gauche = true;
        boolean droite = true;
        boolean haut = true;
        boolean bas = true;
        boolean gauchehaut = true;
        boolean droitehaut = true;
        boolean gauchebas = true;
        boolean droitebas = true;
        for(int i = 1; i < 4; i++) {
            try {
                if(grille.getGrilleChar(x-i, y) != jetonActuel){

                    gauche = false;
                }
            } catch (Exception e){
                gauche = false;
            }
            try {
                if(grille.getGrilleChar(x+i, y) != jetonActuel){
                    droite = false;
                }
            } catch (Exception e){
                droite = false;
            }
            try {
                if(grille.getGrilleChar(x, y-i) != jetonActuel){
                    haut = false;
                }
            } catch(Exception e) {
                haut = false;
            }
            try {
                if(grille.getGrilleChar(x, y+i) != jetonActuel){
                    bas = false;
                }
            } catch(Exception e) {
                bas = false;
            }
            try {
                if(grille.getGrilleChar(x-i, y-i) != jetonActuel){
                    gauchehaut = false;
                }
            } catch(Exception e) {
                gauchehaut = false;
            }
            try {
                if(grille.getGrilleChar(x+i, y-i) != jetonActuel){
                    droitehaut = false;
                }
            } catch(Exception e) {
                droitehaut = false;
            }
            try {
                if(grille.getGrilleChar(x-i, y+i) != jetonActuel){
                    gauchebas = false;
                }
            } catch(Exception e) {
                gauchebas = false;
            }
            try {
                if(grille.getGrilleChar(x+i, y+i) != jetonActuel){
                    droitebas = false;
                }
            } catch(Exception e) {
                droitebas = false;
            }
        }
        if(gauche || droite || haut || bas || gauchehaut || droitehaut || gauchebas || droitebas){
            win = true;
        }
        return win;
    }
}
