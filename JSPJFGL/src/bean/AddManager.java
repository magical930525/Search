// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AddManager.java

package bean;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

// Referenced classes of package bean:
//            LoginBean

public class AddManager extends HttpServlet
{

    public AddManager()
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
        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("Sname");
        if(name == null)
        {
            request.getRequestDispatcher("admin/login.jsp").forward(request, response);
        } else
        {
            String method = request.getParameter("method").trim();
            LoginBean lb = new LoginBean();
            if(method.equals("add"))
            {
                String admin_name = request.getParameter("admin_name").trim();
                String admin_password = request.getParameter("admin_password").trim();
                String type = request.getParameter("type").trim();
                int i = lb.addManager(admin_name, admin_password, type);
                if(i == 1)
                {
                    request.setAttribute("message", "\u64CD\u4F5C\u6210\u529F\uFF01");
                    request.getRequestDispatcher("admin/zhmanage.jsp").forward(request, response);
                } else
                if(i == 3)
                {
                    request.setAttribute("message", "\u5BF9\u4E0D\u8D77\uFF0C\u8BE5\u7528\u6237\u540D\u5DF2\u7ECF\u5B58\u5728\uFF01");
                    request.getRequestDispatcher("admin/adManager.jsp").forward(request, response);
                } else
                if(i == 2)
                {
                    request.setAttribute("message", "\u7CFB\u7EDF\u7EF4\u62A4\u4E2D\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01");
                    request.getRequestDispatcher("admin/adManager.jsp").forward(request, response);
                }
            } else
            if(method.equals("del"))
            {
                String id = request.getParameter("choose").trim();
                if(Integer.parseInt(id) == 1)
                {
                    request.setAttribute("message", "\u4E0D\u80FD\u5220\u9664\u7CFB\u7EDF\u7BA1\u7406\u5458\uFF01");
                    request.getRequestDispatcher("admin/zhmanage.jsp").forward(request, response);
                } else
                {
                    int i = lb.delManager(Integer.parseInt(id));
                    if(i == 1)
                    {
                        request.setAttribute("message", "\u64CD\u4F5C\u6210\u529F\uFF01");
                        request.getRequestDispatcher("admin/zhmanage.jsp").forward(request, response);
                    } else
                    {
                        request.setAttribute("message", "\u7CFB\u7EDF\u7EF4\u62A4\u4E2D\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01");
                        request.getRequestDispatcher("admin/zhmanage.jsp").forward(request, response);
                    }
                }
            } else
            if(method.equals("update"))
            {
                String id = request.getParameter("choose").trim();
                request.setAttribute("id", id);
                request.getRequestDispatcher("admin/upManager.jsp").forward(request, response);
            } else
            if(method.equals("up2"))
            {
                String id = request.getParameter("id").trim();
                String new_password = request.getParameter("new_password").trim();
                int i = lb.upManager(Integer.parseInt(id), new_password);
                if(i == 1)
                {
                    request.setAttribute("message", "\u64CD\u4F5C\u6210\u529F\uFF01");
                    request.getRequestDispatcher("admin/zhmanage.jsp").forward(request, response);
                } else
                {
                    request.setAttribute("id", id);
                    request.setAttribute("message", "\u7CFB\u7EDF\u7EF4\u62A4\u4E2D\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01");
                    request.getRequestDispatcher("admin/upManager.jsp").forward(request, response);
                }
            } else
            if(method.equals("delmember"))
            {
                String id = request.getParameter("choose").trim();
                int i = lb.delUser(Integer.parseInt(id));
                if(i == 1)
                {
                    request.setAttribute("message", "\u64CD\u4F5C\u6210\u529F\uFF01");
                    request.getRequestDispatcher("admin/member.jsp").forward(request, response);
                } else
                {
                    request.setAttribute("id", id);
                    request.setAttribute("message", "\u7CFB\u7EDF\u7EF4\u62A4\u4E2D\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01");
                    request.getRequestDispatcher("admin/member.jsp").forward(request, response);
                }
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
