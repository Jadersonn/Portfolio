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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Jd
 */
public class TelaEsqueciSenhaFXMLController implements Initializable {

    @FXML
    private SplitPane splitPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField emailEsqueceuSenha;
    @FXML
    private ImageView imgLogo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void clickVoltar(ActionEvent event) throws IOException {
        Portfolio.setRoot("telaLoginFXML");
    }

    @FXML
    private void clickContinuar() {
        enviarEmail(emailEsqueceuSenha.getText());
    }

    @FXML
    private void teclaPressionada(KeyEvent event) throws NoSuchAlgorithmException, IOException {
        if (event.getCode() == KeyCode.ENTER) {
            clickContinuar();
        }
    }

    private void enviarEmail(String email) {
        ConexaoDAO conexao = new ConexaoDAO();
        UsuarioDAO user = new UsuarioDAO(conexao.conectaBD());
        
        if (user.obterUsuarioPorEmail(email).getEmail().isEmpty()) {
            avisoPoupUP("Houve um problema","Nao foi encontrado contas cadastradas para: " + email);
        } else {
            avisoPoupUP("Verifique sua caixa no email","Um email com informações para recuperar sua senha foi encaminhado para: " + email);
        }

    }

    private void avisoPoupUP(String title, String aviso) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("");
        alert.setTitle(title);
        alert.setContentText(aviso);
        alert.showAndWait();
    }
}
