package Practice.Practice.discount;

import Practice.Practice.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
