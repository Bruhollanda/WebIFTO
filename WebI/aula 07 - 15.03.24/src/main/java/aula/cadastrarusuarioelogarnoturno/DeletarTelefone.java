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

@WebServlet("/deletarTelefone")
public class DeletarTelefone extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tid = request.getParameter("id");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        Usuario usuarioLogado = null;

        if (session != null) {
            usuarioLogado = (Usuario) session.getAttribute("usuario");
            if(tid != null && !tid.isBlank()) {
                int id = Integer.parseInt(tid);
                for (Telefone t: usuarioLogado.getTelefones()) {
                    if (id == t.getId()) {
                        usuarioLogado.getTelefones().remove(t);
                        break;
                    }
                }
                out.print("<p> Telefone removido com sucesso!");
            }
        }
    }
}
