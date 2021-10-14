package org.exercices.answers;

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
		if(source == null) {
			return new char[0];
		}

		// calcul du cardinal de l'alphabet
		final int cardinal = 'Z' - 'A' + 1;

		// initialisation du tableau contenant le code
		final char[] cypher = new char[source.length];
		for(int i = 0; i < source.length; i++) {
			// si le caractère n'est pas en majuscule
			if(source[i] < 'A' || source[i] > 'Z') {
				// si il n'est pas non plus en minuscule (donc pas alphabétique)
				if(source[i] < 'a' || source[i] > 'z') {
					return new char[0];
				} else { // sinon on le transforme en majuscule
					source[i] = (char) (source[i] + 'A' - 'a');
				}
			}
			// source[i] - 'A' => change l'intervalle du code ASCII de l'alphabet (65-90 => 0-25)
			// + key => permet de chiffrer la lettre source (ex: pour key=2, 'A' +> 'C')
			// + cardinal => permet de gérer les cas où la clé est négative (ex: pour key=-2, 'A' => 'Y')
			// % cardinal => permet de "cycler" dans l'alphabet ...,Z,A,B,C,...,Y,Z,A,B,...
			// + 'A' => permet de retourner à l'intervalle du code ASCII (0-25 => 65-90)
			cypher[i] = (char) ((source[i] - 'A' + key + cardinal) % cardinal + 'A');
		}

		return cypher;
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
		if(cypher == null) {
			return new char[0];
		}
		// petite astuce, pour déchiffrer César, la clé de déchiffrement est l'inverse (ou le complément à 2 en base 26) de la clé de chiffrement (2 => -2 ou 24)
		return ceasarEncrypt(cypher, -key);
	}
	
}
