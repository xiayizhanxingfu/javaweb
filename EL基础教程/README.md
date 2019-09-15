# EL基础教程  

## El标签语法   

>${参数名}  

## EL标签的功能  

>1. 可以访问JSP中不同的域的对象
>2. 可以访问JavaBean中的属性
>3. 可以访问集合元素
>4. 支持简单的运算操作  

### 访问JSP中不同的域的对象  

    <%
     pageContext.setAttribute("name1", "zhangsan");
     request.setAttribute("name2", "lisi");
     session.setAttribute("name3", "wangwu");
     application.setAttribute("name4", "liuliu");
     %>
	<!--范围.参数名 -->
	${pageScope.name1 } ${requestScope.name2 } ${sessionScope.name3 }
	${applicationScope.name4 }
	<br>
	<!-- 直接写参数名称 -->
	${name1 } ${name2 } ${name3 } ${name4 }

### 访问JavaBean中的属性

    <%
		User user=new User("zhangsan",20,"北京");
		request.setAttribute("user", user);
	%>
	user name:${user.name }<br> 
	user age:${user.age }<br> 
	user address:${user.address }

### 访问集合元素  

    <%
		//数组
		int[] array=new int[]{1,2,3};
		//列表
		List list=new ArrayList();
		list.add("list1");
		list.add(20);
		list.add(true);
		pageContext.setAttribute("array", array);
		pageContext.setAttribute("list", list);
	%>
	数组:${array[0] },${array[1] },${array[2] }<br> 
	List列表:${list }<br>

### 简单的运算操作  

*算术运算符:*

    2+3=${2+3 }
	2-3=${2-3 }
	2*3=${2*3 }
	2/3=${2/3 }

*逻辑运算符:*

	true&&false=${true&&false }	
	true||false=${true||false }	
	!true=${!true }	

*关系运算符:*

    2==5 ${2==5 }
	2!=5 ${2!=5 }
	2>5 ${2>5 }
	2<5 ${2<5 }
	2>=5 ${2>=5 }
	2<=5 ${2<=5 }

*其他运算符:*

    <%
		User user=new User();
		User user1=new User("zhangsan",20,"北京");
		String arr=new String();
		String[] arr1=new String[]{"one","two"};		
		
		pageContext.setAttribute("user", user);
		pageContext.setAttribute("user1", user1);
		pageContext.setAttribute("arr", arr);		
		pageContext.setAttribute("arr1", arr1);
	%>
	user 是否为空:${empty user }
	arr 是否为空:${empty arr }
	user1 是否为空:${empty user1 }
	arr1 是否为空:${empty arr1 }
	三元目运算符2<5?yes:no:${2<5?"yes":"no" }
	user1.address:${user1.address }
	arr1[1]:${arr1[1] }

## EL标签的隐形变量

>1. page <==============================> pageScope
>2. request <============================> requestScope
>3. session <============================> sessionScope
>4. application <=========================> applicationScope
>5. request.getParameter(String name) <=======> param

**A.jsp**

    <form action="B.jsp" method="get">
		<input name="name"><br> <input type="submit">
	</form>

**B.jsp**

    ${param.name }

>6. request.getParameterValues(String name) <==> paramValues

**A.jsp**

    <form action="B.jsp" method="get">
		<input name="name"><br> 
		<input name="name"><br>
		<input type="submit">
	</form>
	
**B.jsp**

    ${paramValues.name[0] },${paramValues.name[1] }

>7. request.getHeader(String name) <=========> header
>8. request.getHeaderNames() <=============> headerValues
>9. 所有请求cookie <=====================> cookie
>10. application.getInitParameter(String name)  <==> initParam
>11. pageContext

    ${pageContext.request.queryString}<!-- 获取请求名参数 -->
	${pageContext.request.requestURL}<!-- 获取请求的URL -->
	${pageContext.request.contextPath }<!-- 获取服务应用的名称 -->
	${pageContext.request.method }<!-- 获取http提交方法 -->
	${pageContext.request.protocol }<!-- 获取使用的协议 -->
	${pageContext.request.remoteUser }<!-- 获取登录用户名 -->
	${pageContext.request.remoteAddr }<!-- 获取登录用户IP地址 -->
	${pageContext.session.id }<!-- 获取session的ID -->
	${pageContext.servletContext.serverInfo }<!-- 获取主机端的服务信息 -->
