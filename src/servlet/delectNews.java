package servlet;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewsDao;


@SuppressWarnings("serial")
public class delectNews extends HttpServlet {

	
	public delectNews() {
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
	int id = Integer.parseInt(request.getParameter("nid"));
//     System.out.println("输出ID是+++++++++++"+id);
      NewsDao nd = new NewsDao();
     if (nd.DelectNews(id)) {
    	 request.getRequestDispatcher("/ht/xinwenguanli.jsp").forward(request, response);
	}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
