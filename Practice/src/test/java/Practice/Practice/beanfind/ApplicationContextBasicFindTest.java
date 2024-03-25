package Practice.Practice.beanfind;

import Practice.Practice.AppConfig;
import Practice.Practice.member.MemberService;
import Practice.Practice.member.MemberServiceimpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.lang.annotation.Annotation;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac =new AnnotationConfigApplicationContext(AppConfig  .class);

    @Test
    @DisplayName("빈 이름으로 조회하기")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass());
        assertThat(memberService).isInstanceOf(MemberServiceimpl.class);
    }

    @Test
    @DisplayName("이름없이 타입으로만 조회하기")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceimpl.class);

    }

    @Test
    @DisplayName("구체 타입으로 조회하기")
    void findBeanByName2(){
        MemberService memberService = ac.getBean("memberService", MemberServiceimpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceimpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회하기 X")

    void findBeanByNameX(){

        // test 실패
        //MemberService memberService = ac.getBean("XXXX", MemberService.class);

        // test 성공
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("XXXX", MemberService.class));
    }

}
