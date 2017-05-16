package chapter06;

/**
 * final : 수정 불가
 *   변수(attribute, local 변수) : 값 수정 불가 (constance, 상수)
 *   메서드 : 오버라이드 금지
 *   클래스 : 상속 금지
 *     ex) System, String, Math
 */

class Super{
	// Super클래스로 부터 생성된 객체들이 공유하는 고정값
	static final double PI = 3.14;
	final int snum; //객체마다 다른 고정값을 갖는다. ex)객체의 시리얼넘버
					//blank final variable
					//이부분만 작성시 오류 발생
	public Super(int snum){
		this.snum = snum; // bfv를 한번 초기화 시키면 에러가 안난다.
	}
	
	public final void test(){
		System.out.println("test()가 호출됩니다.");
	}
	
	public int getSnum() {
		return snum;
	}
	//getter 랑 setter 생성을 누르면 getter만 생성 됨.
	//setter 가 할 수 있는 일이 없기 때문
}

class Sub extends Super{
	public Sub(int snum){
		super(snum);
	}
//	Final Method는 override 할 수 없다. 
//	public void test(){}
}

public class FinalTest {
	public static void main(String[] args) {
		final double PI = 3.14;
//		pi = 3.141;
		System.out.println(PI);
	}
}
