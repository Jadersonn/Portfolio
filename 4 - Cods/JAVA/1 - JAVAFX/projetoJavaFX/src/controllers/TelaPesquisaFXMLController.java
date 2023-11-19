/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    @FXML
    private Text nome;

    private boolean admin;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    public void receberDados(Usuario dadosUsuario){
        nome.setText(dadosUsuario.getNome());
        admin = dadosUsuario.isAdministrador();
    }

    @FXML
    private void clickVoltar() throws IOException {
        Portfolio.setRoot("telaLoginFXML");
    }

    private void mudarParaAdmin() throws IOException {
        if (admin) {
            Portfolio.setRoot("TelaPesquisaAdminFXML");
        }
    }
}
