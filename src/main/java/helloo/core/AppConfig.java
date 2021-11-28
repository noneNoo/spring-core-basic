package helloo.core;

import helloo.core.discount.DiscountPolicy;
import helloo.core.discount.FixDiscountPolicy;
import helloo.core.member.MemberRepository;
import helloo.core.member.MemberService;
import helloo.core.member.MemberServiceImpl;
import helloo.core.member.MemoryMemberRepository;
import helloo.core.order.OrderService;
import helloo.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
