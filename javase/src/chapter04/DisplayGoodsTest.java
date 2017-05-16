package chapter04;

import java.util.Scanner;

public class DisplayGoodsTest {

	public static void main(String[] args) {
		/*
		 * 상품(@)을 진열해주는 코드
		 * 두개의 정수를 입력받아서 
		 * 첫번째 데이터는 진열할 제품 총수
		 * 두번째 데이터는 한열에 진열할 제품 수
		 * 
		 * [입력데이터]
		 * 13  4
		 * [출력데이터]
		 * @ @ @ @
		 * @ @ @ @
		 * @ @ @ @
		 * @
		 */
		
//		Scanner s = new Scanner(System.in);
//		int all = s.nextInt();
//		int row = s.nextInt();
//		
//		for(int i=0 ; i<all ; i+=row){
//			for(int j=0 ; all-i>row ? j<row : j<all%row ; j++){
//				System.out.print("@ ");
//			}
//			System.out.println();
//		}
		Scanner s = new Scanner(System.in);
		int all = s.nextInt();
		int row = s.nextInt();
		s.close();
		for(int num=1 ; num<=all ; num++){
			System.out.print("@ ");
			if(num%row==0) System.out.println();			
			if(num==all) break;
		}
		
		//강사님 답
		Scanner s2 = new Scanner(System.in);
		int total = s2.nextInt();
		int displayNum = s2.nextInt();
		s2.close();
		
		int line = total / displayNum; //진열할 총 line수
		int mod = total % displayNum;
		if(mod != 0) line++; //나머지가 있으면 라인 하나 추가
//		for (int i = 0; i < line ; i++) {
//			for (int j = 0; j < displayNum; j++) {
//				System.out.print("@ ");
//				if(--total == 0) break;
//			}
//			System.out.println();
//		}
		for (int i = 1; i <= line ; i++) {
			if(i==line && mod>0){
				for (int j = 0; j < mod; j++) {
					System.out.print("@ ");
				}
			}else{
				for (int j = 0; j < displayNum; j++) {
					System.out.print("@ ");
				}
			}
			System.out.println();
		}

	}

}
