package helloo.core;

import helloo.core.member.Grade;
import helloo.core.member.Member;
import helloo.core.member.MemberService;
import helloo.core.member.MemberServiceImpl;
import helloo.core.order.Order;
import helloo.core.order.OrderService;
import helloo.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        // VIP 회원 생성
        Long memberId = 1l;
        Member member1 = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member1);


        // 일반 회원 생성
        memberId ++;
        Member member2 = new Member(memberId, "memberB", Grade.BASIC);
        memberService.join(member2);


        // 주문 생성
        Order order1 = orderService.createOrder(member1.getId(), "10연챠", 10000);
        System.out.println(order1.toString());
        System.out.println(order1.calculatePrice());

        Order order2 = orderService.createOrder(member2.getId(),"10연챠", 10000);
        System.out.println(order2.toString());
        System.out.println(order2.calculatePrice());
    }
}