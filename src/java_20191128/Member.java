package java_20191128;

public class Member {
	private String id;
	private String name;
	
	//매개변수가 있는 생성자 만든거
	public Member(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	

}
