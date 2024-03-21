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

@WebServlet("/deletar")
public class Deletar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tid=request.getParameter("id");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        if(tid!=null && !tid.isBlank()) {
            int id=Integer.parseInt(tid);
            Set<Usuario> usuarios = (Set<Usuario>) getServletContext().getAttribute("usuarios");
            boolean removeu=false;
            for(Usuario u:usuarios)
            {
                if(u.getId()==id)
                {
                    usuarios.remove(u);
                    removeu=true;
                    out.print("Removido com sucesso");
                    session.invalidate();
                    break;
                }
            }
            if(!removeu)
                out.print("Id informado não existe");
        }else{
            out.print("<p>Você precisa informar o ID");
        }


    }
}
