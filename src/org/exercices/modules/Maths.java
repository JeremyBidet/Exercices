package org.exercices.modules;

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
		// TODO
		return new int[Integer.SIZE];
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
		// TODO
		return 0L;
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
		// TODO
		return 0L;
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
		// TODO
		return 0L;
	}

	/**
	 * Le factoriel du nombre n. (itératif)<br>
	 * n est positif ou nul.<br>
	 *
	 * @param n le nombre d'itération pour le calcul du factoriel
	 * @return le factoriel du nombre n, -1 si impossible
	 */
	public static long factoriel(final long n) {
		// TODO
		return 0L;
	}

	/**
	 * Le factoriel du nombre n. (récursif)<br>
	 * n est positif ou nul.<br>
	 *
	 * @param n le nombre d'itération pour le calcul du factoriel
	 * @return le factoriel du nombre n, -1 si impossible
	 */
	public static long r_factoriel(final long n) {
		// TODO
		return 0L;
	}

	/**
	 * Implémentation de la suite de Fibonacci pour la valeur n. (itératif)<br>
	 * n est positif ou nul.<br>
	 *
	 * @param n l'ordre de la suite de Fibonacci
	 * @return le nombre de Fibonacci calculé, -1 si impossible
	 */
	public static long fibonacci(final long n) {
		// TODO
		return 0L;
	}

	/**
	 * Implémentation de la suite de Fibonacci pour la valeur n. (récursif)<br>
	 * n est positif ou nul.<br>
	 *
	 * @param n l'ordre de la suite de Fibonacci
	 * @return le nombre de Fibonacci calculé, -1 si impossible
	 */
	public static long r_fibonacci(final long n) {
		// TODO
		return 0L;
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
		// TODO
		return -1;
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
		// TODO
		return -1;
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
		// TODO
		return 0L;
	}

}
