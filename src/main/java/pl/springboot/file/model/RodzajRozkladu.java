package pl.springboot.file.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class   RodzajRozkladu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "typ_rozkladu")
    private String typRozkladu;
    private String linia;
    private String brygada;
    private String godzina;
    private String miejsceZmiany;
    private String pierwszaLinia;

//    @Transient
//    private MultipartFile file;

}
