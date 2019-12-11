package java_20191210.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java_20191210.dto.SalGradeDto;

public class SalGradeDao {
	static{
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static SalGradeDao single;
	private SalGradeDao(){
		
	}
	public static SalGradeDao getInstance(){
		if(single == null){
			single = new SalGradeDao();
		}
		return single;
	}
	
	public boolean insesrt(SalGradeDto dto){
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/acorn?autoReconnect=true","acorn13","acorn13");
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO ");
			sql.append("salGrade(grade, losal, hisal) ");
			sql.append("VALUES( ?,?,?)");
			
			pstmt = con.prepareStatement(sql.toString());
			
			int index = 0;
			pstmt.setInt(++index, dto.getGrade());
			pstmt.setInt(++index, dto.getLosal());
			pstmt.setInt(++index, dto.getHisal());
			
			pstmt.executeUpdate();
			
			isSuccess = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
				try {
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return isSuccess;
	}
	public boolean update(SalGradeDto dto){
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/acorn?autoReconnect=true","acorn13","acorn13");
			
			StringBuffer sql = new StringBuffer();
			sql.append("update salgrade ");
			sql.append("set losal = ?, hisal = ? ");
			sql.append("where grade = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			int index =0;
			pstmt.setInt(++index, dto.getLosal());
			pstmt.setInt(++index, dto.getHisal());
			pstmt.setInt(++index, dto.getGrade());
			
			pstmt.executeUpdate();
			isSuccess = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
				try {
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return isSuccess;
	}
	public boolean delete(int grade){
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/acorn?autoReconnect=true","acron13","acorn13");
			StringBuffer sql = new StringBuffer();
			sql.append("delete ");
			sql.append("from salGrade ");
			sql.append("where grade = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setInt(++index, grade);
			
			pstmt.executeUpdate();
			isSuccess = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
				try {
					if(pstmt !=null) pstmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return isSuccess;
	}
	public ArrayList<SalGradeDto> select(){
		ArrayList<SalGradeDto> list = new ArrayList<SalGradeDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/acorn?autoReconnect=true","acorn13","acorn13");
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT grade, losal, hisal ");
			sql.append("FROM salgrade ");
			sql.append("ORDER BY grade");
			
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				int index = 0;
				int grade = rs.getInt(++index);
				int losal = rs.getInt(++index);
				int hisal = rs.getInt(++index);
				list.add(new SalGradeDto(grade, losal, hisal));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return list;
	}
	public SalGradeDto selcet(int Grade){
		SalGradeDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/acorn?autoReconnect=true","acorn13","acorn13");
			
			StringBuffer sql = new StringBuffer();
			sql.append("Select grade, losal, hisal ");
			sql.append("from salGrade ");
			sql.append("where grade = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			
			int index = 0;
			pstmt.setInt(++index, Grade);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				index = 0;
				int grade = rs.getInt(++index);
				int losal = rs.getInt(++index);
				int hisal = rs.getInt(++index);
				dto = new SalGradeDto(grade,losal,hisal);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return dto;
		
	}
	
	
}
