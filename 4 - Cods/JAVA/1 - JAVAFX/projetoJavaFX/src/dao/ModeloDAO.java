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
import objetos.Modelo;

/**
 *
 * @author JD
 */
public class ModeloDAO {

    private final Connection connection;

    public ModeloDAO(Connection connection) {
        this.connection = connection;
    }

    public Modelo obterModeloPorId(int modeloId) {
        String query = "SELECT * FROM modelo WHERE modeloId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, modeloId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return criarModelo(resultSet);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Modelo> obterTodosModelos() {
        List<Modelo> modelos;
        modelos = new ArrayList<>();
        String query = "SELECT * FROM modelo";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                modelos.add(criarModelo(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return modelos;
    }

    public void salvarUsuario(Modelo modelo) {
        String query = "INSERT INTO modelo (nomeModelo, anoModelo, fk_versaoId) VALUES (?, ?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, modelo.getNomeModelo());
            preparedStatement.setString(2, modelo.getAnoModelo());
            preparedStatement.setInt(3, modelo.getFkVersaoId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void atualizarModelo(Modelo modelo) {
        String query = "UPDATE modelo SET nomeModelo = ?, anoModelo = ?, fk_versaoId = ? WHERE modeloId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, modelo.getNomeModelo());
            preparedStatement.setString(2, modelo.getAnoModelo());
            preparedStatement.setInt(3, modelo.getFkVersaoId());
            preparedStatement.setInt(4, modelo.getModeloId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void excluirModelo(int modeloId) {
        String query = "DELETE FROM modelo WHERE modeloId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, modeloId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private Modelo criarModelo(ResultSet resultSet) throws SQLException {
        Modelo modelo = new Modelo();
        modelo.setNomeModelo(resultSet.getString("nomeModelo"));
        modelo.setAnoModelo(resultSet.getString("anoModelo"));
        modelo.setFkVersaoId(resultSet.getInt("fk_versaoId"));
        return modelo;
    }

}
