package helloo.core;

import helloo.core.member.Grade;
import helloo.core.member.Member;
import helloo.core.member.MemberService;
import helloo.core.order.Order;
import helloo.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

        // AppConfig appConfig = new AppConfig();

        // MemberService memberService = appConfig.memberService();
        // OrderService orderService = appConfig.orderService();


        // 스프링 빈 등록
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        // VIP 회원 생성
        Long memberId = 1l;
        Member member1 = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member1);


        // 일반 회원 생성
        memberId ++;
        Member member2 = new Member(memberId, "memberB", Grade.BASIC);
        memberService.join(member2);


        // 주문 생성
        Order order1 = orderService.createOrder(member1.getId(), "candy", 10000);
        System.out.println(order1.toString());
        System.out.println(order1.calculatePrice());

        Order order2 = orderService.createOrder(member2.getId(),"candy", 10000);
        System.out.println(order2.toString());
        System.out.println(order2.calculatePrice());
    }
}
