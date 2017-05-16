package chapter06;

public class InheritanceTest {
	public static void main(String[] args) {
		/* mgr 이란 공간이 스택에 생김
		 * new Manager를 통해 힙영역에 공간 할당 시도
		 * Manager가 얼만큼의 공간이 필요할지 참고하러 감
		 * 동적로딩이니, Manager에 Position밖에 없으므로 Position공간만 확보
		 * Manager에 this, super 가 없으면 super(~)가 한줄 들어감
		 * 따라서 부모클래스에 기본생성자가 있어야 확인함.
		 * 따라서 Employee 로딩 시도
		 * Employee에얼만큼의 공간이 필요한지까지 확인
		 * 힙영역에 할당할 공간 확보 완료
		 * 초기화 진행
		 */
		Manager mgr = new Manager("emp1", "emp1", "나주", 3500000, "대리");
		Engineer eng = new Engineer("emp2", "홍길동", "율도국", 5000000, "도술");
		System.out.println(mgr);
		System.out.println(eng);
	}
}
