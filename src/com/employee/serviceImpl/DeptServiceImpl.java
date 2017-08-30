package com.employee.serviceImpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.employee.dao.DeptDao;
import com.employee.domain.Dept;
import com.employee.domain.PageBean;
import com.employee.service.DeptService;
/**
 * ����ҵ����ʵ����
 * @author Administrator
 *
 */
@Transactional
public class DeptServiceImpl implements DeptService{
	
	//ע��dao
	private DeptDao deptDao;
	
	//��ҳ��ѯ����
	@Override
	public PageBean<Dept> findByPage(Integer currPage) {
		PageBean<Dept> pageBean=new PageBean<Dept>();
		//��װ��ǰҳ��
		pageBean.setCurrPage(currPage);
		//��װÿҳ��ʾ��¼��
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		//��װ�ܼ�¼��
		int totalCount=deptDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��װ��ҳ��
		double tc=totalCount;
		Double num=Math.ceil(tc/pageSize);//����ȡ��
		pageBean.setTotalPage(num.intValue());
		//��װÿҳ��ʾ������
		int begin=(currPage-1)*pageSize;
		List<Dept> list=deptDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}
	
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	/**
	 * ҵ���ʵ�ֱ���ķ���
	 */
	@Override
	public void save(Dept dept) {
		deptDao.save(dept);
		
		
	}

	/**
	 * ���ݲ��ŵ�id��ѯ����
	 */
	@Override
	public Dept findById(Integer did) {
		Dept dept=deptDao.findById(did);
		return dept;
	}

	/**
	 * ҵ����޸Ĳ��ŵķ���
	 */
	@Override
	public void update(Dept dept) {
		deptDao.update(dept);
		
	}

	/**
	 * ҵ�����ɾ�����ŵķ���
	 */
	@Override
	public void delete(Dept dept) {
		deptDao.delete(dept);
		
	}

	/**
	 * ��ѯ���в��ŵķ���
	 */
	@Override
	public List<Dept> findAll() {
		List<Dept> list=deptDao.findAll();
		
		return list;
	}

}
