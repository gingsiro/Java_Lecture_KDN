package chapter06;

public class AccessModifiewTest2 {

	public static void main(String[] args) {
		Account acc = new Account();
		// private로 선언된 no는 접근 불가
//		acc.no="1111";
		acc.balance = 10;
		
		Customer cust = new Customer();
		// 같은 패키지 이므로 접근 가능
		cust.name = "kdg";
	}

}
