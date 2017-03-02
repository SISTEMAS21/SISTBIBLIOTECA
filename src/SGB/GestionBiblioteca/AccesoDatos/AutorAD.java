package SGB.GestionBiblioteca.AccesoDatos;

import Conector.EntidadAD;
import SGB.GestionBiblioteca.Entidades.Autor;
import SGB.GestionBiblioteca.Entidades.Categoria;
import SGB.GestionBiblioteca.Entidades.Autor;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class AutorAD extends EntidadAD{

    public AutorAD(Connection connection) {
        super(connection);
    }
    
    public Integer getId() throws Exception{
        try {
            String  sql = "SELECT MAX(idautor) + 1 AS idautor FROM autor";
            
            Integer id = 1;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                id = rs.getInt("idautor");
                
                if(rs.wasNull()){
                    id = 1;
                }
            }
            return id;
        } catch (Exception e) {
            throw e;
        }
        finally{
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
        }
    }
    
    public String getCodigo() throws Exception{
        try {
            String sql = "select lpad(cast(case when max(cast(codautor as character)) is null then 1 else (max(cast(codautor as character)) + 1) end as character),2,'0') as codautor from autor";
            
            String codigo = "";
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                codigo = rs.getString("codautor");
                
                if(rs.wasNull()){
                    codigo= "01";
                }
            }
            return codigo;
        } catch (Exception e) {
            throw e;
        }
        finally{
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
        }
    }
    
    public List<Autor> Consultar(String nombre) throws Exception{
        try {
            String sql = "select";
            sql = sql + " idautor";
            sql = sql + ",codautor";
            sql = sql + ",nomautor";
            sql = sql + ",apepatautor";
            sql = sql + ",apematautor";
            sql = sql + " from autor";
            sql = sql + " where";
            sql = sql + " nomautor like '%" + nombre +"%'";
            sql = sql + " order by";
            sql = sql + " codautor asc";
            sql = sql + ";";
            
            List<Autor> lista = new ArrayList<Autor>();
            Autor obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            while (rs.next()) {                
                obj = new Autor();
                
                obj.setIdautor(rs.getInt("idautor"));
                obj.setCodautor(rs.getString("codautor"));
                obj.setNomautor(rs.getString("nomautor"));
                obj.setApepatautor(rs.getString("apepatautor"));
                obj.setApematautor(rs.getString("apematautor"));
                
                lista.add(obj);
            }
            
            return lista;
        } catch (Exception e) {
            throw e;
        }
        finally{
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
        }
    }
    
    public Autor Consultar(Autor autor) throws Exception{
        try {
            String sql = "select";
            sql = sql + " idautor";
            sql = sql + " from autor";
            sql = sql + " where";
            sql = sql + " idautor <> " + (autor.getIdautor() == null?"0":autor.getIdautor().toString());
            sql = sql + " and (codautor = '"+ autor.getCodautor() + "'";
            sql = sql + " or nomautor = '" + autor.getNomautor() + "'";
            sql = sql + " or apepatautor = '" + autor.getApepatautor() + "'";
            sql = sql + " or apematautor = '" + autor.getApematautor() + "')";
            sql = sql + ";";
            
            Autor obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                obj = new Autor();
                
                obj.setIdautor(rs.getInt("idautor"));
            }
            return obj;
        } catch (Exception e) {
            throw e;
        }
        finally{
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
        }
    }
    
    public Autor ConsultarPorCodigo(String codigo) throws Exception{
        try {
            String sql = "select";
            sql = sql + " idautor";
            sql = sql + ",codautor";
            sql = sql + ",nomautor";
            sql = sql + ",apepatautor";
            sql = sql + ",apematautor";
            sql = sql + " from autor";
            sql = sql + " where" ;
            sql = sql + " codautor = '" + codigo + "'";
            sql = sql + ";";
            
            Autor obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                obj.setIdautor(rs.getInt("idautor"));
                obj.setCodautor(rs.getString("codautor"));
                obj.setNomautor(rs.getString("nomautor"));
                obj.setApepatautor(rs.getString("apepatautor"));
                obj.setApematautor(rs.getString("apematautor"));
            }
            return obj;
        } catch (Exception e) {
            throw e;
        }
        finally{
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
        }
    }
    
    public Autor Consutar(Integer id) throws Exception{
        try {
                String sql = "select";
            sql = sql + " idautor";
            sql = sql + ",codautor";
            sql = sql + ",nomautor";
            sql = sql + ",apepatautor";
            sql = sql + ",apematautor";
            sql = sql + " from autor";
            sql = sql + " where";
            sql = sql + " idautor = "+ id.toString();
            sql = sql + ";";
            
            Autor obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                obj = new Autor();
                obj.setIdautor(rs.getInt("idautor"));
                obj.setCodautor(rs.getString("codautor"));
                obj.setNomautor(rs.getString("nomautor"));
                obj.setApepatautor(rs.getString("apepatautor"));
                obj.setApematautor(rs.getString("apematautor"));
            }
            return obj;
        } catch (Exception e) {
            throw e;
        }
        finally{
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
        }
    }
    
    public void Insertar(Autor obj) throws Exception{
        try {
            obj.setIdautor(getId());
            obj.setCodautor(getCodigo());
            
            String dml = "insert into autor(";
            dml = dml + " idautor";
            dml = dml + ",codautor";
            dml = dml + ",nomautor";
            dml = dml + ",apepatautor";
            dml = dml + ",apematautor";
            dml = dml + ") values (";
            dml = dml + " '"+ obj.getIdautor().toString() +"'";
            dml = dml + ",'" + obj.getCodautor() + "'";
            dml = dml + ",'" + obj.getNomautor() + "'";
            dml = dml + ",'" + obj.getApepatautor() + "'";
            dml = dml + ",'" + obj.getApematautor() + "'";
            dml = dml + ");";
            
            EjecutarSentenciaDML(dml);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void Actualizar(Autor obj) throws Exception{
        try {
            String dml = "update autor set";
            dml = dml + " codautor = '" +obj.getCodautor() + "'";
            dml = dml + ",nomautor = '" +obj.getNomautor() + "'";
            dml = dml + ",apepatautor = '" +obj.getApepatautor() + "'";
            dml = dml + ",apematautor = '" +obj.getApematautor() + "'";
            dml = dml + " where";
            dml = dml + " idautor = " + obj.getIdautor().toString();
            dml = dml + ";";
            
            EjecutarSentenciaDML(dml);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void Eliminar(Autor obj) throws Exception{
        try {
            String dml = "delete from autor";
            dml = dml + " where";
            dml = dml + " idautor = " + obj.getIdautor().toString();
            dml = dml + ";";
            
            EjecutarSentenciaDML(dml);
        } catch (Exception e) {
            throw e;
        }
    }
}
