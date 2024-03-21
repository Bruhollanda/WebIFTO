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

@WebServlet("/perfil")
public class Perfil extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        HttpSession session = request.getSession(false);
        if(session != null)
        {
            Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
            out.print("<p>Olá, "+ usuarioLogado.getNome());

            out.print(
                    "<p> Telefones Cadastrados: "
            );

            out.print(
                    "<table border=1>\n"+
                            "<tbody>\n" +
                            "<thead>\n" +
                            "<tr>\n" +
                            "<th>id</th>\n" +
                            "<th>Número</th>\n" +
                            "<th>Tipo</th>\n" +
                            "<th>Ação</th>\n" +
                            "</tr>\n" +
                            "</thead>"
            );
            for (Telefone t: usuarioLogado.getTelefones()) {
                out.print(
                                "<tr>" +
                                "<td>"+t.getId()+"</td>" +
                                "<td>"+t.getNumero()+"</td>" +
                                "<td>"+t.getTipo()+"</td>" +
                                "<td><a href=\"deletarTelefone?id="+t.getId()+"\">Deletar</a></td>"
                );
            }
            out.print("</tbody>" +
                    "</table>");

            out.print(
                    "<form action=\"cadastrarTelefone\" method=\"post\">\n" +
                            "        <label for=\"numero\">Cadastrar Número</label>\n" +
                            "        <input type=\"text\" name=\"numero\" placeholder=\"Número\" id=\"numero\">\n" +
                            "        <label for=\"telefone\">Tipo do número</label>\n" +
                            "        <input type=\"text\" name=\"tipo\" placeholder=\"celular ou fixo\" id=\"tipo\">\n" +
                            "        <input type=\"submit\" value=\"Cadastrar\">\n" +
                            "    </form>"
            );

        }
        else {
            out.print("<p>Você precisa logar antes</p>");
        }


    }
}
