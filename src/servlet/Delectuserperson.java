package servlet;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import dao.UserpersonDao;

@SuppressWarnings("serial")
public class Delectuserperson extends HttpServlet {

	public Delectuserperson() {
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
	int id = Integer.parseInt(request.getParameter("did"));
      UserpersonDao updDao =new UserpersonDao();
     
     if (updDao.DelectUserperson(id)) {
    	 request.getRequestDispatcher("/ht/Delectuserperson.jsp").forward(request, response);
	}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
