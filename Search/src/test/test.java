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
		this.url = url; //Ŀ��ҳ���ַ
		this.outFileName = outFileName; //����ļ��ĵ�ַ������          
		this.errOutFileName = errOutFileName; //��������ļ��ĵ�ַ������     
		}
	public void convert() {         
		URL u;          
		BufferedInputStream in;        
		FileOutputStream out;           
		Tidy tidy = new Tidy();          
		tidy.setXmlOut(true);          
	tidy.setXmlPi(true);   //��� <?xml?> ��ǩ Ϊ����� XML �ļ��� ��Щ�����ǿ�ѡ�ġ�
	tidy.setXmlSpace(true);          
	tidy.setInputEncoding("UTF-8"); //�������Ҫ�����û�������ͻ������������ 
	try {  
		//�����ļ��������ַ������            
		tidy.setErrout(new PrintWriter(new FileWriter(errOutFileName), true));           
		u = new URL(url);   //�������������ļ�             
		in = new BufferedInputStream(u.openStream());             
		out = new FileOutputStream(outFileName);
		//�ļ�ת��              
		tidy.parse(in, out); //��Դ�ͷ�             
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
	

