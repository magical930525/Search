package bean;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoginBean {


	private static int SUCCESS=1;
	private static int ERROR=2;
	private static int SAME=3;
	private ResultSet rs;
	//用户登陆通用类
	public int userLogin(String username,String password){
		String sql="select * from admin where name ='"+username+"' and password='"+password+"' ";
		DBO dbo=new DBO();
		dbo.open();
		try{
			rs=dbo.executeQuery(sql);
			if(rs.next()){//登陆验证
				return this.SUCCESS;
			}
			else{
				return this.ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return this.ERROR;
		}
		finally{
			dbo.close();
		}
	}
	//新用户注册 
	/*
	 * String name=request.getParameter("name").trim();
			String password=request.getParameter("password").trim();
			String coname=request.getParameter("coname").trim();
			String fanwei=request.getParameter("fanwei").trim();
			String lianxiren=request.getParameter("lianxiren").trim();
			String address=request.getParameter("address").trim();
			String email=request.getParameter("email").trim();
			String tel=request.getParameter("tel").trim();
	 */
	public int regUser(String name,String password,String coname,String fanwei,String lianxiren,String tel,String email,String address){
		String sql="insert into member(name,password,coname,fanwei,lianxiren,tel,email,address) values('"+name+"','"+password+"','"+coname+"','"+fanwei+"','"+lianxiren+"','"+tel+"','"+email+"','"+address+"','"+new java.util.Date().toLocaleString()+"')";
		DBO dbo=new DBO();
		dbo.open();
		try{
			rs=dbo.executeQuery("select * from member where name='"+name+"'");
			if(rs.next()){//查看是否重名
				return this.SAME;
			}
			else{
				int i=dbo.executeUpdate(sql);
				if(i==1){
					return this.SUCCESS;
				}
				else{
					return this.ERROR;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return this.ERROR;
		}finally{
			dbo.close();
		}
	}
	//得到所有用户，在后台显示
	public List getUser(){
		String sql="select * from member ";
		DBO dbo=new DBO();
		dbo.open();
		List list=new ArrayList();
		try{
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list2.add(rs.getString(4));
				list2.add(rs.getString(5));
				list2.add(rs.getString(6));
				list2.add(rs.getString(7));
				list2.add(rs.getString(8));
				list2.add(rs.getString(9));
				list2.add(rs.getString(10));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			return list;
		}finally{
			dbo.close();
		}
	}
	//增加管理员
	public int addManager(String name,String password,String type){
		String sql="insert into admin(name,password,type) values('"+name+"','"+password+"','"+type+"')";
		DBO dbo=new DBO();
		dbo.open();
		try{
			rs=dbo.executeQuery("select * from admin where name='"+name+"'");
			if(rs.next()){//查看是否重名
				return this.SAME;
			}
			else{
				int i=dbo.executeUpdate(sql);
				if(i==1){
					return this.SUCCESS;
				}
				else{
					return this.ERROR;
				}
			}			
		}catch(Exception e){
			e.printStackTrace();
			return this.ERROR;
		}finally{
			dbo.close();
		}
	}
	//获取单个用户信息
	public List getManager(int id){
		String sql="select * from admin where id='"+id+"'";
		DBO dbo=new DBO();
		dbo.open();
		List list=new ArrayList();
		try{
			rs=dbo.executeQuery(sql);
			rs.next();
			list.add(rs.getString(1));
			list.add(rs.getString(2));
			list.add(rs.getString(3));
			return list;
		}catch(Exception e){
			return list;
		}finally{
			dbo.close();
		}
	}
	//修改管理员信息
	public int upManager(int id,String password){
		String sql="update admin set password='"+password+"' where id='"+id+"'";
		DBO dbo=new DBO();
		dbo.open();
		try{		
				int i=dbo.executeUpdate(sql);
				if(i==1){
					return this.SUCCESS;
				}
				else{
					return this.ERROR;
				}			
		}catch(Exception e){
			e.printStackTrace();
			return this.ERROR;
		}finally{
			dbo.close();
		}
	}
	//查询所有管理员
	public List getAllManager(){
		String sql="select * from admin ";
		DBO dbo=new DBO();
		dbo.open();
		List list=new ArrayList();
		try{
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				List list2=new ArrayList();
				list2.add(rs.getString(1));
				list2.add(rs.getString(2));
				list2.add(rs.getString(3));
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			return list;
		}finally{
			dbo.close();
		}
	}
	//删除管理员
	public int delManager(int id){
		String sql="delete from admin where id='"+id+"'";
		DBO dbo=new DBO();
		dbo.open();
		try{			
			int i=dbo.executeUpdate(sql);
			if(i==1){
				return this.SUCCESS;
			}
			else{
				return this.ERROR;
				}
		}catch(Exception e){
			return this.ERROR;
		}finally{
			dbo.close();
		}
	}
	//删除用户
	public int delUser(int id){
		String sql="delete from member where id='"+id+"'";
		DBO dbo=new DBO();
		dbo.open();
		try{			
			int i=dbo.executeUpdate(sql);
			if(i==1){
				return this.SUCCESS;
			}
			else{
				return this.ERROR;
				}
		}catch(Exception e){
			return this.ERROR;
		}finally{
			dbo.close();
		}
	}
	//根据用户名获取用户信息
	public List getUser(String name){
		String sql="select * from member where name='"+name+"'";
		DBO dbo=new DBO();
		dbo.open();
		List list=new ArrayList();
		try{
			rs=dbo.executeQuery(sql);
			rs.next();
			list.add(rs.getString(1));
			list.add(rs.getString(2));
			list.add(rs.getString(3));
			list.add(rs.getString(4));
			list.add(rs.getString(5));
			list.add(rs.getString(6));
			list.add(rs.getString(7));
			list.add(rs.getString(8));
			list.add(rs.getString(9));
			list.add(rs.getString(10));
			return list;
		}catch(Exception e){
			return list;
		}finally{
			dbo.close();
		}
	}
	//修改用户信息
	/*
	 * String name=request.getParameter("name").trim();
			String password=request.getParameter("password").trim();
			String coname=request.getParameter("coname").trim();
			String fanwei=request.getParameter("fanwei").trim();
			String lianxiren=request.getParameter("lianxiren").trim();
			String address=request.getParameter("address").trim();
			String email=request.getParameter("email").trim();
			String tel=request.getParameter("tel").trim();
	 */
	public int upUser(String name,String password,String coname,String fanwei,String lianxiren,String tel,String email,String address){
		String sql="update member set password='"+password+"', coname='"+coname+"',bound='"+fanwei+"',linkman='"+lianxiren+"',address='"+address+"',email='"+email+"',tel='"+tel+"' where name='"+name+"'";
		DBO dbo=new DBO();
		dbo.open();
		try{
			int i=dbo.executeUpdate(sql);
			if(i==1){
				return this.SUCCESS;
			}
			else{
				return this.ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return this.ERROR;
		}finally{
			dbo.close();
		}
	}
	
}




