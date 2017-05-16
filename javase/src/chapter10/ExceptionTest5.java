package chapter10;

/**
 * 사용자 정의 예외 : 개발자들이 필요에 따라 만드는 예외
 * 
 * - CheckedException : 예외 처리하지 않으면 컴파일 오류 발생 => 반드시 예외 처리 해야 한다. - 종류 :
 * UnChecked 의 종류를 제외한 예외들 ex) Exception, IOException, SQLException, ... -
 * CheckedException으로 선언하는 방법 RunTimeException, RunTimeException 상속 받은 Sub들을 제외한
 * 예외들을 상속 받기 ex) Exception
 * 
 * - UnCheckedException : 예외처리 하지 않아도 컴파일 오류는 발생하지 않지만 실행 중에 오류 발생할 수 있다. => 필요시
 * 예외 처리 - 종류 : RunTimeException, RunTimeException 상속 받은 Sub들 -
 * UnCheckedException으로 선언하는 방법 RunTimeException, RunTimeException 상속 받은 Sub들을
 * 상속 받기
 */

class MyCheckedExcep1 extends Exception { // Exception 을 상속받았기에 CheckedException으로 선언 됨
	public MyCheckedExcep1(String msg){
		super(msg); //getMessage(), printStackTrace() 에서 오류 메세지 확인
	}
}

class MyUnCheckedExcep extends RuntimeException {
	public MyUnCheckedExcep(String msg){
		super(msg);
	}
}

class MyCalc{
	public static int mod(int i, int j){
		if (j == 0) {
			throw new MyUnCheckedExcep("0으로 나눌 수 없습니다.");
		} else {
			return i/j;
		}
	}
	public static int div(int i, int j) throws MyCheckedExcep1{
		if (j == 0) {
			throw new MyCheckedExcep1("0으로 나눌 수 없습니다.");
		} else {
			return i/j;
		}
	}
}

public class ExceptionTest5 {
	public static void main(String[] args) {
	}
}
