package pl.springboot.file.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "date")
    private String date;
    @Column(name = "typ_rozkladu")
    private String typRozkladu;
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

}
