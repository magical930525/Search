// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ZhiBan.java

package bean;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

// Referenced classes of package bean:
//            MachineBean

public class ZhiBan extends HttpServlet
{

    public ZhiBan()
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
            if(method.equals("addzhiban"))
            {
                String name = request.getParameter("name").trim();
                String kaishi = request.getParameter("kaishi").trim();
                String jieshu = request.getParameter("jieshu").trim();
                int i = mb.addZhiBan(name, kaishi, jieshu);
                if(i == 1)
                {
                    request.setAttribute("message", "\u64CD\u4F5C\u6210\u529F\uFF01");
                    request.getRequestDispatcher("admin/zbjl.jsp").forward(request, response);
                } else
                {
                    request.setAttribute("message", "\u7CFB\u7EDF\u7EF4\u62A4\u4E2D\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01");
                    request.getRequestDispatcher("admin/zbjl.jsp").forward(request, response);
                }
            }
            if(method.equals("shuaka"))
            {
                String cardid = request.getParameter("cardid").trim();
                String jiqihao = request.getParameter("jiqihao").trim();
                float f = mb.getBiaoZhun();
                int i = mb.shuaKa(Integer.parseInt(cardid), Integer.parseInt(jiqihao), f);
                if(i == 0xa2c2a)
                {
                    request.setAttribute("message", "\u64CD\u4F5C\u6210\u529F\uFF01");
                    request.getRequestDispatcher("admin/shuaka.jsp").forward(request, response);
                } else
                if(i == 0x87a238)
                {
                    request.setAttribute("message", "\u8BE5\u5361\u5DF2\u7ECF\u5728\u4F7F\u7528\u4E2D\uFF01");
                    request.getRequestDispatcher("admin/shuaka.jsp").forward(request, response);
                } else
                if(i == 0x98967f)
                {
                    request.setAttribute("message", "\u8BE5\u5361\u4F59\u989D\u4E0D\u8DB3\uFF01");
                    request.getRequestDispatcher("admin/shuaka.jsp").forward(request, response);
                } else
                if(i == 0xbde31)
                {
                    request.setAttribute("message", "\u7CFB\u7EDF\u7EF4\u62A4\u4E2D\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01");
                    request.getRequestDispatcher("admin/shuaka.jsp").forward(request, response);
                }
            } else
            if(method.equals("delzhiban"))
            {
                String id = request.getParameter("id").trim();
                int i = mb.delZhiBan(Integer.parseInt(id));
                if(i == 1)
                {
                    request.setAttribute("message", "\u64CD\u4F5C\u6210\u529F\uFF01");
                    request.getRequestDispatcher("admin/zbjl.jsp").forward(request, response);
                } else
                {
                    request.setAttribute("message", "\u7CFB\u7EDF\u7EF4\u62A4\u4E2D\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01");
                    request.getRequestDispatcher("admin/zbjl.jsp").forward(request, response);
                }
            } else
            if(method.equals("deljilu"))
            {
                String id = request.getParameter("id").trim();
                int i = mb.delLSJL(Integer.parseInt(id));
                if(i == 1)
                {
                    request.setAttribute("message", "\u64CD\u4F5C\u6210\u529F\uFF01");
                    request.getRequestDispatcher("admin/cxjl.jsp").forward(request, response);
                } else
                {
                    request.setAttribute("message", "\u7CFB\u7EDF\u7EF4\u62A4\u4E2D\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01");
                    request.getRequestDispatcher("admin/cxjl.jsp").forward(request, response);
                }
            } else
            if(method.equals("deldageka"))
            {
                String id = request.getParameter("id").trim();
                String cardid = request.getParameter("cardid").trim();
                int i = mb.delLSJL(Integer.parseInt(id));
                if(i == 1)
                {
                    request.setAttribute("cardid", cardid);
                    request.setAttribute("message", "\u64CD\u4F5C\u6210\u529F\uFF01");
                    request.getRequestDispatcher("admin/chaxun.jsp").forward(request, response);
                } else
                {
                    request.setAttribute("cardid", cardid);
                    request.setAttribute("message", "\u7CFB\u7EDF\u7EF4\u62A4\u4E2D\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01");
                    request.getRequestDispatcher("admin/chaxun.jsp").forward(request, response);
                }
            } else
            if(method.equals("delshuaka"))
            {
                String id = request.getParameter("id").trim();
                int i = mb.delShuaKa(Integer.parseInt(id));
                if(i == 1)
                {
                    request.setAttribute("message", "\u64CD\u4F5C\u6210\u529F\uFF01");
                    request.getRequestDispatcher("admin/lsjl.jsp").forward(request, response);
                } else
                {
                    request.setAttribute("message", "\u7CFB\u7EDF\u7EF4\u62A4\u4E2D\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01");
                    request.getRequestDispatcher("admin/lsjl.jsp").forward(request, response);
                }
            } else
            if(method.equals("xiaji"))
            {
                String id = request.getParameter("id").trim();
                float f = mb.getBiaoZhun();
                int i = mb.xiaJi(Integer.parseInt(id), f);
                if(i == 1)
                {
                    request.setAttribute("message", "\u64CD\u4F5C\u6210\u529F\uFF01");
                    request.getRequestDispatcher("admin/lsjl.jsp").forward(request, response);
                } else
                {
                    request.setAttribute("message", "\u7CFB\u7EDF\u7EF4\u62A4\u4E2D\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01");
                    request.getRequestDispatcher("admin/lsjl.jsp").forward(request, response);
                }
            } else
            if(method.equals("upzhiban"))
            {
                String id = request.getParameter("id").trim();
                String name = request.getParameter("name").trim();
                String kaishi = request.getParameter("kaishi").trim();
                String jieshu = request.getParameter("jieshu").trim();
                int i = mb.upZhiBan(Integer.parseInt(id), name, kaishi, jieshu);
                if(i == 1)
                {
                    request.setAttribute("message", "\u64CD\u4F5C\u6210\u529F\uFF01");
                    request.getRequestDispatcher("admin/zbjl.jsp").forward(request, response);
                } else
                {
                    request.setAttribute("message", "\u7CFB\u7EDF\u7EF4\u62A4\u4E2D\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01");
                    request.getRequestDispatcher("admin/zbjl.jsp").forward(request, response);
                }
            } else
            if(method.equals("chaxunka"))
            {
                String cardid = request.getParameter("cardid").trim();
                request.setAttribute("cardid", cardid);
                request.getRequestDispatcher("admin/chaxun.jsp").forward(request, response);
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
