package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarroDAO {
    private final Connection connection;

    public CarroDAO(Connection connection) {
        this.connection = connection;
    }    

   
}