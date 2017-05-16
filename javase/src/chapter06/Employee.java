package chapter06;

public class Employee {
	private String empno;
	private String name;
	private String address;
	private int    salary;
	
	//만약 기본 생성자가 없다면 ? Engineer 클래스에 가서 보자.
	public Employee(){}
	public Employee(String empno, String name, String address, int salary) {
		this.empno = empno;
		this.name = name;
		this.address = address;
		setSalary(salary);
	}
	
	public String getEmpno() {
		return empno;
	}
	
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		if(salary >= 1000000)
			this.salary = salary;
		else
			this.salary = 1000000;
	}
	
	@Override
	public String toString() {
		return String.format("empno=%s, name=%s, address=%s, salary=%s"
							, empno, name, address, salary);
	}
	
}
