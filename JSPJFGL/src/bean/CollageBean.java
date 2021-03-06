package bean;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CollageBean {

	private static int SUCCESS=1;
	private static int ERROR=2;
	private static int SAME=3;
	private ResultSet rs;
	public int addTeacher(String name,String xueyuan,String xibie,String type){
		String sql="insert into teachercard(name,xueyuan,xibie,type,addtime) values('"+name+"','"+xueyuan+"','"+xibie+"','"+type+"','"+new java.util.Date().toLocaleString()+"')";
		DBO dbo=new DBO();
		dbo.open();
		try{
			int i=dbo.executeUpdate(sql);
				if(i==1){
					rs=dbo.executeQuery("select max(id) from teachercard");
					rs.next();
					return rs.getInt(1);
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
	public int addStu(String name,String xueyuan,String xibie,float money,String type){
		String sql="insert into stucard(name,xueyuan,xibie,money,type,addtime) values('"+name+"','"+xueyuan+"','"+xibie+"','"+money+"','"+type+"','"+new java.util.Date().toLocaleString()+"')";
		DBO dbo=new DBO();
		dbo.open();
		try{
			int i=dbo.executeUpdate(sql);
				if(i==1){
					rs=dbo.executeQuery("select max(id) from stucard");
					rs.next();
					return rs.getInt(1);
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
	public List getAllTeacher(){
		String sql="select * from teachercard order by id desc";
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
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			return list;
		}finally{
			dbo.close();
		}
	}
	public List getAllStu(){
		String sql="select * from stucard order by id desc";
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
			
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			return list;
		}finally{
			dbo.close();
		}
	}
	public List getCz(int id){
		String sql="select * from czjl where userid='"+id+"' order by id desc";
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
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return list;
		}finally{
			dbo.close();
		}
	}
	public List getTeacher(int id){
		String sql="select * from teachercard where id='"+id+"'";
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
			return list;
		}catch(Exception e){
			return list;
		}finally{
			dbo.close();
		}
	}
	public List getStu(int id){
		String sql="select * from stucard where id='"+id+"'";
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
			return list;
		}catch(Exception e){
			return list;
		}finally{
			dbo.close();
		}
	}
	public int upTeacher(int id,String name,String xueyuan,String xibie){
		String sql="update teachercard  set name='"+name+"',xueyuan='"+xueyuan+"',xibie='"+xibie+"' where id='"+id+"'";
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
	public int upStu(int id,String name,String xueyuan,String xibie,float money){
		String sql="update stucard  set name='"+name+"',xueyuan='"+xueyuan+"',xibie='"+xibie+"',money='"+money+"' where id='"+id+"'";
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
	public int chongZhi(int id,float money){
		String sql="select money from stucard where id='"+id+"'";
		DBO dbo=new DBO();
		dbo.open();
		try{
			//�����ֵ��ϸ��
			dbo.executeUpdate("insert into czjl(userid,money,addtime) values('"+id+"','"+money+"','"+new java.util.Date().toLocaleString()+"')");
			rs=dbo.executeQuery(sql);
			rs.next();
			money+=rs.getFloat(1);
			int i=dbo.executeUpdate("update stucard set money='"+money+"' where id='"+id+"'");
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
	public int delTeacher(int id){
		String sql="delete from teachercard where id='"+id+"'";
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
	public int delStu(int id){
		String sql="delete from stucard where id='"+id+"'";
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
	public int delCz(int id){
		String sql="delete from czjl where id='"+id+"'";
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
