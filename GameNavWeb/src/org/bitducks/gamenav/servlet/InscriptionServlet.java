
package org.bitducks.gamenav.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bitducks.gamenav.dto.InscriptionJoueurDTO;
import org.bitducks.gamenav.dtp.InscriptionFormDTP;
import org.bitducks.gamenav.dtp.InscriptionJoueurDTP;
import org.bitducks.gamenav.ejb.session.InscriptionService;
import org.bitducks.gamenav.servlet.util.TilesUtil;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {

	private static final long	serialVersionUID	= 1L;

	@EJB
	private InscriptionService	inscriptionService;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute(
				"univers",
				this.inscriptionService.getInscriptionFormDTO(new InscriptionFormDTP()).universList);
		TilesUtil.render("inscription", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Map<String, String> param = getParameterMap(request.getParameterMap());
		InscriptionJoueurDTP inscriptionDTP = getInscriptionDTP(param);

		InscriptionJoueurDTO dto = this.inscriptionService.inscriptionJoueur(inscriptionDTP);
		response.getWriter().println(dto);
	}

	private static InscriptionJoueurDTP getInscriptionDTP(
			Map<String, String> parameterMap) {

		InscriptionJoueurDTP dtp = new InscriptionJoueurDTP();

		dtp.email = parameterMap.get("joueur_email");
		dtp.login = parameterMap.get("joueur_login");
		dtp.password = parameterMap.get("joueur_password");
		String passwordConfirmation = parameterMap.get("joueur_password_confirmation");
		String univers = parameterMap.get("joueur_univers");
		dtp.nomPlanete = parameterMap.get("joueur_planete");

		if (dtp.login == null) {
			throw new RuntimeException("Le nom d'utilisateur est absent.");
		}

		if (dtp.password == null) {
			throw new RuntimeException("Le mot de passe est absent.");
		}

		if (!dtp.password.equals(passwordConfirmation)) {
			throw new RuntimeException(
					"Le mot de passe saisi et la confirmation du mot de passe ne concorde pas.");
		}

		if (dtp.email == null) {
			throw new RuntimeException("L'adresse courriel est absente.");
		}

		if (univers == null) {
			throw new RuntimeException("L'univers est absent.");
		}

		try {
			dtp.idUnivers = Integer.parseInt(univers);
		} catch (NumberFormatException e) {
			throw new RuntimeException("L'univers n'a pas le bon format.");
		}

		if (dtp.nomPlanete == null) {
			throw new RuntimeException("Le nom de la planète mère est absent.");
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
