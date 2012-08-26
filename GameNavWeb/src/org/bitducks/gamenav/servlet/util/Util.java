
package org.bitducks.gamenav.servlet.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.bitducks.gamenav.ejb.session.exception.base.GameNavError;
import org.bitducks.gamenav.ejb.session.exception.base.GameNavException;

public class Util {

	public static void manageException(GameNavException e,
			HttpServletRequest request) {

		Map<String, String> erreurs = new HashMap<String, String>();
		request.setAttribute("errors", erreurs);
		for (GameNavError error : e.getErrors()) {
			String[] split = error.getErrorCode().split("[.]");
			if (split.length > 2) {
				erreurs.put(split[2], error.getErrorCode());
			}
		}
	}
}
