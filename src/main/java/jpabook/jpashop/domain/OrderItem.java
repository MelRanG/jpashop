package jpabook.jpashop.domain;

import jakarta.persistence.*;
import jpabook.jpashop.domain.item.Item;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem {
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    private int orderPrice; // 주문 가격
    private int count; //주문 수량


    //기본 생성자를 막는다. 롬복 AccessLevel.Protected와 같다.
//    protected OrderItem(){
//    }
    //할인으로 가격이 바뀔 수 있기 때문에 orderPrice를 또 받음
    //생성로직
    public static OrderItem createOrderItem(Item item, int orderPrice, int count){
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);

        item.removeStock(count);
        return orderItem;
    }

    //비즈니스로직
    public void cancel() {
        getItem().addStock(count);
    }

    //조회로직
    public int getTotalPrice(){
        return getOrderPrice() * getCount();
    }
}
