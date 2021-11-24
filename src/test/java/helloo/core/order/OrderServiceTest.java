package helloo.core.order;

import helloo.core.member.Grade;
import helloo.core.member.Member;
import helloo.core.member.MemberService;
import helloo.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "안즈", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(),"왕사탕",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
