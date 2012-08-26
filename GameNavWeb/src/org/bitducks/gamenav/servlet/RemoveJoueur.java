
package org.bitducks.gamenav.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bitducks.gamenav.ejb.session.InscriptionService;

/**
 * Servlet implementation class RemoveJoueur
 */
@WebServlet("/RemoveJoueur")
public class RemoveJoueur extends HttpServlet {

	private static final long	serialVersionUID	= 1L;

	@EJB
	private InscriptionService	inscriptionService;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("id") != null) {
			try {
				this.inscriptionService.removeInscription(Integer.parseInt(request.getParameter("id")));
				response.getWriter().println("OK");
			} catch (Exception e) {
				response.getWriter().println("Erreur pendant la suppression.");
			}
		} else {
			response.getWriter().println("Aucun id n'a été passé à la page.");
		}
	}

}
