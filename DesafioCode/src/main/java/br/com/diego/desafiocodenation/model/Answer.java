package br.com.diego.desafiocodenation.model;

/**
 * The Class Answer.
 */
public class Answer {
	
	/** The numero casas. */
	private Integer numero_casas;
	
	/** The token. */
	private String token;
	
	/** The cifrado. */
	private String cifrado;
	
	/** The decifrado. */
	private String decifrado;
	
	/** The resumo criptografico. */
	private String resumo_criptografico;
	
	/**
	 * Gets the numero casas.
	 *
	 * @return the numero casas
	 */
	public Integer getNumeroCasas() {
		return numero_casas;
	}
	
	/**
	 * Sets the numero casas.
	 *
	 * @param numeroCasas the new numero casas
	 */
	public void setNumeroCasas(Integer numeroCasas) {
		this.numero_casas = numeroCasas;
	}
	
	/**
	 * Gets the token.
	 *
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	
	/**
	 * Sets the token.
	 *
	 * @param token the new token
	 */
	public void setToken(String token) {
		this.token = token;
	}
	
	/**
	 * Gets the cifrado.
	 *
	 * @return the cifrado
	 */
	public String getCifrado() {
		return cifrado;
	}
	
	/**
	 * Sets the cifrado.
	 *
	 * @param cifrado the new cifrado
	 */
	public void setCifrado(String cifrado) {
		this.cifrado = cifrado;
	}
	
	/**
	 * Gets the decifrado.
	 *
	 * @return the decifrado
	 */
	public String getDecifrado() {
		return decifrado;
	}
	
	/**
	 * Sets the decifrado.
	 *
	 * @param decifrado the new decifrado
	 */
	public void setDecifrado(String decifrado) {
		this.decifrado = decifrado;
	}
	
	/**
	 * Gets the resumo criptografico.
	 *
	 * @return the resumo criptografico
	 */
	public String getResumoCriptografico() {
		return resumo_criptografico;
	}
	
	/**
	 * Sets the resumo criptografico.
	 *
	 * @param resumoCriptografico the new resumo criptografico
	 */
	public void setResumoCriptografico(String resumoCriptografico) {
		this.resumo_criptografico = resumoCriptografico;
	}
	@Override
	public String toString() {
		return "Answer [numeroCasas=" + numero_casas + ", token=" + token + ", cifrado=" + cifrado + ", decifrado="
				+ decifrado + ", resumoCriptografico=" + resumo_criptografico + "]";
	}
	
	
}
