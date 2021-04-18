package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCrypt;

import bean.User;
import dao.UserDao;

/**
 * Servlet implementation class CreationCompte
 */
@WebServlet("/inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/formulaire/inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom_saisie = request.getParameter("nom");
		String prenom_saisie = request.getParameter("prenom");
		String email_saisie = request.getParameter("email");
		String password_saisie = request.getParameter("password");
		
		String hashPasword = BCrypt.hashpw(password_saisie, BCrypt.gensalt(12));
		
		User user1 = new User(nom_saisie, prenom_saisie,email_saisie,hashPasword);
		
		UserDao usDao = new UserDao();
		
		if(usDao.create(user1)) {
			request.setAttribute("message", "Féliciation l'utlisateur "+prenom_saisie+ " "+nom_saisie+ "a été bien ajouté");
		}else {
			request.setAttribute("message", "Oups, erreur lors de la création de compte");
		}
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

}
