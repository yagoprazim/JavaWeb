<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

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
	<h1>Lista de Turmas</h1>
    
    <table>
        <thead>
            <tr class="t-header">
                <th>ID</th>
                <th>Código</th>
                <th>Nome</th>
            </tr>
        </thead>
        <tbody>
            <% 
            dao.TurmaDao turmaDao = new dao.TurmaDao();
            java.util.List<model.Turma> turmas = turmaDao.buscarTurmas();
            for (model.Turma turma : turmas) {
            %>
            <tr>
                <td><%= turma.getIdTurma() %></td>
                <td><%= turma.getCodigo() %></td>
                <td><%= turma.getNome() %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
</div>
</body>
</html>