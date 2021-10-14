package org.exercices.answers;

public class Maths {

	/**
	 * La classe de test correspondante est {@code BiZaries} (comme Binaries avec le N penché).<br>
	 * <br>
	 * Représentation d'un entier dans sa forme binaire dans l'ordre Big-Endian.<br>
	 * a est un entier quelconque compris entre {@link Integer#MIN_VALUE} et {@link Integer#MAX_VALUE}.<br>
	 * Le tableau retourné contient les bits (0 ou 1) représentant l'entier a.
	 * Il est de longueur {@link Integer#SIZE} (nombre de bits composant un entier, dans ce langage).<br>
	 * <br>
	 * <i>
	 * Note :<br>
	 * (1) Big-Endian (par opposition à Little-Endian) défini l'ordre dans lequel la représentation binaire d'un mot
	 * est effectuée. En Big-Endian, le bit de poids fort (MSB) se situe à gauche. A droite en Little-Endian.<br>
	 * (2) Les entiers <b>signés</b> (dans la majorité des langages) sont représentés sur 1 bit de moins.
	 * C'est-à-dire que le MSB (le premier bit, de gauche à droite en Big-Endian) est utilisé pour représenter le signe (+/-).
	 * Ainsi, la méthode du <b>{@code complément à 2}</b> est utilisée pour déterminer le nombre binaire d'un entier négatif.
	 * Cela permet de conserver l'addition dans les deux formes (décimale et binaire).
	 * </i>
	 *
	 * @param a l'entier à représenter en bits
	 * @return la représentaton binaire de l'entier dans l'ordre Big-Endian
	 */
	public static int[] itob(final int a) {
		final int[] bits = new int[Integer.SIZE];
		for(int i = Integer.SIZE - 1; i >= 0; i--) {
			bits[Integer.SIZE - i - 1] = (a & (1 << i)) != 0 ? 1 : 0;
		}
		return bits;
	}

	/**
	 * Implémentation de la fonction PGCD de a et b. (itératif)<br>
	 * a et b sont strictement positifs. a supérieur ou égal à b.<br>
	 * <br>
	 * <i>Note :<br>
	 * Le modificateur {@code final} sert à identifier des variables
	 * qui ne peuvent être modifiés (comme const en C/C++).<br>
	 * Dans notre cas, l'algorithme peut nécessiter de modifier les variables a et b,
	 * donc le mot clé {@code final} est retiré.<br>
	 * </i>
	 *
	 * @param a le dividende
	 * @param b le diviseur
	 * @return le PGCD de a et b, -1 si impossible
	 */
	public static long pgcd(long a, long b) {
		if(a <= 0 || b <= 0) {
			return -1;
		}
		if(a < b) {
			return pgcd(b, a);
		}
		long r;
		while((r = a%b) > 0) {
			a = b;
			b = r;
		}
		return b;
	}

	/**
	 * Implémentation de la fonction PGCD de a et b. (récursif)<br>
	 * a et b sont strictement positifs. a supérieur ou égal à b.<br>
	 *
	 * @param a le dividende
	 * @param b le diviseur
	 * @return le PGCD de a et b, -1 si impossible
	 */
	public static long r_pgcd(final long a, final long b) {
		if(a <= 0 || b <= 0) {
			return -1;
		}
		if(a < b) {
			return r_pgcd(b, a);
		}
		if(a%b == 0) {
			return b;
		}
		return r_pgcd(b,a%b);
	}

	/**
	 * Implémentation de la fonction PPCM de a et b. (itératif)<br>
	 * a et b sont positifs ou nuls.<br>
	 *
	 * @param a le premier entier
	 * @param b le second entier
	 * @return le PPCM de a et b, -1 si impossible
	 */
	public static long ppcm(final long a, final long b) {
		if(a < 0 || b < 0) {
			return -1;
		}
		return (a * b) / pgcd(a, b);
	}

	/**
	 * Le factoriel du nombre n. (itératif)<br>
	 * n est positif ou nul.<br>
	 *
	 * @param n le nombre d'itération pour le calcul du factoriel
	 * @return le factoriel du nombre n, -1 si impossible
	 */
	public static long factoriel(final long n) {
		if(n < 0) {
			return -1;
		}
		if(n == 0) {
			return 1;
		}
		long fact = 1;
		for(int i = 2; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}

	/**
	 * Le factoriel du nombre n. (récursif)<br>
	 * n est positif ou nul.<br>
	 *
	 * @param n le nombre d'itération pour le calcul du factoriel
	 * @return le factoriel du nombre n, -1 si impossible
	 */
	public static long r_factoriel(final long n) {
		if(n < 0) {
			return -1;
		}
		if(n == 0) {
			return 1;
		}
		return n * r_factoriel(n-1);
	}

	/**
	 * Implémentation de la suite de Fibonacci pour la valeur n. (itératif)<br>
	 * n est positif ou nul.<br>
	 *
	 * @param n l'ordre de la suite de Fibonacci
	 * @return le nombre de Fibonacci calculé, -1 si impossible
	 */
	public static long fibonacci(final long n) {
		if(n < 0) {
			return -1;
		}
		if(n == 0) {
			return 0;
		}
		long n0 = 0, n1 = 1, fibo = 1;
		for(int i = 2; i <= n; i++) {
			fibo = n0 + n1;
			n0 = n1;
			n1 = fibo;
		}
		return fibo;
	}

	/**
	 * Implémentation de la suite de Fibonacci pour la valeur n. (récursif)<br>
	 * n est positif ou nul.<br>
	 *
	 * @param n l'ordre de la suite de Fibonacci
	 * @return le nombre de Fibonacci calculé, -1 si impossible
	 */
	public static long r_fibonacci(final long n) {
		if(n < 0) {
			return -1;
		}
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		return r_fibonacci(n-2) + r_fibonacci(n-1);
	}

	/**
	 * Implémentation du problème de Josèphe (ou Josephus, ou Caligula, ou Yseult). (iteratif) <br>
	 * n est strictement positif.<br>
	 * m est strictement positif.<br>
	 *
	 * @param n le nombre de participants
	 * @param k l'ordre d'élimination
	 * @return la position du dernier survivant, -1 si impossible
	 */
	public static int josephus(final int n, final int k) {
		if(n <= 0 || k <= 0) {
			return -1;
		}

		final int[] applicants = new int[n];
		// initialisation des participants (de 0 à n-1)
		for(int i = 0; i < n; i++) {
			applicants[i] = i;
		}

		// élimination des participants
		int survivors = n, last = -1;
		while(survivors > 0) {
			int next = (last + 1) % n;
			for(int i = 0; i < k; next++, i++) {
				if(applicants[next % n] == -1) {
					i--;
				}
			}
			last = (next + n - 1) % n;
			applicants[last] = -1;
			survivors--;
		}

		return last;
	}

	/**
	 * Implémentation du problème de Josèphe (ou Josephus, ou Caligula, ou Yseult). (récursif) <br>
	 * n est strictement positif.<br>
	 * m est strictement positif.<br>
	 *
	 * @param n le nombre de participants
	 * @param k l'ordre d'élimination
	 * @param cpt un compteur permettant d'éliminer les participants
	 * @param next la position du prochain à éliminer
	 * @param eliminated les participants éliminés au fur et à mesure, initialisé avec des -1
	 * @return la position du dernier survivant, -1 si impossible
	 */
	public static int r_josephus(final int n, final int k, final int cpt, final int next, final int[] eliminated) {
		if(n <= 0 || k <= 0 || eliminated.length != n) {
			return -1;
		}

		// on a éliminé tous les participants, on retourne le dernier éliminé.
		int last = eliminated[eliminated.length - 1];
		if(last != -1) {
			return last;
		}

		// recherche de next dans les éliminés
		// on ne parcours pas tout le tableau, uniquement les éliminés (donc arrêt au premier -1)
		for(int i = 0; eliminated[i] != -1; i++) {
			// si next est un éliminé on passe au suivant sans décrémenter le compteur d'élimination
			if(eliminated[i] == next) {
				return r_josephus(n, k, cpt, (next + 1) % n, eliminated);
			}
		}

		// on a avancé jusqu'au k-ème participant non-éliminé.
		// on l'élimine et passe au suivant, le compteur d'élimination est réinitialisé.
		// pas cpt == 0 car on commence à k et non k-1
		if(cpt == 1) {
			int i = 0;
			for(; eliminated[i] != -1; i++);
			eliminated[i] = next;
			return r_josephus(n, k, k, (next + 1) % n, eliminated);
		}

		// aucun des cas ci-dessus, on continue la recherche du prochain à éliminer
		return r_josephus(n, k, cpt-1, (next + 1) % n, eliminated);
	}

	/**
	 * Implémentation du crible d'Eratosthène jusqu'à la valeur n. (itératif)<br>
	 * n est strictement positif.<br>
	 * <br>
	 * <i>Note :<br>
	 * (0) 1 n'est pas considéré comme premier.<br>
	 * (1) le nombre de nombres premiers inférieurs à n est forcément inférieur ou égal à n lui-même.<br>
	 * (2) en réalité ce nombre peut être approché par limite : lim [x->inf] pi(x) / (x/ln(x)) = 1<br>
	 *     donc pour x tendant vers l'infini, le nombre de nombres premiers inférieurs à x (noté pi(x))
	 *     est proche (mais pas exacte) de x / ln(x).<br>
	 * </i>
	 *
	 * @param n la limite du crible d'Eratosthène
	 * @return le nombre de nombres premiers inférieurs ou égals à n
	 */
	public static long eratosthene(final long n) {
		if(n <= 0) {
			return -1;
		}

		// on ignore 0 et 1 car ils ne sont pas considérés comme premiers

		// creation du tableau contenant tous les entiers de 2 à n (on ignore 0 et 1 mais pas n, donc n-1 pour la taille)
		final long[] data = new long[(int) n - 1];

		// Pour rappel: un tableau de n élements initialisé avec les entiers naturels consécutifs à partir de 0
		// contiendra les entiers de 0 à n-1. Or on ignore 0 et 1 mais pas n, donc n-1 comme condition de fin
		// et i+2 comme valeur permet d'intégrer les entiers de 2 à n, en partant de i=0
		for(int i = 0; i < n - 1; i++) {
			data[i] = i+2;
		}

		int primeQuantity = 0;
		// élimination (remplacement par 0) de tous les entiers non premiers
		for(int i = 0; i < n - 1; i++) {
			// entier non premier déjà supprimé
			if(data[i] == 0) {
				continue; // on passe à l'entier suivant
			}
			// entier premier => incrémentation du compteur et suppression de tous ses multiples
			primeQuantity++;
			// j = i+1 on part directement de la cellule suivante
			for(int j = i+1; j < n - 1; j++) {
				// si data[j] modulo data[i] == 0 alors data[j] est multiple de data[i] donc suppression de data[j] (remplacement par 0)
				if(data[j] % data[i] == 0) {
					data[j] = 0;
				}
			}
		}

		return primeQuantity;
	}

}
