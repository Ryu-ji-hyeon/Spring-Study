package Study.Spring.Study.repository;

import Study.Spring.Study.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member); //회원 저장
    Optional<Member> findById(Long id); //id로 회원 찾기
    Optional<Member> findByName(String name); //id로 이름 찾기
    List<Member> findAll();

}

// Optional<Member> -> java 8에 저장된 기능 id나 name이 null일경우 찾아줌