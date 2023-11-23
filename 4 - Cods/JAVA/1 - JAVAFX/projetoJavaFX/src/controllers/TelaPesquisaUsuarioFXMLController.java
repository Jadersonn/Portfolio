/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import dao.UsuarioDAO;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import objetos.Usuario;

/**
 * FXML Controller class
 *
 * @author Jd
 */
public class TelaPesquisaUsuarioFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Text msgOla;
    @FXML
    private TableView<Usuario> tableView;
    @FXML
    private TableColumn<Usuario, String> tcUsuario;
    @FXML
    private TableColumn<Usuario, String> tcDescricao;
    @FXML
    private TableColumn<Usuario, String> tcAdmin;
    @FXML
    private TableColumn<Usuario, Void> tcExcluir;
    @FXML
    private MenuButton opcoes;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarTableView();
        carregarUsuariosNaTableView();
    }



    @FXML
    private void clickSair(ActionEvent event) throws IOException {
        Portfolio.setRoot("telaLoginFXML");
    }

    private void carregarUsuariosNaTableView() {
        ConexaoDAO connection = new ConexaoDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO(connection.conectaBD());
        List<Usuario> usuarios = usuarioDAO.obterTodosUsuarios();

        // Configurar os usuarios na TableView
        tableView.getItems().addAll(usuarios);
    }

    private void configurarTableView() {
        // Configurar as colunas da TableView
        tcUsuario.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcDescricao.setCellValueFactory(new PropertyValueFactory<>("email"));
        tcAdmin.setCellValueFactory(new PropertyValueFactory<>("administrador"));
        
        tcExcluir.setCellFactory(param -> new TableCell<Usuario, Void>() {
            private final Button excluirButton = new Button("Excluir");

            {
                // Adicionar ação para o botão Excluir
                excluirButton.setOnAction(event -> {
                    Usuario usuario = getTableView().getItems().get(getIndex());
                    excluirUsuario(usuario);
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

    private void excluirUsuario(Usuario usuario) {
        ConexaoDAO connection = new ConexaoDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO(connection.conectaBD());
        usuarioDAO.excluirUsuario(usuario.getUserId());
        // Atualizar a TableView após excluir
        tableView.getItems().remove(usuario);
    }

    private void abrirPaginaDoUsuario(Usuario usuarioSelecionado) throws IOException {
        Portfolio.setRoot("telaConfigAdminFXML");
    }

    private void alterarDadosUsuario(Usuario usuarioSelecionado) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader = new FXMLLoader(getClass().getResource("/view/telaAlterarUsuarioFXML.fxml"));
        Parent proximaCenaParent = loader.load();
        TelaAlterarUsuarioFXMLController alterarUsuario = loader.getController();
        alterarUsuario.receberDados(usuarioSelecionado);
        Portfolio.setRoot(proximaCenaParent);
    }

    


    @FXML
    private void clickCadastrar(ActionEvent event) throws IOException {
        Portfolio.setRoot("telaCadastrarItensFXML");
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
    private void editarPessoa(MouseEvent event) {
        if (event.getClickCount() == 2) {
            // Lógica para abrir as configurações do usuario
            Usuario selectedUsuario = tableView.getSelectionModel().getSelectedItem();
            if (selectedUsuario != null) {
                try {
                    alterarDadosUsuario(selectedUsuario);
                } catch (IOException ex) {
                    Logger.getLogger(TelaPesquisaAdminFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
