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

@WebServlet("/relatorio")
public class Relatorio extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        Set<Usuario> usuarios=(Set<Usuario>) getServletContext().getAttribute("usuarios");
        HttpSession sessao=request.getSession(false);
        Usuario usuarioLogado=null;
        if(sessao!=null)
            usuarioLogado=(Usuario) sessao.getAttribute("usuario");

        out.print("<table border=1>\n" +
                "    <thead>\n" +
                "        <tr>\n" +
                "            <th>id</th>\n" +
                "            <th>Nome</th>\n" +
                "            <th>Telefone</th>\n" +
                "            <th>Login</th>\n" +
                "            <th>Senha</th>\n" +
                "            <th>Deletar</th>\n" +
                "            <th>Editar</th>\n" +
                "        </tr>\n" +
                "    </thead>\n" +
                "    <tbody>");
        for (Usuario u:usuarios)
        {

                out.print("<tr>" +
                        "<td>"+u.getId()+"</td>" +
                        "<td>"+u.getNome()+"</td>" +
                        "<td> <ul>");
                for(Telefone t: u.getTelefones()) {
                    out.print(
                            "<li>"+t+"</li>"
                    );
                }
                out.print(
                        "</ul></td>" +
                        "<td>"+u.getLogin()+"</td>" +
                        "<td>"+(u.equals(usuarioLogado)==true?u.getSenha():"****")+"</td>" +
                        "<td>"+(u.equals(usuarioLogado)==true?"<a href=\"deletar?id="+u.getId()+"\">Deletar</a>":"Deletar")+"</td>" +
                        "<td>"+(u.equals(usuarioLogado)==true?"<a href=\"editar?id="+u.getId()+"\">Editar</a>":"Editar")+"</td>");

        }
        out.print("    </tbody>\n" +
                "</table>");
    }
}