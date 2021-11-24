package helloo.core.order;

public interface OrderService {
    /**
     *
     * @param memberId
     * @param itemName
     * @param itemPrice
     * @return 최종결과 Order 반환     */
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
