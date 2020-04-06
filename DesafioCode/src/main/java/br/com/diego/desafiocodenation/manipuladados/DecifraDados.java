package br.com.diego.desafiocodenation.manipuladados;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import br.com.diego.desafiocodenation.model.Answer;

/**
 * @author dcandido
 * @since 04/04/2020
 *
 * Classe responsável por Decifrar os Dados
 *
 */
public class DecifraDados {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DecifraDados.class);
	private static final char [] ALFABETO = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	
	/**
	 * Referência: https://pt.wikipedia.org/wiki/Cifra_de_C%C3%A9sar
	 * 
	 * Decodifica mensagem Cifra de Cesar.
	 * 
	 * A ideia do algoritmo é simplesmente a substuição da letra por outra
	 * a partir de um "índice" que é fornecido junto a palava que será decodificada
	 *
	 * @param answer the answer
	 * @return the answer
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	public static void decodificaMensagem(Answer answer) throws NoSuchAlgorithmException, UnsupportedEncodingException  {
		LOGGER.info("INICIANDO DECODIFICAÇÃO");
		
//		int caracterCrip = 0;
		char caracterDCrip = 0;
		String texto = "";
		
		for(int i =0; i < answer.getCifrado().length(); i++) {
			caracterDCrip = get(answer.getNumeroCasas(), (char)answer.getCifrado().charAt(i));
//			caracterCrip = answer.getCifrado().charAt(i);			
//			LOGGER.info("Crip : %s, DCrip: %s\n", (char)caracterCrip, caracterDCrip);
			texto += caracterDCrip;
		}
		answer.setDecifrado(texto);
		answer.setResumoCriptografico(gerarSha1(texto));
        LOGGER.info("DeCodificado: %s\n", answer.getDecifrado());
        LOGGER.info("FINALIZANDO DECODIFICAÇÃO");
	}
	
	/**
	 * Verifica a Posição em que a Letra se encontra no Alfabeto
	 *
	 * @param indice the indice
	 * @param charAt the char at
	 * @return the char
	 */
	private static char get(int indice, char charAt) {
		if(Character.isAlphabetic(charAt)) {
			int pos = 0;
			for(int i=0; i < ALFABETO.length; i++) {
				if( ALFABETO[i] == charAt) {
					pos = i;	
					break;
				}
			}
			while(indice > 0) {
				if(pos == 0)
					pos = ALFABETO.length;
				pos--;
				indice--;
			}
			return ALFABETO[pos];
		}
		return charAt;
	}
	
	/**
	 * Gerar sha 1.
	 *
	 * @param mensagem the mensagem
	 * @return the string
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	private static String gerarSha1(String mensagem) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.reset();
        digest.update(mensagem.getBytes("utf8"));
        String sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
        return sha1;

	}
	
	public static Answer obterDados(Answer answer, String response) {
		LOGGER.info("INICIANDO - OBTER DADOS");
		Gson gson = new Gson();
		answer = gson.fromJson(response, Answer.class);
		LOGGER.info("Answer : %s\n", answer.toString());
		LOGGER.info("FINALIZANDO - OBTER DADOS");
		return answer;
	}
}
