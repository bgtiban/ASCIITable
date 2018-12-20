/**
 * 
 */
package tabla;

import java.util.Collection;
import lombok.NonNull;

/** @author bgtiban */
public final class Utils {

	private Utils() {}

	/** Se retornará un conjunto de guiones (-) tantos como se indiquen por
	 * parámetro.
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

	/** Se retornará un conjunto de espacios ( ) tantos como se indiquen por
	 * parámetro.
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

	/** Retorna la palabra más larga
	 * 
	 * @param words
	 *            lista de palabras a comparar.
	 * @return La palabra más larga de la lista */
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

	/** Dadas dos cadenas compara cuál de ellas es mayor y la retorna.
	 * 
	 * @param string1
	 * @param string2
	 * @return La cadena más larga. */
	public static String compareSizes(@NonNull final String string1, @NonNull final String string2) {
		return string1.length() >= string2.length() ? string1 : string2;
	}
}
