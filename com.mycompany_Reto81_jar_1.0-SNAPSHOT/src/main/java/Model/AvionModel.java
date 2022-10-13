/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Class.*;
import Contoller.Conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**


/**
 *
 * @author Anderson Sachez
 */
public class AvionModel {
     Conn conexion = new Conn();
    public int Create(Avion a){
        Connection conn = conexion.getConnection();
        String query = "INSERT INTO avion(modelo, numero_asientos, numero_banos, cacasidad_max_peso) VALUES( ?, ?, ?, ?)";
        try{
            PreparedStatement statment = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statment.setString(1, a.getModelo());
            statment.setInt(2,(int) a.getNumero_asientos());
            statment.setInt(3, (int) a.getNumero_banos());
            statment.setInt(4, (int) a.getCapasiad_max_peso());
            statment.executeUpdate();
            return 1; // Todo salio bien
        }catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return 0; // SI algo sale mal
    }
    public ArrayList<Avion> Read() {
        Connection conn = conexion.getConnection();
        ArrayList<Avion> listaAviones = new ArrayList();
        String query = "SELECT * FROM avion;";
        try {
            PreparedStatement newStatement = conn.prepareStatement(query);
            ResultSet resultados = newStatement.executeQuery();
            while (resultados.next()) {
                int id = resultados.getInt(1);
                String moelo = resultados.getString(2);
                int numero_asientos = resultados.getInt(3);
                int numero_banos = resultados.getInt(4);
                int cacasidad_max_peso = resultados.getInt(5);
                Avion avi = new Avion(id, moelo, numero_asientos, numero_banos, cacasidad_max_peso);
                listaAviones.add(avi);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return listaAviones;

    }
    public int Update(Avion a, int id) {
        Connection conn = conexion.getConnection();
        String query = "UPDATE avion "
                + "SET modelo = ?, "
                + "numero_asientos = ?, "
                + "nnumero_banos = ?, "
                + "cacacidad_max_peso = ? "
                + "WHERE id = ? ";
         try {
            PreparedStatement newStatement = conn.prepareStatement(query);
            newStatement.setString(1, a.getModelo());
            newStatement.setInt(2, a.getNumero_asientos());
            newStatement.setInt(3, a.getNumero_banos());
            newStatement.setInt(4, (int) a.getCapasiad_max_peso());
           
         
            return 1;
        } catch (Exception exp) {
            System.out.println("Error: " + exp.getMessage());
        }
        return 0;
    }
    public int Delete(int id) {
        Connection conn = conexion.getConnection();
        String query = "DELETE FROM avion WHERE id = ?;";
        try {
            PreparedStatement newStatement = conn.prepareStatement(query);
            newStatement.setInt(1, id);
            newStatement.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return 0;
    }
      public ArrayList<Avion> GetByModelo(){
        Connection conn = conexion.getConnection();
        ArrayList<Avion> lista_Avion = new ArrayList();
        String query = "SELECT modelo, count(modelo) AS cantidad "
                    +  "FROM avion "
                    +  "GROUP BY modelo;";
        try {
            PreparedStatement newStatement = conn.prepareStatement(query);
            ResultSet resultados = newStatement.executeQuery();
            while (resultados.next()) {
                String modelo = resultados.getString(1);
                int cantidad = resultados.getInt(2);
                Avion avion = new Avion(modelo, cantidad);
                lista_Avion.add(avion);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return lista_Avion;

      }
 }
