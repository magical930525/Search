package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import model.News;
import test.Dom;
import util.DBConnection;

public class LikeServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		
		DBConnection db=new DBConnection();

		String content=request.getParameter("QueryContent");
		String sql="select * from news where title like '%"+content+"%'";
	  System.out.println(sql);
		List<News> newList=new ArrayList<News>();
		db.open();
		try {
		ResultSet rs = db.executeQuery(sql);
			while (rs.next()) {
				News news = new News();
				news.setP(rs.getString("p"));
				news.setTime(rs.getString("time"));
				news.setTitle(rs.getString("title"));
				news.setUrl(rs.getString("url"));
				newList.add(news);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("as", newList);
		request.setAttribute("content", content);
		request.setAttribute("length", newList.size());
		request.getRequestDispatcher("success.jsp").forward(request, response);
	}

}
