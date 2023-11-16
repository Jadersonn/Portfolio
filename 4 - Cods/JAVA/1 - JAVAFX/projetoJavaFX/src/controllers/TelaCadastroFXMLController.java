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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
    private void clickVoltar(ActionEvent event) throws IOException {
        Portfolio.setRoot("telaLoginFXML");
    }

    @FXML
    private void clickCriarConta(ActionEvent event) throws NoSuchAlgorithmException {
        /*ConexaoDAO conexao = new ConexaoDAO();
        if(conexao.conectaBD() != null){
        System.out.println("conectou");
        }
        UsuarioDAO usuario = new UsuarioDAO(conexao.conectaBD());
        for (Usuario usuarioNovo : usuario.obterTodosUsuarios() ){
            System.out.println(usuarioNovo.getNome());
        }*/
        ConexaoDAO conexao = new ConexaoDAO();
        UsuarioDAO usuarioBD = new UsuarioDAO(conexao.conectaBD());
        Usuario usuario = new Usuario();
        usuario.setNome(nomeCadastro.getText());
        usuario.setEmail(emailCadastro.getText());
        if (senhaCadastro.getText().equals(confirmeSenhaCadastro.getText())) {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(senhaCadastro.getText().getBytes(StandardCharsets.UTF_8));

            // Convertendo o array de bytes para representação hexadecimal
            StringBuilder hexStringBuilder = new StringBuilder();
            for (byte b : hashBytes) {
                hexStringBuilder.append(String.format("%02x", b));
            }
            usuario.setSenha(hexStringBuilder.toString());
        }

        System.out.println("Usuario Salvo" + usuario.toString());
        usuarioBD.salvarUsuario(usuario);
    }

}
