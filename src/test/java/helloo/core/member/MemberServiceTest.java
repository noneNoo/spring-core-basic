package helloo.core.member;

import helloo.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {

        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given ~가 주어졌을 때
        Member member = new Member(1L,"Anzu", Grade.VIP);
        // when ~ 를 하면
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then ~ 가 되어야 한다
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
