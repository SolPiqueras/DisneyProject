package ar.solPiqueras.disney.domain.movies;

import ar.solPiqueras.disney.domain.genres.Genre;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {

    private long idMovie;

    private String movieImage;

    private String title;

    private Date releaseDate;

    private int rating;

    private Genre genre;

    private Set<Character> characters;

}
