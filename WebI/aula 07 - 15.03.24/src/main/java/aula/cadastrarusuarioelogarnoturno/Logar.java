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

@WebServlet("/logar")
public class Logar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);

        if(session != null) {
            out.print("<p>Existe sessão ativa. Saia antes de logar com outra conta</p>");
        } else {
            String login=request.getParameter("login");
            String senha=request.getParameter("senha");

            if( login!=null && senha!=null  && !login.isBlank() && !senha.isBlank()) {
                Set<Usuario> usuarios=(Set<Usuario>) getServletContext().getAttribute("usuarios");
                HttpSession sessao=null;
                for(Usuario usuario:usuarios ) {
                    if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                        sessao=request.getSession();
                        sessao.setAttribute("usuario",usuario);
                        out.print("<p>Logado com sucesso</p>");
                        break;
                    }
                }
                if(sessao==null)
                {
                    out.print("<p>Login ou senha incorretos</p>");
                }
            }
            else{
                out.print("<p>Informe o login e a senha</p>");
            }
        }

    }
}
