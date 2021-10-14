package org.exercices.answers;

import java.util.List;

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
		if(data.length == 0) {
			return -1;
		}
		int comp, tmp = -1;
		int last = -1, lbound = 0, ubound = data.length-1;
		int i = data.length / 2;
		// tant que data[i] != target
		while((comp = Integer.compare(data[i], target)) != 0) {
			// data[i] < target
			if(comp < 0) {
				tmp = i;
				i = i + (int) java.lang.Math.ceil((ubound - i) / 2.);
				lbound = tmp;
			}
			// data[i] > target
			if(comp > 0) {
				tmp = i;
				i = i - (int) java.lang.Math.ceil((i - lbound) / 2.);
				ubound = tmp;
			}
			// on boucle sur les valeurs adjacentes car pas de match => -1
			if(last == i) {
				return -1;
			}
			last = tmp;
		}
		return target == data[i] ? i : -1;
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
		// pas de vecteur de recherche
		if(data.length == 0) {
			return -1;
		}

		int comp = Integer.compare(data[position], target);
		int next = -1;

		// data[position] == target ? match => fin
		if(comp == 0) {
			return position;
		}
		// data[position] < target ? pas encore de match => mise à jour position et intervalle suivants
		if(comp < 0) {
			next = position + (int) java.lang.Math.ceil((ubound - position) / 2.);
			lbound = position;
		}
		// data[position] > target ? pas encore de match => mise à jour position et intervalle suivants
		if(comp > 0) {
			next = position - (int) java.lang.Math.ceil((position - lbound) / 2.);
			ubound = position;
		}
		// la dernière position == la suivante ? on boucle sur les valeurs adjacentes car pas de match => fin -1
		if(last == next) {
			return -1;
		}

		return r_dichotomie(data, target, next, lbound, ubound, position);
	}

	/**
	 * Cherche par dichotomie une valeur dans une table de données. (récursif et Java 8)<br>
	 * La table de données est triée dans l'ordre croissant naturel.<br>
	 * La valeur cherchée peut ne pas être dans la table de données.<br>
	 *
	 * @param data la liste de données dans laquelle chercher (le vecteur de recherche)
	 * @param target la valeur à chercher
	 * @param realLbound la limite inférieure réelle (liste originale) de l'intervalle de recherche
	 * @return la position finale de la valeur dans la table de données, -1 si non trouvée
	 */
	public static int r_dichotomie2(final List<Integer> data, final int target, int realLbound) {
		// pas (ou plus) de vecteur de recherche
		if(data.size() == 0) {
			return -1;
		}

		// tant qu'il n'y a pas de match, l'algorithme va vider la liste jusqu'à n'avoir plus qu'un élément,
		// dans ce cas il suffit de tester cet élément avec la valeur chercher et retourner
		// -1 s'ils ne correspondent pas, ou la limite inférieure 'réelle' de la liste originale.
		if(data.size() == 1) {
			return data.get(0) == target ? realLbound : -1;
		}

		// calcul de la position se situant au milieu de l'intervalle 'fictif' actuel
		int position = data.size() / 2;
		int lbound = 0, ubound = data.size();
		int comp = Integer.compare(data.get(position), target);

		// data[position] == target ? match => fin = position actuelle intervalle 'fictif' + limite inférieure réelle
		if(comp == 0) {
			return position + realLbound;
		}
		// data[position] < target ? pas encore de match => mise à jour intervalle 'fictif' suivant et limite inférieure réelle
		if(comp < 0) {
			realLbound = realLbound + position;
			lbound = position;
		}
		// data[position] > target ? pas encore de match => mise à jour intervalle 'fictif' suivant
		if(comp > 0) {
			ubound = position;
		}

		// L'usage de subList est une solution élégante car elle simule une sous liste dans l'intervalle donné.
		// Le nouvel intervalle 'fictif' est toujours réinitialisé à partir de 0, donc il est nécessaire de conserver,
		// au moins, la limite inférieure de l'intervalle réel (realLbound).
		// Par ailleurs, la position suivante est toujours la même => le médian du nouvel intervalle, soit la moitié de sa taille.
		// Cela nous permet de supprimer les paramètres position, lbound et ubound de la fonction récursive, mais nous oblige à
		// ajouter le paramètre realLbound. Le paramètre last est supprimé lui aussi car si aucune correpondance n'est trouvée,
		// la sous-liste se vide progressivement jusqu'à avoir une taille de 0.
		// Une solution encore plus élégante aurait pu être implémentée si la sous liste conservait les index de l'intervalle 'réel'
		// de la liste originale. Cela aurait permit de retirer également le paramètre realLbound.
		return r_dichotomie2(data.subList(lbound, ubound), target, realLbound);
	}

}
