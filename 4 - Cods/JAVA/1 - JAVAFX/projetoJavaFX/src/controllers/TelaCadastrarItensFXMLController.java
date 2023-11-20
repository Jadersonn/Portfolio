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
<<<<<<< HEAD
    private void clickAlterarCarro() throws IOException {
=======
    private void clickAlterarCarro(ActionEvent event) throws IOException {
>>>>>>> 690cd04904066c293c2081f25931822e3f5b90d8
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("");
        alert.setTitle("Informação:");
        alert.setContentText("Selecione e dê duplo clique no carro desejado para altera-lo.");
        alert.showAndWait();
<<<<<<< HEAD
        Portfolio.setRoot("telaPesquisaAdminFXML");
=======
        Portfolio.setRoot("TelaPesquisaAdminFXML");
>>>>>>> 690cd04904066c293c2081f25931822e3f5b90d8
    }

    @FXML
    private void clickAlterarUsuario(ActionEvent event) {

    }

    @FXML
<<<<<<< HEAD
    private void clickRemoverCarro(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("");
        alert.setTitle("Informação:");
        alert.setContentText("Clique no botão excluir para excluir o Carro.");
        alert.showAndWait();
        Portfolio.setRoot("telaPesquisaAdminFXML");
=======
    private void clickRemoverCarro(ActionEvent event) {
>>>>>>> 690cd04904066c293c2081f25931822e3f5b90d8
    }

    @FXML
    private void clickRemoverUsuario(ActionEvent event) {

    }

<<<<<<< HEAD
=======
    private void clickItensSalvos(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader = new FXMLLoader(getClass().getResource("/view/telaItensFavFXML.fxml"));
        Parent proximaCenaParent = loader.load();
        //TelaPesquisaAdminFXMLController controllerTelaPesquisaAdmin = loader.getController();
        //controllerTelaPesquisaAdmin.receberDados(usuarioLogin.realizarLogin(email, senha));
        //Portfolio.setRoot(proximaCenaParent);
    }
>>>>>>> 690cd04904066c293c2081f25931822e3f5b90d8

    @FXML
    private void clickConfig(ActionEvent event) throws IOException {
        Portfolio.setRoot("telaConfigFXML");
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
