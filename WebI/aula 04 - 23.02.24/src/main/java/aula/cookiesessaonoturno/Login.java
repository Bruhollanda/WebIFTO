package aula.cookiesessaonoturno;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logar")
public class Login  extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String user = request.getParameter("user");
        String senha = request.getParameter("senha");

        if(user != null && senha != null)
        {
            if ((user.equals("bruna") && senha.equals("123")) ||
                    (user.equals("jose") && senha.equals("abc")) ||
                    (user.equals("maria") && senha.equals("xyz"))) {
                HttpSession sessao=request.getSession(true);
                sessao.setAttribute("user",user);
                out.print("<p>Bem vindo, "+user);
                out.println("<p><a href='promocao'>Promoção!!!></a></p>");
                out.print("<p><a href='sair'>Sair</a></p>");
            } else
                out.print("<p>Login ou senha incorretos");
        }
    }
}
