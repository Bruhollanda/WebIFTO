package aula.cookiesessaonoturno;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/perfume")
public class Perfume extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.print("La Vie Est Belle");
        out.println("Eau de parfum, 50ml");
        out.println("R$350,00");
        out.println("</body></html>");

        if (session == null) {
            Cookie cookie = new Cookie("perfume", "acessou");
            cookie.setMaxAge(3600);
            response.addCookie(cookie);
        }


    }
}
