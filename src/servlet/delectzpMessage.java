package servlet;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import dao.ZpMessageDao;

@SuppressWarnings("serial")
public class delectzpMessage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public delectzpMessage() {
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
		int id = Integer.parseInt(request.getParameter("zpid"));
//	     System.out.println("输出ID是+++++++++++"+id);
	      ZpMessageDao zd = new ZpMessageDao();
         if (zd.DelectZpmessage(id)) {
        	 request.getRequestDispatcher("/ht/editzpxx.jsp").forward(request, response);
		}
	         
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
