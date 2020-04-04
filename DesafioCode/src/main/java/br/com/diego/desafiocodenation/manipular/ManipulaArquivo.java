/**
 * 
 */
package br.com.diego.desafiocodenation.manipular;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.diego.desafiocodenation.model.Answer;
import br.com.diego.desafiocodenation.model.constantes.Constantes;

/**
 * @author dcandido
 * @since 04/04/2020
 * 
 * Classe responsável por Manipular os Dados do Arquivo
 */
public class ManipulaArquivo {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ManipulaArquivo.class);
	
	/**
	 * Atualiza arquivo.
	 *
	 * @param answer the answer
	 */
	public static void atualizaArquivo(Answer answer) {
		LOGGER.info("INICIANDO TRATATIVA ARQUIVO");
		
		JSONObject jsonObject = getArquivo();
		
		jsonObject.put("numero_casas", answer.getNumeroCasas());
		jsonObject.put("token", answer.getToken());
		jsonObject.put("cifrado", answer.getCifrado());
		jsonObject.put("decifrado", answer.getDecifrado());
		jsonObject.put("resumo_criptografico", answer.getResumoCriptografico());
		
		try {
			LOGGER.info("ATUALIZANDO ARQUIVO");
			
			FileWriter fw = new FileWriter(geraCaminho());
			fw.write(jsonObject.toString());
			fw.close();
			
			LOGGER.info("ARQUIVO SALVO");
		} catch (IOException e) {
			System.err.println("\nERRO AO MANIPULAR JSON, " + e.getMessage());
		}
		
		LOGGER.info("FINALIZANDO TRATATIVA ARQUIVO");
	}
	
	/**
	 * Obtem arquivo.
	 *
	 * @return the JSON object
	 */
	public static JSONObject obtemArquivo() {
		return getArquivo();
	}
	
	/**
	 * Gets the arquivo.
	 *
	 * @return the arquivo
	 */
	private static JSONObject getArquivo() {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		JSONTokener jsonTokener = new JSONTokener(cl.getResourceAsStream(Constantes.ANSWER_JSON));
		return new JSONObject(jsonTokener);
	}
	
	/**
	 * Gera caminho.
	 *
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static String geraCaminho() throws IOException {
		return new File(".").getCanonicalPath() + Constantes.CAMINHO_FISICO + Constantes.ANSWER_JSON;
	}
	
	/**
	 * Nome arquivo.
	 *
	 * @return the string
	 */
	public static String nomeArquivo() {
		return Constantes.ANSWER_JSON;
	}
}
