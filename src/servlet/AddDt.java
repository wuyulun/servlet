package servlet;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DongtaiDao;

@SuppressWarnings("serial")
public class AddDt extends HttpServlet {

	public AddDt() {
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
	 //获取新闻标题
     String dtbt = request.getParameter("dtbt");
     //获取新闻内容
     String dtcontent = request.getParameter("dtcontent");
     dtcontent=dtcontent.replaceAll("\r\n","<br/>");
     dtcontent=dtcontent.replaceAll(" ","&nbsp;");
     DongtaiDao dt = new DongtaiDao();
     if (dt.AddDt(dtbt, dtcontent)) {
    	 request.getRequestDispatcher("/ht/delectedt.jsp").forward(request, response);
	}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
