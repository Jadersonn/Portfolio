/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import dao.CarroDAO;
import dao.ConexaoDAO;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
<<<<<<< HEAD
import javafx.scene.Parent;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
=======
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableView;
>>>>>>> 690cd04904066c293c2081f25931822e3f5b90d8
import javafx.scene.text.Text;
import objetos.Carro;
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
<<<<<<< HEAD
    private TableView<Carro> tableView;
    @FXML
    private TableColumn<Carro, String> tcCarro;
    @FXML
    private TableColumn<Carro, String> tcDescricao;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarTableView();
        carregarCarrosNaTableView();
    }

    private void configurarTableView() {
        // Configurar as colunas da TableView
        tcCarro.setCellValueFactory(new PropertyValueFactory<>("nomeCarro"));
        tcDescricao.setCellValueFactory(new PropertyValueFactory<>("descricaoCarro"));

    }

    private void carregarCarrosNaTableView() {
        ConexaoDAO connection = new ConexaoDAO();
        CarroDAO carroDAO = new CarroDAO(connection.conectaBD());
        List<Carro> carros = carroDAO.obterTodosCarros();

        // Configurar os carros na TableView
        tableView.getItems().addAll(carros);
    }

    public void receberDados(Usuario dadosUsuario) {
        nome.setText("Seja bem vindo, " + dadosUsuario.getNome());
        this.usuario = dadosUsuario;
    }

    @FXML
    private void clickConfig() throws IOException {
        Portfolio.setRoot("telaConfigFXML");
    }

    @FXML
    private void clickSair() throws IOException {
=======
    private TableView<?> tablleview;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void receberDados(Usuario dadosUsuario) {
        nome.setText(dadosUsuario.getNome());
        this.usuario = dadosUsuario;
    }

    private void clickVoltar() throws IOException {
>>>>>>> 690cd04904066c293c2081f25931822e3f5b90d8
        Portfolio.setRoot("telaLoginFXML");
    }

    @FXML
<<<<<<< HEAD
    private void abraConfigCarro(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER) {
            Carro selectedCarro = tableView.getSelectionModel().getSelectedItem();
            if (selectedCarro != null) {
                abrirPaginaDoCarro(selectedCarro);
            }
        }
    }

    private void abrirPaginaDoCarro(Carro carroSelecionado) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader = new FXMLLoader(getClass().getResource("/view/telaConfigAdminFXML.fxml"));
        Parent proximaCenaParent = loader.load();
        TelaAlterarCarroFXMLController alterarCarro = loader.getController();
        alterarCarro.receberDados(carroSelecionado);
        Portfolio.setRoot(proximaCenaParent);
    }

    

=======
    private void clickConfig(ActionEvent event) {
    }

    @FXML
    private void clickSair(ActionEvent event) {
    }

>>>>>>> 690cd04904066c293c2081f25931822e3f5b90d8
}
