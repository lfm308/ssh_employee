<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="dtree.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/frame/dtree.js"></script>
</head>

<body bgColor=#DDF0FB leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
<table width="90%" border="0" cellspacing="1" cellpadding="2" align="center">
<div class="dtree">
  <script type="text/javascript">
    d=new dTree('d');

    d.add('01','-1','员工管理系统');
    d.add('0101','01','人力资源部');
    d.add('010101','0101','部门管理','${pageContext.request.contextPath }/dept_findAll.action','','right');

    d.add('010102','0101','员工管理','${pageContext.request.contextPath }/employee_findAll.action','','right');
    document.write(d);
  </script>
</div>
</table>

</body>
</html>
