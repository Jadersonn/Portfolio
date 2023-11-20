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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import objetos.Carro;
import objetos.Usuario;

/**
 * FXML Controller class
 *
 * @author Jd
 */
public class TelaPesquisaAdminFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Usuario usuarioLogado = new Usuario();
    @FXML
    private Text msgOla;
    @FXML
    private MenuButton opcoes;
    @FXML
    private TableView<Carro> tableView;
    @FXML
    private TableColumn<Carro, String> tcCarro;
    @FXML
    private TableColumn<Carro, String> tcDescricao;
    @FXML
    private TableColumn<Carro, Void> tcExcluir;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarTableView();
        carregarCarrosNaTableView();
    }

    void receberDados(Usuario userLogin) {
        this.usuarioLogado = userLogin;
        msgOla.setText("Seja bem vindo, " + usuarioLogado.getNome());
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

    private void carregarCarrosNaTableView() {
        ConexaoDAO connection = new ConexaoDAO();
        CarroDAO carroDAO = new CarroDAO(connection.conectaBD());
        List<Carro> carros = carroDAO.obterTodosCarros();

        // Configurar os carros na TableView
        tableView.getItems().addAll(carros);
    }

    private void configurarTableView() {
        // Configurar as colunas da TableView
        tcCarro.setCellValueFactory(new PropertyValueFactory<>("nomeCarro"));
        tcDescricao.setCellValueFactory(new PropertyValueFactory<>("descricaoCarro"));

        // Configurar a coluna de ação (botão Excluir)
        tcExcluir.setCellFactory(param -> new TableCell<Carro, Void>() {
            private final Button excluirButton = new Button("Excluir");

            {
                // Adicionar ação para o botão Excluir
                excluirButton.setOnAction(event -> {
                    Carro carro = getTableView().getItems().get(getIndex());
                    excluirCarro(carro);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(excluirButton);
                }
            }
        });
    }

    private void excluirCarro(Carro carro) {
        ConexaoDAO connection = new ConexaoDAO();
        CarroDAO carroDAO = new CarroDAO(connection.conectaBD());
        carroDAO.excluirCarro(carro.getCarroId());
        // Atualizar a TableView após excluir
        tableView.getItems().remove(carro);
    }

    private void abrirPaginaDoCarro(Carro carroSelecionado) throws IOException {
        Portfolio.setRoot("telaConfigAdminFXML");
    }

    private void alterarDadosCarro(Carro carroSelecionado) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader = new FXMLLoader(getClass().getResource("/view/telaAlterarCarroFXML.fxml"));
        Parent proximaCenaParent = loader.load();
        TelaAlterarCarroFXMLController alterarCarro = loader.getController();
        alterarCarro.receberDados(carroSelecionado);
        Portfolio.setRoot(proximaCenaParent);
    }

    @FXML
    private void abraConfigCarro(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            // Lógica para abrir a página do carro
            Carro selectedCarro = tableView.getSelectionModel().getSelectedItem();
            if (selectedCarro != null) {
                try {
                    abrirPaginaDoCarro(selectedCarro);
                } catch (IOException ex) {
                    Logger.getLogger(TelaPesquisaAdminFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @FXML
    private void editarCarro(MouseEvent event) {
        if (event.getClickCount() == 2) {
            // Lógica para abrir as configurações do carro
            Carro selectedCarro = tableView.getSelectionModel().getSelectedItem();
            if (selectedCarro != null) {
                try {
                    alterarDadosCarro(selectedCarro);
                } catch (IOException ex) {
                    Logger.getLogger(TelaPesquisaAdminFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
