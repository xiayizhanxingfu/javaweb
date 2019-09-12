# Session
>#### HTTP是无状态协议，这意味着每次客户端检索网页时，都要单独打开一个服务器连接，因此服务器不会记录下先前客户端请求的任何信息
>#### 会话,当用户打开一个浏览器连接到web应用或者打开某个页面,直到关闭浏览器这个过程叫做会话
>#### Session是保存在服务器上的数据结构，用于跟踪用户的状态。此数据可以保存在群集、数据库、文件中
## Session常用方法
>* public boolean isNew()  
返回是否为一个新的客户端，或者客户端是否拒绝加入session
>* public Enumeration getAttributeNames()  
返回session对象中所有的对象名称
>* public int getMaxInactiveInterval()  
返回最大时间间隔，以秒为单位，servlet 容器将会在这段时间内保持会话打开
>* public long getCreationTime()  
返回session对象被创建的时间， 以毫秒为单位，从1970年1月1号凌晨开始算起
>* public long getLastAccessedTime()  
返回客户端最后访问的时间，以毫秒为单位，从1970年1月1号凌晨开始算起
>* public Object getAttribute(String name)  
返回session对象中与指定名称绑定的对象，如果不存在则返回null
>* public Object getAttribute(String name)  
返回session对象中与指定名称绑定的对象，如果不存在则返回null
>* public String getId()  
返回session对象的ID
>* public void invalidate()  
将session无效化，解绑任何与该session绑定的对象
>* public void removeAttribute(String name)  
移除session中指定名称的对象
>* public void setAttribute(String name, Object value)  
使用指定的名称和值来产生一个对象并绑定到session中
>* public void setMaxInactiveInterval(int interval)  
用来指定时间，以秒为单位，servlet容器将会在这段时间内保持会话有效
## Session应用
新建SessionDemo类  
```
@WebServlet("/SessionDemo")//servlet的URL匹配模式
public class SessionDemo extends HttpServlet {
	private int count=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		count++;
		HttpSession session = request.getSession();// 获取会话
		String id = session.getId();
		long startTime = session.getCreationTime();// 会话创建时间
		long lastTime = session.getLastAccessedTime();// 获取最后访问时间
		long validTime = session.getMaxInactiveInterval();// 获取会话有效时间
		session.setMaxInactiveInterval(60);//设置会话有效时间
		SimpleDateFormat myFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//时间格式转换

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		if(session.isNew()) {//判断是否新客户
			out.println("新客户<br>");
		}else {
			out.println("不是新客户<br>");
		}
		out.println("会话ID:" + id+"<br>");
		out.println("会话创建时间:"+myFormat.format(startTime)+"<br>");
		out.println("会话有效时间:"+validTime+"秒<br>");
		out.println("当前会话有效时间:"+session.getMaxInactiveInterval()+"秒<br>");
		out.println("最后访问时间:"+myFormat.format(lastTime)+"<br>");
		out.println("访问次数:"+count+"<br>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
}
```  
