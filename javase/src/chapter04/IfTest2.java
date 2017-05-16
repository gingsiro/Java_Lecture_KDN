package chapter04;

import java.util.Scanner;

public class IfTest2 {

	public static void main(String[] args) {
		/*
		 * 1~24까지 정수를 입력받아 아래와 같이 출력하는 기능 
		 * 9~12 : 오전 근무 시간 
		 * 13 : 점심 시간 
		 * 14~18 : 오후
		 * 근무 시간 나머지: 휴식시간
		 */
		Scanner s = new Scanner(System.in);
		
		int data = s.nextInt();
		s.close();

		if(data<1 || data>24){
			System.out.println("1 부터 24 사이의 정수를 입력하세요.");
		} else if (data >= 9 && data <= 12) {
			System.out.println(data + "시 는 오전 근무 시간 입니다.");
		} else if (data == 13) {
			System.out.println(data + "시 는 점심 시간 입니다.");
		} else if (data >= 14 && data <= 18) {
			System.out.println(data + "시 는 오후 근무 시간 입니다.");
		} else {
			System.out.println(data + "시 는 휴식 시간 입니다.");
		}
	}
}
