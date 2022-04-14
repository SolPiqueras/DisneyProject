package ar.solPiqueras.disney.domain.characters;

public interface CharacterGateway {

    Chara create(Chara chara);

    Chara update(Chara chara, long id);

    boolean existsById(long id);

    void delete(long id);

    Chara findById(Long id);
}
