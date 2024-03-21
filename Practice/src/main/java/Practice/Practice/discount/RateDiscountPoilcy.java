package Practice.Practice.discount;

import Practice.Practice.member.Grade;
import Practice.Practice.member.Member;

public class RateDiscountPoilcy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return price * discountPercent /100;
        }
        else {
            return  0;
        }
    }
}
