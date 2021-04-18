package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Article;

public class ArticleDao implements IDAO<Article>{
	
	Connection connect = Connect.getConnection();


	@Override
	public boolean create(Article object) {
		boolean message = false;
		try {
			
			PreparedStatement req = connect.prepareStatement("INSERT INTO article (titre, resume, contenu, created_at, auteur)"
			+" VALUES (?,?,?,now(),?)");
			
			req.setString(1, object.getTitre());
			req.setString(2, object.getResume());
			req.setString(3, object.getContenu());
			req.setString(4, object.getAuteur());
			
			req.executeUpdate();
			message = true;
			System.out.println("Insertion OK");
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
			
		}
		return message;
	}


	@Override
	public List<Article> read() {
		List<Article> listArticles = new ArrayList<>();
		
		try {
			
			PreparedStatement req = connect.prepareStatement("SELECT * FROM article");
			
			ResultSet rs = req.executeQuery();
			
			while (rs.next()) {
				
				Article art = new Article();
				
				art.setId(rs.getInt("id"));
				art.setTitre(rs.getString("titre"));
				art.setContenu(rs.getString("contenu"));
				art.setResume(rs.getString("resume"));
				
				
				listArticles.add(art);
			}
			System.out.println(listArticles);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		return listArticles;
	}
}