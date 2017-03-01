package SGB.GestionBiblioteca.AccesoDatos;

import Conector.EntidadAD;
import SGB.GestionBiblioteca.Entidades.Categoria;
import SGB.GestionBiblioteca.Entidades.Libro;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class LibroAD extends EntidadAD{

    public LibroAD(Connection connection) {
        super(connection);
    }
    
    public Integer getId() throws Exception{
        try {
            String  sql = "SELECT MAX(idlibro) + 1 AS idlibro FROM libro";
            
            Integer id = 1;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                id = rs.getInt("idlibro");
                
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
            String sql = "select lpad(cast(case when max(cast(codlibro as character)) is null then 1 else (max(cast(codlibro as character)) + 1) end as character),2,'0') as codlibro from libro";
            
            String codigo = "";
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                codigo = rs.getString("codlibro");
                
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
    
    public List<Libro> Consultar(String nombre) throws Exception{
        try {
            String sql = "select";
            sql = sql + " libro.idlibro";
            sql = sql + ",libro.codlibro";
            sql = sql + ",libro.nomlibro";
            sql = sql + ",libro.numpag";
            sql = sql + ",libro.edicion";
            sql = sql + ",libro.genero";
            sql = sql + ",libro.idcat";
            sql = sql + ",libro.codcat";
            sql = sql + ",libro.nomcat";
            sql = sql + " from libro";
            sql = sql + " where";
            sql = sql + " nomlibro like '%" + nombre +"%'";
            sql = sql + " order by";
            sql = sql + " codlibro asc";
            sql = sql + ";";
            
            List<Libro> lista = new ArrayList<Libro>();
            Libro obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            while (rs.next()) {                
                obj = new Libro();
                
                obj.setIdlibro(rs.getInt("idlibro"));
                obj.setCodlibro(rs.getString("codlibro"));
                obj.setNomlibro(rs.getString("nomlibro"));
                obj.setNumpag(rs.getInt("numpag"));
                obj.setEdicion(rs.getInt("edicion"));
                obj.setGenero(rs.getString("genero"));
                obj.setOcategoria(new Categoria(rs.getInt("idcat"),rs.getString("codcat"),rs.getString("nomcat")));
                
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
    
    public Libro Consultar(Libro libro) throws Exception{
        try {
            String sql = "select";
            sql = sql + " idlibro";
            sql = sql + " from libro";
            sql = sql + " where";
            sql = sql + " idlibro <> " + (libro.getIdlibro() == null?"0":libro.getIdlibro().toString());
            sql = sql + " and (codlibro = '"+ libro.getCodlibro() + "'";
            sql = sql + " or nomlibro = '" + libro.getNomlibro() + "'";
            sql = sql + " or numpag = '" + libro.getNumpag() + "'";
            sql = sql + " or edicion = '" + libro.getEdicion() + "'";
            sql = sql + " or genero = '" + libro.getGenero() + "'";
            sql = sql + " and idcat = '" + libro.getOcategoria().getIdcat() + "')";
            sql = sql + ";";
            
            Libro obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                obj = new Libro();
                
                obj.setIdlibro(rs.getInt("idlibro"));
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
    
    public Libro ConsultarPorCodigo(String codigo) throws Exception{
        try {
            String sql = "select";
            sql = sql + " libro.idlibro";
            sql = sql + ",libro.codlibro";
            sql = sql + ",libro.nomlibro";
            sql = sql + ",libro.numpag";
            sql = sql + ",libro.edicion";
            sql = sql + ",libro.genero";
            sql = sql + ",libro.idcat";
            sql = sql + ",libro.codcat";
            sql = sql + ",libro.nomcat";
            sql = sql + " from libro";
            sql = sql + " where" ;
            sql = sql + " codlibro = '" + codigo + "'";
            sql = sql + ";";
            
            Libro obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                obj.setIdlibro(rs.getInt("idlibro"));
                obj.setCodlibro(rs.getString("codlibro"));
                obj.setNomlibro(rs.getString("nomlibro"));
                obj.setNumpag(rs.getInt("numpag"));
                obj.setEdicion(rs.getInt("edicion"));
                obj.setGenero(rs.getString("genero"));
                obj.setOcategoria(new Categoria(rs.getInt("idcat"),rs.getString("codcat"),rs.getString("nomcat")));
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
    
    public Libro Consutar(Integer id) throws Exception{
        try {
            String sql = "select";
            sql = sql + " libro.idlibro";
            sql = sql + ",libro.codlibro";
            sql = sql + ",libro.nomlibro";
            sql = sql + ",libro.numpag";
            sql = sql + ",libro.edicion";
            sql = sql + ",libro.genero";
            sql = sql + ",libro.idcat";
            sql = sql + ",libro.codcat";
            sql = sql + ",libro.nomcat";
            sql = sql + " from libro";
            sql = sql + " where";
            sql = sql + " idlibro = "+ id.toString();
            sql = sql + ";";
            
            Libro obj = null;
            
            EjecutarSentenciaSQL(sql);
            
            rs.beforeFirst();
            
            if(rs.next()){
                obj = new Libro();
                obj.setIdlibro(rs.getInt("idlibro"));
                obj.setCodlibro(rs.getString("codlibro"));
                obj.setNomlibro(rs.getString("nomlibro"));
                obj.setNumpag(rs.getInt("numpag"));
                obj.setEdicion(rs.getInt("edicion"));
                obj.setGenero(rs.getString("genero"));
                obj.setOcategoria(new Categoria(rs.getInt("idcat"),rs.getString("codcat"),rs.getString("nomcat")));
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
    
    public void Insertar(Libro obj) throws Exception{
        try {
            obj.setIdlibro(getId());
            obj.setCodlibro(getCodigo());
            
            String dml = "insert into libro(";
            dml = dml + " idlibro";
            dml = dml + ",codlibro";
            dml = dml + ",nomlibro";
            dml = dml + ",numpag";
            dml = dml + ",edicion";
            dml = dml + ",genero";
            dml = dml + ",idcat";
            dml = dml + ") values (";
            dml = dml + " '"+ obj.getIdlibro().toString() +"'";
            dml = dml + ",'" + obj.getCodlibro() + "'";
            dml = dml + ",'" + obj.getNomlibro() + "'";
            dml = dml + ",'" + obj.getNumpag() + "'";
            dml = dml + ",'" + obj.getEdicion() + "'";
            dml = dml + ",'" + obj.getGenero() + "'";
            dml = dml + ",'" + obj.getOcategoria().getIdcat() + "'";
            dml = dml + ");";
            
            EjecutarSentenciaDML(dml);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void Actualizar(Libro obj) throws Exception{
        try {
            String dml = "update libro set";
            dml = dml + " codlibro = '" +obj.getCodlibro() + "'";
            dml = dml + ",nomlibro = '" +obj.getNomlibro() + "'";
            dml = dml + ",numpag = '" +obj.getNumpag() + "'";
            dml = dml + ",edicion = '" +obj.getEdicion() + "'";
            dml = dml + ",genero = '" +obj.getGenero() + "'";
            dml = dml + ",idcat = '" +obj.getOcategoria().getIdcat() + "'";
            dml = dml + " where";
            dml = dml + " idlibro = " + obj.getIdlibro().toString();
            dml = dml + ";";
            
            EjecutarSentenciaDML(dml);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void Eliminar(Libro obj) throws Exception{
        try {
            String dml = "delete from libro";
            dml = dml + " where";
            dml = dml + " idlibro = " + obj.getIdlibro().toString();
            dml = dml + ";";
            
            EjecutarSentenciaDML(dml);
        } catch (Exception e) {
            throw e;
        }
    }
}
