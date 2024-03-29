package helloo.core.order;

import helloo.core.discount.DiscountPolicy;
import helloo.core.member.Member;
import helloo.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    // 저장소 끼워넣기
    private final MemberRepository memberRepository;

    // 할인정책 끼워넣기
    private final DiscountPolicy discountPolicy;


    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 멤버 찾기
        Member member = memberRepository.findById(memberId);

        // 할인 정책에 회원정보를 넘김
        int discountPrice = discountPolicy.discount(member, itemPrice);

        // 최종 주문 생성 후 반환
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
