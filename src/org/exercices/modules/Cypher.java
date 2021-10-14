package org.exercices.modules;

public class Cypher {

	/**
	 * Implémentation de l'algorithme du chiffrement de César avec la clé {@code key}.<br>
	 * {@code key} est un entier quelconque.<br>
	 * {@code source} est un tableau de caractères alphabétiques uniquement, en majuscule.<br>
	 * <br>
	 * <i>
	 * Note :<br>
	 * (1) pour la clé de chiffrement {@code x}, la clé de déchiffrement sera {@code -x}.
	 * Il existe un cas particulier pour la clé {@code 13} (voir ROT13).<br>
	 * (2) le chiffrement de César connait un corollaire simplifié appelé le ROT13,
	 * il s'agit en fait du chiffrement de César avec la clé de chiffrement{@code 13}
	 * qui se trouve être aussi la clé de déchiffrement (car -13 % 26 = 13).<br>
	 * </i>
	 *
	 * @param source la source à chiffrer
	 * @param key la clé de chiffrement
	 * @return le code chiffré de la source, sinon un code vide
	 */
	public static char[] ceasarEncrypt(final char[] source, final int key) {
		// TODO
		return new char[source.length];
	}

	/**
	 * Implémentation dde l'algorithme du <b>dé</b>chiffrement de César avec la clé {@code key}.<br>
	 * {@code key} est un entier quelconque.<br>
	 *
	 * @param cypher le code chiffré à déchiffrer
	 * @param key la clé de chiffrement
	 * @return le code déchiffré, sinon un code vide
	 */
	public static char[] ceasarDecrypt(final char[] cypher, final int key) {
		// TODO
		return new char[cypher.length];
	}

}
