package servlet;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserpersonDao;

@SuppressWarnings("serial")
public class NewAdduserperson extends HttpServlet {

	
	public NewAdduserperson() {
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
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	     String username = request.getParameter("up");
        UserpersonDao upDao=new UserpersonDao();
	     if (upDao.AddUserperson(username)) {
	    	 request.getRequestDispatcher("/ht/Delectuserperson.jsp").forward(request, response);
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
