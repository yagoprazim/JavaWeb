package model;

import dao.AlunoDao;

public class Aluno {
	private int idAluno;
	private String nome;
	private String matricula;
	private Turma turma;
	
	public Aluno() {
		
	}

	public Aluno(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}
	
	public Aluno(int idAluno, String nome, String matricula) {
		this.idAluno = idAluno;
		this.nome = nome;
		this.matricula = matricula;
	}
	
	public Aluno(String nome, String matricula, Turma turma) {
		this.nome = nome;
		this.matricula = matricula;
		this.turma = turma;
	}

//-----------------------------------------------------------------
	
	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
//-----------------------------------------------------------------
	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
//-----------------------------------------------------------------
	
	public String salvar() {
		return new AlunoDao().cadastrarAluno(this);
	}

}
