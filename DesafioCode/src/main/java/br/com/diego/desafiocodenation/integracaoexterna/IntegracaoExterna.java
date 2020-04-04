/**
 * 
 */
package br.com.diego.desafiocodenation.integracaoexterna;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.diego.desafiocodenation.manipular.ManipulaArquivo;
import br.com.diego.desafiocodenation.model.constantes.Constantes;
import br.com.diego.desafiocodenation.resultado.VerificaResultado;

/**
 * @author dcandido
 * @since 04/04/2020
 *
 * Responsável por consumir a Api informada
 */
public class IntegracaoExterna {
	private static final Logger LOGGER = LoggerFactory.getLogger(IntegracaoExterna.class);
	/**
	 * Send get.
	 *
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 */
	public static String sendGet() throws IOException, NoSuchAlgorithmException {
		LOGGER.info("INICIANDO - GET");
		
		URL obj = new URL(Constantes.GET.concat(Constantes.TOKEN));
	    HttpURLConnection con = (HttpURLConnection)obj.openConnection();
	    con.setRequestMethod("GET");
	    con.setRequestProperty("User-Agent", "Mozila/5.0");
	    
	    int response_code = con.getResponseCode();
	    LOGGER.info("\nSending 'GET' request to URL: ");
	    LOGGER.info("Response Code: " + response_code);
	    
	    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	    
	    StringBuffer response = new StringBuffer();
	    String inputLine;

	    while ((inputLine = in.readLine()) != null) { 
	      response.append(inputLine);
	    }
	    in.close();
	    
	    System.out.printf("Response %s \n", response.toString());
	    
	    LOGGER.info("FINALIZANDO - GET");
	    return response.toString();
	}
	
	/**
	 * Send post.
	 *
	 * @throws MalformedURLException the malformed URL exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void sendPost() throws MalformedURLException, IOException {
		File fileToUpload = new File(ManipulaArquivo.geraCaminho());
		String boundary = Long.toHexString(System.currentTimeMillis()); // Just generate some unique random value.

		URLConnection connection = new URL(Constantes.POST.concat(Constantes.TOKEN)).openConnection();
		connection.setDoOutput(true); // This sets request method to POST.
		connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
		PrintWriter writer = null;
		try {
		    writer = new PrintWriter(new OutputStreamWriter(connection.getOutputStream()));
		    writer.println("--" + boundary);
		    writer.println("Content-Disposition: form-data; name=\"answer\"; filename=\"answer.json\"");
		    writer.println();
		    BufferedReader reader = null;
		    try {
		        reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileToUpload)));
		        for (String line; (line = reader.readLine()) != null;) {
		            writer.println(line);
		        }
		    } finally {
		        if (reader != null) try { reader.close(); } catch (IOException logOrIgnore) {}
		    }
		    writer.println("--" + boundary + "--");
		} finally {
		    if (writer != null) writer.close();
		}

		LOGGER.info("FINALIZANDO - POST");
		VerificaResultado.verificaResultado(connection);
	}
}
