package servlet;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewsDao;

@SuppressWarnings("serial")
public class ChangeNews extends HttpServlet {

	public ChangeNews() {
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
	    //获取id值
	    int id = Integer.parseInt(request.getParameter("nid"));
	    
	 //获取新闻标题
     String ntitle = request.getParameter("ntitle");
     //获取新闻内容
     String ncontent = request.getParameter("ncontent");
//     System.out.println(id+ntitle+ncontent+"+++++++++");
     ntitle=ntitle.replaceAll(" ","&nbsp;");
     ncontent=ncontent.replaceAll("\r\n","<br/>");
     ncontent=ncontent.replaceAll(" ","&nbsp;");
     NewsDao nd = new NewsDao();
     if (nd.UPdateNews(ntitle, ncontent, id)) {
    	 request.getRequestDispatcher("/ht/xinwenguanli.jsp").forward(request, response);
	}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
