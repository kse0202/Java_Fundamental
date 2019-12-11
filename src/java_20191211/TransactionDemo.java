package java_20191211;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDemo {

	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		boolean isSuccess = false;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost:3307/acorn","acorn13","acorn13");
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO dept(deptno, dname, loc) VALUES(60,'aaa','aaa')");
			
			con.setAutoCommit(false);//트랜잭션 시작!!
			pstmt1 = con.prepareStatement(sql.toString());
			pstmt1.executeUpdate();
			
			sql.setLength(0);//편하게 지우는 방법!
			sql.append("INSERT INTO dept(deptno, dname, loc) VALUES(70,'bbb','bbb')");
			pstmt2 = con.prepareStatement(sql.toString());
			pstmt2.executeUpdate();
			
			isSuccess =true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				if(isSuccess){
					con.commit(); //모두 수행
				}else{
					con.rollback(); //모두 수행하지 않음
				}
				
				con.setAutoCommit(true); //connection pool에 반납하기 전에 오토커밋을 트루로 바꿔줘야 함.반드시 !!
				if(pstmt1 != null) pstmt1.close();
				if(pstmt2 != null) pstmt2.close();
				if(con != null) con.close();
			}catch(SQLException e){
				
			}
		}
		

	}

}
