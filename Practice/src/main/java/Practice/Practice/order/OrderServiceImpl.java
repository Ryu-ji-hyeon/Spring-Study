package Practice.Practice.order;

import Practice.Practice.discount.DiscountPolicy;
import Practice.Practice.member.Member;
import Practice.Practice.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    //DIP위반
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    //할인 정책이 바뀌어 클래스 교체, OCP위반
    //private final DiscountPolicy discountPolicy = new RateDiscountPoilcy();

    // DIP는 지킴 but NullPointerException
    // private final DiscountPolicy discountPolicy;

    private final DiscountPolicy discountPolicy;
    private final MemberRepository memberRepository ;

    //lombok 사용시 생성자 따로 만들 필요 없음
//    @Autowired
//    public OrderServiceImpl(DiscountPolicy discountPolicy, MemberRepository memberRepository) {
//        this.discountPolicy = discountPolicy;
//        this.memberRepository = memberRepository;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);

    }
}
