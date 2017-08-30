package com.employee.service;

import java.util.List;

import com.employee.domain.Dept;
import com.employee.domain.PageBean;

/**
 * ����ҵ���߼��ӿ�
 * @author Administrator
 *
 */
public interface DeptService {
	
	public PageBean<Dept> findByPage(Integer currPage);

	public void save(Dept dept);

	public Dept findById(Integer did);

	public void update(Dept dept);

	public void delete(Dept dept);

	public List<Dept> findAll();

}
