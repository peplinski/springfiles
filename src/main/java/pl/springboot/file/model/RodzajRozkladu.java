package pl.springboot.file.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class   RodzajRozkladu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String typRozkladu;
    private String linia;
    private String brygada;
    private String godzina;
    private String miejsceZmiany;
    private String pierwszaLinia;

    @Transient
    private MultipartFile file;

    public  RodzajRozkladu() {
    }

    public RodzajRozkladu(String typRozkladu, String linia, String brygada, String godzina, String miejsceZmiany, String pierwszaLinia) {
        this.typRozkladu = typRozkladu;
        this.linia = linia;
        this.brygada = brygada;
        this.godzina = godzina;
        this.miejsceZmiany = miejsceZmiany;
        this.pierwszaLinia = pierwszaLinia;
    }

    public RodzajRozkladu(Long id, String typRozkladu, String linia, String brygada, String godzina, String miejsceZmiany, String pierwszaLinia) {
        this.id = id;
        this.typRozkladu = typRozkladu;
        this.linia = linia;
        this.brygada = brygada;
        this.godzina = godzina;
        this.miejsceZmiany = miejsceZmiany;
        this.pierwszaLinia =pierwszaLinia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypRozkladu() {
        return typRozkladu;
    }

    public void setTypRozkladu(String typRozkladu) {
        this.typRozkladu = typRozkladu;
    }

    public String getLinia() {
        return linia;
    }

    public void setLinia(String linia) {
        this.linia = linia;
    }

    public String getBrygada() {
        return brygada;
    }

    public void setBrygada(String brygada) {
        this.brygada = brygada;
    }

    public String getGodzina() {
        return godzina;
    }

    public void setGodzina(String godzina) {
        this.godzina = godzina;
    }

    public String getMiejsceZmiany() {
        return miejsceZmiany;
    }

    public void setMiejsceZmiany(String miejsceZmiany) {
        this.miejsceZmiany = miejsceZmiany;
    }

    public String getPierwszaLinia() {
        return pierwszaLinia;
    }

    public void setPierwszaLinia(String pierwszaLinia) {
        this.pierwszaLinia = pierwszaLinia;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RodzajRozkladu that = (RodzajRozkladu) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(typRozkladu, that.typRozkladu) &&
                Objects.equals(linia, that.linia) &&
                Objects.equals(brygada, that.brygada) &&
                Objects.equals(godzina, that.godzina) &&
                Objects.equals(miejsceZmiany, that.miejsceZmiany) &&
                Objects.equals(pierwszaLinia, that.pierwszaLinia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typRozkladu, linia, brygada, godzina, miejsceZmiany, pierwszaLinia);
    }
    //na pozniej napisac conwerter implements Converter<String, enumClass>
//    NIEDZIELA("niedziela"),
//    SOBOTA("sobota"),
//    POWSZEDNI_SZKOLNY("powszedni szkolny"),
//    POWSZEDNI_FERIE("powszedni ferie"),
//    POWSZEDNI_WAKACJE("powszedni wakacje"),
//    SPECJALNY("specjalny");
//
//    private String pierwszaLinia;
//
//    private RodzajRozkladu(String pierwszaLinia){
//        this.pierwszaLinia=pierwszaLinia;
//    }
//    public String getPierwszaLinia(){
//        return pierwszaLinia;
//    }

}
