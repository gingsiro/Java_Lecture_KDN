package chapter04;

public class ContinueTest {

	public static void main(String[] args) {
		// 4의 배수를 제외하고 1~100까지 출력
		for (int i = 1; i <= 100 ; i++) {
			if(i%4==0) continue;
			System.out.println(i);
		}
	}
}
