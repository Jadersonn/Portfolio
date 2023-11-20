/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import dao.CarroDAO;
import dao.ConexaoDAO;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import objetos.Carro;

/**
 * FXML Controller class
 *
 * @author INFO
 */
public class TelaCadastroCarroFXMLController implements Initializable {

    @FXML
    private Text msgOla;
    @FXML
    private MenuButton opcoes;
    @FXML
    private TextField nomeCarro;
    @FXML
    private TextArea descricaoCarro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickCadastrar(ActionEvent event) throws IOException {
        Portfolio.setRoot("telaCadastrarItensFXML");
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
    private void salvarCarro(ActionEvent event) throws IOException {
        ConexaoDAO connection = new ConexaoDAO();
        CarroDAO carro = new CarroDAO(connection.conectaBD());
        Carro carroCriado = new Carro();
        carroCriado.setDescricaoCarro(descricaoCarro.getText());
        carroCriado.setNomeCarro(nomeCarro.getText());
        carro.salvarCarro(carroCriado);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("");
        alert.setTitle("Relatorio:");
        alert.setContentText("Carro Cadastrado.");
        alert.showAndWait();
        Portfolio.setRoot("telaCadastrarItensFXML");
    }
    
    
}
