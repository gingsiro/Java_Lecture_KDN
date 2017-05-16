package chapter10;


/**
 * - 오류 발생 시키기
 *   오류를 강제로 발생시켜 비정상적인 상황에 대한 메세지를 전달하기
 *   형식] throw 예외객체;
 */

class MyMath {
	public static int div(int i, int j) {
		if (j == 0) {
			// unchecked 이기 때문에 throws 안해도 자동으로 호출한 곳으로 전달 됨
			throw new ArithmeticException("0으로 나눌 수 없습니다.");
		} else {
			return i / j;
		}
	}
	public static int mod(int i, int j) throws Exception{
		if (j == 0) {
			// checked 이기 때문에 throws 해줘야 호출한 곳으로 전달 됨
			throw new Exception("0으로 나눌 수 없습니다.");
		} else {
			return i / j;
		}
	}
}

public class ExceptionTest4 {

	public static void main(String[] args) {
	}

}
