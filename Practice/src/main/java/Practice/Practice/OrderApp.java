package Practice.Practice;

import Practice.Practice.member.Grade;
import Practice.Practice.member.Member;
import Practice.Practice.member.MemberService;
import Practice.Practice.member.MemberServiceimpl;
import Practice.Practice.order.Order;
import Practice.Practice.order.OrderService;
import Practice.Practice.order.OrderServiceImpl;

public class OrderApp {
    
    public static void main(String[] args) {

        AppConfig appConfig =new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member =new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",10000);
        System.out.println("order = " + order);
    }
}
