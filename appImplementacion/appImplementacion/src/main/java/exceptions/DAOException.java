/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author tilin
 */
public class DAOException extends Exception {
    /**
     * Método constructor de la clase DAOException.
     */
    public DAOException(){
        
    }
    /**
     * 
     * @param n parámetro n
     */
    public DAOException(String n){
        super(n);
    }
    
    /**
     * 
     * @param n parámetro n
     * @param t parámetro t
     */
    public DAOException(String n, Throwable t){
        super(n,t);
    }
    
    /**
     * 
     * @param t parámetro t
     */
    public DAOException(Throwable t){
        super(t);
    }
    
}
