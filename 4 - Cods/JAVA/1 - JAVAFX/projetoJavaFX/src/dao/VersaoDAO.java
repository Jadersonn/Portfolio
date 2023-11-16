/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import objetos.Versao;

/**
 *
 * @author JD
 */
public class VersaoDAO {

    private final Connection connection;

    public VersaoDAO(Connection connection) {
        this.connection = connection;
    }

    public Versao obterVersaoPorId(int versaoId) {
        String query = "SELECT * FROM versao WHERE versaoId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, versaoId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return criarVersao(resultSet);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Versao> obterTodosVersaos() {
        List<Versao> versoes;
        versoes = new ArrayList<>();
        String query = "SELECT * FROM versao";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                versoes.add(criarVersao(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return versoes;
    }

    public void salvarUsuario(Versao versao) {
        String query = "INSERT INTO versao (nomeVersao, anoVersao, fk_carroId) VALUES (?,?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, versao.getNomeVersao());
            preparedStatement.setString(2, versao.getAnoVersao());
            preparedStatement.setInt(3, versao.getFkCarroId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void atualizarVersao(Versao versao) {
        String query = "UPDATE versao SET nomeVersao = ?, anoVersao = ?, fk_carroId= ? WHERE versaoId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, versao.getNomeVersao());
            preparedStatement.setString(2, versao.getAnoVersao());
            preparedStatement.setInt(3, versao.getFkCarroId());
            preparedStatement.setInt(4, versao.getVersaoId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void excluirVersao(int versaoId) {
        String query = "DELETE FROM versao WHERE versaoId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, versaoId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private Versao criarVersao(ResultSet resultSet) throws SQLException {
        Versao versao = new Versao();
        versao.setNomeVersao(resultSet.getString("nomeVersao"));
        versao.setAnoVersao(resultSet.getString("anoVersao"));
        versao.setFkCarroId(resultSet.getInt("fk_carroId"));
        return versao;
    }

}
