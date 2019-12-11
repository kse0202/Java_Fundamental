package java_20191211;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java_20191210.dto.DeptDto;

public class DeptDao {
	static{ //스태틱 초기화... 
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}

	//1. singleton pattern 
	//single변수는 static 메서드에서 사용해야 하기 때문에 static변수로 설정해야 한다.
	private static DeptDao single;
	//외부에서 객체를 생성할 수 없다.
	private DeptDao(){
		
	}
	//외부에서 DeptDao 객체를 생성하기 위해서는 getInstantce()메서드를 이용해야한다. 
	//따라서 이 메서드에서는 DeptDao객체를 하나만 생성할 수 있게 코딩해야 한다. singleton.
	
	public static DeptDao getInstance(){
		if(single == null){
			single = new DeptDao();
		}
		return single;
	}
	
	
	public boolean insert(DeptDto dto){
			boolean isSuccess = false;
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3307/acorn?autoReconnect=true",
						"acorn13",
						"acorn13");
				
				StringBuffer sql = new StringBuffer();
				sql.append("INSERT INTO dept(deptno, dname, loc) VALUES(?, ?, ?)");
			
				pstmt = con.prepareStatement(sql.toString());
			
				int index = 0;
				pstmt.setInt(++index, dto.getNo());
				pstmt.setString(++index, dto.getName());
				pstmt.setString(++index, dto.getLoc() );
				
				int result = pstmt.executeUpdate();
			
				isSuccess = true;
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally{
			
				try {
					if (pstmt != null)
						pstmt.close();
					if (con != null)
						con.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			}
		return isSuccess;
	}
	
	public boolean update(DeptDto dto){
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/acorn?autoReconnect=true"
					, "acorn13"
					, "acorn13");
			
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE dept SET dname = ?, loc = ? WHERE deptno = ?");
			pstmt = con.prepareStatement(sql.toString());
			
			int index = 0;
			pstmt.setString(++index, dto.getName());
			pstmt.setString(++index, dto.getLoc());
			pstmt.setInt(++index, dto.getNo());
			
			int result = pstmt.executeUpdate();
			isSuccess = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		
		return isSuccess;

	}
	
	public boolean delete(int deptno){
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/acorn?autoReconnect=true",
					"acorn13",
					"acorn13");
	
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE ");
			sql.append("from dept ");
			sql.append("WHERE deptno = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			
		
			pstmt.setInt(1, deptno);
			
	
			int result = pstmt.executeUpdate();
			isSuccess = true;
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isSuccess;
	}
	
	public ArrayList<DeptDto> select(){
		ArrayList<DeptDto> list = new ArrayList<DeptDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/acorn?autoReconnect=true",
					"acorn13","acorn13");
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT deptno, dname, loc ");
			sql.append("FROM dept ");
			sql.append("ORDER BY deptno");
			
			pstmt = con.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery(); 
			
			while(rs.next()){
				//int index = 0;
				//rs.getInt(++index) ?��?���? ?���? ?��?��??�? ?�� 출력?�� ?�� ?��?��. 
				int deptno = rs.getInt(1);
				String dname = rs.getString(2);
				String loc = rs.getString(3);
				list.add(new DeptDto(deptno,dname,loc));
				
			}
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally{
			
				try {
					if(rs != null) rs.close();
					if(pstmt != null) rs.close();
					if(con != null) rs.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			
		}
		return list;
		
	}
	public DeptDto select(int deptNo){
		DeptDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/acorn?autoReconnect=true",
					"acorn13","acorn13");
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT deptno, dname, loc ");
			sql.append("FROM dept ");
			sql.append("WHERE deptno = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			
			int index = 0;
			pstmt.setInt(++index, deptNo);
			rs = pstmt.executeQuery(); 
			
			if(rs.next()){
				index = 0;
				int deptno = rs.getInt(++index);
				String dname = rs.getString(++index);
				String loc = rs.getString(++index);
				dto = new DeptDto(deptno,dname,loc);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
				try {
					if(rs != null) rs.close();
					if(pstmt != null) rs.close();
					if(con != null) rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return dto;
	}

}
