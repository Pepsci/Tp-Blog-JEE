package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;
import bean.User;

public class UserDao implements IDAO<User> {
	
	Connection connect = Connect.getConnection();
	
	@Override
	public boolean create(User object) {
		boolean message = false;
		try {
			PreparedStatement req = connect.prepareStatement("INSERT INTO user (nom,prenom,email,password)"	
					+ "VALUES (?,?,?,?)");
			
			req.setString(1, object.getNom());
			req.setString(2, object.getPrenom());
			req.setString(3, object.getEmail());
			req.setString(4, object.getPwd());
			
			req.executeUpdate();
			
			System.out.println( object.getPrenom()+ "  " +object.getNom() +" a été bien ajouté en base");
			
			message= true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Insertion KO");
			e.printStackTrace();
		}
		return message;
	}
	
	//La connection 
		public User login(String mail, String pwd) {
			try {
				PreparedStatement req = connect.prepareStatement("SELECT * FROM user WHERE email=?");
				
				req.setString(1, mail);
				
				ResultSet rs = req.executeQuery();
				
				while(rs.next()) {
					//System.out.println(pwd);
					//System.out.println(rs.getString("password"));
					
					
					if (BCrypt.checkpw(pwd, rs.getString("password"))) {
						 return new User(rs.getString("nom"),rs.getString("prenom"),rs.getString("email")
								 ,rs.getString("password"));
					}
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public List<User> read() {
			// TODO Auto-generated method stub
			return null;
		}

}
