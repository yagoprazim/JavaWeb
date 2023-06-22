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
	
	<header>
		<h1>Projeto Java + Banco de Dados</h1>
	    <h2>Selecione uma das opções abaixo:</h2>
 	</header>
	
	<main>
	    <div class="card-options turma">
            <h2>Cadastro de Turma</h2>
            <form action="cadTurma.jsp" method="get">
                <input type="submit" value="+">
            </form>
        </div>

        <div class="card-options aluno">
            <h2>Cadastro de Aluno</h2>
            <form action="cadAluno.jsp" method="get">
                <input type="submit" value="+">
            </form>
        </div>

        <div class="card-options aluno">
            <h2>Visualizar Alunos</h2>
            <form action="visAluno.jsp" method="get">
                <input type="submit" value="&#x1F441">
            </form> 
        </div>

        <div class="card-options turma">
            <h2>Visualizar Turmas</h2>
            <form action="visTurma.jsp" method="get">
                <input type="submit" value="&#x1F441">
            </form> 
        </div>
    </main>
</body>
</html>