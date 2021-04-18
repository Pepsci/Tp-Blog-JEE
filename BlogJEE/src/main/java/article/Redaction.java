package article;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Article;
import bean.User;
import dao.ArticleDao;

/**
 * Servlet implementation class Redaction
 */
@WebServlet("/redaction")
public class Redaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Redaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/menu/Redaction.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String titre_saisie = request.getParameter("titre");
		String resume_saisie = request.getParameter("resume");
		String contenu_saisie = request.getParameter("contenu");
		String auteur = (String) request.getSession().getAttribute("utilisateur");
		
		Article article = new Article(titre_saisie,resume_saisie,contenu_saisie,auteur, auteur);
		
		ArticleDao arDao = new ArticleDao();
		
		
		if(arDao.create(article)) {
			request.setAttribute("article", "Féliciation l'article "+ titre_saisie +" a été bien ajouté");
			request.getRequestDispatcher("/menu/Redaction.jsp").forward(request, response);

		}else {
			request.setAttribute("article", "Oups, erreur lors de l'ajout");
		}
		
		request.getRequestDispatcher("/menu/Redaction.jsp").forward(request, response);
		
	}

}
