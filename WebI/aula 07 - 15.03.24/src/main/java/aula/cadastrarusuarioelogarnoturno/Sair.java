package aula.cadastrarusuarioelogarnoturno;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sair")
public class Sair extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        HttpSession sessao=request.getSession(false);
        if(sessao!=null)
        {
            Usuario u=(Usuario) sessao.getAttribute("usuario");
            out.print("<p>Tchau "+u.getNome());
            sessao.invalidate();
        }
        else
            out.print("<p>Você nem estava logado</p>");


    }
}
