# Description

Les exercices sont découpés en modules :
- **Array** : manipulation de tableau à 1 ou 2 dimensions
- **Cypher** : algo de chiffrement
- **Finder** : algo de recherche
- **Maths** : problèmes de maths

Chaque module contient une ou plusieurs méthodes correspondant aux différents exercices du module.

Exemple : dans le module [`Maths`](https://github.com/JeremyBidet/Exercices/blob/develop/src/org/exercices/modules/Maths.java), pour le calcul du `PGCD` on trouve deux méthodes : [`pgcd`](https://github.com/JeremyBidet/Exercices/blob/develop/src/org/exercices/modules/Maths.java#L46) et [`r_pgcd`](https://github.com/JeremyBidet/Exercices/blob/develop/src/org/exercices/modules/Maths.java#L59), une pour la version itérative et l'autre pour la version récursive.


# Developpement
Dans tes dev, n'oublie pas de prendre en compte tous les cas de figures, car les tests unitaires n'en n'oublieront aucun.

Par exemple :
- PGCD : a >= b > 0 => que faire si a < b ? si a ou b <= 0 ?
- Fibonacci : n >= 0
- Dichotomie : les données data sont triés, data peut être vide
- etc...

Bien lire la documentation (javadoc ou jdoc) des méthodes, elle peut être utile et donner des conseils.

Il y a également le package [`answers`](https://github.com/JeremyBidet/Exercices/tree/develop/src/org/exercices/answers) qui donne des réponses pour chaque module et chaque exercices.<br>
**Attention !** en informatique il n'y a **JAMAIS** qu'une seule façon de faire et il n'y a pas de bonne ou mauvaise réponse, seulement de meilleures réponses. Ce sont donc mes réponses, mon algo, ma façon de voir le problème et de l'adresser.

D'ailleurs je peux te dire que la plus part des réponses dans le package [`answers`](https://github.com/JeremyBidet/Exercices/tree/develop/src/org/exercices/answers) ne sont pas celles que j'utiliserais dans la vraie vie (professionnelle), car trop lentes ou trop complexes (ou pour d'autres raisons).


# Tests
Pour tester tes développement tu peux utiliser le [`main`](https://github.com/JeremyBidet/Exercices/blob/e3b07b28ec37a6e230d15d878e9b54982d21eb9a/src/org/exercices/Main.java#L78) dans la classe [`Main`](https://github.com/JeremyBidet/Exercices/blob/develop/src/org/exercices/Main.java). Mais ce n'est pas ce qui va valider que ta méthode fonctionne pour **tous** les cas.<br>
Pour valider réellement les développement, il faut utiliser les classes de test prévues à cet effet.<br>
Elles se situent dans le dossier **`test/src/`*`<module>`*`/`*`<class>`***.

Exemple : pour le module [`Maths`](https://github.com/JeremyBidet/Exercices/blob/develop/src/org/exercices/modules/Maths.java) et l'exercice sur le `PGCD`, la classe de test sera :
```
test/src/maths/PGCD
```
Ces tests sont ce qu'on appelle des tests unitaires (=TU, ou UT en anglais).<br>
Ils servent à vérifier le bon fonctionnement d'une méthode ou un bloc de code.<br>
On dit "unitaire" car ils effectuent des tests simples mais les plus exhaustifs possible.<br>
On essaye donc tout type d'entrée (comme si l'utilisateur roulait son front sur le clavier).<br>

Voici un exemple de test unitaire, pour la culture *(mais ce n'est pas ce qui est demandé ici, ils sont déjà tous écris !!!)* :
Disons que l'on te demande de coder la fonction `toUpperCase` (transforme les minuscules en majuscules), le protocole de test doit être le plus simple possible :
- on donne une valeur d'entrée arbitraire
- on détermine manuellement (ou avec un algo qui fonctionne déjà) la valeur de sortie attendue
- on appelle la méthode testée `toUpperCase` avec la valeur d'entrée
- on vérifie que la valeur de sortie reçue (actuelle) est égale à la valeur de sortie attendue
- si le test passe => OK!, sinon ce n'est pas le test qui se trompe c'est TON dev qui est faux ! (le problème vient toujours de l'interface chaise-clavier)

```java
@Test
public void test_toUpperCase() {
	final String provided = "abcdef";
	
	final String expected = "ABCDEF";
	
	final String actual = toUpperCase(provided);
	
	assert expected == actual;
}
```

Si tu veux tester les réponses déjà écrites dans les classes de test, il te suffit de changer l'import (dans la classe de test).<br>
Les classes contenant les réponses ayant le même nom que les classes à implémenter, l'appel aux bonnes méthodes se fera tout seul :
```java
import org.exercices.modules.<classe>; => import org.exercices.answers.<classe>;

public class Test {
    @Test
    public void test_() {
        ...
    }
}
```
