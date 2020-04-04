/**
 * 
 */
package br.com.diego.desafiocodenation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.diego.desafiocodenation.orquestrador.Orquestrador;

/**
 * @author dcandido
 * 
 * Classe responsável por iniciar o processo
 */
public class IniciarAplicacao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IniciarAplicacao.class);
	
	public static void main(String[] args) {
		LOGGER.info("***************** INICIANDO   *****************");
		Orquestrador orquestrador = new Orquestrador();
		try {
			orquestrador.iniciarProcesso();
		
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("ERRO: " + e.getMessage());
		}
		LOGGER.info("***************** FINALIZANDO *****************");
	}
}
