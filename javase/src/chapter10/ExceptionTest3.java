package chapter10;
/**
 * 선언적 예외 처리:
 *  - 오류가 발생된 곳에서 예외 처리하지 않고 해당 메서드를 호출한 곳에
 *  예외처리하도록 위임
 *  형식]
 *  [modifier] returnType 메서드이름([인자])
 *  						[ throws CheckedException1, ...]{
 *  	// 오류가 발생 될 코드
 *  }
 */

class MyUtil{
	public static int mod(int i, int j){
		return i/j;
	}
}
public class ExceptionTest3 {
	public static void main(String[] args) {
		System.out.println(MyUtil.mod(256, 2));
		System.out.println(MyUtil.mod(256, 0));
		System.out.println("main end___");
	}
}
