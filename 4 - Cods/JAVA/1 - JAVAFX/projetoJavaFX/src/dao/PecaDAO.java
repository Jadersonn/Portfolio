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
import objetos.Peca;

/**
 *
 * @author JD
 */
public class PecaDAO {

    private final Connection connection;

    public PecaDAO(Connection connection) {
        this.connection = connection;
    }

    public Peca obterPecaPorId(int pecaId) {
        String query = "SELECT * FROM peca WHERE pecaId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, pecaId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return criarPeca(resultSet);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Peca> obterTodosPecas() {
        List<Peca> pecas;
        pecas = new ArrayList<>();
        String query = "SELECT * FROM peca";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                pecas.add(criarPeca(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return pecas;
    }

    public void salvarUsuario(Peca peca) {
        String query = "INSERT INTO peca (nomePeca, categoria, idGeralPeca) VALUES (?, ?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, peca.getNomePeca());
            preparedStatement.setString(2, peca.getCategoria());
            preparedStatement.setString(3, peca.getIdGeralPeca());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void atualizarPeca(Peca peca) {
        String query = "UPDATE peca SET nomePeca = ?, categoria = ?, idGeralPeca = ? WHERE pecaId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, peca.getNomePeca());
            preparedStatement.setString(2, peca.getCategoria());
            preparedStatement.setString(3, peca.getIdGeralPeca());
            preparedStatement.setInt(4, peca.getPecaId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void excluirPeca(int pecaId) {
        String query = "DELETE FROM peca WHERE pecaId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, pecaId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private Peca criarPeca(ResultSet resultSet) throws SQLException {
        Peca peca = new Peca();
        peca.setNomePeca(resultSet.getString("nomePeca"));
        peca.setCategoria(resultSet.getString("categoria"));
        peca.setIdGeralPeca(resultSet.getString("IdGeralPeca"));
        return peca;
    }

}
