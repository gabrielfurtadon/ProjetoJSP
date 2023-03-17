package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/servletLogin") // mapeamento da URL que vem da tela 
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletLogin() {
        super();
        
    }

	
    // RECEBE OS DADOS PELA URL EM PARAMETROS 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	//RECEBE OS DADOS ENVIADOS POR UM FORMULARIO
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("idade"));
	}

}
