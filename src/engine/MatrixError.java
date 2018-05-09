/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

/**
 *
 * @author Ermengarde
 */
public class MatrixError extends RuntimeException {

	/**
	 * Serial id for this class.
	 */
	private static final long serialVersionUID = -8961386981267748942L;

	/**
	 * Construct this exception with a message.
	 * @param t The other exception.
	 */
	public MatrixError(final String message) {
		super(message);
	}

	/**
	 * Construct this exception with another exception.
	 * @param t The other exception.
	 */
	public MatrixError(final Throwable t) {
		super(t);
	}

}