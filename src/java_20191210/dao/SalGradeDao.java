package java_20191210.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	public boolean update(){
		boolean isSuccess = false;
		return isSuccess;
	}
	public boolean delete(){
		boolean isSuccess = false;
		return isSuccess;
	}
	public ArrayList<SalGradeDto> select(){
		ArrayList<SalGradeDto> list = new ArrayList<SalGradeDto>();
		return list;
	}
	public SalGradeDto selcet(int Grade){
		SalGradeDto dto = null;
		return dto;
		
	}
	
	
}
