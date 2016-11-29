# Immuabilit&#0233;
A l'inverse d'une classe mutable dont l'&#0233;tat peut changer au cours de son cycle de vie, l'&#0233;tat des instances d'une classe immuable ne change jamais. Les informations contenues dans les instances sont fournies lors la cr&#0233;ation de ces derniers et sont fix&#0233;es pour toute la dur&#0233;e de vie des objets.
Les classes immuables sont reconnues pour &#0234;tre plus s&#0233;curis&#0233;es et moins sujet aux erreurs. Elles offrent aussi l'avantage d'&#0234;tre plus faciles à concevoir, à implementer et à utiliser que les classes mutables.

## Conception classe immuable
Pour concevoir une classe immuable, certaines r&#0232;gles doivent &#0234;tre appliqu&#0233;es :

1. Ne jamais exposer de m&#0233;thode permettant de modifier l'&#0233;tat de l'objet à l'exemple des setteurs.
2. Intedire l'h&#0233;ritage de la classe, en rendant la classe *final* : Pour &#0233;viter qu'une sous classe ne simule un changement d'&#0233;tat et ainsi compromettre l'immuabilit&#0233;. 
3. Tous les champs de la classe doivent &#0234;tre *private* et *final* : *private* pour interdire l'acc&#0232;s direct aux champs ayant des objets mutables et *final* pour garantir la non modification des r&#0233;f&#0233;rences.
4. Assurer un acc&#0232;s exclusif à tous les champs mutables : Assurer que le client de la classe ne peut jamais avoir la r&#0233;f&#0233;rence des objets mutables, au niveau de l'initialisation du constructeur et au niveau des m&#0233;thodes retournant les champs en question. Toujours r&#0233;aliser des copies d&#0233;fensifs sur le objets mutables pour garantir leur status.

La classe Microbe est un exemple d'une classe immuable. Chaque microbe est unique et ne peut &#0234;tre modifi&#0233;.






