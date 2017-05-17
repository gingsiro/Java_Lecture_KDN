package java_workshop04;

import java.util.List;

public class NKH_Java_Workshop04_Test {
	public static void main(String[] args) {
		NKH_Java_Workshop04_LibraryManagement mgr=new NKH_Java_Workshop04_LibraryManagement();
		System.out.println("====================등록=======================");
		try{
			mgr.add(new NKH_Java_Workshop04_Book("21424","Java Basic","김하나","Jaen",15000,"Java 기본 문법"));
			mgr.add(new NKH_Java_Workshop04_Book("33455","JDBC Pro  ","김철수","Jaen",23000));
			mgr.add(new NKH_Java_Workshop04_Book("55355","Servlet/JSP","박자바","kdn",41000,"Model2 기반"));
			mgr.add(new NKH_Java_Workshop04_Book("35332","Android App","홍길동","kdn",25000,"Lightweight Framework"));
			mgr.add(new NKH_Java_Workshop04_Book("35355","OOAD 분석,설계 ","소나무","소나무출판사",30000));
			mgr.add(new NKH_Java_Workshop04_Magazine("35535","Java World ","편집부","Jaen",2009,2,7000));
			mgr.add(new NKH_Java_Workshop04_Magazine("33434","Mobile World","편집부","kdn",2008,9,8000));
			mgr.add(new NKH_Java_Workshop04_Magazine("75342","Next Web    ","편집부","홍길동출판사",2007,10,10000,"AJAX 소개"));
			mgr.add(new NKH_Java_Workshop04_Magazine("76543","Architecture","편집부","홍길동출판사",2006,3,5000,"java 시스템"));
			mgr.add(new NKH_Java_Workshop04_Magazine("76534","Data Modeling","편집부","Jaen",2008,12,14000));
			mgr.add(new NKH_Java_Workshop04_Book("33455","JDBC Pro  ","김철수","Jaen",23000));
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		mgr.printAll();
		
		System.out.println("====================수정=======================");
		try{
			mgr.update(new NKH_Java_Workshop04_Magazine("35535","Java World!! ","동글양","Jaen",2009,2,7000));
			mgr.update(new NKH_Java_Workshop04_Magazine("85535","Java World!! ","동글양","Jaen",2009,2,7000));
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		mgr.printAll();
		System.out.println("====================삭제=======================");
		try{
			mgr.remove("33434");		
			mgr.remove("83434");
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		mgr.printAll();
		System.out.println("====================찾기=======================");
		try{
			System.out.println(mgr.search("76534"));
			System.out.println(mgr.search("86534"));
		} catch(Exception e){
				System.out.println(e.getMessage());
		}
		
		List<NKH_Java_Workshop04_Book> findList = mgr.searchAll(new NKH_Java_Workshop04_PageBean("publisher","Jaen"));
		
		for (NKH_Java_Workshop04_Book book : findList) {
			System.out.println(book);
		}
		System.out.println("\n*********************** 도서 목록  **************************");
		mgr.printBook();
		System.out.println("\n***********************잡지 목록 **************************");
		mgr.printMagazine();
	}
}
