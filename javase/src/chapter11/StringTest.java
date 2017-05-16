package chapter11;

public class StringTest {
	public static void main(String[] args) {
		String str1 = "hello";
		String str2 = "hello";
		String str3 = new String("hello");
		String str4 = new String("hello");
		
		System.out.printf("str1 == str2 %b\n", str1 == str2); // 
		System.out.printf("str1 == str3 %b\n", str1 == str3);
		System.out.printf("str3 == str4 %b\n", str3 == str4);
		
		System.out.printf("str1.equals(str2) %b\n", str1.equals(str2));
		System.out.printf("str1.equals(str3) %b\n", str1.equals(str3));
		System.out.printf("str3.equals(str4) %b\n", str3.equals(str4));
		
		str1 += " world"; //문자열 + 로 연산하면, Garbage Collector가 발동되어 성능 저하
		str2 += " world";//최대한 지양하자
		System.out.println(str1 + " world");
		
//		StringBuffer sb1;
		StringBuilder sb2 = new StringBuilder(100);
		sb2.append("hello ");
		sb2.append("world ");
		sb2.append("java ");
		System.out.println(sb2.toString());
		 
		String str5 = "hello " + "world " + "java";
		String str6 = "hello " + "world " + sb2.toString();
		System.out.println(str5 + str6);
		
	}
}
