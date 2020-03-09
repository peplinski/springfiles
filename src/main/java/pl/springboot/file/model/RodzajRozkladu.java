package pl.springboot.file.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class   RodzajRozkladu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Column(name = "typ_rozkladu")
    private String typRozkladu;
    @NotNull
    private String linia;
    private String brygada;
    @NotNull
    private String godzina;
    @NotNull
    private String miejsceZmiany;
    private String pierwszaLinia;

//    @Transient
//    private MultipartFile file;

}

