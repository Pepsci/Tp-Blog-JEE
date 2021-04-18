package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/formulaire/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email_saisie = request.getParameter("email");
		String pwd_saisie = request.getParameter("password");
		
		UserDao usDao = new UserDao();
		System.out.println(pwd_saisie);
		
		if (usDao.login(email_saisie, pwd_saisie) != null) {
			
			String prenom = usDao.login(email_saisie, pwd_saisie).getPrenom();
			String nom = usDao.login(email_saisie, pwd_saisie).getNom();
			
			System.out.println("laaaaaaaaaaaaaaa");
			HttpSession session = request.getSession();
			session.setAttribute("utilisateur", prenom+" "+nom);
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else {
			System.out.println("else");
			request.getRequestDispatcher("/formulaire/login.jsp").forward(request, response);
		}
	}

}

