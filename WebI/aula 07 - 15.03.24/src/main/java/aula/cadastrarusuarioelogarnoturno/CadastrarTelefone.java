package aula.cadastrarusuarioelogarnoturno;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cadastrarTelefone")
public class CadastrarTelefone extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession(false);
        Usuario usuarioLogado = null;
        String numero = request.getParameter("numero");
        String tipo = request.getParameter("tipo");

        if (session != null) {
            usuarioLogado = (Usuario) session.getAttribute("usuario");
            int id = usuarioLogado.getTelefones().size() + 1;
            usuarioLogado.getTelefones().add(new Telefone(id, tipo, numero));
            out.print(
                    "<p>Telefone cadastrado com sucesso!"
            );
        }
    }
}
