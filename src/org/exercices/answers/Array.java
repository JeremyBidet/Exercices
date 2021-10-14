package org.exercices.answers;

public class Array {

	/**
	 * Cette méthode permet, à partir d'un index en dimension 1,
	 * de rechercher une donnée dans une source en dimension 2.<br>
	 * p est un entier positif ou nul.<br>
	 *
	 * @param data la source de données en dimension 2
	 * @param p l'index en dimension 1 de la donnée à récupérer
	 * @return la donnée dans la source à partir de l'index p, le caractère vide sinon
	 */
	public static char dimension2(final char[][] data, final int p) {
		if(data == null || data.length == 0) {
			return '\0';
		}

		if(data[0] == null || data[0].length == 0) {
			return '\0';
		}

		final int height = data.length;
		final int width = data[0].length;

		if(p < 0 || p >= (width * height)) {
			return '\0';
		}

		return data[p/width][p%width];
	}

	/**
	 * Cette méthode permet de rechercher une donnée à partir de ses coordonnées {@code i} et {@code j} ({@code y} et {@code x})
	 * dans une source de données en dimension 2 applatie (représentée en dimension 1).<br>
	 * {@code width} est un entier strictement positif.<br>
	 * {@code i} et {@code j} sont deux entiers positifs ou nuls.<br>
	 * {@code j} est strictement inférieur à {@code width}.<br>
	 * {@code data} est un tableau de char en dimension 2 applatie.<br>
	 *
	 * @param data la source de données en dimension 2
	 * @param width la longueur de la première dimension
	 * @param i la coordonnée y (ligne) de la donnée
	 * @param j la coordonnée x (colonne) de la donnée
	 * @return la donnée dans la source à partir de ses coordonnées i et j (y et x), le caractère vide sinon
	 */
	public static char dimension2Flat(final char[] data, final int width, final int i, final int j) {
		if(data == null || data.length == 0) {
			return '\0';
		}

		if(i < 0 || j < 0) {
			return '\0';
		}

		final int height = data.length / width;

		if(i >= height || j >= width) {
			return '\0';
		}

		return data[i * width + j];
	}
	
}
