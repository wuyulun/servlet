package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import util.DBHelper;
import util.MD5Util;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	
	public LoginServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	@SuppressWarnings("static-access")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MD5Util md5Util = new MD5Util();
		//获取用户填写的登录用户名
	     String password1 = request.getParameter("password");
	     String usename = request.getParameter("login");
     //获取用户填写的登录密码
//	     String password = request.getParameter("password");
	     //设置user用户，用于会话操作
	     String password;
		try {
//			password = md5Util.md5Encode(password1);
			 User user = new User();
		     user.setPassword(password1);;
		     user.setUsername(usename);;
		  
		       //用户登录
		        Connection conn = null;
				PreparedStatement stmt= null;
				ResultSet rs= null;
				try {
					conn = DBHelper.getConnection();
					String sql = "select username from Users where password='" + password1 + "'";//sql语句
					stmt=conn.prepareStatement(sql);
					rs=stmt.executeQuery();
					if(rs.next()){
						//登录成功后，就将用户存储到session中
						request.getSession().setAttribute("user", user);
				        String message = String.format(
				               "恭喜：%s,登陆成功！本页将在3秒后跳到首页！！<meta http-equiv='refresh' content='3;url=%s'", 
				               user.getUsername(),request.getContextPath()+"/ht/index.jsp");
				        request.setAttribute("message",message);
					       request.getRequestDispatcher("/message.jsp").forward(request, response);
					}else{
						String message = String.format(
				                   "对不起，用户名或密码有误！！请重新登录！2秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='2;url=%s'", 
				                   request.getContextPath()+"/servlet/LoginUIUI");
					          request.setAttribute("message",message);
				            request.getRequestDispatcher("/message.jsp").forward(request, response);
					            return;
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally{//释放 数据集对象
					if(rs!=null){
						try {
							rs.close();
							rs=null;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(stmt!=null){
						try {
							stmt.close();
							stmt=null;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
