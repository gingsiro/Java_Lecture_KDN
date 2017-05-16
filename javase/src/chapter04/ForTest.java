package chapter04;

import java.util.Scanner;

public class ForTest {

	public static void main(String[] args) {
		/*
		 * for(초기값설정;조건;증감){
		 * 		
		 * }
		 */
//		for( int i = 1 ; i <= 10 ; i++ ){
//			System.out.println("i : " + i);
//		}
		/* 콘솔창에서 단을 입력받아 해당 단의 구구를 찍는다.*/
		Scanner s = new Scanner(System.in);
		int dan = s.nextInt();
		s.close();
		if(dan<1){
			System.out.println("1이상의 정수를 입력하세요.");
		}else{
			for( int i = 1 ; i < 10 ; i++ ){
//				printf("데이터, 포멧", 포멧에 따른 데이터, ...);
//				%d : 정수, %f : 실수, %s : 문자열 %b : 논리
				System.out.printf("%d * %d = %d \n",dan, i, dan*i);
			}
		}
		
	}

}
