package java_20191128;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberManagementDemo {
	private ArrayList<Member> list;

	public MemberManagementDemo() {
		list = new ArrayList<Member>();
	}

	public void print() {
		System.out.println("********************************************");
		System.out.println("*1)insert 2)update 3)delete 4)search 5)exit*");
		System.out.println("********************************************");
	}

	public String console(String msg) {
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}

	public void run(String index) {
		if (index.equals("1")) {
			insert();

		} else if (index.equals("2")) {
			update();

		} else if (index.equals("3")) {
			delete();
		} else if (index.equals("4")) {
			search();
		} else if (index.equals("5")) {
			System.out.println("프로그램 종료");
		} else {
			System.out.println("안녕");
		}

	}

	// 1. 아이디를 입력받는다.
	// 2. 이름을 입력받는다.
	// 3, ArrayList에 멤버를 추가한다.
	// 4. print() 메서드를 호출하여 번호를 선택할 수 있게한다.
	// 5. 번호를 선택하세요> 메세지를 출력한 후 키보드 입력을 받게 대기한다.
	// 6. 번호를 입력받으면 run() 메서드를 호출한다.
	public void insert() {
		String id = console("아이디>");
		String name = console("이름>");
		Member m = new Member(id, name);
		list.add(m);
		System.out.printf("총 회원은 %d명 입니다. %n", list.size());
		print();
		String index = console("번호를 선택하세요>");
		run(index);

	}

	// 1. 수정할 아이디를 입력받는다. 중복된 아이디 안됨.
	// 2. ArrayList에 있는 멤버중에서 수정할 아이디를 찾아서 있으면 수정함
	// 이름을 입력받고, ArrayList에 멤버정보를 수정하고 만약 없으면 "수정할 아이디가 없습니다." 라는 메세지를 출력한다.
	// 3. ArrayList에 있는 멤버정보를 모두 출력한다.
	// 4. print() 메서드를 호출하여 번호를 선택할 수 있게한다.
	// 5. 번호를 선택하세요> 메세지를 출력한 후 키보드 입력을 받게 대기한다.
	// 6. 번호를 입력받으면 run() 메서드를 호출한다.

	public void update() {
		String id = console("수정할 아이디를 입력하세요>");
		for (int i = 0; i < list.size(); i++) {
			if (id.equals(list.get(i).getId())) {
				String name = console("수정할 이름을 입력하세요>");
				Member m = new Member(id, name);
				list.set(i, m);
				break;
			}
			System.out.println("수정할 아이디가 없습니다.");
			
		}
		System.out.println("********************************************");
		System.out.println("회원 목록입니다.");
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("회원 아이디 : %s, 회원 이름 : %s %n",
					list.get(i).getId(), list.get(i).getName());
		}

		print();
		String index = console("번호를 선택하세요>");
		run(index);
	}

	// 1. 삭제할 아이디를 입력받는다. 중복된 아이디 안됨.
	// 2. ArrayList에 있는 멤버중에서 삭제할 아이디를 찾아서 있으면 삭제함
	// 만약 없으면 "삭제할 아이디가 없습니다." 라는 메세지를 출력한다.
	// 3. ArrayList에 있는 멤버정보를 모두 출력한다.
	// 4. print() 메서드를 호출하여 번호를 선택할 수 있게한다.
	// 5. 번호를 선택하세요> 메세지를 출력한 후 키보드 입력을 받게 대기한다.
	// 6. 번호를 입력받으면 run() 메서드를 호출한다.
	public void delete() {
		String id = console("삭제할 아이디를 입력하세요>");
		for (int i = 0; i < list.size(); i++) {
			if (id.equals(list.get(i).getId())) {
				list.remove(i);
				break;
			} 
				System.out.println("삭제할 아이디가 없습니다.");
			

		}
		System.out.println("********************************************");
		System.out.println("회원 목록입니다.");
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("회원 아이디 : %s, 회원 이름 : %s %n",
					list.get(i).getId(), list.get(i).getName());
		}

		print();
		String index = console("번호를 선택하세요>");
		run(index);
	}

	// 1. 검색할 아이디를 입력받는다.
	// 2. ArrayList에 있는 멤버중에서 검색할 아이디를 찾아서 있으면 출력하고
	// 만약 없으면 "검색된 결과가 없습니다."라는 메세지를 출력한다.
	// 4. print() 메서드를 호출하여 번호를 선택할 수 있게한다.
	// 5. 번호를 선택하세요> 메세지를 출력한 후 키보드 입력을 받게 대기한다.
	// 6. 번호를 입력받으면 run() 메서드를 호출한다.
	public void search() {
		String id = console("검색할 아이디를 입력하세요>");
		for (int i = 0; i < list.size(); i++) {
			if (id.equals(list.get(i).getId())) {
				System.out.printf("회원 아이디 : %s, 회원 이름 : %s %n", list.get(i)
						.getId(), list.get(i).getName());
				break;
			}
				System.out.println("검색된 결과가 없습니다.");
		}
		print();
		String index = console("번호를 선택하세요>");
		run(index);

	}

	public static void main(String[] args) {
		MemberManagementDemo m1 = new MemberManagementDemo();
		m1.print();
		String index = m1.console("번호를 선택하세요>");
		System.out.println(index);
		m1.run(index);

	}

}
