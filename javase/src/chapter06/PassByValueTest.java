package chapter06;

/**
 * - 자바는 대입, 인자 전달, 리턴 값 전달 방식을 PassByValue만으로 전달한다.
 * 
 * PassByValue : 값을 전달할 때 메모리에 있는 값을 전달
 * 		Primitive Type : 변수를 위해 할당된 메모리에 실제 값이 저장됨.
 * 		Reference Type : 변수를 위해 할당된 메모리에 참조 값(Hase Code)이 저장됨.
 *
 */
public class PassByValueTest {
	public static void main(String[] args) {
		int pData1 = 10;
		int pData2 = pData1;
		
		System.out.printf("pData1 : %d, pData2 : %d\n", pData1, pData2);
		pData1 += 5;
		System.out.printf("pData1 : %d, pData2 : %d\n", pData1, pData2);
		
		MyDate today1 = new MyDate(2017, 5, 11);
		MyDate today2 = today1;
		System.out.printf("today1 : %s, today2 : %s\n", today1, today2);
		today1.setDate(2017, 5, 12);
		System.out.printf("today1 : %s, today2 : %s\n", today1, today2);		
	}
}
