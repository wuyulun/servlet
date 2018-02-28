package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBHelper;
import bean.News;


public class NewsDao {
      
	public ArrayList<News> getAllNews(){//得到所有的招聘信息
		Connection conn = null;
		PreparedStatement stmt= null;
		ResultSet rs= null;
		ArrayList<News> list = new ArrayList<>();
		try {
			conn = DBHelper.getConnection();
			String sql = "select nId,nTitle,nContent from news;";//sql语句
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()){
				News news=new News();
				news.setnId(rs.getInt("nId"));
				news.setnTitle(rs.getString("nTitle"));
				news.setnContent(rs.getString("nContent"));
//			System.out.println(news.getnId()+news.getnTitle()+news.getnContent());
				list.add(news);
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
	
	public News getOneNews(int b){//得到所有的招聘信息
		Connection conn = null;
		PreparedStatement stmt= null;
		ResultSet rs= null;
		try {
			conn = DBHelper.getConnection();
			String sql = "select nId,nTitle,nContent from news where nId = "+b+";";//sql语句
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			News news=new News();
			while(rs.next()){
				news.setnId(rs.getInt("nId"));
				news.setnTitle(rs.getString("nTitle"));
				news.setnContent(rs.getString("nContent"));
//			System.out.println(news.getnId()+news.getnTitle()+news.getnContent());
			}
			return news;
			
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
	
	public boolean UPdateNews(String z,String s,int a){//删除招聘信息
		Connection conn = null;
		PreparedStatement pstmt= null;
		String sql = "update news set nTitle = '"+z+"',nContent ='"+s+" 'WHERE nId='"+a+"'";//sql语句
		
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
	
	
	
	public boolean DelectNews(int  a){//删除招聘信息
		Connection conn = null;
		PreparedStatement pstmt= null;
		String sql = "DELETE FROM news WHERE nId="+a+"";//sql语句
	
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
	public boolean AddNews(String str,String q){//添加招聘信息
		Connection conn = null;
		PreparedStatement pstmt= null;
		String sql = "insert into news values (default,'"+ str+"','"+ q+"')";//sql语句
		
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
