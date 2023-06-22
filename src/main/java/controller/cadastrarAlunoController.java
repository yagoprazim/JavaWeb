package controller;

import java.io.IOException;

import dao.MySqlConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Aluno;
import model.Turma;

public class cadastrarAlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public cadastrarAlunoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
        String mensagem;

        String nome = request.getParameter("nome");
        String matricula = request.getParameter("matricula");
        String idTurma = request.getParameter("idTurma");

        if (isCamposPreenchidos(nome, matricula, idTurma)) {
            Aluno aluno = new Aluno(nome, matricula);
            int turmaId = Integer.parseInt(idTurma);
            Turma turma = new Turma();
            turma.setIdTurma(turmaId);
            aluno.setTurma(turma);

            mensagem = aluno.salvar();
        } else {
            mensagem = "Preencha todos os campos corretamente!";
        }

        request.setAttribute("mensagem", mensagem);

        RequestDispatcher dispatcher = request.getRequestDispatcher("cadAluno.jsp");
        dispatcher.forward(request, response);
    }

    private boolean isCamposPreenchidos(String nome, String matricula, String idTurma) {
        return nome != null && !nome.isEmpty() && matricula != null && !matricula.isEmpty() && idTurma != null
                && !idTurma.isEmpty();
    }

}
