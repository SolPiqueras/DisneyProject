package ar.solPiqueras.disney.domain.genres;

import ar.solPiqueras.disney.data.entities.MovieEntity;
import lombok.*;

import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Genre {

    private long idGenre;

    private String genreImage;

    private String genreName;

    private Set<MovieEntity> movies;
}
