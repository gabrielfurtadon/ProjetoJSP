package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/principal/*"}) // INTERCEPTA TODAS AS REQUISIÇÕES QUE VIEREM DO PROJETO OU MAPEAMENTO de tudo que estiver na pasta "principal"
public class FilterAutenticacao extends HttpFilter implements Filter {
       
    
    public FilterAutenticacao() {
        super();
        
    }

   /*ENCERRA OS PROCESSOS QUANDO O SERVIDOR É PARADP*/
    // EX: MATARIA OS PROCESSOS DE CONEXAO COM O BANCO
	public void destroy() {
		 
	}

	/*INTERCEPTA AS REQUISIÇÕES E AS RESPOSTAS NO SISTEMA*/
	//TUDO O QUE FIZER NO SISTEMA VAI PASSAR POR AQUI 
	// EX: VALIDCAO E AUTENTICACAO / DAR COMMIT E ROLLBACK DE TRANSAÇOES DO BANCO
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest rq = (HttpServletRequest)request; // CONVERTENDO O ServletRequest request passado em cima para HttpServletRequest
		HttpSession session = rq.getSession();
		
		String userLogado = (String) session.getAttribute("usuario"); // pegando o login para ver se esta logado 
		String urlParaAutenticar = rq.getServletPath(); // URL QUE ESTA SENDO ACESSADA
		
		//VALIDAR SE ESTA LOGADO. SENAO REDIRECIONA NPARA A PAGINA DE LOGIN
		if(userLogado == null  && !urlParaAutenticar.equalsIgnoreCase("/principal/ServletLogin")) {     // se o usuario tentar acessar qualaquer pagina que nao seja a de login e não estiver logado
			RequestDispatcher redireciona = request.getRequestDispatcher("/index.jsp?url=" + urlParaAutenticar); // LEVA PARA A TELA DE LOGIN, DEPOIS QUE ESTIVER LOGADO, LEVA PARA A TELA QUE ELE ESTAVA TENTANDO ACESSAR
			request.setAttribute("msg", "Autentique a sessão para continuar");
			redireciona.forward(request, response);
			return; //PARA A EXECUÇÃO E REDIRECIONA PARA O LOGIN
		}else {
			chain.doFilter(request, response); // deixa o processo do software continuar
		}
		
		
	}

	/*INICIA OS PROCESSOS OU RESURSOS QUANDO O SERVIDOR SOBE O PROCESSO*/
	// EX: INICIAR A CONEXAO COM O BANCO
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
