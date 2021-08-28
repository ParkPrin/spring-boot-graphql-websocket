package me.parkprin.springbootgraphqlwebsocket.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class StockPrice {
	private String symbol;
	private double price;
	private LocalDateTime timestamp;

	// getter and setters
}
