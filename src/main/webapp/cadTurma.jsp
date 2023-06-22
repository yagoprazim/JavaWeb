<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
	
	<a href="index.jsp" >Voltar para a página inicial &#x2190;</a>
	<div class="form-cadastro">
		<h1>Cadastrar Turma</h1>
	    <form action="cadastrarTurmaController" method="post" class="cadastroTurmaForm">
	      <div class="input-form">
	        <label>Nome:</label>
	        <input type="text" placeholder="Nome da turma..." name="nome">
	      </div>
	      <div class="input-form">
	        <label>Código:</label>
	        <input type="text" placeholder="Código da turma..." name="codigo">
	      </div>
	      <input id="turmaButton" type="submit" name="salvar" value="Cadastrar Turma">
	    </form>
	    <br>
	    <div class="aviso">
	    	<%
	    	String mensagem = (String) request.getAttribute("mensagem");
	    	if(mensagem!=null)
	    		out.print(mensagem);
	    	%>
	    </div>
    </div>
</body>
</html>