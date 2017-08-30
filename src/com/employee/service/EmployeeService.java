package com.employee.service;

import com.employee.domain.Employee;
import com.employee.domain.PageBean;

/**
 * 员工管理业务层接口
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
