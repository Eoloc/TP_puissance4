package main.tp_puissance4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graphe {
    private ArrayList<Noeud> graphe;

    public Graphe(){
        graphe = new ArrayList<>();

    }

    public void genererGraphe(Grille grille){
        Noeud n1 = new Noeud();
        n1.genererValeur(grille);
        System.out.println(n1);

        //fin
    }
}
