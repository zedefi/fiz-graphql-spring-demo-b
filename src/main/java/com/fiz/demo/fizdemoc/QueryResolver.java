package com.fiz.demo.fizdemoc;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    public StockDetail stockDetail(String symbol) {

        return new StockDetail(symbol, "name", 2000l);
    }
}