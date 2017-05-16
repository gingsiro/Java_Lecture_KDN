package java_workshop01;

import java.util.Scanner;

public class NKH_Java_Workshop01_1 {

	public static void main(String[] args) {
		System.out.println("1. 개\n2. 고양이\n3. 병아리\n영어로 알고싶은 번호를 입력하세요.");
		
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		s.close();
		if(input==1){
			System.out.println("Dog");
		}else if(input==2){
			System.out.println("Cat");
		}else if(input==3){
			System.out.println("Chick");
		}else System.out.println("I Don't Know.");
	}
}
