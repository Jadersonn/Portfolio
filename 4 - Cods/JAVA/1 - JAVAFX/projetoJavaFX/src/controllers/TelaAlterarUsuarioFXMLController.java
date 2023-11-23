/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import dao.ConexaoDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import objetos.Usuario;

/**
 * FXML Controller class
 *
 * @author Jd
 */
public class TelaAlterarUsuarioFXMLController implements Initializable {

    @FXML
    private Text msgOla;
    @FXML
    private MenuButton opcoes;
    @FXML
    private TextField nome;
    @FXML
    private PasswordField senha;
    @FXML
    private TextField email;
    @FXML
    private CheckBox admin;

    private Usuario usuario = new Usuario();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        msgOla.setText("Ola, " + Portfolio.getUsuarioFinal().getNome());
    }

    @FXML
    private void clickConfig(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("");
        alert.setTitle("Informação:");
        alert.setContentText("Função ainda não configurada.");
        alert.showAndWait();
    }

    void receberDados(Usuario usuarioSelecionado) {
        usuario = usuarioSelecionado;
    }

    @FXML
    private void salvarUsuario(ActionEvent event) throws NoSuchAlgorithmException, IOException {
        ConexaoDAO connection = new ConexaoDAO();
        UsuarioDAO userDAO = new UsuarioDAO(connection.conectaBD());
        usuario.setNome(nome.getText());
        usuario.setEmail(email.getText());
        usuario.setSenha(senha.getText());
        usuario.setAdministrador(admin.isSelected());
        userDAO.atualizarUsuario(usuario);
        Portfolio.setRoot("telaPesquisaUsuarioFXML");
    }

    @FXML
    private void clickSair(ActionEvent event) throws IOException {
        Portfolio.setRoot("telaLoginFXML");
    }

    @FXML
    private void clickVoltar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader = new FXMLLoader(getClass().getResource("/view/telaPesquisaAdminFXML.fxml"));
        Parent proximaCenaParent = loader.load();
        TelaPesquisaAdminFXMLController controllerTelaPesquisaAdmin = loader.getController();
        controllerTelaPesquisaAdmin.receberDados(Portfolio.getUsuarioFinal());
        Portfolio.setRoot(proximaCenaParent);
    }

    @FXML
    private void clickCadastrar(ActionEvent event) throws IOException {
        Portfolio.setRoot("telaCadastroUsuarioFXML");
    }

}
