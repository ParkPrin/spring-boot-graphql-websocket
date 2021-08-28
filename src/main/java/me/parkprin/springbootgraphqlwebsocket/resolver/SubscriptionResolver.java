package me.parkprin.springbootgraphqlwebsocket.resolver;

import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import me.parkprin.springbootgraphqlwebsocket.model.StockPrice;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Slf4j
@Component
public class SubscriptionResolver implements GraphQLSubscriptionResolver {

	public Publisher<StockPrice> stockPrice(String symbol) {

		Random random = new Random();
		return Flux.interval(Duration.ofSeconds(1))
				.map(num -> {
					StockPrice stockPrice = StockPrice.builder()
							.symbol(symbol)
							.price(random.nextDouble())
							.timestamp(LocalDateTime.now())
							.build();
					log.info("storkPrice: {}", stockPrice);
					return stockPrice;
				});
	}
}
