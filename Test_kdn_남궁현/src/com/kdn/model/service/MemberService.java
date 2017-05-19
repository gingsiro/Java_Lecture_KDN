package com.kdn.model.service;

import java.util.List;

import com.kdn.model.domain.Member;
import com.kdn.model.domain.PageBean;

public interface MemberService {
	public void add(Member member);
	public void update(Member member);
	public void withdraw(String id);
	public Member search(String id);
	public boolean login(String id, String password);
	public List<Member> searchAll(PageBean bean);
}
