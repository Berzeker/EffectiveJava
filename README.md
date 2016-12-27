# Composition et h�ritage
Malgr� que l'h�ritage est un outil assez puissant pour la r�utilisation du code, il pr�sente quelques lacunes et peut engendrer des conceptions logiciels fragiles.
Il est recommand� de r�aliser l'h�ritage dans le m�me package sous la responsabilit� du m�me programmeur. Les h�ritages en dehors du m�me package que la classe m�re sont dangereux.
En effet, l'h�ritage viole le principe de l'encapsulation car la sous-classe d�pend de l'impl�mentation de la classe m�re pour ses propres fonctions. Or l'impl�mentation de la classe m�re peut changer d'une version � une autre et ainsi impacter le bon fonctionnement de la sous-classe.

Pour illustrer ce probl�me :
Imaginant une classe m�re d�finissant une pile d'objet :

