package servlet;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import dao.ZpMessageDao;

@SuppressWarnings("serial")
public class AddZpMessage extends HttpServlet {

	
	public AddZpMessage() {
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
		request.setCharacterEncoding("UTF-8");
		    response.setCharacterEncoding("UTF-8");
		 //获取岗位名字
	     String gangwei = request.getParameter("gangwei");
         //获取招聘信息
	     String zpxx = request.getParameter("zpxx");
	     zpxx=zpxx.replaceAll("\r\n","<br/>");
	     zpxx=zpxx.replaceAll(" ","&nbsp;");
	     ZpMessageDao zp = new ZpMessageDao();
	     if (zp.AddZpMessage(gangwei, zpxx)) {
	    	 request.getRequestDispatcher("/ht/editzpxx.jsp").forward(request, response);
		}
	
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
