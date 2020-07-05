package cn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.model.User;

public class LoginFilter implements Filter{

	public void destroy() {
	}
	//过滤器，过滤除登录和注册操作外的页面访问,需要在web.xml中进行过滤器的配置
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = ((HttpServletRequest)request);
		HttpSession session = req.getSession();
		String contextPath = req.getContextPath();  //得到路径
		String uri = req.getRequestURI();			//uri
		int loc = uri.lastIndexOf("/");				//得到/的位置
		String page = uri.substring(loc+1);			//得到访问的文件名
		if(page.equals("index.jsp")||page.equals("register.jsp")||page.equals("changePw.jsp")){		//判断
			chain.doFilter(request, response);
		}
		else if(page.equals("orderCenter.jsp")||page.equals("addStaff.jsp")||page.equals("staffInfo.jsp")||page.equals("turnover.jsp")){
			if(session.getAttribute("user")!=null&&session.getAttribute("role")=="employer"){
				chain.doFilter(request, response);
			}
			else{
				req.setAttribute("errorMess", "没有权限");
				((HttpServletResponse)response).sendRedirect(contextPath+"/dish.jsp");
			}
		}
		else{
			if(session.getAttribute("user")!=null){
				chain.doFilter(request, response);
			}
			else{
				((HttpServletResponse)response).sendRedirect(contextPath+"/index.jsp");
			}
		}
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
