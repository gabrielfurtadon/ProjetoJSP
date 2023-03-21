package servlets;

import java.io.IOException;

import bean.loginBean;
import dao.DAOLoginRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/servletLogin", "/principal/ServletLogin"}) // mapeamento da URL que vem da tela 
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DAOLoginRepository daoLoginRepository = new DAOLoginRepository();
       
    
    public ServletLogin() {
        super();
        
    }

	
    // RECEBE OS DADOS PELA URL EM PARAMETROS 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	//RECEBE OS DADOS ENVIADOS POR UM FORMULARIO
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login"); // parametro que vem da tela 
		String senha = request.getParameter("senha"); // parametro que vem da tela 
		String url = request.getParameter("url");
		
		try {
		
				if(login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {
					
					loginBean lb = new loginBean();
					lb.setLogin(login);
					lb.setSenha(senha);
					
//					
					if(daoLoginRepository.validarAutenticacao(lb)) { 
						
						request.getSession().setAttribute("Usuario", lb.getLogin()); // CRIANDO SESSÃO, SETANDO SO O LOGIN PARA A SENHA NAO FICAR GUARDADA NA SESSÃO
						
						if(url == null || url.equals("null")) {
							url = "principal/main.jsp";
						}
						
						RequestDispatcher redirecionar = request.getRequestDispatcher(url);
						redirecionar.forward(request, response);
					}else {
						RequestDispatcher redirecionar = request.getRequestDispatcher("/index.jsp");
						request.setAttribute("msg", "Login e senha incorretos!");
						redirecionar.forward(request, response);
					}
					
				}else {
					RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
					request.setAttribute("msg", "Login e senha não informados, por favor informe-os corretamente!");
					redirecionar.forward(request, response);
				}
	
		}catch(Exception e) {
			e.printStackTrace();
			RequestDispatcher redirecionar = request.getRequestDispatcher("erro.jsp");
			request.setAttribute("msg", e.getMessage());
			redirecionar.forward(request, response);
		}
	}

}
