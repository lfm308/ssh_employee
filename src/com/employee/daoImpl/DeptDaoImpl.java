package com.employee.daoImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.employee.dao.DeptDao;
import com.employee.domain.Dept;
/**
 * 部门dao实现类
 * @author Administrator
 *
 */
public class DeptDaoImpl extends HibernateDaoSupport implements DeptDao{

	@Override
	//获取总记录数
	public int findCount() {
		String hql="select count(*) from Dept";
		List<Long> list=this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();//转换为整型返回
		}
		return 0;
	}

	@Override
	/**
	 * 分页查询部门
	 */
	public List<Dept> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Dept.class);
		List<Dept> list=this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}

	/**
	 * dao中保存部门的方法
	 */
	@Override
	public void save(Dept dept) {
		this.getHibernateTemplate().save(dept);
		
	}
	/**
	 *dap 根据部门id查询部门
	 */
	@Override
	public Dept findById(Integer did) {
		
		return this.getHibernateTemplate().get(Dept.class, did);
	}

	@Override
	public void update(Dept dept) {
		this.getHibernateTemplate().update(dept);
	}

	/**
	 * dao中删除部门的方法
	 */
	@Override
	public void delete(Dept dept) {
		this.getHibernateTemplate().delete(dept);
	}

	/**
	 * dao中获取所有部门的方法
	 */
	@Override
	public List<Dept> findAll() {
		String hql="from Dept";
		List<Dept> list=this.getHibernateTemplate().find(hql);
		return list;
	}

}
