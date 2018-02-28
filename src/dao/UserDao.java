package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;












import util.MD5Util;
import util.DBHelper;
import bean.User;



public class UserDao {
 
    MD5Util md5Util = new MD5Util();	
	public ArrayList<User> getAllUsers(){//得到所有的用户
		Connection conn = null;
		PreparedStatement stmt= null;
		ResultSet rs= null;
		ArrayList<User> list = new ArrayList<>();
		try {
			conn = DBHelper.getConnection();
			String sql = "select userid,username,password from users;";//sql语句
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
//				user.setPassword(rs.getString(MD5.GetMD5Code("password").toString()));
//				util.MD5.GetMD5Code("password").toString();
//				System.out.println(user.getUsername()+user.getPassword()+user.getUserid());
				list.add(user);//把一个用户加入集合	
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
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
	}
	public boolean DelectUser(int a){//删除用户
		Connection conn = null;
		PreparedStatement pstmt= null;
		String sql = "DELETE FROM users WHERE userid="+a+"";//sql语句
		 try {
				conn = DBHelper.getConnection();
				pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.executeUpdate();
//				System.out.println("删除成功"+ i +"++++++");
			} catch (Exception e) {
				e.printStackTrace();
			}finally{//释放 数据集对象
				if(pstmt!=null){
					try {
						pstmt.close();
	                    pstmt=null;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		return true;
	}
	
	@SuppressWarnings("static-access")
	public boolean AddUser(String str,String q) throws Throwable  {//增加用户
		Connection conn = null;
		PreparedStatement pstmt= null;	
		String sql = "insert into users values (default,'"+ str+"','"+md5Util.md5Encode(q)+"')";//sql语句

		try {
			conn = DBHelper.getConnection();
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.executeUpdate();
//			System.out.println("++++="+ i +"++++++");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{//释放 数据集对象
			if(pstmt!=null){
				try {
					pstmt.close();
                    pstmt=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		return true;
	}
	
}
