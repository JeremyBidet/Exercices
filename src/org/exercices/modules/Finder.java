package org.exercices.modules;

public class Finder {

	/**
	 * Cherche par dichotomie une valeur dans une table de données. (itératif)<br>
	 * La table de données est triée dans l'ordre croissant naturel.<br>
	 * La valeur cherchée peut ne pas être dans la table de données.<br>
	 *
	 * @param data la table de données dans laquelle chercher
	 * @param target la valeur à chercher
	 * @return la position de la valeur dans la table de données, -1 si non trouvée
	 */
	public static int dichotomie(final int[] data, final int target) {
		// TODO
		return 0;
	}

	/**
	 * Cherche par dichotomie une valeur dans une table de données. (récursif)<br>
	 * La table de données est triée dans l'ordre croissant naturel.<br>
	 * La valeur cherchée peut ne pas être dans la table de données.<br>
	 *
	 * @param data la table de données dans laquelle chercher (le vecteur de recherche)
	 * @param target la valeur à chercher
	 * @param position la position suivante de recherche
	 * @param lbound la limite inférieure de l'intervalle de recherche
	 * @param ubound la limite supérieure de l'intervalle de recherche
	 * @param last la dernière position de recherche
	 * @return la position finale de la valeur dans la table de données, -1 si non trouvée
	 */
	public static int r_dichotomie(final int[] data, final int target, final int position, int lbound, int ubound, final int last) {
		// TODO
		return position;
	}

}
