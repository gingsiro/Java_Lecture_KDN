package chapter06;

public class Member {
	String id      ;
	String password;
	String name    ;
	String email   ;
	String address ;
	String withdraw;
	
	/**
	 * 생성자 
	 *  - 객체 생성시 객체 초기화(속성에 특정값 부여, 객체 생성시 수행되는 기능)
	 *  - 생성자 이름은 클래스 이름과 같아야 하며, 리턴 타입이 없어야 한다.
	 *  - 기본 생성자 : 컴파일러는 클래스 내에서 생성자가 하나도 선언되어 있지 않으면
	 *  				인자가 없고, 구현내용이 없는 생성자를 추가한다. 
	 *  - 인자가 있는 생성자만 생성 시 기본 생성자가 생성되지 않기 때문에 에러가 난다.
	 *  
	 *  **생성자 Overloading
	 *  - 생성자를 여러개 선언할 수 있다. 
	 *  - 생성자를 구분하기 위해 인자를 다르게 선언해야 한다.
	 *    인자의 개수가 달라야 한다.
	 *    인자의 타입이 달라야 한다.
	 *    인자의 순서가 달라야 한다. (셋중 하나만 만족해도 구분 가능) 
	 *  - 인자 이름은 유의미하게 해주는 것이 좋다.
	 *  
	 * 기본값
	 *  - 숫자 : 0
	 *  - char : '\u0000'
	 *  - 논리 : false(0<-자바에선 안됨)
	 *  - 참조형 : null 
	 */
	Member(){
		/* this
		 * 2. 재사용성을 위해 인자가 다른 생성자를 호출할때
		 *    this([args]) 로 호출
		 *    주의점 : 생성자 호출은 생성자의 첫번째 명령에서만 가능
		 */
		this("kdn", "1111", "한전KDN", "admin@kdn.co.kr", "전남 나주 빛가람동 188", "N");
	}
//	Member(String id, int password, String name, String email, String address, String withdraw){}
//	Member(String id, String name, int password, String email, String address, String withdraw){}
	Member(String id, String password, String name, String email, String address, String withdraw){
		/* this : this를 사용한 클래스로부터 생성된 객체중
		 * 		  현재 사용중인 객체를 지시하는 지시자.
		 * 1. 속성이름과 로컬 변수의 이름이 같을 때 구별하기 위해 사용
		 *    속성 앞에 this.을 붙인다.
		 * */
		// F6은 함수 안쪽까지 한줄한줄 따라가며 디버깅
		// F5는 코드라인 한줄한줄 따라가며 디버깅
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.address = address;
		this.withdraw = withdraw;
	}
	
	void memberInfo(){
		System.out.printf("id:%s\npassword:%s\nname:%s\nemail:%s\naddress:%s\nwithdraw:%s\n"
				, id
				, password
				, name
				, email
				, address
				, withdraw
				);
	}
	/** 인자로 받은 객체와 현재 객체가 같은지 비교하는 기능 */
	public boolean equals(Member member){
		/* this
		 * 3. 클래스 내에서 현재 사용 중인 객체를 지시할 때 사용
		 */
		return this == member;
	}
}
