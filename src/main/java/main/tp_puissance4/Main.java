package main.tp_puissance4;

public class Main {
    public static void main(String[] args) {
        Grille map = new Grille(5, 5);
        System.out.println(map);
        Jeu puissance4 = new Jeu(map);

    }
}
