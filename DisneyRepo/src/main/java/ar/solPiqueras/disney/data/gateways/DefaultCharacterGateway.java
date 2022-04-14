package ar.solPiqueras.disney.data.gateways;

import ar.solPiqueras.disney.data.entities.CharacterEntity;
import ar.solPiqueras.disney.data.repositories.CharacterRepository;
import ar.solPiqueras.disney.domain.characters.Chara;
import ar.solPiqueras.disney.domain.characters.CharacterGateway;
import ar.solPiqueras.disney.web.exceptions.ResourceNotFoundException;

public class DefaultCharacterGateway implements CharacterGateway {
    private final CharacterRepository characterRepository;

    public DefaultCharacterGateway(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public Chara create(Chara chara) {
        CharacterEntity characterEntity = toEntity(chara);
        return toModel(characterRepository.save(characterEntity));
    }

    @Override
    public Chara update(Chara chara, long id) {
        CharacterEntity characterEntity = characterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found"));
        return toModel(characterRepository.save(characterEntity));
    }

    @Override
    public boolean existsById(long id) {
        return characterRepository.existsById(id);
    }

    @Override
    public void delete(long id) {
        characterRepository.deleteById(id);
    }

    @Override
    public Chara findById(Long id) {
        CharacterEntity characterEntity = characterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found"));
        return toModel(characterEntity);
    }

    private CharacterEntity toEntity(Chara chara){
        return CharacterEntity.builder()
                .idCharacter(chara.getIdCharacter())
                .characterName(chara.getCharacterName())
                .characterImage(chara.getCharacterImage())
                .age(chara.getAge())
                .weight(chara.getWeight())
                .story(chara.getStory())
                .build();
    }

    private Chara toModel(CharacterEntity entity){
        return Chara.builder()
                .idCharacter(entity.getIdCharacter())
                .characterName(entity.getCharacterName())
                .characterImage(entity.getCharacterImage())
                .age(entity.getAge())
                .weight(entity.getWeight())
                .story(entity.getStory())
                .build();
    }
}
