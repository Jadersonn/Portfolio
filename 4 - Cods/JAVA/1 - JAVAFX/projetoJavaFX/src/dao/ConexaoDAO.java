/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.Alert;

public class ConexaoDAO {

    static String URL = "jdbc:mysql://localhost:3306/pecascarros";
    static String USERNAME = "root";
    static String PASSWORD = "";

    public Connection conectaBD() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (connection != null) {
                System.out.println("\n----------------------------------------------------");
                System.out.println("\tConectado ao Banco de Dados.");
                System.out.println("----------------------------------------------------");
            } else {
                System.out.println("\n----------------------------------------------------");
                System.out.println("\tNaO conectado ao Banco de Dados.");
                System.out.println("----------------------------------------------------");

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return connection;
    }
    
   

}
