package chapter06;
/**
 * static : 정적인 특성을 부려
 *   - Class가 로딩될 때 한번 수행됨.
 *   - 객체 생성 없이 Class를 통해서 속성, 메서드에 접근
 *     ClassName.속성명     ClassName.메서드명([args])
 *     
 *   - 속성 : Class가 로딩될 때 static으로 선언한 속성이 Class Area에 할당됨.
 *            해당 Class로 부터 생성된 객체들이 공유하는 공유 변수가 됨.      
 *            
 *   - 메서드 : Class가 로딩될 때 method binding이 됨.
 *     주의점 : non-static인 속성, 메서드에 접근 불가.
 *     			utility 성 코딩시 static 메서드를 사용.
 *              
 *   - 블럭 : Class가 로딩될 때 한번 수행됨
 *     		  클래스로 부터 단 한번 수행될 기능 작성
 *    		  - static 속성을 초기화
 *     형식] static{ }
 *     
 *  instance 블럭 :
 *     - 객처 셍성시 마다 생성자보다 먼저 수행됨
 *     - 어떤 생성자로 객체 생성하던 동일하게 수행될 기능을 작성.
 *     형식] { }
 */
class Counter{
	static int scount; //static attribute, class attribute
	int icount; //non-static attribute, instance attribute
	
	{
		System.out.println("Counter Instance Block 수행됨");
	}
	
	public Counter(){
		System.out.println("Counter() 생성자 호출됨");
		scount++;
		icount++;
	}
	
	public void print(){
		System.out.printf("scount : %d, icount : %d\n", scount, icount);
	}
	
	public static void sprint(){
		//static 메서드에서는 non-static으로 선언한 icount에 접근 불가
//		System.out.printf("scount : %d icount : %d\n", scount, icount);
		System.out.printf("Counter의 sprint() 메서드 scount: %d\n", scount);
	}
}

class SubCounter extends Counter{
	public static void sprint(){
		System.out.println("SubCounter의 sprint() 메서드");
	}
}

//public static class StaticTest { //클래스는 무조건 동적로딩으로 static 쓰면 에러남
public class StaticTest {
	static{
		System.out.println("StaticTest 클래스의 static 블럭");
	}
	
	public static void main(String[] args) {
		System.out.println("Main Start...");
		Counter c3 = new Counter();
//		c3.sprint(); 접근 불가
		c3.print();
		
		Counter.scount++;
		Counter.sprint();
		
		Counter c1 = new Counter();
		c1.print();
		Counter c2 = new Counter();
		c2.print();
		
		c1.print();
	}
}
