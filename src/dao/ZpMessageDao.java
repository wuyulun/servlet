package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBHelper;

import bean.ZpMessage;

public class ZpMessageDao {

	public ArrayList<ZpMessage> getAllZpMessage(){//得到所有的招聘信息
		Connection conn = null;
		PreparedStatement stmt= null;
		ResultSet rs= null;
		ArrayList<ZpMessage> list = new ArrayList<>();
		try {
			conn = DBHelper.getConnection();
			String sql = "select zpid,zpname,zpcontent from zpmessage;";//sql语句
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()){
				ZpMessage zmee=new ZpMessage();
				zmee.setZpid(rs.getInt("zpid"));
				zmee.setZpname(rs.getString("zpname"));
				zmee.setZpcontent(rs.getString("zpcontent"));
//				System.out.println(zmee.getZpid()+zmee.getZpname()+zmee.getZpcontent());
				list.add(zmee);
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
	
	
	
	public ZpMessage getOneZpMessage(int zp){//得到所有的招聘信息
		Connection conn = null;
		PreparedStatement stmt= null;
		ResultSet rs= null;
		try {
			conn = DBHelper.getConnection();
			String sql = "select zpid,zpname,zpcontent from zpmessage where zpid = "+zp+";";//sql语句
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			ZpMessage zmee=new ZpMessage();
			while(rs.next()){
				
				zmee.setZpid(rs.getInt("zpid"));
				zmee.setZpname(rs.getString("zpname"));
				zmee.setZpcontent(rs.getString("zpcontent"));
//				System.out.println(zmee.getZpid()+zmee.getZpname()+zmee.getZpcontent());		
			}
			return zmee;
			
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
	
	
	public boolean UPdatezp(String z,String s,int a){//删除招聘信息
		Connection conn = null;
		PreparedStatement pstmt= null;
		String sql = "update zpmessage set zpname = '"+z+"',zpcontent ='"+s+" 'WHERE zpid='"+a+"'";//sql语句
		
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
	
	public boolean DelectZpmessage(int  a){//删除招聘信息
		Connection conn = null;
		PreparedStatement pstmt= null;
		String sql = "DELETE FROM zpmessage WHERE zpid="+a+"";//sql语句
	
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
	public boolean AddZpMessage(String str,String q){//添加招聘信息
		Connection conn = null;
		PreparedStatement pstmt= null;
		String sql = "insert into zpmessage values (default,'"+ str+"','"+ q+"')";//sql语句
	
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
