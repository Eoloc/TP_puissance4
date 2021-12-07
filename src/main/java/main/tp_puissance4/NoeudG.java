package main.tp_puissance4;

import java.util.ArrayList;
import java.util.HashMap;

public class NoeudG {
	private Grille grille;
	private NoeudG previous;
	private ArrayList<NoeudG> nexts = new ArrayList<NoeudG>();
	private HashMap<Integer, int[]> valeurs;

	public NoeudG(NoeudG previous, Grille grille) {
		this.grille = grille;
		this.previous = previous;
		this.valeurs = new HashMap<>();
		for(int i = 1; i < 8;i++){
			this.valeurs.put(i, null);
		}


	}

	public NoeudG(Grille grille) {
		this.grille = grille;
		this.previous = null;
	}

	public Grille getGrille() {
		return this.grille;
	}

	public ArrayList<NoeudG> getNexts() {
		return this.nexts;
	}

	public HashMap<Integer, int[]> getValeurs() {
		return valeurs;
	}

	public void genererNext(char symbole) {
		// on trouve les places libres
		ArrayList<int[]> placeLibre = new ArrayList<int[]>();
		int[] place = new int[2];
		for(int i = 0; i < 7 ;i++) {
			for(int j =0; j<6;j++) {
				if(j > 0 && (grille.getGrilleChar(i, j)=='O' || grille.getGrilleChar(i, j)=='X')) {
					if (grille.getGrilleChar(i, j-1)=='-') {
						place[0] = i;
						place[1] = j-1;
						placeLibre.add(new int[]{i,(j-1)});
					}
				} else if(j == 5) {
					place[0] = i;
					place[1] = j;
					placeLibre.add(new int[]{i,(j)});
				}
			}
		}
		//

		//pour chaque place libre on génère une grille suivant le symbole
		for (int i = 0; i < placeLibre.size(); i++) {

			nexts.add(new NoeudG(this,new Grille(this.grille)));
			nexts.get(nexts.size()-1).getGrille().setGrilleChar(placeLibre.get(i)[0], placeLibre.get(i)[1], symbole);

		}
	}


	public void afficherNexts() {
		for (int i = 0; i < nexts.size();i++) {
			System.out.println("montre grille : " + i);
			System.out.println(nexts.get(i).getGrille());

			// on remplit le Hashmap des valeurs heuristiques
			nexts.get(i).genererValeur(grille);
		}
	}

	public void genererValeur(Grille grille){
		for(int i = 0; i < grille.getTailleX(); i++) {
			for(int j = 0; j < grille.getTailleY(); j++){
				if(grille.getGrilleChar(i, j) != '-'){
					// Au moment ou on arrive au premier jeton de la pile
					if(j==0){ break; } // plus de place dans la pile
					int x = i;
					int y = j-1;
					char jetonActuel = 'X';
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
					valeurs.replace((i+1), value);
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
					valeurs.replace((i+1), value);
				}
			}
		}
	}

	public void genererProfondeur(int n, char symbole) {
		if (n > 0) {
			char sy = 'O';
			char nxt = 'X';
			if (symbole=='X') {
				sy = 'X';
				nxt = 'O';
			}
			this.genererNext(sy);
			this.afficherNexts();
			for(int i = 0; i < this.getNexts().size();i++) {
				this.getNexts().get(i).genererProfondeur(n-1, nxt);
			}
		}
	}
}
