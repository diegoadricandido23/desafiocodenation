/**
 * 
 */
package br.com.diego.desafiocodenation.orquestrador;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.diego.desafiocodenation.integracaoexterna.IntegracaoExterna;
import br.com.diego.desafiocodenation.manipuladados.DecifraDados;
import br.com.diego.desafiocodenation.manipular.ManipulaArquivo;
import br.com.diego.desafiocodenation.model.Answer;

/**
 * @author dcandido
 * @since 04/04/2020
 *
 * Classe responsável por 'orquestrar as chamadas da rotina
 *
 */
public class Orquestrador {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Orquestrador.class);
	
	public void iniciarProcesso() throws MalformedURLException, IOException, NoSuchAlgorithmException {
		
		Answer answer = new Answer();
		
		LOGGER.info("INICIADO PROCESSO - GET");
		String mensagemRecebida = IntegracaoExterna.sendGet();
		LOGGER.info("FINALIZANDOO PROCESSO - GET");
		
		LOGGER.info("================================================");
		
		LOGGER.info("INICIADO PROCESSO - OBTENÇÃO OBJETO");
		DecifraDados.obterDados(answer, mensagemRecebida);
		LOGGER.info("FINALIZANDOO PROCESSO - OBTENÇÃO OBJETO");
		
		LOGGER.info("================================================");
		
		LOGGER.info("INICIADO PROCESSO - DESIFRAR MENSAGEM");
		DecifraDados.decodificaMensagem(answer);
		LOGGER.info("FINALIZANDOO PROCESSO - DESIFRAR MENSAGEM");
		
		LOGGER.info("================================================");
		
		LOGGER.info("INICIADO PROCESSO - SALVAR MENSAGEM");
		ManipulaArquivo.atualizaArquivo(answer);
		LOGGER.info("FINALIZANDOO PROCESSO - SALVAR MENSAGEM");
		
		LOGGER.info("================================================");
		
		LOGGER.info("INICIADO PROCESSO - POST MENSAGEM");
		IntegracaoExterna.sendPost();
		LOGGER.info("FINALIZANDOO PROCESSO - POST MENSAGEM");
	}
}
