package helloo.core;

import helloo.core.member.Grade;
import helloo.core.member.Member;
import helloo.core.member.MemberService;
import helloo.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        // MemberService memberService = new MemberServiceImpl();

        // 의존 관계 주입
        // AppConfig appConfig = new AppConfig();
        // MemberService memberService = appConfig.memberService();

        // 스프링 빈들을 컨테이너에 전부 집어넣어 관리
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


        Member member = new Member(1L, "Anzu", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

    }
}
