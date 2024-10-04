package cardBattle.src;

import java.util.ArrayList;

/**
 * @author Baptiste Borie
 * 
 *         La classe Joueur représente un joueur dans le jeu de cartes.
 *         Chaque joueur a un nom et une main de cartes.
 * 
 *         Je suis partie du principe que le paquet de carte était une file FIFO
 *         (First
 *         in First Out). Par conséquent les cartes ajoutés seront à la fin et
 *         on tire
 *         les cartes au début.
 */
public class Joueur {

    private ArrayList<Card> cards;
    private String nom;

    /**
     * Constructeur pour créer un joueur avec un nom spécifique.
     *
     * @param nom Le nom du joueur.
     */
    public Joueur(String nom) {
        this.nom = nom;
        this.cards = new ArrayList<>();
    }

    /**
     * Récupère la main de cartes du joueur.
     *
     * @return Une liste de cartes détenues par le joueur.
     */
    public ArrayList<Card> getCards() {
        return this.cards;
    }

    /**
     * Récupère le nom du joueur.
     *
     * @return Le nom du joueur.
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Définit la main de cartes du joueur.
     *
     * @param newDeck La nouvelle main de cartes à assigner au joueur.
     */
    public void setCards(ArrayList<Card> newDeck) {
        this.cards = newDeck;
    }

    /**
     * Définit le nom du joueur.
     *
     * @param newNom Le nouveau nom du joueur.
     */
    public void setNom(String newNom) {
        this.nom = newNom;
    }

    /**
     * Permet au joueur de choisir une carte de sa main.
     *
     * @return La carte choisie, qui est la première carte de la main du joueur.
     */
    public Card pickCard() {
        return this.cards.get(0);
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères du joueur.
     * 
     * @return Une chaîne représentant le joueur, sous la forme "nom".
     * 
     *         ex : "Joueur 1"
     */
    @Override
    public String toString() {
        return this.nom;
    }
}
