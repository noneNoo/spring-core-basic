package helloo.core.discount;

import helloo.core.member.Grade;
import helloo.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 회원 10% 할인이 적용되어야 한다.")
    void vip_o() {
        // given
        Member member = new Member(1L,"안쥬쨩", Grade.VIP);

        // when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(1000);
    }
    
    @Test
    @DisplayName("VIP가 아니면 할인 혜택이 없어야 한다.")
    void vip_x() {
        // given
        Member member = new Member(2L,"소이",Grade.BASIC);

        // when
        int discount =  discountPolicy.discount(member, 10000);

        // then
        assertThat(discount).isEqualTo(0);
    }

}
