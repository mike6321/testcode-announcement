package com.example.parameterized.basic;

import com.example.Item;
import com.example.context_caching.step03.ContextCachingTest;
import com.example.utils.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicTests extends ContextCachingTest {

    @Autowired
    private Item item;

    @DisplayName("상품 등록 테스트")
    @Test
    public void create_item_test() {
        // given
        Item reqCreateItem01 = new Item("원피스", 1L, 1000L, Utils.parseDate("2022/05/20"));
        // when
        item.createItem(reqCreateItem01);
        // then
        assertThat(item.getName()).isEqualTo(reqCreateItem01.getName());
        assertThat(item.getQty()).isEqualTo(reqCreateItem01.getQty());
        assertThat(item.getPrice()).isEqualTo(reqCreateItem01.getPrice());
        assertThat(item.getExpirationDate()).isEqualTo(reqCreateItem01.getExpirationDate());
        assertThat(item.getTotalPrice()).isEqualTo(reqCreateItem01.getQty() * reqCreateItem01.getPrice());

        // given
        Item reqCreateItem02 = new Item("원피스", 2L, 1000L, Utils.parseDate("2022/05/20"));
        // when
        item.createItem(reqCreateItem02);
        // then
        assertThat(item.getName()).isEqualTo(reqCreateItem02.getName());
        assertThat(item.getQty()).isEqualTo(reqCreateItem02.getQty());
        assertThat(item.getPrice()).isEqualTo(reqCreateItem02.getPrice());
        assertThat(item.getExpirationDate()).isEqualTo(reqCreateItem02.getExpirationDate());
        assertThat(item.getTotalPrice()).isEqualTo(reqCreateItem02.getQty() * reqCreateItem02.getPrice());

        // given
        Item reqCreateItem03 = new Item("원피스", 3L, 1000L, Utils.parseDate("2022/05/20"));
        // when
        item.createItem(reqCreateItem03);
        // then
        assertThat(item.getName()).isEqualTo(reqCreateItem03.getName());
        assertThat(item.getQty()).isEqualTo(reqCreateItem03.getQty());
        assertThat(item.getPrice()).isEqualTo(reqCreateItem03.getPrice());
        assertThat(item.getExpirationDate()).isEqualTo(reqCreateItem03.getExpirationDate());
        assertThat(item.getTotalPrice()).isEqualTo(reqCreateItem03.getQty() * reqCreateItem03.getPrice());
    }

    @DisplayName("상품 등록 테스트 with loop")
    @Test
    public void create_item_test_with_loop() {
        // given
        Item reqCreateItem01 = new Item("원피스", 1L, 1000L, Utils.parseDate("2022/05/20"));
        Item reqCreateItem02 = new Item("원피스", 2L, 1000L, Utils.parseDate("2022/05/20"));
        List<Item> reqCreateItems = List.of(reqCreateItem01, reqCreateItem02);
        // when
        AtomicLong totalPrice = new AtomicLong(1000L);
        // then
        IntStream.range(0, reqCreateItems.size())
                .forEach(index -> {
                    Item reqCreateItem = reqCreateItems.get(index);
                    item.createItem(reqCreateItem);
                    assertThat(item.getTotalPrice()).isEqualTo(totalPrice.get());
                    totalPrice.getAndAdd(1000L);
                });
    }

}
