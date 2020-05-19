package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class shouhinDAO {
	static final String URL =  "jdbc:mysql://localhost/hanbai?useSSL=false";
	static final String USER = "java";
	static final String PASS = "pass";

	public  void update(shouhin s) {
		try(Connection con = DriverManager.getConnection(URL,USER,PASS)){

			String sql = "UPDATE shouhin SET sname=?,tanka=? WHERE sid=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,s.getSname());
			stmt.setInt(2,s.getTanka());
			stmt.setInt(3,s.getSid());

			stmt.executeUpdate();

			stmt.close();
		}catch (SQLException e) {
			System.out.println("updateエラー：" + e.getMessage());
		}
}


	public  void insert(shouhin s) {

		try(Connection con = DriverManager.getConnection(URL,USER,PASS)){

			String sql = "INSERT INTO shouhin (sname,tanka) VALUES(?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,s.getSname());
			stmt.setInt(2,s.getTanka());
			stmt.executeUpdate();

			stmt.close();

		}catch (SQLException e) {
			System.out.println("INSERTエラー：" + e.getMessage());
		}
	}
	public  shouhin findBysid(int sid) {
		shouhin s=null;
		try {
			Connection con = DriverManager.getConnection(URL,USER,PASS);
			String sql = "select * from shouhin where sid=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, sid);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String sname = rs.getString("sname");
				int tanka = rs.getInt("tanka");
				s= new shouhin(sid,sname,tanka);
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {

			System.out.println("findBysidエラー"+e.getMessage());
		}
		return s;
	}


	public ArrayList<shouhin> findAll() {
		ArrayList<shouhin> slist = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

			String sql = "SELECT * FROM shouhin";
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				int sid = rs.getInt("sid");
				String sname = rs.getString("sname");
				int tanka = rs.getInt("tanka");

				shouhin s = new shouhin(sid,sname,tanka);
				slist.add(s);
			}

			stmt.close();

		} catch (SQLException e) {
			System.out.println("findAllエラー:" + e.getMessage());
		}
		return slist;
	}

	public void delete(int sid) {
		try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

			String sql = "delete FROM shouhin where sid =?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, sid);
			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			System.out.println("deleteエラー:" + e.getMessage());
		}


	}


}
