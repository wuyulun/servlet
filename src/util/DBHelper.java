package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
   
	private static final String driver = "com.mysql.jdbc.Driver"; //驱动
	//url链接
	private static final String url="jdbc:mysql://localhost:3306/sjk?useUnicode=true&characterEncoding=UTF-8"; 
	private static final String username="root";//用户
	private static final String password="root";//密码
    
	private static Connection conn=null;
	
	//代码块加载启动
	static 
	{
		try
		{
			Class.forName(driver);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	//连接数据库
	public static Connection getConnection() throws Exception
	{
		if(conn==null)
		{
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		return conn;
	}
	
	public static void main(String[] args) {
		
		try
		{
		   Connection conn = DBHelper.getConnection();
		   if(conn!=null)
		   {
//			   System.out.println("数据库连接成功");
		   }
		   else
		   {
//			   System.out.println("数据库连接失败");
		   }
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
}
