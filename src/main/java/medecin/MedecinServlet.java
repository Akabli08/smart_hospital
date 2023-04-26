package medecin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UtilisateurDaoImpl;
import entities.Utilisateur;

@WebServlet(urlPatterns = "/medecin")
public class MedecinServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UtilisateurDaoImpl daoImpl = new UtilisateurDaoImpl();
		ArrayList<Utilisateur> medecins = daoImpl.getAllMedecins();
		req.setAttribute("medecins", medecins);
		this.getServletContext().getRequestDispatcher("/WEB-INF/medecin/medecin.jsp").forward(req, resp);
	}
	
	
}
