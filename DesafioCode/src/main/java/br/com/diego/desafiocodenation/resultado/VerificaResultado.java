/**
 * 
 */
package br.com.diego.desafiocodenation.resultado;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dcandido
 *
 */
public class VerificaResultado {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VerificaResultado.class);
	
	/**
	 * Verifica resultado.
	 *
	 * @param connection the connection
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void verificaResultado(URLConnection connection) throws IOException {
		LOGGER.info("INICIANDO VERIFICAÇÃO");
		int responseCode = ((HttpURLConnection) connection).getResponseCode();
		
		if(responseCode != 200) {
			LOGGER.error("Erro - getResponseCode: "+ responseCode);
			LOGGER.error("Erro - getResponseMessage: "+ ((HttpURLConnection) connection).getResponseMessage());
		
		} else {
			LOGGER.info("SUCESSO - PARABÉNS");
			LOGGER.info("getResponseCode: "+ responseCode);
			LOGGER.info("getResponseMessage: "+ ((HttpURLConnection) connection).getResponseMessage());
		}
		LOGGER.info("FINALIZANDO VERIFICAÇÃO");
	}
}
