/**
 * 
 */
package ascci.table.console;

import java.util.Collection;

/** @author bgtiban */
public final class Utils {

	private Utils() {}

	/** Se retornar� un conjunto de guiones (-) tantos como se indiquen por
	 * par�metro.
	 * 
	 * @param DashQuantity
	 *            cantidad de guiones (-) a pintar
	 * @return tantos guiones como se hayan especificado */
	public static String createDashes(final int DashQuantity) {
		final StringBuilder dashes = new StringBuilder();
		for (int i = 0; i < DashQuantity; i++) {
			dashes.append(Constants.DASH);
		}
		return dashes.toString();
	}

	/** Se retornar� un conjunto de espacios ( ) tantos como se indiquen por
	 * par�metro.
	 * 
	 * @param spaceQuantity
	 *            cantidad de espacios ( ) a pintar
	 * @return tantos espacios como se hayan especificado */
	public static String createSpaces(final int spaceQuantity) {
		final StringBuilder spaces = new StringBuilder();
		for (int i = 0; i < spaceQuantity; i++) {
			spaces.append(Constants.SPACE);
		}
		return spaces.toString();
	}

	/** Retorna la palabra m�s larga
	 * 
	 * @param words
	 *            lista de palabras a comparar.
	 * @return La palabra m�s larga de la lista */
	public static String getBiggest(final Collection<String> words) {
		String theBig = "";
		String wordAux = theBig;
		for (final String word : words) {
			if (!Constants.NEWLINE.equals(word)) {
				theBig = compareSizes(word, wordAux);
				wordAux = theBig;
			}
		}

		return theBig;
	}

	/** Dadas dos cadenas compara cu�l de ellas es mayor y la retorna.
	 * 
	 * @param string1
	 * @param string2
	 * @return La cadena m�s larga. */
	public static String compareSizes( final String string1,  final String string2) {
		return string1.length() >= string2.length() ? string1 : string2;
	}
}
