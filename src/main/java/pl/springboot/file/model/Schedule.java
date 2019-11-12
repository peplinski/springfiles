package pl.springboot.file.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "date")
    private String date;
    //@Enumerated(value = EnumType.STRING)
    @Column(name = "rodzaj_rozkladu")
    private String rodzajRozkladu;
    @Column(name = "nr_sluzbowy")
    private String nrSluzbowy;
    @Column(name = "linia")
    private String linia;
    @Column(name = "poczatekPracy")
    private String poczatekPracy;
    @Column(name = "koniecPracy")
    private String koniecPracy;
    @Column(name = "miejsce_zmiany")
    private String miejsceZmiany;

    @Transient
    private MultipartFile file;


    public Schedule() {
    }

    public Schedule(String date, String rodzajRozkladu, String nrSluzbowy, String linia, String poczatekPracy, String koniecPracy, String miejsceZmiany) {
        this.date = date;
        this.rodzajRozkladu = rodzajRozkladu;
        this.nrSluzbowy = nrSluzbowy;
        this.linia = linia;
        this.poczatekPracy = poczatekPracy;
        this.koniecPracy = koniecPracy;
        this.miejsceZmiany=miejsceZmiany;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRodzajRozkladu() {
        return rodzajRozkladu;
    }

    public void setRodzajRozkladu(String rodzajRozkladu) {
        this.rodzajRozkladu = rodzajRozkladu;
    }

    public String getNrSluzbowy() {
        return nrSluzbowy;
    }

    public void setNrSluzbowy(String nrSluzbowy) {
        this.nrSluzbowy = nrSluzbowy;
    }

    public String getLinia() {
        return linia;
    }

    public void setLinia(String linia) {
        this.linia = linia;
    }

    public String getPoczatekPracy() {
        return poczatekPracy;
    }

    public void setPoczatekPracy(String poczatekPracy) {
        this.poczatekPracy = poczatekPracy;
    }

    public String getKoniecPracy() {
        return koniecPracy;
    }

    public void setKoniecPracy(String koniecPracy) {
        this.koniecPracy = koniecPracy;
    }

    public String getMiejsceZmiany() {
        return miejsceZmiany;
    }

    public void setMiejsceZmiany(String miejsceZmiany) {
        this.miejsceZmiany = miejsceZmiany;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
