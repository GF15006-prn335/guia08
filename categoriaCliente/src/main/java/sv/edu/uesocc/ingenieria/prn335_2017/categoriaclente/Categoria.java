/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.categoriaclente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author kevin
 */
@Named("categoria")
@ViewScoped
public class Categoria implements Serializable{
 
    Client cliente;
    
    public Categoria(){
     
        try {
            cliente = ClientBuilder.newClient();
        } catch (Exception ex) {
        Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);

        }
    }
    
    public List<Categoria> findAll(){
        List<Categoria> salida=null;
        try {
            WebTarget target = cliente.target("localhost:8080/guia07-1.0-SNAPSHOT/webresources/categoria");
            salida= target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Categoria>>(){});
       return salida;
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);

        }finally{
            if(salida==null){
                salida= new ArrayList<>();
            }
        }
         return salida;
    }
    
      public List<Categoria> findRange(int first,int pageSize){
        List<Categoria> salida=null;
        try {
            WebTarget target = cliente.target
        ("localhost:8080/guia07-1.0-SNAPSHOT/webresources/categoria").path("pag").
        queryParam("first",0).queryParam("pageSize",10);
            salida= target.request(MediaType.APPLICATION_JSON).
                    get(new GenericType<List<Categoria>>(){});
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);

        }finally{
            if(salida==null){
                salida= new ArrayList<>();
            }
        }
         return salida;
    }
      
      public List<Categoria> findById(Integer id){
        List<Categoria> salida=null;
        try {
            WebTarget target = cliente.target
        ("localhost:8080/guia07-1.0-SNAPSHOT/webresources/categoria").
                    path("{idCategoria}").resolveTemplate("idCategoria",id);
            salida= target.request(MediaType.APPLICATION_JSON).
                    get(new GenericType<List<Categoria>>(){});
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);

        }finally{
            if(salida==null){
                salida= new ArrayList<>();
            }
        }
         return salida;
    }
   
    
    
}
