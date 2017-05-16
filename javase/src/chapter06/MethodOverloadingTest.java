package chapter06;
// 하나의 자바파일 내에서 여러가지 클래스가 생성 가능
// 단, 파일 이름과 같은 퍼블릭클래스가 유일하게 존재 해야함  
class MyMath{
	
	public int plus(int a, int b){
		return a + b;
	}
	
	public double plus(double a, double b){
		return a + b;
	}

	public char plus(char a, char b){
		return (char)(a + b);
	}
	
	public String plus(String a, String b){
		return a + b;
	}
	
}

/**
 * Method Overloading : 
 *   - 동일한 이름의 메서드를 여러개 선언할 수 있다.
 *   - 인자의 개수, 인자의 타입, 인자의 순서가 달라야 메서드를 구별할 수 있다.
 *   
 *   - 목적 
 *     1. 메서드의 기능이 동일하지만 인자가 다를경우 동일한 이름을 부여하고
 *   	  인자를 다르게 선언
 *     2. 메서드 호출에 대한 편리성 제공, 수정성을 조금 높일 수 있다.
 */
public class MethodOverloadingTest {

	public static void main(String[] args) {
		MyMath mm = new MyMath();
		
		System.out.println(mm.plus(256, 128));
		System.out.println(mm.plus(256.5, 128.8));
		System.out.println(mm.plus("a", "b"));
		System.out.println(mm.plus("그리고"," 그렇다"));
		
	}

}
