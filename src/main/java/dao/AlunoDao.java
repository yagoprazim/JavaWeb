package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.Turma;

public class AlunoDao {
    private static final String INSERT_ALUNO = "INSERT INTO alunos VALUES (null,?,?,?)";
    private static final String SELECT_ALUNOS = "SELECT * FROM alunos";
    private static final String SELECT_TURMA_BY_ID = "SELECT * FROM turmas WHERE id = ?";
    private static final String DUPLICATE_MATRICULA_ERROR = "Já existe um aluno cadastrado com esta matrícula!";


    public String cadastrarAluno(Aluno aluno) {
        try (Connection conn = new MySqlConnection().conectar();
             PreparedStatement pStatement = conn.prepareStatement(INSERT_ALUNO)) {

            pStatement.setString(1, aluno.getMatricula());
            pStatement.setString(2, aluno.getNome());

            if (aluno.getTurma() != null) {
                pStatement.setInt(3, aluno.getTurma().getIdTurma());
            } else {
                pStatement.setNull(3, Types.INTEGER);
            }

            pStatement.execute();
        } catch (SQLException e) {
        	if (e.getMessage().contains("Duplicate")) {
                return DUPLICATE_MATRICULA_ERROR;
            }
            return e.getMessage();
        }

        return "Aluno cadastrado com sucesso!";
    }
 //---------------------------------------------------------------------------------
    public List<Aluno> listarAlunos() {
        List<Aluno> alunos = new ArrayList<>();

        try (Connection conn = new MySqlConnection().conectar();
             PreparedStatement pStatement = conn.prepareStatement(SELECT_ALUNOS);
             ResultSet resultSet = pStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String matricula = resultSet.getString("matricula");
                String nome = resultSet.getString("nome");
                int idTurma = resultSet.getInt("idTurma");

                Aluno aluno = new Aluno(id, nome, matricula);
                if (idTurma != 0) {
                    Turma turma = buscarTurmaPorId(idTurma);
                    aluno.setTurma(turma);
                }

                alunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alunos;
    }
 //---------------------------------------------------------------------------------
    public Turma buscarTurmaPorId(int idTurma) {
        Turma turma = null;

        try (Connection conn = new MySqlConnection().conectar();
             PreparedStatement pStatement = conn.prepareStatement(SELECT_TURMA_BY_ID)) {

            pStatement.setInt(1, idTurma);

            try (ResultSet resultSet = pStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String codigo = resultSet.getString("codigo");
                    String nome = resultSet.getString("nome");
                    turma = new Turma(id, nome, codigo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return turma;
    }

}
