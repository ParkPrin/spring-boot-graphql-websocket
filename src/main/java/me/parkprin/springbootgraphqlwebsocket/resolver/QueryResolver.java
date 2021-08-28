package me.parkprin.springbootgraphqlwebsocket.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;

import me.parkprin.springbootgraphqlwebsocket.model.StockDetail;
import org.springframework.stereotype.Component;

@Component
public class QueryResolver implements GraphQLQueryResolver {

	public StockDetail stockDetail(String symbol) {

		return StockDetail
				.builder()
				.symbol(symbol)
				.name("name")
				.marketCap(2000l)
				.build();
	}
}
