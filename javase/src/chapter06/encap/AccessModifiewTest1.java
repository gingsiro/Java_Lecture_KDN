package chapter06.encap;

import chapter06.Customer;

public class AccessModifiewTest1 {

	public static void main(String[] args) {
		Customer cust = new Customer();
		// name 속성이 퍼블릭이 아니라 접근 불가 
//		cust.name = "kdg";
		cust.age = 12;
	}

}
