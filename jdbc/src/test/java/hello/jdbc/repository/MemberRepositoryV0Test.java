package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryV0Test {

    MemberRepository0 repository = new MemberRepository0();
    @Test
    void crud() throws SQLException {
        //save
        Member member = new Member("memberV3", 10000);
        repository.save(member);
        //findById
        Member findMember = repository.findById(member.getMemberId());

        assertThat(findMember).isEqualTo(member);
    }
}