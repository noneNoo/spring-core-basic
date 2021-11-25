package helloo.core;

import helloo.core.discount.FixDiscountPolicy;
import helloo.core.member.MemberService;
import helloo.core.member.MemberServiceImpl;
import helloo.core.member.MemoryMemberRepository;
import helloo.core.order.OrderService;
import helloo.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
