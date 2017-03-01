package SGB.GestionBiblioteca.LogicaNegocio;

import Conector.Conexion;
import SGB.GestionBiblioteca.AccesoDatos.CategoriaAD;
import SGB.GestionBiblioteca.Entidades.Categoria;
import java.util.List;

public class CategoriaLN {
    public List<Categoria> ConsultarCategorias(String nombre) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            CategoriaAD categoriaAD = new CategoriaAD(conexion.getConnection());
            List<Categoria> lstcategorias = categoriaAD.Consultar(nombre);
            
            return lstcategorias;
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
    
    public Categoria ConsultarCategoria(Categoria obj) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            CategoriaAD categoriaAD = new CategoriaAD(conexion.getConnection());
            Categoria categoriaEncontrado = categoriaAD.Consultar(obj);
            
            return categoriaEncontrado;
            
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
    
    public Categoria ConsultarCategoria(String codigo) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            CategoriaAD categoriaAD = new CategoriaAD(conexion.getConnection());
            Categoria categoria = categoriaAD.ConsultarPorCodigo(codigo);
            
            return categoria;
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
    
    public Categoria ConsultarCategoria(Integer id) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            CategoriaAD categoriaAD = new CategoriaAD(conexion.getConnection());
            Categoria categoria = categoriaAD.Consutar(id);
            
            return categoria;
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
    
    public void RegistrarCategoria(Categoria obj) throws Exception{
        Conexion conexion = null;
        
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            CategoriaAD categoriaAD = new CategoriaAD(conexion.getConnection());
            categoriaAD.Insertar(obj);
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
    
    public void ModificarCategoria(Categoria obj) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            CategoriaAD categoriaAD = new CategoriaAD(conexion.getConnection());
            categoriaAD.Actualizar(obj);
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
    
    public void EliminarCategoria(Categoria obj) throws Exception{
        Conexion conexion = null;
        try {
            conexion = new Conexion();
            conexion.Abrir(true);
            
            CategoriaAD categoriaAD = new CategoriaAD(conexion.getConnection());
            categoriaAD.Eliminar(obj);
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
