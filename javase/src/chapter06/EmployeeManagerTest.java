package chapter06;

public class EmployeeManagerTest {

	public static void main(String[] args) {
		//EmployeeManager ems = new EmployeeManager();
		EmployeeManagerPoly ems = new EmployeeManagerPoly();
		
		ems.addEmployee(new Employee("1", "1", "1", 1));
		ems.addEmployee(new Manager("2", "2", "2", 1, "2"));
		ems.addEmployee(new Engineer("3", "3", "3", 1, "3"));
		ems.addEmployee(new Manager("4", "2", "2", 1, "2"));
		ems.addEmployee(new Manager("5", "2", "2", 1, "2"));
		ems.addEmployee(new Manager("6", "2", "2", 1, "2"));
		System.out.println("=========================== Add후 List ============================");
		ems.printAll();
		
		System.out.println("============================== Find ===============================");
		System.out.println(ems.findEmployee("3"));
		System.out.println(ems.findEmployee("4"));
		System.out.println(ems.findEmployee(null));
		
		System.out.println("============================= Update ==============================");
		ems.updateEmployee(new Manager("6", "홍길동", "율도국", 5000000, "사장"));
		ems.printAll();
		
		System.out.println("============================= Delete ==============================");
		ems.removeEmployee("1");
		ems.printAll();
	}
}