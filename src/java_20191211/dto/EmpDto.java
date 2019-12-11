package java_20191211.dto;

public class EmpDto {
	private int no;
	private String name;
	private String job;
	private int mgr;
	private String hiredate;
	private double sal;
	private double comm;
	private int deptNo;
	
	
	public EmpDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EmpDto(int no, String name, String job, int mgr, String hiredate,
			double sal, double comm, int deptNo) {
		super();
		this.no = no;
		this.name = name;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.comm = comm;
		this.sal = sal;
		this.deptNo = deptNo;
	}

	
	public int getNo() {
		return no;
	}


	public String getName() {
		return name;
	}


	public String getJob() {
		return job;
	}


	public int getMgr() {
		return mgr;
	}


	public String getHiredate() {
		return hiredate;
	}


	public double getSal() {
		return sal;
	}


	public int getDeptNo() {
		return deptNo;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public void setMgr(int mgr) {
		this.mgr = mgr;
	}


	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}


	public void setSal(double sal) {
		this.sal = sal;
	}


	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	
	public double getComm() {
		return comm;
	}


	public void setComm(double comm) {
		this.comm = comm;
	}
	
	

}
