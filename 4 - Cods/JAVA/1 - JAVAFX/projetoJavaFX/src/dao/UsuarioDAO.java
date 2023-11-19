/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import objetos.Usuario;

public class UsuarioDAO {

    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    public Usuario obterUsuarioPorId(int userId) {
        String query = "SELECT * FROM usuario WHERE userId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return criarUsuario(resultSet);
                }
            }
        } catch (SQLException e) {
            String alert = convertSQLExceptionToString(e);
            alertBd(alert);
        }
        return null;
    }
    public Usuario obterUsuarioPorEmail(String email) {
        String sql = "SELECT * FROM usuario WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return criarUsuario(resultSet);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Lida com a exceção de SQL
            return null;
        }
    }

    public Usuario realizarLogin(String email, String senha) throws NoSuchAlgorithmException {
        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, converterSenha(senha));

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return criarUsuario(resultSet);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Lida com a exceção de SQL
            return null;
        }
    }

    public List<Usuario> obterTodosUsuarios() {
        List<Usuario> usuarios;
        usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuario";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                usuarios.add(criarUsuario(resultSet));
            }
        } catch (SQLException e) {
            String alert = convertSQLExceptionToString(e);
            alertBd(alert);
        }
        return usuarios;
    }

    public void salvarUsuario(Usuario usuario) throws NoSuchAlgorithmException {
        String query = "INSERT INTO usuario (nome, email, senha, administrador) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getEmail());
            preparedStatement.setString(3, converterSenha(usuario.getSenha()));
            preparedStatement.setBoolean(4, usuario.isAdministrador());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            String alert = convertSQLExceptionToString(e);
            alertBd(alert);
        }
    }

    public void atualizarUsuario(Usuario usuario) throws NoSuchAlgorithmException {
        String query = "UPDATE usuario SET nome = ?, email = ?, senha = ?, administrador = ? WHERE userId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getEmail());
            preparedStatement.setString(3, converterSenha(usuario.getSenha()));
            preparedStatement.setBoolean(4, usuario.isAdministrador());
            preparedStatement.setInt(5, usuario.getUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            String alert = convertSQLExceptionToString(e);
            alertBd(alert);
        }
    }

    public void excluirUsuario(int userId) {
        String query = "DELETE FROM usuario WHERE userId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            String alert = convertSQLExceptionToString(e);
            alertBd(alert);
        }
    }

    private Usuario criarUsuario(ResultSet resultSet) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setUserId(resultSet.getInt("userId"));
        usuario.setNome(resultSet.getString("nome"));
        usuario.setEmail(resultSet.getString("email"));
        usuario.setSenha(resultSet.getString("senha"));
        usuario.setAdministrador(resultSet.getBoolean("administrador"));
        return usuario;
    }

    public void alertBd(String avisoConexao) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("");
        alert.setTitle("Houve um problema no Banco de dados");
        alert.setContentText(avisoConexao);
        alert.showAndWait();
    }

    private static String convertSQLExceptionToString(SQLException e) {
        StringBuilder mensagem = new StringBuilder();

        do {
            mensagem.append("SQLState: ").append(e.getSQLState()).append("\n");
            mensagem.append("Código do erro: ").append(e.getErrorCode()).append("\n");
            mensagem.append("Mensagem: ").append(e.getMessage()).append("\n");

            e = e.getNextException();
            if (e != null) {
                mensagem.append("\n--- Causa raiz ---\n");
            }
        } while (e != null);

        return mensagem.toString();
    }

    private String converterSenha(String senha) throws NoSuchAlgorithmException, NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(senha.getBytes(StandardCharsets.UTF_8));

        // Convertendo o array de bytes para representação hexadecimal
        StringBuilder hexStringBuilder = new StringBuilder();
        for (byte b : hashBytes) {
            hexStringBuilder.append(String.format("%02x", b));
        }
        return hexStringBuilder.toString();
    }
}
