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
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import objetos.Usuario;

/**
 * FXML Controller class
 *
 * @author INFO
 */
public class TelaPesquisaFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Text nome;

    private Usuario usuario;
    @FXML
    private Text msgOla;
    @FXML
    private MenuButton opcoes;
    @FXML
    private TableView<?> tablleview;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void receberDados(Usuario dadosUsuario) {
        nome.setText(dadosUsuario.getNome());
        this.usuario = dadosUsuario;
    }

    private void clickVoltar() throws IOException {
        Portfolio.setRoot("telaLoginFXML");
    }

    @FXML
    private void clickConfig(ActionEvent event) {
    }

    @FXML
    private void clickSair(ActionEvent event) {
    }

}
