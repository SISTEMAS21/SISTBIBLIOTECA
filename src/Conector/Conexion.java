package Conector;

import java.sql.Connection;
import Configuracion.Configuracion;
import java.sql.DriverManager;

public class Conexion {
    private Connection connection;
    
    public void Abrir(boolean autoConfirmacion) throws Exception{
        try {
            String servidor = Configuracion.getServidorBaseDatos();
            String puerto = Configuracion.getPuertoBaseDatos();
            String nombre = Configuracion.getNombreBaseDatos();
            String usuario = Configuracion.getUsuarioBaseDatos();
            String clave = Configuracion.getContrasenaBaseDatos();
            
            String cadenaconnection = "jdbc:mysql://" + servidor + ":" + puerto + "/" + nombre;
            
            connection = DriverManager.getConnection(cadenaconnection,usuario,clave);
            
            connection.setAutoCommit(autoConfirmacion);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Connection getConnection() throws Exception{
        return this.connection;
    }
    
    public void setTRANSACTION_READ_UNCOMMITED() throws Exception{
        try {
            connection.setTransactionIsolation(connection.TRANSACTION_READ_UNCOMMITTED);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void setTRANSACTION_READ_COMMITED() throws Exception{
        try {
            connection.setTransactionIsolation(connection.TRANSACTION_READ_COMMITTED);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void setTRANSACTION_REPEAATABLE_READ() throws Exception{
        try {
            connection.setTransactionIsolation(connection.TRANSACTION_REPEATABLE_READ);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void setTRANSACTION_SERIALIZABLE() throws Exception{
        try {
            connection.setTransactionIsolation(connection.TRANSACTION_SERIALIZABLE);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public boolean EstaCerrada() throws Exception{
        try {
            Boolean cerrada;
            
            if(connection != null){
                cerrada = connection.isClosed();
            }else{
                cerrada = true;
            }
            return cerrada;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void Cerrar() throws Exception{
        try {
            if(!EstaCerrada()){
                connection.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
