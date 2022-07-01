package com.example.parameterized.methodsource;

import com.example.Item;
import com.example.utils.Utils;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

@SuppressWarnings("unused")
public class ReqCreateItemProvider {

    public static final String PROVIDER_CLASSPATH = "com.example.parameterized.methodsource.ReqCreateItemProvider#";
    static Stream<Arguments> reqCreateItemProvider() {
        Item reqCreateItem = new Item("원피스", 2L, 1000L, Utils.parseDate("2022/05/20"));
        return Stream.of(Arguments.of(
                Named.of("ReqCreateItem", reqCreateItem)
        ));
    }

    static Stream<Arguments> reqCreateItemForTotalPrice01Provider() {
        Item reqCreateItem = new Item("원피스", 2L, 1000L, Utils.parseDate("2022/05/20"));
        return Stream.of(
                Arguments.of(
                        Named.of("ReqCreateItems", reqCreateItem),
                        2000L
                    )
        );
    }

    static Stream<Arguments> reqCreateItemForTotalPrice02Provider() {
        Item reqCreateItem = new Item("원피스", 1L, 1000L, Utils.parseDate("2022/05/20"));
        return Stream.of(
                Arguments.of(
                        Named.of("ReqCreateItems", reqCreateItem),
                        1000L
                    )
        );
    }

}
