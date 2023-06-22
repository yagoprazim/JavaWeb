package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Aluno;
import model.Turma;

import java.io.IOException;


public class cadastrarTurmaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public cadastrarTurmaController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
        String mensagem;

        String nome = request.getParameter("nome");
        String codigo = request.getParameter("codigo");

        if (isCamposPreenchidos(nome, codigo)) {
            Turma turma = new Turma(nome, codigo);
            mensagem = turma.salvar();
        } else {
            mensagem = "Preencha todos os campos corretamente!";
        }

        request.setAttribute("mensagem", mensagem);

        RequestDispatcher dispatcher = request.getRequestDispatcher("cadTurma.jsp");
        dispatcher.forward(request, response);
    }

    private boolean isCamposPreenchidos(String nome, String codigo) {
        return nome != null && !nome.isEmpty() && codigo != null && !codigo.isEmpty();
    }

}
