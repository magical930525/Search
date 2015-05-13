// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Login.java

package bean;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

// Referenced classes of package bean:
//            LoginBean

public class Login extends HttpServlet
{

    public Login()
    {
    }

    public void destroy()
    {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        request.setCharacterEncoding("gb2312");
        response.setContentType("text/html;charset=gb2312");
        String method = request.getParameter("method").trim();
        LoginBean lb = new LoginBean();

        if(method.equals("login"))
        {
            String name = request.getParameter("name").trim();
            String password = request.getParameter("password").trim();
            int i = lb.userLogin(name, password);
            if(i == 1)
            {
                HttpSession session = request.getSession();
                session.setAttribute("Sname", name);
                request.setAttribute("message", "");
                request.getRequestDispatcher("admin/index.jsp").forward(request, response);
            } else
            {
                request.setAttribute("message", "\u7528\u6237\u540D\u6216\u5BC6\u7801\u9519\u8BEF\uFF01");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
    }

    public void init()
        throws ServletException
    {
    }

    public static final String CONTENTTYPE = "text/html;charset=gb2312";
    public static final String CHARACTERENCODING = "gb2312";
}
