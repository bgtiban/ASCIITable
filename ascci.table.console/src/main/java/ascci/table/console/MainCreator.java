/**
 * 
 */
package ascci.table.console;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Clase Princial, inicia la ejecución del programa.
 * 
 * @author bgtiban */
public class MainCreator {

	/** LOGGER */
	private static final Logger LOG = Logger.getAnonymousLogger();

	/** Método main.
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		final Table table = new Table();

		table.setFieldNewLine("ID", "NOMBRE", "APELLIDO", "EDAD");
		for (int i = 0; i < 5; i++) {
			table.setFieldNewLine(String.valueOf(i), "Bryan", "Tiban", String.valueOf(20 + i));
		}

		System.out.println(table.getTableASCII());
	}

}
