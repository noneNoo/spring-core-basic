package helloo.core.discount;

import helloo.core.member.Member;

public interface DiscountPolicy {
    /**
     * @return 할인 금액
     */
    int discount(Member member, int price);
}
