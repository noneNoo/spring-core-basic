package helloo.core;

import helloo.core.discount.DiscountPolicy;
import helloo.core.discount.FixDiscountPolicy;
import helloo.core.member.MemberRepository;
import helloo.core.member.MemberService;
import helloo.core.member.MemberServiceImpl;
import helloo.core.member.MemoryMemberRepository;
import helloo.core.order.OrderService;
import helloo.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
