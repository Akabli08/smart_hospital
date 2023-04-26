package patient;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PatientDaoImpl;
import entities.Patient;

@WebServlet(urlPatterns = "/addpatient")
public class AddPatientServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/patient/addpatient.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean champVide = false;
	    // On récupère tous les noms des paramètres envoyés par le formulaire
	    Enumeration<String> nomsParametres = req.getParameterNames();
		while(nomsParametres.hasMoreElements()) {
	        String nomParametre = nomsParametres.nextElement();
	        String valeurParametre = req.getParameter(nomParametre);
	        if(valeurParametre.isEmpty()) {
	            champVide = true;
	            break;
	        }
		}
		if(champVide) {
	        req.setAttribute("erreur", true);
	        req.getRequestDispatcher("/WEB-INF/patient/addpatient.jsp").forward(req, resp);
	    } else {
	    	String date = req.getParameter("dateNaissance").replaceAll("[^0-9]", "");
	        PatientDaoImpl daoImpl = new PatientDaoImpl();
	        Patient patient = new Patient(req.getParameter("nom"), req.getParameter("prenom"),
						        		req.getParameter("sexe"), new Date(Long.parseLong(date)),
						        		req.getParameter("email"),req.getParameter("telephone"),
						        		req.getParameter("etatCevil"),req.getParameter("proffesion"),
						        		req.getParameter("adresse"),req.getParameter("ville"),
						        		req.getParameter("groupeSanguin"));
	        daoImpl.save(patient);
	        req.setAttribute("succes", true);
	        req.getRequestDispatcher("/WEB-INF/patient/addpatient.jsp").forward(req, resp);
	    }
	}
}
