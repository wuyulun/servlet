package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBHelper;
import bean.Dongtai;


public class DongtaiDao {

	public ArrayList<Dongtai> getAllDongtai(){//得到所有的招聘信息
		Connection conn = null;
		PreparedStatement stmt= null;
		ResultSet rs= null;
		ArrayList<Dongtai> list = new ArrayList<>();
		try {
			conn = DBHelper.getConnection();
			String sql = "select dId,dTitle,dContent from dt;";//sql语句
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()){
				Dongtai dt = new Dongtai();
				dt.setdId(rs.getInt("dId"));
				dt.setdTitle(rs.getString("dTitle"));
				dt.setdContent(rs.getString("dContent"));
//			System.out.println(news.getnId()+news.getnTitle()+news.getnContent());
				list.add(dt);
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
	
	
	public Dongtai getOneDongtai(int sb){//得到所有的招聘信息
		Connection conn = null;
		PreparedStatement stmt= null;
		ResultSet rs= null;
		
		try {
			conn = DBHelper.getConnection();
			String sql = "select dId,dTitle,dContent from dt where dId = "+sb+";";//sql语句
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			Dongtai dt = new Dongtai();
			while(rs.next()){	
				dt.setdId(rs.getInt("dId"));
				dt.setdTitle(rs.getString("dTitle"));
				dt.setdContent(rs.getString("dContent"));
//			System.out.println(news.getnId()+news.getnTitle()+news.getnContent());
			}
			return dt;
			
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
	

	public boolean UPdateDt(String z,String s,int a){//删除招聘信息
		Connection conn = null;
		PreparedStatement pstmt= null;
		String sql = "update dt set dTitle = '"+z+"',dContent ='"+s+" 'WHERE dId='"+a+"'";//sql语句
		 
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
	
	
	public boolean DelectDt(int  a){//删除动态信息
		Connection conn = null;
		PreparedStatement pstmt= null;
		String sql = "DELETE FROM dt WHERE dId="+a+"";//sql语句
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
	public boolean AddDt(String str,String q){//添加动态
		Connection conn = null;
		PreparedStatement pstmt= null;
		String sql = "insert into dt values (default,'"+ str+"','"+ q+"')";//sql语句
		
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
