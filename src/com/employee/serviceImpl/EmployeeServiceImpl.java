package com.employee.serviceImpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.employee.dao.EmployeeDao;
import com.employee.domain.Employee;
import com.employee.domain.PageBean;
import com.employee.service.EmployeeService;
/**
 * �ع�����ҵ���ʵ����
 * @author admin
 *
 */
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	//ע��dao�е���
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public Employee login(Employee employee) {
		Employee existEmployee=employeeDao.findByUsernameAndPassword(employee);
		return existEmployee;
	}

	/**
	 * empҵ���߼��з�ҳ��ѯ���е�Ա��
	 */
	@Override
	public PageBean<Employee> findByPage(Integer currPage) {
		PageBean<Employee> pageBean=new PageBean<Employee>();
		
		pageBean.setCurrPage(currPage);
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		int totalCount=employeeDao.findConut();
		pageBean.setTotalCount(totalCount);
		double tc=totalCount;
		Double num=Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		int begin=(currPage-1)*pageSize;
		List<Employee> list=employeeDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	/**
	 * service�����Ա���ķ���
	 */
	@Override
	public void save(Employee employee) {
		
		employeeDao.save(employee);
		
	}

	@Override
	public void update(Employee employee) {
		
		employeeDao.update(employee);
	}

	/**
	 * service��ͨ��id��ѯԱ���ķ���
	 */
	@Override
	public Employee findById(Integer eid) {
		Employee employee=employeeDao.findById(eid);
		
		return employee;
	}

	/**
	 * service��ɾ��Ա���ķ���
	 */
	@Override
	public void delete(Employee employee) {
		employeeDao.delete(employee);
	}
	
}
