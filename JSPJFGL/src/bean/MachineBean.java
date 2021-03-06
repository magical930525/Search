package bean;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MachineBean {

	private static int SUCCESS=1;
	private static int ERROR=2;
	private static int SAME=3;
	private ResultSet rs;
	public int chongZhi(float biaozhun){
		String sql="insert into biaozhun(biaozhun) values('"+biaozhun+"')";
		DBO dbo=new DBO();
		dbo.open();
		try{
			rs=dbo.executeQuery("select * from biaozhun");
			if(rs.next()){
				int i=dbo.executeUpdate("update biaozhun set biaozhun='"+biaozhun+"'");
				if(i==1){
					return this.SUCCESS;
				}
				else{
					return this.ERROR;
				}	
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
	public float getBiaoZhun(){
		String sql="select biaozhun from biaozhun";
		DBO dbo=new DBO();
		dbo.open();
		try{
			rs=dbo.executeQuery(sql);
			if(rs.next()){
				return rs.getFloat(1);
			}
			else{
				return 1000;
			}
		}catch(Exception e){
			e.printStackTrace();
			return 1000;
		}finally{
			dbo.close();
		}
	}
	public int addSheBeiWeiHu(String shebei,String yuanyin,String weihu,String shijian){
		String sql="insert into shebeiweihu(shebei,yuanyin,weihu,shijian) values('"+shebei+"','"+yuanyin+"','"+weihu+"','"+shijian+"')";
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
	public int upSheBeiWeiHu(int id,String shebei,String yuanyin,String weihu,String shijian){
		String sql="update shebeiweihu set shebei='"+shebei+"',yuanyin='"+yuanyin+"',weihu='"+weihu+"',shijian='"+shijian+"' where id='"+id+"'";
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
	public int addZhiBan(String name,String kaishi,String jieshu){
		String sql="insert into zhiban(name,kaishi,jieshu) values('"+name+"','"+kaishi+"','"+jieshu+"')";
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
	public int upZhiBan(int id,String name,String kaishi,String jieshu){
		String sql="update zhiban set name='"+name+"',kaishi='"+kaishi+"',jieshu='"+jieshu+"' where id='"+id+"'";
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
	public List getWeiHu(int id){
		String sql="select * from shebeiweihu where id='"+id+"'";
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
	public List getZhiBan(int id){
		String sql="select * from zhiban where id='"+id+"'";
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
			return list;
		}catch(Exception e){
			return list;
		}finally{
			dbo.close();
		}
	}
	public List getStuCard(){
		String sql="select id from stucard ";
		DBO dbo=new DBO();
		dbo.open();
		List list=new ArrayList();
		try{
			rs=dbo.executeQuery(sql);
			while(rs.next()){
				list.add(rs.getString(1));
			}
			return list;
		}catch(Exception e){
			return list;
		}finally{
			dbo.close();
		}
	}
	public List getAllSheBeiWeiHu(){
		String sql="select * from shebeiweihu order by id desc";
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
				list.add(list2);
			}
			return list;
		}catch(Exception e){
			return list;
		}finally{
			dbo.close();
		}
	}
	public int delSheBeiWeiHu(int id){
		String sql="delete from shebeiweihu where id='"+id+"'";
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
	public List getAllZhiBan(){
		String sql="select * from zhiban order by id desc";
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
			return list;
		}finally{
			dbo.close();
		}
	}
	public List getAllLiShiJiLu(){
		String sql="select * from xiaofeijilu order by id desc";
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
	public List getAllLiShiJiLu(int cardid){
		String sql="select * from xiaofeijilu where cardid='"+cardid+"' order by id desc";
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
	public int delZhiBan(int id){
		String sql="delete from zhiban where id='"+id+"'";
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
	public int delLSJL(int id){
		String sql="delete from xiaofeijilu where id='"+id+"'";
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
	public int delShuaKa(int id){
		String sql="delete from shuaka where id='"+id+"'";
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
	public int shuaKa(int cardid,int jiqihao,float ffff){
		long kaishi=System.currentTimeMillis();
		String kaishi2=new java.util.Date().toLocaleString();
		String sql="insert into shuaka(cardid,kaishi,kaishi2,jieshu,jieshu2,jiqihao) values('"+cardid+"','"+kaishi+"','"+kaishi2+"','0','0','"+jiqihao+"')";
		DBO dbo=new DBO();
		dbo.open();
		try{
			ResultSet rs3=dbo.executeQuery("select * from shuaka where cardid='"+cardid+"'");
			if(rs3.next()){
				return 8888888;
			}
			else{
				rs=dbo.executeQuery("select money from stucard where id='"+cardid+"'");
				rs.next();
				float f=rs.getFloat(1);
				ResultSet rs2=dbo.executeQuery("select sum(feiyong) from xiaofeijilu where cardid='"+cardid+"'");
				rs2.next();
				float ff=rs2.getFloat(1);
				if(f-ff<=ffff){
					return 9999999;
				}
				else{
					int i=dbo.executeUpdate(sql);
					if(i==1){
						return 666666;
					}
					else{
						return 777777;
					}		
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			return this.ERROR;
		}finally{
			dbo.close();
		}
	}
	public int xiaJi(int id,float biaozhun){
		long jieshu=System.currentTimeMillis();
		String jieshu2=new java.util.Date().toLocaleString();
		String sql="update shuaka set jieshu='"+jieshu+"',jieshu2='"+jieshu2+"' where id='"+id+"'";
		DBO dbo=new DBO();
		dbo.open();
		try{
			int i=dbo.executeUpdate(sql);
				if(i==1){
					rs=dbo.executeQuery("select * from shuaka where id='"+id+"'");
					rs.next();
					String id2=rs.getString(1);
					String carid=rs.getString(2);
					String kaishi=rs.getString(3);
					String kaishi2=rs.getString(4);
					String jieshu22=rs.getString(5);
					String jieshu222=rs.getString(6);
					String jiqihao=rs.getString(7);
					float f=(Long.parseLong(jieshu22)-Long.parseLong(kaishi))/60000*biaozhun;
					dbo.executeUpdate("insert into xiaofeijilu(cardid,kaishi,jieshu,jishi,feiyong,jiqihao) values('"+carid+"','"+kaishi2+"','"+jieshu222+"','"+(Long.parseLong(jieshu22)-Long.parseLong(kaishi))/60000+"','"+f+"','"+jiqihao+"')");
					dbo.executeUpdate("delete from shuaka where id='"+id+"'");
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
	public List getAllShuaKa(){
		String sql="select shuaka.*,stucard.money from shuaka,stucard where shuaka.cardid=stucard.id order by shuaka.id desc";
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
	public float getShouFeiBiaoZhun(){
		String sql="select biaozhun from biaozhun";
		DBO dbo=new DBO();
		dbo.open();
		try{
			rs=dbo.executeQuery(sql);
			if(rs.next()){
				return rs.getFloat(1);
			}
			else{
				return 0;
			}
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dbo.close();
		}
	}
	public float getYuE(int cardid){
		String sql="select sum(feiyong) from xiaofeijilu where cardid='"+cardid+"'";
		DBO dbo=new DBO();
		dbo.open();
		try{
			rs=dbo.executeQuery(sql);
			if(rs.next()){
				return rs.getFloat(1);
			}
			else{
				return 0;
			}
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dbo.close();
		}
	}
	public float getZongJinE(int cardid){
		String sql="select money from stucard where id='"+cardid+"'";
		DBO dbo=new DBO();
		dbo.open();
		try{
			rs=dbo.executeQuery(sql);
			if(rs.next()){
				return rs.getFloat(1);
			}
			else{
				return 0;
			}
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			dbo.close();
		}
	}
}
