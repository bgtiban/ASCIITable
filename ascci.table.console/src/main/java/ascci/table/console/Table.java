/**
 * 
 */
package ascci.table.console;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/** Clase que representa una tabla y contiene operaciones para insertar filas.
 * La presentación mostrará una tabla de contenido en formato ASCII.
 * 
 * @author bgtiban */
public class Table {

	private final Collection<String> fields;

	/** Constructor */
	public Table() {
		fields = new ArrayList<>();
	}

	/** Constructor que recibe una colección para ser pintada posteriormente con
	 * el método {@link #getTableASCII()}
	 * 
	 * @param collection
	 *            Colección de campos. */
	public Table( final Collection<String> collection) {
		fields = collection;
	}

	/** Establece un conjunto de campos para ser pintados en una fila con
	 * formato tabla ASCII.
	 * 
	 * @param values
	 *            Valores a pintar separados por coma. */
	public void setField( final String... values) {
		Collections.addAll(fields, values);
	}

	/** Establece un conjunto de campos para ser pintados en una fila y
	 * postoriormente añade un salto de línea.
	 * 
	 * @param values
	 *            Valores a pintar separados por coma */
	public void setFieldNewLine( final String... values) {
		Collections.addAll(fields, values);
		newLine();
	}

	/** Se retornará una tabla en formato ASCII con los valores establecidos con
	 * los métodos {@link #setField(String...)} y/o
	 * {@link #setFieldNewLine(String...)} creada
	 *
	 * @return tabla en formato ASCII */
	public String getTableASCII() {
		final StringBuilder sb = new StringBuilder();
		final String maxDashesByField = Utils.createDashes(Utils.getBiggest(fields).length() + 2);
		// Creación de separador de filas.
		final String dashesLine = createTotalDashes(maxDashesByField);

		// Creación de contenido de tabla
		sb.append(dashesLine);
		// Creo el contenido de la tabla.
		createEssence(sb, maxDashesByField, dashesLine);
		sb.append(Constants.BREAK_LINE);
		sb.append(dashesLine);
		// Adición de guianes a la cadena principal
		return sb.toString();
	}

	/** Crea el contenido de {@link #fields} en formato tabla ASCII
	 * 
	 * @param sb
	 *            Constructor de cadena.
	 * @param maxDashesByField
	 *            conjunto de caracteres que separarán las columnas.
	 * @param dashesLine
	 *            conjunto de caracteres que separarán las filas */
	public void createEssence(final StringBuilder sb, final String maxDashesByField, final String dashesLine) {
		for (final String field : fields) {

			if (Constants.NEWLINE.equals(field)) {
				sb.append(Constants.COLUMN);
				sb.append(Constants.BREAK_LINE);
				sb.append(dashesLine);
			} else {
				sb.append(Constants.COLUMN + Constants.SPACE + field.toUpperCase() + Utils.createSpaces(maxDashesByField.length() - 1 - field.length()));
			}
		}
		sb.append(Constants.COLUMN);
	}

	/** Se crean el conjunto de [+---------+---------+---------+] que separarán
	 * las filas.
	 * 
	 * @param maxDashesByField
	 *            máximo de guiones a establecer.
	 * @return separador de filas. */
	private String createTotalDashes(final String maxDashesByField) {
		final StringBuilder dashesLine = new StringBuilder();
		// (+)--------+ Se añade el primer simbolo +.
		dashesLine.append(Constants.PLUS);
		/* Se recorren los campos para determinar dónde se ha establecido el
		 * caracter especial que indica Nueva Linea. */
		for (final String string : fields) {
			if (!Constants.NEWLINE.equalsIgnoreCase(string)) {
				/* Mientras no se encuentre el caracter NEWLINE se añade un
				 * conjunto de +---------+ */
				dashesLine.append(maxDashesByField + Constants.PLUS);
			} else {
				break;
			}
		}
		// Se añade un salto de linea tras +---------+ (salto de linea)
		dashesLine.append(Constants.BREAK_LINE);
		return dashesLine.toString();
	}

	/** Establece en la lista de {@link #fields} un caracter especial que
	 * significará SALTO DE LINEA. */
	public void newLine() {
		fields.add(Constants.NEWLINE);
	}

}
