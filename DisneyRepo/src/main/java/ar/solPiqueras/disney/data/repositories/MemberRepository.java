package ar.solPiqueras.disney.data.repositories;

import ar.solPiqueras.disney.data.entities.MemberEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    Page<MemberEntity> findByDeleted(boolean deleted, Pageable pageable);
}
