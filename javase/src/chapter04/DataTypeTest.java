package chapter04;

public class DataTypeTest {

	public static void main(String[] args) {
		int price;
//		price 변수를 초기화하지 않고 사용해서 컴파일 에러
//		System.out.println(price);
		price=1000;
		System.out.println(price);
		
//		정수형 : byte, short, int, long 중에서 jvm은 int를 정수의 기본형으로 사용
//		byte, short는 연산을 하면 vm이 int형으로 변환한다.
		byte b1 = 1, b2 = 8;
//		byte b3 = b1 + b2;
		byte b3 = (byte)(b1 + b2);
		int i1 = b1 + b2;
		System.out.println(b1 + "  " + b2 + "  " + b3 + "  " + i1);
		
		long l1 = 127;
//		long l2 = 2222222222; 리터럴 2222222222은 int 범위를 벗어나서 error 형변환 필요
		long l2 = 2222222222l, l3 = 2222222222L;
		System.out.println(l1 + "  " + l2 + "  " + l3);
		
//		실수의 기본형은 double이다.
		float f1 = 3.14f, f2 = 3.14F;
		
		float f3 = 65536.256f;
		float f4 = 2222222222.345f;
		System.out.println(f1 + "  " + f2 + "  " + f3);
		System.out.println(f4);
		
		/* 형변황 : 
		 *  - 논리형을 제외한 7가지 기본 타입은 형을 바꿀 수 있다.
		 *  - 자동 형변환 : 
		 *    byte => short => int => long => float => double
		 *    		  char
		 *  - 명시적 형변환 : (변환할타입)값;
		 */
		
		int i3 = b1;
		char c1 = 'a';
		int i4 = c1;
		System.out.println(i3 + "  " + i4);
		i4 = c1 + 5;
		char c2 = (char)i4;
		System.out.println(c1);
		System.out.println(c2);
	}

}
