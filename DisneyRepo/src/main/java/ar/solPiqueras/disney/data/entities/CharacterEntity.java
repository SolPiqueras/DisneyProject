package ar.solPiqueras.disney.data.entities;

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
@Table(name = "characters")
public class CharacterEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idCharacter;

    @NotEmpty
    @Column(nullable = false)
    private String characterImage;

    @NotEmpty
    @Column(nullable = false)
    private String characterName;

    @Column
    private Integer age;

    @Column
    private Double weight;

    @NotEmpty
    @Column(nullable = false)
    private String story;

    @ManyToMany(mappedBy = "characters")
    private Set<MovieEntity> movies;

    //To String
    @Override
    public String toString() {
        return characterName + " - " + characterImage;
    }
}
