package chapter06;
/**
 * 배열 : 변수 하나에 여러개의 공간을 할당해서 동일한 데이터만 저장
 *   - 자바는 모든 타입을 배열로 선언할 수 있고 배열로 선언하면
 *     Reference Type이 된다.
 *   - 배열을 생성하면 length라는 속성이 생기고 배열의 크기를 표현한다.
 *   - 배열을 생성하면 크기 변경이 안됨.
 *   - 배열을 생성하면 기본 값으로 초기화 됨.
 *     정수 : 0, 실수 : 0.0, 논리 : false, 문자 : \u0000, 참조 : null
 *   - 배열의 공간은 index로 구별하며 index는 0부터 시작
 *   - 배열의 접근은 0번부터 length-1까지 접근
 *     범위를 벗어나면 ArrayIndexOutOfBoundsException 
 *   - 선언
 *     DataType[] id; or DataType id [];
 *   - 생성
 *     id = new DataType[size];
 *   - 접근
 *     id[index] = value;
 *   
 */
public class ArrayTest1 {

	public static void main(String[] args) {
		int[] array1;
		MyDate[] array2;
		
		array1 = new int[3];
		array2 = new MyDate[2]; //배열 객체 생성
		
		array1[0] = 10;
		array1[1] = 20;
		
		MyDate d1 = new MyDate(2017, 5, 10);
		array2[0] = new MyDate(2017, 5, 11);
		array2[1] = d1;
		
		for (int i = 0; i < array1.length; i++) {
			System.out.println(array1[i]);
		}
		for (int i = 0; i < array2.length; i++) {
			System.out.println(array2[i]);
		}
	}

}
