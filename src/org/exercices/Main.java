package org.exercices;

import org.exercices.modules.Maths;

public class Main {

	/**
	 * Les exercices sont découpés en modules :
	 * <ul>
	 *     <li><b>Array</b> : manipulation de tableau à 1 ou 2 dimensions</li>
	 *     <li><b>Cypher</b> : algo de chiffrement</li>
	 *     <li><b>Finder</b> : algo de recherche</li>
	 *     <li><b>Math</b> : problèmes de maths</li>
	 * </ul>
	 *
	 * Chaque module contient une ou plusieurs méthodes correspondant aux différents exercices du module.<br>
	 * Exemple : dans le module {@link Maths}, pour le calcul du {@code PGCD} on trouve deux méthodes : {@link Maths#pgcd} et {@link Maths#r_pgcd},
	 * 		     une pour la version itérative et l'autre pour la version récursive.<br>
	 * <br>
	 * Pour tester tes développement tu peux utiliser le {@link Main#main} dans la classe {@link Main}.<br>
	 * Pour valider les développement, il faut utiliser les classes de test prévues à cet effet.<br>
	 * Elles se situent dans le dossier <b>{@code test/src/<module>/<class>}</b>.<br>
	 * Exemple : pour le module {@link Maths} et l'exercice sur le {@code PGCD}, la classe de test sera :<br>
	 *
	 * <pre>{@code test/src/maths/PGCD}</pre><br>
	 *
	 * Ces tests sont ce qu'on appelle des tests unitaires.<br>
	 * Ils servent à vérifier le bon fonctionnement d'une méthode ou un bloc de code.<br>
	 * On dit "unitaire" car ils effectuent des tests simples mais le plus exhaustifs possible.<br>
	 * Exemple : on te demande de coder la fonction {@code toUpperCase} (transforme les minuscules en majuscules),
	 * le protocole de test doit être le plus simple possible :
	 * <ul>
	 *     <li>on donne une valeur d'entrée arbitraire</li>
	 *     <li>la valeur de sortie attendue</li>
	 *     <li>on appelle la méthode {@code toUpperCase} avec la valeur d'entrée</li>
	 *     <li>on vérifie que la valeur de sortie reçue est égale à la valeur de sortie attendue</li>
	 * </ul>
	 * Ex:
	 * <pre>{@code
	 *  // given
	 *  final String provided = "abcdef";
	 *  // expected
	 *  final String expected = "ABCDEF";
	 *  // actual
	 *  final String actual = toUpperCase(provided);
	 *  // assert
	 *  assert expected == actual;
	 * }</pre>
	 *
	 * Il y a également le package {@code answers} qui correspond aux réponses pour chaque module et chaque exercices.<br>
	 * Attention ! en informatique il n'y a <b>JAMAIS</b> qu'une seule façon de faire et il n'y a pas de bonne ou mauvaise réponse,
	 * seulement de meilleures réponses. Ce sont donc mes réponses, mon algo, ma façon de voir le problème et de l'adresser.<br>
	 * D'ailleurs je peux te dire que la plus part des réponses dans le package {@code answers} ne sont pas celles que j'utiliserais dans la vraie vie (professionnelle),
	 * car trop lentes ou trop complexes (ou pour d'autres raisons).<br>
	 * Si tu veux tester les réponses dans les classes de test, il te suffit de changer l'import :
	 * <pre>{@code
	 * import org.exercices.modules.<classe>;
	 * => import org.exercices.answers.<classe>;
	 * }</pre>
	 *
	 * Dans tes dev, n'oublie pas de prendre en compte tous les cas de figures, car les tests unitaires n'en n'oublieront aucun.<br>
	 * Par exemple :
	 * <ul>
	 *     <li>PGCD : a >= b > 0 => que faire si a < b ? si a ou b <= 0 ?</li>
	 *     <li>Fibonacci : n >= 0</li>
	 *     <li>Dichotomie : les données data sont triés, data peut être vide</li>
	 *     <li>etc...</li>
	 * </ul>
	 *
	 * Bien lire la documentation (javadoc) des méthodes, elle peut être utile et donner des conseils.<br>
	 */
	public static void main(final String[] args) {
		// Merci de lire la jdoc de cette méthode avant de commencer ! (ou le README au choix)
		// (passer la souris sur le nom de la méthode suffit à l'afficher)
		// 
		// Tu peux effectuer tes tests de développement ici avant de soumettre tes fonctions aux tests unitaires.
	}

}
