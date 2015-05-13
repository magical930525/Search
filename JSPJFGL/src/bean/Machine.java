// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Machine.java

package bean;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

// Referenced classes of package bean:
//            MachineBean

public class Machine extends HttpServlet
{

    public Machine()
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
        MachineBean mb = new MachineBean();
        if(sname == null)
        {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else
        {
            String method = request.getParameter("method").trim();
            if(method.equals("addbiaozhuan"))
            {
                String biaozhun = request.getParameter("biaozhun").trim();
                int i = mb.chongZhi(Float.parseFloat(biaozhun));
                if(i == 1)
                {
                    request.setAttribute("message", "\u64CD\u4F5C\u6210\u529F\uFF01");
                    request.getRequestDispatcher("admin/sfbz.jsp").forward(request, response);
                } else
                {
                    request.setAttribute("message", "\u7CFB\u7EDF\u7EF4\u62A4\u4E2D\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01");
                    request.getRequestDispatcher("admin/sfbz.jsp").forward(request, response);
                }
            } else
            if(method.equals("addweihu"))
            {
                String shebei = request.getParameter("shebei").trim();
                String yuanyin = request.getParameter("yuanyin").trim();
                String weihu = request.getParameter("weihu").trim();
                String shijian = request.getParameter("shijian").trim();
                int i = mb.addSheBeiWeiHu(shebei, yuanyin, weihu, shijian);
                if(i == 1)
                {
                    request.setAttribute("message", "\u64CD\u4F5C\u6210\u529F\uFF01");
                    request.getRequestDispatcher("admin/sbwh.jsp").forward(request, response);
                } else
                {
                    request.setAttribute("message", "\u7CFB\u7EDF\u7EF4\u62A4\u4E2D\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01");
                    request.getRequestDispatcher("admin/sbwh.jsp").forward(request, response);
                }
            } else
            if(method.equals("delweihu"))
            {
                String id = request.getParameter("id").trim();
                int i = mb.delSheBeiWeiHu(Integer.parseInt(id));
                if(i == 1)
                {
                    request.setAttribute("message", "\u64CD\u4F5C\u6210\u529F\uFF01");
                    request.getRequestDispatcher("admin/sbwh.jsp").forward(request, response);
                } else
                {
                    request.setAttribute("message", "\u7CFB\u7EDF\u7EF4\u62A4\u4E2D\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01");
                    request.getRequestDispatcher("admin/sbwh.jsp").forward(request, response);
                }
            } else
            if(method.equals("upweihu"))
            {
                String id = request.getParameter("id").trim();
                String shebei = request.getParameter("shebei").trim();
                String yuanyin = request.getParameter("yuanyin").trim();
                String weihu = request.getParameter("weihu").trim();
                String shijian = request.getParameter("shijian").trim();
                int i = mb.upSheBeiWeiHu(Integer.parseInt(id), shebei, yuanyin, weihu, shijian);
                if(i == 1)
                {
                    request.setAttribute("message", "\u64CD\u4F5C\u6210\u529F\uFF01");
                    request.getRequestDispatcher("admin/sbwh.jsp").forward(request, response);
                } else
                {
                    request.setAttribute("message", "\u7CFB\u7EDF\u7EF4\u62A4\u4E2D\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01");
                    request.getRequestDispatcher("admin/sbwh.jsp").forward(request, response);
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
