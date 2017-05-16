package java_workshop01;

import java.util.Scanner;

public class NKH_Java_Workshop01_3 {

	public static void main(String[] args) {
		System.out.println("가위 바위 보 게임\n1. 가위\n2. 바위\n3. 보\n숫자를 입력하세요.");
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		s.close();
		int com=(int)(Math.random()*3+1);

		if(input==1) System.out.println("입력 : 가위");
		else if(input==2) System.out.println("입력 : 바위");
		else if(input==3) System.out.println("입력 : 보");
		else System.out.println("입력 : 잘못냈습니다.");
		
		if(com==1) System.out.println("게임 : 가위");
		else if(com==2) System.out.println("게임 : 바위");
		else if(com==3) System.out.println("게임 : 보"); 

		if((input==1 && com==3) || (input==2 && com==1) || (input==3 && com==2)) 
			System.out.println("결과 : 이겼습니다.");
		else if((input==3 && com==1) || (input==1 && com==2) || (input==2 && com==3)) 
			System.out.println("결과 : 졌습니다. ㅋ");
		else if((input==1 && com==1) || (input==2 && com==2) || (input==3 && com==3)) 
			System.out.println("결과 : 비겼습니다.");
		else
			System.out.println("왜 이상한걸 내고 그러세요...");
		
	}
}
