package memo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class memoDAO {
	static final String URL =  "jdbc:mysql://localhost/memo?useSSL=false";
	static final String USER = "java";
	static final String PASS = "pass";

	public ArrayList<memo> findAll(){
		ArrayList<memo> mlist =new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection(URL,USER,PASS);
			String sql = "select * from memo";
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int mid = rs.getInt("mid");
				String title  = rs.getString("title");
				String body = rs.getString("body");

				memo m=new memo(mid,title,body);
				mlist.add(m);
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {

			System.out.println("findAllエラー"+e.getMessage());
		}
		return mlist;

	}

	public memo findByMid(int mid) {

		memo m1=null;
		try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

			String sql = "SELECT * FROM memo WHERE mid=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, mid);

			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				String  title = rs.getString("title");
				String body = rs.getString("body");

				 m1=new memo(mid,title,body);

			}

			stmt.close();

		} catch (SQLException e) {
			System.out.println("findByMidエラー:" + e.getMessage());
		}
		return m1;
	}





}
