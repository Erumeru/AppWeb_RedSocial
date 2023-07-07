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
    private Comentario comentario;
    private List<Comentario> comentarios;
    private Normal normal;

    public ComentariosDTO() {
    }

    public ComentariosDTO(Date fechaHora, String contenido, Comun comun, Comentario comentario, List<Comentario> comentarios, Normal normal) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.comun = comun;
        this.comentario = comentario;
        this.comentarios = comentarios;
        this.normal = normal;
    }

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

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Normal getNormal() {
        return normal;
    }

    public void setNormal(Normal normal) {
        this.normal = normal;
    }
    
    
}
