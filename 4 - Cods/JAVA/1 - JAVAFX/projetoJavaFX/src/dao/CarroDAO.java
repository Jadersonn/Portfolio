package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import objetos.Carro;

public class CarroDAO {

    private final Connection connection;

    public CarroDAO(Connection connection) {
        this.connection = connection;
    }

    public Carro obterCarroPorId(int carroId) {
        String query = "SELECT * FROM usuario WHERE carroId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, carroId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return criarCarro(resultSet);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Carro> obterTodosCarros() {
        List<Carro> carros;
        carros = new ArrayList<>();
        String query = "SELECT * FROM carro";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                carros.add(criarCarro(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return carros;
    }

    public void salvarCarro(Carro carro) {
        String query = "INSERT INTO carro (nomeCarro, DescricaoCarro) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, carro.getNomeCarro());
            preparedStatement.setString(2, carro.getDescricaoCarro());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void atualizarCarro(Carro carro) {
        String query = "UPDATE carro SET nomeCarro = ?, DescricaoCarro = ? WHERE carroId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, carro.getNomeCarro());
            preparedStatement.setString(2, carro.getDescricaoCarro());
            preparedStatement.setInt(3, carro.getCarroId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void excluirCarro(int carroId) {
        String query = "DELETE FROM carro WHERE carroId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, carroId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private Carro criarCarro(ResultSet resultSet) throws SQLException {
        Carro carro = new Carro();
        carro.setNomeCarro(resultSet.getString("nomeCarro"));
        carro.setDescricaoCarro(resultSet.getString("DescricaoCarro"));
        return carro;
    }

}
