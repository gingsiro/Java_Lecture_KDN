package chapter04;

import java.util.Scanner;

public class SwitchTest1 {

	public static void main(String[] args) {
		/*
		 * switch(조건) {
		 * 		조건의 결과가 byte, short, char, int여야한다.
		 *      1.7버전 부터 String도 가능
		 *      case 값 : 값과 조건의 결과가 같으면 실행
		 *      default : 조건과 맞는것이 없으면 실행
		 * }
		 */
		Scanner s = new Scanner(System.in);
		int time = s.nextInt();
		s.close();
		
		if(time<1 || time>24){
			System.out.println("1 부터 24 사이의 정수를 입력하세요.");
		} else{
			switch(time){
			case 13:
				System.out.println("점심시간");
				break;
			case 9:
			case 10:
			case 11:
			case 12:
				System.out.println("오전 근무 시간");
				break;
			case 14:
			case 15:
			case 16:
			case 17:
			case 18:
				System.out.println("오후 근무 시간");
				break;
			default:
				System.out.println("휴식 시간");
			}
		}
		
	}

}
