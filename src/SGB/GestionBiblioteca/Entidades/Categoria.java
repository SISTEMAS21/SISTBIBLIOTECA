package SGB.GestionBiblioteca.Entidades;
public class Categoria {
    private Integer Idcat;
    private String Codcat;
    private String Nomcat;

    public Categoria() {
    }

    public Categoria(Integer Idcat) {
        this.Idcat = Idcat;
    }

    public Categoria(Integer Idcat, String Codcat, String Nomcat) {
        this.Idcat = Idcat;
        this.Codcat = Codcat;
        this.Nomcat = Nomcat;
    }

    public Integer getIdcat() {
        return Idcat;
    }

    public void setIdcat(Integer Idcat) {
        this.Idcat = Idcat;
    }

    public String getCodcat() {
        return Codcat;
    }

    public void setCodcat(String Codcat) {
        this.Codcat = Codcat;
    }

    public String getNomcat() {
        return Nomcat;
    }

    public void setNomcat(String Nomcat) {
        this.Nomcat = Nomcat;
    }
    
    
    
    
    
}
