/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categoriaResources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.CategoriaFacadeLocal;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.Categoria;

/**
 *
 * @author kevin
 */
@Path("categoria")
public class CategoriaResources implements Serializable{
    
    @EJB
    private CategoriaFacadeLocal categoriaFacade;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Categoria> findAll(){
        List salida=null;
        try {
            if(categoriaFacade!=null){
                salida=categoriaFacade.findAll();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        finally{
            if(salida==null){
                salida=new ArrayList();
            }
        }
       
     return salida;
        
    }
    
    
        
    @GET
    @Path("pag")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Categoria> findRange(
           @DefaultValue("0")@QueryParam("first") int first,
           @DefaultValue("10")@QueryParam("pageSize") int pageSize){
        
        List salida = null;
        try {
            if(categoriaFacade!=null){
                salida=categoriaFacade.findRange(first,pageSize);
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        finally{
            if(salida==null){
                salida=new ArrayList();
            }
        }
       
     return salida;
        
    }
    
     @GET
    @Path("{idCategoria}")
    @Produces({MediaType.APPLICATION_JSON})
    public Categoria findById(
            @PathParam("idCategoria") Integer id){
        
         try {
             if(categoriaFacade!=null && id!=null){
                 return  categoriaFacade.find(id);
             }
         } catch (Exception ex) {
Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
         }
       
        return new Categoria();
    }
    
   
    
    
    
    
    
}
