package SGB.GestionBiblioteca.LogicaNegocio;

import Conector.Conexion;
import SGB.GestionBiblioteca.AccesoDatos.AutorAD;
import SGB.GestionBiblioteca.Entidades.Autor;
import java.util.List;

public class AutorLN {
    public List<Autor> ConsultarAutores(String nombre) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            AutorAD autorAD = new AutorAD(conexion.getConnection());
            List<Autor> lstautores = autorAD.Consultar(nombre);
            
            return lstautores;
        } catch (Exception e) {
            throw e;
        }
        finally{
            if(conexion != null){
                if(conexion.getConnection() != null){
                    if(!conexion.EstaCerrada()){
                        conexion.Cerrar();
                    }
                }
            }
        }
    }
    
    public Autor ConsultarAutor(Autor obj) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            AutorAD autorAD = new AutorAD(conexion.getConnection());
            Autor autorEncontrado = autorAD.Consultar(obj);
            
            return autorEncontrado;
            
        } catch (Exception e) {
            throw e;
        }
        finally{
            if(conexion != null){
                if(conexion.getConnection() != null){
                    if(!conexion.EstaCerrada()){
                        conexion.Cerrar();
                    }
                }
            }
        }
    }
    
    public Autor ConsultarAutor(String codigo) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            AutorAD autorAD = new AutorAD(conexion.getConnection());
            Autor autor = autorAD.ConsultarPorCodigo(codigo);
            
            return autor;
        } 
        catch (Exception e) {
            throw e;
        }
        finally{
            if(conexion != null){
                if(conexion.getConnection() != null){
                    if(!conexion.EstaCerrada()){
                        conexion.Cerrar();
                    }
                }
            }
        }
    }
    
    public Autor ConsultarAutor(Integer id) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            AutorAD autorAD = new AutorAD(conexion.getConnection());
            Autor autor = autorAD.Consutar(id);
            
            return autor;
        } 
        catch (Exception e) {
            throw e;
        }
        finally{
            if(conexion != null){
                if(conexion.getConnection() != null){
                    if(!conexion.EstaCerrada()){
                        conexion.Cerrar();
                    }
                }
            }
        }
    }
    
    public void RegistrarAutor(Autor obj) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            AutorAD autorAD = new AutorAD(conexion.getConnection());
            autorAD.Insertar(obj);
        } 
        catch (Exception e) {
            throw e;
        }
        finally{
            if(conexion != null){
                if(conexion.getConnection() != null){
                    if(!conexion.EstaCerrada()){
                        conexion.Cerrar();
                    }
                }
            }
        }
    }
    
    public void ModificarAutor(Autor obj) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            AutorAD autorAD = new AutorAD(conexion.getConnection());
            autorAD.Actualizar(obj);
        } 
        catch (Exception e) {
            throw e;
        }
        finally{
            if(conexion != null){
                if(conexion.getConnection() != null){
                    if(!conexion.EstaCerrada()){
                        conexion.Cerrar();
                    }
                }
            }
        }
    }
    
    public void EliminarAutor(Autor obj) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            AutorAD autorAD = new AutorAD(conexion.getConnection());
            autorAD.Eliminar(obj);
        } 
        catch (Exception e) {
            throw e;
        }
        finally{
            if(conexion != null){
                if(conexion.getConnection() != null){
                    if(!conexion.EstaCerrada()){
                        conexion.Cerrar();
                    }
                }
            }
        }
    }
}
