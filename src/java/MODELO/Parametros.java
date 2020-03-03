/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.time.LocalDate;

/**
 *
 * @author Raul
 */
public class Parametros {
    private int id;
    private String circuspripcion;
    private int candidatos_elegir;
    private String tipo_consulta;
    private LocalDate fecha_consulta;
    private String estado_escrutinio;
    private String frase;
    
    public Parametros(){};
    
    public Parametros(String circuspripcion, int candidatos_elegir, String tipo_consulta, LocalDate fecha_consulta, String estado_escrutinio, String frase) {
        this.circuspripcion = circuspripcion;
        this.candidatos_elegir = candidatos_elegir;
        this.tipo_consulta = tipo_consulta;
        this.fecha_consulta = fecha_consulta;
        this.estado_escrutinio = estado_escrutinio;
        this.frase = frase;
    }

        
    public String getCircuspripcion() {
        return circuspripcion;
    }

    public void setCircuspripcion(String circuspripcion) {
        this.circuspripcion = circuspripcion;
    }

    public int getCandidatos_elegir() {
        return candidatos_elegir;
    }

    public void setCandidatos_elegir(int candidatos_elegir) {
        this.candidatos_elegir = candidatos_elegir;
    }

    public String getTipo_consulta() {
        return tipo_consulta;
    }

    public void setTipo_consulta(String tipo_consulta) {
        this.tipo_consulta = tipo_consulta;
    }

    public LocalDate getFecha_consulta() {
        return fecha_consulta;
    }

    public void setFecha_consulta(LocalDate fecha_consulta) {
        this.fecha_consulta = fecha_consulta;
    }

    public String getEstado_escrutinio() {
        return estado_escrutinio;
    }

    public void setEstado_escrutinio(String estado_escrutinio) {
        this.estado_escrutinio = estado_escrutinio;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }
    
    
    
}
