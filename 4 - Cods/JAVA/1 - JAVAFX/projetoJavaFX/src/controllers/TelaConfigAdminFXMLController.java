/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import objetos.Carro;
import objetos.Usuario;

/**
 * FXML Controller class
 *
 * @author INFO
 */
public class TelaConfigAdminFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Carro carro = new Carro();
    private Usuario user = new Usuario();
    @FXML
    private Text msgOla;
    @FXML
    private MenuButton opcoes;
    @FXML
    private ImageView imgCarro;
    @FXML
    private Text nomeCarro;
    @FXML
    private Text descricao;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void receberDados(Carro carroRecebido) {
        carro = carroRecebido;
        user = Portfolio.getUsuarioFinal();
        msgOla.setText("Ola, " + user.getNome());
        Image imgCarroCarregada = new Image("resources/imgs/" + carro.getNomeCarro() + ".png");
        imgCarro.setImage(imgCarroCarregada);
        nomeCarro.setText(carro.getNomeCarro());
        descricao.setText(carro.getDescricaoCarro());
    }

    @FXML
    private void clickConfig() throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("");
        alert.setTitle("Informação:");
        alert.setContentText("Função ainda não configurada ou indisponivel a esse usuario.");
        alert.showAndWait();
    }

    @FXML
    private void clickCadastrar() throws IOException {
        if (user.isAdministrador()) {
            Portfolio.setRoot("telaCadastrarItensFXML");
        } else {
            clickConfig();
        }
    }

    @FXML
    private void clickSair() throws IOException {
        Portfolio.setRoot("telaLoginFXML");
    }

    @FXML
    private void clickVoltar() throws IOException {
        if (user.isAdministrador()) {
            Portfolio.setRoot("telaPesquisaAdminFXML");
        } else {
            Portfolio.setRoot("telaPesquisaUsuarioFXML");
        }
    }
}
