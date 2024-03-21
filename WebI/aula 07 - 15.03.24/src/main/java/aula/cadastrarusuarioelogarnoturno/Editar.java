package aula.cadastrarusuarioelogarnoturno;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet("/editar")
public class Editar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession(false);
        Usuario usuarioLogado = null;


        if (session != null) {
            usuarioLogado = (Usuario) session.getAttribute("usuario");
            out.print(
                    "<label for=\"nome\">Nome</label>\n" +
                    "<input type=\"text\" name=\"nome\" value=\""+usuarioLogado.getNome()+"\" id=\"nome\">\n" +
                    "<label for=\"telefone\">Telefone</label>\n" +
                    "<input type=\"text\" name=\"telefone\" value=\""+usuarioLogado.getTelefones()+"\" id=\"telefone\">" +
                    "<a href=\"editar?id=\""+usuarioLogado.getId()+"\">Editar</a>"
            );
        }
    }
}
