# Immuabilit&#0233;
A l'inverse d'une classe mutable dont l'&#0233;tat peut changer au cours de son cycle de vie, l'&#0233;tat des instances d'une classe immuable ne change jamais. Les informations contenues dans les instances sont fournies lors la cr&#0233;ation de ces derniers et sont fix&#0233;es pour toute la dur&#0233;e de vie des objets.
Les classes immuables sont reconnues pour &#0234;tre plus s&#0233;curis&#0233;es et moins sujet aux erreurs. Elles offrent aussi l'avantage d'&#0234;tre plus faciles Ã  concevoir, Ã  implementer et Ã  utiliser que les classes mutables.

## Conception classe immuable
Pour concevoir une classe immuable, certaines r&#0232;gles doivent &#0234;tre appliqu&#0233;es :

1. Ne jamais exposer de m&#0233;thode permettant de modifier l'&#0233;tat de l'objet Ã  l'exemple des setteurs.
2. Intedire l'h&#0233;ritage de la classe, en rendant la classe *final* : Pour &#0233;viter qu'une sous classe ne simule un changement d'&#0233;tat et ainsi compromettre l'immuabilit&#0233;. 
3. Tous les champs de la classe doivent &#0234;tre *private* et *final* : *private* pour interdire l'acc&#0232;s direct aux champs ayant des objets mutables et *final* pour garantir la non modification des r&#0233;f&#0233;rences.
4. Assurer un acc&#0232;s exclusif Ã  tous les champs mutables : Assurer que le client de la classe ne peut jamais avoir la r&#0233;f&#0233;rence des objets mutables, au niveau de l'initialisation du constructeur et au niveau des m&#0233;thodes retournant les champs en question. Toujours r&#0233;aliser des copies d&#0233;fensifs sur le objets mutables pour garantir leur status.

### Exemple avec la classe Microbe :

#### classe microbe ne respectant pas les r&#0232;gles d'immuabilit&#0233; 
| commit |
|  --------------------------------------------------------- |
|  git reset --hard 2ac5602360382fdad1631cc9f7cc309b3c0028aa |

La classe Microbe est non immuable, elle contient plusieur d&#0233;fauts :

1. Elle permet l'h&#0233;ritage, il est ainssi possible qu'une sous-classe simule un changement d'&#0233;tat et compremettre l'immmabilit&#0233;. 
Dans l'exemple, c'est le cas de la classe VirusMicrobe qui surcharge le nom des microbes.

2. les champs mutables n'ont pas un acc&#0232;s exclusif. La classe Date est mutable et il est possible dans l'exemple pr&#0233;sent de modifier la valeur du champ *dateNaissance*
via sa r&#0233;f&#0233;rence. Sans l'absence d'une copie d&#0233;fensive du champ mutable, le status de chaque instance Microbe peut &#0234;tre modifi&#0233; Ã  tout moment..

#### classe microbe immuable
| commit |
| --------------------------------------------------------- |
|  git reset --hard 6f6b99ef2d79dd6654ab0318bbb446a18eec46a7  |

La classe Microbe est d&#0233;somais immuable et respecte les 4 r&#0232;gles mentionn&#0233;es plus haut.


## Inconv&#0233;nients classe immuable
Le seul inconv&#0233;nient des classes immuables c'est qu'elles ont besoin d'une instance pour chaque valeur. Ce qui cause des probl&#0232;mes de performance et une augmentation significative du nombre d'instances dans le garbage collector et ainsi une empreinte m&#0233;moire cons&#0233;quente.

Une solution facile et d'encourager à r&#0233;-utiliser les instances fr&#0233;quemment utilis&#0233;es, en les mettant à disposition via des constantes **public static final**

###Exemple constantes :###

|  |
| ------------------------------------------------------------ |
|  public static final Microbe GRIPPE = new Microbe("GRIPPE");  |
|  public static final Microbe RHUME = new Microbe("RHUME");  |
|  public static final Microbe GASTRO = new Microbe("GASTRO");  |

Il est possible aussi de cacher les instances lors de leur cr&#0233;ation. Pour cela il est possible d'utiliser des m&#0233;thodes fabriques au lieu des constructeurs.

Vous vous rappelez que parmi les 4 r&#0232;gles pour rendre une classe immuable, il fallait lui interdire l'h&#0233;ritage via le mot cl&#0233; **final**.
Une autre alternative mieux recommand&#0233;e et de rendre les constructreurs priv&#0233;s et de permettre la cr&#0233;ation des instances via des m&#0233;thodes fabriques.
Cette alternative en plus de permettre de tuner les performances en proposant des solutions de cache, rend possible la cr&#0233;ation de plusieurs impl&#0233;mentations **private-package** pouvant am&#0233;liorer les perfomances selon le contexte.

Un autre avantage des m&#0233;thodes de fabrique et de pouvoir nommer la m&#0233;thode et de proposer les arguments de n'importe quels types et dans l'ordre souhait&#0233; à l'inverse des constructeurs qui gardent le m&#0234;me nom et qui ne permettent pas d'avoir deux constructeurs avec le m&#0234;me nombre d'arguments avec des types dans le m&#0234;me ordre.


## Avantages classe immuable
Les objets immuables sont faciles à utiliser et sont par d&#0233;fault *thread-safe*. Ils gardent toujours leur &#0233;tat, ne changent jamais et ne peuvent pas &#0234;tre alt&#0233;r&#0233;s par plusieurs threads.

