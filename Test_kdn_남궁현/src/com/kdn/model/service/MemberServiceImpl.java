package com.kdn.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kdn.model.dao.MemberDao;
import com.kdn.model.dao.MemberDaoImpl;
import com.kdn.model.domain.Member;
import com.kdn.model.domain.MemberException;
import com.kdn.model.domain.PageBean;
import com.kdn.util.DBUtil;

public class MemberServiceImpl implements MemberService {
	MemberDao dao = new MemberDaoImpl();

	@Override
	public void add(Member member) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			Member find = new Member();
			find = dao.search(con, member.getId());
			if(find==null){
				dao.add(con, member);
			} else{
				throw new MemberException("이미 등록된 아이디 입니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void update(Member member) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			Member find = new Member();
			find = dao.search(con, member.getId());
			if(find!=null){
				dao.update(con, member);
			} else {
				throw new MemberException("아이디에 해당하는 회원이 없어 수정할 수 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void withdraw(String id) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			Member find = new Member();
			find = dao.search(con, id);
			if(find!=null){
				dao.update(con, id);
			} else {
				throw new MemberException("아이디에 해당하는 회원이 없어 탈퇴 처리할 수 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Member search(String id) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			Member find = new Member();
			find = dao.search(con, id);
			if(find!=null){
				return find;
			} else {
				throw new MemberException("아이디에 해당하는 회원 정보를 찾을 수 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean login(String id, String password) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			Member find = new Member();
			find = dao.search(con, id);
			if(find==null){
				throw new MemberException("해당하는 아이디는 존재하지 않습니다.");
			}
			if(find.getWithdraw().equals("N")){
				if(find.getPassword().equals(password)){
					return true;
				} else {
					throw new MemberException("비밀번호가 맞지 않습니다.");
				}
			} else{
				throw new MemberException("탈퇴한 회원 아이디입니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Member> searchAll(PageBean bean) {
		Connection con = null;
		List<Member> lists = new ArrayList<Member>();
		try {
			con = DBUtil.getConnection();
			lists = dao.searchAll(con, bean);
			if(lists!=null){
				return lists;
			} else {
				throw new MemberException("조건에 해당하는 회원 정보를 찾을 수 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
