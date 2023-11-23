/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuButton;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author INFO
 */
public class TelaCadastrarItensFXMLController implements Initializable {

    @FXML
    private Text msgOla;
    @FXML
    private MenuButton opcoes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void clickCadastrarCarro(ActionEvent event) throws IOException {
        Portfolio.setRoot("telaCadastroCarroFXML");
    }

    @FXML
    private void clickAlterarCarro() throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("");
        alert.setTitle("Informação:");
        alert.setContentText("Selecione e dê duplo clique no carro desejado para altera-lo.");
        alert.showAndWait();
        Portfolio.setRoot("telaPesquisaAdminFXML");
    }

    @FXML
    private void clickAlterarUsuario(ActionEvent event) throws IOException {
        Portfolio.setRoot("telaPesquisaUsuarioFXML");

    }

    @FXML
    private void clickRemoverCarro(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("");
        alert.setTitle("Informação:");
        alert.setContentText("Clique no botão excluir para excluir o Carro.");
        alert.showAndWait();
        Portfolio.setRoot("telaPesquisaAdminFXML");
    }

    @FXML
    private void clickRemoverUsuario(ActionEvent event) throws IOException {
        Portfolio.setRoot("telaPesquisaUsuarioFXML");
    }

    @FXML
    private void clickConfig(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("");
        alert.setTitle("Informação:");
        alert.setContentText("Função ainda não configurada.");
        alert.showAndWait();
    }

    @FXML
    private void clickSair(ActionEvent event) throws IOException {
        Portfolio.setRoot("telaLoginFXML");
    }

    @FXML
    private void clickVoltar(ActionEvent event) throws IOException {
        Portfolio.setRoot("telaPesquisaAdminFXML");
    }
}
