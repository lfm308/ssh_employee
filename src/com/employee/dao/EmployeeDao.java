package com.employee.dao;

import java.util.List;

import com.employee.domain.Employee;

/**
 * Ա������Dao�ӿ�
 * @author admin
 *
 */
public interface EmployeeDao {

	public Employee findByUsernameAndPassword(Employee employee);

	public int findConut();

	public List<Employee> findByPage(int begin, int pageSize);

	public void save(Employee employee);

	public Employee findById(Integer eid);

	public void update(Employee employee);

	public void delete(Employee employee);
}
