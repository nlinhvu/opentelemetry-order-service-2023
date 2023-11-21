package vn.cloud.orderservice;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public record Order(Long id, Long customerId, ZonedDateTime orderDate, BigDecimal totalAmount) {
}
