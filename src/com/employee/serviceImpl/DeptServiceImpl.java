package com.employee.serviceImpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.employee.dao.DeptDao;
import com.employee.domain.Dept;
import com.employee.domain.PageBean;
import com.employee.service.DeptService;
/**
 * 部门业务层的实现类
 * @author Administrator
 *
 */
@Transactional
public class DeptServiceImpl implements DeptService{
	
	//注入dao
	private DeptDao deptDao;
	
	//分页查询部门
	@Override
	public PageBean<Dept> findByPage(Integer currPage) {
		PageBean<Dept> pageBean=new PageBean<Dept>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示记录数
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount=deptDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc=totalCount;
		Double num=Math.ceil(tc/pageSize);//向上取整
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin=(currPage-1)*pageSize;
		List<Dept> list=deptDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}
	
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	/**
	 * 业务层实现保存的方法
	 */
	@Override
	public void save(Dept dept) {
		deptDao.save(dept);
		
		
	}

	/**
	 * 根据部门的id查询部门
	 */
	@Override
	public Dept findById(Integer did) {
		Dept dept=deptDao.findById(did);
		return dept;
	}

	/**
	 * 业务层修改部门的方法
	 */
	@Override
	public void update(Dept dept) {
		deptDao.update(dept);
		
	}

	/**
	 * 业务层中删除部门的方法
	 */
	@Override
	public void delete(Dept dept) {
		deptDao.delete(dept);
		
	}

	/**
	 * 查询所有部门的方法
	 */
	@Override
	public List<Dept> findAll() {
		List<Dept> list=deptDao.findAll();
		
		return list;
	}

}
