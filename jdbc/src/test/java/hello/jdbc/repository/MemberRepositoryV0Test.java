package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryV0Test {

    //save
    MemberRepository0 repository = new MemberRepository0();
    @Test
    void crud() throws SQLException {
        //save
        Member member = new Member("memberV91", 10000);
        repository.save(member);
        //findById
        Member findMember = repository.findById(member.getMemberId());

        assertThat(findMember).isEqualTo(member);

        //update money : 10000 -> 20000
        repository.update(member.getMemberId(), 20000);
        Member updatedMember = repository.findById(member.getMemberId());
        assertThat(updatedMember.getMoney()).isEqualTo(20000);

        //delete
        repository.delete(member.getMemberId());
        assertThatThrownBy(() -> repository.findById(member.getMemberId()))
                .isInstanceOf(NoSuchElementException.class);

    }
}