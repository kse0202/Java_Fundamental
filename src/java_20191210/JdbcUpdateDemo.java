package java_20191210;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUpdateDemo {

	public static void main(String[] args) {
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/acorn?autoReconnect=true"
					, "acorn13"
					, "acorn13");
			
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE dept SET dname = ?, loc = ? WHERE deptno = ?");
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1, "MINING");
			pstmt.setString(2, "SILICONVALLEY");
			pstmt.setInt(3, 60);
			
			int result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				

	}

}
