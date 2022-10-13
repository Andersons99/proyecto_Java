/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author Anderson Sachez
 */
public class Avion {
    private int id;
    private String modelo;
    private int numero_asientos;
    private int numero_banos;
    private double capasiad_max_peso;
    private int cantidad;

    public Avion() {
    }

    public Avion(String modelo, int cantidad) {
        this.modelo = modelo;
        this.cantidad = cantidad;
    }

    public Avion(int id, String modelo, int numero_asientos, int numero_banos, double capasiad_max_peso) {
        this.id = id;
        this.modelo = modelo;
        this.numero_asientos = numero_asientos;
        this.numero_banos = numero_banos;
        this.capasiad_max_peso = capasiad_max_peso;
     
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the numero_asientos
     */
    public int getNumero_asientos() {
        return numero_asientos;
    }

    /**
     * @param numero_asientos the numero_asientos to set
     */
    public void setNumero_asientos(int numero_asientos) {
        this.numero_asientos = numero_asientos;
    }

    /**
     * @return the numero_banos
     */
    public int getNumero_banos() {
        return numero_banos;
    }

    /**
     * @param numero_banos the numero_banos to set
     */
    public void setNumero_banos(int numero_banos) {
        this.numero_banos = numero_banos;
    }

    /**
     * @return the capasiad_max_peso
     */
    public double getCapasiad_max_peso() {
        return capasiad_max_peso;
    }

    /**
     * @param capasiad_max_peso the capasiad_max_peso to set
     */
    public void setCapasiad_max_peso(double capasiad_max_peso) {
        this.capasiad_max_peso = capasiad_max_peso;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
 
    
   
}
