package java_20191211.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import java_20191211.dto.EmpDto;

public class EmpDao {
	private static EmpDao single;
	private static String url;
	private static String user;
	private static String password;
	static{
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\acorn\\git\\Java_Fundamental_git\\src\\jdbc.properties");
			Properties prop = new Properties();
			prop.load(fis);
			
			String driver = prop.getProperty("driver"); //static 초기화 영역에서 쓸거라서 지역 변수 가능. 
			url = prop.getProperty("url"); // 밑에 것들은 아래 메서드에서 사용할 거라서 전역변수 설정....
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			
			Class.forName(driver);
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private EmpDao(){}
	public static EmpDao getInstance(){
		if(single ==null){
			single = new EmpDao();
		}
		return single;
	}
	
	public boolean insert(EmpDto dto){
		boolean isSuccess= false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) ");
			sql.append("VALUES(?, ?, ?, ?, CURDATE(), ?, ?, ?)");
	
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setInt(++index, dto.getNo());
			pstmt.setString(++index, dto.getName());
			pstmt.setString(++index, dto.getJob());
			pstmt.setInt(++index, dto.getMgr());
			pstmt.setDouble(++index, dto.getSal());
			pstmt.setDouble(++index, dto.getComm());
			pstmt.setInt(++index, dto.getDeptNo());
			
			pstmt.executeUpdate();
			
			isSuccess = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				close(con,pstmt,null);
			}catch(SQLException e){
				
			}
		}
		
		return isSuccess;
		
	}
	
	public boolean update(EmpDto dto){
		boolean isSuccess= false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE emp ");
			sql.append("SET ename = ?, job = ?, mgr = ?, ");
			sql.append("sal = ?, comm= ?, deptno= ? ");
			sql.append("WHERE empno = ?");
	
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			
			pstmt.setString(++index, dto.getName());
			pstmt.setString(++index, dto.getJob());
			pstmt.setInt(++index, dto.getMgr());
			pstmt.setDouble(++index, dto.getSal());
			pstmt.setDouble(++index, dto.getComm());
			pstmt.setInt(++index, dto.getDeptNo());
			pstmt.setInt(++index, dto.getNo());
			
			pstmt.executeUpdate();
			
			isSuccess = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				close(con,pstmt,null);
			}catch(SQLException e){
				
			}
		}
		return isSuccess;
		
	}
	
	public boolean delete(int no){
		boolean isSuccess= false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE ");
			sql.append("FROM emp ");
			sql.append("WHERE empno = ?; ");
	
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			
			pstmt.setInt(++index, no);
	
			
			pstmt.executeUpdate();
			
			isSuccess = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				close(con,pstmt,null);
			}catch(SQLException e){
				
			}
		}
		return isSuccess;
		
	}
	
	public ArrayList<EmpDto> select(int start, int len){
		ArrayList<EmpDto> list = new ArrayList<EmpDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT empno, ename, job, mgr, DATE_FORMAT(hiredate,'%Y/%m/%d'), sal, comm, deptno ");
			sql.append("FROM emp ");
			sql.append("ORDER BY hiredate DESC ");
			sql.append("LIMIT ?,? ");
			
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setInt(++index, start);
			pstmt.setInt(++index, len);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				index = 0;
				int no = rs.getInt(++index);
				String name = rs.getString(++index);
				String job = rs.getString(++index);
				int mgr = rs.getInt(++index);
				String hiredate = rs.getString(++index);
				double sal = rs.getDouble(++index);
				double comm = rs.getDouble(++index);
				int deptNo = rs.getInt(++index);
				list.add(new EmpDto(no,name,job,mgr,hiredate,sal,comm,deptNo));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				close(con, pstmt, rs);
			}catch(SQLException e){
				
			}
		}
		
		return list;
	}
	private void close(Connection con, PreparedStatement pstmt, ResultSet rs)
			throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(con != null) con.close();
	}
	
	public EmpDto select(int no){
		EmpDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT empno, ename, job, mgr, DATE_FORMAT(hiredate,'%Y/%m/%d'), sal, comm, deptno ");
			sql.append("FROM emp ");
			sql.append("where empno = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setInt(++index, no);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				index = 0;
				no = rs.getInt(++index);
				String name = rs.getString(++index);
				String job = rs.getString(++index);
				int mgr = rs.getInt(++index);
				String hiredate = rs.getString(++index);
				double sal = rs.getDouble(++index);
				double comm = rs.getDouble(++index);
				int deptNo = rs.getInt(++index);
				dto = new EmpDto(no,name,job,mgr,hiredate,sal,comm,deptNo);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				close(con, pstmt, rs);
			}catch(SQLException e){
				
			}
		}
		return dto;
	}
	

}
