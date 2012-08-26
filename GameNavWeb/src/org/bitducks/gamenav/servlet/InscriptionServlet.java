
package org.bitducks.gamenav.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.EJB;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bitducks.gamenav.dtp.InscriptionFormDTP;
import org.bitducks.gamenav.dtp.InscriptionJoueurDTP;
import org.bitducks.gamenav.ejb.session.InscriptionService;
import org.bitducks.gamenav.ejb.session.exception.InscriptionErrorCode;
import org.bitducks.gamenav.ejb.session.exception.InscriptionException;
import org.bitducks.gamenav.ejb.session.exception.base.GameNavError;
import org.bitducks.gamenav.servlet.util.TilesUtil;
import org.bitducks.gamenav.servlet.util.Util;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {

	private static final long	serialVersionUID	= 1L;

	private static final String	PAGE				= "inscription";

	private static final String	PAGE_CONFIRMATION	= "inscription_confirmation";

	private static final String	LOGIN_FORM			= "login";

	private static final String	EMAIL_FORM			= "email";

	private static final String	PASSWORD_FORM		= "password";

	private static final String	PASSWORD_CONF_FORM	= "password_confirmation";

	private static final String	UNIVERS_FORM		= "univers";

	private static final String	PLANETE_FORM		= "planete";

	@EJB
	private InscriptionService	inscriptionService;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.renderInscriptionPage(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			Map<String, String> param = InscriptionServlet.getParameterMap(request.getParameterMap());
			InscriptionJoueurDTP inscriptionDTP = InscriptionServlet.getInscriptionDTP(param);

			this.inscriptionService.inscriptionJoueur(inscriptionDTP);
			TilesUtil.render(InscriptionServlet.PAGE_CONFIRMATION, request,
					response);
		} catch (InscriptionException e) {
			Util.manageException(e, request);
			this.renderInscriptionPage(request, response);
		}
	}

	public void renderInscriptionPage(HttpServletRequest request,
			HttpServletResponse response) {

		request.setAttribute(
				"univers",
				this.inscriptionService.getInscriptionFormDTO(new InscriptionFormDTP()).universList);
		TilesUtil.render(InscriptionServlet.PAGE, request, response);
	}

	private static InscriptionJoueurDTP getInscriptionDTP(
			Map<String, String> parameterMap) throws InscriptionException {

		InscriptionJoueurDTP dtp = new InscriptionJoueurDTP();
		InscriptionException ex = new InscriptionException();

		dtp.email = parameterMap.get(InscriptionServlet.EMAIL_FORM);
		dtp.login = parameterMap.get(InscriptionServlet.LOGIN_FORM);
		dtp.password = parameterMap.get(InscriptionServlet.PASSWORD_FORM);
		String passwordConfirmation = parameterMap.get(InscriptionServlet.PASSWORD_CONF_FORM);
		String univers = parameterMap.get(InscriptionServlet.UNIVERS_FORM);
		dtp.nomPlanete = parameterMap.get(InscriptionServlet.PLANETE_FORM);

		if (dtp.login == null || dtp.login.isEmpty()) {
			ex.addError(new GameNavError(InscriptionErrorCode.LOGIN_ABSENT));
		}

		if (dtp.password == null || dtp.password.isEmpty()) {
			ex.addError(new GameNavError(InscriptionErrorCode.PASSWORD_ABSENT));
		} else if (passwordConfirmation == null
				|| passwordConfirmation.isEmpty()) {
			ex.addError(new GameNavError(
					InscriptionErrorCode.PASSWORD_CONFIRMATION_ABSENT));
		} else if (!dtp.password.equals(passwordConfirmation)) {
			ex.addError(new GameNavError(
					InscriptionErrorCode.PASSWORD_CONFIRMATION_CONCORDANCE));
		}

		if (dtp.email == null || dtp.email.isEmpty()) {
			ex.addError(new GameNavError(InscriptionErrorCode.EMAIL_ABSENT));
		} else {
			try {
				InternetAddress emailAddr = new InternetAddress(dtp.email);
				emailAddr.validate();
				if (dtp.email.split("@")[1].split("[.]").length <= 1) {
					throw new AddressException();
				}
			} catch (AddressException ex2) {
				ex.addError(new GameNavError(InscriptionErrorCode.EMAIL_FORMAT));
			}
		}

		if (univers == null || univers.isEmpty()) {
			ex.addError(new GameNavError(InscriptionErrorCode.UNIVERS_ABSENT));
		} else {
			try {
				dtp.idUnivers = Integer.parseInt(univers);
			} catch (NumberFormatException e) {
				ex.addError(new GameNavError(
						InscriptionErrorCode.UNIVERS_FORMAT));
			}
		}

		if (dtp.nomPlanete == null || dtp.nomPlanete.isEmpty()) {
			ex.addError(new GameNavError(InscriptionErrorCode.PLANETE_ABSENT));
		}

		if (ex.getErrors().size() != 0) {
			throw ex;
		}

		return dtp;
	}

	private static Map<String, String> getParameterMap(
			Map<String, String[]> parameterMap) {

		Map<String, String> ret = new HashMap<String, String>();

		for (Entry<String, String[]> entry : parameterMap.entrySet()) {
			if (entry.getValue() != null && entry.getValue().length > 0) {
				ret.put(entry.getKey(), entry.getValue()[0]);
			}
		}

		return ret;
	}

}
