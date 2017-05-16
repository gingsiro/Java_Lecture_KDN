package chapter10;

public class ExceptionTest1 {
	public static void main(String[] args) {
		String[] greeting = { "hello", "hi", "안녕" };
		try {
			for (int i = 0; i <= 3; i++) {
				System.out.println(greeting[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}
		System.out.println("main end___");
	}
}
