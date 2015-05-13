// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Collage.java

package bean;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

// Referenced classes of package bean:
//            CollageBean

public class Collage extends HttpServlet
{

    public Collage()
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
        String sname = (String)session.getAttribute("Sname");
        
        if(sname == null)
        {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else
        {
            CollageBean cb = new CollageBean();
            String method = request.getParameter("method").trim();
            if(method.equals("add"))
            {
                String name = request.getParameter("name").trim();
                String xueyuan = request.getParameter("xueyuan").trim();
                String xibie = request.getParameter("xibie").trim();
                String type = request.getParameter("type").trim();
                if(type.equals("\u6559\u5E08\u5361"))
                {
                    int i = cb.addTeacher(name, xueyuan, xibie, type);
                    if(i == 2)
                    {
                        request.setAttribute("message", "\u7CFB\u7EDF\u7EF4\u62A4\u4E2D\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01");
                        request.getRequestDispatcher("admin/addxy.jsp").forward(request, response);
                    } else
                    {
                        request.setAttribute("message", (new StringBuilder("\u64CD\u4F5C\u6210\u529F\uFF01\u8BE5\u7528\u6237\u7684\u5361\u53F7\u4E3A")).append(i).append("\u8BF7\u59A5\u5584\u4FDD\u5B58\uFF01").toString());
                        request.getRequestDispatcher("admin/xueyuan.jsp").forward(request, response);
                    }
                } else
                if(type.equals("\u5B66\u751F\u5361"))
                {
                    String money = request.getParameter("money").trim();
                    if(money == null)
                    {
                        request.setAttribute("message", "\u8BF7\u586B\u5199\u5145\u503C\u91D1\u989D\uFF01");
                        request.getRequestDispatcher("admin/addxy.jsp").forward(request, response);
                    } else
                    {
                        int i = cb.addStu(name, xueyuan, xibie, Float.parseFloat(money), type);
                        if(i == 2)
                        {
                            request.setAttribute("message", "\u7CFB\u7EDF\u7EF4\u62A4\u4E2D\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01");
                            request.getRequestDispatcher("admin/addxy.jsp").forward(request, response);
                        } else
                        {
                            request.setAttribute("message", (new StringBuilder("\u64CD\u4F5C\u6210\u529F\uFF01\u8BE5\u7528\u6237\u7684\u5361\u53F7\u4E3A")).append(i).append("\uFF0C\u5145\u503C\u91D1\u989D\u4E3A").append(money).append("\u5143\uFF0C\u8BF7\u59A5\u5584\u4FDD\u5B58\uFF01").toString());
                            request.getRequestDispatcher("admin/stu.jsp").forward(request, response);
                        }
                    }
                }
            } else
            if(method.equals("delstu"))
            {
                String id = request.getParameter("id").trim();
                int i = cb.delStu(Integer.parseInt(id));
                if(i == 1)
                {
                    request.setAttribute("message", "\u64CD\u4F5C\u6210\u529F\uFF01");
                    request.getRequestDispatcher("admin/stu.jsp").forward(request, response);
                } else
                {
                    request.setAttribute("message", "\u7CFB\u7EDF\u7EF4\u62A4\u4E2D\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01");
                    request.getRequestDispatcher("admin/stu.jsp").forward(request, response);
                }
            } else
            if(method.equals("delteacher"))
            {
                String id = request.getParameter("id").trim();
                int i = cb.delTeacher(Integer.parseInt(id));
                if(i == 1)
                {
                    request.setAttribute("message", "\u64CD\u4F5C\u6210\u529F\uFF01");
                    request.getRequestDispatcher("admin/xueyuan.jsp").forward(request, response);
                } else
                {
                    request.setAttribute("message", "\u7CFB\u7EDF\u7EF4\u62A4\u4E2D\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01");
                    request.getRequestDispatcher("admin/xueyuan.jsp").forward(request, response);
                }
            } else
            if(method.equals("delcz"))
            {
                String id = request.getParameter("id").trim();
                int i = cb.delCz(Integer.parseInt(id));
                if(i == 1)
                {
                    request.setAttribute("message", "\u64CD\u4F5C\u6210\u529F\uFF01");
                    request.getRequestDispatcher("admin/stu.jsp").forward(request, response);
                } else
                {
                    request.setAttribute("message", "\u7CFB\u7EDF\u7EF4\u62A4\u4E2D\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01");
                    request.getRequestDispatcher("admin/stu.jsp").forward(request, response);
                }
            } else
            if(method.equals("upteacher"))
            {
                String id = request.getParameter("id").trim();
                String name = request.getParameter("name").trim();
                String xueyuan = request.getParameter("xueyuan").trim();
                String xibie = request.getParameter("xibie").trim();
                int i = cb.upTeacher(Integer.parseInt(id), name, xueyuan, xibie);
                if(i == 1)
                {
                    request.setAttribute("message", "\u64CD\u4F5C\u6210\u529F\uFF01");
                    request.getRequestDispatcher("admin/xueyuan.jsp").forward(request, response);
                } else
                {
                    request.setAttribute("message", "\u7CFB\u7EDF\u7EF4\u62A4\u4E2D\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01");
                    request.getRequestDispatcher("admin/xueyuan.jsp").forward(request, response);
                }
            } else
            if(method.equals("upstu"))
            {
                String id = request.getParameter("id").trim();
                String name = request.getParameter("name").trim();
                String xueyuan = request.getParameter("xueyuan").trim();
                String xibie = request.getParameter("xibie").trim();
                String money = request.getParameter("money").trim();
                int i = cb.upStu(Integer.parseInt(id), name, xueyuan, xibie, Float.parseFloat(money));
                if(i == 1)
                {
                    request.setAttribute("message", "\u64CD\u4F5C\u6210\u529F\uFF01");
                    request.getRequestDispatcher("admin/stu.jsp").forward(request, response);
                } else
                {
                    request.setAttribute("message", "\u7CFB\u7EDF\u7EF4\u62A4\u4E2D\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01");
                    request.getRequestDispatcher("admin/stu.jsp").forward(request, response);
                }
            } else
            if(method.equals("cz"))
            {
                String id = request.getParameter("id").trim();
                String money = request.getParameter("money").trim();
                int i = cb.chongZhi(Integer.parseInt(id), Float.parseFloat(money));
                if(i == 1)
                {
                    request.setAttribute("message", "\u64CD\u4F5C\u6210\u529F\uFF01");
                    request.getRequestDispatcher("admin/stu.jsp").forward(request, response);
                } else
                {
                    request.setAttribute("message", "\u7CFB\u7EDF\u7EF4\u62A4\u4E2D\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01");
                    request.getRequestDispatcher("admin/stu.jsp").forward(request, response);
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
