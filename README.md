# spring-boot-graphql-websocket

## Subscription
- graphql의 실시간 통신 규약
- 실시간 처리를 위해서는 Reactive Streams 기능이 필요함

### 설정정보

#### build.gradle
```
Subscription을 위한 의존성 추가
implementation 'io.projectreactor:reactor-core' //  Reactive Streams 처리를 위한 의존성
```

#### endpoint 설정

```
URL: localhost:8080/graphql

Method: POST

QUERY:
subscription {
  stockPrice(symbol: "GOOG") {
    symbol
    price
    timestamp
  }
}
```

#### 실행코드
```
@Component
public class SubscriptionResolver implements GraphQLSubscriptionResolver {

	public Publisher<StockPrice> stockPrice(String symbol) {

		Random random = new Random();
		// Duration.ofSeconds(1) 매 1초마다 반응
		return Flux.interval(Duration.ofSeconds(1))
				.map(num -> {
					StockPrice stockPrice = StockPrice.builder()
							.symbol(symbol)
							.price(random.nextDouble())
							.timestamp(LocalDateTime.now())
							.build();
					log.info("storkPrice: {}", stockPrice);
					// return null; 이면 실시간 통신 종료
					return stockPrice;
				});
	}
}

```