<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="dao.TurmaDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Projeto Java + DB</title>
	<link href="./index.css" rel="stylesheet"> 
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
</head>
<body>
	<a href="index.jsp">Voltar para a página inicial &#x2190;</a>
	<div class="form-cadastro">
		<h1>Cadastrar Aluno</h1>
	<form action="cadastrarAlunoController" method="post" class="cadastroForm">
	    <div class="input-form">
	        <label>Nome:</label>
	        <input type="text" placeholder="Digite seu nome..." name="nome">
	    </div>
	    <div class="input-form">
	        <label>Matricula:</label>
	        <input type="text" placeholder="Digite sua matrícula..." name="matricula">
	    </div>
	    <div class="input-form">
	        <label>Turma:</label>
	        <select name="idTurma">
	            <option value="">Selecione uma turma</option>
	            <% 
	            TurmaDao turmaDao = new TurmaDao();
	            java.util.List<model.Turma> turmas = turmaDao.buscarTurmas();
	            for (model.Turma turma : turmas) { 
	            %>
	            <option value="<%= turma.getIdTurma() %>"><%= turma.getNome() %></option>
	            <% } %>
	        </select>
	    </div>
	    <input id="alunoButton" type="submit" name="salvar" value="Cadastrar Aluno">
	</form>
	<div class="aviso">	
	    <% 
	    String mensagem = (String) request.getAttribute("mensagem");
	    if (mensagem != null) {
	        out.print(mensagem);
	    }
	    %>
	</div>
</div>
</body>
</html>