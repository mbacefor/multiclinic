/**
 * 
 */
package br.med.multiclinic.util;

/**
 * @author mbacefor
 * 
 */
public class WarnException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WarnException(String mensagem) {
		super(mensagem);
	}
	
	public WarnException(Exception exception) {
		super(exception);
	}

}
