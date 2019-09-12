# Session
>#### HTTP是无状态协议，这意味着每次客户端检索网页时，都要单独打开一个服务器连接，因此服务器不会记录下先前客户端请求的任何信息
>#### 会话,当用户打开一个浏览器连接到web应用或者打开某个页面,直到关闭浏览器这个过程叫做会话
>#### Session是保存在服务器上的数据结构，用于跟踪用户的状态。此数据可以保存在群集、数据库、文件中
>#### Session常用方法
<table>
	<tr>
		<td class="td1" style="backage-color:green">public Object getAttribute(String name)<br/>返回session对象中与指定名称绑定的对象，如果不存在则返回null</td>
	</tr>
	<tr>
		<td class="td1" style="backage-color:yellow">public Enumeration getAttributeNames()<br/>
返回session对象中所有的对象名称</td>
	</tr>
	<tr>
		<td class="td1" style="backage-color:green">public long getCreationTime()<br/>
返回session对象被创建的时间， 以毫秒为单位，从1970年1月1号凌晨开始算起</td>
	</tr>
	<tr>
		<td class="td1" style="backage-color:yellow">public String getId()<br/>
返回session对象的ID</td>
	</tr>
	<tr>
		<td class="td1" style="backage-color:green">public long getLastAccessedTime()<br/>
返回客户端最后访问的时间，以毫秒为单位，从1970年1月1号凌晨开始算起</td>
	</tr>
	<tr>
		<td class="td1" style="backage-color:yellow">public int getMaxInactiveInterval()<br/>
返回最大时间间隔，以秒为单位，servlet 容器将会在这段时间内保持会话打开</td>
	</tr>
	<tr>
		<td class="td1" style="backage-color:green">public void invalidate()<br/>
将session无效化，解绑任何与该session绑定的对象</td>
	</tr>
	<tr>
		<td class="td1" style="backage-color:yellow">public boolean isNew()<br/>
返回是否为一个新的客户端，或者客户端是否拒绝加入session</td>
	</tr>
	<tr>
		<td class="td1" style="backage-color:green">public void removeAttribute(String name)<br/>
移除session中指定名称的对象</td>
	</tr>
	<tr>
		<td class="td1" style="backage-color:yellow">public void setAttribute(String name, Object value)<br/> 
使用指定的名称和值来产生一个对象并绑定到session中</td>
	</tr>
	<tr>
		<td class="=td1" style="backage-color:green">public void setMaxInactiveInterval(int interval)<br/>
用来指定时间，以秒为单位，servlet容器将会在这段时间内保持会话有效</td>
	</tr>
</table>
