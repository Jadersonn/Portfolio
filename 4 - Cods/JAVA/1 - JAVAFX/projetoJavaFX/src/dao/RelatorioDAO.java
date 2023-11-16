/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import objetos.Relatorio;

/**
 *
 * @author JD
 */
public class RelatorioDAO {
    private final Connection connection;

    public RelatorioDAO(Connection connection) {
        this.connection = connection;
    }    
    
    public Relatorio obterRelatorioPorId(int registroId) {
        String query = "SELECT * FROM relatorio WHERE registroId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, registroId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return criarRelatorio(resultSet);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public List<Relatorio> obterTodosRelatorios() {
        List<Relatorio> relatorios;
        relatorios = new ArrayList<>();
        String query = "SELECT * FROM relatorio";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                relatorios.add(criarRelatorio(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return relatorios;
    }
    
    public void salvarUsuario(Relatorio relatorio) {
        String query = "INSERT INTO relatorio (acao, data, descricao, fk_userId) VALUES (?, ?,?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, relatorio.getAcao());
            preparedStatement.setDate(2, (Date) relatorio.getData());
            preparedStatement.setString(3, relatorio.getDescricao());
            preparedStatement.setInt(4, relatorio.getFkUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void atualizarRelatorio(Relatorio relatorio) {
        String query = "UPDATE relatorio SET acao = ?, data = ?, descricao = ?, fk_userId = ? WHERE registroId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, relatorio.getAcao());
            preparedStatement.setDate(2, (Date) relatorio.getData());
            preparedStatement.setString(3, relatorio.getDescricao());
            preparedStatement.setInt(4, relatorio.getFkUserId());
            preparedStatement.setInt(5, relatorio.getRegistroId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void excluirRelatorio(int registroId) {
        String query = "DELETE FROM relatorio WHERE registroId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, registroId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private Relatorio criarRelatorio(ResultSet resultSet) throws SQLException {
        Relatorio relatorio = new Relatorio();
        relatorio.setAcao(resultSet.getString("acao"));
        relatorio.setData(resultSet.getDate("data"));
        relatorio.setDescricao(resultSet.getString("descricao"));
        relatorio.setFkUserId(resultSet.getInt("fk_userId"));
       return relatorio;
    }

    
    
}
