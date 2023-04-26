package patient;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PatientDaoImpl;
import entities.Patient;

@WebServlet(urlPatterns = "/patient")
public class PatientServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PatientDaoImpl daoImpl = new PatientDaoImpl();
		ArrayList<Patient> patients = daoImpl.getAll();
		req.setAttribute("patients", patients);
		this.getServletContext().getRequestDispatcher("/WEB-INF/patient/patient.jsp").forward(req, resp);
	}
}
