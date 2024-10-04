# Fonctionnement du jeu

Après le lancement du programme, la partie débute entre nos deux joueurs (John Carmack et Tim Berners-Lee).

Le score après chaque tour est affiché est correspond au nombre de carte restantes pour chaques joueurs.

En dessous la partie débute, il est indiqué quel joueur à pris quelle carte. Après avoir appuyé sur entrée la partie continue.

Le joueur gagnat est affiché. Il faut de nouveau appuyer sur entrée afin de continuer. Le joueur ayant remporter la manche reprend les deux cartes en jeu dans son paquet. Ainsi le tour recommence et ainsi de suite.

En cas d'égalité une bataille est ouverte. Dans ce cas les deux cartes initiales sont mis de cotés et les joueurs reprennent une carte afin de se départager.

Le joueur qui emporte une bataille empoche les 4 cartes !

Si lors d'une bataille les nouvelles cartes reprovoquent une égalité. Dans ce scénario peu probable, les premières cartes qui ont provoqués la premières batailles sont perdus. Les joueurs mettent de cotés Les cartes ayant provoquer la seconde bataille et reprennent une carte. Ainsi au maximum 4 cartes peuvent être "en jeu" à chaque tour.

## Fin de jeu

Une partie se termine quand un joueur n'as plus de cartes.

Il est vivement conseillé si vous voulez voir la fin de reduire le nombre de cartes disponible dans les constantes `COULEURS` & `VALEURS` dans `Card.java`. En effet avec 52 cartes une partie peut s'avérer très longue ...

# Commande ant :

- Pour (juste) compiler : `ant compile`

- Pour lancer le projet : `ant run`

- Pour générer la javadoc : `ant javadoc`

- Pour nettoyer les dossiers `build` et `doc` : `ant clean`

## Javadoc

Pour générer la javadoc, il faut utiliser la commande `ant javadoc`. Cette
commande génère la javadoc dans le dossier `doc`. Il suffit après de lancer le fichier `index.html` pour naviguer dans la documentation du projet.

## Lancement

Sur le dépot github il n'y a qu'un dossier `src`. La commande `ant run` permet de générer les dossier `build`&`doc` qui contiennet respectivement les classes et la javadoc. Elle permet également de compiler et de lancer le projet. La commande `ant compile` permet seulement de compiler sans lancer le projet.

# Si ant ne fonctionne pas/ n'est pas installé :

```
javac -d build src/*.java
java -cp build cardBattle.src.Bataille
```
