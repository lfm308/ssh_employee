package com.employee.action;

import com.employee.domain.Dept;
import com.employee.domain.PageBean;
import com.employee.service.DeptService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ����action
 * @author Administrator
 *
 */
public class DeptAction extends ActionSupport implements ModelDriven<Dept>{

	//ģ������
	private Dept dept=new Dept();
	//��ǰҳ��
	private Integer currPage=1;
	//ע��Service
	private DeptService deptService;
	
	@Override
	public Dept getModel() {
		return dept;
	}
	
	//�ṩһ����ѯ�ķ���
	public String findAll(){
		PageBean<Dept> pageBean=deptService.findByPage(currPage);
		//��pageBean���뵽ֵջ��
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	//��ת���������ҳ��ķ���
	public String saveUI(){
		return "saveUI";
	}
	
	//��Ӳ��ŵ�ִ�з���
	public String save(){
		deptService.save(dept);
		
		return "saveSuccess";
	}
	
	//�༭���ŵ�ִ�еķ���
	public String edit(){
		dept=deptService.findById(dept.getDid());
		return "editSuccess";
	}
	
	//�޸Ĳ��ŵ�ִ�з���
	public String update(){
		deptService.update(dept);
		
		return "updateSuccess";
	}
	
	//ɾ������ִ�еķ���
	public String delete(){
		dept=deptService.findById(dept.getDid());
		deptService.delete(dept);//��������������ɾ������������ɾ������������
		return "deleteSuccess";
	}
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
}
