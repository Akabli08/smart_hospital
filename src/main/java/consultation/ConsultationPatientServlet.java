package consultation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConsultationDaoImpl;
import dao.PatientDaoImpl;
import entities.Consultation;
import entities.Patient;

@WebServlet(urlPatterns = "/consultationpatient")
public class ConsultationPatientServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ConsultationDaoImpl daoImpl = new ConsultationDaoImpl();
		PatientDaoImpl daoImpl2 = new PatientDaoImpl();
		int id = Integer.parseInt(req.getParameter("id"));
		Patient patient = daoImpl2.findById(Integer.parseInt(req.getParameter("id")));
		ArrayList<Consultation> consultations = daoImpl.findByPatientId(id);
		req.setAttribute("consultations", consultations);
		req.setAttribute("patient", patient);
		this.getServletContext().getRequestDispatcher("/WEB-INF/consultation/patientconsultation.jsp").forward(req, resp);
	}
}
