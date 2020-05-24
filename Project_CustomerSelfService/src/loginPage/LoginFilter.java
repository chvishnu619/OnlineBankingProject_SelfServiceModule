package loginPage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(servletNames = { "Login" },urlPatterns= {"/Login"})
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserDAO userDAO=new UserDAO();
		ArrayList<User> list=new ArrayList<User>();
		try
		{
			list.addAll(userDAO.getUserList());
		}
		catch(ClassNotFoundException | SQLException cs)
		{
			System.out.println(cs);
		}
		boolean valid=false;
		Iterator<User> li=list.iterator();
		while(li.hasNext())
		{
			User x=(User) li.next();
			if(x.getUsername().equals(username))
			{
				if(x.getPassword().equals(password))
				{
					valid=true;
					request.getServletContext().setAttribute("customer", x);
					break;
				}
			}
		}
		// pass the request along the filter chain
		if(valid==true)
		{
			chain.doFilter(request, response);
		}
		else
		{
			response.setContentType("text/html");
			out.println("<h3 style='color:red'>Incorrect username/password</h3>");
			request.getRequestDispatcher("LoginPage.jsp").include(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
