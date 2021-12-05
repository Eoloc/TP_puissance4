package main.tp_puissance4;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graphe {
    private NoeudG n;

    public Graphe(){

    }

    public void genererGraphe(Grille grille){
        n = new NoeudG(grille);
        System.out.println(grille);

        //fin
    }

    public NoeudG getNoeudG() {
        return n;
    }
}
