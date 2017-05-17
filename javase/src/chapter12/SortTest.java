package chapter12;

import java.util.Arrays;

import chapter11.Employee;

public class SortTest {
	public static void main(String[] args) {
		int[] a1 = {4, 7, 3, 1, 9, 8, 2};
		
		Arrays.sort(a1);
		for(int i = 0 ; i < a1.length ; i++){
			System.out.println(a1[i]);
		}
		
		Employee[] emps = new Employee[5];
		emps[0] = new Employee("8", "8", "8", 1000000);
		emps[1] = new Employee("1", "1", "1", 1000000);
		emps[2] = new Employee("5", "5", "5", 1000000);
		emps[3] = new Employee("9", "9", "9", 1000000);
		emps[4] = new Employee("3", "3", "3", 1000000);
		/*
		 * Arrays.sort(Object[] o)로 정렬
		 *  - 정렬할 클래스는 Comparable 인터페이스의 compareTo를 이용해서
		 *    어떤 속성으로 정렬할지 지정해야 한다.
		 */		     
		Arrays.sort(emps);
		for(Employee employee : emps){
			System.out.println(employee);
		}
	}
}
