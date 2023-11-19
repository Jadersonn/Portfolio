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
    private void clickCadastrarModelo(ActionEvent event) {
    }

    
    @FXML
    private void clickAlterarCarro(ActionEvent event) {
    }

    @FXML
    private void clickAlterarModelo(ActionEvent event) {
    }

    @FXML
    private void clickAlterarPeca(ActionEvent event) {
    }

    @FXML
    private void clickAlterarUsuario(ActionEvent event) {
    }

    @FXML
    private void clickRemoverCarro(ActionEvent event) {
    }

    @FXML
    private void clickRemoverModelo(ActionEvent event) {
    }

    @FXML
    private void clickRemoverPeca(ActionEvent event) {
    }

    @FXML
    private void clickRemoverUsuario(ActionEvent event) {
        
    }
    
    

    @FXML
    private void clickItensSalvos(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader = new FXMLLoader(getClass().getResource("/view/telaItensFavFXML.fxml"));
        Parent proximaCenaParent = loader.load();
        //TelaPesquisaAdminFXMLController controllerTelaPesquisaAdmin = loader.getController();
        //controllerTelaPesquisaAdmin.receberDados(usuarioLogin.realizarLogin(email, senha));
        //Portfolio.setRoot(proximaCenaParent);
    }

    @FXML
    private void clickConfig(ActionEvent event) throws IOException {
        Portfolio.setRoot("telaConfigFXML");
    }

    @FXML
    private void clickSair(ActionEvent event) throws IOException {
        Portfolio.setRoot("telaLoginFXML");
    }

    @FXML
    private void clickCadastrarPeca(ActionEvent event) {
    }

    @FXML
    private void clickVoltar(ActionEvent event) throws IOException {
        Portfolio.setRoot("telaPesquisaAdminFXML");
    }
}
