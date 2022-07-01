package com.example;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class Item {

    private String name;
    private Long qty;
    private Long price;
    private Long totalPrice;
    private LocalDateTime expirationDate;

    public Item(String name, Long qty, Long price, LocalDateTime expirationDate) {
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.expirationDate = expirationDate;
    }

    public void createItem(Item reqCreateItem) {
        this.name = reqCreateItem.getName();
        this.qty = reqCreateItem.getQty();
        this.price = reqCreateItem.getPrice();
        this.expirationDate = reqCreateItem.getExpirationDate();
        this.totalPrice = reqCreateItem.getQty() * reqCreateItem.getPrice();
    }

}
