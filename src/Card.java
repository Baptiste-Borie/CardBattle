package cardBattle.src;

import java.util.Arrays;

/**
 * @author Baptiste Borie
 * 
 *         La classe Card représente une carte dans le jeu de cartes.
 *         Chaque carte a une couleur et une valeur.
 */
public class Card {

    protected static String[] COULEURS = { "coeur", "carreau", "pique", "trefle"
    };
    protected static String[] VALEURS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "valet", "dame", "roi",
            "as" };

    private String couleur;
    private String valeur;

    /**
     * Constructeur pour créer une carte avec une couleur et une valeur spécifiées.
     *
     * @param couleur La couleur de la carte. Les couleurs valides sont : "coeur",
     *                "carreau", "pique", "trefle".
     * @param valeur  La valeur de la carte. Les valeurs valides sont comprises
     *                entre 1 et 10.
     * @throws IllegalArgumentException Si la couleur ou la valeur spécifiée est
     *                                  invalide.
     */
    public Card(String couleur, String valeur) {

        if (!Arrays.asList(COULEURS).contains(couleur)) {
            throw new IllegalArgumentException(
                    "Couleur invalide : " + couleur + ". Les couleurs valides sont : " +
                            Arrays.toString(COULEURS));
        }
        boolean found = false;
        for (String value : VALEURS) {
            if (value == valeur) {
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IllegalArgumentException(
                    "Valeur invalide : " + valeur + ". Les valeurs valides sont : " +
                            Arrays.toString(VALEURS));
        }

        this.couleur = couleur;
        this.valeur = valeur;
    }

    /**
     * Récupère la couleur de la carte.
     *
     * @return La couleur de la carte.
     */
    public String getCouleur() {
        return this.couleur;
    }

    /**
     * Récupère la valeur de la carte.
     *
     * @return La valeur de la carte.
     */
    public String getValeur() {
        return this.valeur;
    }

    /**
     * Définit la couleur de la carte.
     *
     * @param couleur La nouvelle couleur de la carte.
     * @throws IllegalArgumentException Si la couleur spécifiée est invalide.
     */
    public void setCouleur(String couleur) {
        if (!Arrays.asList(COULEURS).contains(couleur)) {
            throw new IllegalArgumentException(
                    "Couleur invalide : " + couleur + ". Les couleurs valides sont : " + Arrays.toString(COULEURS));
        }
        this.couleur = couleur;
    }

    /**
     * Définit la valeur de la carte.
     *
     * @param valeur La nouvelle valeur de la carte.
     * @throws IllegalArgumentException Si la valeur spécifiée est invalide.
     */
    public void setValeur(String valeur) {
        boolean found = false;
        for (String value : VALEURS) {
            if (value == valeur) {
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IllegalArgumentException(
                    "Valeur invalide : " + valeur + ". Les valeurs valides sont : " +
                            Arrays.toString(VALEURS));
        }

        this.valeur = valeur;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de la carte.
     *
     * @return Une chaîne représentant la carte, sous la forme "valeur de couleur".
     * 
     *         ex : "1 de coeur"
     */
    @Override
    public String toString() {
        return valeur + " de " + couleur;
    }

    /**
     * Compare la valeur de cette carte avec une autre carte.
     *
     * @param c La carte avec laquelle comparer cette carte.
     * @return 0 si les valeurs des deux cartes sont égales. 1 si la valeur de cette
     *         carte est supérieure à la valeur de la carte spécifiée. -1 si la
     *         valeur de cette carte est inférieure à la valeur de la carte en
     *         paramètres.
     */
    public int Compare(Card c) {
        int thisIndex = Arrays.asList(VALEURS).indexOf(this.getValeur());
        int otherIndex = Arrays.asList(VALEURS).indexOf(c.getValeur());
        if (thisIndex == otherIndex) {
            return 0; // equal
        } else if (thisIndex > otherIndex) {
            return 1; // win
        }
        return -1; // loss
    }
}
