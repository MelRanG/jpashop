package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Member member){
        em.persist(member);
        //member가 아니라 id를 리턴한 이유는 저장한 뒤 member를 리턴했을 때 발생할 수 있는 사이드 이펙트를 최대한 줄이는 목적임.
        //id는 필요하기 때문에 리턴
        return member.getId();
    }

    public Member find(Long id){
        return em.find(Member.class, id);
    }
}
