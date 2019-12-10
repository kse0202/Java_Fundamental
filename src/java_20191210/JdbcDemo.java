package java_20191210;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDemo {
	public static void main(String[] args) {
		
		try {
			
			//1. org.mariadb.jdbc.Driver 클래스를 메모리에 로딩한다. Driver가 클래스. 앞은 Package. 회사마다 다르다. 
			//메모리에 로딩한다 => 스태틱 메서드들이 메모리에 올라온다. 
			//레퍼런스 라이브러리에서 확인 할 수 있당!!
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("드라이브 로드 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			//2. 데이터 베이스와 연결을 시도한다.
			//포트번호는 localhost 뒤에다가 :0000 이렇게 붙여준다. 
			//db 주소, user, pw 순서로 입력. autoRaconnect 이건 재연결을 자동으로 해준다. 
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/acorn?autoReconnect=true",
					"acorn13",
					"acorn13");
			
			System.out.println("데이터베이스 연결 성공");
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO dept(deptno, dname, loc) VALUES(?, ?, ?)");
			//3. SQL문을 전송할 수 있는 PreparedStatement 객체를 생성한다.
			pstmt = con.prepareStatement(sql.toString());
			//4. 바인딩 변수 를 설정한다.
			//?에 들어갈 값을 넣는 방법. 자료형에 맞게, 순서에 맞게.... ? = 바인딩 변수, 항상 값, 밸류에만 쓴다. 
			pstmt.setInt(1, 60);
			pstmt.setString(2, "ANAYLSIS");
			pstmt.setString(3, "LA" );
			
			//5.SQL문을 전송한다.
			int result = pstmt.executeUpdate();//insert, update, delete 일때 사용한다. DML일때!!!
			System.out.println("갱신된 행의 수 : " +result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//6. 열었으면 닫아준다. 
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
