package java_20191210;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDeleteDemo {

	public static void main(String[] args) {
		
		//1. 드라이버 로드한다. 
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {
			//2. 데이터 베이스와 연결
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/acorn?autoReconnect=true",
					"acorn13",
					"acorn13");
			//3. PrepareStatement 객체를 생설
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE ");
			sql.append("from dept ");
			sql.append("WHERE deptno = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			
			//4. 바인딩 변수를 설정한다.
			pstmt.setInt(1, 60);
			
			//5. SQL문을 전송한다.
			int result = pstmt.executeUpdate();
			System.out.println("갱신된 행의 수 : " +result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6. 닫는다.
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		

	}

}
