/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers.adminUser;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void receberDados(Carro carroRecebido) {
        carro = carroRecebido;
    }
}
