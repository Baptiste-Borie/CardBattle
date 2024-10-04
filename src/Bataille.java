package cardBattle.src;

import java.util.*;

/**
 * @author Baptiste Borie
 *         La classe Bataille représente une partie de jeu de cartes entre deux
 *         joueurs.
 *         Elle permet de distribuer des cartes, de jouer des tours, et de gérer
 *         les
 *         situations de "bataille".
 */
public class Bataille {

    private Joueur j1;
    private Joueur j2;
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Constructeur pour initialiser une partie de Bataille avec deux joueurs.
     *
     * @param j1Name Le nom du premier joueur.
     * @param j2Name Le nom du second joueur.
     */
    public Bataille(String j1Name, String j2Name) {
        this.j1 = new Joueur(j1Name);
        this.j2 = new Joueur(j2Name);
    }

    /**
     * Distribue un jeu de cartes mélangé entre les deux joueurs.
     */
    public void distribuer() {
        ArrayList<Card> cartes = new ArrayList<>();
        for (String couleur : Card.COULEURS) {
            for (String valeur : Card.VALEURS) {
                cartes.add(new Card(couleur, valeur));
            }
        }

        Collections.shuffle(cartes);
        int midIndex = cartes.size() / 2;
        ArrayList<Card> firstHalf = new ArrayList<>(cartes.subList(0, midIndex));
        ArrayList<Card> secondHalf = new ArrayList<>(cartes.subList(midIndex, cartes.size()));
        this.j1.setCards(firstHalf);
        this.j2.setCards(secondHalf);
    }

    /**
     * Joue un tour de la partie. Chaque joueur tire une carte et le gagnant de la
     * manche est déterminé.
     * En cas d'égalité, une bataille est déclenchée.
     */
    public void jouerTour() {
        getStatusGame();
        Card c1 = j1.pickCard();
        Card c2 = j2.pickCard();
        System.out.println(j1.getNom() + " a tiré la carte " + c1);
        System.out.println(j2.getNom() + " a tiré la carte " + c2);
        attendreEntree();

        int res = c1.Compare(c2);
        if (res == 1) {
            System.out.println(j1.getNom() + " remporte la manche !");
            j1.getCards().add(c1);
            j1.getCards().add(c2);
            removePickedCard();
            getStatusGame();
            attendreEntree();
        } else if (res == -1) {
            System.out.println(j2.getNom() + " remporte la manche !");
            j2.getCards().add(c1);
            j2.getCards().add(c2);
            removePickedCard();
            getStatusGame();
            attendreEntree();
        } else {
            System.out.println("Egalité ! Bataille !");
            removePickedCard();
            jouerBataille(c1, c2);
            attendreEntree();
        }
    }

    /**
     * Gère une situation de bataille lorsque deux cartes ont la même valeur.
     * Les joueurs tirent chacun une nouvelle carte pour déterminer le gagnant.
     *
     * @param c1 La première carte impliquée dans la bataille.
     * @param c2 La deuxième carte impliquée dans la bataille.
     */
    public void jouerBataille(Card c1, Card c2) {
        Card c3 = j1.pickCard();
        Card c4 = j2.pickCard();

        System.out.println(j1.getNom() + " a tiré la carte " + c3);
        System.out.println(j2.getNom() + " a tiré la carte " + c4);
        attendreEntree();

        int resBataille = c3.Compare(c4);
        if (resBataille == 1) {
            System.out.println(j1.getNom() + " remporte la manche !");
            j1.getCards().add(c1);
            j1.getCards().add(c2);
            j1.getCards().add(c3);
            j1.getCards().add(c4);
            removePickedCard();
            getStatusGame();
            attendreEntree();
        } else if (resBataille == -1) {
            System.out.println(j2.getNom() + " remporte la manche !");
            j2.getCards().add(c1);
            j2.getCards().add(c2);
            j2.getCards().add(c3);
            j2.getCards().add(c4);
            removePickedCard();
            getStatusGame();
            attendreEntree();
        } else {
            System.out.println("\nEgalité ! Bataille !");
            removePickedCard();
            jouerBataille(c3, c4);
            attendreEntree();
        }

    }

    /**
     * Attend que le joueur appuie sur la touche Entrée pour continuer.
     */
    private void attendreEntree() {
        scanner.nextLine();
    }

    /**
     * Affiche l'état actuel du jeu, y compris les scores (nombre de cartes
     * restantes) des deux joueurs.
     */
    private void getStatusGame() {
        System.out.println("\n");
        System.out.println("----------------------------------------------------------");
        System.out.println("|                         SCORE                          |");
        System.out.println("----------------------------------------------------------");
        System.out.println("|      " + j1.getNom() + "                 " + j2.getNom() + "      |");
        System.out.println("|                                                        |");
        System.out.println("|            " + j1.getCards().size() + "                             "
                + j2.getCards().size() + "           |");
        System.out.println("----------------------------------------------------------");
        System.out.println("\n");
    }

    /**
     * Retire la première carte du jeu de chaque joueur après qu'elles ont été
     * jouées.
     */
    private void removePickedCard() {
        j1.getCards().remove(0);
        j2.getCards().remove(0);
    }

    /**
     * Le point d'entrée principal du programme.
     * Lance une partie de Bataille entre deux joueurs.
     *
     * @param args Les arguments de la ligne de commande.
     */
    public static void main(String[] args) {
        Bataille Game = new Bataille("John Carmack", "Tim Berners-Lee");
        Game.distribuer();
        while (Game.j1.getCards().size() > 0 && Game.j2.getCards().size() > 0) {
            Game.jouerTour();
        }
        if (Game.j1.getCards().size() == 0) {
            System.out.println(Game.j2.getNom() + " remporte la partie !");
        } else {
            System.out.println(Game.j1.getNom() + " remporte la partie !");
        }
    }
}
