package com.example.parameterized.csv;

import com.example.Item;
import com.example.utils.Utils;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

public class ReqCreateItemAggregator implements ArgumentsAggregator {

    @Override
    public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context) throws ArgumentsAggregationException {
        return Item
                .builder()
                .name(accessor.getString(0))
                .qty(accessor.getLong(1))
                .price(accessor.getLong(2))
                .expirationDate(Utils.parseDate(accessor.getString(3)))
                .build();
    }

}
