package com.employee.action;

import com.employee.domain.Dept;
import com.employee.domain.PageBean;
import com.employee.service.DeptService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 部门action
 * @author Administrator
 *
 */
public class DeptAction extends ActionSupport implements ModelDriven<Dept>{

	//模型驱动
	private Dept dept=new Dept();
	//当前页面
	private Integer currPage=1;
	//注入Service
	private DeptService deptService;
	
	@Override
	public Dept getModel() {
		return dept;
	}
	
	//提供一个查询的方法
	public String findAll(){
		PageBean<Dept> pageBean=deptService.findByPage(currPage);
		//将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	//跳转到部门添加页面的方法
	public String saveUI(){
		return "saveUI";
	}
	
	//添加部门的执行方法
	public String save(){
		deptService.save(dept);
		
		return "saveSuccess";
	}
	
	//编辑部门的执行的方法
	public String edit(){
		dept=deptService.findById(dept.getDid());
		return "editSuccess";
	}
	
	//修改部门的执行方法
	public String update(){
		deptService.update(dept);
		
		return "updateSuccess";
	}
	
	//删除部门执行的方法
	public String delete(){
		dept=deptService.findById(dept.getDid());
		deptService.delete(dept);//按照整个部门做删除操作，可以删除级联的数据
		return "deleteSuccess";
	}
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
}
