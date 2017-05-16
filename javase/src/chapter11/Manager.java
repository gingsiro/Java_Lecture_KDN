package chapter11;

public class Manager extends Employee{
	private String position;

	public Manager() {
		super(null, null, null, 0);
	}
	public Manager(String empno, String name, String address, int salary, String position) {
		super(empno, name, address, salary);
		this.position = position;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	public String toString(){
		return String.format("%s, position=%s", super.toString(), position);
	}
}
