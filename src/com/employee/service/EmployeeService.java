package com.employee.service;

import com.employee.domain.Employee;
import com.employee.domain.PageBean;

/**
 * Ա������ҵ���ӿ�
 * @author admin
 *
 */
public interface EmployeeService {
	
	public Employee login(Employee employee);

	public PageBean<Employee> findByPage(Integer currPage);

	public void save(Employee employee);

	public void update(Employee employee);

	public Employee findById(Integer eid);

	public void delete(Employee employee);
}
