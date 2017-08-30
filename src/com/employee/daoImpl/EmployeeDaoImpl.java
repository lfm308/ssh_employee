package com.employee.daoImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.employee.dao.EmployeeDao;
import com.employee.domain.Employee;
/**
 * 员工管理dao实现类
 * @author admin
 *
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao{

	/**
	 * 根据用户名密码查询用户的方法
	 */
	@Override
	public Employee findByUsernameAndPassword(Employee employee) {
		
		String hql="from Employee where username=? and password=?";
		List<Employee> list=this.getHibernateTemplate().find(hql,employee.getUsername(),employee.getPassword());
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	/**
	 * dao中获取所有员工数
	 */
	public int findConut() {
		String hql="select count(*) from Employee";
		List<Long> list=this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	/**
	 * dao中分页查询所有员工
	 */
	@Override
	public List<Employee> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Employee.class);
		List<Employee> list=this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}

	/**
	 * dao中添加员工的方法
	 */
	@Override
	public void save(Employee employee) {
		
		this.getHibernateTemplate().save(employee);
	}
	/**
	 * dao中通过id查询员工信息
	 */
	@Override
	public Employee findById(Integer eid) {
		
		return this.getHibernateTemplate().get(Employee.class,eid);
	}

	@Override
	public void update(Employee employee) {
		
		this.getHibernateTemplate().update(employee);
		
	}

	/**
	 * dao中删除员工的方法
	 */
	@Override
	public void delete(Employee employee) {

		this.getHibernateTemplate().delete(employee);
	}

}
