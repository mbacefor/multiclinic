/**
 * 
 */
package br.com.linkedmed.util;

/**
 * @author mbacefor
 * 
 */
public class ErrorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorException(String mensagem) {
		super(mensagem);
	}

	public ErrorException(Exception exception) {
		super(exception);
	}

}
