# Composition et héritage
Malgré que l'héritage est un outil assez puissant pour la réutilisation du code, il présente quelques lacunes et peut engendrer des conceptions logiciels fragiles.
Il est recommandé de réaliser l'héritage dans le même package sous la responsabilité du même programmeur. Les héritages en dehors du même package que la classe mère sont dangereux.
En effet, l'héritage viole le principe de l'encapsulation car la sous-classe dépend de l'implémentation de la classe mère pour ses propres fonctions. Or l'implémentation de la classe mère peut changer d'une version à une autre et ainsi impacter le bon fonctionnement de la sous-classe.

Pour illustrer ce problème :
Imaginant une classe mère définissant une pile d'objet :

