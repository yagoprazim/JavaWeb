<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="model.Turma" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
	<link href="./index.css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
</head>
<body>
	<a href="index.jsp">Voltar para a página inicial &#x2190;</a>
	<div class="table-list">
		<h1>Alunos Cadastrados</h1>
	    
	        <table>
	        <tr class="t-header">
	            <th>ID</th>
	            <th>Matrícula</th>
	            <th>Nome</th>
	            <th>Turma</th>
	        </tr>
	
	        <%-- Obtenha a lista de alunos do banco de dados --%>
	        <%@ page import="dao.AlunoDao" %>
	        <%@ page import="model.Aluno" %>
	        <%@ page import="model.Turma" %>
	        <%
	            AlunoDao alunoDao = new AlunoDao();
	            java.util.List<Aluno> alunos = alunoDao.listarAlunos();
	
	            for (Aluno aluno : alunos) {
	                int id = aluno.getIdAluno();
	                String matricula = aluno.getMatricula();
	                String nome = aluno.getNome();
	                String nomeTurma = "";
	
	                Turma turma = aluno.getTurma();
	                if (turma != null) {
	                    nomeTurma = turma.getNome();
	                }
	        %>
	        <tr>
	            <td><%= id %></td>
	            <td><%= matricula %></td>
	            <td><%= nome %></td>
	            <td><%= nomeTurma %></td>
	        </tr>
	        <% } %>
	    </table>
   </div>
</body>
</html>