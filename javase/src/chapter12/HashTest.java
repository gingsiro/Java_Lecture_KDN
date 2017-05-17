package chapter12;


import java.util.HashMap;

import chapter11.Employee;

public class HashTest {
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public static void main(String[] args) {
		HashMap map1 = new HashMap();
		
		map1.put(1, new Employee("emp1", "kdn", "나주", 3000000));
		map1.put("emp2", new Employee("emp2", "kdn", "나주", 3000000));
		System.out.println(map1);
		map1.put(1, "Hello");
		System.out.println(map1);
		
		Object o = map1.get("emp2");
		
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("empno", "emp1");
		map2.put("name", "kdn");
		map2.put("address", "나주");
		map2.put("salary", "3000000");
		
	}
}
