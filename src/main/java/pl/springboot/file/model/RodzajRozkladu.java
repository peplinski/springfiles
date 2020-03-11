package pl.springboot.file.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class   RodzajRozkladu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min = 2,max = 30,message = "typ powinien się mieścić między 2 a 30 znakami")
    @Column(name = "typ_rozkladu")
    private String typRozkladu;
    @NotNull
    @Size(min = 1,max = 5,message = "nie może być pusta, max 5 znaków")
    private String linia;
    @NotNull
    private String brygada;
    @NotNull
    private String godzina;
    @NotNull
    @Size(min = 3,max = 255,message = "nie może być puste")
    private String miejsceZmiany;
    @NotNull
    @Size(min = 1,max = 5,message = "wprowadź pierwszą linię z rozkładu")
    private String pierwszaLinia;

//    @Transient
//    private MultipartFile file;

}

