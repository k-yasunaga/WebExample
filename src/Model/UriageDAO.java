package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UriageDAO {
	static final String URL =  "jdbc:mysql://localhost/hanbai?useSSL=false";
	static final String USER = "java";
	static final String PASS = "pass";

	public  uriage findByUid(int Uid) {
		uriage u=null;
		try {
			Connection con = DriverManager.getConnection(URL,USER,PASS);
			String sql = "select * from uriage where uid=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, Uid);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int sid  = rs.getInt("sid");
				int kosu = rs.getInt("kosu");
				Date hi= rs.getDate("hi");
				u= new uriage(Uid,sid,kosu,hi);
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {

			System.out.println("findBysidエラー"+e.getMessage());
		}
		return u;
	}

	public  ArrayList<uriage> findAll() {
		ArrayList<uriage> slist =new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection(URL,USER,PASS);
			String sql = "select * from uriage";
			PreparedStatement stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int uid = rs.getInt("uid");
				int sid = rs.getInt("sid");
				int kosu = rs.getInt("kosu");
				Date hi =rs.getDate("hi");
				uriage u =new uriage(uid,sid,kosu,hi);
				slist.add(u);
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {

			System.out.println("findAllエラー"+e.getMessage());
		}
		return slist;

	}
	public ArrayList<uriage> findBySid(int sid) {
		ArrayList<uriage> slist = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

			String sql = "SELECT * FROM uriage WHERE sid=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, sid);

			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				int uid = rs.getInt("uid");
				int kosu = rs.getInt("kosu");
				Date hi = rs.getDate("hi");

				uriage u = new uriage(uid,sid,kosu,hi);
				slist.add(u);
			}

			stmt.close();

		} catch (SQLException e) {
			System.out.println("findBySidエラー:" + e.getMessage());
		}
		return slist;
	}


	public void delete(int uid) {
		try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

			String sql = "delete FROM uriage where uid =?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, uid);
			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			System.out.println("deleteエラー:" + e.getMessage());
		}


	}

	public  void update(uriage u) {
		try(Connection con = DriverManager.getConnection(URL,USER,PASS)){

			String sql = "UPDATE uriage SET sname=?,tanka=? WHERE uid=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,u.getSid());
			stmt.setInt(2,u.getKosu());
			stmt.setDate(3,u.getHi());
			stmt.setInt(4,u.getUid());
			stmt.executeUpdate();

			stmt.close();
		}catch (SQLException e) {
			System.out.println("updateエラー：" + e.getMessage());
		}
}
	public  void insert(uriage u) {

		try(Connection con = DriverManager.getConnection(URL,USER,PASS)){

			String sql = "INSERT INTO uriage (sid,kosu,hi) VALUES(?,?,curdate())";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,u.getSid());
			stmt.setInt(2,u.getKosu());

			stmt.executeUpdate();

			stmt.close();

		}catch (SQLException e) {
			System.out.println("INSERTエラー：" + e.getMessage());
		}
	}
}
