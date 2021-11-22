package main.tp_puissance4;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Jeu {
    private boolean fin_jeu;
    private Grille grille;

    public Jeu(Grille g) {
        fin_jeu = false;
        grille = g;
    }

    public void demarrer() throws IOException {
        Joueur joueur1 = new Joueur(1, 'O');
        Joueur joueur2 = new Joueur(2, 'X');
        int tour = 1;
        char commande = '-';
        Reader reader = new InputStreamReader(System.in);
        boolean bonChoix = true;

        while(!fin_jeu){
            if(tour == joueur1.getIdTour()){
                System.out.println("Joueur 1 jouer");

                bonChoix = true;

                commande = (char) reader.read();
                reader.skip(1);

                if(commande == '1'){
                    insererJeton(joueur1, 0);
                }
                else if(commande == '2'){
                    insererJeton(joueur1, 1);
                }
                else if(commande == '3'){
                    insererJeton(joueur1, 2);
                }
                else if(commande == '4'){
                    insererJeton(joueur1, 3);
                }
                else if(commande == '5'){
                    insererJeton(joueur1, 4);
                }
                else if(commande == '6'){
                    insererJeton(joueur1, 5);
                }
                else if(commande == '7'){
                    insererJeton(joueur1, 6);
                }
                else if(commande == '8') {
                    insererJeton(joueur1, 7);
                }
                else {
                    bonChoix = false;
                }
            }
            if(tour == joueur2.getIdTour()){
                System.out.println("Joueur 2 jouer");

                bonChoix = true;

                commande = (char) reader.read();
                reader.skip(1);

                if(commande == '1'){
                    insererJeton(joueur2, 0);
                }
                else if(commande == '2'){
                    insererJeton(joueur2, 1);
                }
                else if(commande == '3'){
                    insererJeton(joueur2, 2);
                }
                else if(commande == '4'){
                    insererJeton(joueur2, 3);
                }
                else if(commande == '5'){
                    insererJeton(joueur2, 4);
                }
                else if(commande == '6'){
                    insererJeton(joueur2, 5);
                }
                else if(commande == '7'){
                    insererJeton(joueur2, 6);
                }
                else if(commande == '8') {
                    insererJeton(joueur2, 7);
                }
                else {
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
            commande = '-';
            System.out.println(grille);
        }
    }

    public void insererJeton(Joueur joueur, int position){
        for(int j = 0; j < grille.getTailleY(); j++){
            if(grille.getGrilleChar(position, j) != '-'){
                grille.setGrilleChar(position, j-1, joueur.getJeton());
                break;
            }
            if(j == grille.getTailleY() - 1){
                grille.setGrilleChar(position, 7, joueur.getJeton());
            }

        }
    }
}
