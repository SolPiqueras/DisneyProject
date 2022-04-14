package ar.solPiqueras.disney.data.repositories;

import ar.solPiqueras.disney.data.entities.CommentaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaryRepository extends JpaRepository<CommentaryEntity, Long> {
    List<CommentaryEntity> findByNewsEntityId(Long newsId);
}
