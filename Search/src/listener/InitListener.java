package listener;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import test.Dom;
import test.test;

public class InitListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void contextInitialized(ServletContextEvent arg0) {
		test t = new test("file:///D:/myeclipse/workspace/Search/src/test/News.html", "D:/myeclipse/workspace/Search/WebRoot/file/News.xml", "Error.htm");         
		t.convert();  
		try {
			Dom.read("D:/myeclipse/workspace/Search/WebRoot/file/News.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("准备完成");
}
}
