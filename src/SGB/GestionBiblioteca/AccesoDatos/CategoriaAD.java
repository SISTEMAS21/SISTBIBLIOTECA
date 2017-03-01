package SGB.GestionBiblioteca.AccesoDatos;

import Conector.EntidadAD;
import SGB.GestionBiblioteca.Entidades.Categoria;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class CategoriaAD extends EntidadAD{

    public CategoriaAD(Connection connection) {
        super(connection);
    }
    
    public Integer getId() throws Exception{
        try {
            String  sql = "SELECT MAX(idcat) + 1 AS idcat FROM categoria";
            
            Integer id = 1;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                id = rs.getInt("idcat");
                
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
            String sql = "select lpad(cast(case when max(cast(codcat as character)) is null then 1 else (max(cast(codcat as character)) + 1) end as character),2,'0') as codcat from categoria";
            
            String codigo = "";
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                codigo = rs.getString("codcat");
                
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
    
    public List<Categoria> Consultar(String nombre) throws Exception{
        try {
            String sql = "select";
            sql = sql + " idcat";
            sql = sql + ",codcat";
            sql = sql + ",nomcat";
            sql = sql + " from categoria";
            sql = sql + " where";
            sql = sql + " nomcat like '%" + nombre +"%'";
            sql = sql + " order by";
            sql = sql + " codcat asc";
            sql = sql + ";";
            
            List<Categoria> lista = new ArrayList<Categoria>();
            Categoria obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            while (rs.next()) {                
                obj = new Categoria();
                
                obj.setIdcat(rs.getInt("idcat"));
                obj.setCodcat(rs.getString("codcat"));
                obj.setNomcat(rs.getString("nomcat"));
                
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
    
    public Categoria Consultar(Categoria categoria) throws Exception{
        try {
            String sql = "select";
            sql = sql + " idcat";
            sql = sql + " from categoria";
            sql = sql + " where";
            sql = sql + " idcat <> " + (categoria.getIdcat() == null?"0":categoria.getIdcat().toString());
            sql = sql + " and (codcat = '"+ categoria.getCodcat() + "'";
            sql = sql + " or nomcat = '" + categoria.getNomcat() + "')";
            sql = sql + ";";
            
            Categoria obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                obj = new Categoria();
                
                obj.setIdcat(rs.getInt("idcat"));
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
    
    public Categoria ConsultarPorCodigo(String codigo) throws Exception{
        try {
            String sql = "select";
            sql = sql + " idcat";
            sql = sql + ",codcat";
            sql = sql + ",nomcat";
            sql = sql + " from categoria";
            sql = sql + " where" ;
            sql = sql + " codcat = '" + codigo + "'";
            sql = sql + ";";
            
            Categoria obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                obj = new Categoria();
                obj.setIdcat(rs.getInt("idcat"));
                obj.setCodcat(rs.getString("codcat"));
                obj.setNomcat(rs.getString("nomcat"));
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
    
    public Categoria Consutar(Integer id) throws Exception{
        try {
            String sql = "select";
            sql = sql + " idcat";
            sql = sql + ",codcat";
            sql = sql + ",nomcat";
            sql = sql + " from categoria";
            sql = sql + " where";
            sql = sql + " idcat = "+ id.toString();
            sql = sql + ";";
            
            Categoria obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                obj = new Categoria();
                obj.setIdcat(rs.getInt("idcat"));
                obj.setCodcat(rs.getString("codcat"));
                obj.setNomcat(rs.getString("nomcat"));
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
    
    public void Insertar(Categoria obj) throws Exception{
        try {
            obj.setIdcat(getId());
            obj.setCodcat(getCodigo());
            
            String dml = "insert into categoria(";
            dml = dml + " idcat";
            dml = dml + ",codcat";
            dml = dml + ",nomcat";
            dml = dml + ") values (";
            dml = dml + " '"+ obj.getIdcat().toString() +"'";
            dml = dml + ",'" + obj.getCodcat() + "'";
            dml = dml + ",'" + obj.getNomcat() + "'";
            dml = dml + ");";
            
            EjecutarSentenciaDML(dml);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void Actualizar(Categoria obj) throws Exception{
        try {
            String dml = "update categoria set";
            dml = dml + " codcat = '" +obj.getCodcat() + "'";
            dml = dml + ",nomcat = '" +obj.getNomcat() + "'";
            dml = dml + " where";
            dml = dml + " idcat = " + obj.getIdcat().toString();
            dml = dml + ";";
            
            EjecutarSentenciaDML(dml);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void Eliminar(Categoria obj) throws Exception{
        try {
            String dml = "delete from categoria";
            dml = dml + " where";
            dml = dml + " idcat = " + obj.getIdcat().toString();
            dml = dml + ";";
            
            EjecutarSentenciaDML(dml);
        } catch (Exception e) {
            throw e;
        }
    }
}
