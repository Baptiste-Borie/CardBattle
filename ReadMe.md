# Commande ant :

- Pour (juste) compiler : `ant compile`

- Pour lancer le projet : `ant run`

- Pour générer la javadoc : `ant javadoc`

- Pour nettoyer les dossiers `build` et `doc` : `ant clean`

## Javadoc

Pour générer la javadoc, il faut utiliser la commande `ant javadoc`. Cette
commande génère la javadoc dans le dossier `doc`. Il suffit après de lancer le fichier `index.html` pour naviguer dans la documentation du projet.

# Si ant ne fonctionne pas/ n'est pas installé :

```
javac -d build src/*.java
java -cp build cardBattle.src.Bataille
```
