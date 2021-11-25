package main.tp_puissance4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graphe {
    private HashMap<Integer, int[]> graphe;

    public Graphe(){
        graphe = new HashMap<>();
        for(int i = 1; i < 8;i++){
            graphe.put(i, null);
        }
    }

    public void genererGraphe(Grille grille){
        for(int i = 0; i < grille.getTailleX(); i++) {
            for(int j = 0; j < grille.getTailleY(); j++){
                if(grille.getGrilleChar(i, j) != '-'){
                    // Au moment ou on arrive au premier jeton de la pile
                    if(j==0){ break; } // plus de place dans la pile
                    int x = i;
                    int y = j-1;
                    char jetonActuel = 'X';
                    boolean win = false;
                    int gauche = 0;
                    int droite = 0;
                    int haut = 0;
                    int bas = 0;
                    int gauchehaut = 0;
                    int droitehaut = 0;
                    int gauchebas = 0;
                    int droitebas = 0;
                    for(int k = 1; k < 4; k++) {
                        try {
                            if(grille.getGrilleChar(x-k, y) == jetonActuel){
                                gauche++;
                            }
                        } catch (Exception e){

                        }
                        try {
                            if(grille.getGrilleChar(x+k, y) == jetonActuel){
                                droite++;
                            }
                        } catch (Exception e){

                        }
                        try {
                            if(grille.getGrilleChar(x, y-k) == jetonActuel){
                                haut++;
                            }
                        } catch(Exception e) {

                        }
                        try {
                            if(grille.getGrilleChar(x, y+k) == jetonActuel){
                                bas++;
                            }
                        } catch(Exception e) {

                        }
                        try {
                            if(grille.getGrilleChar(x-k, y-k) == jetonActuel){
                                gauchehaut++;
                            }
                        } catch(Exception e) {

                        }
                        try {
                            if(grille.getGrilleChar(x+k, y-k) == jetonActuel){
                                droitehaut++;
                            }
                        } catch(Exception e) {

                        }
                        try {
                            if(grille.getGrilleChar(x-k, y+k) == jetonActuel){
                                gauchebas++;
                            }
                        } catch(Exception e) {

                        }
                        try {
                            if(grille.getGrilleChar(x+k, y+k) == jetonActuel){
                                droitebas++;
                            }
                        } catch(Exception e) {

                        }
                    }
                    int[] value = new int[]{gauche, droite, haut, bas, gauchehaut, droitehaut, gauchebas, droitebas};
                    graphe.replace((i+1), value);
                    break;
                }
                if(j == grille.getTailleY() - 1){
                    // Au moment ou on arrive au fond de la pile (pas de jeton mis dedans
                    int x = i;
                    int y = j;
                    char jetonActuel = 'X';
                    boolean win = false;
                    int gauche = 0;
                    int droite = 0;
                    int haut = 0;
                    int bas = 0;
                    int gauchehaut = 0;
                    int droitehaut = 0;
                    int gauchebas = 0;
                    int droitebas = 0;
                    for(int k = 1; k < 4; k++) {
                        try {
                            if(grille.getGrilleChar(x-k, y) == jetonActuel){
                                gauche++;
                            }
                        } catch (Exception e){

                        }
                        try {
                            if(grille.getGrilleChar(x+k, y) == jetonActuel){
                                droite++;
                            }
                        } catch (Exception e){

                        }
                        try {
                            if(grille.getGrilleChar(x, y-k) == jetonActuel){
                                haut++;
                            }
                        } catch(Exception e) {

                        }
                        try {
                            if(grille.getGrilleChar(x, y+k) == jetonActuel){
                                bas++;
                            }
                        } catch(Exception e) {

                        }
                        try {
                            if(grille.getGrilleChar(x-k, y-k) == jetonActuel){
                                gauchehaut++;
                            }
                        } catch(Exception e) {

                        }
                        try {
                            if(grille.getGrilleChar(x+k, y-k) == jetonActuel){
                                droitehaut++;
                            }
                        } catch(Exception e) {

                        }
                        try {
                            if(grille.getGrilleChar(x-k, y+k) == jetonActuel){
                                gauchebas++;
                            }
                        } catch(Exception e) {

                        }
                        try {
                            if(grille.getGrilleChar(x+k, y+k) == jetonActuel){
                                droitebas++;
                            }
                        } catch(Exception e) {

                        }
                    }
                    int[] value = new int[]{gauche, droite, haut, bas, gauchehaut, droitehaut, gauchebas, droitebas};
                    graphe.replace((i+1), value);
                }
            }
        }

        //fin
    }

    @Override
    public String toString() {
        String res = "Graphe : \n";
        for(int i = 1; i < 8;i++){
            res += "(" + i + ") = [";
            for (int j = 0; j < graphe.get(i).length -1; j++) {
                res += graphe.get(i)[j] + ", ";
            }

            res += graphe.get(i)[graphe.get(i).length -1] + "]\n";
        }
        res += '\n';
        return res;

    }
}
