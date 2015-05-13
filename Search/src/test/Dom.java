package test;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import model.News;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import util.DBConnection;

public class Dom {
public static int index=0;
	
	public static List<News> read(String path) throws Exception {
		// step 1:���DOM����������
		// �����������Ǵ�������Ľ�����
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// step 2����þ����dom������
		DocumentBuilder db = dbf.newDocumentBuilder();

		// step 3:����һ��xml�ĵ������Document���󣨸��ڵ㣩
		// ���ĵ�������ĿĿ¼�¼���
		Document document = db.parse(new File(path));

		// ���ݱ�ǩ�����ʽڵ�
		System.out.println("������ĵ���DomImplementation����  = "
				+ document.getImplementation());
		NodeList list = document.getElementsByTagName("li");
		System.out.println("list length: " + list.getLength());

		List<News> newList = new ArrayList<News>();
		// ����ÿһ���ڵ�
		int s=read();
		for (int i = 0; i < list.getLength(); ++i) {
			News a1 = new News();
			System.out.println("----------------------");
			// ���Ԫ�أ����ڵ�ǿ��ת��ΪԪ��
			Element element = (Element) list.item(i);
			// ��ʱelement����һ�������Ԫ��

			// ��ȡ��Ԫ�أ���Ԫ��titleֻ��һ���ڵ㣬֮��ͨ��getNodeValue������ȡ�ڵ��ֵ
			String content0 = element.getElementsByTagName("a").item(0)
					.getNodeValue();

			System.out.println(content0);// �˴���ӡ��Ϊnull
			// ��Ϊ�ڵ�getNodeValue��ֵ��ԶΪnull

			// �������������getFirstChild()
			String content = element.getElementsByTagName("a").item(0)
					.getFirstChild().getNodeValue();
			System.out.println("a: " + content);// �˴���ӡ������
			a1.setTitle(content);

			// �������ƴ����ɣ�
			content = element.getElementsByTagName("span").item(0)
					.getFirstChild().getNodeValue();
			System.out.println("span: " + content);
			a1.setTime(content);

			content = element.getElementsByTagName("p").item(0).getFirstChild()
					.getNodeValue();
			System.out.println("p: " + content);
			a1.setP(content);

			NamedNodeMap url = element.getElementsByTagName("a").item(0)
					.getAttributes();
			String x = url.item(0).getNodeValue();
			System.out.println("href: " + x);
			a1.setUrl(x);
			System.out.println(list.getLength());
			System.out.println(s+"::::;");
			if(s==list.getLength()){
				
				System.out.println("����Ҫ����");
			}else{
				addNew(a1);//��������
			}
			newList.add(a1);
		}
		return newList;
	}
	public static int read(){
		DBConnection dbo = new DBConnection();
		dbo.open();
		String sql="select * from news";

		try {
			ResultSet rs=dbo.executeQuery(sql);
			while(rs.next()){
			    index++; 
			    System.out.println(index);
			}
		 return index;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return index;
	}
	
	public static void addNew(News news) {
		String sql = "insert into news(title,time,url,p) values('"
				+ news.getTitle() + "','" + news.getTime() + "','"
				+ news.getUrl() + "','" + news.getP() + "')";
//		System.out.println(sql);
		DBConnection dbo = new DBConnection();
		dbo.open();
		try {
			dbo.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbo.close();
		}
	}
		   
	   
}