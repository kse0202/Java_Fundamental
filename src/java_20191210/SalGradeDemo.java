package java_20191210;

import java.util.ArrayList;

import java_20191210.dao.SalGradeDao;
import java_20191210.dto.SalGradeDto;

public class SalGradeDemo {

	public static void main(String[] args) {
		SalGradeDao s = SalGradeDao.getInstance();
		boolean isSuccess = s.insesrt(new SalGradeDto(6,6000,6500));
		System.out.println(isSuccess);
		
		//boolean isSuccess = s.update(new SalGradeDto(6,6000,7000));
		//System.out.println(isSuccess);
		
		//boolean isSuccess = s.delete(6);
		//System.out.println(isSuccess);
		
		ArrayList<SalGradeDto> list = s.select();
		for (SalGradeDto dto : list) {
			System.out.printf("%d, %d, %d %n", dto.getGrade(), dto.getLosal(), dto.getHisal());
			
		}
		
		SalGradeDto dto = s.selcet(1);
		if(dto ==null){
			System.out.println("해당 값이 없습니다.");
		}else{
			System.out.printf("%d, %d, %d", dto.getGrade(), dto.getLosal(), dto.getHisal());
		}

	}

}
