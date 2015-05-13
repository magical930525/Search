package test;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import org.w3c.tidy.Tidy;

public class test {    
	private String url;    
	private String outFileName; 
	private String errOutFileName;     
	public test(String url, String outFileName, String errOutFileName) {          
		this.url = url; //目标页面地址
		this.outFileName = outFileName; //输出文件的地址和名称          
		this.errOutFileName = errOutFileName; //输出错误文件的地址和名称     
		}
	public void convert() {         
		URL u;          
		BufferedInputStream in;        
		FileOutputStream out;           
		Tidy tidy = new Tidy();          
		tidy.setXmlOut(true);          
	tidy.setXmlPi(true);   //添加 <?xml?> 标签 为输出的 XML 文件， 这些参数是可选的。
	tidy.setXmlSpace(true);          
	tidy.setInputEncoding("UTF-8"); //这个很重要，如果没有它，就会出现中文乱码 
	try {  
		//错误文件的输入地址和名称            
		tidy.setErrout(new PrintWriter(new FileWriter(errOutFileName), true));           
		u = new URL(url);   //建立输入和输出文件             
		in = new BufferedInputStream(u.openStream());             
		out = new FileOutputStream(outFileName);
		//文件转换              
		tidy.parse(in, out); //资源释放             
		in.close();          
		out.close();           
		} catch (IOException e) {              
		System.out.println(this.toString() + e.toString());         }    
	}

public static void main(String[] args) { 
	/*  
	 * 
	 * * Parameters are:
	 *  * URL of HTML file  
	 *  * Filename of output file 
	 *  * Filename of error file 
	 *  */          
	test t = new test("file:///D:/myeclipse/workspace/Search/src/test/News.html", "D:/myeclipse/workspace/Search/WebRoot/file/News.xml", "Error.htm");         
	t.convert();   
	} 
}
	

