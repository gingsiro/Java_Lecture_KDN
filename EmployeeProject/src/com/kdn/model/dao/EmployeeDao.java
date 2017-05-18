package com.kdn.model.dao;

import java.sql.Connection;
import java.util.List;

import com.kdn.model.domain.Employee;
import com.kdn.model.domain.PageBean;

public interface EmployeeDao {
	public void add(Connection con, Employee emp);
	public void update(Connection con, Employee emp);
	public void remove(Connection con, String empno);
	public Employee search(Connection con, String empno);
	public List<Employee> searchAll(Connection con, PageBean bean);
	public int getCount(Connection con, PageBean bean);
}
