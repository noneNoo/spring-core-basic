package helloo.core;

import helloo.core.member.Grade;
import helloo.core.member.Member;
import helloo.core.member.MemberService;
import helloo.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();

        Member member = new Member(1L, "Anzu", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

    }
}
