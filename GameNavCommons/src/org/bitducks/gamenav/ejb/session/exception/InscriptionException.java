
package org.bitducks.gamenav.ejb.session.exception;

import org.bitducks.gamenav.ejb.session.exception.base.GameNavError;
import org.bitducks.gamenav.ejb.session.exception.base.GameNavException;

public class InscriptionException extends GameNavException {

	private static final long	serialVersionUID	= 1L;

	public InscriptionException() {

		super();
	}

	public InscriptionException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {

		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InscriptionException(String message, Throwable cause) {

		super(message, cause);
	}

	public InscriptionException(String message) {

		super(message);
	}

	public InscriptionException(Throwable cause) {

		super(cause);
	}

	public InscriptionException(GameNavError error) {

		super(error);
	}
}
