# jeeProject

[![forthebadge](http://forthebadge.com/images/badges/built-with-love.svg)](http://forthebadge.com)  [![forthebadge](http://forthebadge.com/images/badges/powered-by-electricity.svg)](http://forthebadge.com)

L’objectif de ce projet est de mettre en œuvre les compétences acquises dans le cours Programmation en Java EE.

## Pour commencer
##Lien du tutoriel Youtube

https://youtu.be/-BYpdMQ6o40


### Contenu du projet
On désire concevoir une application Web qui gère des albums photos d’utilisateurs. Un visiteur du site pourra, sans être authentifié, voir les photos qui sont en accès libre. Les photos sont placées dans des albums permettant de grouper les photos d’un même thème (vacance, sport, etc.).
Un album peut être déclaré public ou privé. Si l’album est privé, seuls les utilisateurs enregistrés et autorisés par le propriétaire de l’album peuvent le consulter. S’il est public, il est accessible à tous les utilisateurs et à tous les visiteurs, même ceux qui ne sont pas identifiés. Seul le propriétaire de l’album peut faire des modifications (insertion d’images, suppression d’images, modification d’images). Enfin, un utilisateur peut créer autant d’albums qu’il souhaite.
Une image appartient nécessairement à un album. De ce fait, elle appartient également à un utilisateur (le propriétaire de l’album). Elle possède un titre, une description, une hauteur et une largeur, des mots- clés, une date de création et une date de mise à jour, et bien sûr, un fichier image. Lors de la présentation de la liste des images, si on clique sur l’image, elle s’affiche sous forme de popup. Si on clique sur le nom de l’album à laquelle elle appartient, le détail de l’album s’affiche, et si on clique sur le nom de l’image, les informations concernant l’image s’affichent.
Les utilisateurs de l’application sont de deux types : les administrateurs et les utilisateurs simples. En effet, les visiteurs qui s’inscrivent deviennent des utilisateurs simples et peuvent ainsi publier des albums et des photos. Quant aux administrateurs, en plus de partager des albums, ils ont la possibilité de gérer les utilisateurs. Ainsi, ils peuvent ajouter, modifier ou supprimer des utilisateurs ainsi que tous les albums et photos qui leur sont associés. Toutefois, un compte administrateur ne peut être créé que par un administrateur. Ce qui veut dire qu’au moins un administrateur devra préalablement être inscrit dans l’application.
### Installation

Vous devez installer TomCat version 9 ou plus pour pouvoir démarrer le projet.

## Démarrage

- Lancer le projet dans Eclipse avec le seveur Tomcat préalablement configuré.

## Fabriqué avec

* [Java EE](https://www.oracle.com/java/technologies/java-ee-glance.html) - Java SE Jakarta EE Java ME JavaFX Java Card Jakarta EE, est une spécification pour la plate-forme Java d'Oracle, destinée aux applications d'entreprise.
* [Tomcat](https://tomcat.apache.org/) - Apache Tomcat ou simplement Tomcat est un serveur d'applications, plus précisément un conteneur web libre de servlets et JSP
* [MySql](https://www.mysql.com/fr/) - pour la base de données
* [Eclipse](https://www.eclipse.org/) - Éditeur de code


## Auteurs

* **Mohamed Amidou Seck** _alias_ [@AmidouSeck](https://github.com/AmidouSeck)
* **Pape Assane Thiobane** _alias_ [@papaassane](https://github.com/papaassane)
* **Elhadji Mamadou Doudou Coulibaly** _alias_ [@ElhadjiMamadouCoulibaly](https://github.com/ElhadjiMamadouCoulibaly)

## License

Ce projet est sous licence ``ESP`` - voir le fichier [LICENSE.md](LICENSE.md) pour plus d'informations

