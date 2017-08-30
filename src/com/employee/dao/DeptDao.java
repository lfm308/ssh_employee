package com.employee.dao;

import java.util.List;

import com.employee.domain.Dept;

/**
 * 部门dao接口
 * @author Administrator
 *
 */
public interface DeptDao {

	int findCount();

	List<Dept> findByPage(int begin, int pageSize);

	void save(Dept dept);

	Dept findById(Integer did);

	void update(Dept dept);

	void delete(Dept dept);

	List<Dept> findAll();

}
