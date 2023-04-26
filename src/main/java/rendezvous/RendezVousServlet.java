package rendezvous;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RendezVousDaoImpl;
import entities.RendezVous;
import entities.Utilisateur;

@WebServlet(urlPatterns = "/rendezvous")
public class RendezVousServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(((Utilisateur)session.getAttribute("utilisateur")).getRole().equals("SECRETAIRE")) {
			RendezVousDaoImpl daoImpl = new RendezVousDaoImpl();
			ArrayList<RendezVous> rendezvous = daoImpl.getAll();
			req.setAttribute("rendezvous", rendezvous);
		}else if(((Utilisateur)session.getAttribute("utilisateur")).getRole().equals("MEDECIN")) {
			RendezVousDaoImpl daoImpl = new RendezVousDaoImpl();
			int id = ((Utilisateur)session.getAttribute("utilisateur")).getIdUtilisateur();
			ArrayList<RendezVous> rendezvous = daoImpl.getRdvByMedecinId(id);
			req.setAttribute("rendezvous", rendezvous);
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/rendezvous/rendezvous.jsp").forward(req, resp);
	}
}
