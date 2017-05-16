package chapter06;

/**
 * 다형성 : 여러가지 형태를 제공
 *   - Method : 메서드를 호출했는데 상황에 따라 메서드가 호출됨.
 *     - Method Overloading : 메서드 인자에 따라서
 *     - Method Overriding : 부모 or 자식에 따라서
 *     => 메서드 호출에 대한 편리성 제공, 수정성 제공
 *   - Data(형변환)  
 *     - Primitive : byte => short => int => long => float => double
 *     						 char
 *     - Reference : super type의 참조 변수가 sub type의 객체를 참조 할 수 있다. 
 *     
 */
public class PolymorphismTest {
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp = new Manager();	//다형성
		emp = new Engineer();	//다형성
		System.out.println(emp);
//		Manager mgr = new Employee();  //다형성이 아니라서 compile error 발생
//		Engineer mgr = new Engineer(); //다형성이 아니라서 compile error 발생
		
		/*
		 * Reference type 형변환
		 *   - up casting (자동 형 변환) 	 : sub 타입의 객체에서 super 타입으로 변환
		 *   							=> 모든 sub타입 객체는 super type으로 자동 형변환
		 *   - down casting (명시적 형 변환) : super 타입의 참조 변수가 sub 타입으로 변환
		 *   							=> 참조하고 있는 sub 객체의 타입으로만 변환 됨.
		 *     목적 : 다형성에 의해 sub에 추가된 속성, 메서드에 접근 불가하기 때문에
		 *     		  추가된 속성, 메서드에 접근하기 위해 down casting을 한다.
		 */
		
		Manager mgr1 = new Manager();
		Employee emp1 = mgr1;	//up casting
//		emp1.getPosition();		//Shadow Impact
		/*
		 * Shadow Impact :
		 *   다형성에 의해 sub에 추가된 속성, 메서드에 접근 불가
		 */
		
		Engineer eng1 = new Engineer();
		emp1 = eng1;			//up casting
		
		Engineer eng2 = (Engineer) emp1; //down casting
		System.out.println(eng2);
//		Manager mgr2 = (Manager) emp1; // down casting x, ClassCastExecption 발생
		
		/*
		 * instanceof : 레퍼런스 타입의 형검사
		 *   객체가 해당 타입인지 검사하는 operator로 해당 타입이면 true, 그렇지 않으면 false
		 *   
		 *   형식] 객체(해시코드) instanceof 타입(해시코드)
		 */
		if (emp1 instanceof Manager) {
			Manager mgr3 = (Manager) emp1;
			System.out.println("emp1은 Manager입니다. 직위 : "+mgr3.getPosition());
		}else if (emp1 instanceof Engineer) {
			Engineer eng3 = (Engineer) emp1;
			System.out.println("emp1은 Engineer입니다. 스킬 : "+eng3.getSkill());
		}		
		
		/*
		 * Virtual Invocation : 
		 *   - 다형성 관계에서는 override된 메서드가 호출됨.
		 *   - Virtual Invocation이 안되는 경우
		 *     - static으로 선언한 경우
		 *     - access modifier가 default이고 상속된 클래스가 패키지가 다른경우
		 */
		Manager mgr5 = new Manager("1111", "홍길동", "율도국", 5000000, "사장");
		System.out.println(mgr5);
		Employee emp5 = mgr5;
		System.out.println(emp5);
		
		
		
		System.out.println("main end.....");
	}
}
