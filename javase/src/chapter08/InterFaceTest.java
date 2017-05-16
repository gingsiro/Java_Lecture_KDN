package chapter08;

import java.io.Serializable;

import chapter08.sub.Trans;

/**
 *  Interface
 *    - 산수와 추상메서드로만 구성된 Reference Type
 *    - 생성자로 객체 생성 불가.
 *    - 다형성에 의해 sub 객체를 참조 할 수 있다.
 *    - 다중 상속이 됨 ==> 
 *    선언] 
 *    [public] interface 인터페이스이름 [extends 슈퍼인터페이스, ...] { }
 *    
 *    구현]
 *    [modifier] class 클래스이름 [extends 슈퍼클래스] [implements 슈퍼인터페이스, ...] { }
 */
interface SuperInter extends Trans, Serializable{
	double PI=3.14; //컴파일 시 public static final로 선언 됨.
}

interface Flyer{
	public void fly();
}
class Super{
	public void start(){
		System.out.println("출발");
	}
}
// 상속 extends 먼저 받고 interface는 뒤에
@SuppressWarnings("serial")
class SuperMan extends Super implements SuperInter, Flyer{
	public void stop() {
		System.out.println("멈춤");
	}
 
	public void fly() {
		System.out.println("날기");
	}
}

public class InterFaceTest {
	public static void main(String[] args) {
		System.out.println(SuperInter.PI); // 객체 생성없이 접근했으니 static이다. private은 아니구나~!
//		SuperInter.PI = 3.141; // 에러 발생, 값 변경 불가 final임
		System.out.println(Trans.INIT); // 다른 패키지에 있어도 접근 가능하니 public 이다.
//		Trans.INIT = 1; // 에러 발생, 값 변경 불가 final임
		
//		다양하게 형변환이 됨.
		SuperMan man = new SuperMan();
		Super s1 = man;
		SuperInter si1 = man;
		Trans t = man;
		Serializable sl = man;
		Flyer f = man;
		
		System.out.println(man.toString() + s1 + si1 + t + sl + f); //노란느낌표 없애기용.
	}
}
