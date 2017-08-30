package com.employee.daoImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.employee.dao.DeptDao;
import com.employee.domain.Dept;
/**
 * ����daoʵ����
 * @author Administrator
 *
 */
public class DeptDaoImpl extends HibernateDaoSupport implements DeptDao{

	@Override
	//��ȡ�ܼ�¼��
	public int findCount() {
		String hql="select count(*) from Dept";
		List<Long> list=this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();//ת��Ϊ���ͷ���
		}
		return 0;
	}

	@Override
	/**
	 * ��ҳ��ѯ����
	 */
	public List<Dept> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Dept.class);
		List<Dept> list=this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}

	/**
	 * dao�б��沿�ŵķ���
	 */
	@Override
	public void save(Dept dept) {
		this.getHibernateTemplate().save(dept);
		
	}
	/**
	 *dap ���ݲ���id��ѯ����
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
	 * dao��ɾ�����ŵķ���
	 */
	@Override
	public void delete(Dept dept) {
		this.getHibernateTemplate().delete(dept);
	}

	/**
	 * dao�л�ȡ���в��ŵķ���
	 */
	@Override
	public List<Dept> findAll() {
		String hql="from Dept";
		List<Dept> list=this.getHibernateTemplate().find(hql);
		return list;
	}

}
