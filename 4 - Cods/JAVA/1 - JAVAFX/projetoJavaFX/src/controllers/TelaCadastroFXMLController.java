/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import dao.ConexaoDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.SplitPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import objetos.Usuario;

/**
 * FXML Controller class
 *
 * @author INFO
 */
public class TelaCadastroFXMLController implements Initializable {

    @FXML
    private TextField nomeCadastro;
    @FXML
    private TextField emailCadastro;
    @FXML
    private PasswordField senhaCadastro;
    @FXML
    private PasswordField confirmeSenhaCadastro;
    @FXML
    private ImageView imgLogo;
    @FXML
    private SplitPane splitPane;

    /**
     * Initializes the controller class.
     *
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Image logo = new Image("resources/imgs/logo.png");
            imgLogo.setImage(logo);
        } catch (Exception e) {
            System.err.println("Erro ao carregar a imagem: " + e.getMessage());
        }
    }

    @FXML
    private void clickVoltar() throws IOException {
        Portfolio.setRoot("telaLoginFXML");
    }

    @FXML
    private void clickCriarConta() throws NoSuchAlgorithmException, IOException {

        ConexaoDAO conexao = new ConexaoDAO();
        Usuario usuario = new Usuario();

        if (nomeCadastro.getText().isEmpty() || emailCadastro.getText().isEmpty() || confirmeSenhaCadastro.getText().isEmpty() || senhaCadastro.getText().isEmpty()) {
            //verificando se nao existem campos vazios
            avisoPoupUP("Existem campos não preenchidos.");
            return;
        } else {
            usuario.setNome(nomeCadastro.getText());
            //verificando a validade do email
            if (emailValido(emailCadastro.getText())) {
                usuario.setEmail(emailCadastro.getText());
            } else {
                avisoPoupUP("Email invalido.");
                return;
            }

            //verificando a igualidade das senhas
            if (senhaCadastro.getText().equals(confirmeSenhaCadastro.getText())) {
                usuario.setSenha(senhaCadastro.getText());
            } else {
                avisoPoupUP("Senhas não conferem.");
                return;

            }

            System.out.println("Usuario Salvo" + usuario.toString());
            UsuarioDAO usuarioBD = new UsuarioDAO(conexao.conectaBD());
            usuarioBD.salvarUsuario(usuario);
            Portfolio.setRoot("telaLoginFXML");
        }
    }

    private void avisoPoupUP(String aviso) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText("");
        alert.setTitle("Houve um problema");
        alert.setContentText(aviso);
        alert.showAndWait();
    }

    //verificando a validade do email padrao nome@email.com
    private static boolean emailValido(String email) {
        // verificando o formato do e-mail
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        //estamos compilando a expressão em um objeto Pattern qpara corresponder com o formato dado com strings.
        Pattern pattern = Pattern.compile(regex);
        //fazendo a comparacao e atribuindo a variavel
        Matcher matcher = pattern.matcher(email);
        //retorna um booleano
        return matcher.matches();
    }

    @FXML
    private void teclaPressionada(KeyEvent event) throws NoSuchAlgorithmException, IOException {
        if (event.getCode() == KeyCode.ENTER) {
            clickCriarConta();
        }
    }

}
