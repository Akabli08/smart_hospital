package consultation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ConsultationDaoImpl;
import dao.RendezVousDaoImpl;
import entities.Consultation;
import entities.RendezVous;
import entities.Utilisateur;

@WebServlet(urlPatterns = "/consultation")
public class ConsultationServlet extends HttpServlet{
	
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		ConsultationDaoImpl daoImpl = new ConsultationDaoImpl();
		ArrayList<Consultation> consultations = daoImpl.getAll();
		req.setAttribute("consultations", consultations);
		this.getServletContext().getRequestDispatcher("/WEB-INF/consultation/consultation.jsp").forward(req, resp);
	}
}
