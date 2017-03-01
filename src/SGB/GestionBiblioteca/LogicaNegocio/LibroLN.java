package SGB.GestionBiblioteca.LogicaNegocio;

import Conector.Conexion;
import SGB.GestionBiblioteca.AccesoDatos.LibroAD;
import SGB.GestionBiblioteca.Entidades.Libro;
import java.util.List;

public class LibroLN {
    public List<Libro> ConsultarLibros(String nombre) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            LibroAD libroAD = new LibroAD(conexion.getConnection());
            List<Libro> lstlibros = libroAD.Consultar(nombre);
            
            return lstlibros;
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
    
    public Libro ConsultarLibro(Libro obj) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            LibroAD libroAD = new LibroAD(conexion.getConnection());
            Libro libroEncontrado = libroAD.Consultar(obj);
            
            return libroEncontrado;
            
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
    
    public Libro ConsultarLibro(String codigo) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            LibroAD libroAD = new LibroAD(conexion.getConnection());
            Libro libro = libroAD.ConsultarPorCodigo(codigo);
            
            return libro;
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
    
    public Libro ConsultarLibro(Integer id) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            LibroAD libroAD = new LibroAD(conexion.getConnection());
            Libro libro = libroAD.Consutar(id);
            
            return libro;
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
    
    public void RegistrarLibro(Libro obj) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            LibroAD libroAD = new LibroAD(conexion.getConnection());
            libroAD.Insertar(obj);
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
    
    public void ModificarLibro(Libro obj) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            LibroAD libroAD = new LibroAD(conexion.getConnection());
            libroAD.Actualizar(obj);
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
    
    public void EliminarLibro(Libro obj) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            LibroAD libroAD = new LibroAD(conexion.getConnection());
            libroAD.Eliminar(obj);
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
