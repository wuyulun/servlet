package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBHelper;
import bean.Userperson;

public class UserpersonDao {
    
	public ArrayList<Userperson> getAllUserperson(){//得到所有的用户
		Connection conn = null;
		PreparedStatement stmt= null;
		ResultSet rs= null;
		ArrayList<Userperson> list = new ArrayList<>();
		try {
			conn = DBHelper.getConnection();
			String sql = "select upid,upcontent from useperson;";//sql语句
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()){
				Userperson user =new Userperson();
				user.setUpid(rs.getInt("upid"));
				user.setUpcontent(rs.getString("upcontent"));
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
	public boolean DelectUserperson(int a){//删除用户
		Connection conn = null;
		PreparedStatement pstmt= null;
		String sql = "DELETE FROM useperson WHERE upid="+a+"";//sql语句

		 try {
				conn = DBHelper.getConnection();
				pstmt = (PreparedStatement) conn.prepareStatement(sql);
				pstmt.executeUpdate();
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
	public boolean AddUserperson(String q){//增加用户
		Connection conn = null;
		PreparedStatement pstmt= null;
		String sql = "insert into useperson values (default,'"+ q+"')";//sql语句
	
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
