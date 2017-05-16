package java_workshop02;

public class NKH_Java_Workshop02_Test {

	public static void main(String[] args) {
		NKH_Java_Workshop02_Book b1 = new NKH_Java_Workshop02_Book(21424, "Java Pro", "김하나", "Jaen.kr", 15000, "Java 기본 문법");
		NKH_Java_Workshop02_Book b2 = new NKH_Java_Workshop02_Book(35355, "OOAD 분석, 설계", "소나무", "Jaen.kr", 30000, "");
		NKH_Java_Workshop02_Magazine m = new NKH_Java_Workshop02_Magazine(35535, "Java World", "편집부", "androidjava.com", 2013, 2, 7000,"");
		System.out.println("************************ 도서목록 ************************");
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(m);
	}

}
