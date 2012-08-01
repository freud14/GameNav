import java.io.IOException;
import java.util.Arrays;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bitducks.gamenav.ejb.session.entityutil.JoueurService;
import org.bitducks.gamenav.ejb.session.entityutil.UniversService;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

	private static final long	serialVersionUID	= 1L;

	@EJB
	private UniversService		universService;

	@EJB
	private JoueurService		joueurService;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().println(this.universService.getAllUnivers());

		Object[] joueur = this.joueurService.getJoueur(1, "bob", "salut");
		response.getWriter().println(Arrays.toString(joueur));
		
		joueur = this.joueurService.getJoueur(2, "fredy", "123");
		response.getWriter().println(Arrays.toString(joueur));
	}

}
