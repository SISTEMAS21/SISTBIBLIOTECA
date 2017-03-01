package SGB.GestionBiblioteca.Entidades;
public class Libro {
    private Integer Idlibro;
    private String Codlibro;
    private String Nomlibro;
    private Integer Numpag;
    private Integer Edicion;
    private String Genero;
    private Categoria ocategoria;

    public Libro() {
    }

    public Libro(Integer Idlibro) {
        this.Idlibro = Idlibro;
    }

    public Libro(Integer Idlibro, String Codlibro, String Nomlibro, Integer Numpag, Integer Edicion, String Genero, Categoria ocategoria) {
        this.Idlibro = Idlibro;
        this.Codlibro = Codlibro;
        this.Nomlibro = Nomlibro;
        this.Numpag = Numpag;
        this.Edicion = Edicion;
        this.Genero = Genero;
        this.ocategoria = ocategoria;
    }

    public Integer getIdlibro() {
        return Idlibro;
    }

    public void setIdlibro(Integer Idlibro) {
        this.Idlibro = Idlibro;
    }

    public String getCodlibro() {
        return Codlibro;
    }

    public void setCodlibro(String Codlibro) {
        this.Codlibro = Codlibro;
    }

    public String getNomlibro() {
        return Nomlibro;
    }

    public void setNomlibro(String Nomlibro) {
        this.Nomlibro = Nomlibro;
    }

    public Integer getNumpag() {
        return Numpag;
    }

    public void setNumpag(Integer Numpag) {
        this.Numpag = Numpag;
    }

    public Integer getEdicion() {
        return Edicion;
    }

    public void setEdicion(Integer Edicion) {
        this.Edicion = Edicion;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public Categoria getOcategoria() {
        return ocategoria;
    }

    public void setOcategoria(Categoria ocategoria) {
        this.ocategoria = ocategoria;
    }

     
    
}
