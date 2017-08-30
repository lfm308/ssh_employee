package com.employee.action;

import java.util.List;

import com.employee.domain.Dept;
import com.employee.domain.Employee;
import com.employee.domain.PageBean;
import com.employee.service.DeptService;
import com.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 员工管理Action
 * @author admin
 *
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	//模型驱动使用的对象
	private Employee employee=new Employee();
	//注入业务层的类
	private EmployeeService employeeService;
	private Integer currPage=1;
	//注入部门业务逻辑
	private DeptService deptService;
	/**
	 * 登录执行的方法
	 * @return
	 */
	public String login() {
		Employee existEmployee=employeeService.login(employee);
		if(existEmployee==null) {
			//登录失败
			this.addActionError("用户名或密码错误");
			return INPUT;
			
		}else {
			//登录成功
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
		
	}
	
	/**
	 * action中员工查询的方法
	 */
	public String findAll(){
		PageBean<Employee> pageBean=employeeService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);//存入值栈
		
		return "findAll";
	}
	
	/**
	 * 转向员工添加页面
	 * @return
	 */
	public String saveUI(){
		
		List<Dept> list=deptService.findAll();
		//将集合存入值栈，一般集合用set方法存入，而对象用push方法，这样操作比较简单
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	/**
	 * action中添加员工的方法
	 * @return
	 */
	public String save(){
		employeeService.save(employee);
		return "saveSuccess";
	}
	
	/**
	 * action中修改员工信息的方法
	 * @return
	 */
	public String edit(){
//		System.out.println("*************employee_edit.action.....");
//		System.out.println(employee.getEid());
		employee=employeeService.findById(employee.getEid());
		
		List<Dept> list=deptService.findAll();
		
//		System.out.println(list.get(0).getDname()+"************");
		ActionContext.getContext().getValueStack().set("list",list);
		
		return "editSuccess";
	}
	/**
	 * action中修改员工信息的方法
	 * @return
	 */
	public String update(){
//		System.out.println(employee.getEname()+"***********");
		employeeService.update(employee);
		return "updateSuccess";
	}
	
	/**
	 * action中删除员工的方法
	 * 
	 * @return
	 */
	public String delete(){
		employee=employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}

	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}

	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

}
