package ar.solPiqueras.disney.data.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "genres")
public class GenreEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idGenre;

    @NotEmpty
    @Column(nullable = false)
    private String genreImage;

    @NotEmpty
    @Column(nullable = false)
    private String genreName;

    @OneToMany(mappedBy = "genre")
    @JsonBackReference
    private Set<MovieEntity> movie;
}
