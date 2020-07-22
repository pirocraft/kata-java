# Katas en Java
La master est un projet vide pour lancer des TU avec Junit 5 + assert J  
Des tags contiennent des exemples de réalisation de Kata

### GildedRose Kata
#### Context
Bonjour ! Nous sommes une petite auberge pour les voyageurs de passage    
Notre métier est de loger nos hôtes mais nous en profitons pour acheter et vendre les meilleurs produits du quartier  
Malheureusement, nos produits se dégradent constamment en qualité à mesure qu'ils approchent de leur date de vente  

Nous avons déléguer le travail à deux équipes, une équipe s'occupait du coeur du système tandis qu'une autre
 se charge de l'intégrer dans un environnement qu'elle maitrise sur le bout des doigts.  
Le covid a ruiné la première équipe et m'a incité à vous confier le coeur de notre système pour le faire évoluer, 
 voici son fonctionnement actuel :  

- Tous les articles ont une valeur VenduDans qui indique le nombre de jours dont nous disposons pour vendre l'article
- Tous les articles ont une valeur de Qualité qui indique la valeur de l'article
- À la fin de chaque journée, notre système réduit les deux valeurs pour chaque article

Plutôt simple non ? Voici quelques règles supplémentaires :  

- Une fois la date limite de vente passée, la qualité se dégrade deux fois plus vite
- La qualité d'un article n'est jamais négative
- La qualité du «Brie âgé» augmente en fait avec l'âge
- La qualité d'un article n'est jamais supérieure à 50
- "Sulfuras", étant un objet légendaire, ne doit jamais être vendu ou la qualité diminue
- «Backstage pass», comme le brie vieilli, augmente en qualité à mesure que sa valeur SellIn approche;

Voici enfin les nouvelles règles dont j'ai absolument besoin :

