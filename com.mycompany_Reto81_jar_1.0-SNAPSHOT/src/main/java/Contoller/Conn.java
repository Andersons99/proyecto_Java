/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contoller;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Anderson Sachez
 */
public class Conn {
    String driver = "com.mysql.jdbc.Driver";
    String user = "root";
    String password = "";
    String url = "jdbc:mysql://localhost:3306/misiontic81";
    Connection conexion;

    public Connection getConnection() {
        try {
            Class.forName(driver);
            conexion = (Connection) DriverManager.getConnection(url, user, password);
            if (conexion != null) {
                System.out.println("Conexion exitosa");
            }
        } catch (Exception e) {
            System.out.println("Error en al conexion: " + e.getMessage());

        }
        return conexion;
    }

}
