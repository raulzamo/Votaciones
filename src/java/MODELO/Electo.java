/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

/**
 *
 * @author Raul
 */
public class Electo {
    
    private int id;
    private String siglasPartido;
    private String logo;
    private String nombreElecto;
    

    public Electo(){
    }

    public Electo(int id, String siglasPartido, String logo, String nombreElecto) {
        this.id = id;
        this.siglasPartido = siglasPartido;
        this.logo = logo;
        this.nombreElecto = nombreElecto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getSiglasPartido() {
        return siglasPartido;
    }

    public void setSiglasPartido(String siglasPartido) {
        this.siglasPartido = siglasPartido;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNombreElecto() {
        return nombreElecto;
    }

    public void setNombreElecto(String nombreElecto) {
        this.nombreElecto = nombreElecto;
    }

    @Override
    public String toString() {
        return "Electo{" + "id=" + id + ", siglasPartido=" + siglasPartido + ", logo=" + logo + ", nombreElecto=" + nombreElecto + '}';
    }
    
    
    
}
