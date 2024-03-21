package aula.cadastrarusuarioelogarnoturno;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet("/cadastrar")
public class Cadastrar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        request.setCharacterEncoding("utf-8");
        String nome=request.getParameter("nome");
        String login=request.getParameter("login");
        String senha=request.getParameter("senha");

        if(nome!=null && login!=null && senha!=null && !nome.isBlank() && !login.isBlank() && !senha.isBlank()) {
            Set<Usuario> usuarios=(Set<Usuario>) getServletContext().getAttribute("usuarios");
            boolean existe=false;

            for(Usuario usuario:usuarios ) {
                if (usuario.getLogin().equals(login)) {
                    existe = true;
                    break;
                }
            }

            if(!existe) {
                Integer serial=(Integer) getServletContext().getAttribute("serial");
                serial++;
                getServletContext().setAttribute("serial",serial);
                Usuario u = new Usuario(serial, nome, login, senha);
                usuarios.add(u);
                out.println("<p>Cadastrado com sucesso</p>");
            }
            else
                out.print("<p>Falha ao cadastrar. Login já existe.</p>");
            System.out.println(usuarios);
        }
        else{
            out.print("<p>Informe todos os dados no formulário</p>");
        }
    }
}
