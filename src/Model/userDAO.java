package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDAO {
	static final String URL =  "jdbc:mysql://localhost/hanbai?useSSL=false";
	static final String USER = "java";
	static final String PASS = "pass";

	public  user login(String uname,String pass) {
		user u =null;
		try {
			Connection con = DriverManager.getConnection(URL,USER,PASS);
			String sql = "select * from user where uname=? and pass=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, uname);
			stmt.setString(2, pass);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {

				int uid = rs.getInt("uid");
				String mail= rs.getString("mail");
				u= new user(uid,uname,pass,mail );
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {

			System.out.println("loginエラー"+e.getMessage());
		}
		return u;
	}
}
