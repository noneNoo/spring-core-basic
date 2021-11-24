package helloo.core.discount;

import helloo.core.member.Grade;
import helloo.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    // 고정 할인 금액
    private int discountFixAmount = 1000;

    // 할인액 리턴
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP) {
            return discountFixAmount;
        }
        return 0;
    }
}
