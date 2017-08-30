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
 * Ա������Action
 * @author admin
 *
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	//ģ������ʹ�õĶ���
	private Employee employee=new Employee();
	//ע��ҵ������
	private EmployeeService employeeService;
	private Integer currPage=1;
	//ע�벿��ҵ���߼�
	private DeptService deptService;
	/**
	 * ��¼ִ�еķ���
	 * @return
	 */
	public String login() {
		Employee existEmployee=employeeService.login(employee);
		if(existEmployee==null) {
			//��¼ʧ��
			this.addActionError("�û������������");
			return INPUT;
			
		}else {
			//��¼�ɹ�
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
		
	}
	
	/**
	 * action��Ա����ѯ�ķ���
	 */
	public String findAll(){
		PageBean<Employee> pageBean=employeeService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);//����ֵջ
		
		return "findAll";
	}
	
	/**
	 * ת��Ա�����ҳ��
	 * @return
	 */
	public String saveUI(){
		
		List<Dept> list=deptService.findAll();
		//�����ϴ���ֵջ��һ�㼯����set�������룬��������push���������������Ƚϼ�
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	/**
	 * action�����Ա���ķ���
	 * @return
	 */
	public String save(){
		employeeService.save(employee);
		return "saveSuccess";
	}
	
	/**
	 * action���޸�Ա����Ϣ�ķ���
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
	 * action���޸�Ա����Ϣ�ķ���
	 * @return
	 */
	public String update(){
//		System.out.println(employee.getEname()+"***********");
		employeeService.update(employee);
		return "updateSuccess";
	}
	
	/**
	 * action��ɾ��Ա���ķ���
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
