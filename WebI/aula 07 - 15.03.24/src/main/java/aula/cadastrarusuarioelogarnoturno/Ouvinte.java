package aula.cadastrarusuarioelogarnoturno;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebListener
public class Ouvinte implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent evento) {
        ServletContext aplicacao= evento.getServletContext();
        Set<Usuario> usuarios=new HashSet<>();
        usuarios.add(new Usuario(1,"José", "jose","123"));
        usuarios.add(new Usuario(2,"Maria","maria","abc"));
        aplicacao.setAttribute("serial",2);
        aplicacao.setAttribute("usuarios",usuarios);
    }
}
