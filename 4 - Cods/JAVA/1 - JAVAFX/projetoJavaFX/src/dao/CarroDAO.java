package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import objetos.Carro;
import objetos.Usuario;

public class CarroDAO {
    private final Connection connection;

    public CarroDAO(Connection connection) {
        this.connection = connection;
    }    
    /*public Usuario obterCarroPorId(int userId) {
        String query = "SELECT * FROM usuario WHERE userId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return criarUsuario(resultSet);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    private Carro criarCarro(ResultSet resultSet) throws SQLException {
        Carro carro = new Usuario();
        carro.setNome(resultSet.getString("nome"));
        carro.setEmail(resultSet.getString("email"));
        carro.setSenha(resultSet.getString("senha"));
        carro.setAdministrador(resultSet.getBoolean("administrador"));
        return usuario;
    }**/
   
}