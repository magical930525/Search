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
		// step 1:获得DOM解析器工厂
		// 工厂的作用是创建具体的解析器
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// step 2：获得具体的dom解析器
		DocumentBuilder db = dbf.newDocumentBuilder();

		// step 3:解析一个xml文档，获得Document对象（根节点）
		// 此文档放在项目目录下即可
		Document document = db.parse(new File(path));

		// 根据标签名访问节点
		System.out.println("处理该文档的DomImplementation对象  = "
				+ document.getImplementation());
		NodeList list = document.getElementsByTagName("li");
		System.out.println("list length: " + list.getLength());

		List<News> newList = new ArrayList<News>();
		// 遍历每一个节点
		int s=read();
		for (int i = 0; i < list.getLength(); ++i) {
			News a1 = new News();
			System.out.println("----------------------");
			// 获得元素，将节点强制转换为元素
			Element element = (Element) list.item(i);
			// 此时element就是一个具体的元素

			// 获取子元素：子元素title只有一个节点，之后通过getNodeValue方法获取节点的值
			String content0 = element.getElementsByTagName("a").item(0)
					.getNodeValue();

			System.out.println(content0);// 此处打印出为null
			// 因为节点getNodeValue的值永远为null

			// 解决方法：加上getFirstChild()
			String content = element.getElementsByTagName("a").item(0)
					.getFirstChild().getNodeValue();
			System.out.println("a: " + content);// 此处打印出标题
			a1.setTitle(content);

			// 后面类似处理即可：
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
				
				System.out.println("不需要插入");
			}else{
				addNew(a1);//插入数据
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