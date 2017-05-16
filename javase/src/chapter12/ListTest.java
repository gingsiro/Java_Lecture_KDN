package chapter12;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

import chapter11.Employee;
import chapter11.Manager;

/**
 * List :
 *   - 저장한 순서대로 저장됨
 *   - index는 0부터 시작
 *   - 접근할 수 있는 index는 0 ~ size()-1
 *   - 저장할 수 있는 index는 0 ~ size() 까지
 *     => 범위 벗어나면 IndexOutOfBoundsException 발생
 *   - 중복 허용
 *   
 *   주요 메서드
 *   add(Object o) : 맨 뒤에 저장
 *   add(int index, Object o) : 지정한 index에 저장
 *   Object get(int index, Object o) : index에 해당하는 객체 추출
 *   remove(int index) : index에 해당하는 객체 삭제
 *   remove(Object o) : 해당 Object를 삭제
 *   indexOf(Object o) : 해당 객체에 저장된 index 추출 (배열 처음 부터 검색)
 *   lastIndexOf(Object o) : 해당 객체에 저장된 index 추출 (배열의 뒤에서 부터 검색)
 */

@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
public class ListTest {
	public static void main(String[] args) {
		/*
		 * JDK 1.4
		 */
//		ArrayList list = new ArrayList(7);
		LinkedList list = new LinkedList();
		
//		저장
		list.add("hello");
		list.add("world");
		list.add(256);
		list.add(3.14);
		list.add(new Employee("emp1", "홍길동", "율도국", 5000000));
		list.add(0, 1);
//		list.add(7, "java"); // 저장 가능 index 초과
		
//		추출
		System.out.println(list.get(0));
		
		Employee e = new Employee();
		e.setEmpno("emp1");
		int index = list.indexOf(e);
		System.out.println("index : " + index);
		Employee emp = (Employee)list.get(5);
		System.out.println("사원번호 : " + emp.getEmpno());
		
		/*
		 * JDK 1.5 버전 부터 Collection에 Generic이 추가 됨.
		 * Collection,Type> id = new ~
		 *   - 지정한 타입(reference라면 sub들까지)만 저장
		 *   - 추출 시 형변환 없이 추출 가능
		 */
		ArrayList<Employee> list2 = new ArrayList<Employee>(3);
		list2.add(new Employee("emp1", "kdg", "나주", 3000000));
		list2.add(new Manager("emp2", "kdg", "나주", 5000000, "사장"));
//		list2.add(10); //Employee만 저장하도록 설정했기 때문에 그외엔 저장 불가
		System.out.println(list2.get(0).toString());
		
	}
}
