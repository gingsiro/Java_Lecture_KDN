package com.kdn;

import java.util.List;

import com.kdn.model.domain.Member;
import com.kdn.model.domain.PageBean;
import com.kdn.model.service.MemberService;
import com.kdn.model.service.MemberServiceImpl;

public class Test {
	public static void print(List<Member> members){
		for (Member member : members) {
			System.out.println(member);
		}
	}
	public static void main(String[] args) {
		MemberService service = new MemberServiceImpl();
		System.out.println("======================회원 등록=======================");
		try {
			service.add(new Member("kdn", "1111", "한전KDN", "admin@kdn.com", "나주"));
			service.add(new Member("kdg", "1111", "김동근", "kdg@androidjava.com", "서울"));
			service.add(new Member("hong", "1212", "홍길동", "hong@androidjava.com", "서울"));
			service.add(new Member("kdn", "1111", "한전KDN", "admin@kdn.com", "나주"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("===================등록된 회원 정보====================");		
		print(service.searchAll(new PageBean(null, null)));
		System.out.println("====================회원 정보 수정=====================");	
		try{
			service.update(new Member("kdn", "4321", "한전kdn", "admin@kdn.com", "전남 나주시 빛가람동"));
			service.update(new Member("kkk", "4321", "한전kdn", "admin@kdn.com", "전남 나주시 빛가람동"));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("===================수정된 회원 정보====================");	
		System.out.println(service.search("kdn"));
		
		System.out.println("====================회원 목록 조회=====================");	
		print(service.searchAll(new PageBean("address", "서울")));
		System.out.println("=======================탈퇴하기=======================");	
		service.withdraw("hong");
		System.out.println("=======================로긴하기=======================");	
		try {
			boolean result = service.login("hong", "1212");
			if(result){
				System.out.println("인증 됐습니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			boolean result = service.login("kkk", "1111");
			if(result){
				System.out.println("인증 됐습니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			boolean result = service.login("kdn", "1111");
			if(result){
				System.out.println("인증 됐습니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			boolean result = service.login("kdn", "4321");
			if(result){
				System.out.println("인증 됐습니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
