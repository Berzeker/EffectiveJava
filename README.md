#L'Encapsulation
Un module java bien construit doit cacher ses donn&#0233;es internes ainsi que son impl&#0233;mentation des autres modules. Seule l'API du module doit &#234;tre expos&#0233;e. Les modules interagissent entre eux via leurs API sans connaitre l'impl&#0233;mentation de chacun. C'est le concept de l'encapsulation.

L'encapsulation permet d'avoir un syst&#0232;me modulaire ainsi chaque module pourra &#0234;tre &#0233;tudi&#233;, d&#0233;velopp&#0233;, test&#0233;, optimis&#0233; de mani&#232;re isol&#0233;.

* Elle acc&#233;l&#232;re le d&#233;veloppement d'un syst&#232;me car les modules peuvent &#234;tre d&#233;velopp&#233;s en parall&#232;le.
* Elle r&#233;duit le coût de maintenance car les modules peuvent &#234;tre compris plus rapidement et d&#233;bugg&#233;s sans compromettre les autres modules.
* Elle permet plus rapidement de d&#233;tecter les modules causant un probl&#232;me de performance, les isoler, les corriger sans affecter les autres modules.
* Elle permet un couplage faible et la r&#233;utilisation des modules dans un autre contexte.

Le m&#233;canisme JAVA de **contr&#244;le d'acc&#232;s** permet de d&#233;terminer l'accessibilit&#233; aux classes, interfaces et leurs membres.
L'accessibilit&#233; a une entit&#233; est determin&#233; par la localisation de sa d&#233;claration et par la pr&#233;sence d'un des modificateurs d'acc&#232;s (private, protected, public) à sa d&#233;claration.

**Il est important lors du design de son API de rendre tous les classes et membres le plus inaccessibles que possible** 

## modificateurs d'acc&#232;s pour les classes et interfaces :

Pour les classes et interfaces (non imbriqu&#233;es), il n'est possible d'utiliser que deux modificateurs d'acc&#232;s.

* **package-private** : Sans aucun modificateur d'acc&#232;s devant la d&#233;cralation de la classe ou l'interface. Ce modificateur d'acc&#232;s rend la classe ou l'interface partie int&#233;grante de l'impl&#233;mentation au lieu de l'API expos&#233;e. Les classes, interfaces peuvent &#234;tre modifi&#233;es, remplac&#233;es, supprim&#233;es dans une version ult&#233;rieure sans impact sur les clients tiers.
* **public** : en utilisant le modificateur d'acc&#232;s * public * devant la d&#233;claration de la classe ou l'interface. le modificateur d'acc&#232;s public rend la classe ou l'interface partie int&#233;grante de l'API expos&#233;e et il devient obligatoire de les supporter dans les versions ult&#0233;rieures pour maintenir une compatibilit&#233;.

## modificateurs d'acc&#232;s pour les membres :
Les membres concernent les champs, les m&#233;thodes, les classes et les interfaces imbriqu&#233;es. 4 modificateurs d'acc&#232;s peuvent &#234;tre appliqu&#233;s sur les membres :

* **private** : Le membre est accessible uniquement depuis la classe dont il est d&#233;clar&#233;.
* **package-private** : Le membre est accessible depuis toute classe du package dont il est d&#233;clar&#233;.
* **protected** : Le membre est accessible depuis les classes h&#233;ritant la classe dont il est d&#233;clar&#233; et depuis toute classe du package dont il est d&#233;clar&#233;.
* **public** : le membre est accessible depuis partout.

### Membres private et package-private
Le premier reflexe à avoir est de rendre tous les membres d'une classe private. Si une classe du m&#0234;me package à besoin d'acc&#0233;der à un membre de la classe, il est possible dans ce cas de supprimer le modificateur d'acc&#0232;s *private* pour rendre le membre *package-private*. il ne faut pas non plus que cette manipulation soit tr&#0232;s r&#0233;p&#0233;titive au quel cas il faudra revoir le design du syst&#0232;me pour une meilleur d&#0233;composition permettant un meilleur d&#0233;couplage des classes. Il est à rappeler que les deux modificateurs d'acc&#0232;s *private* et *package-private* font partie de l'impl&#0233;mentation et n'impacte l'API export&#0233;e.

### Membres protected
Une grosse mont&#0233;e d'acc&#0232;s est r&#0233;alis&#0233;e quand un membre d'une classe publique voit sont modificateur d'acc&#0232;s chang&#0233; de *package-private* à *protected*. En effet un membre *protected* fait partie de l'API export&#0233;e est doit toujours &#0234;tre maintenu dans les versions ult&#0233;rieures.

### Limite d'acc&#0232;s h&#0233;ritage
il existe une r&#0232;gle r&#0233;duisant votre abilit&#0233; à r&#0233;duire l'acc&#0232;s d'une m&#0233;thode : si la m&#0233;thode surcharge une m&#0233;thode h&#0233;rit&#0233;e d'une classe m&#0232;re alors il est non permis d'avoir un acc&#0232;s plus restreint que celle de la classe m&#0232;re. Cette r&#0232;gle est pour assurer qu'une instance d'une sous-classe est utilisable n'importe où une instance de la classe m&#0232;re est utilisable.

### Membres public
Les instances des champs d'une classe ne doivent jamais &#0234;tre publiques. Si le champ est non final ou final avec une r&#0233;f&#0233;rence vers un objet mutable alors en le rendant publique vous abandonner l'abilit&#0233; de limiter les valeurs qui peuvent &#0234;tre stock&#0233;es dans ce champ, vous abandonner aussi l'abilit&#0233; d'imposer des invariants impliquant ce champ et vous abandonner ainsi la possibilit&#0233; d'entreprendre toute action quand le champ est modifi&#0233;.
Les classes avec des champs publiques mutable sont non thread-safe. M&#0234;me si le champ est final et fait r&#0233;f&#0233;rence à un objet immutable, en le rendant publique vous abandonner la flexibilit&#0233; de switcher vers une nouvelle repr&#0233;sentation interne dans laquelle le champ n'existe pas.

### Champs public static
Le m&#0234;me conseil s'applique aux champs statiques avec une seule exception, vous pouvez exposer des constantes via un champ public static final, en consid&#0233;rant ques les constantes sont parties int&#0233;grantes de l'abstraction que fournie une classe. Il est important que ces champs contiennent soit une une valeur primitive ou une r&#0233;f&#0233;rence à objet immuable. 
A noter qu'un champ final avec une ref&#0233;rence à un objet mutable à tous les d&#0233;savantages d'un champ non final. M&#0234;me si la r&#0233;f&#0233;rence de l'objet ne peut &#0234;tre chang&#0233;e, il est tout a fait de modifier l'objet r&#0233;f&#0233;renc&#0233;e avec de d&#0233;sastreuses cons&#0233;quences.


