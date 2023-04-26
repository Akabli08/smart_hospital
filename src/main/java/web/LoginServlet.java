package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UtilisateurDaoImpl;
import entities.Utilisateur;


@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		if(session.getAttribute("utilisateur") != null) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
		}	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if (req.getParameter("method").equals("connecter")) {
			if(!req.getParameter("email").isBlank() && !req.getParameter("password").isBlank()) {
				String email = req.getParameter("email");
				String password = req.getParameter("password");
				UtilisateurDaoImpl daoImpl = new UtilisateurDaoImpl();
				Utilisateur utilisateur = daoImpl.findByEmailAndPssword(email, password);
				if(daoImpl.findByEmailAndPssword(email, password) != null) {
					HttpSession session = req.getSession();
					int interval = 5 * 60; // 5 minutes en secondes
					session.setMaxInactiveInterval(interval);
					session.setAttribute("utilisateur", daoImpl.findByEmailAndPssword(email, password));
					this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
				}else {
					boolean error = true;
					String errorMessage = "Ce n'existe pas !!";
					req.setAttribute("error", error);
					req.setAttribute("errorMessage", errorMessage);
					this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
				}
			}else {
				boolean error = true;
				String errorMessage = "Merci d'entrer vos cordonnées !!";
				req.setAttribute("error", error);
				req.setAttribute("errorMessage", errorMessage);
				this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
			}
		}else if (req.getParameter("method").equals("deconnecter")) {
			HttpSession session = req.getSession();
			session.invalidate();
			resp.sendRedirect(req.getContextPath() + "/login");
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
		}
	}
}
