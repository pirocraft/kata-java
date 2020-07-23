# Katas en Java
La master est un projet vide pour lancer des TU avec Junit 5 + assert J  
Des tags contiennent des exemples de réalisation de Kata

### Gilded Rose Kata
#### Niveau 1
Bonjour ! Nous sommes une petite auberge pour les voyageurs de passage.  
Notre métier est de loger nos hôtes mais nous en profitons pour acheter et vendre les meilleurs produits du quartier.  
Malheureusement, la qualité de nos produits se dégradent constamment à mesure qu'ils approchent de leur date de vente.  

Nous avons déléguer le travail à deux équipes, une équipe s'occupait du coeur du système tandis qu'une autre
 se charge de l'intégrer dans un environnement qu'elle maitrise sur le bout des doigts.  
Le covid a ruiné la première équipe et m'a conseillé de vous confier le coeur de notre système pour le faire évoluer, 
 voici son fonctionnement actuel :  

- Tous les produits ont une valeur VenduDans qui indique le nombre de jours dont nous disposons pour le vendre
- Tous les produits ont une Qualité qui nous permet d'estimer sa valeur
- À la fin de chaque journée, notre système réduit les deux valeurs de chaque produit

La première équipe n'a pas eu le temps d'aller plus loin, pouvez-vous gérer ces cas que nous rencontrons actuellement ?  

- Une fois la date limite de vente passée, la qualité se dégrade deux fois plus vite
- La qualité d'un produit n'est jamais négative
- La qualité du "Vieux Gruyère" augmente en fait avec l'âge
- La qualité d'un produit n'est jamais supérieure à 50
- "Sulfuras", étant un objet légendaire, ne doit jamais être vendu ou la qualité diminue
- "Pass concert", comme le "Vieux Gruyère", augmente en qualité à mesure que sa valeur VenduDans approche;

Vous pouvez faire toutes les modifications que vous souhaitez, la précédente équipe nous a donné une seule contrainte, 
 ne pas modifier l'objet Produit sous peine de transmission immédiate et définitive du covid à votre équipe !

#### Niveau 2

Ca y est ? Le moteur fonctionne ? On va pouvoir commencer à échanger nos produits alors !
Nous avons maintenant besoin de :
- Fournir la liste de nos produits à nos visiteurs
- Leur vendre nos produits
- Acheter des produits chez le petit fabricant d'en face
  - Il a eu la bonne idée d'avoir un système similaire au nôtre, prévoyez de communiquer les achats avec son système
  - Par contre c'est du local ... Ce fabricant est connu pour avoir des produits fébriles qui se dégradent 
  deux fois plus vite
- Échanger un de nos produits avec un de ceux de notre partenaire
  - Nous n'accepterons l'échange qu'avec un produit de même qualité qui doit être vendu à 1 jour près du nôtre
