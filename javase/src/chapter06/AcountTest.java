package chapter06;

import java.util.Scanner;

public class AcountTest {

	public static void main(String[] args) {
		String no = "12345";
		String password = "12345";
		int cash = 0;
		String pw;

		Account a = new Account(no, password, 0);
		MinusAccount ma = new MinusAccount(no, password, 5000, 1000000);
		Scanner s = new Scanner(System.in);

		int input = 0;
		while (input != 3) {
			System.out.println("KDN Bank");
			System.out.println("1. 일반계좌");
			System.out.println("2. 마이너스계좌");
			System.out.println("3. 종료");
			System.out.println("원하시는 메뉴를 입력하세요.");
			input = s.nextInt();
			switch (input) {
			case 1:
				while (input != 3) {
					System.out.println("KDN Bank - 일반 계좌");
					System.out.println("1. 입금");
					System.out.println("2. 출금");
					System.out.println("3. 종료");
					System.out.println("원하시는 메뉴를 입력하세요.");

					input = s.nextInt();

					if (input == 1) {
						System.out.print("입금할 금액을 입력하세요 : ");
						cash = s.nextInt();
						System.out.printf("입금 후 잔액 : %d원\n\n", a.deposit(cash));
					} else if (input == 2) {
						System.out.println("비밀번호를 입력하세요.");
						// 이부분 정확히 파악해보자
						// 줄단위로 문자열 읽는거 !
						pw = s.next();
						System.out.println("출금할 금액을 입력하세요.");
						cash = s.nextInt();
						System.out.printf("출금 후 잔액 : %d원\n\n", a.withdraw(pw, cash));
					} else if (input == 3) {
						break;
					} else {
						System.out.println("잘못입력하셨습니다.");
					}
				}
				input = 0;
				break;
			case 2:
				while (input != 4) {
					System.out.println("KDN Bank - 마이너스 계좌");
					System.out.println("1. 입금");
					System.out.println("2. 출금");
					System.out.println("3. 한도 설정");
					System.out.println("4. 종료");
					System.out.println("원하시는 메뉴를 입력하세요.");

					input = s.nextInt();

					if (input == 1) {
						System.out.print("입금할 금액을 입력하세요 : ");
						cash = s.nextInt();
						System.out.printf("입금 후 잔액 : %d원\n\n", ma.deposit(cash));
					} else if (input == 2) {
						System.out.println("비밀번호를 입력하세요.");
						// 이부분 정확히 파악해보자
						// 줄단위로 문자열 읽는거 !
						pw = s.next();
						System.out.println("출금할 금액을 입력하세요.");
						cash = s.nextInt();
						System.out.printf("출금 후 잔액 : %d원\n\n", ma.withdraw(pw, cash));
					} else if (input == 3) {
						System.out.println("한도 금액을 입력하세요.");
						cash = s.nextInt();
						ma.setLimit(cash);
						System.out.printf("한도 금액 : %d원\n\n", -ma.getLimit());
					} else if (input == 4) {
						break;
					} else {
						System.out.println("잘못입력하셨습니다.");
					}
				}
				input = 0;
				break;
			case 3:
				break;
			}

		}
		s.close();
	}

}
