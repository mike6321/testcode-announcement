package com.example.parameterized.csv;

import com.example.Item;
import com.example.context_caching.step03.ContextCachingTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class CsvTests extends ContextCachingTest {

    @Autowired
    private Item item;

    @DisplayName("단순 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:false"}, delimiter = ':')
    void test(int element, boolean expected) {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        assertThat(numbers.contains(element)).isEqualTo(expected);
    }

    @DisplayName("상품 등록 테스트 (CsvSource)")
    @ParameterizedTest
    @CsvSource(textBlock = "원피스, 2, 2000, 2022/05/20")
    void create_item_test_with_csv_source(@AggregateWith(ReqCreateItemAggregator.class)
                        Item reqCreateItem) {
        item.createItem(reqCreateItem);
        assertThat(item.getName()).isEqualTo(reqCreateItem.getName());
        assertThat(item.getQty()).isEqualTo(reqCreateItem.getQty());
        assertThat(item.getExpirationDate()).isEqualTo(reqCreateItem.getExpirationDate());
    }

}
