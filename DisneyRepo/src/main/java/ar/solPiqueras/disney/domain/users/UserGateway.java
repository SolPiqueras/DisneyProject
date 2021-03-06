package ar.solPiqueras.disney.domain.users;

import java.util.List;

public interface UserGateway {

    List<User> findAll();

    List<User> findByDeleted(boolean isDeleted);

    User findByEmail(String email);

    User findById(Long id);

    User create(User user);

    void deleteById(Long id);

    boolean existsByEmail(String email);

    User update(Long id, User user);
}
