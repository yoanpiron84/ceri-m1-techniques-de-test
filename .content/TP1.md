# TP 1 : Maven

L'objectif de ce premier TP est de configurer votre projet, à travers la plateforme [GitHub](https://github.com),
et de définir un fichier ``pom.xml`` afin de rendre votre projet exploitable par l'outil [Maven](https://maven.apache.org).


## Spécification du fichier pom.xml

Le fichier ``pom.xml`` devra décrire un projet répondant aux exigences suivantes :

- Une definition du projet comprenant:
  - Un identifiant de groupe ``fr.univavignon``.
  - Un identifiant d'**artifact** ``pokedex``.
  - Un numéro de version respectant les règles du [Sementic Versioning](http://semver.org/lang/fr/).
- Une meta description complète du projet (auteur, description, licence, et url du projet).
- Configuration du plugin de compilation pour utiliser le JDK 1.8.
- Un dossier contenant les sources ``src/main/java``.
- Un dossier contenant les fichiers de tests ``src/test/java``.
- Une dépendence [JUnit](junit.org).
