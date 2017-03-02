package SGB.GestionBiblioteca.Entidades;
public class Autor {
    private Integer Idautor;
    private String Codautor;
    private String Nomautor;
    private String Apepatautor;
    private String Apematautor;

    public Autor() {
    }

    public Autor(Integer Idautor) {
        this.Idautor = Idautor;
    }

    public Autor(Integer Idautor, String Codautor, String Nomautor, String Apepatautor, String Apematautor) {
        this.Idautor = Idautor;
        this.Codautor = Codautor;
        this.Nomautor = Nomautor;
        this.Apepatautor = Apepatautor;
        this.Apematautor = Apematautor;
    }

    public Integer getIdautor() {
        return Idautor;
    }

    public void setIdautor(Integer Idautor) {
        this.Idautor = Idautor;
    }

    public String getCodautor() {
        return Codautor;
    }

    public void setCodautor(String Codautor) {
        this.Codautor = Codautor;
    }

    public String getNomautor() {
        return Nomautor;
    }

    public void setNomautor(String Nomautor) {
        this.Nomautor = Nomautor;
    }

    public String getApepatautor() {
        return Apepatautor;
    }

    public void setApepatautor(String Apepatautor) {
        this.Apepatautor = Apepatautor;
    }

    public String getApematautor() {
        return Apematautor;
    }

    public void setApematautor(String Apematautor) {
        this.Apematautor = Apematautor;
    }

    
    
}
