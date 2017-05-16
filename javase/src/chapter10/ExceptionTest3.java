package chapter10;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/**
 * 선언적 예외 처리:
 *  - 오류가 발생된 곳에서 예외 처리하지 않고 해당 메서드를 호출한 곳에
 *  예외처리하도록 위임
 *  형식]
 *  [modifier] returnType 메서드이름([인자])
 *  						[ throws CheckedException1, ...]{
 *  	// 오류가 발생 될 코드
 *  }
 *  
 *  1. 예외 처리 방법을 고정하지 않고 메서드 호출한 곳에 맞게 예외 처리하도록
 *     개발자에게 예외처리를 위임 => 예외 처리에 대한 다양성 제공
 *     
 *  2. 여러 기능에서 다양한 오류 발생하지만 예외 처리하는 방법이 공통적일 때
 *     호출한 곳으로 예외를 던져서 한 곳에서 공통적으로 처리
 *     => 코드의 재사용성
 *     
 *  3. 메서드의 수행 결과는 리턴으로 전달하고 메서드의 오류 정보를 예외로 전달 
 */
class MyUtil{
	public static int mod(int i, int j){
		return i/j;
	}
	
	public static void openFile(String name) throws FileNotFoundException{
		FileInputStream fis = new FileInputStream(name);
	}
}
//try catch 와 throws 가 사용되는 상황이 다름 
public class ExceptionTest3 {
	public static void main(String[] args) {
		try {
			MyUtil.openFile("a.txt");			
		} catch (FileNotFoundException e1) {
			// printStackTrace() : 오류가 발생한 곳의 모든 정보를 표시
			// getMessage() : 오류 메세지를 추출
			e1.printStackTrace();
		}
		
		System.out.println(MyUtil.mod(256, 2));
		
		try {
			System.out.println(MyUtil.mod(256, 0));
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		System.out.println("main end___");
		
	}
}
