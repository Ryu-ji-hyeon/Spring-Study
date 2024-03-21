package Practice.Practice;

import Practice.Practice.discount.DiscountPolicy;
import Practice.Practice.discount.FixDiscountPolicy;
import Practice.Practice.discount.RateDiscountPoilcy;
import Practice.Practice.member.MemberRepository;
import Practice.Practice.member.MemberService;
import Practice.Practice.member.MemberServiceimpl;
import Practice.Practice.member.MemoryMemberRepository;
import Practice.Practice.order.OrderService;
import Practice.Practice.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        // 생성자 주입
        return new MemberServiceimpl(memberRepository());
    }

    private MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(discountPolicy(), memberRepository());
    }

    public DiscountPolicy discountPolicy(){
        return new RateDiscountPoilcy();
    }

}
