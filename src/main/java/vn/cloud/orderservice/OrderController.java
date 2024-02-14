package vn.cloud.orderservice;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping("/{id}")
    public Order findById(@PathVariable Long id) {
        return this.orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id: %d".formatted(id)));
    }

    @PostMapping
    public void placeOrder() {
        // save new Order to Database
        // send event to Kafka
        OrderPlacedEvent event = new OrderPlacedEvent(1L, 1L, ZonedDateTime.now(), BigDecimal.TEN);
        this.kafkaTemplate.send("public.order.orders.v1", event);
    }
}
