package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Turma;

public class TurmaDao {	
    private static final String INSERT_TURMA = "INSERT INTO turmas VALUES (null,?,?)";
    private static final String SELECT_TURMAS = "SELECT id, codigo, nome FROM turmas";
    private static final String DUPLICATE_CODE_ERROR = "Já existe uma turma cadastrada com este código!";

    public String cadastrarTurma(Turma turma) {
        try (Connection conn = new MySqlConnection().conectar();
             PreparedStatement pStatement = conn.prepareStatement(INSERT_TURMA)) {

            pStatement.setString(1, turma.getCodigo());
            pStatement.setString(2, turma.getNome());
            pStatement.execute();

            return "Turma cadastrada com sucesso!";
        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate")) {
                return DUPLICATE_CODE_ERROR;
            }
            return e.getMessage();
        }
    }
//---------------------------------------------------------------------------------
    public List<Turma> buscarTurmas() {
        List<Turma> turmas = new ArrayList<>();

        try (Connection conn = new MySqlConnection().conectar();
             PreparedStatement statement = conn.prepareStatement(SELECT_TURMAS);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Turma turma = new Turma();
                turma.setIdTurma(resultSet.getInt("id"));
                turma.setCodigo(resultSet.getString("codigo"));
                turma.setNome(resultSet.getString("nome"));
                turmas.add(turma);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return turmas;
    }
}
