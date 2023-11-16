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
import objetos.Vendedor;

/**
 *
 * @author JD
 */
public class VendedorDAO {
    private final Connection connection;

    public VendedorDAO(Connection connection) {
        this.connection = connection;
    }    
    
    public Vendedor obterVendedorPorId(int vendedorId) {
        String query = "SELECT * FROM vendedor WHERE vendedorId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, vendedorId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return criarVendedor(resultSet);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public List<Vendedor> obterTodosVendedors() {
        List<Vendedor> vendedores;
        vendedores = new ArrayList<>();
        String query = "SELECT * FROM vendedor";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                vendedores.add(criarVendedor(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return vendedores;
    }
    
    public void salvarUsuario(Vendedor vendedor) {
        String query = "INSERT INTO vendedor (nomeVendedor, preco, link, fk_userId) VALUES (?, ?,?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, vendedor.getNomeVendedor());
            preparedStatement.setDouble(2, vendedor.getPreco());
            preparedStatement.setString(3, vendedor.getLink());
            preparedStatement.setInt(4, vendedor.getFkUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void atualizarVendedor(Vendedor vendedor) {
        String query = "UPDATE vendedor SET nomeVendedor = ?, preco = ?, link= ?, fk_userId= ? WHERE vendedorId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
           preparedStatement.setString(1, vendedor.getNomeVendedor());
            preparedStatement.setDouble(2, vendedor.getPreco());
            preparedStatement.setString(3, vendedor.getLink());
            preparedStatement.setInt(4, vendedor.getFkUserId());
            preparedStatement.setInt(5, vendedor.getVendedorId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void excluirVendedor(int vendedorId) {
        String query = "DELETE FROM vendedor WHERE vendedorId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, vendedorId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private Vendedor criarVendedor(ResultSet resultSet) throws SQLException {
        Vendedor vendedor = new Vendedor();
        vendedor.setNomeVendedor(resultSet.getString("nomeVendedor"));
        vendedor.setPreco(resultSet.getDouble("preco"));
        vendedor.setLink(resultSet.getString("link"));
        vendedor.setFkUserId(resultSet.getInt("fk_userId"));
       return vendedor;
    }

    
    
}
