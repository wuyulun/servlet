package servlet;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

@SuppressWarnings("serial")
public class AddUser extends HttpServlet {

	
	public AddUser() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取用户填写的登录用户名
	     String username = request.getParameter("username");
        //获取用户填写的登录密码
	     String password = request.getParameter("userpass");
	     UserDao ud = new UserDao();
	     try {
			if (ud.AddUser(username, password)) {
				 request.getRequestDispatcher("/ht/Allusers.jsp").forward(request, response);
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void init() throws ServletException {
		
	}

}
