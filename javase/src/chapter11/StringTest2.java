package chapter11;

public class StringTest2 {
	public static void main(String[] args) {
		String str = "hello";
		for (int i = 0; i < 2111111111; i++) {
			str += i;
			System.out.println("str : " + str);
		}
	}
}
