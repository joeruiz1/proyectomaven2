package DAO;


import Conexion.DbUtil;
import VO.FormaPago;
import VO.Libro;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Pago {
private Connection connection;

    public Pago() throws URISyntaxException {
        connection = DbUtil.getConnection();
    }

    public void agregarPago(FormaPago fp) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into FormasPago(idP,nombre) values (?, ?)");
            // Parameters start with 1
            preparedStatement.setInt(1, fp.getId());
            preparedStatement.setString(2, fp.getFormarPago());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
