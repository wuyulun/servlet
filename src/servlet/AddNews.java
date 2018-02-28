package servlet;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewsDao;


@SuppressWarnings("serial")
public class AddNews extends HttpServlet {

	
	public AddNews() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
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
     String ntitle = request.getParameter("ntitle");
     //获取新闻内容
     String ncontent = request.getParameter("ncontent");
     ncontent=ncontent.replaceAll("\r\n","<br/>");
     ncontent=ncontent.replaceAll(" ","&nbsp;");
     NewsDao nd = new NewsDao();
     if (nd.AddNews(ntitle, ncontent)) {
    	 request.getRequestDispatcher("/ht/xinwenguanli.jsp").forward(request, response);
	}
	}

	public void init() throws ServletException {
		
	}

}