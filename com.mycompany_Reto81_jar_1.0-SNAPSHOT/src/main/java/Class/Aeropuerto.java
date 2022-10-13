/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author Anderson Sachez
 */
public class Aeropuerto {
    private int id;
    private String nombre;
    private String ciudad;
    private String pais;
    private double coord_x;
    private double coord_y;
    private int cantidad;

    public Aeropuerto(String pais, int cantidad) {
        
        this.pais = pais;
        this.cantidad = cantidad;
       
    }
    
    

    public Aeropuerto(int id, String nombre, String ciudad, String pais, double coord_x, double coord_y) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.coord_x = coord_x;
        this.coord_y = coord_y;
    }

    public Aeropuerto() {
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the coord_x
     */
    public double getCoord_x() {
        return coord_x;
    }

    /**
     * @param coord_x the coord_x to set
     */
    public void setCoord_x(double coord_x) {
        this.coord_x = coord_x;
    }

    /**
     * @return the coord_y
     */
    public double getCoord_y() {
        return coord_y;
    }

    /**
     * @param coord_y the coord_y to set
     */
    public void setCoord_y(double coord_y) {
        this.coord_y = coord_y;
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
