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
 */
class MyUtil{
	public static int mod(int i, int j){
		return i/j;
	}
	
	public static void openFile(String name) throws FileNotFoundException{
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(name);			
		} catch (Exception e) {
//			getMessage() : 에러메세지 추출 
			System.out.println(e.getMessage());
		}
	}
}
 
public class ExceptionTest3 {
	public static void main(String[] args) {
		MyUtil.openFile("a.txt");
		MyUtil.openFile("b.txt");
		MyUtil.openFile("c.txt");
		MyUtil.openFile("d.txt");
		
		System.out.println(MyUtil.mod(256, 2));
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(MyUtil.mod(256, 0));
		System.out.println("main end___");
		
	}
}
