package chapter06;

public class Engineer extends Employee{
	private String skill;
	
	public Engineer(){
		/* 클래스에 기본 생성자가 없다면
		 * 기본 생성자 호출해줘야 함. 
		 * - 생성자 호출은 생성자의 첫번째 명령에서만 호출 가능
		 */
//		super(null, null,null, 0);
	}
	public Engineer(String empno, String name, String address, int salary, String skill) {
		/* 부모 클래스의 생성자는 상속되지 않지만 호출을 통해 재사용할 수 있다.
		 * - super([args]);
		 * - 생성자 호출은 생성자의 첫번째 명령에서만 호출 가능
		 */
		super(empno, name, address, salary);
//		setEmpno(empno);
//		setName(name);
//		setAddress(address);
//		setSalary(salary);
		this.skill = skill;
	}
	
	public String getSkill() {
		return skill;
	}
	
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	/**
	 * Method Overriding(함수 재정의)
	 * - 상속받은 메서드와 전체적인 기능은 동일하지만 상세 구현이 조금 다른 경우
	 *   새로운 메서드를 작성해야 하는데 이때 메서드 이름을 동일하게 선언 할 수 있다.
	 * - 규칙
	 *   1. 메서드 이름과 인자는 반드시 동일해야 한다. (인자가 다르면 오버 로딩)
	 *   2. 리턴타입
	 *      JDK 1.7 이전
	 *       - 부모 메서드에서 리턴한 타입과 반드시 같아야 한다.
	 *      JDK 1.7 이후
	 *       - 부모 메서드에서 리턴한 타입과 같거나 sub를 리턴
	 *       ex) [부모] public Employee findEmployee(String emp){}
	 *           [자식] public Employee findEmployee(String emp){}
	 *                  public Manager findEmployee(String emp){}
	 *   3. access modifier는 reduce(접근 범위 좁힘)하면 안된다. 같거나 넓힐수만 있다.
	 *   4. Exception을 throws할 때는 같은 Exception을 throws하거나 sub를 throws 하거나
	 *      throws하지 않으면 된다.
	 *      => super를 throws하면 컴파일 오류 발생
	 * - 효과
	 *   1. 부모의 메서드 이름과 같고 인자가 같기 때문에 호출하는 방법이 같고
	 *      리턴 타입이 같으므로 매서드 호출 후 처리가 같아지므로
	 *      기존의 소스 코드를 수정하지 않고 변경된 내용을 반영할 수 있다.
	 *   2. 부모, 자식 가리지 않고 기능이 동일하면 같은 이름의 메서드를 호출한다.
	 *     => 호출의 편리성
	 *   3. 다형성 관계에서는 sub에 재정(override)된 메서드가 호출 된다.
	 *     => 기존의 소스 코드를 수정하지 않고 변경된 내용을 반영할 수 있다.
	 *   4. Shadow Impact에 의해 접근할 수 없는 속성, 메서드에 접근 가능
	 *   
	 *   Shadow Impact
	 *     - 다형성 관계일 때 sub에 추가된 속성, 메서드에 접근 불가.
	 */
	
	public String toString(){
		/* super : 부모를 가리키는 지시자
		 * Override에 의해 무시된 부모 메서드를 호출 할 때 super.methodName(~);
		 */
		return String.format("%s, skill=%s", super.toString(), skill);
	}
}