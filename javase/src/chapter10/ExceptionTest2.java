package chapter10;

public class ExceptionTest2 {
	public static void main(String[] args) {
		int result = 0, data = 0;
		try {
			// Integer.parseInt(String d) : 문자열을 정수로 변환 시켜주는 함수
			result = 256 / Integer.parseInt(args[0]);
			// } catch (ArithmeticException e) {
			// System.out.println("0이 아닌 정수를 입력하세요. 기본 처리 됩니다.");
			// result = 1;
		} catch (NumberFormatException e) {
			System.out.println("정수로 입력해 주세요. 기본 처리 됩니다.");
			result = 2;
			return;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("데이터를 입력해 주세요. 기본 처리 됩니다.");
			result = 3;
			System.exit(0);
			// } catch (Exception e){
			// System.out.println("오류 발생! 기본처리 됩니다.");
			// result = 1;
		} finally {
			// try문 수행되면 반드시 수행되는 문잔
			// 1. 오류가 발생하지 않아도
			// 2. 오류가 발생했지만 catch로 잡은 경우에도 수행
			// 3. 오류가 발생했지만 catch로 못 잡은 경우에도 수행
			// 4. try문 또는 catch문에서 return된 경우에도 수행
			// 반드시 수행되야 하는 기능을 작성 ex) 자원 반납
			// ex) File, Network, db 등은 반드시 close 해야 됨.
			System.out.println("finally문이 수행됨___");
		}
		System.out.println("결과 : " + result + data);
		System.out.println("main end___");
	}
}
