package chapter04;

import java.util.Scanner;

public class IfTest1 {

	public static void main(String[] args) {
		// 콘솔창에서 데이터를 입력 받을 수 있는 객체 생성
		Scanner s = new Scanner(System.in);

		int data = s.nextInt(); // 콘솔창에서 정수 데이터 한개를 입력 받음
		s.close();
		
		if(data % 2 == 0){
			System.out.println("입력된 데이터 : " + data + "는(은) 짝수입니다.");
		}else{
			System.out.println("입력된 데이터 : " + data + "는(은) 홀수입니다.");			
		}
		
		

	}
}
