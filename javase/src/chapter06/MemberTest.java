package chapter06;

public class MemberTest {

	public static void main(String[] args) {
		//객체 생성 방법 : new 생성자([args]);
		//객체 생성에서 속성은 초기화 안되어있어도 초기화 되어있음
//		String name;
//		System.out.println(name);
		
		new Member().memberInfo();
		System.out.println();
		
//		Member m = new Member();
//		m.id = "kdn";
//		m.password = "1111";
//		m.name = "한전kdn";
//		m.email = "admin@kdn.co.kr";
//		m.address = "전남 나주 빛가람동 188";
//		m.withdraw = "N";
		
		Member m = new Member("kdn", "1111", "한전KDN", "admin@kdn.co.kr", "전남 나주 빛가람동 188", "N");
		m.memberInfo();
		System.out.println();
		
		Member m2 = new Member("1", "1", "1", "1", "1", "1");
		m2.memberInfo();
		System.out.println();
		
		System.out.println(m2.equals(m));
	}
	
}
