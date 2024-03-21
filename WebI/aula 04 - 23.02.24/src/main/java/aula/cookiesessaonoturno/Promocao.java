package aula.cookiesessaonoturno;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/promocao")
public class Promocao extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        Cookie[] cs = request.getCookies();
        HttpSession session=request.getSession(false);

        if(session != null)
        {
            out.print("<p>Bem vindo a área de promoções, "+session.getAttribute("user"));
            out.println("<p>Promoções ativas:");
            if(cs != null)
                for(Cookie c: cs)
                {
                    if(c.getName().equals("computador")) {
                        out.println("<p>Notebook Dell com 10% de desconto!!!");
                    }
                    if(c.getName().equals("perfume")) {
                        out.println("<p>La Vie Est Belle com 10% de desconto!!!");
                    }
                }
        }
        else
            out.print("<p>Você não tem permissão");


        out.println("</body></html>");
    }
}
