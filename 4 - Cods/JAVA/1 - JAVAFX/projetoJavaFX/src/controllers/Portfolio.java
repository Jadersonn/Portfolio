package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.fxml.FXML;
import objetos.Usuario;

/**
 * JavaFX App
 */
public class Portfolio extends Application {

    private static Scene scene;
    static Usuario usuarioFinal;
    

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("telaLoginFXML"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    static void setRoot(Parent proximaCenaParent) {
       scene.setRoot(proximaCenaParent);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Portfolio.class.getResource("/view/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    
    static void setUsuarioFinal(Usuario user){
        usuarioFinal = user;
    }
    static Usuario getUsuarioFinal(){
        return usuarioFinal;
    }

}
