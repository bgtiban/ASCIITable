/**
 * 
 */
package tabla;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Clase Princial, inicia la ejecución del programa.
 * 
 * @author bgtiban */
public class Creator {

	/** LOGGER */
	private static final Logger LOG = Logger.getAnonymousLogger();

	/** Método main.
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		final Table t = new Table();

		t.setFieldNewLine("ID", "NOMBRE", "APELLIDO", "EDAD");
		for (int i = 0; i < 5; i++) {
			t.setFieldNewLine(String.valueOf(i), "Bryan", "Tiban", String.valueOf(20 + i));
		}

		try (final BufferedWriter bw = new BufferedWriter(new FileWriter(new File(System.getProperty("user.home") + "/Desktop/TablaEnASCII.txt")))) {
			bw.write(t.getTableASCII());
		} catch (final IOException e) {
			LOG.log(Level.SEVERE, "Excepción producida al escribir en el archivo: ", e);
		}
	}

}
