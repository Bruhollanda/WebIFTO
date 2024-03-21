package aula.cookiesessaonoturno;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/computador")
public class Computador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);

        out.println("<html><body>");
        out.print("Notebook Dell");
        out.println("Processador intel i5 12° geração, 16GB RAM, SSD 500GB");

        out.println("R$2500,00");
        out.println("</body></html>");
        if (session == null) {
            Cookie cookie = new Cookie("computador", "acessou");
            cookie.setMaxAge(3600);
            response.addCookie(cookie);
        }
    }
}
