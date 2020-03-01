package pl.springboot.file.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class   RodzajRozkladu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "typ_rozkladu")
    private TypRozkladu typRozkladu;
    private String linia;
    private String brygada;
    private String godzina;
    private String miejsceZmiany;
    private String pierwszaLinia;

//    @Transient
//    private MultipartFile file;

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

}
