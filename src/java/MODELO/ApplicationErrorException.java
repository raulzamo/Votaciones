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
public class ApplicationErrorException extends Exception {
    private String lugar;
    private int error;
    public ApplicationErrorException(String message, int error, String lugar) {
        super(message); 
        setError(error);
        setLugar(lugar);
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ApplicationErrorException{" + "lugar=" + lugar + ", error=" + error + '}';
    }
    
    
}
