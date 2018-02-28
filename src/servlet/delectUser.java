package servlet;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

@SuppressWarnings("serial")
public class delectUser extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public delectUser() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		     int id = Integer.parseInt(request.getParameter("userid"));
//		     System.out.println("输出ID是+++++++++++"+id);
             UserDao ud=new UserDao();
             if (ud.DelectUser(id)) {
            	 request.getRequestDispatcher("/ht/Allusers.jsp").forward(request, response);
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
              doGet(request, response);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
