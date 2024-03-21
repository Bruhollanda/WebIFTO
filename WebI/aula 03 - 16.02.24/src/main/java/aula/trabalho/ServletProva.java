package aula.trabalho;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "prova", value = "/prova")
public class ServletProva extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        String nome = request.getParameter("nome");
        String [] animais = request.getParameterValues("animal");
        String [] software = request.getParameterValues("software");
        String date = request.getParameter("date");
        String metal = request.getParameter("metal");
        Double resultado = Double.parseDouble(request.getParameter("resultado"));
        Double notafinal = 0D;

        // Questão 1
        Double notaQ1 = 1.25D;

        if (animais != null) {
            for (String a: animais) {
                if (a.equals("certa")) {
                    notaQ1 += 0.25;
                } else {
                    notaQ1 -= 0.25;
                }
            }
        }
        notafinal += notaQ1;

        // Questão 2
        Double notaQ2 = 0.8D;
        for (String s: software) {
            if (s.equals("certa")) {
                notaQ2 += 0.4;
            } else {
                notaQ2 -= 0.4;
            }
        }
        notafinal += notaQ2;

        // Questão 3
        if (date.equals("1914-07-28")) {
            notafinal += 2;
        }

        // Questão 4
        if (metal.equals("mercurio")) {
            notafinal += 2;
        }

        // Questão 5
        if (resultado == 19) {
            notafinal += 2;
        }

        out.println("<h1> Olá, "+ nome + "!</h1>");
        out.println("<p> Sua nota foi: "+ notafinal + ".</p>");
        if (notafinal >= 6) {
            out.println("<p>Parabéns, vocẽ está aprovado!");
        } else {
            out.println("<p>você reprovou.</p>");
        }
    }

}