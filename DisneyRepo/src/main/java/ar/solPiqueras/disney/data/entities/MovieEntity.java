package ar.solPiqueras.disney.data.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movies")
public class MovieEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idMovie;

    @NotEmpty
    @Column(nullable = false)
    private String movieImage;

    @NotEmpty
    @Column(nullable = false)
    private String title;

    @NotEmpty
    @Column(nullable = false)
    private Date releaseDate;

    @NotEmpty
    @Column(nullable = false)
    private int rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idGenre", nullable=false)
    private GenreEntity genre;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "casting",
            joinColumns = {@JoinColumn(name = "idMovie", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name="idCharacter", nullable = false)}
    )
    @JsonBackReference
    private Set<CharacterEntity> characters;
}
