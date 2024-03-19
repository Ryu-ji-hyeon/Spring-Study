package Practice.Practice.order;

import Practice.Practice.discount.DiscountPolicy;
import Practice.Practice.discount.FixDiscountPolicy;
import Practice.Practice.member.Member;
import Practice.Practice.member.MemberRepository;
import Practice.Practice.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository =new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);

    }
}
