package ar.solPiqueras.disney.domain.members;

import java.util.List;

public interface MemberGateway {

    Member create(Member member);
    List<Member> findAll();
    Member update(long id, Member member);
    void delete(long id);
    List<Member> listByPage(int page, int pageSize);
}
