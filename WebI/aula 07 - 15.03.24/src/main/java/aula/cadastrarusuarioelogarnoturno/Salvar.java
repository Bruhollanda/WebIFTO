package aula.cadastrarusuarioelogarnoturno;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet("/salvar")
public class Salvar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tid=request.getParameter("id");
        PrintWriter out=response.getWriter();
        request.setCharacterEncoding("utf-8");
        String nome=request.getParameter("nome2");
        String telefone=request.getParameter("telefone2");

        if (tid != null && !tid.isBlank()) {
            int id = Integer.parseInt(tid);
            Set<Usuario> usuarios = (Set<Usuario>) getServletContext().getAttribute("usuarios");

            for (Usuario u: usuarios) {
                if (u.getId() == id) {

                }
            }
        }
    }
}
