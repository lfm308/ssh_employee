package com.employee.serviceImpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.employee.dao.EmployeeDao;
import com.employee.domain.Employee;
import com.employee.domain.PageBean;
import com.employee.service.EmployeeService;
/**
 * 关公管理业务层实现类
 * @author admin
 *
 */
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	//注入dao中的类
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
	 * emp业务逻辑中分页查询多有的员工
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
	 * service中添加员工的方法
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
	 * service中通过id查询员工的方法
	 */
	@Override
	public Employee findById(Integer eid) {
		Employee employee=employeeDao.findById(eid);
		
		return employee;
	}

	/**
	 * service层删除员工的方法
	 */
	@Override
	public void delete(Employee employee) {
		employeeDao.delete(employee);
	}
	
}
