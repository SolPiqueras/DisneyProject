package ar.solPiqueras.disney.domain.characters;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Service
public class CharacterService {

    private CharacterGateway gateway;

    CharacterService(CharacterGateway gateway) {this.gateway=gateway;}

    Chara create(Chara chara){
        return gateway.create(chara);
    }

    Chara update(Chara chara, long id){
        return gateway.update(chara, id);
    }

    boolean existsById(long id) {
        return gateway.existsById(id);
    }

    void delete(long id) {
        gateway.delete(id);
    }

    public Chara findById(Long id) {
        return gateway.findById(id);
    }

}
