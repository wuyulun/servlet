package servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.ZpMessageDao;

@SuppressWarnings("serial")
public class ChangeZpxx extends HttpServlet {

	
	public ChangeZpxx() {
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
	    int id = Integer.parseInt(request.getParameter("zpid"));
	    
	 //获取新闻标题
     String ntitle = request.getParameter("ntitle");
     //获取新闻内容
     String ncontent = request.getParameter("ncontent");
//     System.out.println(id+ntitle+ncontent+"+++++++++");
     ntitle=ntitle.replaceAll(" ","&nbsp;");
     ncontent=ncontent.replaceAll("\r\n","<br/>");
     ncontent=ncontent.replaceAll(" ","&nbsp;");
     ZpMessageDao zpMessageDao = new ZpMessageDao();
     if (zpMessageDao.UPdatezp(ntitle, ncontent, id)) {
    	 request.getRequestDispatcher("/ht/editzpxx.jsp").forward(request, response);
	}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
