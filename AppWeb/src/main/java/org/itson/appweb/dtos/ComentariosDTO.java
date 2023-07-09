/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.appweb.dtos;

import ObjNegocio.Comentario;
import ObjNegocio.Comun;
import ObjNegocio.Normal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hoshi
 */
public class ComentariosDTO {
    
    private Date fechaHora;
    private String contenido;
    private Comun comun;


    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Comun getComun() {
        return comun;
    }

    public void setComun(Comun comun) {
        this.comun = comun;
    }

    
    
}
