/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author Anderson Sachez
 */
public class Ruta extends Aeropuerto{
    private int idruta;
    private int origen;
    private int desino;
    private int tiempo_estimado; 
    private String nombre_origen;
    private String nombre_destino;

    public Ruta() {
    }
     public Ruta(int idruta, int origen, int desino, int tiempo_estimado) {
        this.idruta = idruta;
        this.origen = origen;
        this.desino = desino;
        this.tiempo_estimado = tiempo_estimado;
       
    }

    public Ruta(int idruta, int origen, int desino, int tiempo_estimado, String nombre_origen, String nombre_destino) {
        this.idruta = idruta;
        this.origen = origen;
        this.desino = desino;
        this.tiempo_estimado = tiempo_estimado;
        this.nombre_origen = nombre_origen;
        this.nombre_destino = nombre_destino;
    }

    public Ruta(int idruta, int origen, int desino, int tiempo_estimado, String nombre_origen, String nombre_destino, int id, String nombre, String ciudad, String pais, double coord_x, double coord_y) {
        super(id, nombre, ciudad, pais, coord_x, coord_y);
        this.idruta = idruta;
        this.origen = origen;
        this.desino = desino;
        this.tiempo_estimado = tiempo_estimado;
        this.nombre_origen = nombre_origen;
        this.nombre_destino = nombre_destino;
    }
    

    /**
     * @return the idruta
     */
    public int getIdruta() {
        return idruta;
    }

    /**
     * @param idruta the idruta to set
     */
    public void setIdruta(int idruta) {
        this.idruta = idruta;
    }

    /**
     * @return the origen
     */
    public int getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(int origen) {
        this.origen = origen;
    }

    /**
     * @return the desino
     */
    public int getDesino() {
        return desino;
    }

    /**
     * @param desino the desino to set
     */
    public void setDesino(int desino) {
        this.desino = desino;
    }

    /**
     * @return the tiempo_estimado
     */
    public int getTiempo_estimado() {
        return tiempo_estimado;
    }

    /**
     * @param tiempo_estimado the tiempo_estimado to set
     */
    public void setTiempo_estimado(int tiempo_estimado) {
        this.tiempo_estimado = tiempo_estimado;
    }

    /**
     * @return the nombre_origen
     */
    public String getNombre_origen() {
        return nombre_origen;
    }

    /**
     * @param nombre_origen the nombre_origen to set
     */
    public void setNombre_origen(String nombre_origen) {
        this.nombre_origen = nombre_origen;
    }

    /**
     * @return the nombre_destino
     */
    public String getNombre_destino() {
        return nombre_destino;
    }

    /**
     * @param nombre_destino the nombre_destino to set
     */
    public void setNombre_destino(String nombre_destino) {
        this.nombre_destino = nombre_destino;
    }

   
    
   
}
