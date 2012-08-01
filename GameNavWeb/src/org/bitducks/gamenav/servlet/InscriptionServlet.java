
package org.bitducks.gamenav.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bitducks.gamenav.dtp.InscriptionDTP;
import org.bitducks.gamenav.ejb.session.InscriptionService;
import org.bitducks.gamenav.ejb.session.entityutil.UniversService;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {

	private static final long	serialVersionUID	= 1L;

	@EJB
	private UniversService		universService;

	@EJB
	private InscriptionService	inscriptionService;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.inscriptionService.test();

		request.setAttribute("univers", this.universService.getAllUnivers());
		this.getServletContext().getRequestDispatcher("/inscription.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("joueur_email");
		String login = request.getParameter("joueur_login");
		String password = request.getParameter("joueur_password");
		String univers = request.getParameter("joueur_univers");
		String planete = request.getParameter("joueur_planete");

		validateParameter(email, login, password, univers, planete);

		InscriptionDTP dtp = new InscriptionDTP();
		dtp.email = email;
		dtp.login = login;
		dtp.password = password;
		dtp.idUnivers = Integer.parseInt(univers);
		dtp.planete = planete;

		this.inscriptionService.inscription(dtp);
	}

	private static void validateParameter(String email, String login,
			String password, String univers, String planete) {

		if (login == null) {
			throw new RuntimeException("Le nom d'utilisateur est absent.");
		}

		if (password == null) {
			throw new RuntimeException("Le mot de passe est absent.");
		}

		if (email == null) {
			throw new RuntimeException("L'adresse courriel est absente.");
		}

		if (univers == null) {
			throw new RuntimeException("L'univers est absent.");
		}

		try {
			Integer.parseInt(univers);
		} catch (NumberFormatException e) {
			throw new RuntimeException("L'univers n'a pas le bon format.");
		}

		if (planete == null) {
			throw new RuntimeException("Le nom de la planète mère est absent.");
		}
	}

}
