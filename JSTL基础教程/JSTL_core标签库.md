# JSTL标签库

JSTL主要有五大类标签库
 - core标签库(核心标签库),包括通用标签(输出标签),流程控制和循环控制标签
 - fmt标签库,包括格式化,国际格式化标签等
 - fn标签库,函数标签库
 - XML标签库,关于XML操作的标签库
 - SQL标签库,操作数据库标签

## core标签库用法
**使用core标签前必须添加taglie指令**
>%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

1. <c:set>在某个范围设定某个值
><c:set value="表达式" var="varname" [scope="request|page|session|application"]></c:set>

    <c:set value="${1+2 }" var="variable"></c:set>
	${variable }

2. <c:out>把表达式的结构输出到页面中
><c:out value="表达式" [escapeXml="true|false"]></c:out>

	<c:set value="${1+2 }" var="variable"></c:set>
	<c:out value="${variable }"></c:out>

3. <c:if>条件判断
><c:if test="判断条件" [var="varname"] [scope="request|page|session|application"]>
	条件为真执行的语句
</c:if>

    <c:if test="${1<2 }" var="result">
		<c:out value="${result }"></c:out>
	</c:if>

4. <c:choose>,<c:when>,<c:otherwise>流程控制标签
><c:choose>
	<c:when test="表达式">
		表达式为真执行的语句
	</c:when>
	[<c:otherwise>
		表达式为假执行的语句
	</c:otherwise>]
</c:choose>

><c:when>必须在<c:otherwise>前边,<c:choose>可以添加多个<c:choose>,类似于if else if写法

    <c:set value="8" var="variable1"></c:set>
	<c:set value="9" var="variable2"></c:set>
	<c:choose>
		<c:when test="${variable1%2==0 }">
			<c:out value="variable1:偶数"></c:out>
			<c:choose>
				<c:when test="${variable2%2==0 }">
					<c:out value="variable2:偶数"></c:out>
				</c:when>
				<c:otherwise>
					<c:out value="variable2:奇数"></c:out>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<c:out value="variable1:奇数"></c:out>
		</c:otherwise>
	</c:choose>

5. <c:forEach>迭代标签
><c:forEach [var="varname"] [varStatus="varStatusName"] [begin="开始"] [end="结束"] [step="步数"]>
		java or html code
</c:forEach>

    <table>
		<tr>
			<td>行号1</td>
			<td>行号2</td>
			<td>当前迭代项</td>
			<td>是否第一项</td>
			<td>是否最后一项</td>
			<td>结果</td>
		</tr>
		<c:forEach var="i" varStatus="j" begin="1" end="10" step="2">
			<tr>
				<td>${j.index }</td>
				<td>${j.count }</td>
				<td>${j.current }</td>
				<td>${j.first }</td>
				<td>${j.last }</td>
				<td>${i }</td>
			</tr>
		</c:forEach>
	</table>

><c:forEach item="collection" [varStatus="varStatusName" [begin="开始"] [end="结束"] [step="步数"]]>
java or heml code
</c:forEach>

    <%
		List list=new ArrayList();
		list.add("zhangsan");
		list.add("lisi");
		list.add("wangwu");
		list.add("liuliu");
		pageContext.setAttribute("collection", list);
	 %>
	<table>
		<tr>
			<td>行号1</td>
			<td>行号2</td>
			<td>当前迭代项</td>
			<td>是否第一项</td>
			<td>是否最后一项</td>
			<td>姓名</td>
		</tr>
		<c:forEach items="${collection }" var="i" varStatus="j">
			<tr>
				<td>${j.index }</td>
				<td>${j.count }</td>
				<td>${j.current }</td>
				<td>${j.first }</td>
				<td>${j.last }</td>
				<td>${i }</td>
			</tr>
		</c:forEach>
	</table>

6. <c;forTokens>字符串分割标签
><c:forTokens items="字符串" delims="分割符" [var="別名"]
> [varStatus="varStatusName"] [begin="开始"] [end="结束"] [step="步数"]>
java or html code
</c:forTokens>

    <table>
	<tr>
		<td>行号1</td>
		<td>行号2</td>
		<td>当前迭代项</td>
		<td>是否第一项</td>
		<td>是否最后一项</td>
		<td>子字符串</td>
	</tr>
	<c:forTokens items="this is a jstl code" delims=" " var="i" varStatus="j">
		<tr>
			<td>${j.index }</td>
			<td>${j.count }</td>
			<td>${j.current }</td>
			<td>${j.first }</td>
			<td>${j.last }</td>
			<td>${i }</td>
		</tr>
	</c:forTokens>
</table>

7. <c;remove>删除某个范围内的值
><c:remove var="varname" [scope="request|page|session|application"]/>

    <%
		pageContext.setAttribute("varname1", "one");
		request.setAttribute("varname2", "two");
		session.setAttribute("varname3", "three");
		application.setAttribute("varname4", "four");
	%>
	<table>
		<tr>
			<th>pageContext</th>
			<th>request</th>
			<th>session</th>
			<th>application</th>
		</tr>
		<tr>
			<td>${varname1 }</td>
			<td>${varname2 }</td>
			<td>${varname3 }</td>
			<td>${varname4 }</td>
		</tr>
	</table>
	<c:remove var="varname1"/>
	<c:remove var="varname2"/>
	<c:remove var="varname3"/>
	<c:remove var="varname4"/>
	<c:out value="删除后"></c:out><br>
	<table>
		<tr>
			<th>pageContext</th>
			<th>request</th>
			<th>session</th>
			<th>application</th>
		</tr>
		<tr>
			<td>${varname1 }</td>
			<td>${varname2 }</td>
			<td>${varname3 }</td>
			<td>${varname4 }</td>
		</tr>
	</table>

8. <c:catch>抛出异常标签
><c:catch [var="varname"]>
code
</c:catch>

    <c:catch var="error">
		<%
		int[] arr=new int[4];
		int j=arr[5];
		%>
	</c:catch>
	<c:out value="错误信息:${error }"></c:out><br>
	<c:catch var="error1">
		<%
		int j=5/0;
		 %>
	</c:catch>
	<c:out value="错误信息:${error1 }"></c:out>

9. <c:param>向导入的页面传入参数,与<c:import>结合使用
><c:param name="paramName" value="paramValue"></c:param> 
10. <c:import>导入静|动态文件
><c:import url="url" [context="context"] [var="varname"] [scope="request|page|session|application"] [charEncoding="coding"]>
	[<c:param name="paramName" [value="valueName"]></c:param>]
</c:import>

    <c:import url="https://www.baidu.com/s">
    	<c:param name="wd" value="java"/>
	</c:import>
11. <c:redirect>重定向另一个页面
><c:redirect url="url" [contex="context"]>
	[<c:param name="paramName" [value="valueName"]></c:param>]
</c:redirect>

    <c:redirect url="https://www.baidu.com/s">
    	<c:param name="wd" value="java"/>
	</c:redirect> 

12. <c:url>生成一个url
><c:url value="url" [context="context"] var="varname" [scope="request|page|session|application"]>
	[<c:param name="paramName" [value="valueName"]></c:param>]
</c:url>

    <c:url value="https://www.baidu.com/s" var="varname">
		<c:param name="wd" value="java"></c:param>
	</c:url>
	<c:out value="${varname }"></c:out>
	<br>
	<c:url value="/index.jsp" var="varname"></c:url>
	<c:out value="${varname }"></c:out>

