package java_20191211;

import java.util.ArrayList;

import java_20191211.dao.EmpDao;
import java_20191211.dto.EmpDto;

public class EmpDemo {

	public static void main(String[] args) {
	/*	try {
			Class.forName("java_20191211.dao.EmpDao").newInstance(); //에러남. 생성자가 private이라서 객체 생성이 안된다.
			EmpDao empDao = (EmpDao)Class.forName("java_20191211.dao.EmpDao").newInstance(); //이렇게 객체 생성 가능
			// 문자열 가지고 객체를 생성할때 사용한다. ""안에가 클래스 파일 정보이니까 이걸로 객체를 생성할 때 사용
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		EmpDao dao = EmpDao.getInstance();
		
			//dao.insert(new EmpDto(9002,"SUNG2","SALESMAN",7839,null,4998,0,20));
			//dao.update(new EmpDto(9002, "SUNG3","SALESMAN", 7839,null, 5002, 22 , 20));
			//dao.delete(8001);
		
		ArrayList<EmpDto> list = dao.select(0,5);
		for (EmpDto dto : list) {
			int no = dto.getNo();
			String name = dto.getName();
			String job = dto.getJob();
			int mgr = dto.getMgr();
			String hiredate = dto.getHiredate();
			double sal = dto.getSal();
			double comm = dto.getComm();
			int deptNo = dto.getDeptNo();
			
			System.out.printf(" %d, %s, %s, %d, %s, %.2f, %.2f, %d %n ", no, name, job, mgr, hiredate, sal, comm, deptNo);
		}
		
		EmpDto dto = dao.select(9002);
		if(dto != null){
			int no = dto.getNo();
			String name = dto.getName();
			String job = dto.getJob();
			int mgr = dto.getMgr();
			String hiredate = dto.getHiredate();
			double sal = dto.getSal();
			double comm = dto.getComm();
			int deptNo = dto.getDeptNo();
			
			System.out.printf(" %d, %s, %s, %d, %s, %.2f, %.2f, %d %n ", no, name, job, mgr, hiredate, sal, comm, deptNo);
			
		}else {
			System.out.println("해당 사원이 없습니다.");
		}

	}

}
