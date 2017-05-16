package chapter06;

public class CustomerTest {

	public static void main(String[] args) {
		Customer cust1 = new Customer("남궁현", "대전", 31);
		Customer cust2 = new Customer("kdn", "나주", 25);
		
		System.out.println(cust1.customerInfo());
		System.out.println(cust2.customerInfo());
	}

}
