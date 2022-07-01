package com.example.parameterized.methodsource;

import com.example.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MethodSourceTests {

    @DisplayName("상품 등록 테스트 (MethodSource)")
    @ParameterizedTest
    @MethodSource(ReqCreateItemProvider.PROVIDER_CLASSPATH + "reqCreateItemProvider")
    void create_item_test_with_method_source(Item reqCreateItem) {
        Item item = new Item();
        item.createItem(reqCreateItem);
        assertThat(item.getName()).isEqualTo(reqCreateItem.getName());
        assertThat(item.getQty()).isEqualTo(reqCreateItem.getQty());
        assertThat(item.getExpirationDate()).isEqualTo(reqCreateItem.getExpirationDate());
    }

    @DisplayName("상품 가격 테스트 (MethodSource)")
    @ParameterizedTest
    @MethodSource({
            ReqCreateItemProvider.PROVIDER_CLASSPATH + "reqCreateItemForTotalPrice01Provider",
            ReqCreateItemProvider.PROVIDER_CLASSPATH + "reqCreateItemForTotalPrice02Provider"
    })
    void get_price_test_with_method_source(Item reqCreateItem, Long result) {
        Item item = new Item();
        item.createItem(reqCreateItem);
        assertThat(item.getTotalPrice()).isEqualTo(result);
    }

}
