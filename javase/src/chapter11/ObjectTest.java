package chapter11;

public class ObjectTest {
	public static void main(String[] args) {
		Employee emp1 = new Employee("emp1", "홍길동", "율도국", 5000000);
		Employee emp2 = new Employee("emp1", "홍길동", "율도국", 5000000);
		
		System.out.println("emp1.hashCode() " + emp1.hashCode());
		System.out.println("emp2.hashCode() " + emp2.hashCode());
		System.out.println(emp1.toString());
		System.out.println("emp1 == emp2 " + (emp1 == emp2));
		System.out.println("emp1.equals(emp2) " + emp1.equals(emp2));		
	}
}
