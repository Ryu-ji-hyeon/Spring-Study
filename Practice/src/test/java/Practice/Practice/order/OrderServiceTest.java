package Practice.Practice.order;

import Practice.Practice.member.Grade;
import Practice.Practice.member.Member;
import Practice.Practice.member.MemberService;
import Practice.Practice.member.MemberServiceimpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class OrderServiceTest {

    MemberService memberService =new MemberServiceimpl();
    OrderService orderService =new OrderServiceImpl();

    @Test
    void createOrder(){

        Long memberId = 1L;
        Member member =new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
