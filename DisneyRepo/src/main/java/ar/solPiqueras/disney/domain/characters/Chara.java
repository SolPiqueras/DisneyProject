package ar.solPiqueras.disney.domain.characters;

import ar.solPiqueras.disney.data.entities.MovieEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chara {

    private long idCharacter;

    private String characterImage;

    private String characterName;

    private Integer age;

    private Double weight;

    private String story;

    private Set<MovieEntity> movies;

}
