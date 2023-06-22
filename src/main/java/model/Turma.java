package model;

import java.util.List;

import dao.AlunoDao;
import dao.TurmaDao;

public class Turma {
	private int idTurma;
	private String nome;
	private String codigo;
	
	public Turma() {
		
	}

	public Turma(String nome, String codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}

	public Turma(int idTurma, String nome, String codigo) {
		this.idTurma = idTurma;
		this.nome = nome;
		this.codigo = codigo;
	}
//--------------------------------------------------------------------------

	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String salvar() {
		return new TurmaDao().cadastrarTurma(this);	
	}
	
}
